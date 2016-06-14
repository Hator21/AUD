package b07;

/**
 * Class for the redblack tree.
 *
 * @author karl
 *
 */
public class RBTree implements IRBTree {
	private RBNode root;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RBNode search(final int key) {
		RBNode tmp;
		RBNode prev = null;

		if (this.root == null) {
			return null;
		}
		tmp = this.root;

		while (tmp != null) {
			if (key < tmp.getKey()) {
				prev = tmp;
				tmp = tmp.getLeft();
			} else if (key > tmp.getKey()) {
				prev = tmp;
				tmp = tmp.getRight();
			} else {
				return tmp;
			}
		}

		return prev;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(final int key) {
		if ((this.search(key) != null) && (this.search(key) != this.root)) {
			RBNode parent = this.search(key);
			RBNode node = new RBNode();
			NodeColor color = null;
			RBNode nil = null;
			String direction = "LEFT";//Wo kriege ich die richtung her ??? KALLE

			node.setColor(color.RED);
			node.setLeft(nil);
			node.setRight(nil);
			node.setParent(parent);//ka ob richtig mit kalle reden
			if (node.getParent() != null) {
				if (direction.equals("LEFT")) {
					parent.setLeft(node);
				} else {
					parent.setRight(node);
				}
			}
			int x = 0;
			while (x == 0) {
				// Bedingung_1:
				if (parent == null) {
					node.setColor(color.BLACK);
					this.root = node;
					return;
				}
				// Bedingung_2:
				if (parent.getColor().equals(color.BLACK)) {
					return;
				}
				RBNode grandparent = node.getGrandeparent(node);
				RBNode uncle = node.getUncle(node);
				// Bedingung_3:
				if (uncle.equals(null) && uncle.getColor().equals(color.RED)) {
					parent.setColor(color.BLACK);
					uncle.setColor(color.BLACK);
					grandparent.setColor(color.RED);
					node = grandparent;
					node.setParent(node.getParent());
					continue;
				}
				// Bedingung_4:
				if ((node == parent.getRight()) && (parent == grandparent.getLeft())) {
					//rotation links
				} else if ((node == parent.getLeft()) && (parent == grandparent.getRight())) {
					//rotation rechts
				}
				// Bedingung_5:
				if ((node == parent.getLeft()) && (parent == grandparent.getLeft())) {
					//rotation rechts

				} else {
					//rotation links
				}
				parent.setColor(color.BLACK);
				grandparent.setColor(color.RED);
				return;
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(final int key) {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void modify(final int key, final int newKey) {}

}
