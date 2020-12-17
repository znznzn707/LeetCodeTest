package listnode;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/12/07 19:49
 * <a href="https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">孩子们的游戏(圆圈中最后剩下的数)</a>
 * <pre>
 * 题目描述:
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 如果没有小朋友，请返回-1
 * </pre>
 */
public class LastRemaining_Solution {
    public int lastRemaining(int n, int m) {
        int i = 0;
        Child head = null ;
        Child tail = null ;
        int size = n;
        if(size == 1) return 0 ;
        else if(size == 0) return -1;
        while (i < n) {
            Child newCild = new Child(i) ;
            if(head == null)  tail = head = newCild;
            else {
                tail.next = newCild ;
                tail = newCild;
            }
            ++i;
        }
        tail.next = head;
        i = 0;
        Child cur = head;
        while (size != 1) {
            if(i == m-2) {
                Child temp = cur.next ;
                cur.next = cur.next.next ;
                temp = null ;
                i = -1;
                --size;
            }else {
                cur = cur.next ;
                ++i;
            }
        }
        return cur.n;
    }
    static class Child {
         int n;
         Child next ;
         Child(int n) {
             this.n = n;
         }
    }
    public static void main(String[] args) {
        LastRemaining_Solution solution = new LastRemaining_Solution();
        int n = solution.lastRemaining(5, 3) ;
        System.out.println(n) ;
    }
}
