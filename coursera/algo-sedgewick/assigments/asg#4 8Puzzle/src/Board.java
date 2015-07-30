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
        return blocks.length;
    }              

    // number of blocks out of place
    public int hamming() {
        int result = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if(blocks[i][j] != 0 && matrixIds(i, j) != blocks[i][j]){
                    result++;
                }
            }
        }
        return result;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int ii, jj, num = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                num = blocks[i][j];
                ii = num / N;
                jj = num - ii * N;
            }
        }

        return 0;
    }   

    private int matrixIds(int i, int j) {
        return blocks.length * i + (j + 1);
    }

    // is this board the goal board?
    public boolean isGoal() {
        return false;
    }
    // a board that is obtained by exchanging two adjacent blocks in the same row
    public Board twin() {
        return null;
    }
    // does this board equal y?
    public boolean equals(Object y) {
        return false;
    }

    // all neighboring boards     
    public Iterable<Board> neighbors() {
        return null;
    }

    public String toString() {
        return "";
    }

    public static void main(String[] args) {

    }
}