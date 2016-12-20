package baum;

public interface IBinaryTreeNode<TKey extends Comparable<TKey>, TValue> {
	public TKey getKey();

	public void setKey(TKey key);

	public TValue getValue();

	public void setValue(TValue value);

	public IBinaryTreeNode getLeftChild();

	public void setLeftChild(IBinaryTreeNode node);

	public IBinaryTreeNode getRightChild();

	public void setRightChild(IBinaryTreeNode node);

	public int getLevel();

	public void setLevel(int level);
}
