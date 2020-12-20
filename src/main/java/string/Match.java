pakage string; 
/**
 * <a href="https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=0">*** 正则表达式匹配</a>
 * <pre>
 *题目描述
 *请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 *模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 *在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * </pre>
 */
public class Match {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int s, char[] pattern, int p) {
        //下面4行是递归结束标志，两个指针都指到了最后，才是匹配，否则不匹配
        if (s == str.length && p == pattern.length)
            return true;
        if (s < str.length && p == pattern.length)
            return false;

        //虽然比的是P位置的，但是P后面出现*时，规则需要改变。
        if (p + 1 < pattern.length && pattern[p + 1] == '*') {
            //出现了*，并且s和P指向的相同，3种情况并列
            if ((s < str.length && pattern[p] == '.')
                    || (s < str.length && pattern[p] == str[s])) {
                return matchCore(str, s, pattern, p + 2)
                    || matchCore(str, s + 1, pattern, p)
                    || matchCore(str, s + 1, pattern, p + 2);
            } else {//出现了*，并且s和p指向的不同，那就把*前面的字符理解出现了0次，p+2
                return matchCore(str, s, pattern, p + 2);
            }
        }
        //说明P后面不是*，那么就进行常规判断。相同就分别给指针+1
        if (s < str.length && (pattern[p] == str[s] || pattern[p] == '.'))
            return matchCore(str, s + 1, pattern, p + 1);
        //p后面又不是*，也没有.给你撑腰，你还敢出现不同，那必然false
        return false;
    }
}
