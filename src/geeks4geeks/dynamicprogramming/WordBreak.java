/**
 * 
 */
package geeks4geeks.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an input string and a dictionary of words, segment the input string into a space-separated sequence of dictionary words if possible. 
 * For example, if the input string is "applepie" and dictionary contains a standard set of English words, 
 * then we would return the string "apple pie" as output.
 * 
 * @author mandeep
 *
 */
public class WordBreak {
	
	private static HashMap<String, ArrayList<String>> wordBreak = new HashMap<String, ArrayList<String>>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Set<String> dictionary = new HashSet<String>(Arrays.asList("i", "like", "kesa", "msun", "sam", "sung", "mobile","samsung","mob", "le"));
		Set<String> dictionary = new HashSet<String>(Arrays.asList("apple", "pie", "ap", "e", "pi", "le","ple"));		
		String input = "applepie";
		ArrayList<String> finalRes = wordBreak(dictionary, input);
		for(String word : finalRes)
			System.out.println(word);
	}
	
	private static ArrayList<String> wordBreak(Set<String>dictionary, String input){
		if(wordBreak.containsKey(input))
			return wordBreak.get(input);
		ArrayList<String> result = new ArrayList<String>();
		
		if(dictionary.contains(input))
			result.add(input);
		
		for(int i = 0; i < input.length(); i++){
			String prefix = input.substring(0, i + 1);
			if(dictionary.contains(prefix)){
				String suffix = input.substring(i + 1);
				ArrayList<String> subResult = wordBreak(dictionary, suffix);
				for(String text : subResult)
					result.add(prefix+" "+text);
			}
		}
		wordBreak.put(input, result);
		return result;
	}
}