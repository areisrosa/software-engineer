// Tests
void run_all_tests() {
    test_size_init();
    test_append();
    test_empty();
    test_resize();
    test_at();
    test_insert();
    test_prepend();
    test_pop();
    test_remove();
    test_find_exists();
    test_find_not_exists();
}

void test_size_init() {
    jarray *aptr = jarray_new(5);
    int initial_size = jarray_size(aptr);
    assert(initial_size == 0);
    jarray_destroy(aptr);
}

void test_append() {
    jarray *aptr = jarray_new(2);
    jarray_push(aptr, 2);
    jarray_push(aptr, 12);
    int new_size = jarray_size(aptr);
    assert(new_size == 2);
    jarray_destroy(aptr);
}

void test_resize() {
    jarray *aptr = jarray_new(2);

    int old_capacity = jarray_capacity(aptr);
    assert(old_capacity == 16);

    // forces a resize up
    for (int i = 0; i < 18; ++i) {
        jarray_push(aptr, i + 1);
    }

    assert(jarray_capacity(aptr) == 32);

    // forces a resize down
    for (int j = 0; j < 15; ++j) {
        jarray_pop(aptr);
    }

    assert(jarray_capacity(aptr) == 16);

    jarray_destroy(aptr);
}

void test_empty() {
    jarray *aptr = jarray_new(2);
    bool empty = jarray_is_empty(aptr);
    assert(empty == 1);
    jarray_push(aptr, 1);
    empty = jarray_is_empty(aptr);
    assert(empty == 0);
    jarray_destroy(aptr);
}

void test_at() {
    jarray *aptr = jarray_new(12);
    for (int i = 0; i < 12; ++i) {
        jarray_push(aptr, i + 3);
    }
    assert(jarray_at(aptr, 6) == 9);
    jarray_destroy(aptr);
}

void test_insert() {
    jarray *aptr = jarray_new(5);
    for (int i = 0; i < 5; ++i) {
        jarray_push(aptr, i + 5);
    }
    jarray_insert(aptr, 2, 47);
    assert(jarray_at(aptr, 2) == 47);
    assert(jarray_at(aptr, 3) == 7);
    jarray_destroy(aptr);
}

void test_prepend() {
    jarray *aptr = jarray_new(5);
    for (int i = 0; i < 3; ++i) {
        jarray_push(aptr, i + 1);
    }
    jarray_prepend(aptr, 15);
    assert(jarray_at(aptr, 0) == 15);
    assert(jarray_at(aptr, 1) == 1);
    jarray_destroy(aptr);
}

void test_pop() {
    jarray *aptr = jarray_new(5);
    for (int i = 0; i < 3; ++i) {
        jarray_push(aptr, i + 1);
    }
    assert(aptr->size == 3);
    for (int j = 0; j < 3; ++j) {
        jarray_pop(aptr);
    }
    assert(jarray_is_empty(aptr) == 1);
    jarray_destroy(aptr);
}

void test_remove() {
    jarray *aptr = jarray_new(5);
    jarray_push(aptr, 12);
    jarray_push(aptr, 3);
    jarray_push(aptr, 41);
    jarray_push(aptr, 12);
    jarray_push(aptr, 12);
    jarray_remove(aptr, 12);
    assert(jarray_size(aptr) == 2);
    jarray_destroy(aptr);
}

void test_find_exists() {
    jarray *aptr = jarray_new(5);
    jarray_push(aptr, 1);
    jarray_push(aptr, 2);
    jarray_push(aptr, 3);
    jarray_push(aptr, 4);
    jarray_push(aptr, 5);
    assert(jarray_find(aptr, 1) == 0);
    assert(jarray_find(aptr, 4) == 3);
    assert(jarray_find(aptr, 5) == 4);
    jarray_destroy(aptr);
}

void test_find_not_exists() {
    jarray *aptr = jarray_new(3);
    jarray_push(aptr, 1);
    jarray_push(aptr, 2);
    jarray_push(aptr, 3);
    assert(jarray_find(aptr, 7) == -1);
    jarray_destroy(aptr);
}
