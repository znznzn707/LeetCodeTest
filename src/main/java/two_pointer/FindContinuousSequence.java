package two_pointer;

import java.util.ArrayList;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/12/02 17:36
 * <a href="https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">和为S的连续正数序列</a>
 * <pre>
 *     题目描述:
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 返回值描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * </pre>
 */
public class FindContinuousSequence {
    //时间复杂度O(n)
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        int l = 1;
        int r = 1;
        int sequence = 0 ;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>() ;
        while (l <= sum/2) {
            if(sequence < sum) {
                sequence += r;
                ++r;
            }else {
                if(sequence == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int i = l; i < r; i++)
                        list.add(i);
                    lists.add(list);
                }
                sequence -= l;
                ++l;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        FindContinuousSequence sequence = new FindContinuousSequence();
        ArrayList<ArrayList<Integer>> lists = sequence.findContinuousSequence(50) ;
        lists.forEach(l->{
            for (int x: l) {
                System.out.print(x+" ") ;
            }
            System.out.println() ;
        });
        System.out.println() ;
    }
}
