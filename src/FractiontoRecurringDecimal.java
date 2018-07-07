import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinshuxiao on 2018/7/6.
 */
public class FractiontoRecurringDecimal {

    public static void main(String[] args){
        FractiontoRecurringDecimal computer = new FractiontoRecurringDecimal();

        int numerator = 1, denominator = 2;
        System.out.println("Numerator="+numerator+" Denominator="+denominator);
        System.out.println("Numerator / Denominator = "+computer.fractionToDecimal(numerator, denominator));
        System.out.println("===========================================");

        numerator = 5; denominator = 2;
        System.out.println("Numerator="+numerator+" Denominator="+denominator);
        System.out.println("Numerator / Denominator = "+computer.fractionToDecimal(numerator, denominator));
        System.out.println("===========================================");

        numerator = 65215; denominator = 2761;
        System.out.println("Numerator="+numerator+" Denominator="+denominator);
        System.out.println("Numerator / Denominator = "+computer.fractionToDecimal(numerator, denominator));
        System.out.println("===========================================");

        numerator = -107; denominator = 3;
        System.out.println("Numerator="+numerator+" Denominator="+denominator);
        System.out.println("Numerator / Denominator = "+computer.fractionToDecimal(numerator, denominator));
        System.out.println("===========================================");

        numerator = -1; denominator = -2147483648;
        System.out.println("Numerator="+numerator+" Denominator="+denominator);
        System.out.println("Numerator / Denominator = "+computer.fractionToDecimal(numerator, denominator));
        System.out.println("===========================================");
    }

    /**
     *
     * 1. Using recursion to compute decimal.
     *
     * 2. How to deal with infinite circulating decimal？
     *    Using hashmap to store <numerator, idx of current result digit> pairs.
     *    When we meet an new numerator, if it has already existed in the hashmap,
     *    We know we meet circulating decimal.
     *    Then all we need to do is to retrieve idx, and insert a '(' in idx, alongside inserting a ')' in the end.
     *
     *
     */

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean isNeg = (numerator < 0) ^ (denominator < 0);

        long num = (numerator < 0)?-(long)numerator:numerator;
        long denum = (denominator<0)?-(long)denominator:denominator;

        sb.append(num/denum);
        if(numerator % denominator == 0) return (isNeg?"-":"") + sb.toString();
        else {
            sb.append('.');
            getDecimal( (num%denum) * 10, denum, sb, new HashMap<Long, Integer>());
            return (isNeg?"-":"") + sb.toString();
        }

    }

    private void getDecimal(long numerator, long denominator, StringBuilder sb, Map<Long, Integer> map){
        if(numerator == 0) return;
        if(map.containsKey(numerator)) {
            int idx = map.get(numerator);
            sb.insert(idx, '(');
            sb.append(')');
            return;
        }

        sb.append(numerator/denominator);
        map.put(numerator, sb.length()-1);
        getDecimal((numerator%denominator)*10, denominator, sb, map);
    }
}
