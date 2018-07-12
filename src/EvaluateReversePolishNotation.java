import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by qinshuxiao on 2018/7/11.
 */
public class EvaluateReversePolishNotation {


    public static void main(String[] args){
        EvaluateReversePolishNotation eva = new EvaluateReversePolishNotation();

        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println("Input: "+ Arrays.toString(tokens)+ " Result: "+eva.evalRPN(tokens));

        tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println("Input: "+ Arrays.toString(tokens)+ " Result: "+eva.evalRPN(tokens));

        tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Input: "+ Arrays.toString(tokens)+ " Result: "+eva.evalRPN(tokens));

        tokens = new String[]{"-1", "-2147483648", "*", "76592", "-"};
        System.out.println("Input: "+ Arrays.toString(tokens)+ " Result: "+eva.evalRPN(tokens));
    }

    /**
     *
     * Using Stack to store number we met.
     * When we meet an operator.
     * We do a computation on the top two numbers, then we push the result back to the top of stack.
     *
     * Note that there are one possible edge case:
     * [-1, -2147483648, '*']
     * which will produce the number 2147483648, which is larger than 2147483647 (int overflow).
     * Therefore, in our stack, we have to store element which type is Long.
     *
     */
    public int evalRPN(String[] tokens) {
        Stack<Long> s = new Stack<>();
        Set<String> ops = new HashSet<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");

        for(String token : tokens){
            if(ops.contains(token)){
                Long num1 = s.pop(), num2 = s.pop();

                if(token.equals("+")){
                    s.push(num1+num2);
                } else if(token.equals("-")){
                    s.push(num2-num1);
                } else if(token.equals("*")){
                    s.push(num1*num2);
                } else if(token.equals("/")){
                    s.push(num2/num1);
                }
            } else {
                s.push(Long.parseLong(token));
            }
        }

        return s.pop().intValue();
    }
}
