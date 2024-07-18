section .bss
a resd 1
b resd 1
resultado resd 1
T0 resd 1
T1 resd 1

section .text
global _start
_start:
	; 0 ASSIGN null -> [a]
	mov rax, 0
	mov [a], rax
	; 0 ASSIGN null -> [b]
	mov rax, 0
	mov [b], rax
	; 0 ASSIGN null -> [resultado]
	mov rax, 0
	mov [resultado], rax
	; null CALL null -> sumar
	call sumar
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
	mov [T0], rax
	ret
