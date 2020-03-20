#include <stdio.h> 

// Mesclagem de dois sub "arrays" de a[]; 
// Primeiro sub "array" é um a[l..m];
// Segundo sub "array" é um a[m+1..r]; 
void merge(int a[], int l, int m, int r) 
{ 
    int i, j, k; 
    int n_1 = m - l + 1; 
    int n_2 = r - m; 

    // Criar "arrays" temp
    int b[n_1], c[n_2]; 

    // Copia dados para os arrays b[] temp and c[] */
    for (i = 0; i < n_1; i++) 
        b[i] = a[l + i]; 
    for (j = 0; j < n_2; j++) 
        c[j] = a[m + 1+ j]; 

    // Mescla os "arrays" temp retorna para a[l..r]
    i = 0; // Indice inicial para primeiro sub "array" 
    j = 0; // Indice inicial para segundo sub "array"
    k = l; // Indice inicial para mesclar sub "array"
    while (i < n_1 && j < n_2) 
    { 
        if (b[i] <= c[j]) 
        { 
            a[k] = b[i]; 
            i++; 
        } 
        else
        { 
            a[k] = c[j]; 
            j++; 
        } 
        k++; 
    } 

    // Copie os elementos restante de b[], se houver algum
    while (i < n_1) 
    { 
        a[k] = b[i]; 
        i++; 
        k++; 
    } 

    // Copie os elementos restante de c[], se houver algum
    while (j < n_2) 
    { 
        a[k] = c[j]; 
        j++; 
        k++; 
    } 
} 

    // l está a esquerda do índice e r está a direita do índice do 
    // sub "array" de a para ser classificado
void merge_sort(int a[], int l, int r) 
{ 
    if (l < r) 
    { 
        // O mesmo que (l+r)/2, mas evita "overflow" para
        // grandes l e h 
        int m = l+(r-l)/2; 

        // Ordena o primeira e segunda metade 
        merge_sort(a, l, m); 
        merge_sort(a, m+1, r); 

        merge(a, l, m, r); 
    } 
} 


// Function para imprimir o "array"
void print_array(int a[], int size) 
{ 
    int i; 
    for (i=0; i < size; i++) 
        printf("%d ", a[i]);
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

    merge_sort(a, 0, n-1); 

    printf("Vetor ordenado segundo o Algoritmo Merge: ");
    print_array(a,n); 

    return 0; 
} 


