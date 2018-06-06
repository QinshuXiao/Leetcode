import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinshuxiao on 2018/6/6.
 */
public class LetterCombinationsofaPhoneNumber {

    public static void main(String[] args){
        LetterCombinationsofaPhoneNumber combiner = new LetterCombinationsofaPhoneNumber();

        String digits = "23";
        System.out.println("Digits: "+digits+" Result: "+combiner.letterCombinations(digits));

        digits = "2";
        System.out.println("Digits: "+digits+" Result: "+combiner.letterCombinations(digits));

        digits = "234";
        System.out.println("Digits: "+digits+" Result: "+combiner.letterCombinations(digits));

        digits = "22";
        System.out.println("Digits: "+digits+" Result: "+combiner.letterCombinations(digits));
    }

    /**
     *
     * Just like Generate Parentheses, this is also a classical backtracking.
     * We can have several choices in every position.
     *
     * For example, for "234",
     * we can firstly compute the combination from "34";
     * then we put each character which belongs to number "2" in the head of each string in combination we just got before.
     *
     * But how do we get the combination from "34"?
     * The same way! We firstly compute the combination from "4";
     * then we put each character which belongs to number "3" in the head of each string in combination we just got before
     *
     * That's it! Backtracking!
     *
     */

    public List<String> letterCombinations(String digits) {
        char[][] letters = {{},{}, {'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
                {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

        return bt(letters, digits.toCharArray(), 0);
    }

    private List<String> bt(char[][] letters, char[] digits, int cur){
        if(cur == digits.length) return new ArrayList<String>();

        char curChar = digits[cur];
        List<String> restCombination = bt(letters, digits, cur+1);
        List<String> curCombination = new ArrayList<String>();

        if(restCombination.size() == 0) {
            for(char ch : letters[curChar-'0']){
                curCombination.add(String.valueOf(ch));
            }
        } else {
            for(char ch : letters[curChar-'0']){
                for(String str : restCombination){
                    curCombination.add(String.valueOf(ch)+str);
                }
            }
        }

        return curCombination;
    }
}
