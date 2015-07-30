import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Assert;
import java.util.NoSuchElementException;



public class EightPuzzleBoardTest{

	@Test
	public void testEnque1(){
		int[][] array = {
			{1,2,3},
			{4,5,6},
			{7,8,0}
		};
		Board board = new Board(array);

		assertEquals("hamington", 0, board.hamming());
		assertEquals("manhattan", 0, board.manhattan());
	}

	@Test
	public void testEnque2(){
		int[][] array = {
			{7,8,0},
			{4,5,6},
			{1,2,3}
		};
		Board board = new Board(array);

		assertEquals("hamington", 5, board.hamming());
		assertEquals("manhattan", 10, board.manhattan());
	}

	@Test
	public void testEnque3(){
		int[][] array = {
			{4,5,6},
			{7,8,0},
			{1,2,3}
		};
		Board board = new Board(array);

		assertEquals("hamington", 8, board.hamming());
		assertEquals("manhattan", 11, board.manhattan());
	}

	@Test
	public void testEnque4(){
		int[][] array = {
			{8,  1,  3},
			{4,  0,  2},
			{7,  6,  5}
		};
		Board board = new Board(array);

		assertEquals("hamington", 5, board.hamming());
		assertEquals("manhattan", 10, board.manhattan());
	}	

	@Test
	public void testEnque5(){
		int[][] array = {
			{8,  1,  3},
			{4,  0,  2},
			{7,  6,  5}
		};
		Board board = new Board(array);

		assertFalse(board.isGoal());
	}	

	@Test
	public void testEnque6(){
		int[][] array = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 0}
		};
		Board board = new Board(array);

		assertTrue(board.isGoal());
	}	

	@Test
	public void testEnque7(){
		int[][] array = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 0}
		};
		Board board = new Board(array);

		assertEquals("toString() ", "1 2 3 \n4 5 6 \n7 8   \n", board.toString());
	}	

	@Test
	public void testEnque8(){
		int[][] array = {
			{1, 0, 3},
			{4, 2, 5},
			{7, 8, 6}
		};
		Board board = new Board(array);

		assertEquals("toString() ", "1   3 \n4 2 5 \n7 8 6 \n", board.toString());
	}	

	// @Test
	// public void testEnque9(){
	// 	int[][] array = {
	// 		{1, 0, 3},
	// 		{4, 2, 5},
	// 		{7, 8, 6}
	// 	};
	// 	Board board = new Board(array);

	// 	for (Board b : board.neighbors()){
	// 		System.out.println(b);
	// 	}
	// }	

	@Test
	public void testEnque9(){
		int[][] array = {
			{1, 2, 3},
			{4, 0, 5},
			{7, 8, 6}
		};
		Board board = new Board(array);

		for (Board b : board.neighbors()){
			System.out.println(b);
		}
	}	
	
	@Test
	public void testEnque10(){
		int[][] array1 = {{1, 2, 3}, {4, 0, 5},{7, 8, 6}};
		int[][] array2 = {{1, 2, 3}, {4, 0, 5},{7, 8, 6}};
		Board board = new Board(array1);
		Board board2 = new Board(array2);
		assertTrue(board.equals(board2));
	}	
	
	@Test
	public void testEnque11(){
		int[][] array1 = {{2, 1, 3}, {4, 0, 5},{7, 8, 6}};
		int[][] array2 = {{1, 2, 3}, {4, 0, 5},{7, 8, 6}};
		Board board = new Board(array1);
		Board board2 = new Board(array2);
		assertFalse(board.equals(board2));
	}
}