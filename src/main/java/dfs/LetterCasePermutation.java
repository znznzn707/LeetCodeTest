package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3642/discuss/115485/Java-Easy-BFS-DFS-solution-with-explanation">Letter Case Permutation</a>
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        List<String> strings = letterCasePermutation2("a1b2");
        strings.forEach(System.out::println);
    }

    //DFS
    public static List<String> letterCasePermutation(String S) {
        if(S == null) return new LinkedList<>();
        List<String> res = new ArrayList<>();
        dfs(S.toCharArray(),0, res);
        return res;
    }
    private static void dfs(char[] chars, int pos, List<String> res) {
        if(pos == chars.length) {
            res.add(new String(chars));
            return;
        }
        if(chars[pos] >= '0' && chars[pos] <= '9') {
            dfs(chars,pos + 1, res);
            return;
        }
        chars[pos] = Character.toLowerCase(chars[pos]);
        dfs(chars, pos + 1, res);
        chars[pos] = Character.toUpperCase(chars[pos]);
        dfs(chars, pos + 1, res);
    }

    //BFS
    public static List<String> letterCasePermutation2(String S) {
        if(S == null) return new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        for(int i = 0; i < S.length(); ++i) {
            if(Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for(int j = 0; j < size; ++j) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();
                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(new String(chs));
                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(new String(chs));
            }
        }
        return new LinkedList<>(queue);
    }
}
