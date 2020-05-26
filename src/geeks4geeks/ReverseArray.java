/**
 *
 */
package geeks4geeks;


/**
 * Given a string, that contains special character together with alphabets
 * (‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse the string in a way that special characters are not affected.
 * Input:   str = "a,b$c"
 * Output:  str = "c,b$a"
 *
 * @author mandeep
 */
public class ReverseArray {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        //String str = "Ab,c,de!$";
        String str = "a!!!b.c.d,e'f,ghi";
        //System.out.println(reverseArray(str));
        reverseArray(str);
    }
    
    private static void reverseArray(String str) {
        char[] arr = str.toCharArray();
        int l = 0, r = arr.length - 1;
        char temp;
        
        while (l < r) {
            if (!Character.isLetter(arr[l])) {
                //System.out.println("l: "+arr[l]);
                l++;
            } else if (!Character.isLetter(arr[r])) {
                //System.out.println("r: "+arr[r]);
                r--;
            } else {
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                //	System.out.println("l: "+arr[l]+" r: "+arr[r]);
                l++;
                r--;
            }
        }
        
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]);
    }
    
}
