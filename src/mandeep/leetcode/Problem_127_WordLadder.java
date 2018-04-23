/**
 * Problem 127. Word Ladder
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * 
 * For example,
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */
package mandeep.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author mandeep created on Apr 1, 2018, 1:53:59 PM
 */
public class Problem_127_WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> dictionary = new ArrayList<String>();
		dictionary.add("hot");
		dictionary.add("dot");
		dictionary.add("dog");
		dictionary.add("lot");
		//dictionary.add("log");
		//dictionary.add("cog");

		String startWord = "hit";
		String endWord = "cog";
		System.out.println("shortest length of path from " + startWord + " to " + endWord + " is "
				+ ladderLength(startWord, endWord, dictionary));
	}

	/**
	 * @param startWord
	 * @param endWord
	 * @param dictionary
	 * @return
	 */
	private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        HashSet<String> set = new HashSet<String>(wordList);
        Queue<String> q = new LinkedList<String>();
        int length = 0;
        set.add(endWord);
        q.add(beginWord);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String w = q.poll();
                if (w.equals(endWord)) return length + 1;
                wordMatch(w, set, q);
            }
            length++;
        }
        return 0;
    }
    
    private static void wordMatch(String w, Set<String> set, Queue<String> q) {
        for (int i = 0; i < w.length(); i++) {
            char[] word = w.toCharArray();
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                if (word[i] == c) continue;
                word[i] = c;
                String s = String.valueOf(word);
                if (set.contains(s)) {
                    set.remove(s);
                    q.offer(s);
                }
            }
        }
    }

}
