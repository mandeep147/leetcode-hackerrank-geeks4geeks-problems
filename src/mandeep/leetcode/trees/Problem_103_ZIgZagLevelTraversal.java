/**
 * Problem 103 : Binary Tree Zigzag Level Order Traversal
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * [
 * 	[3],
 * 	[20,9],
 * 	[15,7]
 * ]
 * 
 */
package mandeep.leetcode.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author mandeep
 *
 */
public class Problem_103_ZIgZagLevelTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		List<List<Integer>> res = zigzagLevelOrder(root);
		for(List<Integer> x : res){
			Iterator<Integer> iterate = x.iterator();
			while(iterate.hasNext()){
				System.out.print(iterate.next()+" ");
			}
			System.out.println();
		}
	}

	/**
	 * @param root
	 * @return
	 */
	private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>>  res = new ArrayList<List<Integer>> ();
		zigzag(root, res, 0);
		return res;
	}

	/**
	 * @param root
	 * @param res
	 * @param i
	 */
	private static void zigzag(TreeNode curr, List<List<Integer>> res, int level) {
		if(curr == null)
			return;
		
		if(res.size() <= level){
			List<Integer> nextLevel = new LinkedList<>();
			res.add(nextLevel);
		}
		
		List<Integer> allNodes = res.get(level);
		if(level % 2 == 0)
			allNodes.add(curr.data);
		else
			allNodes.add(0, curr.data);
		
		zigzag(curr.left, res, level+1);
		zigzag(curr.right, res, level+1);
	}
}