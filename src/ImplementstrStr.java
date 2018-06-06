/**
 * Created by qinshuxiao on 2018/6/5.
 */
public class ImplementstrStr {

    public static void main(String[] args){
        ImplementstrStr checker = new ImplementstrStr();

        String haystack = "hello", needle = "ll";
        System.out.println("Haystack: "+haystack+ " needle: "+needle+"  Result: "+checker.strStr(haystack, needle));

        haystack = "aaaaa";
        needle = "bba";
        System.out.println("Haystack: "+haystack+ " needle: "+needle+"  Result: "+checker.strStr(haystack, needle));

        needle = "";
        System.out.println("Haystack: "+haystack+ " needle: "+needle+"  Result: "+checker.strStr(haystack, needle));
    }

    /**
     *
     * To be honest, we need to write a KMP algorithm.
     * But I use a straightforward way. Using java built-in substring() and equals()
     * And surprisingly, I found that java's built-in function equals() can get a really good performance.
     *
     */

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;

        int len = needle.length(), idx = 0;
        while(idx + len <= haystack.length()){
            if(haystack.substring(idx, idx+len).equals(needle)) return idx;
            ++idx;
        }
        
        return -1;

    }
}
