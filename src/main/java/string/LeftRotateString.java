package string;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/12/06 15:42
 * <a href="https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&&tqId=11196&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">左旋转字符串</a>
 * <pre>
 *     题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * </pre>
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(n < 0) return str;
        if(n > str.length()) return "";
        StringBuilder s = new StringBuilder(str);
        s.delete(0, n);
        s.append(str,0, n);
        return s.toString();    }

}
