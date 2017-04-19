import javax.jws.Oneway;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Wei Shi on 2/13/17.
 */
//class myTest {
//    protected static void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
//}
public class test1 {
    public static void main(String[] args) {
//        test1 cbv = new test1();
//        Date date = new Date();
//        date.setTime(0L);
//        cbv.invoke(date);
//        String s = new String("hello");
//        cbv.func(s);
//        System.out.println(s);
//        String a = "123.45.6.7";
//        String[] words = a.split("\\.");
//        for (String str : words) {
//            System.out.println(str);
//        }
        int[] s = new int[]{1, 2};
        func(s);
        System.out.println(s[0]);
    }

    static void func(int[] s) {
//        s = new String("2");
//        s = new int[]{2, 3};
        s[0] = 2;
    }

    public void invoke(Date date) {
        date.setTime(1L);
        date = new Date(2L);
    }

//    public void func(String s) {
//        s = new String("world");
//    }
}

