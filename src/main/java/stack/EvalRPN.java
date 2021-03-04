package stack;

import java.util.Stack;

/**
 * <a href="https://www.nowcoder.com/questionTerminal/22f9d7dd89374b6c8289e44237c70447">后缀表达式求值</a>
 */

public class EvalRPN {

    /**
     *
     * @param tokens string字符串一维数组
     * @return int整型
     */
    public static int evalRPN (String[] tokens) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; ++i) {
            try {
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }catch (Exception ex) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(calculate(tokens[i], n2, n1));
            }
        }
        return stack.pop();
    }
    public static int calculate(String operator, int n1, int n2) {
        switch (operator) {
            case "+": return n1 + n2;
            case "-": return n1 - n2;
            case "*": return n1 * n2;
            case "/": return n1 / n2;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"20","10","+","30","*"})) ;
    }
}
