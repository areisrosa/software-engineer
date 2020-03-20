#include <stdio.h>

int max (int n, int v[]) 
{
   if (n == 1) 
      return v[0];
   else {
      int m;
      m = max (n-1, v);
      if (m > v[n-1]) 
         return m;
      else 
         return v[n-1]; 
   }
}

int main(void) {
    int n, i, v[99];

    printf("Entre com o número de termos do vetor: ");
    scanf("%d", &n);

    for (i = 0; i < n; ++i) 
    {
        scanf("%d",&v[i]);
    }

    printf("%d", max(n,v));

    return 0;
}
