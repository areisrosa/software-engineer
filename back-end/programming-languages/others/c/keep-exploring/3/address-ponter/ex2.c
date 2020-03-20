#include <stdio.h>
#define EXIT_SUCESS 0

int main (void) {

    int i = 1234;
    printf("i = %d\n", i);
    printf("&i = %ld\n", (long int) &i);
    printf("&i = %p\n", (void *) &i);
    printf("sizeof (i) = %d\n", sizeof (i));

    return EXIT_SUCESS;
}
