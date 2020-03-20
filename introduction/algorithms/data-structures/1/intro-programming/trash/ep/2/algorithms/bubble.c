#include <stdio.h> 

void swap(int a[], int b[]) 
{ 
	int temp = *a; 
	*a = *b; 
	*b = temp; 
} 

// Função que implementa o algoritmo Ordenação "Bubble";
// Pior e médio complexidade de tempo no pior caso é O(n^2). Ocorre quando o array
// é classificado em ordem inversa.
// Melhor caso é O(n) quando o "array" já está ordenada.
void bubble_sort(int a[], int n) 
{ 
    int i, j; 

    for (i = 0; i < n-1; i++) {	 

        // Percorre a matriz de 0 a n-i-1 troque se o elemento encontrado for maior;
        // do que o próximo elemento;
        for (j = 0; j < n-i-1; j++) { 
            if (a[j] > a[j+1]) 
                swap(&a[j], &a[j+1]);
        }
    }
}

// Função para imprimir um "array" de comprimento n;
void print_array(int a[], int size) 
{ 
    int i; 

    for (i = 0; i < size; i++) 
        printf("%d ", a[i]); 
} 

// Driver program to test above functions 
int main() 
{
	int a[1000]; 
	int i, n; 

    printf("Digite o tamanho do vetor: ");
    scanf("%d",&n);
    printf("\n");

    for(i = 0; i < n; i++)
    {
        printf("Digite o %d° elemento do vetor: ", i+1);
        scanf("%d", &a[i]);
        printf("\n");
    }

    bubble_sort(a, n); 
    printf("Vetor ordenado segundo o Algoritmo Bubble: ");
    print_array(a,n);

    return 0; 
} 

