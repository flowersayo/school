// selection_sort.cpp : Defines the entry point for the console application.
//

//#include "stdafx.h"
#include "stdlib.h"
#include "stdio.h"
#include "string.h"

#define SWAP(x, y, t) ( (t)=(x), (x)=(y), (y)=(t) )

typedef struct data {
	int *id;
	int *score;
} data;


void selection_sort(data *list, int n)
{
	int i, j, least, temp;
	for (i = 0; i < n - 1; i++) {
		least = i;
		for (j = i + 1; j<n; j++)
			if (list->score[j]<list->score[least]) least = j;
		SWAP(list->score[i], list->score[least], temp);
		SWAP(list->id[i], list->id[least], temp);
	}
}



void selection_sort_stable(data *list, int n)
{
	int i, j, k, least, min_score, min_id;
	for (i = 0; i < n - 1; i++) {
		least = i;

		//1. find minimum element 
		for (j = i + 1; j < n; j++)
			if (list->score[j] < list->score[least]) least = j;

		// keep min data
		 min_score = list->score[least];
		 min_id = list->id[least];

		 //2. instead of swapping.push element one step backward( right shift )
		 for (k = least; k >i; k--) {
			 list->score[k] = list->score[k - 1]; 
			 list->id[k] = list->id[k - 1];
		 }


		 //3 . Insert minimum value at correct place
		 list->score[i] = min_score;
		 list->id[i] = min_id;

	}
}

int main()
{
	int data_id[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	int data_score[] = { 30, 25, 10, 20, 80, 30, 25, 10 };

	int in_size = 8;
	data *input = (data *)malloc(sizeof(data));
	
	input->id = data_id;
	input->score = data_score;

	//Print out the input data
	printf("Input data\n");
	for (int i = 0; i < in_size; i++)
		printf("%d\t %d\n", input->id[i], input->score[i]);
	printf("\n");

	// Produce the stable sorting results by replacing 'selection_sort' with 'selection_sort_stable'.
	selection_sort_stable(input, in_size);

	//Print out the sorted data
	printf("Sorted data\n");
	for (int i = 0; i < in_size; i++)
		printf("%d\t %d\n", input->id[i], input->score[i]);
	printf("\n");

    return 0;
}

