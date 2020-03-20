section .text
    global _start

;; ----------------------------------------------- EM PYTHON ------------------------------------------------

;; def soma_digitos(n):
;;    m = n
;;    s = 0
;;
;;    while m > 0:
;;        s += m % 10
;;        m /= 10
;;
;;    return s

;; ---------------------------------------------- EM ASSEMBLY -----------------------------------------------

;; Recebe um inteiro positivo n em rax. Retorna a soma dos digitos de n na base decimal em rax. A subrotina
;; deve preservar o valor de todos os registros com execao de rax.
soma_digitos:
    mov  rax, 1               ; return 1
    ret

;; =================================== NAO MODIFIQUE AS LINHAS ABAIXO!!! =================================== 

_start:
    mov  rsi, intro           ; Referencia para a string a ser impressa
    mov  eax, 1               ; sys_write
    mov  edi, 1               ; stdout
    mov  edx, intro_len       ; Comprimento da string a ser impressa
    syscall

    mov  rax, 123             ; rax = 123
    call soma_digitos         ; rax = soma_digitos(rax)

    cmp  rax, 6               ; rax == 6 ?
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
    intro: db 0xa, "def soma_digitos(n):", 0xa, "    m = n", 0xa, "    s = 0", 0xa, 0xa, "    while m > 0:", 0xa, "        s += m % 10", 0xa, "        m /= 10", 0xa, 0xa, "    return s", 0xa, 0xa, "soma_digitos(132) == 6 ", 0x23
    intro_len:       equ $ - intro

    acertou_msg:     db " => True", 0xa, "[Acertou!]", 0xa, 0xa
    acertou_msg_len: equ $ - acertou_msg

    errou_msg:       db " => False", 0xa, "[Errou ", 0x3b, '-', 0x3b, ']', 0xa, 0xa
    errou_msg_len:   equ $ - errou_msg