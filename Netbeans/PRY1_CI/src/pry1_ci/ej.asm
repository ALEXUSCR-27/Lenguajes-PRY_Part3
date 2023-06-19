.text
main:
lw $t0, 201
jal funcB
move $t0, $t1
sw $t0, num

# IMPRESION DE DATO
li $v0, 1
lw $a0, num
syscall

li $a0, 10
li $v0, 11
syscall

lw $t2, 0
li $v0, 10
syscall

.end main
funcB:
lw $t3, num
lw $t4, 100
jal L0
lw $t6, num
subu $t7, $t6, $50
jal funcB
move $t0, $t8
sw $t0, num
lw $t9, num
li $v0, 10
syscall

lw $t10, num
li $v0, 10
syscall

.end funcB

.data
num: .word 0
