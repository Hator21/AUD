package b07;

public class Run {

	public static void main(String[] args) {
		RBTree tree = new RBTree();
		tree.insert(1);
		tree.insert(2);
		tree.insert(16);
		tree.insert(4);
		tree.insert(21);
		tree.inOrder();
		System.out.println("\n____________________________________________________");
		tree.delete(2);
		tree.inOrder();
		System.out.println("\n____________________________________________________");
	}

}
