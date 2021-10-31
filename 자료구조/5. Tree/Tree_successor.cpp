#include <stdio.h>
#include <stdlib.h>


using namespace std;

typedef struct TreeNode {
	int data;
	struct TreeNode* left, * right, * parent;
} TreeNode;

//    G
//  C   F
// A B D E
TreeNode n1 = { 'A', NULL, NULL, NULL };
TreeNode n2 = { 'B', NULL, NULL, NULL };
TreeNode n3 = { 'C', &n1, &n2, NULL };
TreeNode n4 = { 'D', NULL, NULL, NULL };
TreeNode n5 = { 'E', NULL, NULL, NULL };
TreeNode n6 = { 'F', &n4, &n5, NULL };
TreeNode n7 = { 'G', &n3, &n6, NULL };



TreeNode* tree_successor(TreeNode* x)
{
	if (x->right != NULL) //x’s right subtree is not null
	{
		x = x->right; //set right sub tree
		while (x->left != NULL) { //leftmost of right subtree
			x = x->left;
		}
		return x;
		
	}

		//x’s right subtree is null
	TreeNode* y = x->parent;
		while (y != NULL and x == y->right) {
			x = y;
			y = y->parent;
		}
	return y;
}

void main()
{
	TreeNode* exp = &n7;
	TreeNode *q = exp;
	n1.parent = &n3;
	n2.parent = &n3;
	n3.parent = &n7;
	n4.parent = &n6;
	n5.parent = &n6;
	n6.parent = &n7;
	n7.parent = NULL;
	while (q->left) q = q->left; // Go to the leftmost node
	do
	{
		printf("%c\n", q->data); // Output data
		// Call the successor
		q = tree_successor(q);
	} while (q); // If not null
}