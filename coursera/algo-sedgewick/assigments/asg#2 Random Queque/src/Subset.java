public class Subset {
    private static int k = 0;

    public Subset() {
        super();
    }

    private static void print(RandomizedQueue set) {
        for (int i = 0; i < k; i++) {
            StdOut.println(set.dequeue());
        }
    }

    public static void main(String[] args) {
        RandomizedQueue set = new RandomizedQueue<String>();
        k = Integer.parseInt(args[0]);
        // StdOut.println(ch+" ");

        while (!StdIn.isEmpty()) {
            String ch = StdIn.readString();
            set.enqueue(ch);
        }

        print(set);
    }
}