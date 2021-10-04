Homework 3_2 [Merge.c]

0. what variables change the results. 
: if you want to change the element of two list,
 modify value on 	int list1[] = { 1,2,5,10,15,20,25 };
		int list2[] = { 3,7,8,15,18,30 };

the num of list1 is add into Linked list `a`
the num of list2 is add into Linked list 'b'

1. purpose of this code
: Implement a merge function using a linked list that generates a new linked list ܿ by merging ܽ a and b. 

2. function 

1) void init(ListType* list)
- Input : the address of ListType that want to initialize the value.
- Output : initialize the ListType to state that there are 0 nodes.

2) void insert_last(ListType* list, ListNode* new_node)
- Input : the address of list, node to insert 
- Output : A new node is added at the end of the list.
                                                         
3) void add_last(ListType* list, element data)
- Input : the address of list, the data value that new node will have.
- Output : Create a new node with data value and insert it at the end of the list.

4) void display(ListType* list) 
- Input : list that wants to know the contents
- Output : It shows the data values of nodes existing in the list sequentially.

5) void merge_list(ListType* list1, ListType* list2, ListType* result)
- Input : the address of the two list that want to be merged(list 1, list 2) , list to store the result of merging. (result)
- Output : The result of merging list1 and list2 is stored into result 

Homework 3_3 [ListADT]


0. what variables change the results. 
: if you want change configuration of the list, you can freely add or delete using function add(), delete()

1. purpose of this code
: implement all functions in ‘List ADT’

2. function

1) void error(const char* message)
- Input : An error message
- Output : print error message and exit

2) int is_empty(ListType* list)
- Input : A list to check having at least one node 
- Output : if you have at least one node in given list, return false. otherwise, return true.

3) int get_length(ListType* list) 
- Input : A list that you wants to know the entire length of
- Output : return the total length of list

4) void init(ListType* list)
- Input : A list that needs to be initialized.
- Output : make the list into the state of  zero - length.

5) ListNode* get_node_at(ListType* list, int pos) 
- Input : list , Where to insert the node(index of list)
- Output :  Converts a position to node pointer and return node pointer of ‘pos’ in the list.

6) void insert_node(ListType* list, ListNode* before, ListNode* new_node) 
- Input : list , node located before where you want to insert node, new node to insert 
- Output : Insert new data at the ‘position’

7) void add_first(ListType* list, element data) 
- Input : list , What data you are going to insert in list
- Output : Create a new node with given data and insert it at the beginning of the list.

8) void add_last(ListType* list, element data)
- Input :  list , What data you are going to insert in list
- Output : Create a new node with given data and insert it at the end of the list.


9) void add_at(ListType* list, int position, element data)
- Input :  list , Where to insert the node(index of list) , What data you are going to insert in list
- Output : Create a new node with given data and insert it at the position of the list.

10) void remove_node(ListType* list, ListNode* before, ListNode* removed) 
- Input : list , previous node of node to be removed, node to be removed
- Output : Remove node( ListNode* removed) from the list.

11) void delete_first(ListType* list) 
- Input : list 
- Output : Remove the first node of the list.

12) void delete_last(ListType* list)
- Input : list
- Output : Remove the last node of the list.

13) void delete_at(ListType* list, int pos)
- Input : list , Where to remove the node(index of list)
- Output : Remove node at a specified location  from a non-empty list.

14) void display(ListType* list)
- Input : list 
- Output : Display data in the list

15) bool is_in_list(ListType* list, element item)
- Input : list , `item` to check if it exists in the list.
- Output :  Find a node whose data = item

16) element get_entry(ListType* list, int pos)
- Input :  list , position to take out the data
- Output :  Return the data at the ‘pos’.
