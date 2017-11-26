/**
 * Problem 637. Average of Levels in Binary Tree
 * 
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 */
package mandeep.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mandeep
 *
 */
public class AverageOfLevels {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		List<Double> average = averageOfLevels(root);
		
		for(Double item: average)
			System.out.println(item);
	}

	/**
	 * Using BFS
	 * @param root
	 * @return
	 */
	private static List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		
		if(root == null)
			return result;
		
		que.add(root);
		while(!que.isEmpty()){
			int len = que.size();
			
			double sum = 0.0;
			for(int i = 0; i < len; i++){
				TreeNode node = que.poll();
				sum += node.data;
				if(node.left != null)
					que.offer(node.left);
				
				if(node.right != null)
					que.offer(node.right);
			}
			result.add(sum / len);
		}
		
		return result;
	}

}