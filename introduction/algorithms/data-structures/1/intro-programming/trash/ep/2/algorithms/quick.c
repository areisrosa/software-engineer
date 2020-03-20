#include <stdio.h> 

// Função para trocar dois elementos 
void swap(int* a, int* b) 
{ 
    int temp = *a; 
    *a = *b; 
    *b = temp; 
} 

// Esta função assume o último elemento como pivot,
// coloca o elemento pivot na sua posição correta
// no "array" classificado e coloca todos os menores
// (menor do que pivot) à esquerda do pivot e todos os
// elementos maiores para a direita do pivot
int partition (int a[], int low, int high) 
{ 
    int pivot = a[high]; // pivot 
    int i = (low - 1); // Índice do menor elemento 

    for (int j = low; j <= high-1; j++) 
    { 
        // Se elemento atual for menor que ou
        // igual ao pivot 
        if (a[j] <= pivot) 
        { 
            i++; // incrementa índice do menor elemento 
            swap(&a[i], &a[j]); 
        } 
    } 
    swap(&a[i + 1], &a[high]); 
    return (i + 1); 
} 

// A função que implementa o QuickSort 
//   a[] --> Matrix a ser classificada, 
//   low --> iniciar o índice, 
//   high --> Final do índice
void quick_sort(int a[], int low, int high) 
{ 
    if (low < high) 
    { 
        // pi é índice particionamento, a[p] é agora 
       // no lugar certo
        int pi = partition(a, low, high); 

        // Separadamente ordena os elementos antes 
        // da parttição e após as parttição
        quick_sort(a, low, pi - 1); 
        quick_sort(a, pi + 1, high); 
    } 
} 

// Function para imprimir um "array"
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

    quick_sort(a, 0, n-1); 

    printf("Vetor ordenado segundo o Algoritmo QuickSort: ");
    print_array(a,n); 

    return 0; 
} 

