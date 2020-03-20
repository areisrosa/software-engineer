#include <stdio.h>
#define EXIT_SUCESS 0

int main (void) {

    int i = 1234, *p = &i;
    printf ("*p = %d\n", *p);
    printf (" p = %ld\n", (long int) p);
    printf ("&i = %p\n", (void *) &i);
    printf (" p = %p\n", (void *) p);
    printf ("&p = %p \n", (void *) &p);

    return EXIT_SUCESS;
}
