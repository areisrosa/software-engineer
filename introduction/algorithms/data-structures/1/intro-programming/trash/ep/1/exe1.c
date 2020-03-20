#include <stdio.h>

int func (int A[], int n)
{
    int i = 0, j, number;
    for (j = 2; j <= n; j++)
    {
        int ch = A[j];
        i = j - 1;
        while (i >= 1 && A[i] > ch)
        {
            A[i+1] = A[i];
            i = i - 1;
        }
        A[i+1] = ch;
    }
}

int main(void)
{
    int n, i;
    int A[99];

    printf("Entre com o número de termos do vetor: ");
    scanf("%d", &n);

    for (i = 0; i < n; i++) 
    {
        scanf("%d",&A[i]);
    }
    for(i = 0; i < n; i++) 
    {
        printf("%d ",A[i]);
    }
    return 0;
}
