/*
 * to reverse a given string
*/
package mandeep.leetcode;

public class ReverseString {
    public String reverseString(String s) {
    	char newString[] = s.toCharArray();
    	String reverseString;
        for( int i = s.length()-1; i >= 0; i--){
            //System.out.print(newString[i]);       
        }
  
       reverseString = newString.toString();
      // System.out.println(reverseString);
       return reverseString;
    }
    
    public static void reverseWords(String s) {
        String[] words = s.split(" ");
        int i = 0; 
        String temp;
        int len = words.length -1;
        for(String str : words)
        	System.out.println(str);
        while(i < len){
          temp = words[i];
          words[i] = words[len];
          words[len] = temp;
          i++;
          len--;   
        }
        
        for(String str : words)
        	System.out.println(str);
    }
    
    public static void main(String args[]){
    	@SuppressWarnings("unused")
		String s = new ReverseString().reverseString("Hello");
    //	System.out.println();
    	reverseWords("coding is fun");
    }
}
