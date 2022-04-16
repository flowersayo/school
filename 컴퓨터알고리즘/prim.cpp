#include <stdio.h>
#include <stdlib.h>


# define FALSE 0
# define TRUE 1

typedef struct Edge
{
    char v1, v2;
    int weight;
    struct Edge* next;
}Edge;

typedef struct IncidentEdge
{
    char aName;
    Edge* e;
    struct IncidentEdge* next;
}IncidentEdge;

typedef struct Vertex
{
    char vName;
    int isVisit; 
    IncidentEdge* iHead; // 인접한 간선 
    struct Vertex* next;
}Vertex;

typedef struct
{
    Vertex* vHead;
    Edge* eHead;
    int eCount, vCount;
}Graph;

void init(Graph* G)
{
    G->vHead = NULL;
    G->eHead = NULL;
    G->vCount = G->eCount = 0;
}

void makeVertex(Graph* G, char vName)
{
    Vertex* v = (Vertex*)malloc(sizeof(Vertex));
    v->vName = vName;
    v->iHead = NULL;
    v->isVisit = FALSE;
    v->next = NULL;
    G->vCount++;

    Vertex* q = G->vHead;
    if (q == NULL)
        G->vHead = v;
    else
    {
        while (q->next != NULL)
            q = q->next;
        q->next = v;
    }
}

void makeIncidentEdge(Vertex* v, char aName, Edge* e)
{
    IncidentEdge* p = (IncidentEdge*)malloc(sizeof(IncidentEdge));
    p->aName = aName;
    p->e = e;
    p->next = NULL;
    IncidentEdge* q = v->iHead;
    if (q == NULL)
        v->iHead = p;
    else
    {
        while (q->next != NULL)
            q = q->next;
        q->next = p;
    }
}

// 이름이 vName 인 정점 찾기
Vertex* findVertex(Graph* G, char vName)
{
    Vertex* v = G->vHead;
    while (v->vName != vName)
        v = v->next;
    return v;
}

void insertEdge(Graph* G, char v1, char v2, int w)
{
    Edge* e = (Edge*)malloc(sizeof(Edge));
    e->weight = w;
    e->v1 = v1;
    e->v2 = v2;
    e->next = NULL;
    G->eCount++;

    Edge* q = G->eHead;
    if (q == NULL)
        G->eHead = e;
    else
    {
        while (q->next != NULL)
            q = q->next;
        q->next = e;
    }
    Vertex* v = findVertex(G, v1);
    makeIncidentEdge(v, v2, e);
    v = findVertex(G, v2);
    makeIncidentEdge(v, v1, e);
}

void print(Graph* G)
{
    Vertex* p = G->vHead;
    IncidentEdge* q;
    for (; p != NULL; p = p->next)
    {
        printf("[%c] : ", p->vName);
        for (q = p->iHead; q != NULL; q = q->next)
            printf("[%c, %d] ", q->aName, q->e->weight);
        printf("\n");
    }
    printf("\n");
}

char getMinVertex(Graph* G, int D[]) {

    Vertex* p = G->vHead;
    char vName;

    // 아직 방문하지 않은 첫 정점 찾기.
    for (; p != NULL; p=p->next) {
        if (p->isVisit == FALSE) {
            vName = p->vName;
            break;
        }
            
    }

    // D[v] 가 최소인 정점 찾기
    for (p = G->vHead; p != NULL; p = p->next)
        if (p->isVisit == FALSE && D[p->vName - 'a'] < D[vName - 'a'])
            vName = p->vName;

    return vName;
}
void prim(Graph* G, char vName, int D[]) {

    //이름이 vName인 정점찾기
    Vertex* p = findVertex(G, vName);
    IncidentEdge* q;
    char c;

    D[p->vName - 'a'] = 0; // 시작점 거리 0으로 초기화

    for (int i = 0; i < G->vCount; i++) {

        //D[v] 가 최소인 정점 찾기
         c = getMinVertex(G, D);
         p = findVertex(G, c); // 이름이 c인 정점 찾기 

         p->isVisit = TRUE;
         printf("(%c)", p->vName);
         
         // q : 정점 p와 연결되어있는 정점들
         for (q = p->iHead; q != NULL; q = q->next) {
             p = findVertex(G, q->aName);

             if (p->isVisit == FALSE) // 아직 방문하지 않은 정점이라면 
                 D[q->aName - 'a'] = q->e->weight; // 거리 갱신
         }
    }


}
int main()
{
    Graph G;
    init(&G);

    makeVertex(&G, 'a'); makeVertex(&G, 'b'); makeVertex(&G, 'c');
    makeVertex(&G, 'd'); makeVertex(&G, 'e'); makeVertex(&G, 'f');

    insertEdge(&G, 'a', 'b', 3); insertEdge(&G, 'a', 'd', 2);
    insertEdge(&G, 'a', 'e', 4); insertEdge(&G, 'b', 'c', 1);
    insertEdge(&G, 'b', 'd', 4); insertEdge(&G, 'b', 'f', 2);
    insertEdge(&G, 'c', 'f', 1); insertEdge(&G, 'd', 'e', 5);
    insertEdge(&G, 'd', 'f', 7); insertEdge(&G, 'e', 'f', 9);

    print(&G);


    int D[10] = { 100, 100, 100,100,100,100,100,100,100,100 };
    prim(&G, 'c', D);

    return 0;
}
