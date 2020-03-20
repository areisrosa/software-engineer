section .text
    global _start

;; ----------------------------------------------- EM PYTHON ------------------------------------------------

;; def somatorio(n):
;;     s = 0
;;
;;     # for c in [n, n-1, n-2, ..., 0]
;;     for c in range(n, -1, -1):
;;         s += c
;;
;;     return s

;; ---------------------------------------------- EM ASSEMBLY -----------------------------------------------

;; Recebe um inteiro positivo n em rax. Retorna a soma dos números naturais de 0 a n em rax. A subrotina
;; deve preservar o valor de todos os registros com execao de rax. Dica: use a instrucao 'loop'.
somatorio:
    push rcx                  ; Guardar o valor original de rcx

    mov  rcx, rax             ; rcx = rax
    mov  rax, 0               ; rax = 0

for:
    add  rax, rcx             ; do rax += rcx
    loop for                  ; for rcx in [n, n-1, n-2, ..., 0]

end:
    pop  rcx                  ; Resetaurar o valor original de rcx
    ret                       ; return rax

;; =================================== NAO MODIFIQUE AS LINHAS ABAIXO!!! =================================== 

_start:
    mov  rsi, intro           ; Referencia para a string a ser impressa
    mov  eax, 1               ; sys_write
    mov  edi, 1               ; stdout
    mov  edx, intro_len       ; Comprimento da string a ser impressa
    syscall

    mov  rax, 10              ; rax = 10
    call somatorio            ; rax = somatorio(rax)

    cmp  rax, 55              ; rax == 55 ?
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
    intro: db 0xa, "def somatorio(n):", 0xa, "    s = 0", 0xa, 0xa, "    for c in range(n, -1, -1):", 0xa, "        s += c", 0xa, 0xa, "    return s", 0xa, 0xa, "somatorio(10) == 55 ", 0x23
    intro_len:       equ $ - intro

    acertou_msg:     db " => True", 0xa, "[Acertou!]", 0xa, 0xa
    acertou_msg_len: equ $ - acertou_msg

    errou_msg:       db " => False", 0xa, "[Errou ", 0x3b, '-', 0x3b, ']', 0xa, 0xa
    errou_msg_len:   equ $ - errou_msg