package string;

/**
 * <a href="https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1">最长回文子串</a>
 */
public class GetLongestPalindrome {
    public int getLongestPalindrome(String A, int n) {
        // write code here
        int max = 0;
        for(int i = 0; i < A.length()-1; ++i) {
            int m1 = getLongestIntern(A, i, i); //奇数
            int m2 = getLongestIntern(A, i,i+1); //偶数
            int temp = Math.max(m1, m2) ;
            max = Math.max(max, temp);
        }
        return max;
    }
    private int getLongestIntern(String s, int left, int right) {
        while (left >= 0 && right <= s.length()-1) {
            if(s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }else break;
        }
        return right - left + 1 - 2;
    }

    public static void main(String[] args) {
        GetLongestPalindrome palindrome = new GetLongestPalindrome() ;
        int longest = palindrome.getLongestPalindrome("abc1234321ab",12);
        System.out.println(longest) ;
    }
}
