package leetcode.trees;

public class TreeTraversalRecursive {
	public static void PreOrder(TreeNode root){
		if(root != null){
			System.out.print(root.data+ " ");
			PreOrder(root.left);
			PreOrder(root.right);
		}
	}

	public static void PostOrder(TreeNode root){
		if(root != null){
			PostOrder(root.left);
			PostOrder(root.right);
			System.out.print(root.data+ " ");
		}
	}

	public static void InOrder ( TreeNode root ){
		if(root != null){
			InOrder(root.left);
			System.out.print(root.data+ " ");
			InOrder(root.right);
		}
	}

	public static void main(String[] args){
		TreeNode root = CreateTree.createTree();
		System.out.print("Pre-Order Traversal: ");
		PreOrder(root);

		System.out.print("\nIn-Order Traversal: ");
		InOrder(root);

		System.out.print("\nPost-Order Traversal: ");
		PostOrder(root);
	}
}