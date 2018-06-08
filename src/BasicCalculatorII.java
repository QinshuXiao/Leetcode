/**
 * Created by qinshuxiao on 2018/6/7.
 */
public class BasicCalculatorII {

    public static void main(String[] args){
        BasicCalculatorII calculator = new BasicCalculatorII();

        String s = "1 + 2 * 3";
        System.out.println(s+" = "+calculator.calculate(s));

        s = "3*4 + 2 * 3";
        System.out.println(s+" = "+calculator.calculate(s));

        s = "1000/2/3/4/5";
        System.out.println(s+" = "+calculator.calculate(s));

        s = "3+5 / 2";
        System.out.println(s+" = "+calculator.calculate(s));

        s = "   3  ";
        System.out.println(s+" = "+calculator.calculate(s));
    }

    public int calculate(String s) {
        //Stack<Character> ops = new Stack<>();
        //Stack<Integer> nums = new Stack<>();

        char[] ops = new char[2];
        int[] nums = new int[2];

        char[] sc = s.toCharArray();
        int idx = 0, len = sc.length, opsTop = 0, numsTop = 0;
        while(idx < len){
            while(idx < len && sc[idx] == ' ') ++idx;

            if(idx == len) {
                break;
            } else if(sc[idx] == '+' || sc[idx] == '-' ){
                while(opsTop > 0){
                    char op = ops[--opsTop];
                    int num1 = nums[--numsTop], num2 = nums[--numsTop];

                    if(op == '+') nums[numsTop++] = num1+num2;
                    else nums[numsTop++] = num2-num1;
                }

                ops[opsTop++] = sc[idx];
                ++idx;
            } else if(sc[idx] == '*' || sc[idx] == '/'){
                ops[opsTop++] = sc[idx];
                ++idx;
            }
            else {
                int num = 0;
                while(idx < len && sc[idx] >= '0' && sc[idx] <= '9'){
                    num *= 10;
                    num += sc[idx] - '0';
                    ++idx;
                }

                if(opsTop > 0 && (ops[opsTop-1] == '*' || ops[opsTop-1] == '/')){
                    char op = ops[--opsTop];
                    int num1 = nums[--numsTop];
                    if(op == '*') nums[numsTop++] = num1*num;
                    else nums[numsTop++] = num1/num;

                } else {
                    nums[numsTop++] = num;
                }
            }
        }

        if(opsTop > 0){
            switch(ops[0]){
                case '+':
                    nums[0] = nums[0]+nums[1];
                    break;
                case '-':
                    nums[0] = nums[0] - nums[1];
                    break;
            }
        }

        return nums[0];
    }
}
