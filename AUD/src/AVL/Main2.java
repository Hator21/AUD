package AVL;

public class Main2 {

	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		for (int i = 1; i <= 10; i++)
			tree.insert((int) (Math.random() * 100), (int) (Math.random() * 100));

		tree.PrintTree();
	}
}
