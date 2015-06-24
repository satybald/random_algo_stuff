import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *  Randomized queue. A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random from items in the data structure.
 *  public class RandomizedQueue<Item> implements Iterable<Item> {
     public RandomizedQueue()                 // construct an empty randomized queue
     public boolean isEmpty()                 // is the queue empty?
     public int size()                        // return the number of items on the queue
     public void enqueue(Item item)           // add the item
     public Item dequeue()                    // delete and return a random item
     public Item sample()                     // return (but do not delete) a random item
     public Iterator<Item> iterator()         // return an independent iterator over items in random order
     public static void main(String[] args)   // unit testing
     }
     Throw a NullPointerException if the client attempts to add a null item;
     throw a java.util.NoSuchElementException if the client attempts to sample or dequeue an item from an empty randomized queue;
     throw an UnsupportedOperationException if the client calls the remove() method in the iterator;
     throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.

    Your randomized queue implementation must support each randomized queue operation (besides creating an iterator) in constant amortized time and use space proportional to the number of items currently in the queue.

    That is, any sequence of M randomized queue operations (starting from an empty queue) should take at most cM steps in the worst case, for some constant c.
    Additionally, your iterator implementation must support construction in time linear in the number of items and it must support the operations next() and hasNext() in constant worst-case time;
    you may use a linear amount of extra memory per iterator. The order of two or more iterators to the same randomized queue should be mutually independent; each iterator must maintain its own random order.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] arrays;
    private int size = 0;
    private int N = 0;

    private Item[] resize(int N, Item[] oldArray){
        this.N = N;
        Item[] copy = (Item[])new Object[N];
        
        int j = 0;
        for(Item o: oldArray){
            copy[++j] = o;
        }

        return copy;
    }

    // construct an empty randomized queue
    public RandomizedQueue(){
        arrays = (Item[]) new Object[2];
    }

    // is the queue empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        if (item != null) throw new NullPointerException("NPE enqueue");
        if (size == arrays.length ) this.arrays = resize(2*arrays.length, this.arrays);
        arrays[size++] = item;
    }

    // delete and return a random item
    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException("No Such Element");
        int randomIdx = StdRandom.uniform(size);
        size --;
        Item it = arrays[randomIdx];
        // Swap Array
        if(randomIdx != size - 1) arrays[randomIdx] = arrays[size-1];
        //Shrink Array
        if(size == arrays.length /4 && size > 0) this.arrays = resize(arrays.length/4, arrays);
        return it;

    }

    // return (but do not delete) a random item
    public Item sample(){
        int random = StdRandom.uniform(size);
        return arrays[random];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        
        return new Iterator<Item>() {
            private int i = 0;
            @Override
            public boolean hasNext() {
                return i != size;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                return arrays[++i];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // unit testing
    public static void main(String[] args){
        RandomizedQueue<String> q = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on stack)");


    }
}