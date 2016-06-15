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
		if (this.root == null) {
			this.root = new RBNode();
			this.root.setKey(key);
		}
		RBNode node = this.root;
		while (true) {

			if (key == node.getKey()) {
				node.setKey(key);
				return;
			} else if (key < node.getKey()) {
				if (node.getLeft() == null) {
					RBNode left = new RBNode();
					left.setKey(key);
					node.setLeft(left);
					this.adjustAfterInsertion(node.getLeft());
					break;
				}
				node = node.getLeft();
			} else {
				if (node.getRight() == null) {
					RBNode right = new RBNode();
					right.setKey(key);
					node.setRight(right);
					this.adjustAfterInsertion(node.getRight());
					break;
				}
				node = node.getRight();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(final int key) {
		RBNode deleteTarget = this.search(key);

		if (deleteTarget == null) {
			return;
		}

		if (deleteTarget.getKey() != key) {
			return;
		}
		if ((deleteTarget.getLeft() != null) && (deleteTarget.getRight() != null)) {
			RBNode maxOnTheLeft = this.findMax(deleteTarget.getLeft());
			deleteTarget.setKey(maxOnTheLeft.getKey());

		}

		RBNode pullUp = deleteTarget.getLeft() == null ? deleteTarget.getRight() : deleteTarget.getLeft();
		if (pullUp != null) {

			if (deleteTarget == this.root) {
				this.root = pullUp;
			} else if (deleteTarget.getParent().getLeft() == deleteTarget) {
				deleteTarget.getParent().setLeft(pullUp);
			} else {
				deleteTarget.getParent().setRight(pullUp);
			}
			if (deleteTarget.getColor() == NodeColor.BLACK) {
				this.adjustAfterRemoval(pullUp);
			}
		} else if (deleteTarget == this.root) {
			this.root = null;
		} else {
			if (deleteTarget.getColor() == NodeColor.BLACK) {
				this.adjustAfterRemoval(deleteTarget);
			}
			if (deleteTarget.getParent().getLeft() == deleteTarget) {
				deleteTarget.getParent().setLeft(null);
			} else {
				deleteTarget.getParent().setRight(null);
			}
		}
	}

	private RBNode findMax(final RBNode startNode) {
		RBNode tmp = startNode;
		RBNode prev = null;

		while (tmp != null) {
			prev = tmp;
			tmp = tmp.getRight();
		}

		return prev;

	}

	private void adjustAfterRemoval(RBNode n) {
		while ((n != this.root) && (n.getColor() == NodeColor.BLACK)) {
			if (n == n.getParent().getLeft()) {
				// Pulled up node is a left child
				RBNode sibling = n.getParent().getRight();
				if (sibling.getColor() == NodeColor.RED) {
					sibling.setColor(NodeColor.BLACK);
					n.getParent().setColor(NodeColor.RED);
					this.rotateLeft(n.getParent());
					sibling = n.getParent().getRight();
				}
				if ((sibling.getLeft().getColor() == NodeColor.BLACK) && (sibling.getRight().getColor() == NodeColor.BLACK)) {
					sibling.setColor(NodeColor.RED);
					n = n.getParent();
				} else {
					if (sibling.getRight().getColor() == NodeColor.BLACK) {
						sibling.getLeft().setColor(NodeColor.BLACK);
						sibling.setColor(NodeColor.RED);
						this.rotateRight(sibling);
						sibling = n.getParent().getRight();
					}

					sibling.setColor(sibling.getParent().getColor());
					sibling.getParent().setColor(NodeColor.BLACK);
					sibling.getRight().setColor(NodeColor.BLACK);
					this.rotateLeft(n.getParent());
					n = this.root;
				}
			} else {
				// pulled up node is a right child
				RBNode sibling = n.getParent().getLeft();
				if (sibling.getColor() == NodeColor.RED) {
					sibling.setColor(NodeColor.BLACK);
					sibling.getParent().setColor(NodeColor.RED);
					this.rotateRight(n.getParent());
					sibling = n.getParent().getLeft();

				}
				if ((sibling.getLeft().getColor() == NodeColor.BLACK) && (sibling.getRight().getColor() == NodeColor.BLACK)) {
					sibling.setColor(NodeColor.RED);
					n = n.getParent();
				} else {
					if (sibling.getLeft().getColor() == NodeColor.BLACK) {
						sibling.getRight().setColor(NodeColor.BLACK);
						sibling.setColor(NodeColor.RED);
						this.rotateLeft(sibling);
						sibling = n.getParent().getLeft();
					}
					sibling.setColor(n.getParent().getColor());
					n.getParent().setColor(NodeColor.BLACK);
					sibling.getLeft().setColor(NodeColor.BLACK);
					this.rotateRight(n.getParent());
					n = this.root;
				}
			}
		}
		n.setColor(NodeColor.BLACK);
	}

	private void rotateLeft(final RBNode n) {
		if (n.getRight() == null) {
			return;
		}
		RBNode oldRight = n.getRight();
		n.setRight(oldRight.getLeft());
		if (n.getParent() == null) {
			this.root = oldRight;
		} else if (n.getParent().getLeft() == n) {
			n.getParent().setLeft(oldRight);
		} else {
			n.getParent().setRight(oldRight);
		}
		oldRight.setLeft(n);
	}

	private void rotateRight(final RBNode n) {
		if (n.getLeft() == null) {
			return;
		}
		RBNode oldLeft = n.getLeft();
		n.setLeft(oldLeft.getRight());
		if (n.getParent() == null) {
			this.root = oldLeft;
		} else if (n.getParent().getLeft() == n) {
			n.getParent().setLeft(oldLeft);
		} else {
			n.getParent().setRight(oldLeft);
		}
		oldLeft.setRight(n);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void modify(final int key, final int newKey) {
		RBNode tmp;

		tmp = this.search(key);
		if (tmp == null) {
			return;
		}
		if (tmp.getKey() != key) {
			return;
		}

		this.delete(key);

		this.insert(newKey);
	}

	@Override
	public void inOrder(final RBNode tmp) {
		if (tmp != null) {

			System.out.printf("%d ", tmp.getKey());
			this.inOrder(tmp.getRight());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inOrder() {
		this.inOrder(this.root);
	}

	/**
	 * Classic algorithm for fixing up a tree after inserting a node.
	 */
	private void adjustAfterInsertion(RBNode n) {
		// Step 1: color the node red
		n.setColor(NodeColor.RED);

		// Step 2: Correct double red problems, if they exist
		if ((n != null) && (n != this.root) && n.getColor().equals(NodeColor.RED)) {

			// Step 2a (simplest): Recolor, and move up to see if more work
			// needed
			//RBNode sibling = n.getParent().getRight();
			if ((n.siblingOf(n.getParent()) != null) && n.siblingOf(n.getParent()).getColor().equals(NodeColor.RED)) {
				n.getParent().setColor(NodeColor.BLACK);
				n.siblingOf(n).setColor(NodeColor.BLACK);
				n.getGrandeparent(n).setColor(NodeColor.RED);
				this.adjustAfterInsertion(n.getGrandeparent(n));
			}

			// Step 2b: Restructure for a parent who is the left child of the
			// grandparent. This will require a single right rotation if n is
			// also
			// a left child, or a left-right rotation otherwise.
			else if ((n.getParent() != null) && (n.getParent() == n.getGrandeparent(n).getLeft())) {
				if (n == n.getParent().getRight()) {
					this.rotateLeft(n = n.getParent());
				}
				n.getParent().setColor(NodeColor.BLACK);
				n.getGrandeparent(n).setColor(NodeColor.RED);
				this.rotateRight(n.getGrandeparent(n));
			}

			// Step 2c: Restructure for a parent who is the right child of the
			// grandparent. This will require a single left rotation if n is
			// also
			// a right child, or a right-left rotation otherwise.
			else if ((n.getParent() != null) && (n.getParent() == n.getGrandeparent(n).getRight())) {
				if (n == n.getParent().getLeft()) {
					this.rotateRight(n = n.getParent());
				}
				n.getParent().setColor(NodeColor.BLACK);
				n.getGrandeparent(n).setColor(NodeColor.RED);
				this.rotateLeft(n.getGrandeparent(n));
			}

		}

		// Step 3: Color the root black
		this.root.setColor(NodeColor.BLACK);
	}
}
