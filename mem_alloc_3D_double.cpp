#include <iostream>
#include <algorithm>
#include <iomanip>

//you can define the size of matrix by changing below value
#define ROW 3
#define COL 3
#define HEIGHT 3


using namespace std;

double*** mem_alloc_3D_double(){

	

	double*** m = (double***)malloc(sizeof(double**) * ROW);


	for (int i = 0; i < ROW  ; i++) {

		m[i] = (double**)malloc(sizeof(double*) * COL);

		for (int j = 0; j < COL; j++) {

			m[i][j] = (double*)malloc(sizeof(double) * HEIGHT);

		}
	}

	return m;

}

void setValue3D(double*** m) {


	cout << "set own your value\n" ; 
	int cnt = 0;
	for (int i = 0; i < ROW; i++) {

		for (int j = 0; j < COL; j++) {

			for (int k = 0; k < HEIGHT; k++)

			{
				cout << "m["<<i<<"]["<<j<<"]["<<k<<"] :" ;
				cin >> m[i][j][k];
				//*(*(*(m + i) + j) + k) = ++cnt;

				
			}
		}
	}

	cout << "\n";
}

void print_3D_matrix(double*** m) {

	cout << "==================================\n\n";
	for (int i = 0; i < HEIGHT; i++)
	{
		cout << "HEIGHT : " << i <<'\n' ;
		for (int j = 0; j < ROW; j++)
		{
			for (int k = 0; k < COL; k++) {
				cout <<setw(3) << m[j][k][i] <<' ';
			}
			cout << '\n';
		}
		cout << '\n';
	}
	cout << "==================================\n\n";
}

double*** addition_3D(double*** a, double*** b) {

	
	double*** sum = mem_alloc_3D_double();

	for (int i = 0; i < ROW; i++) {

		for (int j = 0; j < COL; j++) {

			for (int k = 0; k < HEIGHT; k++)

			{
				sum[i][j][k] = a[i][j][k] + b[i][j][k];

			}
		}
	}

	return sum;
}

void deallocate_3D_double(double*** m) {



	if (m != NULL) {

		for (int i = 0; i < ROW; i++)
		{
			for (int j = 0; j < COL; j++) {
				free(m[i][j]);
			}
			free(m[i]);
		}
		free(m);
	}
	m = NULL;

}

int main() {



	//define two matrices A and B using 'mem_alloc_3D_double'
	double*** A = mem_alloc_3D_double();
	double*** B =mem_alloc_3D_double();
	

	// set value of matrix
	cout << "Matrix A" << '\n';
	setValue3D(A);

	cout << "Matrix B" << '\n';
	setValue3D(B);



	//print Matix A,B
	cout << "Matrix A"<<'\n';
	print_3D_matrix(A);

	cout << "Matrix B" << '\n';
	print_3D_matrix(B);


	//perform addition of two matrices using addition_3D();
	double*** SUM = addition_3D(A, B);
	
	
	//print SUM(A+B)
	cout << "SUM(A+B)"<<'\n';
	print_3D_matrix(SUM);

	

	//deallocate
	deallocate_3D_double(A);
	deallocate_3D_double(B);
	deallocate_3D_double(SUM);

	
	
}