Aqui vai um resumo do que cobrimos de Haskell durante a reunião. Não se
preocupe se não conseguir entender tudo ou se o conteúdo estiver bem
fixado: mandem perguntas, por aqui mesmo, pelo Telegram, pessoalmente ou
nas próximas reuniões. Prometo tentar explicar até que esteja
compreensível.

Para quem não estava na reunião, estamos utilizando o compilador de
Haskell da University of Glasgow, o GHC. Por enquanto nos limitaremos ao
modo interativo dele, que pode ser invocado através do comando `ghci`.

Para instalar o GHC:

  sudo pacman -S ghc   # para uma distro baseada no Arch
  sudo apt install ghc # para uma distro baseada no Debian
  sudo yum install ghc # para uma distro da RedHat

O que vimos:

- Existem tipos básicos em Haskell.
- Aplicação de função é separação de tokens. (normalmente espaços)
- Como criar funções com um argumento.
- Como criar funções com n argumentos. (não variádicas!)
- O que são listas e como percorrer uma.
- map, filter, foldl.

Recapitulando:

# Tipos básicos [see]

Essa lista (heh) não é compreensiva, mas temos tipos comuns como Int,
Double, Float, Char, e Bool. Mais para a frente veremos os tipos
Integer, Rational, e criaremos tipos algébricos.

Note que os nomes de tipos começam com letra maiúscula. As únicas
exceções seriam as listas e tuplas, mas falamos delas depois.

Para perguntar ao GHCi o tipo de uma expressão, basta usar o comando:

  :t expressão

E.g.

  Prelude> a = 10 :: Int
  Prelude> a
  10
  Prelude> :t a
  a :: Int

O símbolo '::' pode ser lido como "é do tipo".

# Aplicando funções [see]

A aplicação de funções é dada pela simples separação de tokens, o que
para todos os efeitos aqui se dá por meio de espaços. Vejamos exemplos
de funções e como aplicá-las.

  head :: [a] -> a   -- head é função de "lista de a" para um "a"
  tail :: [a] -> [a] -- tail é função de "lista de a" para "lista de a"

As funções acima recebem uma lista qualquer e produzem, respectivamente,
o primeiro elemento da lista e a cauda (lista sem o primeiro elemento)
da lista.

Aplicando-as:

  Prelude> head [1,2,3]
  1
  Prelude> tail [1,2,3]
  [2,3]
  Prelude> length [1,2,3]
  3
  Prelude> length "abcde"
  5
  Prelude> null ""
  True
  Prelude> null [3, 1, 5]
  False
  Prelude> pegueTres = take 3
  Prelude> pegueTres [1,2,3,4,5]
  [1,2,3]

Tente responder: quais os tipos das funções `length`, `null`, e
`pegueTres`?  Qual o tipo da função `take`?
Resposta: i) `length :: Int` , `null :: Bool` e `pegueTres :: lista`;
          ii) `take :: Int`


Resposta para as duas primeiras:

  length :: [a] -> Int (length é do tipo lista que retorna um Int?)
  null :: [a] -> Bool (null é do tipo lista que retorna um Bool?)

# Criando nossas próprias funções [see]

Implementaremos as funções fatorial e fibonacci, que precisam somente de
um argumento e envolvem repetição. Haskell não possui estruturas de
repetição como `for` e `while`, então usamos recursão para resolver os
problemas. Aqui é como criamos as nossas funções:

  fatorial 0 = 1
  fatorial n = n * fatorial (n - 1)

Obs.: para dar múltiplas linhas ao GHCi, fazemos:

  Prelude> :{
  Prelude| fatorial 0 = 1
  Prelude| fatorial n = n * fatorial (n - 1)
  Prelude| :}
  Prelude> fatorial 10
  3628800

Veja que para dizer o que uma função deve retornar para uma entrada,
basta escrever como você faria no papel: f(x) = 2x traduz exatamente
para:

  f x = 2 * x

