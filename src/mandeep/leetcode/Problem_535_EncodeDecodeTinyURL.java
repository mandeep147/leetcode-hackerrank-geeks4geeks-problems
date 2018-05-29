/**
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
package mandeep.leetcode;

import java.util.HashMap;
import java.util.Random;

/**
 * @author mandeep
 * created on Mar 31, 2018, 4:57:51 PM
 */
public class Problem_535_EncodeDecodeTinyURL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String longUrl = "https://leetcode.com/problems/design-tinyurl";
		String encodedString = encode(longUrl);
		System.out.println("========= Method - 1: Simple Counter =======");
		System.out.println("short url is: "+ encodedString);
		System.out.println("decoded url : "+decode(encodedString)+"\n");
		
		System.out.println("========= Method - 2: Variable Length Encoding =======");
		encodedString = encodeVariable(longUrl);
		System.out.println("short url is: "+ encodedString);
		System.out.println("decoded url : "+decodeVariable(encodedString)+"\n");
		
		System.out.println("========= Method - 3: Hash Code =======");
		encodedString = encodeHashCode(longUrl);
		System.out.println("short url is: "+ encodedString);
		System.out.println("decoded url : "+decodeHashCode(encodedString)+"\n");

		System.out.println("========= Method - 4: Random fixed length encoding =======");
		encodedString = encodeRandom(longUrl);
		System.out.println("short url is: "+ encodedString);
		System.out.println("decoded url : "+decodeRandom(encodedString)+"\n");
	}
	
	//============== Method - 1 (Using Simple Counter) ===================//
	/****
	 * 1. Range of urls that can be decoded is limited by range of int
	 * 2. in case of excessively large number of urls, integer overflow
	 * will overwrite previous URL encoding. -- > performance degradation
	 * 3. Easy to predict next code.
	 */
	static HashMap<Integer, String> map = new HashMap<>();
	static int i = 0;
	
	/**
	 * 
	 * @param longUrl
	 * @return
	 */
	public static String encode(String longUrl){
		map.put(i, longUrl);
		return "http://tinyurl.com/" + i++;
	}

	/**
	 * 
	 * @param shortUrl
	 * @return
	 */
	public static String decode(String shortUrl){
		return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
	}
	
	//============== Method - 2 Variable Length encoding ===================//
	/****
	 * 1. Range of urls that can be decoded is limited by range of int
	 * 2. Easy to predict next code.
	 * 3. Performace is good. 
	 */
	
	static String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static HashMap<String, String> mapVariable = new HashMap<>();
	static int count = 1;
	
	public static String getString(){
		int c = count;
		StringBuilder sb = new StringBuilder();
		
		while(c > 0){
			c--;
			sb.append(chars.charAt(c % 62));
			c /= 62;
		}
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param longUrl
	 * @return
	 */
	public static String encodeVariable(String longUrl){
		String key = getString();
		mapVariable.put(key, longUrl);		
		count++;
		return "http://tinyurl.com/"+key;
	}
	
	/**
	 * 
	 * @param shortUrl
	 * @return
	 */
	public static String decodeVariable(String shortUrl){
		return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
	}
	
	//============== Method - 3 Using HashCode ===================//
	/****
	 * 1. Range of urls that can be decoded is limited by range of int
	 * 2. Possibility of collisions.
	 * 3. Predicting encoded url isn't easy 
	 */
	static HashMap<Integer, String> mapHash = new HashMap<>();
	
	/**
	 * 
	 * @param longUrl
	 * @return
	 */
	public static String encodeHashCode(String longUrl){
		map.put(longUrl.hashCode(), longUrl);
		return "http://tinyurl.com/"+longUrl.hashCode();
	}
	
	/**
	 * 
	 * @param shortUrl
	 * @return
	 */
	public static String decodeHashCode(String shortUrl){
		return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
	}

	//============== Method - 4 Random fixed-length encoding ===================//
	/****
	 * 1. Range of urls that can be decoded is (10+ 26*2)^6
	 * 2. length of url is 6
	 * 3. good performance
	 * 4. Predicting encoded url isn't possible 
	 */	
	
	static String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static HashMap<String, String> mapRandom = new HashMap<>();
	static Random rand = new Random();
	static String key = getRand();
	
	/**
	 * 
	 * @return
	 */
	public static String getRand(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 6; i++)
			sb.append(alphabet.charAt(rand.nextInt(62)));
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param longUrl
	 * @return
	 */
	public static String encodeRandom(String longUrl){
		while(map.containsKey(key)){
			key = getRand();
		}
		
		mapRandom.put(key, longUrl);
		return "http://tinyurl.com/"+key;
	}
	
	public static String decodeRandom(String shortUrl){
		return mapRandom.get(shortUrl.replace("http://tinyurl.com/", ""));
	}
	
	
}