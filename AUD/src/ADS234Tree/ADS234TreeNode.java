package ADS234Tree;

import java.util.ArrayList;
import java.util.TreeMap;



public class ADS234TreeNode<TKey extends Comparable<TKey>, TValue> implements IADS234Node<TKey, TValue>{
	private TreeMap<TKey, TValue> pairs;
	private ArrayList<IADS234Node<TKey, TValue>> childArray;
	private IADS234Node<TKey, TValue> parent;
	
	
	@Override
	public TreeMap<TKey, TValue> getPairs() {
		return pairs;
	}

	@Override
	public void setPair(TreeMap<TKey, TValue> pairs) {
		this.pairs = pairs;
	}

	@Override
	public ArrayList<IADS234Node<TKey, TValue>> getChildArray() {
		return childArray;
	}

	@Override
	public void setChildArray(ArrayList<IADS234Node<TKey, TValue>> children) {
		childArray = children;
	}

	@Override
	public IADS234Node<TKey, TValue> getParent() {
		return parent;
	}

	@Override
	public void setParent(IADS234Node<TKey, TValue> parent) {
		this.parent = parent;
	}

	@Override
	public IADS234Node<TKey, TValue> getRoot() {
		return null;
	}

}
