/**
 * Created by qinshuxiao on 2018/6/21.
 */
public class Trie {

    private static class node{
        boolean isEnd = false;
        node[] children = null;
        public node(){
            isEnd = false;
            children = new node[26];
        }
    }

    private node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] wc = word.toCharArray();

        node cur = root;
        for(char c : wc){
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new node();
            }
            cur = cur.children[c-'a'];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] wc = word.toCharArray();
        node cur = root;

        for(char c : wc){
            if(cur.children[c-'a'] == null) return false;
            cur = cur.children[c-'a'];
        }

        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] wc = prefix.toCharArray();
        node cur = root;

        for(char c : wc){
            if(cur.children[c-'a'] == null) return false;
            cur = cur.children[c-'a'];
        }

        return dfs(cur);
    }

    private boolean dfs(node cur){
        if(cur.isEnd) return true;

        for(int i = 0; i < 26; ++i){
            if(cur.children[i] == null) continue;

            if(dfs(cur.children[i])) return true;
        }

        return false;
    }
}
