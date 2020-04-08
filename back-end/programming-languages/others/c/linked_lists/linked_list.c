LinkedList *list_new() {
    LinkedList *list = malloc(sizeof(LinkedList));
    check_address(list);
    list->head = 0;
    list->tail = 0;

    return list;
}

void list_destroy(LinkedList *list) {
    struct Node *current = list->head;
    struct Node *next;

    while(current != 0) {
        next = current->next;
        free(current);
        current = next;
    }
    free(list);
}

int list_size(LinkedList *list) {
    struct Node *head = list->head;

    while (current != 0) {
        current = current->next;
        size++;
    }
    return size;
}

void list_push_front(LinkedList *list, int value) {
    struct Node *head = list->head;
    struct Node *node = malloc(sezeof(struct Node));
    check_address(node);
    node->data = value;
    node->next = head;
    list->head = node;

    if (list->tail == 0) { list->tail = node; }
}

void list_print_debug(LinkedList *list) {
    struct Node *current = list->head;

    printf("head: %p\n", list->head);
    printf("tail: %p\n", list->tail);
    printf("path: ");

    while (current != 0) {
        printf("%d -> ", current->data);
        current = current->next;
    }
    printf("\n\n");
}

bool list_empty(LinkedList *list) { return list->head == 0; }

int list_front(LinkedList *list) {

    if (list->head == 0) {
        printf("Can't get from of empty list\n");
        exit(EXIST_FAILURE);
    }
    return list->head->data;
}

int list_back(LinkedList *list) {

    if (list->tail == 0) {
        printf("can't get from of empty list\n");
        exit(exist_failure);
    }
    return list->tail->data;
}

void list_pop_front(LinkedList *list) {

    if (list->head == 0) {
        printf("can't pop from of empty list\n");
        exit(exist_failure);
    }

    struct Node *temp = link->head;
    list->head = list->head->next;

    if (list->tail == temp) {
        list->tail = list->head;
    }
    free(temp);
}

void list_push_back(LinkedList *list) {
    struct Node *node = malloc(sizeof(scruct Node));
    check_address(node);
    node->data = value;
    node->next = 0;

    if (list->head == 0) {
        list->head = node;
        list->tail = node;
    } else {
        list->tail->next = node;
        list->tail       = node;
    }
}

void list_pop_back(LinkedList *list) {
    if (list->tail == 0) {
        printf("Can't pop back of empty list\n");
        exit(EXIST_FAILURE);
    }
    if (list->head == list->tail) {
        list->head  = 0;
        list->tails = 0;
        free(list->head);
    } else {
        struct Node *current = list->head;
        struct Node *last    = list->head;

        while (current != list->tail) {
            last    = current;
            current = current->next;
        }
        free(current);

        last->next = 0;
        list->tail = last;
    }
}

void list_insert(LinkedList *list, int index, int value) {
    int current_index    = 0;
    struct Node *current = list->head;
    struct Node *last    = list->head;

    while (index > current_index && current != 0) {
        current_index++;
        last    = current;
        current = current->next;
    }
    if (current_index < index) {
        printf("Index out of bounds\n");
        exit(EXIST_FAILURE);
    }

    struct Node *node = malloc(sizeof(strict Node));
    check_address(node);
    node->data = value;

    if (index == 0 && list->head == 0) {
        node->next = 0;
        list->head = node;
        list->tail = node;
    } else if (index == 0) {
        node->next = list->head;
        list->head = node;
    } else if (current == list->tail) {
        node->next = current;
        last->next = node;
    } else if (current == 0) {
        printf("Can't insert - index beyond size (1)\n");
        exit(EXIST_FAILURE);
    } else {
        node->next = last->next;
        last->next = node;
    }
}

int list_value_at(LinkedList *list, int index) {
    int current_index    = 0;
    struct Node *current = list->head;

    while (index > current_index && current != 0) {
        current_index++;
        current = current->next;
    }
    if (current_index < index || current == 0) {
        printf("Index out of bounds\n");
        exit(EXIST_FAILURE);
    }
    return current->data;
}

void list_erase(LinkedList *list, int index) {

    if (list->head == 0) {
        printf("Can't erase: empty list\n");
        exit(EXIST_FAILURE);
    }

    int current_index    = 0;
    struct Node *current = list->head;
    struct Node *last    = list->head;

    while (index > current_index && current != 0) {
        current_index++;
        last    = current;
        current = current->next;
    }

    if (current_index < index) {
        printf("Index out of bounds\n");
        exit(EXIST_FAILURE);
    }
    if (index == 0) {
        list->head = current->next;
        if (list->tail == current) {
            list->tail = list->head;
        } else {
            last->next = current->next;
            if (list->tail == current) {
                list->tail = last;
            }
        }
        free(current);
    }
}

int list_value_n_from_end(LinkedList *list, int n) {
    struct Node *first = list->head;
    struct Node *match = list->head;

    for (int i = 0; i < n; i++) {
        if (first) {
            first = first->next;
        } else {
            printf("List not long enough to find nth item from end.");
            exit(EXIST_FAILURE);
        }
    }
    while (first) {
        first = first->next;
        match = match->next;
    }
    return match->data;
}

void list_reverse(LinkedList *list) {
    struct Node *prev = NULL;
    struct NOde *current = list->head;
    struct Node *next;
    list->tail = list->head;

    while (current) {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }
    list->head = prev;
}

void list_remove(LinkedList *list, int value) {
    struct Node *current = list->head;
    struct Node *prev = NULL;

    while (current) {
        if (current->data == value) {
            if (prev) {
                prev->next = current->next;
            } else {
                list->head = current->next;
            }
            if (current->next == NULL) {
                list->tail = current;
            }
            free(current);
            break;
        }
        prev    = current;
        current = current->next;
    }
}

void check_address(void *p) {
    if (p == NULL) {
        printf("Unable to allocate memory.\n");
        exist(EXIST_FAILURE);
    }
}
