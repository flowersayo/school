# Homework 8_1 [min_heap.cpp]

1. purpose of this code
: Implements the ‘decrease-key’ and ‘increase_key’ in the min-heap


2. function

1) void init(HeapType* h)
- input : Heap `h`
- output : initializes heap state using `initial_value`

2) void Decrease_key_min_heap(HeapType* h, int i, int key)
- input : Heap `h`, index of element in min_heap that want to decrease key, changing value. 
- output : decreases the element i’s value to ‘key’

3) void Increase_key_min_heap(HeapType* h, int i, int key)
- input : Heap `h`, index of element in min_heap that want to increase key, changing value. 
- output : Increases the element i’s value to ‘key’

4) void print_heap(HeapType* h)
- input : Heap `h`
- output : printouts heap state.


# Homework 8_2 [prim.cpp]

1. purpose of this code
:  implements Prim algorithm  using `min heap` , not the unsorted array.

2. function

1) void init(HeapType* h)
- input :  Heap `h`
- output :  initializes heap.

2) void build_min_heap(HeapType* h)
- input : Heap `h` 
- output : builds min heap `h`

3)void Decrease_key_min_heap(HeapType* h, int v, int key)
- input : Heap `h`, vertex that want to decrease key, changing value. 
- output : decreases the vertex `v`'s  distant to ‘key’

4)element delete_min_heap(HeapType* h)
- input : Heap `h`
- output : Deletes the root at heap h, ()

5)void insert_all_vertices(HeapType* h, int n) 
- input : Heap `h`
- output :  inserts all vertices into heap and sort by `build_min_heap`

6) void print_heap(HeapType* h)
- input : Heap `h`
- output : printouts heap state.

7)void print_prim(int n)
- input :  the number of vertices on the graph
- output : print the constructed MST

8) void prim(int s, int n, HeapType* h)
- input :  starting vertex `s` , the number of vertices on the graph ,Heap `h`
- output : finds MST and saves results in `dist[] and parent[]`
