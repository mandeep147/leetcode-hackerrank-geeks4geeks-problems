/**
 * 
 */
package mandeep.leetcode.trees;

import java.util.*;

/**
 * @author mandeep
 * created on Mar 1, 2018, 1:47:41 AM
 */
public class Problem_102_BinaryTreeLevelOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = CreateTree.createTree();
		System.out.print("Level-Order Traversal: ");
//		LevelOrderTraversal.LevelOrder(root);
		List<List<Integer>> res = levelOrder(root);
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
	private static List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		List<List<Integer>> wrap = new LinkedList<List<Integer>>();
//		System.out.println(root.data);
		if(root == null)
			return wrap;
		
		que.offer(root);
		while(!que.isEmpty()){
			int level = que.size();
			List<Integer> subList = new LinkedList<Integer>();
			for(int i = 0; i < level; i++){
				if(que.peek().left != null)
					que.offer(que.peek().left);
				if(que.peek().right != null)
					que.offer(que.peek().right);
				
				subList.add(que.poll().data);
			}
			wrap.add(subList);
		}
		
		
		return wrap;
	}

}
