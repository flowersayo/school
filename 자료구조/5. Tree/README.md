# Homework 5_2 [Tree_successor.cpp]

0. what variables change the results. 
: The result can be changed by reorganizing structure of tree.

1. purpose of this code
: Implement the function that finds a successor of node in the inorder traversal.
And print a successor sequentially from leftmost node.

2. function

1) TreeNode* tree_successor(TreeNode* x)
- input : address of TreeNode
- output : returns the predecessor of given TreeNode.


# Homework 5_3 [Tree_predecessor.cpp]

0. what variables change the results. 
: The result can be changed by reorganizing structure of tree.

1. purpose of this code
: Implement the function that finds a predecessor of node in the inorder traversal. 
And print a predecessor sequentially from rightmost node.

2. function

1)TreeNode* tree_predecessor(TreeNode* x)
- input : address of TreeNode
- output : returns the successor of given TreeNode.

# Homework 5_4 [bst_insertion_deletion.cpp]

0. what variables change the results. 

1. purpose of this code
:  it inserts or deletes nodes in BST. Specially the case 3 of deletion was implemented using the predecessor at 
the left subtree. 
   
2. function

1) void insert_node(TreeNode **root, int key)
- input : address of root pointer , data that you want to insert in
- output : insert key in proper location in Tree

2) void delete_node(TreeNode **root, int key)
- input :  address of root pointer , data that you want to delete in
- output : delete node in tree with keep rules of tree 

3) void inorder(TreeNode *root)
- input : address of root
- output : print tree in inorder
