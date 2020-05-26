/*
 * Problem 151: reverse words in a string
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
*/
package leetcode;

public class Problem_151_ReverseString {
  
    public static void reverseWords(String s) {
        String[] words = s.split(" ");
        int i = 0; 
        String temp;
        int len = words.length -1;
        while(i < len){
          temp = words[i];
          words[i] = words[len];
          words[len] = temp;
          i++;
          len--;   
        }
        
        for(String str : words)
        	System.out.print(str+" ");
        System.out.println();
    }
    
    private static String reverseStringWords(String s) {
    	String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();
        int len = words.length - 1;
        for(int j = 0; j <= len; j++){
            if(!words[j].isEmpty()){
                sb.insert(0, words[j]);
                if(j < len)
                    sb.insert(0, " ");
            }
        }

        return sb.toString();
    }
    
    public static void main(String args[]){
    	String s = "coding is fun";
    	System.out.println(s);
    	reverseWords(s);
    	
    	System.out.println(reverseStringWords(s));	
    }
}
