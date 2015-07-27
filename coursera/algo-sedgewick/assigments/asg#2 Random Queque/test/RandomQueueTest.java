import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Assert;
import java.util.NoSuchElementException;



public class RandomQueueTest{

	// @Test
	// public void testEnque(){
	// 	RandomizedQueue<Integer> rq = new RandomizedQueue<>();
	// 	Integer[] testArray = {1,2,3};
	// 	Integer[] expectedArray = {1,2,3,null,null,null,null,null,null,null};
	// 	rq.enqueue(1);
	// 	rq.enqueue(2);
	// 	rq.enqueue(3);
	// 	rq.resize(10, testArray);


	// 	assertEquals("size", 3, rq.size());
	// 	assertEquals("ar size", 10, rq.getArLenght());
	// 	Assert.assertArrayEquals(expectedArray, rq.arrays);
	// }

	@Test
	public void testEnque3(){
		RandomizedQueue<Integer> rq = new RandomizedQueue<>();
		rq.enqueue(2);
		rq.enqueue(2);
		rq.enqueue(1);

		assertEquals("size", 3, rq.size());
		// assertEquals("arN", 4, rq.getArLenght());
	}

	// @Test
	// public void testEnque4(){
	// 	RandomizedQueue<Integer> rq = new RandomizedQueue<>();
	// 	rq.enqueue(1);
	// 	rq.enqueue(2);
	// 	rq.enqueue(3);
	// 	rq.enqueue(4);
	// 	rq.enqueue(5);

	// 	Integer[] expectedArray = {1,2,3,4,5,null,null,null};

	// 	Assert.assertArrayEquals(expectedArray, rq.arrays);
	// 	assertEquals("size", 5, rq.size());
	// 	// assertEquals("arN", 8, rq.getArLenght());
	// }

	// @Test
	// public void testEnque5(){
	// 	RandomizedQueue<String> rq = new RandomizedQueue<>();
	// 	rq.enqueue("AA");
	// 	rq.enqueue("BB");
	// 	rq.enqueue("BC");
	// 	rq.enqueue("BD");
	// 	rq.enqueue("BF");
	// 	rq.enqueue("BH");
	// 	rq.enqueue("BJ");
	// 	rq.enqueue("BK");

	// 	String[] expectedArray = {"AA", "BB", "BC", "BD", "BF", "BH","BJ", "BK"};

	// 	Assert.assertArrayEquals(expectedArray, rq.arrays);
	// 	assertEquals("size", 8, rq.size());
	// 	assertEquals("arN", 8, rq.getArLenght());
	// }

	@Test
	public void testEnque6(){
		RandomizedQueue<Integer> rq = new RandomizedQueue<>();
		rq.enqueue(1);
		rq.enqueue(2);
		rq.dequeue();
		rq.enqueue(3);
		rq.enqueue(4);
		rq.enqueue(5);
		rq.dequeue();

		// Integer[] expectedArray = {1,3,4,null};
		Integer k = (Integer)null;
		// Assert.assertArrayEquals(expectedArray, rq.arrays);
		// assertEquals("arN", k, rq.arrays[3]);
		// assertEquals("arN", 4, rq.getArLenght());
		assertEquals("size", 3, rq.size());
	}



	@Test
	public void testResize(){
		RandomizedQueue<Integer> rq = new RandomizedQueue<>();
		rq.enqueue(2);
		rq.enqueue(1);

		assertEquals("size must be equal 2", 2, rq.size());
	}

	@Test(expected=NullPointerException.class) 
	public void testNPE(){
		RandomizedQueue<Integer> rq = new RandomizedQueue<>();
		rq.enqueue(null);
	}

	@Test(expected=NoSuchElementException.class) 
	public void testNPEEn(){
		RandomizedQueue<Integer> rq = new RandomizedQueue<>();
		rq.enqueue(1);
		rq.dequeue();
		rq.dequeue();
	}

	@Test(expected=NoSuchElementException.class) 
	public void testNPEEn2(){
		RandomizedQueue<Integer> rq = new RandomizedQueue<>();
		rq.dequeue();
	}

	@Test(expected=NoSuchElementException.class) 
	public void testNPEEn2(){
		RandomizedQueue<Integer> rq = new RandomizedQueue<>();
		rq.sample();
	}
}