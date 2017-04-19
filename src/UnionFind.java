import java.util.Arrays;

/**
 * Created by Wei Shi on 4/18/17.
 */
public abstract class UnionFind {
    abstract void union(int p, int q);
    abstract boolean connected(int p, int q);

    public static void main(String[] args) {
        QuickUnion qf = new QuickUnion(10);
        qf.union(4, 3);
        qf.union(3, 8);
        qf.union(6, 5);
        qf.union(9, 4);
        qf.union(2, 1);
        System.out.println(qf.connected(8, 9));
        System.out.println(qf.connected(5, 4));
        qf.union(5, 0);
        qf.union(7, 2);
        qf.union(6, 1);
        qf.union(7, 3);
        System.out.println(Arrays.toString(qf.arr));
    }
}

class QuickFind extends UnionFind {
    int[] arr;
    public QuickFind(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    public void union(int p, int q) {
        int pid = arr[p], qid = arr[q];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pid) {
                arr[i] = qid;
            }
        }
    }

    public boolean connected(int p, int q) {
        return arr[p] == arr[q];
    }
}

class QuickUnion extends UnionFind {
    int[] arr;
    public QuickUnion(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }
    private int root(int p) {
        while (arr[p] != p) {
            p = arr[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int pRoot = root(p), qRoot = root(q);
        arr[pRoot] = qRoot;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
