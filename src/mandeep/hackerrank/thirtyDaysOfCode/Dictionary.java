package mandeep.hackerrank.thirtyDaysOfCode;

import java.util.*;

class Dictionary{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String,Integer> directory = new HashMap<String,Integer>(); 
 
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            
            directory.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            if(directory.containsKey(s) == true){
            	System.out.println(s+"="+directory.get(s));
            }
            else {
            	System.out.println("Not found");
            }            
        }
        in.close();
    }
}