E assim criamos a função fibonacci:

  fibonacci 0 = 1
  fibonacci 1 = 1
  fibonacci n = fibonacci (n - 1) + fibonacci (n - 2)

Obs.: aplicação de função tem precedência MÁXIMA. Por isso `f x + 3` é
`(f x) + 3`. O que é uma procedência MÁXIMA?

Problema 1: faça a função f da conjectura de Collatz,

  f(x) =  x / 2   se x é par
  f(x) = 3x - 1   se x é ímpar


Solução: [Feito]

  f x = if (mod x 2 == 0)
    then (div x 2)
    else (3 * x - 1)
Resposta:
>> collatz 2
1
>> collatz 3
8

Obs.: os parênteses são desnecessários, estão aí para melhorar a
legibilidade para quem está começando.

De outra maneira, introduzindo outra sintaxe (guards):

  f x | mod x 2 == 0 = div x 2
      | otherwise = 3 * x - 1

Problema 2: faça a função que conta quantos passos nos levam até 1 na
sequência de Collatz.

Dica: tente fazer a função acima de forma recursiva na sua linguagem de
escolha.

----- Fazer este exercícios -----

Problema 3: crie uma função que diz se um número é primo ou não, com o
teste de primalidade que você quiser.
Resposta:

Solução:

  éPrimo n = númeroDeDivisores n < 3
  númeroDeDivisores n = length (filter divideN [1..n])
    where divideN x = mod n x == 0

Claro, não é a melhor maneira de se fazer isso e eu deveria ao menos
usar raíz quadrada, mas Haskell é muito fortemente tipada, e type
casting meio que não existe. Meio que.

Problema 4: crie uma função que retorna o n-ésimo número primo.
Resposta:

# Listas

Listas em Haskell podem ser trabalhadas com o construtor (:). Exemplos
de funções que operam sobre listas:

  map f [] = []
  map f (x:xs) = f x : map f xs

  filter f [] = []
  filter f (x:xs) =
    if   f x   then   x : filter f xs
               else       filter f xs

ou

  filter _ [] = []
  filter f (x:xs) | f x = x : filter f xs
                  | otherwise = filter f xs

  foldl f ac [] = ac
  foldl f ac (x:xs) = foldl f (f ac x) xs

  foldr f ac [] = []
  foldr f ac (x:xs) = f x (foldr f ac xs)

  drop _ [] = []
  drop 0 l = l
  drop n (x:xs) = drop (n - 1) xs

  take _ [] = []
  take 0 _ = []
  take n (x:xs) = x : take (n - 1) xs

Uma função que soma todos os elementos de uma lista, assumindo que esta
seja de números:

  sum [] = 0
  sum (x:xs) = x + sum xs

Uma que multiplica todos os números de uma lista:

  product [] = 1
  product (x:xs) = x * product xs

Uma que mantém somente os segundos elementos de uma lista qualquer:

  segundosElem [] = []
  segundosElem (x:[]) = []
  segundosElem (x:y:xs) = y : segundosElem xs

ou

  segundosElem l | length l < 2 = []
                 | otherwise = (l !! 1) : segundosElem (drop 2 l)

Problema 1: implemente a função reverse, que inverte uma lista.

:{
  listaVazia [] = True
  listaVazia _ = False 
  
  colocaNoFinal e [] = [e]
  colocaNoFinal e (x:xs) = x : colocaNoFinal e xs

  reverse [] = []
  reverse (x:xs) = colocaNoFinal x (reverse xs)
:}
 
 :{
 data Ternario = Amarelo
               | Roxo 
               | Vermelho

f :: Ternario -> String
f Amarelo = "Amarelo"
f Roxo = "Roxo"
f Vermelho = "Vermelho"
:}

Problema 2: implemente a função que diz se uma lista é vazia.
Problema 3: implemente a função que concatena duas listas.

--
Wilson M. S. Moncayo
https://spoonm.org/
Área de anexos
	
	
	

