package string;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/12/06 16:06
 * <a href="https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">翻转单词顺序列</a>
 * <pre>
 * 题目描述:
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * </pre>
 */
public class ReverseSentence {
    public String reverseSentence(String str) {
        char[] chs = str.toCharArray();
        reverse(chs, 0, str.length()-1);
        int left = 0, right = 0;
        while (left < chs.length) {
            //1. " abc"(开始是空格)的情况
            if(chs[left]  == ' ') {
                ++left ;
                ++right;
            }else if(right == chs.length || chs[right] == ' ') {
                reverse(chs, left, right-1);
                left = ++right;
                //2. "ab xc"(结尾是字母) 和"abc a"(遇到空格)的情况
            }else {
                //3. "abc"的情况
                ++right;
            }
        }
        return String.valueOf(chs);
    }
    public void reverse(char[] chs, int left, int right) {
        while (left < right) {
            char temp = chs[left] ;
            chs[left] = chs[right] ;
            chs[right] = temp;
            ++left;
            --right;
        }
    }
}
