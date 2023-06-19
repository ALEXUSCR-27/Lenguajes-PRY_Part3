.text
main:
li $t0, 10
sw $t0, x
li $t0, 12
sw $t0, y
lw $t0, x
lw $t1, y
addu $t2, $t0, $t1
move $t0, $t2
sw $t0, res

# IMPRESION DE DATO
li $v0, 1
lw $a0, res
syscall

li $a0, 10
li $v0, 11
syscall

li $t0, 123
sw $t0, f
li $t0, 23
sw $t0, d
lw $t3, f
lw $t4, d
addu $t5, $t3, $t4
move $t0, $t5
sw $t0, res2

# IMPRESION DE DATO
li $v0, 1
lw $a0, res2
syscall

li $a0, 10
li $v0, 11
syscall

lw $t6, res
li $v0, 10
syscall

.end main

.data
x: .word 0
y: .word 0
res: .word 0
f: .word 0
d: .word 0
res2: .word 0
