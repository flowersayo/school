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
ListType list1;

void error(const char* message) {
	fprintf(stderr, "%s\n", message);
	exit(1);
}

bool is_empty(ListType* list) {
	if (list->head == NULL) return true;
	else return false;
}

int get_length(ListType* list) {
	return list->length;
}

void init(ListType* list) {
	list->head = NULL;
	list->tail = NULL;
	list->length = 0;
}


ListNode* get_node_at(ListType* list, int pos) {
	ListNode* tmp_node = list->head;
	if (pos < 0) return NULL;
	for (int i = 0; i < pos; i++) {
		tmp_node = tmp_node->link;
	}
	return tmp_node;
}

void insert_node(ListType* list, ListNode* before, ListNode* new_node) {

	if (list->head == NULL) {
		new_node->link = NULL;
		list->head = new_node;
		list->tail = new_node;
	}
	else {
		if (before == NULL) error((char*)"The preceding node cannot be NULL");
		else {
			new_node->link = before->link;
			before->link = new_node;
		}
	}
}

void add_first(ListType* list, element data) {
	ListNode* new_node = (ListNode*)malloc(sizeof(ListNode));
	new_node->data = data;
	if (list->head == NULL) {
		new_node->link = NULL;
		list->head = list->tail = new_node;
	}
	else {
		new_node->link = list->head;
		list->head = new_node;
	}
	list->length++;
}

void add_last(ListType* list, element data) {
	ListNode* new_node = (ListNode*)malloc(sizeof(ListNode));
	new_node->data = data;
	new_node->link = NULL;

	if (list->tail == NULL) {
		list->head = list->tail = new_node;
	}
	else {

		list->tail->link = new_node;
		list->tail = new_node;
	}
	list->length++;
}

void add_at(ListType* list, int position, element data) {
	ListNode* p;
	
	if ((position >= 1) && (position <= list->length - 1)) {
		ListNode* node = (ListNode*)malloc(sizeof(ListNode));
		if (node == NULL) error((char*)"Memory allocation error");
		node->data = data;
		p = get_node_at(list, position - 1);
		insert_node(list, p, node);
		list->length++;
	}
	else if (position == 0) {
		add_first(list, data);
	}
	else if (position == list->length) {
		add_last(list, data);
	}
}

void remove_node(ListType* list, ListNode* before, ListNode* removed) {
	if (list->head == NULL) {
		printf("The list is blank.\n");
	}
	else {
		if (before == NULL) printf("The preceding node cannot be NULL.\n");
		else {
			before->link = removed->link;
			free(removed);
		}
	}
}

void delete_first(ListType* list) {
	if (!is_empty(list)) {
		ListNode* removed = list->head;
		list->head = removed->link;
		free(removed);
		list->length--;
	}
}

void delete_last(ListType* list) {
	if (!is_empty(list)) {
		ListNode* removed = list->tail;
		ListNode* p = get_node_at(list, list->length - 2);
		list->tail = p;
		p->link = NULL;
		free(removed);
		list->length--;
	}
}

void delete_at(ListType* list, int pos) {
	if (!is_empty(list) && (pos >= 1) && (pos < list->length - 1)) {
		ListNode* p = get_node_at(list, pos - 1);
		ListNode* removed = get_node_at(list, pos);
		remove_node(list, p, removed);
		list->length--;
	}
	else if (!is_empty(list) && pos == 0) {
		delete_first(list);
	}
	else if (!is_empty(list) && pos == list->length - 1) {
		delete_last(list);
	}
}

void display(ListType* list) {
	ListNode* node = list->head;
	printf("(");
	for (int i = 0; i < list->length; i++) {
		printf("%d ", node->data);
		node = node->link;
	}
	printf(")\n");
}

bool is_in_list(ListType* list, element item) {
	ListNode* p;
	p = list->head;
	while ((p != NULL)) {
		if (p->data == item)
			break;
		p = p->link;
	}
	if (p == NULL)return false;
	else return true;
}

element get_entry(ListType* list, int pos) {
	ListNode* p;
	if (pos >= list->length)error("position error");
	p = get_node_at(list, pos);
	return p->data;
}

int main()
{

	init(&list1);
	add_first(&list1, 20);
	add_last(&list1, 30);
	add_first(&list1, 10);
	add_last(&list1, 40);
	add_at(&list1, 2, 70);
	display(&list1);
	delete_at(&list1, 2);
	delete_first(&list1);
	delete_last(&list1);
	display(&list1);
	printf("%s\n", is_in_list(&list1, 20) ==true ? "TRUE" : "FALSE");
	printf("%d\n", get_entry(&list1, 0));

}