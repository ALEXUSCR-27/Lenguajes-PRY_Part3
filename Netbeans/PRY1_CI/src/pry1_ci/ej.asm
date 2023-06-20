.text
main:
li $t1, 201
move $s0, $t1
jal funcB
move $t0, $s0
sw $t0, num

# IMPRESION DE DATO
li $v0, 1
lw $a0, num
syscall

li $a0, 10
li $v0, 11
syscall

li $t2, 0
lw $ra, 0($sp)
jr $ra
li $v0, 10
syscall
.end main
funcB:
addi $sp, $sp, -4
sw $ra, 0($sp)
sw $s0, num
lw $t3, num
li $t4, 100
bgt $t3, $t4,L0
j if_end0
L0:
lw $t5, num
subu $t0, $t5, 50
move $s0, $t0
jal funcB
move $t0, $s0
sw $t0, num
lw $t6, num
lw $ra, 0($sp)
jr $ra
if_end0:
addi $sp, $sp, -4
sw $ra, 0($sp)
else_0:
lw $t7, num
lw $ra, 0($sp)
jr $ra
.end funcB

.data
num: .word 0
