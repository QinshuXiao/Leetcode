/**
 * Created by qinshuxiao on 2018/6/3.
 */
public class ValidWordAbbreviation {

    static public void main(String[] args){
        ValidWordAbbreviation checker = new ValidWordAbbreviation();

        String word = "internationalization";
        String abbr = "i12iz4n";
        System.out.println("Word: "+word+" Abbr: "+abbr);
        System.out.println("Result: "+checker.validWordAbbreviation(word,abbr));

        word = "apple";
        abbr = "a2e";
        System.out.println("Word: "+word+" Abbr: "+abbr);
        System.out.println("Result: "+checker.validWordAbbreviation(word,abbr));

        word = "a";
        abbr = "01";
        System.out.println("Word: "+word+" Abbr: "+abbr);
        System.out.println("Result: "+checker.validWordAbbreviation(word,abbr));

        word = "internationalization";
        abbr = "i5a11o1";
        System.out.println("Word: "+word+" Abbr: "+abbr);
        System.out.println("Result: "+checker.validWordAbbreviation(word,abbr));
    }

    /**
     *
     * Firstly transform string to char array
     * Use two pointers to specify the current index we are at in word and abbr individually
     *
     * Then we move forward these two pointers and check character.
     * Note that, when we meet numeric character in abbr, we need to extract that piece of numeric substring and transform them to number.
     * Then we move forward i by this number.
     *
     * Be careful that this edge case:
     * Word = 'a' abbr = '01'
     *
     * When 0 is the first digit of a numeric string, we have to consider that '0' as a character, not a part of numeric string.
     *
     */

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        char[] wc = word.toCharArray(), ac = abbr.toCharArray();

        if(ac[0] > '0' && ac[0] <= '9'){
            int cnt = ac[0]-'0';
            ++j;
            while(j < ac.length && ac[j] >= '0' && ac[j] <= '9'){
                cnt *= 10;
                cnt += ac[j] - '0';
                ++j;
            }
            i += cnt;
        }

        while(i < wc.length && j < ac.length){
            if(wc[i] != ac[j]) return false;

            ++j;
            ++i;
            if(j < ac.length && ac[j] > '0' && ac[j] <= '9'){
                int cnt = ac[j]-'0';
                ++j;
                while(j < ac.length && ac[j] >= '0' && ac[j] <= '9'){
                    cnt *= 10;
                    cnt += ac[j] - '0';
                    ++j;
                }
                i += cnt;
            }
        }

        return (i == wc.length && j == ac.length);
    }
}
