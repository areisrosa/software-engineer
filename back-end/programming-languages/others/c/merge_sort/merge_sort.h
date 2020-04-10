#ifndef PROJECT_MERGE_SORT_H
#define PROJECT_MERGE_SORT_H

// overwrites the original array with merged values.
void merge(int a[], int low, int mid, int high);
// sorts the slice of the given array from index low to index high
void merge_sort(int a[], int low, int high);

#endif
