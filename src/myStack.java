import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Wei Shi on 11/1/16.
 */
public class myStack<E> {
    class Node {
        E data;
        Node next;
        Node(E data) {
            this.data = data;
            next = null;
        }
    }
    private Node top;
    private int count;
    public myStack() {
        top = null;
        count = 0;
    }

    public void push(E item) {
        Node newTop = new Node(item);
        newTop.next = top;
        top = newTop;
        count++;
    }

    public E pop() {
        if (top == null) {
            throw new IllegalStateException("Nah");
        }
        E result = top.data;
        top = top.next;
        count--;
        return result;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return count;
    }

    public E peek() {
        if (top == null) {
            throw new IllegalStateException("Empty Stack!");
        }
        return top.data;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node curt = top;
            @Override
            public boolean hasNext() {
                return curt != null;
            }

            @Override
            public E next() {
                if (curt == null) {
                    throw new NoSuchElementException("Stack is empty!");
                }
                E result = curt.data;
                curt = curt.next;
                return result;
            }
        };
    }

    public static void main(String[] args) {
        myStack<Integer> stack = new myStack<>();
        stack.push(1);
        System.out.println("Size is : " + stack.size());
        System.out.println(stack.pop());
        stack.push(1);
        System.out.println("Is this stack empty ? " + stack.isEmpty());
        stack.push(1);
        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(1);
        System.out.println(stack.peek());
        stack.push(1);
        stack.push(12313);
        stack.push(321);
        System.out.println(stack.peek());
        Iterator<Integer> it = stack.iterator();
        System.out.println("It begins");
        while (it.hasNext()) {
            System.out.println(it.next());

        }
    }
}
