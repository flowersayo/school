#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef int element;
typedef struct ListNode {
	element data;
    struct ListNode* link;
}ListNode;

typedef struct {
	ListNode* head;
	ListNode* tail;
	int length;
}ListType;

void init(ListType* list) { 
	list->length = 0;
	list->head = list->tail = NULL;
}

void insert_last(ListType* list, ListNode* new_node) {
	if (list->head == NULL) { 
		new_node->link = NULL;
		list->head = new_node;
		list->tail = new_node;
	}
	else { 
		new_node->link = NULL;
		list->tail->link = new_node;
		list->tail = new_node;
	}
}

void add_last(ListType* list, element data) {
	ListNode* node = (ListNode*)malloc(sizeof(ListNode));
	if (node == NULL) {
		printf("Memory allocation error\n");
		return;
	}
	node->data = data;
	insert_last(list, node);
	list->length++;
}

void display(ListType* list) { 
	ListNode* node = list->head;
	printf("{ ");
	for (int i = 0; i < list->length; i++) {
		printf("%d ", node->data);
		node = node->link;
	}
	printf(" }\n");
}


void merge_list(ListType* list1, ListType* list2, ListType* result) {
	ListNode* a = list1->head;
	ListNode* b = list2->head;

	while (a && b) { 
		if (a->data < b->data) { 
			add_last(result, a->data);
			a = a->link;
		}
		else { 
			add_last(result, b->data);
			b = b->link;
		}
	}
	for (; a != NULL; a = a->link) 
		add_last(result, a->data);
	for (; b != NULL; b = b->link) 
		add_last(result, b->data);
}

int main() {

	ListType a, b, c;
	init(&a);
	init(&b);
	init(&c);

	int list1[] = { 1,2,5,10,15,20,25 };
	int list2[] = { 3,7,8,15,18,30 };

	
	for (int i = 0; i < sizeof(list1) / sizeof(int); i++) {
		add_last(&a, list1[i]);
	}
	for (int i = 0; i < sizeof(list2) / sizeof(int); i++) {
		add_last(&b, list2[i]);
	}
	
	printf("a :"); display(&a);
	printf("b :"); display(&b);


	merge_list(&a, &b, &c);
	printf("c :"); display(&c);

	
	
}