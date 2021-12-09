#include <stdio.h>
#include <stdlib.h>
#include <stdio.h>


/*
- Use the min heap, not the unsorted array.
- Specify the parent and child relation inside the code.
- Use the following two functions.
‘build_min_heap’: use this at ‘Insert all vertices into the priority queue Q’
‘delete_min_heap’: use this at ‘Extract_Min(Q)’
‘Decrease_key_min_heap’: use this at ‘dist[v] ← weight[u][v]’

*/
#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 8
#define INF 1000L
#define MAX_ELEMENT 100

int weight[MAX_VERTICES][MAX_VERTICES] =
{ { 0,3,INF,INF,INF,INF,INF,14 },
{ 3,0,8,INF,INF,INF,INF,10 },
{ INF,8,0,15,2,INF,INF,INF },
{ INF,INF,15,0,INF,INF,INF,INF },
{ INF,INF,2,INF,0,9,4,5 },
{ INF,INF,INF,INF,9,0,INF,INF },
{ INF,INF,INF,INF,4,INF,0,6 },
{ 14,10,INF,INF,5,INF,6,0 } };


int selected[MAX_VERTICES];
int dist[MAX_VERTICES] = {INF, };
int parent[MAX_VERTICES];

typedef struct element {
	int distance; //key
	int vertex;

} element;

typedef struct {
	element heap[MAX_ELEMENT];
	int heap_size;
} HeapType;

// Initialization
void init(HeapType* h) {
	
	h->heap_size = 0;
}
void build_min_heap(HeapType* h)
{

	int parent, child;
	element temp;
	int i;


	for (int i = h->heap_size / 2; i >= 1; i--) {

		parent = i;
		child = 2 * i; //left child

		temp = h->heap[parent];

		// The process of comparing with the parent node as it traverses the tree
		while (child <= h->heap_size) {


			if ((child + 1 <= h->heap_size) && (h->heap[child].distance > h->heap[child + 1].distance))
				child++; 

			if (temp.distance <= h->heap[child].distance) 
				break;

			h->heap[parent] = h->heap[child];

			// Move down one level
			parent = child;
			child = parent * 2;

		}
		h->heap[parent] = temp;
	}

}

//decrease the vertex v’s value to ‘key’
void Decrease_key_min_heap(HeapType* h, int v, int key)
{
	//find node with vertex 'v' 
	int j, i;
	for (j = 1; j <= h->heap_size; j++) {
		if (h->heap[j].vertex == v) {
			i = j;
			break;
		}
	}
	
	if (key >= h->heap[i].distance)
		fprintf(stderr, "new key is not smaller than current key\n");

	h->heap[i].distance = key;
	element temp = h->heap[i];

	// The process of comparing with the parent node 
	while ((i > 1) && (key < h->heap[i / 2].distance)) { //자식 < 부모 
		h->heap[i] = h->heap[i / 2]; //자식 =부모 
		i /= 2;
	}
	h->heap[i] = temp;
}



// Delete the root at heap h, (# of elements: heap_size)
element delete_min_heap(HeapType* h)
{
	int parent, child;
	element item, temp;

	item = h->heap[1];
	temp = h->heap[(h->heap_size)--];
	parent = 1;
	child = 2;
	while (child <= h->heap_size) {
		// Find a smaller child node
		if ((child < h->heap_size) && (h->heap[child].distance > h->heap[child + 1].distance))
			child++;
		if (temp.distance <= h->heap[child].distance) break;
		// Move down one level
		h->heap[parent] = h->heap[child];
		parent = child;
		child *= 2;
	}
	h->heap[parent] = temp;
	return item;
}


void insert_all_vertices(HeapType* h, int n) {
	
	init(h);
	for (int i = 0; i < MAX_VERTICES; i++) {
		element v;
		v.vertex = i;
		v.distance = dist[i];
		h->heap[i+1] = v;
		h->heap_size++;
	}
	build_min_heap(h);
}

void print_heap(HeapType* h) {

	printf("heap : [");


	for (int i = 1; i < MAX_VERTICES; i++) {
		printf("%d ", h->heap[i].distance);
	}

	printf("]\n");
}

void print_prim(int n) {

	for (int i = 1; i < n; i++) {
		printf("Vertex %d -> %d  edge : %d\n", parent[i], i, dist[i]);
	}

}

void print_dist(int n) {

	printf("dist : [");


	for (int i = 1; i < n; i++) {
		printf("%d ",dist[i]);
	}

	printf("]\n");
}
// n: the number of vertices on the graph
void prim(int s, int n, HeapType* h)
{
	
	int i, u, v,d;
	element node;
	for (u = 0; u < n; u++)
	{
		dist[u] = INF;
		selected[u] = FALSE;
	}
	dist[s] = 0;
	insert_all_vertices(h, n);
	for (i = 0; i <= n-1; i++) {

		print_heap(h);
		print_dist(MAX_VERTICES);
		node = delete_min_heap(h);
		u = node.vertex;
		d = node.distance;
		selected[u] = TRUE;
		
		printf("[current vertex : %d ]\n", u);

		if ( d==INF)
			return;
		
		for (v = 0; v < n; v++) {
			if (weight[u][v] != INF) {
				if (!selected[v] && weight[u][v] < dist[v])
				{
					dist[v] = weight[u][v];
					printf("renewal distance %d(from) -> %d(to) as %d\n",u,v,weight[u][v]);
					Decrease_key_min_heap(h, v, weight[u][v]);
					parent[v] = u;
				}

			}

		}
		printf("\n\n");
	}
	

}


void main()
{
	HeapType h;
	
	prim(0, MAX_VERTICES,&h);
	print_prim(MAX_VERTICES);
}