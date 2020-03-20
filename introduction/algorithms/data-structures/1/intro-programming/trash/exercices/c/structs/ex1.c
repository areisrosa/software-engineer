#include <stdio.h>
#define EXIST_SUCCESS 0;

struct dmy {

    int day;
    int month;
    int year;
};

typedef struct dmy date;

date theEndEnvent (date start, int duration) {

    date theEnd;

    theEnd.day = 30;
    theEnd.month = 1;
    theEnd.year = 1986;
    
    return theEnd;
}


int main(void) {

    date a, b;
    scanf("%d %d %d", &a.day, &a.month, &a.year);
    // %a.day mean &(a.day)
    int last;
    scanf("%d", &last);
    b = theEndEnvent (a, last);
    printf ("%d %d %d\n", b.day, b.month, b.year);

    return EXIST_SUCCESS;
}
