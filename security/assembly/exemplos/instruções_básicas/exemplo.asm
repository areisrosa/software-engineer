mov dst, val ; dst = val
mov rax, 42 ; rax = 42

add dst, val ; dst += val
add rbx, rcx ; rbx += rcx

sub dst, val ; dst -= val
sub rbx, rcx ; rbx -= rcx

mul val ; rax *= val
mul rbx ; rax *= rbx

div val ; rdx = rax % val, rax //= val
div rcx ; rdx = rax % rcx, rax //= rcx

push val ; stack += [val]
push rax ; stack += [rax]

pop dst ; dst = stack[-1], stack = stack[:-1]
pop rax ; rax = stack[-1], stack = stack[:-1]