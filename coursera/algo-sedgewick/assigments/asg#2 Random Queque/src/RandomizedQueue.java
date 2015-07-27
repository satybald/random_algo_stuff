import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 *  Randomized queue. A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly 
 *  public class RandomizedQueue<Item> implements Iterable<Item> {
 *   public RandomizedQueue()                 // construct an empty randomized queue
 *   public boolean isEmpty()                 // is the queue empty?
 *   public int size()                        // return the number of items on the queue
 *   public void enqueue(Item item)           // add the item
 *   public Item dequeue()                    // delete and return a random item
 *   public Item sample()                     // return (but do not delete) a random item
 *   public Iterator<Item> iterator()         // return an independent iterator over items in random order
 *   public static void main(String[] args)   // unit testing
 *   }
 *   Throw a NullPointerException if the client attempts to add a null item;
 *   throw a java.util.NoSuchElementException if the client attempts to sample or dequeue an item from 
 *   throw an UnsupportedOperationException if the client calls the remove() method in the iterator;
 *   throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there 
 *
 *  Your randomized queue implementation must support each randomized queue operation (besides creating an iterator) in constant amortized time and 
 *
 *  That is, any sequence of M randomized queue operations (starting from an empty queue) should take at most cM steps in c.
 *  Additionally, your iterator implementation must support construction in time linear in the number of items and it must 
 *  you may use a linear amount of extra memory per iterator. The order of two or more iterators to the same randomized queue should be 
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] arrays;
    private int size = 0; //Current number of non-empty el in array

    private int getArLenght() {
        return arrays.length;
    }

    private void resize(int N, Item[] oldArray) {
        // printArray("Old array, resize: "+N, oldArray);
        // printArray("arrays, size: "+size, arrays);
        Item[] copy = (Item[]) new Object[N];

        for (int i = 0; i < size; i++) {
            copy[i] = oldArray[i];
        }

        this.arrays = copy;
        // printArray("New array, pSize: "+N,arrays);
    }

   // construct an empty randomized queue
    public RandomizedQueue() {
        arrays = (Item[]) new Object[2];
    } 

    // is the queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException("NPE enqueue");
        if (size == arrays.length) resize(2*arrays.length, this.arrays);
        arrays[size++] = item;
    }

    // delete and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("No Such Element");
        int randomIdx = StdRandom.uniform(size);
        Item it = arrays[randomIdx];
        // Swap Array
        if (randomIdx != size - 1) arrays[randomIdx] = arrays[size - 1];
        //Shrink Array
        if (size == arrays.length/4 && size > 0) resize(arrays.length/4, arrays);
        size--;
        return it;
    }

    private void printArray(String text, Item[] pArray) {
        int k = pArray.length;
        StdOut.print(text + " Size: "+k+", {");
        for (int i = 0; i < k; i++) {
            StdOut.print(pArray[i] + ", ");
        }
        StdOut.println("}");
    }

    // return (but do not delete) a random item
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("No Such Element");
        int random = StdRandom.uniform(size);
        return arrays[random];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        
        return new Iterator<Item>() {
            private int i = 0;
            @Override
            public boolean hasNext() {
                return i != size;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                return arrays[i++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // unit testing
    public static void main(String[] args) {
        RandomizedQueue<String> q = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on stack)");


    }
}