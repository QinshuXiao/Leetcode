/**
 * Created by qinshuxiao on 2018/6/7.
 */
public class BasicCalculator {

    public static void main(String[] args){
        BasicCalculator calculator = new BasicCalculator();

        String s = " 1 + 2 + 3";
        System.out.println(s+" = "+calculator.calculate(s));

        s = " 1 - 2 + 3";
        System.out.println(s+" = "+calculator.calculate(s));

        s = " (1+(4+5+2)-3)+(6+8)";
        System.out.println(s+" = "+calculator.calculate(s));

        s = " 1 ";
        System.out.println(s+" = "+calculator.calculate(s));

        s = " (45)";
        System.out.println(s+" = "+calculator.calculate(s));

    }

    /**
     *
     * Wow Interesting problem.
     * And this problem is not so hard, as all operators have the same priority, which saves us from caring about orders too much.
     *
     * Q: How to deal with embedded expression closed by parentheses? Like " 1 +5 - (7 + (2 - 3 + 4))"
     * A: Extract embedded expression and recursively call calculate(embedded expression).
     *
     *
     */

    public int calculate(String s) {
        char[] sc = s.toCharArray();
        int idx = 0, res = 0;
        char op = '+';

        while(idx < sc.length){

            /**
             * Skip all blanks
             */
            while(idx < sc.length && sc[idx] == ' ') ++idx;

            if(idx == sc.length) break;
            /**
             * Deal with '+' and '-'
             * Just remember it, waiting for next number come, for later computation
             */
            else if(sc[idx] == '+' || sc[idx] == '-'){
                op = sc[idx];
                ++idx;
            }
            /**
             * Deal with expression closed by parentheses "( a+b+c )"
             * Extract closed expression and recursively call calculate(s)
             */
            else if(sc[idx] == '('){
                int end = idx+1, numOfLeft = 1;
                while(end < sc.length && numOfLeft > 0){
                    if(sc[end] == '(') ++numOfLeft;
                    else if(sc[end] == ')') --numOfLeft;
                    ++end;
                }

                if(op == '+'){
                    res += calculate(s.substring(idx+1, end-1));
                } else if (op == '-'){
                    res -= calculate(s.substring(idx+1, end-1));
                }

                idx = end;
            }
            /**
             * Deal with regular number
             * Convert string to number and do calculation based on operation
             */
            else {
                int num = 0;
                while(idx < sc.length && sc[idx] >= '0' && sc[idx] <= '9'){
                    num *= 10;
                    num += sc[idx]-'0';
                    ++idx;
                }

                if(op == '+') res += num;
                else if (op == '-') res -= num;

            }
        }

        return res;
    }

    /**
     * Recursion is a regular and natural ideas. Right?
     * But let's explore this problem more deeply. Then something interesting we found:
     * Since the operator is only either '+' or '-'.
     * 1. If the operator leading the embedded expression is '+', then we can directly remove parentheses.
     *      For example, "5+(4-6)" = "5+4-6". Parentheses don't make any sense in this case.
     * 2. If the operator leading the embedded expression is '-', then all we need to do is to swap '+' and '-' in embedded expression when we remove parentheses.
     *      For example, "5-(3+2-4)"="5-3-2+4"
     *    But Note that we might meet nested embedded expressions. Like " 5-(3 + (2-(4+5)))".
     *    So we need to use a Stack to show if we need to swap '+' and '-' on current closed expression.
     */


}
