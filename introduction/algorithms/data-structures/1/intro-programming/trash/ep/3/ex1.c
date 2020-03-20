#include <stdio.h>

int natural(int n, int v[]) 
{
    if (v[0] == 0) {
        return v[0];
    }
    else {
        int rec;
        rec = natural(n-1, v);
        return rec;
    }
}

int main(void) {

    int n, v[1000];

    printf("Digite um número n: ");
    scanf("%d", &n);
    printf("Impressão dos número pedidos: %d", natural(n,v));
    printf("\n");
}
