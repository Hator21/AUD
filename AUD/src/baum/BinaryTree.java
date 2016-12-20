package baum;

import java.util.ArrayList;

public class BinaryTree {
	private BinaryTreeNode	root;

	public void insert(BinaryTreeNode node) {
		BinaryTreeNode tmp;
		BinaryTreeNode save;
		int level = 0;

		if (node == null)
			return;

		tmp = root;
		save = null;

		while (tmp != null) {
			save = tmp;
			if (node.getKey() < tmp.getKey()) {
				tmp = (BinaryTreeNode) tmp.getLeftChild();
				level++;
			} else {
				if (node.getKey() > tmp.getKey()) {
					tmp = (BinaryTreeNode) tmp.getRightChild();
					level++;
				} else
					return;
			}
		}

		if (root == null)
			root = node;
		else if (node.getKey() < save.getKey())
			save.setLeftChild(node);

		else
			save.setRightChild(node);
		node.setLevel(level + 1);
		return;

	}

	private BinaryTreeNode get_parent(BinaryTreeNode node) {
		BinaryTreeNode tmp = getRoot();
		BinaryTreeNode save = null;

		if (node == null)
			return null;

		while ((tmp != null)) {
			save = tmp;
			if (node.getKey() < tmp.getKey())
				tmp = (BinaryTreeNode) tmp.getLeftChild();
			else if (node.getKey() > tmp.getKey())
				tmp = (BinaryTreeNode) tmp.getRightChild();

			if (tmp.getKey() == node.getKey())
				break;
		}
		return save;
	}

	private BinaryTreeNode find_min(BinaryTreeNode start) {
		BinaryTreeNode tmp = (BinaryTreeNode) start;
		BinaryTreeNode save;

		if (start == null)
			return null;

		do {
			save = tmp;
			tmp = (BinaryTreeNode) tmp.getLeftChild();
		} while (tmp != null);

		return save;
	}

	public boolean delete(BinaryTreeNode node) {
		BinaryTreeNode par;
		BinaryTreeNode min;

		if (node == null)
			return false;

		if (node.getLeftChild() == null && node.getRightChild() == null) {
			if ((par = get_parent(node)) == null)
				return false;
			if (node.getKey() > par.getKey())
				par.setRightChild(null);
			else
				par.setLeftChild(null);
		} else if (node.getLeftChild() == null && node.getRightChild() != null) {
			if ((par = get_parent(node)) == null)
				return false;
			if (node.getKey() > par.getKey())
				par.setRightChild(node.getRightChild());
			else
				par.setLeftChild(node.getRightChild());
		} else if (node.getLeftChild() != null && node.getRightChild() == null) {
			if ((par = get_parent(node)) == null)
				return false;
			if (node.getKey() > par.getKey())
				par.setRightChild(node.getLeftChild());
			else
				par.setLeftChild(node.getLeftChild());
		} else {
			min = find_min((BinaryTreeNode) node.getRightChild());
			par = get_parent(min);
			if (min == null || par == null)
				return false;
			System.out.println("Min" + String.valueOf(min.getKey()));
			delete(min);
			node.setKey(min.getKey());
			node.setValue(min.getValue());
		}

		return true;
	}

	public BinaryTreeNode search(BinaryTreeNode node) {
		BinaryTreeNode tmp;

		if (node == null || root == null)
			return null;

		tmp = root;
		while ((tmp != null) && (tmp.getKey() != node.getKey())) {
			if (node.getKey() < tmp.getKey())
				tmp = (BinaryTreeNode) tmp.getLeftChild();
			else if (node.getKey() > tmp.getKey())
				tmp = (BinaryTreeNode) tmp.getRightChild();
		}

		return tmp;
	}

	public BinaryTreeNode search(Integer matrikelnummer) {
		BinaryTreeNode tmp = new BinaryTreeNode();

		if (matrikelnummer == null)
			return null;
		tmp.setKey(matrikelnummer);

		return this.search(tmp);
	}

	public boolean modify(BinaryTreeNode node1, BinaryTreeNode node2) {
		if (node1 == null || node2 == null)
			return false;

		if (delete(node1) == false)
			return false;
		insert(node2);

		return true;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	public ArrayList<BinaryTreeNode> inorder() {
		ArrayList<BinaryTreeNode> l = new ArrayList<BinaryTreeNode>();

		class in {
			public void inorderRek(BinaryTreeNode x) {
				if (x == null)
					return;
				inorderRek((BinaryTreeNode) x.getLeftChild());
				l.add(x);
				inorderRek((BinaryTreeNode) x.getRightChild());

			}
		};
		in help = new in();
		help.inorderRek(root);

		return l;

	}
}
