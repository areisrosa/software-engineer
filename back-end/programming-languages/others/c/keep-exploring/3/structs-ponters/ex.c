#include <stdio.h>
#define EXIT_SUCCESS 0

struct ymd {
    int day;
    int month;
    int year; 
}; 

typedef struct ymd date;  // a record date the type ymd

date theEndEvent(date start, int duration) {
    date theEnd;
    theEnd.day = 07;
    theEnd.month = 01;
    theEnd.year = 2020;
    return theEnd;
}

int main (void) {
    date a, b;
    scanf ("%d %d %d", &a.year, &a.month, &a.day);
    // &a.day mean &(a.day)
    int duration;
    scanf ("%d", &duration);
    b = theEndEvent(a, duration);
    printf("%d %d %d\n", b.year, b.month, b.day);
    return EXIT_SUCCESS;
}
