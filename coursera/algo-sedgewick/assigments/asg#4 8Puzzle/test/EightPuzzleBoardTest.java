import static org.junit.Assert.assertEquals;

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
		// assertEquals("manhattan", 0, board.manhattan());
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
		// assertEquals("manhattan", 0, board.manhattan());
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
		// assertEquals("manhattan", 0, board.manhattan());
	}	

	// @Test(expected=NoSuchElementException.class) 
	// public void testNPEEn2(){
	// 	// RandomizedQueue<Integer> rq = new RandomizedQueue<>();
	// 	// rq.dequeue();
	// }
}