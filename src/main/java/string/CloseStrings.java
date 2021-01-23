package string;

import java.util.Arrays;

public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        Arrays.sort(chs1);
        Arrays.sort(chs2);
        System.out.println("word1="+Arrays.toString(chs1)) ;
        System.out.println("word2="+Arrays.toString(chs2)) ;
        return false;
    }

    public static void main(String[] args) {
        CloseStrings closeStrings = new CloseStrings();
        boolean isClose = closeStrings.closeStrings("cabbba", "abbccc");
        System.out.println(isClose) ;
    }
}
