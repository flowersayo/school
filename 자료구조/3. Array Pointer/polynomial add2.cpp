#include <iostream>
#define MAX_TERMS 101

using namespace std;


struct {

	float coef;
	int expon;

}terms[MAX_TERMS] = { {8,3},{7,1},{1,0},{10,3},{3,2},{1,0} };
//구조체 선언과 동시에 초기화

int avail = 6; //결과를 넣을 인덱스 배열의 시작점

//compare two integers

char compare(int a, int b) {


	if (a > b) return '>';
	else if (a == b) return '=';
	else return '<';

}

void attach(float coef, int expon) { //새로운 항을 새로운 다항식 C (결과)에 추가한다.

	if (avail > MAX_TERMS) {

		fprintf(stderr, "too many terms\n");
		exit(1);
	}
	//avail이 오른쪽으로 한칸씩 움직이면서 새로운 항을 추가함.
	terms[avail].coef = coef; //계수넣기
	terms[avail++].expon = expon;  //지수 넣고 인덱스 뒤로 이동
}

void add(int As, int Ae, int Bs, int Be, int* Cs, int* Ce) {

	float tempcoef; //덧셈 저장용
	*Cs = avail;


	while (As <= Ae && Bs <= Be) {

		switch (compare(terms[As].expon, terms[Bs].expon))

		{

		case '>': //A항 차수 > B항 차수
			attach(terms[As].coef, terms[As].expon);

			As++; // A를 다음 항으로
			break;

		case '=':  //A항 차수 = B항 차수

			tempcoef = terms[As].coef + terms[Bs].coef; //A항 계수 + B항계수 합친것 

			if (tempcoef) //만일 더했을때 계수가 0이라면 새로운 다항식 C에 추가할필요가 없음. (없는항)
				attach(tempcoef, terms[As].expon); //2번째인자는 terms[Bs].expon 여도 상관X 어짜피 차수 같으니..

			As++; Bs++;
			break;

		case '<': //A항 차수 < B항 차수
			attach(terms[Bs].coef, terms[Bs].expon);
			
			Bs++; // B를 다음 항으로
			break;



		}
	}

		//Q. 항들이 어떻게 남아있을 수 있냐? A. 차수가 같은 항들끼리만 계산하는게 아니므로 A:4 5 B:3 2 이면 A가 먼저 끝남.
		 
		//A에 남아있는 항들을 복사 붙여넣기
		for (; As <= Ae; As++) {

			attach(terms[As].coef, terms[As].expon);
			
		}
		for (; Bs <= Be; Bs++) {

			attach(terms[Bs].coef, terms[Bs].expon);
			
		}
		
	

	*Ce = avail - 1; //avail은 현재 비어있는 공간을 가리키고 있으므로 -1을 해주어야 C가 끝나는 지점의 index가 됨.


}
int main() {


	int Cs, Ce; //결과 다항식의 시작 & 끝 인덱스를 담을 변수
	add(0, 2, 3, 5, &Cs, &Ce); //A다항식의 시작과 끝, B다항식의 시작과 끝.
	//주소를 넘겨주어야 실질적으로 값을 변경할 수 있음.

	for (int i = Cs; i <= Ce; i++) {

		cout << terms[i].coef<<' ';
	
	}
	
}