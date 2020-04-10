#include <stdbool.h>

#ifndef PROJECT_TEST_SORT_H
#define PROJECT_TEST_SORT_H

// tests that given list of integers is in sorted order;
bool is_sorted(int* numbers, int count);
// prints all integers in the given array;
void print_ints(int numbers[], int count);
// returns true if both arrays contain the same elements, regardless of order.
bool contain_same_ints(int a1[], int a2[], int count);

#endif
