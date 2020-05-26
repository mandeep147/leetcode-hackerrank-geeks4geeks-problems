/**
 * 236. Implement Trie (Prefix Tree)
 */
package leetcode.trees;

/**
 * @author mandeep
 * created on Mar 1, 2018, 8:54:26 PM
 */
public class Problem_236_ImplementTrie {
	private TrieNode root;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem_236_ImplementTrie trie = new Problem_236_ImplementTrie();
		String word = "leetcode";
		trie.insert(word);
		trie.insert("code");
		trie.insert("search");
		trie.insert("prefix");
		boolean search = trie.search("leet");
		System.out.println(search);
		boolean start = trie.startsWith("leet");
		System.out.println(start);
	}
	
	 /** 
	  * Initialize your data structure here. 
	  */
	public Problem_236_ImplementTrie(){
		root = new TrieNode();
	}
	
	/** 
	 * Time: O(m)
	 * SPace: O(m)
	 * Inserts a word into the trie. 
	 */
	public void insert(String word){
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++){
			char curr = word.charAt(i);
			if(!node.containsKey(curr))
				node.put(curr, new TrieNode());
			node = node.get(curr);
		}
		node.setEnd();
	}
	
	/** 
	 * Time: O(m)
	 * SPace: O(1)
	 * Returns if the word is in the trie. 
	 */
	public boolean search(String word){
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
	}
	
	/**
	 * @param word
	 * @return
	 */
	private TrieNode searchPrefix(String word) {
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++){
			char curr = word.charAt(i);
			if(node.containsKey(curr))
				node = node.get(curr);
			else 
				return null;
		}
		return node;
	}

	/** 
	 * Time: O(m)
	 * SPace: O(1)
	 * Returns if there is any word in the trie that starts with the given prefix. 
	 */
	public boolean startsWith(String prefix){
		TrieNode node = searchPrefix(prefix);
		return node != null;
	}

}

class TrieNode{
	
	private TrieNode[] links;
	private final int r = 26;
	private boolean isEnd;
	
	public TrieNode(){
		links = new TrieNode[r];
	}
	
	public boolean containsKey(char ch){
		return links[ch-'a'] != null;
	}
	
	public TrieNode get(char ch){
		return links[ch-'a'];
	}
	
	public void put(char ch, TrieNode node){
		links[ch-'a'] = node;
	}
	
	public void setEnd(){
		isEnd = true;
	}
	
	public boolean isEnd(){
		return isEnd;
	}
}