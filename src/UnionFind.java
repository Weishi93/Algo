import java.util.Arrays;

/**
 * Created by Wei Shi on 4/18/17.
 */
public abstract class UnionFind {
    int[] arr;
    int count;
    abstract void union(int p, int q);
    abstract boolean connected(int p, int q);
    abstract int find(int p);
    abstract int getCount();
    public static void main(String[] args) {
        UnionFind qf = new WeightedQuickUnion(10);
        qf.union(4, 3);
        qf.union(3, 8);
        qf.union(6, 5);
        qf.union(9, 4);
        qf.union(2, 1);
        System.out.println(qf.connected(8, 9));
        System.out.println(qf.connected(5, 4));
        System.out.println(qf.getCount());
        qf.union(5, 0);
        qf.union(7, 2);
        qf.union(6, 1);
        System.out.println(qf.getCount());
        qf.union(1, 0);
        qf.union(6, 7);
        System.out.println(Arrays.toString(qf.arr));
        System.out.println(qf.getCount());
    }
}

class QuickFind extends UnionFind {
    public QuickFind(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        count = n;
    }

    public void union(int p, int q) {
        int pid = arr[p], qid = arr[q];
        if (pid == qid) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pid) {
                arr[i] = qid;
            }
        }
        count--;
    }

    public boolean connected(int p, int q) {
        return arr[p] == arr[q];
    }

    public int find(int p) {
        return arr[p];
    }

    public int getCount() {
        return count;
    }
}

class QuickUnion extends UnionFind {
    QuickUnion(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        count = n;
    }
    public int find(int p) {
        while (arr[p] != p) {
            p = arr[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        arr[rootP] = rootQ;
        count--;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int getCount() {
        return count;
    }
}

class WeightedQuickUnion extends UnionFind {
    int[] size;
    WeightedQuickUnion(int n) {
        arr = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            size[i] = 1;
        }
        count = n;
    }
    public int find(int p) {
        while (p != arr[p]) {
            p = arr[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[p] < size[q]) {
            arr[rootP] = rootQ;
            size[q] += size[p];
        } else {
            arr[rootQ] = rootP;
            size[p] += size[q];
        }
        count--;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int getCount() {
        return count;
    }
}
