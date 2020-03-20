section .text
    global _start

;; ----------------------------------------------- EM PYTHON ------------------------------------------------

;; def f(a, b, c):
;;     return ((a + c) // b) * (a % b) 

;; ---------------------------------------------- EM ASSEMBLY -----------------------------------------------

;; Recebe tres inteiros positivos a, b e c em rax, rbx e rcx respectivamente. Retorna ((a + c) / b) * (a % b)
;; em rax. A subrotina deve preservar o valor de todos os registros com execao de rax.
f:
    mov  rax, 0               ; return 0
    ret

;; =================================== NAO MODIFIQUE AS LINHAS ABAIXO!!! ==================================== 

_start:
    mov  rsi, intro           ; Referencia para a string a ser impressa
    mov  eax, 1               ; sys_write
    mov  edi, 1               ; stdout
    mov  edx, intro_len       ; Comprimento da string a ser impressa
    syscall

    mov  rax, 2               ; rax = 2
    mov  rbx, 3               ; rbx = 3
    mov  rcx, 5               ; rcx = 5
    call f                    ; rax = f(rax, rbx, rcx)

    cmp  rax, 4               ; rax == 4 ?
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
    intro: db 0xa, "def f(a, b, c):", 0xa, "    return ((a + c) // b) * (a % b)", 0xa, 0xa, "f(2, 3, 5) == 4", 0x23
    intro_len:       equ $ - intro

    acertou_msg:     db " => True", 0xa, "[Acertou!]", 0xa, 0xa
    acertou_msg_len: equ $ - acertou_msg

    errou_msg:       db " => False", 0xa, "[Errou ", 0x3b, '-', 0x3b, ']', 0xa, 0xa
    errou_msg_len:   equ $ - errou_msg
