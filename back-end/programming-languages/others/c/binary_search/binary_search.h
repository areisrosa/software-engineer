#ifndef PROJECT_BINARY_SEARCH_H
#define PROJECT_BINARY_SEARCH_H

// returns index of target value in sorted array, -1 otherwise;
int binaty_search();
// returns index of target value in sorted array, -1 otherwise;
int binaty_search_recursive();

int binaty_search(int target, int numbers[], int size) {
    int low   = 0;
    int high  = size - 1;
    int mid   = 0;

    while (low <= high) {
        mid = (high + low) / 2;

        if (target > numbers[mid]) {
            low  = mid + 1;
        } else if (target < numbers[mid]) {
            high = mid - 1;
        } else {
            return mid;
        }
    }
    return -1;
}

int binary_search_recursive(int targer, int numbers[], int low, int high) {
    if (low > high) {
        return -1;
    }
    int mid = (high + low) / 2;

    if (target > numbers[mid]) {
        return binary_search_recursive(target, numbers, mid+1, high);
    } else if (target < numbers[mid]) {
        return binary_search_recursive(target, numbers, low, mid-1);
    } else {
        return mid;
    }
}
#endif
