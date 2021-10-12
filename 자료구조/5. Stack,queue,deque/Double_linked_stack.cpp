// linked_stack.cpp : Defines the entry point for the console application.
//

//#include "stdafx.h"
#include "stdlib.h"
#include "stdio.h"
#include "string.h"

//Re-implement the functions in the code using circular doubly linked list which is defined as below,
//and then run the main function of the code
typedef int element;

typedef struct DlistNode {
	element data;
	struct DlistNode* llink;
	struct DlistNode* rlink;
} DlistNode;

typedef struct DlistStackType {
	DlistNode* top;

} DlistStackType;

void init(DlistStackType* s)
{
	s->top = NULL;
}

int is_empty(DlistStackType* s)
{
	return (s->top == NULL);
}

void push(DlistStackType* s, element item)
{
	DlistNode* temp = (DlistNode*)malloc(sizeof(DlistNode));
	if (temp == NULL) {
		fprintf(stderr, "Memory allocation error\n");
		return;
	}

	else {
		temp->data = item;

		if (is_empty(s)) {
			temp->rlink = temp;
			temp->llink = temp;
		}

		else {
			

			temp->rlink = s->top->rlink; 
			temp->llink = s->top; 
			s->top->rlink->llink = temp; 
			s->top->rlink = temp; 

		}
		s->top = temp; 
	}

}

element pop(DlistStackType* s)
{
	if (is_empty(s)) {
		fprintf(stderr, "Stack is empty\n");
		exit(1);
	}
	else {

		DlistNode* temp = s->top;
		int item = temp->data;

		if (s->top == s->top->llink) 
		{
			s->top = NULL;
			

		}
		else {
			temp->llink->rlink = temp->rlink; 
			temp->rlink->llink = temp->llink;

			s->top = s->top->llink;
		}


		free(temp);
		return item;
	}
}

element peek(DlistStackType* s)
{
	if (is_empty(s)) {
		fprintf(stderr, "Stack is empty\n");
		exit(1);
	}
	else {
		return s->top->data;
	}
}


void main()
{
	DlistStackType s;
	init(&s);
	push(&s, 1);
	push(&s, 2);
	push(&s, 3);

	printf("%d\n", pop(&s));
	printf("%d\n", pop(&s));
	printf("%d\n", pop(&s));
}




