package string;

import java.util.regex.Pattern;
/**
 * <a href="https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&&tqId=11206&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">表示数值的字符串</a>
*/

public class IsNumeric {
    public static void main(String[] args) {
        boolean b1 = isNumeric("123.45e+6".toCharArray()) ;
        boolean b2 = isNumeric("1.2.3".toCharArray()) ;
        System.out.println("b1="+b1) ;
        System.out.println("b2="+b2) ;
    }
    public static boolean isNumeric(char[] str) {
        String pattern = "^[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?$" ;
        String s = new String(str) ;
        return Pattern.matches(pattern, s) ;
    }
}
