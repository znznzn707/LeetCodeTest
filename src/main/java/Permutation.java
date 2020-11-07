import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/06 16:10
 * <a href="https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">字符串的排列</a>
 */
public class Permutation {
    ArrayList<String> list = new ArrayList<>() ;
    TreeSet<String> set = new TreeSet<>() ;

    public ArrayList<String> Permutation(String str) {
        if(str.length() == 0) return list;
        perm(0, str.toCharArray());
        list.addAll(set) ;
        return list;
    }
    public void perm(int idx,char[] chs) {
        if(idx+1 == chs.length) set.add(new String(chs)) ;
        for(int i = idx; i < chs.length; i++) {
            if(i != idx && chs[i] == chs[idx]) continue;
            swap(chs, i, idx);
            perm(idx+1, chs);
            swap(chs, i, idx);
        }
    }
    public void swap(char[] chs, int i, int j) {
        char tmp = chs[i] ;
        chs[i] = chs[j] ;
        chs[j] = tmp ;
    }
}
