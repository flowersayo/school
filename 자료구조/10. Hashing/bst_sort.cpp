#include "stdlib.h"
#include "stdio.h"
#include "string.h"
#include "time.h"



typedef struct Node {
	int data;
	 Node* left, * right;
}Node;


// Integer random number generation function between 1 and n
int random(int data_maxval) {
	return rand() % data_maxval + 1;

}
Node* bst_insert(Node* root, int key) {

	if (root == NULL) {
		root = (Node*)malloc(sizeof(Node));
		root->data = key;
		root->left = root->right = NULL;

	}

	else if (root->data >= key) 
		root->left = bst_insert(root->left, key);
	else 
		root->right = bst_insert(root->right, key);

	return root;

}

// l -> v - > r
void in_order(Node* root) {

	if (root == NULL)
		return;

	in_order(root->left);
	printf("%d\n", root->data);
	in_order(root->right);

}


int main() {

	//Intializes random number generator 
	srand((unsigned)time(NULL));

	int input_size = 1000;
	int data_maxval = 10000;
	// output: sorted result
	int* input = (int*)malloc(sizeof(int) * input_size);
	// Generate an input data randomly
	for (int i = 0; i < input_size; i++)
		input[i] = random(data_maxval);

	Node* root = NULL;
	for(int i=0;i< input_size;i++){
		root = bst_insert(root, input[i]);
	}

	in_order(root);

}
