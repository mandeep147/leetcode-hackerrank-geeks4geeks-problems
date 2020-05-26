/**
 * Problem 107. Binary Tree Level Order Traversal II
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 */
package leetcode.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mandeep
 *
 */
public class LevelOrderBottom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		List<List<Integer>> levelOrder = levelOrderBottom(root);
		
		for(List<Integer> list : levelOrder){
			for(Integer item: list)
				System.out.print(item+" ");
			System.out.println();
		}
		
List<List<Integer>> levelOrderDFS = levelOrderBottomDFS(root);
		
		for(List<Integer> list : levelOrderDFS){
			for(Integer item: list)
				System.out.print(item+" ");
			System.out.println();
		}
	}

	/**
	 * Using DFS
	 * @param root
	 * @return
	 */
	private static List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		
		createLevel(list, root, 0);
		return list;
	}

	/**
	 * @param list
	 * @param root
	 * @param i
	 */
	private static void createLevel(List<List<Integer>> list, TreeNode root, int level) {
		if(root == null)
			return;
		
		if(level >= list.size())
			list.add(0, new LinkedList<Integer>());
		
		createLevel(list, root.left, level + 1);
		createLevel(list, root.right, level + 1);
		list.get(list.size() - level -1).add(root.data);
	}

	/**
	 * using BFS
	 * @param root
	 * @return
	 */
	private static List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		
		if(root == null)
			return list;
		
		que.offer(root);
		
		while(!que.isEmpty()){
			int level = que.size();
			List<Integer> subList = new LinkedList<Integer>();
			
			for(int i = 0; i < level; i++){
				TreeNode node = que.peek();
				if(node.left != null)
					que.offer(node.left);
				if(node.right != null)
					que.offer(node.right);
				
				subList.add(que.poll().data);
			}
			list.add(0, subList);
		}
		
		return list;
	}

}