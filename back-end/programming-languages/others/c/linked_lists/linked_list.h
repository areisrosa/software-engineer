#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

#ifndef PROJECT_LINKED_LIST_H
#define PROJECT_LINKED_LIST_H

struct Node {
    int    data;
    struct Node *next;
};

typedef struct ImplmentationLinkedList {
    struct Node *head;
    struct Node *tail;
} List;

// Creates a new List linked list;
List *list_new();
// Frees memory for given List;
void list_destroy(List *list);
// Returns number of data elements in list;
void list_size(List *list);
// Returns true if list is empty;
bool list_empty(List *list);
// Adds the given value to the front of the list;
void list_push_front(List *list, int value);
// Prints the elements in the list for debugging purposes;
void list_print_debug(List *list);
// Returns the value of the first item in the list;
int list_from(List *list);
// Returns the value of the end item;
int list_back(List *list);
// Removes item at front;
void list_pop_front(List *list);
// Adds an item at the end;
void list_push_back(List *list, int value);
// Removes the item from the end;
void list_pop_back(List *list);
// Insert value at index, so current item at that index is pointed to next in
// new node;
void list_insert(List *list, int index, int value);
// Returns the value of the nth item;
int list_value_at(List *list, int index);
// Removes node at given index
void list_erase(List *list, int index);
// Returns the value of the node at nth position from the end of the list.
// For last item, n=1, for second-to-last, n=2, etc;
int list_value_n_from_end(List *list, int n);
// Reverse the values stored in the list;
void list_reverse(List *list);
// Removes the first item in the list with this value;
void list_remove(List *list, int value);
// Checks to see if given value is valid for memory, and exits if so
void check_address(void *p);

#endif // PROJECT_LINKED_LIST_H


