#include <stdio.h>
#include <stdlib.h>


//Linked_stack -> 매 원소를 추가할때마다 새로운 메모리를 할당하므로 stack 크기에 제한이 X

typedef int element;
typedef struct StackNode {
	element item;
	struct StackNode* link;
} StackeNode;

typedef struct {
	StackNode* top;
} LinkedStackType;

int is_empty(LinkedStackType* s)
{
	return (s->top == NULL);
}

void push(LinkedStackType* s, element item)
{
	StackNode* temp = (StackNode*)malloc(sizeof(StackNode));
	if (temp == NULL) {
		fprintf(stderr, "Memory allocation error\n");
			exit(1);
	}
	else {
		temp->item = item;
		temp->link = s->top;
		s->top = temp;
	}
}

element pop(LinkedStackType* s)
{
	if (is_empty(s)) {
		fprintf(stderr, "Stack is empty\n");
		exit(1);
	}
	else {
		StackNode* temp = s->top;
		int item = temp->item;
		s->top = s->top->link;
		free(temp);
		return item;
	}
}

int main() {


	LinkedStackType ls;
	ls.top = NULL;
	
	push(&ls, 3);
	push(&ls, 2);
	push(&ls, 1);

	while (!is_empty(&ls))
	{
		printf("%d " ,pop(&ls));

	}

}