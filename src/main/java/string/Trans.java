package string;

/**
 * <a href="https://www.nowcoder.com/practice/c3120c1c1bc44ad986259c0cf0f0b80e?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey">字符串变形</a>
 */
public class Trans {
    public static String trans(String s, int n) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = n-1; i >= 0; --i) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                sb.append(" ");
                index = n - i;
            }else {
                char c = (char) ((ch < 97)?  ch + 32: ch - 32);
                sb.insert(index, c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "This is a sample";
        int n = 16;
        System.out.println(trans(s, n));
    }
}

