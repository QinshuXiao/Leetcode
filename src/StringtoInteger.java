/**
 * Created by qinshuxiao on 2018/6/6.
 */
public class StringtoInteger {

    public static void main(String[] args){
        StringtoInteger converter = new StringtoInteger();

        String str = "   452 ";
        System.out.println("Str: "+str);
        System.out.println("Int: "+converter.myAtoi(str));
        System.out.println("=================================");


        str = " I'm 452 ";
        System.out.println("Str: "+str);
        System.out.println("Int: "+converter.myAtoi(str));
        System.out.println("=================================");

        str = "   -452 ";
        System.out.println("Str: "+str);
        System.out.println("Int: "+converter.myAtoi(str));
        System.out.println("=================================");

        str = "   +452 ";
        System.out.println("Str: "+str);
        System.out.println("Int: "+converter.myAtoi(str));
        System.out.println("=================================");

        str = "   452.2221 ";
        System.out.println("Str: "+str);
        System.out.println("Int: "+converter.myAtoi(str));
        System.out.println("=================================");

        str = " 345 hyu ";
        System.out.println("Str: "+str);
        System.out.println("Int: "+converter.myAtoi(str));
        System.out.println("=================================");

        str = " 74832648326483248247672834683246832";
        System.out.println("Str: "+str);
        System.out.println("Int: "+converter.myAtoi(str));
        System.out.println("=================================");

        str = "   -3671357126536217827381753621525173628713 ";
        System.out.println("Str: "+str);
        System.out.println("Int: "+converter.myAtoi(str));
        System.out.println("=================================");
    }

    /**
     *
     * The difficulties come from edge cases.
     * There are some issues we need to care about:
     * 1. deal with leading blanks
     * 2. deal with '+' or '-'
     * 3. deal with integer overflow (using long type of variable)
     *
     */

    public int myAtoi(String str) {
        char[] sc = str.toCharArray();
        long res = 0;
        int idx = 0;
        boolean neg = false;

        // deal with leading blanks
        while(idx < sc.length && sc[idx] == ' ') ++idx;
        if(idx == sc.length) return 0;

        // deal with '-' or '+'
        if(sc[idx] == '-') {
            neg = true;
            ++idx;
        }
        else if(sc[idx] == '+'){
            ++idx;
        }

        while(idx < sc.length){
            if(sc[idx] >= '0' && sc[idx] <= '9'){
                res *= 10;
                res += sc[idx]-'0';

                // deal with integer overflow
                if(neg){
                    if(-res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                } else {
                    if(res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                }

            } else {
                if(neg) return -(int)res;
                else return (int)res;
            }

            ++idx;
        }

        if(neg) return -(int)res;
        else return (int)res;
    }
}
