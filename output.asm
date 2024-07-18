section .bss
T4 resq 1
a resq 1
T1_sumar resq 1
b resq 1
resultado resq 1
T0 resq 1
T2 resq 1
T3 resq 1

section .text
global _start
_start:
	; null PUSH null -> 3
	mov rax, 3
	push rax
	; null PUSH null -> 1
	mov rax, 1
	push rax
	; null CALL null -> sumar
	call sumar
	; [T0] ASSIGN null -> [T2]
	mov rax, [T0]
	mov [T2], rax
	; null PUSH null -> 0
	mov rax, 0
	push rax
	; null PUSH null -> 1
	mov rax, 1
	push rax
	; null CALL null -> sumar
	call sumar
	; [T0] ASSIGN null -> [T3]
	mov rax, [T0]
	mov [T3], rax
	; [T2] ADD [T3] -> [T4]
	mov rax, [T2]
	mov rbx, [T3]
	add rax, rbx
	mov [T4], rax
	; [T4] ASSIGN null -> [resultado]
	mov rax, [T4]
	mov [resultado], rax
_stop_exit:
	mov rax, 60
	mov rdi, 0
	syscall
sumar:
	; null POP null -> r10
	pop rax
	mov r10, rax
	; null POP null -> [a]
	pop rax
	mov [a], rax
	; null POP null -> [b]
	pop rax
	mov [b], rax
	; [a] ADD [b] -> [T1_sumar]
	mov rax, [a]
	mov rbx, [b]
	add rax, rbx
	mov [T1_sumar], rax
	; null PUSH null -> r10
	mov rax, r10
	push rax
	; [T1_sumar] RETURN null -> [T0]
	mov rax, [T1_sumar]
	mov [T0], rax
	ret
