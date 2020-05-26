/**
 * Problem 257. Binary Tree Paths
 * 
 * Given a binary tree, return all root-to-leaf paths.
 */
package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mandeep
 *
 */
public class BinaryTreePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		List<String> treePaths = binaryTreePaths(root);
		for(String item : treePaths)
			System.out.println(item);
	}

	/**
	 * @param root
	 * @return
	 */
	private static List<String> binaryTreePaths(TreeNode root) {
		ArrayList<String> result = new ArrayList<String>();
		
		if(root == null)
			return result;
		
		ArrayList<String> current = new ArrayList<String>();
		ArrayList<ArrayList<String>> finalRes = new ArrayList<ArrayList<String>>();
		
		dfs(root, finalRes, current);
		
		for(ArrayList<String> item: finalRes){
			StringBuilder sb = new StringBuilder();
			sb.append(item.get(0));
			for(int i = 1; i < item.size(); i++)
				sb.append("->"+ item.get(i));
			
			result.add(sb.toString());
		}
		
		return result;
	}

	/**
	 * @param root
	 * @param finalRes
	 * @param current
	 */
	private static void dfs(TreeNode root, ArrayList<ArrayList<String>> finalRes, ArrayList<String> current) {
		current.add(String.valueOf(root.data));
		
		if(root.left == null && root.right == null){
			finalRes.add(current);
			return;
		}
		
		if(root.left != null){
			ArrayList<String> temp = new ArrayList<String>(current);
			dfs(root.left, finalRes, temp);
		}
		
		if(root.right != null){
			ArrayList<String> temp = new ArrayList<String>(current);
			dfs(root.right, finalRes, temp);
		}
	}

}