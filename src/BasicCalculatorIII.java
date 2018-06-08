/**
 * Created by qinshuxiao on 2018/6/7.
 */
public class BasicCalculatorIII {

    public static void main(String[] args){
        BasicCalculatorIII calculator = new BasicCalculatorIII();

        String s = "1 + 2 * 3";
        System.out.println(s+" = "+calculator.calculate(s));

        s = "6-4 / 2";
        System.out.println(s+" = "+calculator.calculate(s));

        s = "2*(5+5*2)/3+(6/2+8)";
        System.out.println(s+" = "+calculator.calculate(s));

        s = "(2+6* 3+5- (3*14/7+2)*5)+3";
        System.out.println(s+" = "+calculator.calculate(s));

        s = "   3  ";
        System.out.println(s+" = "+calculator.calculate(s));

        s = " (6882)  ";
        System.out.println(s+" = "+calculator.calculate(s));
    }

    /**
     * Combine solution of Basic Calculator and solution of Basic Calculator II together.
     *
     * (1) Q: How to deal with operators with different priority?
     *     A: Using Stack. Ideas from reverse polish expression.
     *
     * (2) Q: How to deal with embedded expression closed by parentheses? Like " 1 +5 * (7/(2 + 3*4))"
     *     A: Extract embedded expression and recursively call calculate(embedded expression).
     *
     */

    public int calculate(String s) {
        char[] sc = s.toCharArray();
        int idx = 0, res = 0;

        char[] ops = new char[2];
        int[] nums = new int[2];
        int opsTop = 0, numsTop = 0;

        while(idx < sc.length){
            /**
             * Skip blanks
             */
            while(idx < sc.length && sc[idx] == ' ') ++idx;

            if(idx == sc.length) break;
            /**
             * Deal with '+' or '-'
             * Put it into stack, as we don't know whether the next operator is '*' or '/' or not.
             */
            else if(sc[idx] == '+' || sc[idx] == '-'){
                /**
                 * If previous operator is '+' or '-', which has the same priority as current operator
                 * Then we can safely do calculation on previous two numbers based on previous operator.
                 */
                if(opsTop > 0){
                    if(ops[0] == '+') nums[0] += nums[1];
                    else nums[0] -= nums[1];
                    --numsTop;
                    --opsTop;
                }

                ops[opsTop++] = sc[idx];
                ++idx;
            }
            /**
             * Deal with '*' and '/'
             * Put it into the top of stack, waiting for next number, for later calculation
             */
            else if(sc[idx] == '*' || sc[idx] == '/'){
                ops[opsTop++] = sc[idx];
                ++idx;
            }
            /**
             * Deal with regular number or embedded expression closed by parentheses
             */
            else{
                int num = 0;
                /**
                 * Deal with expression string closed by parentheses (a+b*c-e/f)
                 * Extract it and recursively call calculate
                 */
                if(sc[idx] == '('){
                    int end = idx+1, numsOfLeft = 1;
                    while(end < sc.length && numsOfLeft > 0){
                        if(sc[end] == '(') ++numsOfLeft;
                        else if(sc[end] == ')') --numsOfLeft;
                        ++end;
                    }

                    num = calculate(s.substring(idx+1, end-1));
                    idx = end;
                }

                /**
                 * Deal with regular number
                 * Convert string to number
                 */
                else {
                    while(idx < sc.length && sc[idx] >= '0' && sc[idx] <= '9'){
                        num *= 10;
                        num += sc[idx] - '0';
                        ++idx;
                    }
                }

                /**
                 * If last operator we've seen if '*' or '/'
                 * We do calculation on current number and last number we've recorded.
                 */
                if(opsTop > 0 && (ops[opsTop-1] == '*' || ops[opsTop-1] == '/')){
                    int prevNum = nums[--numsTop];
                    char op = ops[--opsTop];
                    if(op == '*'){
                        nums[numsTop++] = prevNum * num;
                    } else {
                        nums[numsTop++] = prevNum / num;
                    }
                } else {
                    nums[numsTop++] = num;
                }
            }
        }

        if(opsTop > 0) {
            if(ops[0] == '+') nums[0] += nums[1];
            else nums[0] -= nums[1];
        }

        return nums[0];
    }
}
