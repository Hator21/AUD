package ADS234Tree;

import java.util.ArrayList;
import java.util.TreeMap;

public interface IADS234Node<TKey extends Comparable<TKey>, TValue>{
	public TreeMap<TKey, TValue> getPairs();
	public void setPair(TreeMap<TKey, TValue> pairs);
	
	public ArrayList<IADS234Node<TKey, TValue>> getChildArray();
	public void setChildArray(ArrayList<IADS234Node<TKey, TValue>> children);
	
	public IADS234Node<TKey, TValue> getParent();
	public void setParent(IADS234Node<TKey, TValue> parent); 
	
	IADS234Node<TKey, TValue> getRoot();
}
