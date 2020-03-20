/******************************************************************************
 *  Name:   Anderson Reis  
 *  NetID:  
 *  Precept:  
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 * 
 *  Operating system: Debian 9
 *  Compiler: JDK 8
  editor / IDE: Dr. Java
 *
 *  Have you taken (part of) this course before:
 *  Have you taken (part of) the Coursera course Algorithm, Part I:
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 1: Percolation


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates?
 *****************************************************************************/
Eu modelei a grade NxN como uma grade de matriz booleana unidimensional [], com uma célula extra na parte superior e inferior para representar as linhas superior e inferior virtuais. Se a célula estava aberta, o valor booleano era verdadeiro. Meu array tinha N ^ 2 + 2 elementos. A linha superior virtual era grid [0], a posição (1,1) era grid [0], a posição (N, N) era grid [N-2], e a linha superior virtual era grid [N-1] . Eu escrevi uma função auxiliar gridIndex (i, j) para converter as coordenadas i, j para o índice da grade [].

Eu criei um objeto quickfind com elementos N ^ 2. Quando abri uma célula, verifiquei se as células acima, abaixo, à esquerda e à direita estavam abertas. Se alguma das células estivesse aberta, eu as unia com a célula que eu estava abrindo no momento. Quando desenhada, se a célula estivesse no mesmo objeto quickfind que a linha superior virtual, ela seria considerada cheia. O sistema percolou quando a linha superior virtual estava no mesmo objeto quickfind que a linha inferior virtual.


/******************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for values values of n and T when implementing
 *  Percolation.java with QuickFindUF.java.
 *
 *  To do so, fill in the two tables below. Each table must have 4-10
 *  data points, ranging in time from around 0.25 seconds for the smallest
 *  data point to around 30 seconds for the largest one. Do not include
 *  data points that takes less than 0.1 seconds.
 *****************************************************************************/

(keep T constant) T=1

 n          time (seconds)
------------------------------
250          3.771
500          59.607
1000        1057.842


(keep n constant) T=50

 T          time (seconds)
------------------------------
250          1.617
500          3.27
1000         6.42

/******************************************************************************
 *  Using the empirical data from the above two tables, give a formula 
 *  (using tilde notation) for the running time (in seconds) of
 *  PercolationStats.java as function of both n and T, such as
 *
 *       ~ 5.3*10^-8 * n^5.0 * T^1.5
 *
 *  Recall that with tilde notation, you include both the coefficient
 *  and exponents of the leading term (but not lower-order terms).
 *  Round each coefficient to two significant digits.
 *
 *****************************************************************************/

QuickFindUF running time (in seconds) as a function of n and T:  ~


/******************************************************************************
 *  Repeat the previous two questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 *****************************************************************************/


(keep T constant) T=1

 N          time (seconds)
------------------------------
250         0.032
500         0.076
1000        0.328
2000        1.748


(keep N constant) N=50

 T          time (seconds)
------------------------------
250            0.136
500            0.271
1000           0.518



WeightedQuickUnionUF running time (in seconds) as a function of n and T:  ~ 

 

/**********************************************************************
 *  How much memory (in bytes) does a Percolation object (which uses
 *  WeightedQuickUnionUF.java) use to store an N-by-N grid? Use the
 *  64-bit memory cost model from Section 1.4 of the textbook and use
 *  tilde notation to simplify your answer. Briefly justify your answers.
 *
 *  Include the memory for all referenced objects (deep memory).
 **********************************************************************/

/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/




/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/




/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
