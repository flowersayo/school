#include <stdio.h>
#include <stdlib.h>
#include <stdio.h>

#define MAX_ELEMENT 100
#define INITIAL_ELEMENT 10

int initial_value[10] = { 1, 4, 2, 7, 5, 3, 3, 7, 8, 9};



typedef struct element {
	int key;
} element;

typedef struct {
	element heap[MAX_ELEMENT];
	int heap_size;
} HeapType;

// Initialization
void init(HeapType* h) {
	  
	h->heap_size = 0;
	for (int i = 0; i < INITIAL_ELEMENT; i++) {
		element node;
		node.key = initial_value[i];
		h->heap[i+1] = node;
		h->heap_size++;
	}

}

//decrease the element i’s value to ‘key’
void Decrease_key_min_heap(HeapType* h, int i, int key)
{
    if (key >= h->heap[i].key)
		fprintf(stderr, "new key is not smaller than current key\n");

	h->heap[i].key=key;
	element temp = h->heap[i];

	// The process of comparing with the parent node 
	while ((i > 1) && (key < h->heap[i / 2].key)) { //자식 < 부모 
		h->heap[i] = h->heap[i / 2]; //자식 =부모 
		i /= 2;
	}
	h->heap[i] = temp;
}

//Increase the element i’s value to ‘key’
void Increase_key_min_heap(HeapType* h, int i, int key)
{
	if (key <= h->heap[i].key)
		fprintf(stderr, "new key is not larger than current key\n");

	
	h->heap[i].key = key;
	
	// The process of comparing with the child node 
	while ((i <= h->heap_size) ){ // 부모 > 자식
		int child = 2 * i;
		if (child >= h->heap_size)
			break;

		


		if ((h->heap[child].key) > h->heap[child + 1].key)
			child++; // child : left right중 더 작은값

		if (h->heap[i].key <= h->heap[child].key) // 부모 < 자식
			break;
		
			// SWAP 
			element tmp = h->heap[i];
			h->heap[i] = h->heap[child]; //부모 = 자식
			h->heap[child] = tmp; //자식 = 부모 

			//	move down one level
			i = child;

	}
	

}

void print_heap(HeapType* h) {

	printf("heap : [");


	for (int i = 1; i <= INITIAL_ELEMENT; i++) {
		printf("%d ", h->heap[i].key);
	}

	printf("]\n");
}

 void main() {

	 HeapType h;
	 init(&h);
	

	 printf("\nInitial state\n");
	 print_heap(&h);

	
	 Decrease_key_min_heap(&h, 4, 3); 
	 printf("\n After  Decrease_key_min_heap(&h1, 4, 3) \n");
	
	 print_heap(&h);

	 Increase_key_min_heap(&h, 3, 10);

	 printf("\n After  Increase_key_min_heap(&h, 3, 10) \n");
	 print_heap(&h);

	

}