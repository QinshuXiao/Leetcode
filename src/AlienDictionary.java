import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qinshuxiao on 2018/6/18.
 */
public class AlienDictionary {

    public static void main(String[] args){
        AlienDictionary ad = new AlienDictionary();

        String[] words = {"a","b","c"};
        System.out.println("Input: "+ Arrays.toString(words)+"  Result: "+ad.alienOrder(words));

        words = new String[]{"ab","ad","cb","dc"};
        System.out.println("Input: "+ Arrays.toString(words)+"  Result: "+ad.alienOrder(words));

        words = new String[]{"a","x","a"};
        System.out.println("Input: "+ Arrays.toString(words)+"  Result: "+ad.alienOrder(words));

        words = new String[]{"a", "a"};
        System.out.println("Input: "+ Arrays.toString(words)+"  Result: "+ad.alienOrder(words));

        words = new String[]{"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"};
        System.out.println("Input: "+ Arrays.toString(words)+"  Result: "+ad.alienOrder(words));
    }


    /**
     * We can use Topo sort to solve this problem, just like we do in **Course Schedule**
     *
     * Because w[i-1][j] is ahead of w[i][j], we can build a directed edge from w[i-1][j] pointed to w[i][j].
     * After we add all edges, we build a graph.
     *
     * Then Use Queue and a revised version of BFS to finish Topo sort
     *
     */
    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        HashSet<Character>[] graph = new HashSet[26];
        int edges = 0;

        for(String word : words){
            for(char c : word.toCharArray()){
                graph[c-'a'] = new HashSet<Character>();
            }
        }

        for(int i = 1; i < words.length; ++i){
            char[] w1 = words[i-1].toCharArray();
            char[] w2 = words[i].toCharArray();

            int j = 0;
            while(j < w1.length && j < w2.length && w1[j] == w2[j]) ++j;

            if(j == w1.length || j == w2.length) continue;

            if( !graph[w1[j]-'a'].contains(w2[j]) ) {
                graph[w1[j]-'a'].add(w2[j]);
                ++indegree[w2[j]-'a'];
                ++edges;
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < 26; ++i){
            if(graph[i] != null && indegree[i] == 0){
                q.offer(Character.valueOf((char)((int)'a'+i)));
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            Character cur = q.poll();
            sb.append(cur);

            for(Character neighbor : graph[cur-'a']){
                --indegree[neighbor-'a'];
                --edges;
                if(indegree[neighbor-'a'] == 0) q.offer(neighbor);
            }

        }


        if(edges == 0) return sb.toString();
        else return "";
    }
}
