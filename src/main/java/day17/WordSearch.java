package day17;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}

public class WordSearch {

    public static void main(String[] args) {
        char[][] island = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };
        new WordSearch().searchIt(island, new String[]{"abccee", "see", "abcb"});
    }

    public TrieNode createTrie(String[] board) {
        TrieNode root = new TrieNode();
        for (String w : board) {
            TrieNode p = root;
            // board char to int, store as sequential leaf till end for ease to find starting point
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    public List<String> searchIt(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = createTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                searchHelperDFS(board, i, j, root, res);
            }
        }
        return res;
    }

    public void searchHelperDFS(char[][] board, int i, int j, TrieNode p, List<String> res) {
        //if first letter matchs to trie's any children
        char c = board[i][j];
        //in visited case
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            // to avoid duplicat char in word
            p.word = null;

        }

        // mark as visited
        board[i][j] = '#';
        // recursive call with 4 adjacent node
        if (i > 0) searchHelperDFS(board, i - 1, j, p, res);
        if (j > 0) searchHelperDFS(board, i, j - 1, p, res);
        if (i < board.length - 1) searchHelperDFS(board, i + 1, j, p, res);
        if (j < board[0].length - 1) searchHelperDFS(board, i, j + 1, p, res);
        // mark as unvisited for further searching
        board[i][j] = c;
    }

}