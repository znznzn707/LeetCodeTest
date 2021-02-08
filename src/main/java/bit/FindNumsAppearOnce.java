package bit;

/**
 * <a href="https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=190&tqId=35201&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey">数组中只出现一次的数字</a>
 */
public class FindNumsAppearOnce {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int diff = 0;
        for(int i: array) {
            diff ^= i;
        }
        int bit = 1;
        while ((diff & bit) == 0) bit <<= 1;
        int n1 = 0, n2 = 0;
        for (int i : array) {
            if((i & bit) == 0) n1 ^= i;
            else n2 ^= i;
        }
        num1[0] = n1;
        num2[0] = n2;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,5,6,6,3,8,8};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce appearOnce = new FindNumsAppearOnce();
        appearOnce.FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0]) ;
        System.out.println(num2[0]) ;
    }
}
