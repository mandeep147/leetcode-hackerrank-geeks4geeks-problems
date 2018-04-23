/**
 * 
 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on Feb 18, 20189:03:12 PM
 */
public class Problem_186_ReverseWordsInStringII {

	/**
	 * @param args
	 */
	public static void main(String args[]){
    	String s = "coding is fun";
    	System.out.println(s);
    	char[] ch = s.toCharArray();
    	reverseWordInPlace(ch);
    }
	
	private static void reverseWordInPlace(char[] s){
    	//reverse whole sentence
    	reverse(s, 0, s.length-1);
    	
    	//reverse each word
    	int start = 0; 
    	for(int i = 0; i < s.length; i++){
    		if(s[i] == ' '){
    			reverse(s, start, i-1);
    			start = i+1;
    		}
    	}
    	
    	//reverse last word
    	reverse(s, start, s.length-1);
    	for(int i = 0; i <s.length; i++)
    		System.out.print(s[i]);
    }
    
    private static void reverse(char[] s, int start, int end){
    	while(start < end){
    		char temp = s[start];
    		s[start] = s[end];
    		s[end] = temp;
    		start++;
    		end--;
    	}
    }
}
