section .bss
T4 resq 1
T5 resq 1
T6 resq 1
T7 resq 1
resultado resq 1
i resq 1
T0 resq 1
exp resq 1
T1 resq 1
T2 resq 1
base resq 1
T3 resq 1

section .text
global _start
_start:
	; 3 ASSIGN null -> [T5]
	mov rax, 3
	mov [T5], rax
	; null PUSH null -> [T5]
	mov rax, [T5]
	push rax
	; 1 ASSIGN null -> [T6]
	mov rax, 1
	mov [T6], rax
	; null PUSH null -> [T6]
	mov rax, [T6]
	push rax
	; null CALL null -> Pow
	call Pow
	; [T0] ASSIGN null -> [T7]
	mov rax, [T0]
	mov [T7], rax
	; T7 ASSIGN null -> [resultado]
	mov rax, T7
	mov [resultado], rax
_stop_exit:
	mov rax, 60
	mov rdi, 0
	syscall
Pow:
	; null POP null -> r10
	pop rax
	mov r10, rax
	; null POP null -> [base]
	pop rax
	mov [base], rax
	; null POP null -> [exp]
	pop rax
	mov [exp], rax
	; 1 ASSIGN null -> [T1]
	mov rax, 1
	mov [T1], rax
	; T1 ASSIGN null -> [i]
	mov rax, T1
	mov [i], rax
	; null LABEL null -> E0
E0:
	; [i] LT [exp] -> [T2]
	mov rax, [i]
	mov rbx, [exp]
	cmp rax, rbx
	setl al
	movzx rax, al
	mov [T2], rax
	; T2 JEQ 0 -> E1
	mov rax, T2
	mov rbx, 0
	cmp rax, rbx
	je E1
	; [base] MUL [base] -> [T3]
	mov rax, [base]
	mov rbx, [base]
	imul rbx
	mov [T3], rax
	; [T3] ASSIGN null -> [base]
	mov rax, [T3]
	mov [base], rax
	; [i] ASSIGN null -> [T4]
	mov rax, [i]
	mov [T4], rax
	; null INCREMENT null -> [i]
	inc qword [i]
	; null JMP null -> E0
	jmp E0
	; null LABEL null -> E1
E1:
	; null PUSH null -> r10
	mov rax, r10
	push rax
	; [base] RETURN null -> [T0]
	mov rax, [base]
	mov [T0], rax
	ret
