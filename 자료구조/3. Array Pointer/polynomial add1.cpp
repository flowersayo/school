#include <iostream>
#define MAX(a,b) (a>b ? a:b)
#define MAX_DEGREE 101

using namespace std;

typedef struct {

	int degree; //차수
	float coef[MAX_DEGREE]; // 항들의 계수 


}polynomial;

polynomial add(polynomial A, polynomial B) {


	polynomial C;
	int Apos = 0, Bpos = 0, Cpos = 0;
	int degree_A = A.degree;
	int degree_B = B.degree;
	C.degree = MAX(A.degree, B.degree); //C의 차수 = A,B중 최고차항

	while (Apos <= A.degree && Bpos <= B.degree) {


		if (degree_A > degree_B) // A의 차수가 더 크다면
		{
			C.coef[Cpos++] = A.coef[Apos++]; //A항을 C항에 옮긴다.
			degree_A--;

		}
		else if (degree_A > degree_B) //차수가 같다면
		{

			C.coef[Cpos++] = A.coef[Apos++] + B.coef[Bpos++];
			degree_A--;
			degree_B--;
		}
		else // B의 차수가 더 크다면
		{
			C.coef[Cpos++] = B.coef[Bpos++]; //A항을 C항에 옮긴다.
			degree_B--;

		}
	}
		return C;
}

int main() {


	polynomial A = { 5,{3,6,0,0,0,10} };
	polynomial B = {4,{7,0,5,0,1} };
	polynomial C = add(A, B);

}