#include "test.c"
#include <stdlib.h>
#include <stdio.h>

jarray *jarray_new(int capacity) {
    int true_capacity = jarray_determine_capacity(capacity);

    jarray *arr = malloc(sizeof(jarray));
    check_address(arr);

    arr->size = 0;
    arr->capacity = true_capacity;
    arr->data = (int *)malloc(sizeof(int) * true_capacity);
    check_address(arr->data);

    return arr;
}

void jarray_resize_for_size(jarray *arrptr, int candidate_size) {
    if (arrptr->size < candidate_size) {  // growing
        if (arrptr->size == arrptr->capacity) {
            jarray_upsize(arrptr);
        }
    } else if (arrptr->size > candidate_size) {  // shrinking
        if (arrptr->size < arrptr->capacity / kShrinkFactor) {
            jarray_downsize(arrptr);
        }
    }  // will not be equal, if so, will do nothing
}

void jarray_upsize(jarray *arrptr) {
    int old_capacity = arrptr->capacity;
    int new_capacity = jarray_determine_capacity(old_capacity);

    int *new_data = (int *)malloc(sizeof(int) * new_capacity);
    check_address(new_data);

    for (int i = 0; i < old_capacity; ++i) {
        *(new_data + i) = *(arrptr->data + i);
    }

    free(arrptr->data);

    arrptr->data = new_data;
    arrptr->capacity = new_capacity;
}

void jarray_downsize(jarray *arrptr) {
    int old_capacity = arrptr->capacity;
    int new_capacity = arrptr->capacity / kGrowthFactor;

    if (new_capacity < kMinCapacity) {
        new_capacity = kMinCapacity;
    }

    if (new_capacity != old_capacity) {
        int *new_data = (int *)malloc(sizeof(int) * new_capacity);
        check_address(new_data);

        for (int i = 0; i < arrptr->size; ++i) {
            *(new_data + i) = *(arrptr->data + i);
        }

        free(arrptr->data);

        arrptr->data = new_data;
        arrptr->capacity = new_capacity;
    }
}

int jarray_determine_capacity(int capacity) {
    const int kMinInitialCapacity = 1;
    int true_capacity = kMinCapacity;

    if (capacity < kMinInitialCapacity) {
        exit(EXIT_FAILURE);
    }

    while (capacity > true_capacity / kGrowthFactor) {
        true_capacity *= kGrowthFactor;
    }

    return true_capacity;
}

int jarray_size(jarray *arrptr) { return arrptr->size; }

void jarray_destroy(jarray *arrptr) {
    free(arrptr->data);
    free(arrptr);
}

void jarray_push(jarray *arrptr, int item) {
    jarray_resize_for_size(arrptr, arrptr->size + 1);

    *(arrptr->data + arrptr->size) = item;
    (arrptr->size)++;
}

void jarray_print(jarray *arrptr) {
    printf("Size: %d\n", arrptr->size);
    printf("Capacity: %d\n", arrptr->capacity);

    printf("Items:\n");
    for (int i = 0; i < arrptr->size; ++i) {
        printf("%d: %d\n", i, *(arrptr->data + i));
    }

    printf("---------\n");
}

int jarray_capacity(jarray *arrptr) { return arrptr->capacity; }

bool jarray_is_empty(jarray *arrptr) {
    int is_empty = 0;

    if (arrptr->size == 0) {
        is_empty = 1;
    }

    return is_empty;
}

int jarray_at(jarray *arrptr, int index) {
    if (index < 0 || index > arrptr->size - 1) {
        exit(EXIT_FAILURE);
    }

    return *(arrptr->data + index);
}

void jarray_insert(jarray *arrptr, int index, int value) {
    if (index < 0 || index > arrptr->size - 1) {
        exit(EXIT_FAILURE);
    }

    jarray_resize_for_size(arrptr, arrptr->size + 1);

    // shift items to the right

    int end_index = arrptr->size - 1;

    for (int i = end_index + 1; i > index; --i) {
        *(arrptr->data + i) = *(arrptr->data + i - 1);
    }

    // insert item
    *(arrptr->data + index) = value;

    arrptr->size += 1;
}

void jarray_prepend(jarray *arrptr, int value) {
    jarray_insert(arrptr, 0, value);
}

int jarray_pop(jarray *arrptr) {
    if (arrptr->size == 0) {
        exit(EXIT_FAILURE);
    }

    jarray_resize_for_size(arrptr, arrptr->size - 1);

    int popped_value = *(arrptr->data + arrptr->size - 1);
    arrptr->size--;

    return popped_value;
}

void jarray_delete(jarray *arrptr, int index) {
    if (index < 0 || index >= arrptr->size) {
        exit(EXIT_FAILURE);
    }

    jarray_resize_for_size(arrptr, arrptr->size - 1);

    int end_index = arrptr->size - 1;
    for (int i = index; i < end_index; ++i) {
        *(arrptr->data + i) = *(arrptr->data + i + 1);
    }

    (arrptr->size)--;
}

void jarray_remove(jarray *arrptr, int value) {
    for (int i = 0; i < arrptr->size; ++i) {
        int check_value = *(arrptr->data + i);
        if (check_value == value) {
            jarray_delete(arrptr, i);
            i--;  // to recheck the index we just copied data into.
        }
    }
}

int jarray_find(jarray *arrptr, int value) {
    int found_index = -1;

    for (int i = 0; i < arrptr->size; ++i) {
        if (*(arrptr->data + i) == value) {
            found_index = i;
            break;
        }
    }

    return found_index;
}

void check_address(void *p) {
    if (p == NULL) {
        printf("Unable to allocate memory.\n");
        exit(EXIT_FAILURE);
    }
}
