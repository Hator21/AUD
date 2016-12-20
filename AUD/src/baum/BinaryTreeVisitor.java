package baum;

public class BinaryTreeVisitor implements IBinaryTreeVisitor {

	String	res	= "";

	public BinaryTreeVisitor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visitText(BinaryTree binTree) {
		BinaryTreeNode root = binTree.getRoot();
		preorder(root);

	}

	public void preorder(IBinaryTreeNode root) {
		res = "";
		if (root != null) {
			for (int i = 0; i < root.getLevel() - 1; i++)
				res += "| ";
			System.out.printf(res + root.getValue() + "\n");
			preorder(root.getLeftChild());
			preorder(root.getRightChild());
		}
	}

	@Override
	public void visitAverage(BinaryTree binTree) {
		float average = 0;

		for (BinaryTreeNode tmp : binTree.inorder()) {
			average += (float) tmp.getValue();
		}

		System.out.println("\nAverage is:" + average / binTree.inorder().size());

	}

	@Override
	public void visitSum(BinaryTree binTree) {
		float sum = 0;

		for (BinaryTreeNode tmp : binTree.inorder()) {
			if (tmp.getLeftChild() == null && tmp.getRightChild() == null)
				sum += (float) tmp.getValue();
		}

		System.out.println("\nSum of leafs: " + sum);

	}

}
