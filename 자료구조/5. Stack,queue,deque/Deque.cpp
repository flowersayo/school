#include <stdio.h>
#include <stdlib.h>


typedef int element;
typedef struct DlistNode {
	element data;
	struct DlistNode* llink;
	struct DlistNode* rlink;
} DlistNode;


typedef struct DequeType {
	DlistNode* head;
	DlistNode* tail;
} DequeType;

bool is_empty(DequeType* dq) {

	return dq->head == NULL;

}
void error(const char* message) { fprintf(stderr, "%s\n", message); exit(1); }

//좌측주소, 우측주소, 아이템값을 주면 그 값으로 노드를 만들어주는 함수
DlistNode* create_node(DlistNode* llink, element item, DlistNode* rlink)
{
	DlistNode* node = (DlistNode*)malloc(sizeof(DlistNode));
	if (node == NULL) error("Memory allocation error");

	//copy and paste
	node->llink = llink;
	node->data = item;
	node->rlink = rlink;
	return node;
}
void add_rear(DequeType* dq, element item)
{
	//노드를 새로만들어 왼쪽은 tail과 연결시키고 오른쪽은 NULL
	DlistNode* new_node = create_node(dq->tail, item, NULL);

	if (is_empty(dq))
		dq->head = new_node;//head갱신
	else
		dq->tail->rlink = new_node; //기존 마지막노드를 현재 마지막노드에 연결

	dq->tail = new_node; //tail갱신(공유)
}

void add_front(DequeType* dq, element item)
{
	DlistNode* new_node = create_node(NULL, item, dq->head); // 새로운 노드의 좌,우 연결 작업공유
	if (is_empty(dq)) // dq가 비어있다면 
		dq->tail = new_node;// tail까지 같이 갱신해주어야함
	else
		dq->head->llink = new_node; // 원래 기존에 있던 front노드의 왼쪽을 새로운front노드로 연결
	dq->head = new_node; //head 갱신(공유)
}

element delete_rear(DequeType* dq)
{
	element item;
	DlistNode* removed_node;
	if (is_empty(dq)) printf("Deque is empty\n");
	else {
		removed_node = dq->tail; // Node to be deleted
		item = removed_node->data; //삭제할 item keep
		dq->tail = dq->tail->llink; // Change tail pointer -> 공유가능! 
		free(removed_node);
		if (dq->tail == NULL) // If empty, after removing the node
			dq->head = NULL; //head를 NULL로 갱신
		else
			dq->tail->rlink = NULL; // 새롭게 갱신된 tail의 우측링크를 풀어줌.
	}
	return item;
}

void add_front(DequeType* dq, element item)
{
	DlistNode* new_node = create_node(NULL, item, dq->head);
	if (is_empty(dq))
		dq->tail = new_node; //tail갱신
	else
		dq->head->llink = new_node; // 기존 front노드의 좌측링크를 새로운 front노드에 연결.
	dq->head = new_node; //head갱신 (공유)
}



int main() {





}
