import java.util.Arrays;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since  2020/06/22 11:37
 */
public class TwoNumber {
    public static int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int num : nums) if ((num & diff) != 0)
            x ^= num;
        return new int[]{x, bitmask^x};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1,1,2,2,3,5})));
    }

}
