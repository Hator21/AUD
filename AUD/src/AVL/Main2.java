package AVL;

public class Main2 {

	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.insert(10, 10);
		tree.insert(2, 2);
		tree.insert(18, 18);
		tree.insert(1, 1);
		tree.insert(7, 7);
		tree.insert(9, 9);
		tree.insert(8, 8);

		tree.PrintTree();
	}
}
