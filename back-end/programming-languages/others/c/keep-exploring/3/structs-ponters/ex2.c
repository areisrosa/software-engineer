#include <stdio.h>

typedef struct reg {
   int cell;
   struct reg *prox;
} cell;

int main (void) {
   printf ("sizeof (cell) = %d\n", sizeof (cell));
    return 0;
}
