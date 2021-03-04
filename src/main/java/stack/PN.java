package stack;

import java.util.Stack;

/**
 * <p>波兰式，即前缀表达式</p>
 * [ * + 4 5 3] = (4+5) * 3 = 27
 * [ / + 12 3 5] = 3
 */

public class PN {
    public static int PN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >= 0; --i) {
            try {
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }catch (Exception ex) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(calculate(tokens[i], a, b));
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

    public static void main(String[] args){
        System.out.println(PN(new String[]{"*", "+", "4", "5", "3"})) ;
        System.out.println(PN(new String[]{"/", "+", "12", "3", "5"})) ;
    }
}
