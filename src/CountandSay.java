/**
 * Created by qinshuxiao on 2018/6/6.
 */
public class CountandSay {

    public static void main(String args[]){
        CountandSay talker = new CountandSay();

        int n = 1;
        System.out.println("n: "+n+"  Result: "+talker.countAndSay(n));

        n = 6;
        System.out.println("n: "+n+"  Result: "+talker.countAndSay(n));

        n = 14;
        System.out.println("n: "+n+"  Result: "+talker.countAndSay(n));
    }

    /**
     *
     * Well, this problem, I guess, is designed to check if you know how to use StringBuilder or not.
     *
     */

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append('1');

        while(n > 1){
            char[] last = sb.toString().toCharArray();
            sb.delete(0,last.length);

            int i = 0;
            while(i < last.length){
                int j = i;
                while(j < last.length && last[j] == last[i]){
                    ++j;
                }

                sb.append(j-i);
                sb.append(last[i]);
                i = j;
            }
            --n;
        }

        return sb.toString();
    }
}
