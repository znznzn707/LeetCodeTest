import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/11 18:31
 * <a href="https://www.nowcoder.com/practice/d2cced737eb54a3aa550f53bb3cc19d0?tpId=182&&tqId=34614&rp=1&ru=/activity/oj&qru=/ta/exam-all/question-ranking">餐馆</a>
 * <pre>
 * 题目描述:
 *   某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数；
 *   有m批客人，每批客人有两个参数:b人数，c预计消费金额。
 *   在*不允许拼桌*的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
 * </pre>
 * <p>贪心算法</p>
 * *时间复杂度未达到要求，只满足50%实例*
 */

class Customer {
    int num;
    int cost ;
    boolean arrange  ;

    public Customer(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }
    public int getCost() {
        return cost;
    }
}
public class Restaurant {
    /**
     *
     * @param n n张桌子
     * @param m m批客人
     * @param a 每个桌子可容纳的最大人数
     * @param b 每批客人人数
     * @param c 每批客人的预计消费额
     * @return 在不拼桌的情况下，返回最大消费额
     */
    public static int getMaxCost(int n, int m, int[] a, int[] b, int[] c) {
        Arrays.sort(a);
        int max = a[a.length-1] ;
        List<Customer> customers = new ArrayList<>(b.length) ;
        for(int i = 0; i < b.length; i++) {
            if(b[i] <= max)
                customers.add(new Customer(b[i], c[i])) ;
        }
        Comparator<Customer> comp = Comparator.comparingInt(Customer::getCost)
                .reversed() ;
        customers.sort(comp);
        int cost= 0 ;
        //需要优化
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < customers.size(); j++) {
                Customer customer = customers.get(j);
                if (!customer.arrange && customer.num <= a[i]) {
                        cost += customer.cost;
                        customer.arrange = true ;
                        break;
                    }
                }
            }
        return cost ;
    }
}
