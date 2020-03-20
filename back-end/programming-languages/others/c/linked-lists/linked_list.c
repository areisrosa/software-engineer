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

void list_push_bask(LinkedList *list) {}
