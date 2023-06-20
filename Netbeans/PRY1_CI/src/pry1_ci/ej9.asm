.text
main:
li $t0, 13
sw $t0, x
li $t0, 15
sw $t0, y
lw $t1, x
lw $t2, y
addu $t0, $t1, $t2
move $s0, $t0
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
li $t0, 290
sw $t0, d
lw $t3, f
lw $t4, d
addu $t0, $t3, $t4
move $s0, $t0
sw $t0, res2

# IMPRESION DE DATO
li $v0, 1
lw $a0, res2
syscall

li $a0, 10
li $v0, 11
syscall

lw $t5, res2
li $t6, 10
bgt $t5, $t6,L0
j if_end0
L0:
li $t0, 23
sw $t0, z
li $t0, 12
sw $t0, r
li $t7, 23
li $t1, 12
subu $t0, $t7, $t1
move $s0, $t0
sw $t0, res3
lw $t2, z
lw $t3, r
div $t2, $t3
mflo $t0
move $s0, $t0
sw $t0, res4
lw $t4, r
lw $t5, z
mul $t0, $t4, $t5
move $s0, $t0
sw $t0, res5

# IMPRESION DE DATO
li $v0, 1
lw $a0, res3
syscall

li $a0, 10
li $v0, 11
syscall


# IMPRESION DE DATO
li $v0, 1
lw $a0, res4
syscall

li $a0, 10
li $v0, 11
syscall


# IMPRESION DE DATO
li $v0, 1
lw $a0, res5
syscall

li $a0, 10
li $v0, 11
syscall

if_end0:
lw $t6, res
li $v0, 10
syscall

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
z: .word 0
r: .word 0
res3: .word 0
res4: .word 0
res5: .word 0
