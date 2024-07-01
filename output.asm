section .data
	b dd 3.1
	a dd 5.2
section .bss
	T0 resd 1
	T1 resd 1
	T2 resd 1
	T3 resd 1
section .text
global _start
_start:
	mov eax,a
	add eax,b
	mov [T3], eax
	mov eax,T1
	imul eax,T2
	mov [T0], eax
	mov eax,a
	add eax,b
	mov [T2], eax
	mov eax,a
	add eax,b
	mov [T1], eax
	mov eax, 1
	int 0x80