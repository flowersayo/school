#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 15
#define SWAP(x, y, t) ((t) = (x), (x) = (y), (y) = (t))

void makeList(int list[])
{
    for(int i = 0; i < SIZE; i++)
        list[i] =rand() % 100 + 1;
}

void printList(int list[])
{
    for(int i = 0; i < SIZE; i++)
        printf("%d ", list[i]);
    printf("\n");    
}

int partition(int list[], int left, int right)
{
    int pivot, temp, low, high;
    
    pivot = list[left];
    low = left; high = right + 1;
    
    do
    {
        do
            low++;
        while (list[low] < pivot);
        
        do  
            high--;
        while (list[high] > pivot);
        
        /*
        for (int i = 0; i < SIZE; i++)	
			printf("%d ", list[i]);
		printf("\nlow=%d, high=%d\n", low, high);
        */
        
        if(low < high)
            SWAP(list[low], list[high], temp);
    
    } while (low < high);
    
    SWAP(list[left], list[high], temp);
    return high;
}

void quickSort(int list[], int left, int right)
{
    if(left < right)
    {
        int q = partition(list, left, right);
        quickSort(list, left, q - 1);
        quickSort(list, q + 1, right);
    }
}

int main()
{
	int list[SIZE];
	srand(time(NULL));
    
    makeList(list);
    printList(list);
    
    quickSort(list, 0, SIZE - 1);
    printList(list);
}
