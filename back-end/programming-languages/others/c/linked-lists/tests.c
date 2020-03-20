void run_all_tests() {
  test_size();
  test_back();
  test_front();
  test_empty();
  test_erase();
  test_insert();
  test_remove();
  test_reverse();
  test_pop_back();
  test_value_at();
  test_push_back();
  test_pop_front();
  test_push_front();
  test_reverse_empty();
  test_reverse_single();
  test_value_n_from_end();
}

void test_size() {
  int size = 0;

  // empty

  List *tester = list_new();
  size = list_size(tester);
  assert(size == 0);

  // non-empty

  list_push_front(tester, 12);
  assert(list_size(tester) == 1);

  list_destroy(tester);
}

void test_push_front() {
  List *tester = list_new();
  assert(list_size(tester) == 0);
  // list_print_debug(tester);

  list_push_front(tester, 6);
  assert(list_size(tester) == 1);

  // list_print_debug(tester);

  list_push_front(tester, 11);
  list_push_front(tester, 45);
  assert(list_size(tester) == 3);

  // list_print_debug(tester);

  list_destroy(tester);
}

void test_empty() {
  List *tester = list_new();
  assert(list_empty(tester) == 1);

  list_push_front(tester, 63);
  assert(list_empty(tester) == 0);

  list_push_front(tester, 3);
  assert(list_empty(tester) == 0);

  list_destroy(tester);
}

void test_front() {
  List *tester = list_new();
  list_push_front(tester, 121);
  assert(list_front(tester) == 121);

  list_push_front(tester, 44);
  assert(list_front(tester) == 44);

  list_destroy(tester);
}

void test_back() {
  List *tester = list_new();

  list_push_front(tester, 121);
  assert(list_back(tester) == 121);

  list_push_front(tester, 44);
  assert(list_back(tester) == 121);

  list_destroy(tester);
}

void test_pop_front() {
  List *tester = list_new();

  list_push_front(tester, 50);
  list_push_front(tester, 100);

  assert(list_front(tester) == 100);

  list_pop_front(tester);
  assert(list_front(tester) == 50);

  list_destroy(tester);
}

void test_push_back() {
  List *tester = list_new();

  list_push_front(tester, 99);
  list_push_front(tester, 13);
  assert(list_back(tester) == 99);

  list_push_back(tester, 500);
  assert(list_back(tester) == 500);

  list_destroy(tester);
}

void test_pop_back() {
  List *tester = list_new();

  list_push_back(tester, 16);
  list_push_back(tester, 84);
  assert(list_back(tester) == 84);

  list_pop_back(tester);
  assert(list_back(tester) == 16);
  assert(list_size(tester) == 1);

  list_push_back(tester, 100);
  list_push_back(tester, 200);
  assert(list_size(tester) == 3);

  list_pop_back(tester);
  assert(list_back(tester) == 100);
  assert(list_size(tester) == 2);

  list_pop_back(tester);
  list_pop_back(tester);
  assert(list_empty(tester));

  list_destroy(tester);
}

void test_value_at() {
  List *tester = list_new();

  list_push_back(tester, 1);
  list_push_back(tester, 2);
  list_push_back(tester, 3);

  assert(list_value_at(tester, 0) == 1);
  assert(list_value_at(tester, 1) == 2);
  assert(list_value_at(tester, 2) == 3);

  list_destroy(tester);
}

void test_insert() {
  List *tester = list_new();

  list_insert(tester, 0, 5);
  assert(list_size(tester) == 1);
  assert(list_value_at(tester, 0) == 5);

  list_insert(tester, 0, 3);
  assert(list_value_at(tester, 0) == 3);
  assert(list_value_at(tester, 1) == 5);

  list_insert(tester, 1, 4);
  assert(list_value_at(tester, 0) == 3);
  assert(list_value_at(tester, 1) == 4);
  assert(list_value_at(tester, 2) == 5);

  list_push_front(tester, 20);
  list_push_front(tester, 10);

  list_insert(tester, 2, 2);
  assert(list_value_at(tester, 2) == 2);
  assert(list_value_at(tester, 3) == 3);

  list_destroy(tester);
}

void test_erase() {
  List *tester = list_new();

  list_push_front(tester, 5);
  list_erase(tester, 0);

  assert(list_size(tester) == 0);

  list_push_back(tester, 1);
  list_push_back(tester, 2);

  list_erase(tester, 0);
  assert(list_value_at(tester, 0) == 2);

  list_push_back(tester, 3);

  list_erase(tester, 1);

  assert(list_value_at(tester, 0) == 2);

  list_push_back(tester, 3);
  list_push_back(tester, 4);

  list_erase(tester, 2);
  assert(list_value_at(tester, 1) == 3);

  list_destroy(tester);
}

void test_value_n_from_end() {
  List *tester = list_new();

  list_push_back(tester, 123);
  list_push_back(tester, 623);
  list_push_back(tester, 987);
  list_push_back(tester, 629);
  list_push_back(tester, 812);
  list_push_back(tester, 238);

  assert(list_value_n_from_end(tester, 4) == 987);
  assert(list_value_n_from_end(tester, 2) == 812);
  assert(list_value_n_from_end(tester, 6) == 123);

  list_destroy(tester);

  // test with single item list

  List *tester2 = list_new();

  list_push_back(tester2, 999);
  assert(list_value_n_from_end(tester2, 1) == 999);

  list_destroy(tester2);
}

void test_reverse() {
  List *tester = list_new();

  list_push_back(tester, 2);
  list_push_back(tester, 3);
  list_push_back(tester, 5);
  list_push_back(tester, 8);
  list_push_back(tester, 11);

  list_reverse(tester);

  assert(list_value_at(tester, 0) == 11);
  assert(list_value_at(tester, 1) == 8);
  assert(list_value_at(tester, 2) == 5);
  assert(list_value_at(tester, 3) == 3);
  assert(list_value_at(tester, 4) == 2);

  list_destroy(tester);
}

void test_reverse_single() {
  List *tester = list_new();

  list_push_back(tester, 2);

  list_reverse(tester);

  assert(list_value_at(tester, 0) == 2);

  list_destroy(tester);
}

void test_reverse_empty() {
  List *tester = list_new();

  // if there was an uncovered case this would blow up
  list_reverse(tester);

  list_destroy(tester);
}

void test_remove() {
  List *tester = list_new();

  list_push_back(tester, 2);
  list_push_back(tester, 4);
  list_push_back(tester, 6);

  list_remove(tester, 6);
  assert(list_size(tester) == 2);
  assert(list_value_at(tester, 0) == 2);
  assert(list_value_at(tester, 1) == 4);

  list_remove(tester, 2);
  assert(list_size(tester) == 1);
  assert(list_value_at(tester, 0) == 4);

  list_remove(tester, 4);
  assert(list_size(tester) == 0);

  list_destroy(tester);
}
