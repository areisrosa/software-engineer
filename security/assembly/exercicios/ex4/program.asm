section .text
    global _start

;; ----------------------------------------------- EM PYTHON ------------------------------------------------

;; def fibonacci(n):
;;    if n < 2:
;;        return n
;;    else:
;;        return fibonacci(n - 2) + fibonacci(n - 1)

;; ------------------------------------------ EM HASKELL (PQ SIM) -------------------------------------------

;; fib :: Natural -> Natural
;; fib n
;;     | n < 2 = n 
;;     | otherwise = fib(n - 1) + fib(n - 2)

;; ---------------------------------------------- EM ASSEMBLY -----------------------------------------------

;; Recebe um inteiro positivo n em rax. Retorna o enesimo termo da sequencia de fibonacci em rax. A subrotina
;; deve preservar o valor de todos os registros com execao de rax.
fibonacci:
    mov  rax, 0               ; return 0
    ret

;; =================================== NAO MODIFIQUE AS LINHAS ABAIXO!!! =================================== 

_start:
    mov  rsi, intro           ; Referencia para a string a ser impressa
    mov  eax, 1               ; sys_write
    mov  edi, 1               ; stdout
    mov  edx, intro_len       ; Comprimento da string a ser impressa
    syscall

    mov  rax, 32              ; rax = 2^5
    call fibonacci            ; rax = fibonacci(rax)

    cmp  rax, 2178309         ; rax == 2178309 ?
    jz   short acertou
    jmp  short errou

acertou:
    mov  rsi, acertou_msg     ; Referencia para a string a ser impressa
    mov  eax, 1               ; sys_write
    mov  edi, 1               ; stdout
    mov  edx, acertou_msg_len ; Comprimento da string a ser impressa
    syscall

    mov  edi, 0               ; Configura o codigo de execucao do programa para 0
    jmp  short quit

errou:
    mov  rsi, errou_msg       ; Referencia para a string a ser impressa
    mov  eax, 1               ; sys_write
    mov  edi, 1               ; stdout
    mov  edx, errou_msg_len   ; Comprimento da string a ser impressa
    syscall

    mov  edi, 1               ; Configura o codigo de execucao do programa para 1
    jmp  short quit

;; Fecha o programa. Sim, em assembly e voce que tem que fechar o programa
quit:
    mov  eax, 60              ; sys_exit
    syscall

section .data
    intro: db 0xa, "def fibonacci(n):", 0xa, "    if n < 2:", 0xa, "        return n", 0xa, "    else:", 0xa, "        return fibonacci(n - 2) + fibonacci(n - 1)", 0xa, 0xa, "fibonacci(2**5) == 2178309 ", 0x23
    intro_len:       equ $ - intro

    acertou_msg:     db " => True", 0xa, "[Acertou!]", 0xa, 0xa
    acertou_msg_len: equ $ - acertou_msg

    errou_msg:       db " => False", 0xa, "[Errou ", 0x3b, '-', 0x3b, ']', 0xa, 0xa
    errou_msg_len:   equ $ - errou_msg