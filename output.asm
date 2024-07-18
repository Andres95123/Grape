section .bss
a resd 1
b resd 1
resultado resd 1
T0 resd 1
T1 resd 1

section .text
global _start
_start:
	; null CALL null -> sumar
	call sumar
	; [T0] ASSIGN null -> [resultado]
	mov rax, [T0]
	mov [resultado], rax
_stop_exit:
	mov rax, 60
	mov rdi, 0
	syscall
sumar:
	; [a] ADD [b] -> [T1]
	mov rax, [a]
	mov rbx, [b]
	add rax, rbx
	mov [T1], rax
	; [T1] RETURN null -> [T0]
	mov rax, [T1]
	mov [T0], rax
	ret
