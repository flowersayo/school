#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>

#define MAX_TERMS 10


using namespace std;

typedef struct {

	int row; 
	int col; 
	int value; 

}element;


typedef struct SparseMatrix {

	element data[MAX_TERMS];
	int rows; //row size
	int cols; //column size
	int terms; //the number of elements

}SparseMatirx;

bool cmp(element a, element b) {

	if (a.row != b.row)
		return a.row < b.row;

	return a.col < b.col;
}



SparseMatirx transpose(SparseMatirx m) {


	SparseMatirx transposed;

	// exchanging row size and col size
	transposed.rows = m.cols;
	transposed.cols = m.rows;
	transposed.terms = m.terms;
	
	
	for (int i = 0; i < m.terms; i++) {

		transposed.data[i].value = m.data[i].value;
		transposed.data[i].row = m.data[i].col;
		transposed.data[i].col = m.data[i].row;

	}

	
	sort(transposed.data, transposed.data + transposed.terms,cmp); //in row-wize manner

	return transposed;
	
}


void printSparseMatirx(SparseMatirx m) {

	cout << "========================"<<'\n';

	int pos=0;

	for (int i = 0; i < m.rows; i++) {


		for (int j = 0; j < m.cols; j++) {

			if (i == m.data[pos].row && j == m.data[pos].col)
				cout << m.data[pos++].value<<' ';

			else {
				cout << "0" <<' ';
				
			}
			
		}

		cout << '\n';
	}

	cout << "========================"<<'\n';


}

int main() {

	
	//you can customize own your input by changing below value 
	SparseMatirx B = { {{0,3,7},{1,0,9},{1,5,8},{3,0,6},{3,1,5},{4,5,1},{5,3,2}}, 6, 6, 7 };

	/*
	 [input]
	0 0 0 7 0 0
	9 0 0 0 0 8
	0 0 0 0 0 0
	6 5 0 0 0 0
	0 0 0 0 0 1
	0 0 2 0 0 0
	*/

	cout << "\nMatrix B\n";
	printSparseMatirx(B);

	//perfrom transpose operation 
	SparseMatirx B_transposed=transpose(B);


	cout << "\nMatrix B^T\n";
	printSparseMatirx(B_transposed);



}