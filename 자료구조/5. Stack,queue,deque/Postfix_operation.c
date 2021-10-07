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

int eval(char exp[])
{
	int op1, op2, value, i = 0;
	int len = strlen(exp);
	char ch;
	StackType s;
	init(&s);
	for (i = 0; i < len; i++) {
		ch = exp[i];
		if (ch != '+' && ch != '-' && ch != '*' && ch != '/') { // Operand
			value = ch - '0'; // char ->int 
			push(&s, value);
		}
		else { //Operator

			//맨위에 두 피연산자 pop해서 op적용한다음 result를 다시 push
			op2 = pop(&s);
			op1 = pop(&s);
			switch (ch) {
			case '+': push(&s, op1 + op2); break;
			case '-': push(&s, op1 - op2); break;
			case '*': push(&s, op1 * op2); break;
			case '/': push(&s, op1 / op2); break;
			}
		}
	}
	return pop(&s); //맨 마지막에 stack에 남아있는값이 연산 결과
}
void main()
{
	int result;
	printf("Postfix expression : 8 2 / 3 – 3 2 * +\n");
	result = eval("82/3-32*+");
	printf("Result: %d\n", result);
}
