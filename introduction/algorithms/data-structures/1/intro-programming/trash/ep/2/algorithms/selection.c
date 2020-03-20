#include <stdio.h>

// Função que troca posições dos elementos do "array" a[0...n];
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Algoritmo "Select Sort"
// Tempo de execução do Algoritmo O(n²) no pior caso;
// Tempo no melhor caso O(1);
// Obs.: Uma coisa boa deste algoritmo bom é que ele nunca faz mais que O(n) trocas, e pode ser útil quando a gravação de memória é uma operação dispendiosa.
void selection_sort(int a[], int n)
{
    int i, j, min;
    // Percorrer os sub "array" de a[0...n];
    for (i = 0; i < n-1; i++) { // Tempo de execução primeiro laço O(n);
        min = i;
        for(j = i+1; j < n; j++) { // Tempo de execução segundo laço O(n);
            if(a[j] < a[min])
                min = j;
            // Troca o elemento mínimo encontrado com primeiro elemento;
            swap(&a[min],&a[i]);
        }

    }
}

// Função para imprimir um "array".
void print_array(int a[], int size) 
{
    int i;

    for(i = 0; i < size; i++)
        printf("%d ",a[i]);
        printf("\n");
}

int main(void) 
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

    selection_sort(a,n);
    printf("Vetor ordenado: ");
    print_array(a,n);
 
    return 0;
}
