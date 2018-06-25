/**
 * Created by qinshuxiao on 2018/6/24.
 */
public class BackspaceStringCompare {

    public static void main(String[] args){
        BackspaceStringCompare cmper = new BackspaceStringCompare();

        String S = "ab#c", T = "ad#c";
        System.out.println("S: "+S+" T: "+T);
        System.out.println("Equal? " +cmper.backspaceCompare(S, T));
        System.out.println("================================");

        S = "ab##"; T = "c#d#";
        System.out.println("S: "+S+" T: "+T);
        System.out.println("Equal? " +cmper.backspaceCompare(S, T));
        System.out.println("================================");

        S = "a##c"; T = "#a#c";
        System.out.println("S: "+S+" T: "+T);
        System.out.println("Equal? " +cmper.backspaceCompare(S, T));
        System.out.println("================================");

        S = "a#c"; T = "b";
        System.out.println("S: "+S+" T: "+T);
        System.out.println("Equal? " +cmper.backspaceCompare(S, T));
        System.out.println("================================");

        S = "isfcow#"; T = "isfcog#w#";
        System.out.println("S: "+S+" T: "+T);
        System.out.println("Equal? " +cmper.backspaceCompare(S, T));
        System.out.println("================================");

        S = "bxj##tw"; T = "bxo#j##tw";
        System.out.println("S: "+S+" T: "+T);
        System.out.println("Equal? " +cmper.backspaceCompare(S, T));
        System.out.println("================================");
    }

    public boolean backspaceCompare(String S, String T) {
        int si = S.length()-1, ti = T.length()-1;

        while(si >= 0 && ti >= 0){
            si = findCharIdx(S, si);
            ti = findCharIdx(T, ti);

            if(si >= 0 && ti >= 0){
                if(S.charAt(si) == T.charAt(ti)){
                    --si;
                    --ti;
                } else {
                    return false;
                }
            }
        }

        si = findCharIdx(S, si);
        ti = findCharIdx(T, ti);

        return (si < 0 && ti < 0);
    }

    private int findCharIdx(String s, int i){
        if(i < 0) return i;
        if(s.charAt(i) != '#') return i;

        int cnt = 1;
        --i;
        while(i >= 0 && cnt > 0){
            if(s.charAt(i) == '#') ++cnt;
            else --cnt;
            --i;
        }

        return findCharIdx(s, i);
    }
}
