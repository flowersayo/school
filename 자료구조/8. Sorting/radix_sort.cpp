#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>
#include <math.h>

#define INPUT 10
#define BUCKETS 64 // 24-bit/ 4 = 6-bit. 2^(6)
#define DIGITS 4

void  generate_random(int A[]) { 

	srand((unsigned)time(NULL));

	for (int i = 1; i <= INPUT; i++) {
		int n1 = rand() % 4096 + 1; // 1 ~ 2^12
		int n2 = rand() % 4096 + 1; // 1 ~ 2^12
		int r = n1 * n2 - 1; // 0 ~ 2^24-1
		A[i] = r;
	}

}

// input : A (array wanting to be sorted), n(size of array)
// output : sorted `A`
void radix_sort(int A[], int n) {
	int C[BUCKETS], B[INPUT+1] = { 0, };
	int factor = 1;
	int i,j;

	for ( i = 1; i <= DIGITS; i++) {
		//counting sort

		//1. initialize
		for (j = 0; j < BUCKETS; j++) {
			C[j] = 0;
		}
		// 2. count appearances of each number.
		for (j = 1; j <= n; j++)
			C[(A[j] / factor) % BUCKETS] += 1;

		// 3. sum accumulately
		for (j = 1; j < BUCKETS; j++)
			C[j] = C[j] + C[j - 1];

		// 4. find proper place to insert `	A[j]` using 'C(cumulative histogram)'
		for (j = n ; j > 0; j--) {
			B[C[(A[j] / factor) % BUCKETS]] = A[j];
			C[(A[j] / factor) % BUCKETS] -= 1;
		}

		//copy to original array.
		for (j = 1; j <= n; j++)
			A[j] = B[j];
		factor *= BUCKETS;
	}
}

bool check(int A[], int n) {
	for (int i = 2; i <= n; i++) {
		if (A[i] < A[i - 1])
			return false;
	}
	return true;
}

int main() {


	int A[INPUT+1];

	generate_random(A);
	radix_sort(A, INPUT);

	if (check(A, INPUT)) { 
		printf("sorting is correct\n");

		for (int i = 1; i <= INPUT; i++)
			printf("%d\n", A[i]);
	}
	else
		printf("sorting is rong\n");
}