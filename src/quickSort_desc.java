import java.util.Arrays;

/**
 * Created by Wei Shi on 10/6/16.
 */
public class quickSort_desc {
    public void quickSort(int[] arr, int left, int right) throws IllegalArgumentException{
        if (arr == null || arr.length == 0) { // bound-check
            return;
        }
        if (left < 0 || right >= arr.length || left >= right) {
            throw new IllegalArgumentException();
        }
        int pivot = arr[left + (right - left) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (arr[i] > pivot) {
                i++;
            }
            while (arr[j] < pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr, i++, j--);
            }
            System.out.println(Arrays.toString(arr));
        }
        if (left < j) {
            System.out.println("\n");
            quickSort(arr, left, j);
        }
        if (i < right) {
            System.out.println("\n");
            quickSort(arr, i, right);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public void quickSort(int[] arr) {
        if (arr != null) {
            quickSort(arr, 0, arr.length - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {9, 0, -3, 92, 62, 34, 92, 67, 3, 61};
        quickSort_desc sort = new quickSort_desc();
        sort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}