package bit;

/**
 * <a href="https://www.nowcoder.com/practice/2cc32b88fff94d7e8fd458b8c7b25ec1?tpId=190&tqId=35335&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey">进制转换</a>
 */
public class DecimalConversion {
    /**
     * 进制转换
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve (int M, int N) {
        // write code here
        int temp = M;
        StringBuilder sb = new StringBuilder();
        while (M != 0) {
            int  carry = Math.abs(M % N);
            if(carry < 10) sb.insert(0, carry) ;
            else sb.insert(0, (char) (carry + 55));
            M /= N;
        }
        if(temp < 0) sb.insert(0, "-") ;
        return sb.toString() ;
    }
}
