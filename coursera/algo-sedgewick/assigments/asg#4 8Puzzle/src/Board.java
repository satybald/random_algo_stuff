import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

public class Board {
    private int[][] blocks;
    private int N;
    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        this.blocks = blocks;
        this.N = blocks.length;
    }
    // board dimension N
    public int dimension() {
        return N;
    }              

    // number of blocks out of place
    public int hamming() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(blocks[i][j] != 0 && matrixIds(i, j) != blocks[i][j]){
                    result++;
                }
            }
        }
        return result;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int ii, jj, num, result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                num = blocks[i][j];
                ii = (int) (num - 1) / N; // natural coords (ii, jj) for number.
                jj = num - ii * N - 1;
                if ((i != ii || j != jj) && blocks[i][j] != 0) {
                    result += Math.abs(i - ii) + Math.abs(j - jj);
                }
            }
        }
        return result;
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
    // a board that is obtained by exchanging two adjacent blocks in the same row
    public Board twin() {
        return null;
    }
    // does this board equal y?
    public boolean equals(Object y) {
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
        int ii = i; int jj = j;
        System.out.println("ii: " + ii + " jj: "+jj);

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