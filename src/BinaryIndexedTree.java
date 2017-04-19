import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Wei Shi on 11/2/16.
 */
public class BinaryIndexedTree {
    int[] sum;
    public BinaryIndexedTree(int[] old) {
        sum = new int[old.length + 1];
        for (int i = 0; i < old.length; i++) {
            int l = i + 1;
            l -= l & (-l);

            sum[i + 1] = old[i] + getSum(l - 1, i - 1);
        }
    }

    public int getSum(int i, int j) { //
        if (i == j) return 0;
        if (i > j) {
            throw new IllegalArgumentException("I > J");
        }
        return getSum(j + 1) - getSum(i + 1);
    }

    private int getSum(int i) {
        int curt = i;
        int res = 0;
        while (curt > 0) {
            res += sum[curt];
            curt -= curt & (-curt);
        }
        return res;
    }

    public void update(int index, int value) { // index is 0-based
        int diff = value - getSum(index - 1, index);
        index = index + 1;
        while (index < sum.length) {
            sum[index] += diff;
            index += index & (-index);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 4, 2, 8, 9};
        BinaryIndexedTree some = new BinaryIndexedTree(arr);
        System.out.println(Arrays.toString(some.sum));
        some.update(0, 2);
        System.out.println(Arrays.toString(some.sum));
        System.out.println(some.getSum(3));
    }

}
