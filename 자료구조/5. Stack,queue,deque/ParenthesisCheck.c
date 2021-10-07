#include <stdio.h>
#include <stdlib.h>



int check_matching(char* in)
{
	StackType s;
	char ch, open_ch;
	int i, n = strlen(in);
	init(&s);
	for (i = 0; i < n; i++) {
		ch = in[i];
		switch (ch) {
		case '(': case '[': case '{': //왼쪽괄호를 만나면
			push(&s, ch); //일단 넣음
			break;
		case ')': case ']': case '}': //오른쪽 괄호를 만나면
			if (is_empty(&s)) return FALSE;
			else {
				open_ch = pop(&s); //맨위에서 pop한 것과 일치하지 않으면 false.
				if ((open_ch == '(' && ch != ')') ||
					(open_ch == '[' && ch != ']') ||
					(open_ch == '{' && ch != '}')) {
					return FALSE;
				}
				break;
			}
		}
	}
	if (!is_empty(&s)) return FALSE; //문장이 다끝났는데도 괄호가 남아있다면 (짝이 안맞는 괄호 존재)
	return TRUE;
}
int main()
{
	if (check_matching("{ A[(i+1)]=0; }") == TRUE)
		printf(“Success\n");
	else
			printf(“Fail\n");
}
