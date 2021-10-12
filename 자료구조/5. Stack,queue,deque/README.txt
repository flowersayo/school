Homework 4_1 [Double_linked_stack.cpp]

0. what variables change the results. 
: you can freely add or delete element using function push() and pop()

1. purpose of this code
:  implement all functions in stack using circular doubly linked list

2. function

1)void init(DlistStackType* s)
- input : the address of DlistStackType that want to initialize the value.
- output : set top pointer of the stack NULL

2)int is_empty(DlistStackType* s)
- input :  A DlistStackType to check if the stack is empty or not
- output : If given DlistStackType is empty, return true;

3)void push(DlistStackType* s, element item)
- input : address of DlistStackType, What item you are going to push in stack
- output : creates node with given item and Adds it at the top of the stack

4)element pop(DlistStackType* s)
- input : address of DlistStackType
- output : Deletes the top most element of the DlistStackType

5)element peek(DlistStackType* s)
- input : address of DlistStackType
- output : Returns the element at the top of the stack without removing it.

Homewordk 4_2 [Simulation.cpp]

0. what variables change the results. 
: You are required to input several values required to assume situation.
you can make own your condition to suit your situation by assigning below value.
- duration -> Simulation time
- arrival_prob -> Average number of customers arriving in one time unit
- max_serv_time -> maximum service time for one customer

1. purpose of this code
: Implement bank waiting system where two back staff work.
It notices us when new customers arrive and when bank staff will service the customers.
After duration, It finally gives entire information such as number of customers served, total wait time, average wait time per person
and number of customers still waiting

2. function 

1) double random()
- input : X
- output :  returns random number between 0 and 1

2)int is_empty(QueueType * q)
- input :  address of QueueType
- output : checks if the Queue is empty or not

3)int is_full(QueueType * q)
- input : address of QueueType
- output : checks if the Queue is full or not

4)void enqueue(QueueType * q, element item)
- input : address of QueueType, What item you are going to push in stack
- output : adds the element at the end of the queue (push_back) 

5)element dequeue(QueueType * q)
- input : address of QueueType
- output : deletes the very first element at queue (pop_front)

6) int is_customer_arrived()
- input : X
- output : If a random number generated  is smaller than ‘arrival_prov’, return true;

7) void insert_customer(int arrival_time)
- input : The time when the customer arrives.
- output : Inserts newly arrived customer into queue

8) int remove_customer()
- input : X
- output : Retrieve the customer at the front of the queue and return the customer's service time.

9)void print_stat()
- input : X
- output : Output statistics about bank system from the current clock.
