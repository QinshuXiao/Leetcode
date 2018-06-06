/**
 * Created by qinshuxiao on 2018/6/5.
 */
public class ReverseString {

    public static void main(String[] args){
        ReverseString rs = new ReverseString();

        String s = "hello";
        System.out.println("S: "+s+"  Reversed S:"+rs.reverseString(s));

        s = "helo";
        System.out.println("S: "+s+"  Reversed S:"+rs.reverseString(s));
    }

    public String reverseString(String s) {
        if(s.length() < 2) return s;

        char[] sc = s.toCharArray();
        int head = 0, tail = sc.length-1;

        while(head < tail){
            char tmp = sc[head];
            sc[head] = sc[tail];
            sc[tail] = tmp;

            ++head;
            --tail;
        }

        return String.copyValueOf(sc);
    }
}
