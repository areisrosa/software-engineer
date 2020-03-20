; Calcula f(rax)
; Guarda o resultado em rax
f:
    ...

;; =================================================================

    mov rax, rbx
    jmp f
    ...

; Calcula f(rax)
; Guarda o resultado em rax
f:
    ...

;; =================================================================

    mov rax, rbx
    jmp f
    mov rbx, rax
    mov rax, rcx
    jmp f
    ...

; Calcula f(rax)
; Guarda o resultado em rax
f:
    ...

;; =================================================================

    mov rax, rbx
    jmp f
    mov rbx, rax
    mov rax, rcx
    jmp f
    ...

; Calcula f(rax)
; Guarda o resultado em rax
f:
    ...
    jmp 3

;; =================================================================

    mov rax, rbx
    push joão
    jmp f
    joão:
    mov rbx, rax
    mov rax, rcx
    push maria
    maria:
    jmp f
    ...

; Calcula f(rax)
; Guarda o resultado em rax
f:
    ...
    pop rdx
    jmp rdx

;; =================================================================

    mov  rax, rbx
    call f
    mov  rbx, rax
    mov  rax, rcx
    call f
    ...

; Calcula f(rax)
; Guarda o resultado em rax
f:
    ...
    ret