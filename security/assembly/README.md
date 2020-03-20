# Workshop Assembly
Documentação do Workshop de Intrudução a Assembly realizado pelo grupo IMEsec do IME USP em Agosto de 2019. O documento da apresentação está disponível [aqui](https://docs.google.com/presentation/d/1-zcn6A0kJxU-qTwFxInUsydYpGX1WffoISEtz7nr6JU/edit?usp=sharing) para os alunos da USP.

## O quê?
* Como um processador executa um programa?
* O quê é Assembly?
    * Tradução direta do código de máquina
    * Exemplo de tradução de opcode
    * Cada família de processadores tem sua própria liguagem assembly, aqui aprenderemos assembly x86 64bits

## Pra que?
* Velocidade
* Jogos antigos (por quê não?)
* Engenharia reversa
    * Exemplo de pequeno "programa" em C

## Como?
### Registradores
* O que são?
* Variáveis vs. Registradores
    * Armazenamento
    * Quantidade
    * Contexto de existência
* Tamanho dos registradores

### Stack
* Uso do Stack para compensar falta de registros

### Instruções
* Operações básicas do processador
* Operandos
    * Registradores
    * Imediatos: valores númericos
* `mov`
* `add`
* `sub`
* `mul`
* `div`
* `push`
* `pop`

### Estruturas de Controle
* `jmp`
* `cmp`
* `je`, `jne`, `ja`, `jae`, `jb`, `jbe`
* Labels
* Traduzir `if-else`
* Traduzir `while`
* Traduzir `for` primitivo (implementação igual à do C)
* `loop`

### Modularização
* Emular funções
* `call`, `ret`

### Montagem
* O quê é um assembler?
* [NASM](https://nasm.us/)

### Debugem
* GDB
    * Como setar break points
    * Como executar o programa dentro do GDB
    * Como inspecionar o valor dos registros durante a execução
    * Como inspecionar o valor do stack durante a execução

## Referências
* Carter, P. A. _[PC Assembly Language](https://pacman128.github.io/pcasm/)_, 2006.
* Wikibooks. _[x86 Assembly](https://en.wikibooks.org/wiki/X86_Assembly)_.
* Damaye, S. _[X86-assembly/Instructions](https://www.aldeid.com/wiki/X86-assembly/Instructions)_, 2016.
