#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

#ifndef PROJECT_QUEUE_ARRAY_H
#define PROJECT_QUEUE_ARRAY_H

const int QueueCapacity = 5;
const int QueuePositions = QueueCapacity + 1;

typedef struct QueueArrayImplementation {
  int data[QueuePositions];
  int insert;
  int pop;
  int capacity;
} queue;

// creates a new queue
queue * create_queue();
// adds value to queue
void enqueue(queue *q, const int value);
// returns value at front of queue, and removes from queue
const int dequeue(queue *q);
// returns true if queue is empty
bool empty(queue *q);
// returns true if queue is full
bool full(queue *q);
// prints the content of the queue for debugging purposes.
void print_debug(queue *q);
// checks to see if memory provided by malloc is valid and exits if not.
void check_memory(queue * address);

#endif
