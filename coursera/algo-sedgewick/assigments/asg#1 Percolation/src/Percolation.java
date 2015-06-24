   
//Memory: we determine the amount of memory according to the 64-bit memory cost model from lecture.
public class Percolation {
   private boolean[] open;
   private WeightedQuickUnionUF id; // percolate or not?
   private int N;
   private int sinkId;
   private int sourceId = 0;

   // create N-by-N grid, with all sites blocked
   public Percolation(int N) {
         if(N <= 0)
            throw new IllegalArgumentException();

         this.N = N;
         int totalSize = N * N + 2;
         
         this.sinkId = totalSize -1;
         this.open = new boolean[totalSize];
         this.id = new WeightedQuickUnionUF(totalSize);

         for (int i = 0; i < totalSize; i++) 
            this.open[i] = false;
         
         //open source and sink ? top and bottom
         this.open[sourceId] = true;
         this.open[sinkId] = true;
   }


   // Throw a java.lang.IndexOutOfBoundsException if either i or j is outside this range.
   private void validate(int i, int j) {
    // System.out.println("Validate: "+i+":"+j);
      if (i <= 0 || i > N || j <= 0 || j > N)
         throw new IndexOutOfBoundsException();
   }

   // open site (row i, column j) if it is not already
   public void open(int i, int j) {
      validate(i, j);
      int idx = indexOf(i, j);

      if (isOpen(i, j)) 
         return;

      open[idx] = true;
      int left, right, top, bottom;

      if (j > 1) {
         left = indexOf(i, j - 1);
      } else {
         left = -1;
      }
      if (j < N) {
         right = indexOf(i, j + 1);
      } else {
         right = -1;
      }
      if (i > 1) {
         top = indexOf(i -1, j);
      } else {
         top = -1;
      }
      if (i < N) {
         bottom = indexOf(i + 1, j);
      } else {
         bottom = -1;
      }

      //connectinf with left cell
      if (left != -1 && open[left]) id.union(idx, left);
      //connectinf with right cell
      if (right != -1 && open[right]) id.union(idx, right);

      //connectinf with top cell
      if (top != -1 && open[top]) id.union(idx, top);
      else if (top == -1) id.union(sourceId, idx);

      //connectinf with bottom cell
      if (bottom != -1 && open[bottom]) id.union(idx, bottom);
      else if (bottom == -1) id.union(sinkId, idx);

   }

   // is site (row i, column j) open?
   public boolean isOpen(int i, int j) {
      validate(i, j);
      // System.out.println(i +", "+j);
      return open[indexOf(i, j)];

   }

   // is site (row i, column j) full?
   // buggy
   public boolean isFull(int i, int j) {
      validate(i, j);
      // if (!isOpen(i, j)) {
      //    return false;
      // }
      return id.connected(sourceId, indexOf(i, j));
   }

   // does the system percolate?   
   public boolean percolates() {
      return id.connected(sourceId, sinkId);
   }

   private int indexOf(int i, int j) {
      int idOf = (i - 1) * this.N + j;
      // System.out.println("id: " + id + " i: "+ i + " j: " + j);

      return idOf;
   }

   public static void main(String[] args) {
      // In in = new In(args[0]);
      int n = Integer.valueOf(args[0]);
      // int n = Integer.valueOf(in.readInt());
      int i,j = 0;
      Percolation perc = new Percolation(n);
      for (int x = 1; x < n + 1; x++) {
         // i = in.readInt();
         // j = in.readInt();
        int i = x,
            j = 1;
         // StdOut.println(i +" " +j);
         perc.open(i, j);
         if (perc.percolates()) {
            StdOut.println(String.format("Perconaltin %d. Grid: %d x %d", x, n, n));
            break;
         }         
      }
   }

}