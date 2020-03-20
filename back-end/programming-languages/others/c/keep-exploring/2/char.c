#include <stdio.h>

int main(int argc, char *argv[])
{
    unsigned char c;

    printf("The size c (type char) is: %lu bytes / %lu bits\n", sizeof c, sizeof c
            * 8);
    c = 255;
    printf("Value c is: %i\n", c);

    return 0;
}
