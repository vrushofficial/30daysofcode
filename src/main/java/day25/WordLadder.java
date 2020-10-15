package day25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class WordNode {
    String word;
    int numSteps;

    public WordNode(String word, int numSteps) {
        this.word = word;
        this.numSteps = numSteps;
    }
}

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {

        // start initially with beginWord in queue
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));
        wordDict.add(endWord);

        // traverse BFS
        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;
            // check for best case - searching word already present in dictionary
           if (word.equals(endWord)) {
                return top.numSteps;
            }
           // apply bruteforce by replacing each char and match with dictionary word
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    // discard replacing with same char
                    if (arr[i] != c) {
                        arr[i] = c;
                    }
                    String newWord = new String(arr);
                    // when newly formed word is in dictionary
                    if (wordDict.contains(newWord)) {
                      // add newly formed word to queue with incrementing
                        queue.add(new WordNode(newWord, top.numSteps + 1));
                        //remove newly formed from dictionary
                        wordDict.remove(newWord);
                    }
                    // set back to origin word
                    arr[i] = temp;
                }
            }
        }
        return 0;
    }

  public static void main(String[] args) {
    System.out.println(new WordLadder().ladderLength("hit","cog", new HashSet<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
  }
}