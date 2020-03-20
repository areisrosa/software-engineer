#include <stdio.h>
#define EXIT_SUCESS 0

int main (void) {
    typedef struct {
        int day, month, year;
    } date;
    printf("sizeof (date) = %d\n", sizeof (date));
    return EXIT_SUCESS;
}
