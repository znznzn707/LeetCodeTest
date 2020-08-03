import java.util.Arrays;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/02 14:38
 * <a href="https://www.nowcoder.com/questionTerminal/fbcf95ed620f42a88be24eb2cd57ec54">微信红包</a>
 */
public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        Arrays.sort(gifts);
        int x = gifts[n/2];
        int m = (int) Arrays.stream(gifts).filter(e-> e==x).count();
        if(m > (n/2))
            return x ;
        else
            return 0 ;
    }
    //最优解
    public int getValue2(int[] gifts, int n) {
        // write code here
        if(gifts.length < n) return 0;
        if(gifts.length == 0) return 0;
        int count=0,temp = 0;
        for(int i=0;i<n;i++) {
            if(count==0) {
                temp=gifts[i];
                count=1;
            }
            else{
                if(temp == gifts[i])
                    count++;
                else
                    count--;
            }
        }
        int size=0;
        for(int i=0;i<n;i++){
            if(temp==gifts[i])
                size++;
        }
        return (size>n/2)?temp:0;
    }
}
