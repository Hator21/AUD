package ADS234Tree;

import java.util.Comparator;

public class TwoFourNode<T> {

	protected final TwoFourNode<T>	divorcedAndChildless	= null;
	protected TwoFourNode<T>		children[]				= new TwoFourNode[4];

	protected Comparator<T>			c;

	private T[]						elems					= (T[]) new Object[3];

	protected TwoFourNode<T>		parent;
	protected int					numberOfElems;

	/**
	 * Default-Constructor
	 */
	public TwoFourNode() {
		numberOfElems = 0;
		c = new DefaultComparator<T>();
	}

	/**
	 * Returns number of Elements
	 * 
	 * @return number of Elements
	 */
	public int howManyElems() {
		return numberOfElems;
	}

	/**
	 * Number of Elements in the Subtree with this Node as Root
	 * 
	 * @return number of Elements in the Subtree
	 */
	public int size() {
		// If this is a leaf return number of elements
		if (this.leaf() == true) {
			return numberOfElems;
		}

		int sum = numberOfElems;
		// Add size of all children
		for (int i = 0; i < numberOfElems + 1; i++) {
			sum += getChild(i).size();
		}

		return sum;
	}

	/**
	 * Return if Node is a leaf
	 * 
	 * @return Node = leaf?
	 */
	public boolean leaf() {
		TwoFourNode<T> test = firstChild();
		if (test == divorcedAndChildless) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Add a Child to this Node
	 * 
	 * @param i
	 * @param node
	 */
	public void createEdge(int i, TwoFourNode<T> node) {
		children[i] = node;
		if (node != divorcedAndChildless)
			node.parent = this;
	}

	/**
	 * Remove a Child from this node
	 * 
	 * @param i
	 * @return
	 */
	public TwoFourNode<T> removeEdge(int i) {
		TwoFourNode<T> tmp = getChild(i);
		children[i] = divorcedAndChildless;
		return tmp;
	}

	/**
	 * Returns parent of the Node
	 * 
	 * @return parent
	 */
	public TwoFourNode<T> parent() {
		return parent;
	}

	/**
	 * Returns first Child
	 * 
	 * @return first Child
	 */
	public TwoFourNode<T> firstChild() {
		return children[0];
	}

	/**
	 * Returns last Child
	 * 
	 * @return last Child
	 */
	public TwoFourNode<T> lastChild() {
		return children[numberOfElems];
	}

	/**
	 * Returns the Child at index i
	 * 
	 * @param i
	 * @return Child at index i
	 */
	public TwoFourNode<T> getChild(int i) {
		return children[i];
	}

	/**
	 * Returns Array of all children
	 * 
	 * @return Array of all children
	 */
	public TwoFourNode<T>[] getChildren() {
		return children;
	}

	/**
	 * Returns Element at index i
	 * 
	 * @param i
	 * @return Element at index i
	 */
	public T getElem(int i) {
		return elems[i];
	}

	/**
	 * Returns the smallest Element
	 * 
	 * @return smallest Element
	 */
	public T smallestElem() {
		return elems[0];
	}

	/**
	 * Returns the largest Element
	 * 
	 * @return largest Element
	 */
	public T largestElem() {
		return elems[numberOfElems - 1];
	}

	/**
	 * Return true if Elements >= 3
	 * 
	 * @return Elements >= 3 = true
	 */
	public boolean full() {
		if (numberOfElems >= 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns index of an Element
	 * 
	 * @param x
	 * @return index of the Element "x"
	 */
	public int findElem(T x) {
		int flag = -1;

		for (int i = 0; i < 3; i++) {
			if (elems[i] == null) {
				break;
			} else if (c.compare(elems[i], x) == 0) {
				flag = i;
			}
		}
		return flag;
	}

	/**
	 * Finds T that is greater than X, but less than max
	 * Returns index of T
	 * 
	 * @param x
	 * @param max
	 * @return index of T
	 */
	public int findG(T x, T max) {
		int flag = -1;
		for (int i = 0; i < 3; i++) {
			if (elems[i] == null) {
				break;
			} else if ((c.compare(elems[i], x) > 0) && (c.compare(elems[i], max) < 0)) {
				flag = i;
				break;
			}
		}
		return flag;
	}

	/**
	 * Finds T that is less than x, but more than min
	 * Returns index of T
	 * 
	 * @param x
	 * @param min
	 * @return index of T
	 */
	public int findLT(T x, T min) {

		int flag = -1;
		for (int i = 2; i >= 0; i--) {
			if (elems[i] == null) {
				continue;
			} else if ((c.compare(elems[i], x) < 0) && (c.compare(elems[i], min) > 0)) {
				flag = i;
				break;
			}
		}
		return flag;
	}

	/**
	 * Finds T that is greater or equal than X, but less than max
	 * Returns index of T
	 * 
	 * @param x
	 * @param max
	 * @return index of T
	 */
	public int findGE(T x, T max) {
		int flag = -1;
		for (int i = 0; i < 3; i++) {
			if (elems[i] == null) {
				break;
			} else if ((c.compare(elems[i], x) >= 0) && (c.compare(elems[i], max) < 0)) {
				flag = i;
				break;
			}
		}

		return flag;
	}

	/**
	 * Removes the right most element
	 * Queue remove
	 * 
	 * @return deleted Element
	 */
	public T remove() {

		numberOfElems--;
		T elem = elems[numberOfElems];
		elems[numberOfElems] = null;
		return elem;
	}

	/**
	 * Add a new element to current TwoFourNode
	 * Returns index of where value was added
	 * 
	 * @param obj
	 * @return index of where value was added
	 */
	public int addNewElem(T obj) {

		if (full())
			return -1;
		// Inc node
		numberOfElems++;

		int indexToReturn = 0;
		// Shift left like arrayList
		for (int i = elems.length - 1; i >= 0; i--) { // 3 - 1 = 2
			if (elems[i] == null)
				continue;
			else {

				T k = elems[i];
				if (c.compare(obj, k) < 0)
					elems[i + 1] = elems[i];

				// No more shifting
				else {
					elems[i + 1] = obj; // insert elem
					indexToReturn = i + 1; // store index
					break;
				}
			}
		}
		elems[indexToReturn] = obj;
		// Return index where added
		return indexToReturn;
	}

	/**
	 * Remove Element at Index (<strong> param: index </strong>) and shift rest
	 * to the left to fill free space
	 * 
	 * @param index
	 * @return the Element that will remove
	 */
	public T removeElem(int index) {
		T toReturn = getElem(index);
		int i;
		for (i = index; i < numberOfElems - 1; i++) {
			elems[i] = elems[i + 1];
		}
		elems[i] = null;
		numberOfElems--;

		return toReturn;

	}

	/**
	 * Returns all elements as one String
	 * 
	 * @return all elements as one String
	 */
	@Override
	public String toString() {
		String str = "|";
		for (int i = 0; i < howManyElems(); i++) {
			str += elems[i] + "|";
		}
		return str;
	}
}
