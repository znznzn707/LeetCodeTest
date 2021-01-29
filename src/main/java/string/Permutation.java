package string;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * <a href="https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">字符串的排列</a>
 */
public class Permutation {
    TreeSet<String> set = new TreeSet<>();
    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() == 0) return res;
        perm(str.toCharArray(), 0);
        res.addAll(set);
        return res;
    }
    private void perm(char[] chars, int index) {
        if (index + 1 == chars.length) set.add(new String(chars)) ;
        for (int i = index; i < chars.length; ++i) {
            if(i != index && chars[i] == chars[index]) continue;
            swap(chars, i, index);
            perm(chars,index+1);
            swap(chars, i, index);
        }

    }
    private void swap(char[] chars, int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }
}
