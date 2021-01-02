import java.lang.StringBuilder;

public class DecodeAtIndex {

    public String decodeAtIndex(String S, int K) {
        StringBuilder s = new StringBuilder() ;
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i) ;
            if(!Character.isDigit(ch)) {s.append(ch);}
            else {
                int x = Integer.valueOf(String.valueOf(ch)); 
                String temp = s.toString() ;
                while(x-- > 1) s.append(temp);
            }
            if(K < s.length()) break;
        }
        return String.valueOf(s.charAt(K-1)) ;
    }
    public static void main(String[] args) {
        DecodeAtIndex decode = new DecodeAtIndex() ;
        String S = "a2b3c4d5e6f7g8h9";
        int K = 10; 
        String s = decode.decodeAtIndex(S, K);
        System.out.println(s) ;
    }
}
