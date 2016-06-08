package Blatt6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

/**
 * Simple-linked list implementation. Implements all optional list operations, and permits all
 * elements (including {@code null}).
 * 
 * @author Jonas-Lampe
 *
 * @param <T>
 *            - the type of elements held in this collection
 */
@SuppressWarnings("serial")
public class SimpleLinkedList<T> {

	public int		length	= 0;
	private Node<T>	head;

	/**
	 * Node for Simple-linked list
	 * 
	 * @author Jonas-Lampe
	 *
	 * @param <T>
	 *            - the type of elements held in this Node
	 */
	private static class Node<T> {
		T		item;
		Node<T>	next;

		/**
		 * Constructor for Node-class
		 * <p>
		 * Set item = (<strong> param: item </strong>)
		 * <br>
		 * Set next = (<strong> param: next </strong>)
		 * 
		 * @param item
		 *            - Value of the Node
		 * @param next
		 *            - Next Node
		 */
		Node(T element, Node<T> next) {
			this.item = element;
			this.next = next;
		}
	}

	/**
	 * Default-Constructor
	 * <p>
	 * Set head = null
	 */
	public SimpleLinkedList() {
		head = null;
	}

	/**
	 * Returns true if the list is empty else false
	 * 
	 * @return head == null -> true
	 *         <br>
	 *         head != null -> false
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Add a Node with the value (<strong> param: item </strong>) at the first position to the List
	 * 
	 * @param item
	 *            - value of the Node
	 */
	public void addFirst(T item) {
		head = new Node<T>(item, head);
	}

	/**
	 * Returns the value of the first Node
	 * 
	 * @return value of first Node
	 */
	public T getFirst() {
		if (head == null)
			throw new NoSuchElementException();
		return head.item;
	}

	/**
	 * Removes the first Node
	 * 
	 * @return value of the first Node
	 */
	public T removeFirst() {
		T tmp = getFirst();
		head = head.next;
		return tmp;
	}

	/**
	 * Add a Node with the value (<strong> param: item </strong>)at the last position to the List
	 * 
	 * @param item
	 *            - value of the Node
	 */
	public void addLast(T item) {
		if (head == null)
			addFirst(item);
		else {
			Node<T> tmp = head;
			while (tmp.next != null)
				tmp = tmp.next;
			tmp.next = new Node<T>(item, null);
		}
	}

	/**
	 * Returns the value of the last Node from the List
	 * 
	 * @return the value of the last Node
	 */
	public T getLast() {
		if (head == null)
			System.err.println("Cannot get last! List is empty");
		Node<T> tmp = head;
		while (tmp.next != null)
			tmp = tmp.next;
		return tmp.item;
	}

	/**
	 * Remove the last Node from the List
	 * 
	 * @return the value of the last Node
	 */
	public T removeLast() {
		if (head == null)
			System.err.println("Cannot delete last! List is empty");
		Node<T> tmp = head;
		while (tmp.next.next != null)
			tmp = tmp.next;
		tmp.next = null;
		return tmp.item;
	}

	/**
	 * Delete the Node with the value (<strong>param: value</strong>)
	 * 
	 * @param value
	 *            - value of a Node that will be deleted
	 */
	public void remove(T value) {
		if (head == null)
			System.err.println("Cannot delete! List is empty");

		if (head.item.equals(value)) {
			head = head.next;
			return;
		}

		Node<T> current = head;
		Node<T> prev = null;

		while (current != null && !current.item.equals(value)) {
			prev = current;
			current = current.next;
		}

		if (current == null)
			System.err.println("value not found");

		prev.next = current.next;
	}

	public void insertAfterUseless(T value, Node<T> node) {
		node.next = new Node<T>(value, node.next);;
	}

	public T getAfterUseless(Node<T> node) {
		return node.next.item;
	}

	public T removeAfterUseless(Node<T> node) {
		T removed = node.next.item;
		node.next = node.next.next;
		return removed;
	}

	/**
	 * Add a Node with the Value (<strong>param: toInsert</strong>) after the Node with the Value (<strong>param: value</strong>)
	 * 
	 * @param toInsert
	 *            - value of the Node which will be insertet after the Node with value (<strong>param: value</strong>)
	 * @param value
	 *            - value a the Node which should be in the list
	 */
	public void insertAfter(T value, T toInsert) {
		Node<T> tmp = head;

		while (tmp != null && !tmp.item.equals(value))
			tmp = tmp.next;

		if (tmp != null)
			tmp.next = new Node<T>(toInsert, tmp.next);
	}

	/**
	 * Returns the value of the Node that is next to the Node with value (<strong>param: value</strong>)
	 * 
	 * @param value
	 *            - value of the Node which is the previous
	 * 
	 * @return value of the Node that is next to the Node with the value (<strong>param: value</strong>)
	 */
	public T getAfter(T value) {
		if (head == null)
			return null;
		Node<T> tmp = head;
		while (tmp != null && !tmp.item.equals(value))
			tmp = tmp.next;
		if (tmp != null && tmp.next != null)
			return tmp.next.item;
		return null;
	}

