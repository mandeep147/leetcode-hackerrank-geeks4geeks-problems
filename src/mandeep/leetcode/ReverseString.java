/*
 * to reverse a given string
*/
package mandeep.leetcode;

public class ReverseString {
    public String reverseString(String s) {
    	char newString[] = s.toCharArray();
    	String reverseString;
        for( int i = s.length()-1; i >= 0; i--){
            System.out.print(newString[i]);
         
        }
  
        
       reverseString = newString.toString();
      // System.out.println(reverseString);
       return reverseString;
    }
    
    public static void main(String args[]){
    	String s = new ReverseString().reverseString("Hello");
    //	System.out.println();
    }
}