import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * Dequeue. A double-ended queue or deque (pronounced "deck") is a generalization of a stack and a queue that supports inserting and removing items from either the front or the back of the data structure.
 * Create a generic data type Deque that implements the following API:
 *
     public Deque()                           // construct an empty deque
     public boolean isEmpty()                 // is the deque empty?
     public int size()                        // return the number of items on the deque
     public void addFirst(Item item)          // insert the item at the front
     public void addLast(Item item)           // insert the item at the end
     public Item removeFirst()                // delete and return the item at the front
     public Item removeLast()                 // delete and return the item at the end
     public Iterator<Item> iterator()         // return an iterator over items in order from front to end
     public static void main(String[] args)   // unit testing

 * Throw a NullPointerException if the client attempts to add a null item; throw a java.util.NoSuchElementException if the client attempts to remove an item from an empty deque;
 * throw an UnsupportedOperationException if the client calls the remove() method in the iterator;
 * throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.

 * Your deque implementation must support each deque operation in constant worst-case time and use space proportional to the number of items currently in the deque.
 * Additionally, your iterator implementation must support the operations next() and hasNext() (plus construction) in constant worst-case time and use a constant amount of extra space per iterator.
**/
public class Deque<Item> implements Iterable<Item> {
    private int size;
    private Node head;

    public class Node{
        Node(){}
        Node(Item e){ this.elem = e;}
        public Node next;
        public Node prev;
        public Item elem;
    }

    // construct an empty deque
    public Deque(){
        head = new Node();
        size = 0;
    }
    // is the deque empty?
    public boolean isEmpty(){
        return size == 0;
    }
    // return the number of items on the deque
    public int size(){
        return size;
    }

    // insert the item at the front
    public void addFirst(Item item){
        if(item == null) throw new NullPointerException();

        Node newNode = new Node(item);
        if (isEmpty()) {

        	head.prev = newNode;
        	head.next = newNode;
        	newNode.prev = head;
        	size++;
        	System.out.println("isEmpty item: "+item+" head: "+head+ " next: "+newNode.next + " prev: "+ newNode.prev + " newNode: "+newNode);
        	return;
        }
			
        
        newNode.prev = head;
        newNode.next = head.next;
        head.next = newNode;
        newNode.next.prev = newNode;
        this.size ++;

        System.out.println("item: "+item+" head: "+head+ " next: "+newNode.next + " prev: "+ newNode.prev + " newNode: "+newNode);

    }

    // insert the item at the end
    public void addLast(Item item){
        if(item == null) throw new NullPointerException();

        Node newNode = new Node(item);

        if (isEmpty())  head.next = newNode;

        newNode.prev = head.prev;
        newNode.next = null;
        head.prev.next = newNode;
        head.prev = newNode;

        size++;
    }

    // delete and return the item at the front
    public Item removeFirst(){

        Node node2Delete = head.next;

        if (node2Delete == null) throw new NoSuchElementException();

        if (isEmpty()){
            node2Delete = null;
            head.next = null;
            head.prev = null;
            return null;
        }

        head.next = node2Delete.next;
        node2Delete.next.prev = head;

        node2Delete = null;
        size--;

        return head.next.elem;

    }

    // delete and return the item at the end
    public Item removeLast(){
        // System.out.println(head);

        Node node2Delete = head.prev;

        if (node2Delete == null)
            throw new NoSuchElementException();

        if (isEmpty()){
            node2Delete = null;
            head.next = null;
            head.prev = null;
            return null;
        }
        // node2Delete.prev.next = null;
        head.prev = node2Delete.prev;
        head.prev.next = null;

        size--;
        node2Delete = null;
		
		System.out.println("Delete head: "+head+ " next: "+head.next + " prev: "+ head.prev);
        return head.prev.elem;

    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator(){

        return new Iterator<Item>() {
            private Node curr = head;

            @Override
            public boolean hasNext() {
                return curr.next != null;
            }

            @Override
            public Item next() {
                if (curr == null ) throw new NoSuchElementException();
                curr = curr.next;
                return curr.elem;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

    }
    // unit testing
    public static void main(String[] args)  {

        Deque deque = new Deque<Integer>();

        deque.addFirst(new Integer(1));
        // deque.addFirst(new Integer(2));
        // deque.addFirst(new Integer(3));

       // deque.removeFirst();
        deque.removeLast();
        
        deque.addLast(new Integer(3));
        deque.addFirst(new Integer(5));
        deque.addLast(new Integer(4));


        for (Iterator<Integer> i = deque.iterator(); i.hasNext(); ){

            System.out.println(i.next());
        }

    }


}
