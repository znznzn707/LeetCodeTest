package array;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since 2020/11/10 20:35
 * <a href="https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1">把数组排成最小的数</a>
 */
public class PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        int m = numbers.length;
        StringBuilder sb = new StringBuilder() ;
        for(int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                String s1 = String.valueOf(numbers[i]);
                String s2 = String.valueOf(numbers[j]);
                int n = Math.max(s1.length(), s2.length());
                int k = 0;
                while (k < n) {
                    int a = (k >= s1.length())? s1.charAt(s1.length()-1):s1.charAt(k) ;
                    int b = (k >= s2.length())? s2.charAt(s2.length()-1):s2.charAt(k) ;
                    if(a > b) {swap(numbers, i, j); break;}
                    k++;
                }
            }
        }
        for(int i : numbers) {
            sb.append(i) ;
        }
        return sb.toString();
    }
    public void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j] ;
        numbers[j] = tmp ;
    }
}
