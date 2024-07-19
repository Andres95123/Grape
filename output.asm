section .bss
T4 resq 1
a resq 1
T5 resq 1
i resq 1
T0 resq 1
T1 resq 1
T2 resq 1
T3 resq 1

section .text
global _start
_start:
	; 3 ASSIGN null -> [T0]
	mov rax, 3
	mov [T0], rax
	; T0 ASSIGN null -> [a]
	mov rax, T0
	mov [a], rax
	; 0 ASSIGN null -> [T1]
	mov rax, 0
	mov [T1], rax
	; T1 ASSIGN null -> [i]
	mov rax, T1
	mov [i], rax
	; null LABEL null -> E0
E0:
	; 10 ASSIGN null -> [T2]
	mov rax, 10
	mov [T2], rax
	; [i] LT [T2] -> [T3]
	mov rax, [i]
	mov rbx, [T2]
	cmp rax, rbx
	setl al
	movzx rax, al
	mov [T3], rax
	; [T3] JEQ 0 -> E1
	mov rax, [T3]
	mov rbx, 0
	cmp rax, rbx
	je E1
	; [a] ASSIGN null -> [T4]
	mov rax, [a]
	mov [T4], rax
	; null INCREMENT null -> [a]
	inc qword [a]
	; [i] ASSIGN null -> [T5]
	mov rax, [i]
	mov [T5], rax
	; null INCREMENT null -> [i]
	inc qword [i]
	; null JMP null -> E0
	jmp E0
	; null LABEL null -> E1
E1:
_stop_exit:
	mov rax, 60
	mov rdi, 0
	syscall
