import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * <a href="https://www.nowcoder.com/practice/95cb356556cf430f912e7bdf1bc2ec8f?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">栈排序</a>
 */
public class StackAndSort {
    /**
     * 栈排序
     * @param a int整型一维数组 描述入栈顺序
     * @return int整型一维数组
     */
    public static int[] solve (int[] a)  {
        // write code here
        int n=a.length;
        int[] maxs=new int[n+1];
        int max=Integer.MIN_VALUE;

        //找出i到n中最大的那个值
        for (int i = n-1; i>=0; i--) {
            max=Math.max(max,a[i]);
            maxs[i]=max;
        }
        maxs[n]=Integer.MIN_VALUE;
        System.out.println(Arrays.toString(maxs)) ;
        Stack<Integer>stack=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();

        //如果当前入栈的值 大于i+1到n之间的最大值 那么出栈
        //maxs[i+1]最后一定为0,所有栈内元素可以全部出栈
        for (int i = 0; i <n; i++) {
            stack.push(a[i]);
            while(!stack.isEmpty() && stack.peek()>maxs[i+1] ){
                list.add(stack.pop());
            }
        }

        int[] res=new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i]=list.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a = {2,1,5,3,4} ;
        int[] res = solve(a);
        System.out.println(Arrays.toString(res)) ;
    }
}
