package string;

/**
 * <a href="https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">字符流中第一个不重复的字符</a>
 */

public class FirstAppearingOnce {

    private int[] hash = new int[128];
    private StringBuilder builder = new StringBuilder() ;

    public void Insert(char ch) {
        builder.append(ch) ;
        ++hash[ch] ;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for(char ch: builder.toString().toCharArray()) {
            if(hash[ch] == 1) return ch ;
        }
        return '#' ;
    }

    public static void main(String[] args) {
        FirstAppearingOnce appearingOnce = new FirstAppearingOnce() ;
        appearingOnce.Insert('g');
        appearingOnce.Insert('o');
        appearingOnce.Insert('o');
        appearingOnce.Insert('g');
        appearingOnce.Insert('l');
        appearingOnce.Insert('e');
        char ch = appearingOnce.FirstAppearingOnce() ;
        System.out.println(ch) ;
    }
}