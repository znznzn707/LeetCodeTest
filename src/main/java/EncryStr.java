import java.lang.annotation.ElementType;
import java.util.stream.IntStream;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/08/03 15:05
 */
public class EncryStr {
    public static String encryStr(String str) {
        StringBuilder target = new StringBuilder();
        char c = ' ' ;
        for(char ch: str.toCharArray()) {
            if(ch >= 'A' && ch < 'F') {
                c = (char) (ch+21) ;
                target.append(c);
            }else if( ch <= 'Z' && ch >= 'F') {
                c = (char) (ch-5) ;
                target.append(c) ;
            }else  target.append(ch) ;
        }
        return target.toString() ;
    }

}
