import java.util.*;

/**
 * Created by qinshuxiao on 2018/6/15.
 */
public class WordLadder {

    public static void main(String[] args){

    }

    /**
     *
     * 1. How we transfer a string to another?
     *    A: travel through 'a' to 'z',  change one character in original string to build a new string.
     *
     * 2. BFS to find a shortest transformation path.
     *
     */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == endWord) return 0;

        Set<String> dict = new HashSet<>();
        for(String word : wordList) dict.add(word);
        if(!dict.contains(endWord)) return 0;

        int transfer = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while(!q.isEmpty()){
            int len = q.size();
            while(len > 0){
                String cur = q.poll();
                if(cur.equals(endWord)) return transfer;

                char[] sc = cur.toCharArray();
                for(int i = 0; i < sc.length; ++i){
                    char original = sc[i];

                    /**
                     * Remember this way!
                     * Change one character in original string to build a new string
                     */
                    for(char ch = 'a'; ch <= 'z'; ++ch){
                        if(ch == original) continue;
                        sc[i] = ch;
                        String str = String.valueOf(sc);
                        if(dict.contains(str)){
                            q.offer(str);
                            dict.remove(str);
                        }
                    }
                    sc[i] = original;
                }
                --len;
            }

            ++transfer;
        }

        return 0;
    }
}
