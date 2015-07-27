import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.LinkedList;
// import java.util.ArrayList;
// import java.util.List;

/**
 * Dequeue. A double-end
 * Create a generic data type Deque that implements the following API:
 *
 *    public Deque()                           // construct an empty deque
 *    public boolean isEmpty()                 // is the deque empty?
 *   public int size()                        // return the number of items on the deque
 *   public void addFirst(Item item)          // insert the item at the front
 *   public void addLast(Item item)           // insert the item at the end
 *   public Item removeFirst()                // delete and return the item at the front
 *   public Item removeLast()                 // delete and return the item at the end
 *   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
 *   public static void main(String[] args)   // unit testing
 *
 * Throw a NullPointerEx
 * throw an UnsupportedOperationException if the client calls the remove() method in the iterator;
 * throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.
 *
 * Your deque implementation must support each deque operation in constant worst-case time and use space 
 * Additionally, your iterator implementation must support the operations next() and hasNext() (plus cons
**/
public class Deque<Item> implements Iterable<Item> {
    private LinkedList<Item> list;

    // construct an empty deque
    public Deque() {
        list = new LinkedList<Item>();
    }
    // is the deque empty?
    public boolean isEmpty() {
        return list.isEmpty();
    }
    // return the number of items on the deque
    public int size() {
        return list.size();
    }

    // insert the item at the front
    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException();
        
        list.addFirst(item);
    }

    // insert the item at the end
    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();

        list.addLast(item);
    }

    // delete and return the item at the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        return list.pollFirst();
    }

    // delete and return the item at the end
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        return list.pollLast();
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Iterator<Item> it = list.iterator();
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                return it.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // unit testing
    public static void main(String[] args) {

        Deque deque = new Deque<Integer>();

        deque.addFirst(new Integer(1));
        // deque.addFirst(new Integer(2));
        // deque.addFirst(new Integer(3));

       // deque.removeFirst();
        deque.removeLast();
        
        deque.addLast(new Integer(3));
        deque.addFirst(new Integer(5));
        deque.addLast(new Integer(4));


        for (Iterator<Integer> i = deque.iterator(); i.hasNext()) {

            System.out.println(i.next());
        }

    }


}
