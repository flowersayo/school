#include <stdio.h>
#include <stdlib.h>

#define MAZE_SIZE 6
#define MAX_STACK_SIZE 100


// 스택을 사용하는 이유: 이동가능했떤 후보군들을 차례로 스택에 쌓고 DEAD END에 도달하면 
// 가장 최근에 가능성 있었던 경로로 이동하기 위함 (Last in,First out)
// + 이미 멀리 지나온 곳일수록 solution이 될 가능성이 낮기때문 

typedef struct {

	int r; //row
	int c; //col

}element;

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

element here = { 1,0 }, entry = { 1,0 };
char maze[MAZE_SIZE][MAZE_SIZE] = {
{ '1', '1', '1', '1', '1', '1' },
{ 'e', '0', '1', '0', '0', '1' },
{ '1', '0', '0', '0', '1', '1' },
{ '1', '0', '1', '0', '1', '1' },
{ '1', '0', '0', '0', '1', 'x' },
{ '1', '1', '1', '1', '1', '1' },
};


//Q. 방문한 경험이 있는지에 관한 Check는 왜 해야하나? 방문했다면 어짜피 스택에 다시 쌓일일이 없지 않나?
//A. 방문했던 곳을 .으로 체크해놓지 않으면 길이 막혀 그 경로 근처로 돌아갔을때 같은 곳을 또 방문하게 되어 무한루프돔.
void push_loc(StackType* s, int r, int c)
{
	if (r < 0 || c < 0) return; //유효하지 않은 index일경우 (끝에 도달했을 경우)

	if (maze[r][c] != '1' && maze[r][c] != '.') { //길이 막혀있지 않고 방문한 적이 없다면,
		element tmp;
		tmp.r = r;
		tmp.c = c;
		push(s, tmp);
	}
}
void main()
{
	int r, c;
	StackType s;
	init(&s); //s->top=-1로 초기화

	here = entry; //현재위치를 entry로 초기화

	while (maze[here.r][here.c] != 'x') { //목적지에 도착하지 않았다면
		
		//현재위치 갱신
		r = here.r;
		c = here.c;

		maze[r][c] = '.'; // 방문했음을 표시

		//현재위치에서 양옆좌우로 움직일 수 있는지 확인.
		push_loc(&s, r - 1, c); //top
		push_loc(&s, r + 1, c); //bottom
		push_loc(&s, r, c - 1); //left
		push_loc(&s, r, c + 1); //right

		if (is_empty(&s)) { //더이상 이동할수 있는 경로가 없다면
			printf("Fail\n");
			return;
		}
		else
			here = pop(&s); //현재위치 갱신
	}
	printf("Success\n");
}