package ADS234Tree;


public interface IADS234Tree<TKey extends Comparable<TKey>, TValue>{
	
	void insert(IADS234Node<TKey, TValue> toAdd);

	void delete(TKey k);

	void modify(IADS234Node<TKey, TValue> oldNode, IADS234Node<TKey, TValue> newNode);
	
	IADS234Node<TKey, TValue> search(TKey toFind);
	
	IADS234Node<TKey, TValue> getRoot();
}
