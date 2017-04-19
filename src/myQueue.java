/**
 * Created by Wei Shi on 11/1/16.
 */
public class myQueue<E> {
    class Node {
        E data;
        Node next;
        Node(E data) {
            this.data = data;
            next = null;
        }
    }
    private Node head, tail;
    private int count;
    public myQueue() {
        head = null;
        tail = null;
        count = 0;
    }
    public void add(E item) {
        Node node = new Node(item);
        if (count == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public E poll() {
        if (head == null || tail == null || count == 0 ) {
            throw new IllegalStateException("This queue is empty");
        }
        E result = head.data;
        head = head.next;
        count--;
        return result;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        myQueue<Integer> queue = new myQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}