	/**
	 * Removes the Node after the Node with value (<strong>param: value</strong>)
	 * 
	 * @param value
	 *            - value a the Node which should be in the list
	 */
	public T removeAfter(T value) {
		T removed = null;
		if (head == null)
			return null;
		Node<T> tmp = head;
		while (tmp != null && !tmp.item.equals(value))
			tmp = tmp.next;
		if (tmp != null && tmp.next != null) {
			removed = tmp.next.item;
			remove(tmp.next.item);
			return removed;
		}
		return null;
	}

	/**
	 * Add a Node with the Value (<strong>param: toInsert</strong>) in front of the Node with the Value (<strong>param: value</strong>)
	 *
	 * @param toInsert
	 *            - value of the Node which will be insertet after the Node with value (<strong>param: value</strong>)
	 * @param value
	 *            - value a the Node which should be in the list
	 */
	public void insertBefore(T value, T toInsert) {
		if (head == null)
			return;

		if (head.item.equals(value)) {
			addFirst(toInsert);
			return;
		}

		Node<T> prev = null;
		Node<T> current = head;

		while (current != null && !current.item.equals(value)) {
			prev = current;
			current = current.next;
		}
		// insert between cur and prev
		if (current != null)
			prev.next = new Node<T>(toInsert, current);
	}

	/**
	 * Returns the value of the Node that is previous of the Node with value (<strong>param: value</strong>)
	 * 
	 * @param value
	 *            - value of the Node which is the next
	 * 
	 * @return value of the Node that is previous of the Node with the value (<strong>param: value</strong>)
	 */
	public T getBefore(T value) {
		if (head == null || head.item.equals(value))
			return null;

		Node<T> prev = null;
		Node<T> current = head;

		while (current != null && !current.item.equals(value)) {
			prev = current;
			current = current.next;
		}

		if (current != null && prev != null)
			return prev.item;
		return null;
	}

	/**
	 * Removes the Node before the Node with value (<strong>param: value</strong>)
	 * 
	 * @param value
	 *            - value a the Node which should be in the list
	 */
	public T removeBefore(T value) {
		T removed = null;
		if (head == null || head.item.equals(value))
			return null;

		Node<T> prev = head;
		Node<T> current = head.next;

		while (current != null && !current.item.equals(value)) {
			prev = current;
			current = current.next;
		}
		if (current != null) {
			removed = prev.item;
			remove(prev.item);
			return removed;
		}
		return null;
	}

	/**
	 * Returns a String with all values in the List
	 * 
	 * <p>
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		Node<T> current = head;
		String s = "";
		while (current != null) {
			s += (current.item + " ");
			current = current.next;
		}
		return s.toString();
	}

	/**
	 * Main-Methode
	 * <p>
	 * Console-Menu to use the operations of the List
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		SimpleLinkedList<String> sbl = new SimpleLinkedList<String>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String eingabe = null;
		String item = null;
		String newItem = null;
		sbl.addLast("Jonas");
		sbl.addLast("Frauke");
		sbl.addLast("Mama");
		sbl.addLast("Papa");
		System.out.println(sbl);
		do {
			System.out.println("1. Add Item\n2. Remove Item\n3. Insert After\n4. Get After\n5. Remove After\n6. Insert Before\n7. Get Before\n8. Remove Before\n0. beenden\n");
			eingabe = br.readLine();
			if (eingabe.equals("1")) {
				System.out.println("Item:");
				item = br.readLine();
				sbl.addLast(item);
			}
			if (eingabe.equals("2")) {
				System.out.println("Item:");
				item = br.readLine();
				sbl.remove(item);
			}
			if (eingabe.equals("3")) {
				System.out.println("Pre Item:");
				item = br.readLine();
				System.out.println("Neues Item:");
				newItem = br.readLine();
				sbl.insertAfter(item, newItem);
			}
			if (eingabe.equals("4")) {
				System.out.println("Pre Item:");
				item = br.readLine();
				System.err.println(sbl.getAfter(item));
			}
			if (eingabe.equals("5")) {
				System.out.println("Next Item:");
				item = br.readLine();
				sbl.removeAfter(item);
			}
			if (eingabe.equals("6")) {
				System.out.println("Next Item:");
				item = br.readLine();
				System.out.println("Neues Item:");
				newItem = br.readLine();
				sbl.insertBefore(item, newItem);
			}
			if (eingabe.equals("7")) {
				System.out.println("Next Item:");
				item = br.readLine();
				System.err.println(sbl.getBefore(item));
			}
			if (eingabe.equals("8")) {
				System.out.println("Pre Item:");
				item = br.readLine();
				sbl.removeBefore(item);
			}
			System.out.println();
			System.out.println(sbl);
			System.out.println();

		} while (!eingabe.equals("0"));
	}

}
