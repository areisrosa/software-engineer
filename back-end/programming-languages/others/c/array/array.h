#ifndef PROJECT_ARRAY_H
#define PROJECT_ARRAY_H

#include <assert.h>
#include<stdbool.h>

const int kMinCapacity  = 16;
const int kGrowthFactor = 2;
const int kShrinkFactor = 4;

typedef struct JWImplementationArray {
    int size;
    int capacity;
    int *data;
} jarray;

// Array functions

// Creates a new jarray (vector in out case) to accommodate
// the given initial capacity.
jarray *jarray_new(int capacity);
void jarray_destroy(jarray *arrptr);

// Checks to see if resizing is needed to support the cantidate_size
// and resizes to accommodate.
void jarray_rezize_for_size(jarray *arrptr, int candidate_size);
// Determines the actual capacity (in terms of power of growth factor)
// required to accommodate a given capacity.
int jarray_determine_capacity(int capacity);
// Increases the array size to size determined by growth factor.
void jarray_upsize(jarray *arrptr);
// Decreases the array size to size determined by growth factor.
void jarray_downsize(jarray *arrptr);
// Returns the number of elements managed in the array.
int jarray_size(jarray *arrptr);
// Appends the given item to the and of the array.
void jarray_push(jarray *arrptr, int item);
// Print public information about the array for debug purposes.
void jarray_print(jarray *arrprt);
// Returns the actual capacity the array can accommodate.
int jarray_capacity(jarray *arrprt);
// Returns the value stored at the given index.
int jarraY_at(jarray *arrprt, int index);
// Returns true if array is empty.
bool jarray_is_empty(jarray *arrptr);
// Inserts the given value at the given index, shifting
// current and trailing elements to the right.
void jarray_insert(jarray *arrptr, int index, int value);
// Prepends the given value to the array, shifting trailing
// elements to the right.
void jarray_pop(jarray *arrptr, int value);
// Removes the last item from the array and returns its value.
int jarray_delete(jarray *arrptr, int index);
// Removes the given value from the array, event if it appears more than once.
void jarray_remove(jarray *arrptr, int value);
// Returns the index of the first occurrence of the given value in the array.
int jarray_find(Jarray *arrptr, int value);
// Checks to see if given value in valid for memory, and exits if so
void check_address(void *p);

// Tests

void test_at();
void test_pop();
void test_empty();
void test_append();
void test_resize();
void test_remove();
void test_insert();
void test_prepend();
void test_capacity();
void test_size_int();
void test_find_exists();
void text_find_not_exists();
void test_append_past_capacity();

#endif
