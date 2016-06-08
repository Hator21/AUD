package ADS234Tree;

import java.util.ArrayList;
import java.util.TreeMap;

public class ADS234Tree<TKey extends Comparable<TKey>, TValue> implements IADS234Tree<TKey, TValue>{
	private IADS234Node<TKey, TValue> root;
	
	
	public ADS234Tree() {
		root = null;
	}
	
	
	@Override
	public void insert(IADS234Node<TKey, TValue> toAdd) {
		IADS234Node<TKey, TValue> activeNode;
		
		if(toAdd == null || toAdd.getPairs().size() > 1) {
			return;
		}
		if(search(toAdd.getPairs().firstKey()) != null) {
			return;
		}
		if(root == null) {
			root = toAdd;
			return;
		}
		activeNode = root;
		
		while(activeNode != null) {
			if(activeNode.getPairs().size() == 3) {
				Object activeKeys[] = activeNode.getPairs().keySet().toArray();
				IADS234Node<TKey, TValue> newFromMid = new ADS234TreeNode<TKey, TValue>();
				newFromMid.setPair(new TreeMap<TKey, TValue>());
				newFromMid.getPairs().put((TKey) activeKeys[1], activeNode.getPairs().get((TKey) activeKeys[1]));
				
				IADS234Node<TKey, TValue> newFromLeft = new ADS234TreeNode<TKey, TValue>();
				newFromLeft.setPair(new TreeMap<TKey, TValue>());
				newFromLeft.getPairs().put((TKey) activeKeys[0], activeNode.getPairs().get((TKey) activeKeys[0]));
				newFromLeft.setParent(newFromMid);
				
				IADS234Node<TKey, TValue> newFromRight = new ADS234TreeNode<TKey, TValue>();
				newFromRight.setPair(new TreeMap<TKey, TValue>());
				newFromRight.getPairs().put((TKey) activeKeys[2], activeNode.getPairs().get((TKey) activeKeys[2]));
				newFromRight.setParent(newFromMid);
				
				newFromMid.setChildArray(new ArrayList<IADS234Node<TKey,TValue>>());
				newFromMid.getChildArray().add(newFromLeft);
				newFromMid.getChildArray().add(newFromRight);
				
				newFromLeft.setChildArray(new ArrayList<IADS234Node<TKey,TValue>>());
				newFromLeft.getChildArray().add(activeNode.getChildArray().get(0));
				newFromLeft.getChildArray().add(activeNode.getChildArray().get(1));

				newFromRight.setChildArray(new ArrayList<IADS234Node<TKey,TValue>>());
				newFromRight.getChildArray().add(activeNode.getChildArray().get(2));
				newFromRight.getChildArray().add(activeNode.getChildArray().get(3));				
				if(activeNode == root) {
					root = newFromMid;
				}
				else {
					int ind = activeNode.getParent().getChildArray().lastIndexOf(activeNode);
					activeNode.getParent().getChildArray().remove(ind);
					activeNode.getParent().getChildArray().add(ind, newFromMid);
				}
				activeNode = newFromMid;
			}
			else {

				
					
			}
		}
	}
	private IADS234Node<TKey, TValue> findRightNodeForKey(TKey toFind) {
		int	activeElement = 0;
		IADS234Node<TKey, TValue> activeNode = root;
		
		if(root == null || toFind == null)
			return null;
		
		while(activeNode != null) {
			Object activeKeys[] = activeNode.getPairs().keySet().toArray();
			
			if(((TKey)activeKeys[activeElement]).compareTo(toFind) > 0) {
				if(activeNode.getChildArray().get(activeElement) == null)
					break;
				activeNode = activeNode.getChildArray().get(activeElement);
				activeElement = 0;
			}
			else {
				activeElement++;
				if(activeNode.getPairs().size() == activeElement) {
					if(activeNode.getChildArray().get(activeElement) == null)
						break;
					activeNode = activeNode.getChildArray().get(activeElement);
					activeElement = 0;
				}
					
			}
		}
		return activeNode;		
	}
	@Override
	public void delete(TKey k) {
	}

	@Override
	public void modify(IADS234Node<TKey, TValue> oldNode, IADS234Node<TKey, TValue> newNode) {
	}

	@Override
	public IADS234Node<TKey, TValue> search(TKey toFind) {
		int	activeElement = 0;
		IADS234Node<TKey, TValue> activeNode = root;
		
		if(root == null || toFind == null)
			return null;
		
		while(activeNode != null) {
			Object activeKeys[] = activeNode.getPairs().keySet().toArray();
			if(activeKeys[activeElement] == toFind)
				break;
			
			if(((TKey)activeKeys[activeElement]).compareTo(toFind) > 0) {
					activeNode = activeNode.getChildArray().get(activeElement);
					activeElement = 0;
			}
			else {
				activeElement++;
				if(activeNode.getPairs().size() == activeElement) {
					activeNode = activeNode.getChildArray().get(activeElement);
					activeElement = 0;
				}
					
			}
		}
		return activeNode;

	}

	@Override
	public IADS234Node<TKey, TValue> getRoot() {
		return root;
	}



}
