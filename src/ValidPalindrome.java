/**
 * Created by qinshuxiao on 2018/6/4.
 */
public class ValidPalindrome {

    public static void main(String[] args){
        ValidPalindrome checker = new ValidPalindrome();

        String s = "A man, a plan, a canal: Panama";
        System.out.println("Input: "+s);
        System.out.println("IsPalindrome: "+checker.isPalindrome(s));
        System.out.println("========================================");


        s = "race a car";
        System.out.println("Input: "+s);
        System.out.println("IsPalindrome: "+checker.isPalindrome(s));
        System.out.println("========================================");


        s = "    ;;; a    xx    a";
        System.out.println("Input: "+s);
        System.out.println("IsPalindrome: "+checker.isPalindrome(s));
        System.out.println("========================================");

    }


    /**
     *
     * Because we can convert a string into a char array,
     * We can use two pointers, one is moving forward while the other is moving backward, to specify two character from head and tail.
     * And we compare them, to see if they are equal.
     *
     * Note that there are only alphanumeric characters inside string, we need firstly to check if the character pointed by pointers needs to be ignore or not.
     *
     */

    public boolean isPalindrome(String s) {
        if(s.length() < 2) return true;

        char[] sc = s.toLowerCase().toCharArray();
        int head = 0, tail = sc.length-1;

        while(head < tail){
            while( head < tail && shouldIgnore(sc[head]) ){
                ++head;
            }

            while(head < tail && shouldIgnore(sc[tail]) ){
                --tail;
            }

            if(sc[head] == sc[tail]){
                ++head;
                --tail;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean shouldIgnore(char ch){
        return !( (ch >= '0' && ch <= '9') || (ch >='a' && ch <='z'));
    }
}
