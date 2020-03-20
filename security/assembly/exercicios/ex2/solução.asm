section .text
    global _start

;; ----------------------------------------------- EM PYTHON ------------------------------------------------

;; def fatorial(n):
;;    if n == 0:
;;        return 1
;;    else:
;;        return n * fatorial(n - 1)

;; ---------------------------------------------- EM ASSEMBLY -----------------------------------------------

;; Recebe um inteiro positivo n em rax. Retorna n! em rax, usando um algoritmo recursivo. A subrotina deve
;; preservar o valor de todos os registros com execao de rax.
fatorial:
    cmp  rax, 0               ; rax == 0 ?
    je   if                   ; if rax == 0 then ...
    jmp  else                 ; else

if:
    mov  rax, 1               ; return 1
    ret

else:
    push rbx                  ; Guardar o valor original de rbx

    mov  rbx, rax             ; rbx = rax
    sub  rax, 1               ; rax -= 1

    call fatorial             ; rax = fatorial(rax)
    mul  rbx                  ; rax *= rbx

    pop  rbx                  ; Resetaurar o valor original de rbx
    ret                       ; return rax

;; =================================== NAO MODIFIQUE AS LINHAS ABAIXO!!! =================================== 

_start:
    mov  rsi, intro           ; Referencia para a string a ser impressa
    mov  eax, 1               ; sys_write
    mov  edi, 1               ; stdout
    mov  edx, intro_len       ; Comprimento da string a ser impressa
    syscall

    mov  rax, 10              ; rax = 10
    call fatorial             ; rax = fatorial(rax)

    cmp  rax, 3628800         ; rax == 3628800 ?
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
    intro: db 0xa, "def fatorial(n):", 0xa, "    if n == 0:", 0xa, "        return 1", 0xa, "    else:", 0xa, "        return n * fatorial(n - 1)", 0xa, 0xa, "fatorial(10) == 3628800 ", 0x23
    intro_len:       equ $ - intro

    acertou_msg:     db " => True", 0xa, "[Acertou!]", 0xa, 0xa
    acertou_msg_len: equ $ - acertou_msg

    errou_msg:       db " => False", 0xa, "[Errou ", 0x3b, '-', 0x3b, ']', 0xa, 0xa
    errou_msg_len:   equ $ - errou_msg