#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define MAX_STACK_SIZE 100

typedef int element;
typedef struct {
	element stack[MAX_STACK_SIZE];
	int top;
} StackType;
// Stack initialization
void init(StackType* s)
{
	s->top = -1;
}
int is_empty(StackType* s)
{
	return (s->top == -1);
}
int is_full(StackType* s)
{
	return (s->top == (MAX_STACK_SIZE - 1));
}

void push(StackType* s, element item)
{
	if (is_full(s)) {
		fprintf(stderr, "Stack is full\n");
		return;
	}
	else s->stack[++(s->top)] = item;
}
element pop(StackType* s)
{
	if (is_empty(s)) {
		fprintf(stderr, "Stack is empty\n");
		exit(1);
	}
	else return s->stack[(s->top)--];
}
element peek(StackType* s)
{
	if (is_empty(s)) {
		fprintf(stderr, "Stack is empty\n");
		exit(1);
	}
	else return s->stack[s->top];
}


//return priority of operator
int prec(char op)
{
	switch (op) {
	case '(': case ')': return 0;
	case '+': case '-': return 1;
	case '*': case '/': return 2;
	}
}


void infix_to_postfix(const char exp[])
{
	int i = 0;
	char ch, top_op;
	int len = strlen(exp);
	StackType s;
	init(&s);// Stack initialization 
	for (i = 0; i < len; i++) {
		ch = exp[i];
		switch (ch) {
		case '+': case '-': case '*': case '/': // Operator
		// If the operator priority on the stack is greater than or equal to current operator
			while (!is_empty(&s) && (prec(ch) <= prec(peek(&s)))) //stack top: +  current :-여도 pop
				printf("%c", pop(&s));
			push(&s, ch);
			break;
		case '(':// Left parenthesis
			push(&s, ch);
			break;
		case ')':// Right parenthesis
			top_op = pop(&s);
			// Output until the left parenthesis is encountered 
			while (top_op != '(') {
				printf("%c", top_op);
				top_op = pop(&s);
			}
			break;
		default:// Operand
			printf("%c", ch);
			break;
		}
	}
	while (!is_empty(&s))// Output operators stored on the stack
		printf("%c", pop(&s));
}

void main() {
	infix_to_postfix("(2+3)*4+9");
}
