Homework 9_1 [Hashing.cpp]

1. purpose of this code
:  implements several hash function including ‘add,delete,search,print`.

2. function

1)void init_table(ListNode* ht[])
- input : hash table `ht`
- output : initializes ht.

2)int transform(char* key)
- input : starting address of char array (=string) `key`
- output : Transform the string key into an integer by summing ASCII codes

3)int hash_function(char* key)
- input : starting address of char array (=string) `key`
- output :  Division function ( key mod TABLE_SIZE )

4)void hash_chain_add(element item, ListNode* ht[])
- input : `item to be inserted` , hash table `ht`
- output : inserts item at specific address in hash table using hash_function`

5)void hash_chain_search(element item, ListNode* ht[])
- input : `item to be searched` , hash table `ht`
- output :  searches item with given item in hash table .

6)void hash_chain_print(ListNode* ht[])
- input :  hash table `ht`
- output :  print  slots of each Bucket in hash table `ht`

7)void hash_chain_delete(element item, ListNode* ht[])
- input : `item to be deleted` , hash table `ht`
- output :  deletes item with given item in hash table .


Homework 9_2 [Bst_sort.cpp]


1. purpose of this code
:  implements several hash function including ‘add,delete,search,print`.

2. function

1)int random(int data_maxval)
- input : maximum value of random generating data
- output : Integer random number generation function between 1 and data_maxval

2)node* bst_insert(node* root, int key)
- input : the address of `root` node , `key` 
- output : inserts given key in bst.

3)void in_order(node* root)
- input : the address of `root` node.
- output : prints tree with inorder traversal ( = ascending order)
