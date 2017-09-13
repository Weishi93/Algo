import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Created by Wei Shi on 9/13/17.
 */
public class MyPriorityQueue<Key> {
    private Key[] pq;
    private Comparator<Key> comparator;
    private int n;

    public MyPriorityQueue(Key[] arr, Comparator<Key> comparator) {
        pq = (Key[])new Object[arr.length + 1];
        n = arr.length;
        this.comparator = comparator;
        for (int i = 0; i < arr.length; i++) {
            pq[i + 1] = arr[i];
        }
        for (int i = n / 2; i >= 1; i--) {
            sink(i);
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int getSize() {
        return n;
    }

    public void swim(int i) {
        while (i > 1 && less(i, i / 2)) {
            swap(i, i / 2);
            i /= 2;
        }
    }

    public void sink(int i) {
        while (2 * i < n) {
            int j = 2 * i;
            if (greater(j, j + 1)) {
                j++;
            }
            if (!less(j, i)) {
                return;
            }
            swap(i, j);
            i = j;
        }
    }

    public void offer(Key key) {
        if (n == pq.length - 1) {
            resize(2 * n);
        }
        n++;
        pq[n] = key;
        swim(n);
        print();
    }

    public Key poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("PriorityQueue is empty.");
        }
        Key key = pq[1];
        swap(1, n);
        sink(1);
        pq[n] = null;
        n--;
        if (n > 0 && n < (pq.length - 1) / 4) {
            resize(n / 2);
        }
        System.out.println(key);
        return key;
    }

    public void swap(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public boolean less(int i, int j) {
        return comparator.compare(pq[i], pq[j]) < 0;
    }

    public boolean greater(int i, int j) {
        return comparator.compare(pq[i], pq[j]) > 0;
    }

    public void resize(int newCapacity) {
        Key[] newPQ = (Key[]) new Object[newCapacity + 1];
        for (int i = 0; i <= n; i++) {
            newPQ[i] = pq[i];
        }
        pq = newPQ;
    }

    public void print() {
        System.out.println(Arrays.toString(pq));
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,4,6,12,0,-1,7};
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        pq.print();
        pq.poll();
        pq.print();
        pq.offer(-7);
        pq.offer(12);
    }
}
