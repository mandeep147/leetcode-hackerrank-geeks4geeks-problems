/**
 * 71. Simplify Path
 */
package mandeep.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author mandeep
 * created on Mar 1, 2018, 10:09:56 PM
 */
public class Problem_71_SimplifyPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "/a/./b/../c/";
		System.out.println("simplified path is " + simplifyPath(path));
	}

	/**
	 * @param path
	 * @return
	 */
	private static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		
		while(path.length() > 0 && path.charAt(path.length()-1) == '/')
			path = path.substring(0, path.length()-1);
		
		int start = 0;
		
		for(int i = 1; i < path.length(); i++){
			if(path.charAt(i) == '/'){
				stack.push(path.substring(start, i));
				start = i;
			}else if(i == path.length()-1)
				stack.push(path.substring(start));
		}
		
		LinkedList<String> res = new LinkedList<>();
		int back = 0;
		
		while(!stack.isEmpty()){
			String top = stack.pop();
			if(top.equals("/.") || top.equals("/")){
				
			}else if(top.equals("/.."))
					back++;
			else{
				if(back > 0)
					back--;
				else res.push(top);;
			}
		}
		
		if(res.isEmpty())
			return "/";
		
		StringBuilder sb = new StringBuilder();
		while(!res.isEmpty()){
			sb.append(res.pop());
		}
		
		return sb.toString();
	}

}
