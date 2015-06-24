
public class PercolationStats {
    private double mean;
    private double stddev;
    private double confidenceLo;
    private double confidenceHi;

// Initialize all sites to be blocked.
// Repeat the following until the system percolates:
// Choose a site (row i, column j) uniformly at random among all blocked sites.
// Open the site (row i, column j).
// The fraction of sites that are opened when the system percolates provides an estimate of the percolation threshold.
    
    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) 
            throw new IllegalArgumentException();

        double[] percolateAt = new double[T];
        for (int i = 0; i < percolateAt.length; i++) {
            percolateAt[i] = experiment(N);
        }

        //Bunch of Experiments
        this.mean = StdStats.mean(percolateAt);
        this.stddev = StdStats.stddev(percolateAt);
        this.confidenceLo = this.mean - 1.96 * this.stddev / Math.sqrt(T);
        this.confidenceHi = this.mean + 1.96 * this.stddev / Math.sqrt(T);


    }
   // sample mean of percolation threshold
    public double mean() {
        return this.mean;
    }
    // sample standard deviation of percolation threshold  
    public double stddev() {
        return this.stddev;
    }

    // returns lower bound of the 95% confidence interval               
    public double confidenceLo() {
        return this.confidenceLo;
    }
    // returns upper bound of the 95% confidence interval             
    public double confidenceHi() {
        return this.confidenceHi;
    }

    private double experiment(int n) {
        Percolation perc = new Percolation(n);
        int openSites = 0,
            i = 0, 
            j = 0;

        while (!perc.percolates()) {
            i = StdRandom.uniform(n);
            j = StdRandom.uniform(n);
            if (!perc.isOpen(i + 1, j + 1)) {
                perc.open(i + 1, j + 1);
                openSites++;
            }
        }

        return ((double) openSites) / (n * n);
    }

    // test client, described below           
    public static void main(String[] args) {
        int firstArg = Integer.parseInt(args[0]);
        int secondArg = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(firstArg, secondArg);


        StdOut.print(stats.mean());
        StdOut.print(stats.stddev());
        StdOut.printf("%f, %f", stats.confidenceLo, stats.confidenceHi);

    }
}