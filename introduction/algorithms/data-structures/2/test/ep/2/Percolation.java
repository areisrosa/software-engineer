import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
/**
* <p> O metodo proviniente da {#ClassPercolation} calcula o Percolation. </p>
*  
* <p> Criei dois objetos WeightedQuickUnionUF {grid, grid2} para resolver o problema backwash. </p>
* 
* <p> autor: Anderson Reis </p>
*
* <p> data: 20/3/2017 </p>
*/

public class Percolation {

  private int size; // tamanho do "grid"
  private int[] status; // registrar o status para cada "site"
  private WeightedQuickUnionUF grid;
  private WeightedQuickUnionUF grid2;
 

  /** "Creates n-by-n grid, with all sites initially blocked"
   *
   * Inicializa dois objetos WeightedQuickUnionUF. Um tem dois "virtual sites" e o outro tem apenas um "top site". 
   * Define o estado de cada "site" bloqueado.
   * @param n temanho de cada grid
   * @throws IllegalArgumentException se n < 1
  */

  public Percolation(int n) {
      
      if (n < 1) throw new IllegalArgumentException("O tamanho do grid fora do intervalo");
      size = n;
      status = new int[n * n];
      for (int i = 0; i < n * n; i++) status[i] = 0;
      grid = new WeightedQuickUnionUF(n * n + 2);
      grid2 = new WeightedQuickUnionUF(n * n + 1);
  }

  /** "Opens the site (row, col) if it is not open already"
   * @param linha(=row) abscissa do "grid"
   * @param coluna(=col) ordenada do "grid"
  */

  public void open(int row, int col) {
      
      int idx = xyTo1D(row, col);
      validate(row, col);
      status[idx] = 1;
      
      if (1 == row) { // conecta-se ao "virtual site"
          
          grid.union(idx, size * size);
          grid2.union(idx, size * size);
      }
      
      if (size == row) { 
         
          grid.union(idx, size * size + 1);
      }
      
      int[] xDf = {-1, 1, 0, 0};
      int[] yDf = {0, 0, -1, 1};

      for(int i = 0; i < 4; i++) {
          
          int adjX = row + xDf[i];
          int adjY = col + yDf[i];

          if (adjX > 0 && adjX <= size) {
            
              if (adjY > 0 && adjY <= size) {
                  
                  int adjPosIdx = xyTo1D(adjX, adjY);

                  if (1 == status[adjPosIdx]) {

                      grid.union(idx, adjPosIdx);
                      grid2.union(idx, adjPosIdx);
                  }      
              }
          } 
      }
  }

  /* "Is the site (row, col) open?"
   * Se o "site (row, col)" está "open"
   * @return "true", caso contrário @return "false" 
  */

  public boolean isOpen(int row, int col) {
      
      validate(row, col);

      return status[xyTo1D(row, col)] == 1;
  }
  
  /* "Is the site (row, col) full?"
   * Se o "site (row, col)" está "full"
   * @return "true", caso contrário @return "false" 
  */

  public boolean isFull(int row, int col) {
      
      validate(row, col);

      return isOpen(row, col) && grid2.connected(xyTo1D(row, col), size * size);
  }

  /* Returns the number of open sites
  *
  * @return o numero de "sites" abertos
  */

  public int numberOfOpenSites() { 
      
      int sum = 0;
      
      for (int i = 0; i < status.length; i++) sum += status[i];

      return sum;
  }

  /* Does the system percolates?
  *
  * @return "true" se o "grid percolates", caso contrário @return false  
  *
  */

  public boolean percolates() { 
      
      return grid.connected(size * size, size * size + 1);
  }
  
  /* Mapiar coordenadas de 2D para 1D
   * 
  */
  public int xyTo1D(int row, int col) {
      
      return (row - 1) * size + col - 1;
  }

  /* Valida que (row, col) é valido
   * 
  */
  
  public void validate(int row, int col) {
      
      if (row < 1 || row > size || col < 1 || col > size) 
          
          throw new IndexOutOfBoundsException("index: (" + row + ", " + col + ") estão fora do limite");
   }


  /* "Unit testing (required) o {@code Percolation} tipo de dados
  * 
  */

  public static void main(String[] args) {
  
      int n = StdIn.readInt();
      Percolation perc = new Percolation(n);
      
      while (!StdIn.isEmpty()) {
  
          int row = StdIn.readInt();
          int col = StdIn.readInt();
          perc.open(row, col);
          StdOut.println(perc.isOpen(row, col));
          StdOut.println(perc.isFull(row, col));
          StdOut.println(perc.percolates());
      }
  }
}
