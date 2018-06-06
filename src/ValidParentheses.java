import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by qinshuxiao on 2018/6/6.
 */
public class ValidParentheses {
    public static void main(String[] args){
        ValidParentheses checker = new ValidParentheses();

        String s = "[(){}]{}";
        System.out.println("S: "+s+" Result: "+checker.isValid(s));

        s = "[(){}]{";
        System.out.println("S: "+s+" Result: "+checker.isValid(s));

        s = "(])";
        System.out.println("S: "+s+" Result: "+checker.isValid(s));

        s = "((()[]))";
        System.out.println("S: "+s+" Result: "+checker.isValid(s));
    }

    /**
     *
     * We use stack to store the left hand side parentheses('(', '[', '{') we've met
     * When we meet a right hand side character ( ')', ']' or '}' ), we check our stack:
     *   if our stack is empty, it can't make valid parentheses.
     *   if the top character in stack cannot match with current character, it can't make valid parentheses.
     *   It's valid on other cases.
     *
     * That's it.
     *
     */

    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        if(s.length() % 2 == 1) return false;

        Map<Character, Character> counterpart = new HashMap<>();
        counterpart.put('[', ']');
        counterpart.put('(', ')');
        counterpart.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(counterpart.containsKey(ch)){
                stack.push(ch);
            } else {
                if(stack.empty() || counterpart.get(stack.peek()) != ch) return false;
                stack.pop();
            }
        }

        return stack.empty();
    }
}
