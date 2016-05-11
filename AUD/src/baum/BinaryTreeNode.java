package baum;

import Praktikum4ADS.IBinaryTreeNode;

public class BinaryTreeNode implements Praktikum4ADS.IBinaryTreeNode<Integer, Integer>{
	private Integer key;
	private Integer value;
	private BinaryTreeNode leftchild;
	private BinaryTreeNode rightchild;
	
	
	
	@Override
	public Integer getKey() {
		return key;
	}

	@Override
	public IBinaryTreeNode getLeftChild() {
		return leftchild;
	}

	@Override
	public IBinaryTreeNode getRightChild() {
		return rightchild;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void setKey(Integer arg0) {
		key = arg0;
		
	}

	@Override
	public void setValue(Integer arg0) {
		value = arg0;
		
	}

	@Override
	public void setLeftChild(IBinaryTreeNode arg0) {
		leftchild = (BinaryTreeNode) arg0;
	}

	@Override
	public void setRightChild(IBinaryTreeNode arg0) {
		rightchild = (BinaryTreeNode) arg0;
		
	}

}
