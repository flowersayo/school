# Homework 2_1 [SparseMatrix.cpp]


0. what variables change the results. 
: The size and value of the initial matrix can be set by the user. 
if you change the matrix that transpose operation will be applied, 
modify value on `SparseMatirx B = { {{0,3,7},{1,0,9},{1,5,8},{3,0,6},{3,1,5},{4,5,1},{5,3,2}}, 6, 6, 7 };` in main. 
It means  element array (row,col,value) , row-size , col-size , the number of terms in regular order.


1. purpose of this code
: create new SparseMatirx B^T that the transpose operation on initial matrix B is performed to
and print B^T  in densed matrix form.


2. function analysis

1) bool cmp(element a, element b) 
: It is necessary to store data, which is an element array,  in a row-wise manner.

2) SparseMatirx transpose(SparseMatirx m)

- Input : SparseMatirx to perform the transpose operation 
- output : Returns transposed SparseMatirx.

3) void printSparseMatirx(SparseMatirx m)

- Input : SparseMatirx that wants to print out the value
- output : print SparseMatirx in dense matrix form 


# Homework 2_2 [mem_alloc_3D_double.cpp] 

0. what variables change the results. 
: You can customize the size of the 3D array by changing the ROWS, COL, and HEIGHT values
 which is declared in global constant (#define) on the top.


1. purpose of this code

:  Firstly, dynamically allocate two 3D arrays A and B by the size of ROWS X COL X HEIGHT. 
And the values of the A and B arrays are initialized by receiving input from the user.
 Based on this, the addition operation is performed and SUM(A+B) is printed.
Finally, the memory allocated to A, B, and SUM is released

2. function analysis


1) double*** mem_alloc_3D_double()

- Input : X
- output : A new 3D array conzaining double with size of ROW X COL X HEIGHT  is allocated and the address is returned.

2)void setValue3D(double*** m)

- Input : 3D array `m` that wants to set the value.
- output : complete setting value on `m` (This function has no return value because it directly approaches the element through the address.)
- function : The value of the given matrix m can be set by receiving an input value from the user.

3)void print_3D_matrix(double*** m)

- Input :  3D array that wants to print out the value
- output : complete printing value on `m`
- function : it prints out the value in height-wise manner.

4)double*** addition_3D(double*** a, double*** b)

- Input : 3D array that wants to perform addition operation (a+b)
- output : It creates a new 3D array that addition operation is performed and returns its address.

5)void deallocate_3D_double(double*** m) 

- Input : 3D array that wants to deallocate memory 
- output :  deallocate memory 


