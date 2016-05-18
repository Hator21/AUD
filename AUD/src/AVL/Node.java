package AVL;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

	private T		data;
	private T	value;
	private Node<T>	left;
	private Node<T>	right;
	public int		level;
	private int		depth;

	public Node(T data, T value) {
		this(data, value, null, null);
	}

	public Node(T data, T value, Node<T> left, Node<T> right) {
		super();
		this.data = data;
		this.value = value;
		this.left = left;
		this.right = right;
		if (left == null && right == null)
			setDepth(1);
		else if (left == null)
			setDepth(right.getDepth() + 1);
		else if (right == null)
			setDepth(left.getDepth() + 1);
		else
			setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth
	 *            the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public int compareTo(Node<T> o) {
		return this.data.compareTo(o.data);
	}

	// @Override
	// public String toString() {
	// return "Level " + level + ": " + data;
	// }
	@Override
	public String toString() {
		if (this.getLeft() != null && this.getRight() != null) {
			return "Level " + level + ": " + data + " -> " + value + " || left " + this.getLeft().data + " -> " + value + " | right " + this.getRight().data + " -> " + value;
		} else if (this.getLeft() != null && this.getRight() == null) {
			return "Level " + level + ": " + data + " -> " + value + " || left " + this.getLeft().data + " -> " + value;
		} else if (this.getLeft() == null && this.getRight() != null) {
			return "Level " + level + ": " + data + " -> " + value + " || right " + this.getRight().data + " -> " + value;
		}

		return "Level " + level + ": " + data + " -> " + value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
