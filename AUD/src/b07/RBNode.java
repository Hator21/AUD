package b07;

/**
 * Class for the red/black node.
 *
 * @author karl
 *
 */
public class RBNode implements IRBNode {
	private int			key;
	private NodeColor	color;
	private RBNode		parent;
	private RBNode		left;
	private RBNode		right;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setKey(final int newKey) {
		this.key = newKey;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getKey() {
		return this.key;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setColor(final NodeColor newColor) {
		this.color = newColor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NodeColor getColor() {
		return this.color;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setParent(final RBNode newParent) {
		this.parent = newParent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RBNode getParent() {
		return this.parent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLeft(final RBNode newLeft) {
		this.left = newLeft;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RBNode getLeft() {
		return this.left;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRight(final RBNode newRight) {
		this.right = newRight;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RBNode getRight() {
		return this.right;
	}

	/**
	 * gets the grandparent oft the node.
	 *
	 * @param N
	 * @return grantparent
	 */
	public RBNode getGrandeparent(RBNode N) {
		return N.getParent().getParent();
	}

	/**
	 * gets the uncle oft the node.
	 *
	 * @param N
	 * @return uncle
	 */
	public RBNode getUncle(RBNode N) {
		if (N.getParent() == N.getGrandeparent(N).getLeft()) {
			return N.getGrandeparent(N).getRight();
		} else {
			return N.getGrandeparent(N).getLeft();
		}
	}

	public RBNode siblingOf(RBNode n) {
		return ((n == null) || (n.getParent() == null)) ? null : (n == n.getParent().getLeft()) ? n.getParent().getRight() : n.getParent().getLeft();
	}
}
