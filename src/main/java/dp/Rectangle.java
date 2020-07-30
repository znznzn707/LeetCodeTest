package dp;

/**
 * @author JN Ma, znznzn707@hotmail.com
 * @since  2020/07/23 17:33
 *
 * <pre>
 *     问题描述：用2*1的小矩形横着或者竖着去覆盖更大的矩形，
 *     请问用n个2*1的小矩形无重复地覆盖一个2*n的大矩形，总共有多少个方法？
 *
 *     状态F(i): 用i个2*1无覆盖2*i的大矩形的方法个数
 *     转移方程：　F(i) = F(i-1) + F(i-2)
 * </pre>
 * <a href="https://www.nowcoder.com/questionTerminal/72a5a919508a4251859fb2cfb987a0e6">矩形</a>
*/
public class Rectangle {
}