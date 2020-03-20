#include <stdio.h>
#include <stdbool.h>

int main(void) {

    bool b; // typing in the terminal ($>_): 
            // view /usr/lib/gcc/x86_64-linux-gnu/8/include/stdbool.h

    printf("The size b (boll) is: %lu\n", sizeof b);

    b = true;

    printf("The value b is: %i\n", b);

    return 0;
}
