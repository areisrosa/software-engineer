import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


/**
 * <p> A class {@code PercolationStats} independe da performece do experimento, usando 
 * a estrutura de dados Percolation. Em seguida calcula o desvio médio padrão dos resultados. </p>
 *
 * <p> Ele também fornece o método para calcular os intervelos de conviança para eles. </p>
 * 
 * <p> autor: Anderson Reis </p>
 *
 * <p> data: 20/03/2018 <p/>
 */

public class PercolationStats {

  private int trials;
  private double[] threshold;

  /**
   * Perform independent "trials" on an n-by-n grid
   * param n tamanho da "grad" criada
   * param quantidade de "trials" de experiências
   * throws IllegalArgumentException a menos que
   * tanto o tamanho da "grad" e valor de "trials" fora da faixa
   */

  public PercolationStats(int n, int trials) {

    if (n < 1)
      throw new IllegalArgumentException("Grid size out of range");
    if (trials < 1) 
      throw new IllegalArgumentException("value of trials out of range");
    this.trials = trials;
    threshold = new double[trials];

    for (int i = 0; i < trials; i++) {
      Percolation expModel = new Percolation(n);

      while (!expModel.percolates()) {

        int row = StdRandom.uniform(n) + 1;
        int col = StdRandom.uniform(n) + 1;

        expModel.open(row, col);
      }

      threshold[i] = (double)expModel.numberOfOpenSites() / (double)(n*n);
    }
  }

  /**
   * Sample mean of percolation threshold
   * 
   * @return a media da amostra do "percolation threshold"
   */

  public double mean() {

    return StdStats.mean(threshold);
  }


  /**
   * Sample standard deviation of percolation threshold.
   * 
   * @return o desvio padrao da amostra do "percolation threshold"
   */

  public double stddev() {

    return StdStats.stddev(threshold);
  }

  /**
   * Returns the low endpoint of 95% confidence interval.
   * 
   * @return o ponto baixo no intervalo de confianca de 95%.
   */

  public double confidenceLow() {

    return mean() - 1.96*stddev() / Math.sqrt(trials);
  }

  /**
   * Returns the high endpoint of 95% confidence interval.
   * 
   * @return o ponto que está acima do intervalo de confia de 95%.
   */

  public double confidenceHigh() {

    return mean() + 1.96*stddev() / Math.sqrt(trials);
  }


  // Test client (see below)
  public static void main(String[] args) {


    int n, trials;

    n = StdIn.readInt();
    trials = StdIn.readInt();
    PercolationStats perc = new PercolationStats(n, trials);
    StdOut.println("media                   = " + perc.mean());
    StdOut.println("desvio padrao                  = " + perc.stddev());
    StdOut.println("intervalo de confianca de 95% = " + "[" + perc.confidenceLow() + ", " 
        + perc.confidenceHigh() + "]");
  }

}
