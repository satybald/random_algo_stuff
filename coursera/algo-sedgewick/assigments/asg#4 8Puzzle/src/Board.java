import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

public class Board {
    private final int[][] blocks;
    private final int[] block;
    private final int N;

    private int manhattan = -1;
    private int hammington = -1;

    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        this.blocks = blocks;
        this.N = blocks.length;
        this.block = new int[N * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                this.block[j + i * N] = blocks[i][j];
            }
        }
    }
    // board dimension N
    public int dimension() {
        return N;
    }              

    // number of blocks out of place
    public int hamming() {
        if (hammington == -1) {
            hammington = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(blocks[i][j] != 0 && matrixIds(i, j) != blocks[i][j]){
                        hammington++;
                    }
                }
            }
        } 

        return hammington;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        if (manhattan == -1){
            manhattan = 0;
            int ii, jj, num = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    num = blocks[i][j];
                    ii = (int) (num - 1) / N; // natural coords (ii, jj) for number.
                    jj = num - ii * N - 1;
                    if ((i != ii || j != jj) && blocks[i][j] != 0) {
                        manhattan += Math.abs(i - ii) + Math.abs(j - jj);
                    }
                }
            }    
        }
        return manhattan;
    }   

    private int matrixIds(int i, int j) {
        return blocks.length * i + (j + 1);
    }

    // is this board the goal board?
    public boolean isGoal() {
        int ii, jj, num, result = 0; 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                num = blocks[i][j];
                ii = (int) (num - 1) / N; // natural coords (ii, jj) for number.
                jj = num - ii * N - 1;
                if ((i != ii || j != jj) && blocks[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /** a board that is obtained by exchanging two adjacent blocks in the same row
    * http://coursera.cs.princeton.edu/algs4/checklists/8puzzle.html
    * You will use it to determine whether a puzzle is solvable: exactly one of a board and its twin are solvable. 
    * A twin is obtained by swapping two adjacent blocks (the blank does not count) in the same row. 
    * For example, here is a board and its 5 possible twins. Your solver will use only one twin.
    **/
    public Board twin() {
        // Arrays.deepHashCode()
        //swap inverse 
        return null;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board that = (Board) y;
        if (this.blocks.length != that.blocks.length) return false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (this.blocks[i][j] != that.blocks[i][j]) return false;
            }
        }
        return true;
    }

    /* is the initial board solvable?
     * https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
     */
    public boolean isSolvable() {
        System.out.println(initial.blocks);
        return false;
    }

    private int[][] deepCopy(int i, int j, int ii, int jj) {
        int[][] newArray = new int[N][N];
        for (int k = 0; k < N; k++){
            newArray[k] = Arrays.copyOf(blocks[k], blocks[k].length);
        }
        // System.out.println("i: "+i+" j: "+j + " ii: "+ii + " jj: "+jj);
        int temp = newArray[i][j];
        newArray[i][j] = newArray[ii][jj];
        newArray[ii][jj] = temp;
        return newArray;
    }

    // all neighboring boards     
    public Iterable<Board> neighbors() {
        int i, j, ci, cj, num, result = 0; 
        j = 0; i = 0;
        outerloop:
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (blocks[i][j] == 0) {
                    break outerloop;
                }
            }
        }
        final int ii = i; 
        final int jj = j;
        // System.out.println("ii: " + ii + " jj: "+jj);

        return new Iterable<Board>() {
            private ArrayList<Board> board = new ArrayList<>();

            @Override
            public Iterator<Board> iterator() {
                if (ii - 1 >= 0) {
                    int[][] newArr = deepCopy(ii, jj, ii - 1, jj);
                    board.add(new Board(newArr));
                }
                if (ii + 1 < N) {
                    int[][] newArr = deepCopy(ii, jj, ii + 1, jj);
                    board.add(new Board(newArr));
                }
                if (jj - 1 >= 0) {
                    int[][] newArr = deepCopy(ii, jj, ii, jj - 1);
                    board.add(new Board(newArr));
                }
                if (jj + 1 < N) {
                    int[][] newArr = deepCopy(ii, jj, ii, jj + 1);
                    board.add(new Board(newArr));
                }
                return board.iterator();
            }
        };
    }

    private void printBoard(ArrayList<Board> it) {
        for (Board b : it){
            System.out.println(b);
        }
    }

    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (blocks[i][j] != 0)
                    build.append(blocks[i][j] + " ");
                else 
                    build.append("  ");
            }
            build.append("\n");
        }
        return build.toString();
    }

    public static void main(String[] args) {

    }
}