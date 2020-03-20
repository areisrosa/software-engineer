// Ordenação por insertion
#include <stdio.h> 

// Função para arranjar um "array" usando ordenação por inserção;
// Tempo de execução é da O(n²) no pior caso, porém
// no melhor caso é de O(1)
void insertion_sort(int a[], int n) 
{ 
    int i, key, j; 

    for (i = 1; i < n; i++) // Tempo de execução O(n) 
    { 
        key = a[i]; 
        j = i-1; 

        /* Desloca os elementos de um "array" a[0..i-1], que são
           maiores do que a "key", para uma posição 
           à frente da sua posição atual. */
        while (j >= 0 && a[j] > key) // Tempo de execução O(n) 
        { 
            a[j+1] = a[j]; 
            j = j-1; 
        } 
        a[j+1] = key; 
    } 
} 

// Função para imprimir um "array" de comprimento n;
void print_array(int a[], int size) 
{ 
    int i; 

    for (i = 0; i < size; i++) {
        printf("%d ", a[i]); 
    } 
} 

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

    insertion_sort(a,n);
    printf("Vetor ordenado segundo o Algoritmo de Inserção: ");
    print_array(a,n);

    return 0; 
} 

