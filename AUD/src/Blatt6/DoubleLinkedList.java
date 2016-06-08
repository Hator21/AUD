package Blatt6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Double-linked list implementation. Implements all optional list operations, and permits all
 * elements (including {@code null}).
 * 
 * @author Jonas-Lampe
 *
 * @param <T>
 *            - the type of elements held in this collection
 */

public class DoubleLinkedList<T> {
	public int		length;
	public Node<T>	head;
	public Node<T>	tail;

	/**
	 * Node for Double-linked list
	 * 
	 * @author Jonas-Lampe
	 *
	 * @param <T>
	 *            - the type of elements held in this Node
	 */
	private static class Node<T> {
		private T		value;
		private Node<T>	next;
		private Node<T>	prev;

		/**
		 * Constructor for Node-class
		 * <p>
		 * Set previous and next Node.
		 * <br>
		 * Set Value of the Node.
		 * 
		 * @param prev
		 *            - previous Node
		 * @param value
		 *            - Value of the Node
		 * @param next
		 *            - next Node
		 */
		public Node(Node<T> prev, T value, Node<T> next) {
			this.prev = prev;
			this.value = value;
			this.next = next;
		}

		/**
		 * Returns the value of the Node
		 * 
		 * <p>
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			return value + "";
		}

	}

	/**
	 * Default-Contructor
	 * <p>
	 * Set head and tail null
	 * <p>
	 * next of head is tail
	 * <br>
	 * prev of tail is head
	 */
	public DoubleLinkedList() {
		head = new Node<>(null, null, null);
		tail = new Node<>(null, null, null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Returns true if the list is empty else false
	 * 
	 * @return length == 0 -> true
	 *         <br>
	 *         length != 0 -> false
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Returns the length of the List
	 * 
	 * @return length of the List
	 */
	public int size() {
		return length;
	}

	/**
	 * Add a Node with the Value (<strong>param: value</strong>) to the list
	 * 
	 * @param value
	 */
	public void populate(T value) {
		Node<T> last = tail.prev;
		Node<T> newNode = new Node<T>(null, null, null);
		newNode.value = value;
		if (length == 0) {
			head.next = newNode;
			newNode.next = tail;
			tail.prev = newNode;
			newNode.prev = head;
		} else {
			last.next = newNode;
			newNode.prev = last;
			tail.prev = newNode;
			newNode.next = tail;
		}
		length++;
	}

	/**
	 * Add a Node with the Value (<strong>param: value</strong>) after the Node with the Value (<strong>param: pre</strong>)
	 * 
	 * @param pre
	 *            - value of the Node which will be insertet after the Node with value (<strong>param: value</strong>)
	 * @param value
	 *            - value a the Node which should be in the list
	 */
	public void insertAfter(T pre, T value) {
		Node<T> newNode = new Node<T>(null, value, null);

		if (head.next == tail) {
			System.err.println("list is empty! cannot add after value. Use \"populate\" first");
			return;
		}

		Node<T> current = head.next;
		Node<T> prev = head;
		Node<T> next = current.next;

		while (current != tail && !current.value.equals(pre)) {
			prev = current;
			current = next;
			next = current.next;
		}

		if (current == tail) {
			System.err.println("value not found");
			return;
		}

		newNode.prev = current;
		current.next = newNode;
		newNode.next = next;
		next.prev = newNode;
		length++;
	}

	/**
	 * Returns the value of the Node that is next to the Node with value (<strong>param: pre</strong>)
	 * 
	 * @param pre
	 *            - value of the Node which is the previous
	 * 
	 * @return value of the Node that is next to the Node with the value (<strong>param: pre</strong>)
	 */
	public T getAfter(T pre) {
		if (head.next == tail) {
			System.err.println("list is empty! cannot get value");
			return null;
		}

		Node<T> current = head.next;
		Node<T> prev = head;
		Node<T> next = current.next;

		while (current != tail && !current.value.equals(pre)) {
			prev = current;
			current = next;
			next = current.next;
		}

		if (current == tail) {
			System.err.println("value not found");
			return null;
		}

		return next.value;
	}

	/**
	 * Removes the Node after the Node with value (<strong>param: pre</strong>)
	 * 
	 * @param pre
	 *            - value a the Node which should be in the list
	 */
	public void removeAfter(T pre) {

		if (head.next == tail) {
			System.err.println("list is empty! cannot remove after value");
			return;
		}

		Node<T> current = head.next;
		Node<T> prev = head;
		Node<T> next = current.next;

		while (current != null && !current.value.equals(pre)) {
			prev = current;
			current = next;
			next = current.next;
		}

		if (current == tail) {
			System.err.println("value not found");
			return;
		}

		if (next != tail && next != null) {
			current.next = next.next;
			next.next.prev = current;
			length--;
		}
	}

	/**
	 * Add a Node with the Value (<strong>param: value</strong>) in front of the Node with the Value (<strong>param: pre</strong>)
	 * 
	 * @param pre
	 * @param value
	 */
	public void insertBefore(T after, T value) {
		Node<T> newNode = new Node<T>(null, value, null);

		if (head.next == tail) {
			System.err.println("list is empty! cannot add before value. Use \"populate\" first");
			return;
		}

		Node<T> current = head.next;
		Node<T> prev = head;
		Node<T> next = current.next;

		while (current != tail && !current.value.equals(after)) {
			prev = current;
			current = next;
			next = current.next;
		}

		if (current == tail) {
			System.err.println("value not found");
			return;
		}

		newNode.prev = prev;
		prev.next = newNode;
		newNode.next = current;
		current.prev = newNode;
		length++;
	}

	/**
	 * Returns the value of the Node that is previous of the Node with value (<strong>param: after</strong>)
	 * 
	 * @param after
	 *            - value of the Node which is the next
	 * 
	 * @return value of the Node that is previous of the Node with the value (<strong>param: after</strong>)
	 */
	public T getBefore(T after) {

		if (head.next == tail) {
			System.err.println("list is empty! cannot get before value");
			return null;
		}

		Node<T> current = head.next;
		Node<T> prev = head;
		Node<T> next = current.next;

		while (current != tail && !current.value.equals(after)) {
			prev = current;
			current = next;
			next = current.next;
		}

		if (current == tail) {
			System.err.println("value not found");
			return null;
		}

		return prev.value;
	}

	/**
	 * Removes the Node before the Node with value (<strong>param: after</strong>)
	 * 
	 * @param after
	 *            - value a the Node which should be in the list
	 */
	public void removeBefore(T after) {

		if (head.next == tail) {
			System.err.println("list is empty! cannot remove before value");
			return;
		}

		Node<T> current = head.next;
		Node<T> prev = head;
		Node<T> next = current.next;

		while (current != tail && !current.value.equals(after)) {
			prev = current;
			current = next;
			next = current.next;
		}

		if (current == tail) {
			System.err.println("value not found");
			return;
		}

		if (prev != head && prev != null) {
			prev.prev.next = current;
			current.prev = prev.prev;
			length--;
		}
	}

	/**
	 * Delete the Node with the value (<strong>param: value</strong>)
	 * 
	 * @param value
	 *            - value of a Node that will be deleted
	 */
	public void depopulate(T value) {
		if (head.next == tail)
			System.err.println("Cannot delete! List is empty");

		Node<T> current = head.next;
		Node<T> prev = head;
		Node<T> next = current.next;

		while (current != null && !current.value.equals(value)) {
			prev = current;
			current = next;
			next = current.next;
		}

		if (current == null)
			System.err.println("value not found");

		prev.next = next;
		next.prev = prev;
		length--;
	}

	/**
	 * Set the Value of a Node from (<strong>param: oldValue</strong> to (<strong>param: newValue</strong>
	 *
	 * @param oldValue
	 *            - old value of the Node
	 * @param newValue
	 *            - new value of the Node
	 */
	public void set(T oldValue, T newValue) {
		if (head.next == tail)
			System.err.println("Cannot set! List is empty");

		Node<T> current = head.next;
		Node<T> prev = head;
		Node<T> next = current.next;

		while (current != null && !current.value.equals(oldValue)) {
			prev = current;
			current = next;
			next = current.next;
		}

		if (current == null)
			System.err.println("value not found");

		current.value = newValue;
	}

	/**
	 * Returns a String with all values in the List
	 * 
	 * <p>
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		Node<T> current = head.next;
		String s = "";
		while (current.next != null) {
			s += (current.value + " ");
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
		DoubleLinkedList<String> dbl = new DoubleLinkedList<String>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String eingabe = null;
		String item = null;
		String newItem = null;
		dbl.head.value = "head";
		dbl.tail.value = "tail";
		dbl.populate("Hallo");
		System.out.println(dbl);
		System.out.println(dbl.length);
		System.out.println();
		do {
			System.out.println("1. Add Item\n2. Remove Item\n3. Set Item\n4. Insert After\n5. Get After\n6. Remove After\n7. Insert Before\n8. Get Before\n9. Remove Before\n0. beenden\n");
			eingabe = br.readLine();
			if (eingabe.equals("1")) {
				System.out.println("Item:");
				item = br.readLine();
				dbl.populate(item);
			}
			if (eingabe.equals("2")) {
				System.out.println("Item:");
				item = br.readLine();
				System.out.println(dbl.head + "<-> " + dbl.head.next);
				System.out.println(dbl.tail + "<-> " + dbl.tail.prev);
				dbl.depopulate(item);
				System.out.println(dbl.head + "<-> " + dbl.head.next);
				System.out.println(dbl.tail + "<-> " + dbl.tail.prev);
			}
			if (eingabe.equals("3")) {
				System.out.println("Altes Item:");
				item = br.readLine();
				System.out.println("Neues Item:");
				newItem = br.readLine();
				dbl.set(item, newItem);
			}
			if (eingabe.equals("4")) {
				System.out.println("Pre Item:");
				item = br.readLine();
				System.out.println("Neues Item:");
				newItem = br.readLine();
				dbl.insertAfter(item, newItem);
			}
			if (eingabe.equals("5")) {
				System.out.println("Pre Item:");
				item = br.readLine();
				System.err.println(dbl.getAfter(item));
			}
			if (eingabe.equals("6")) {
				System.out.println("Next Item:");
				item = br.readLine();
				dbl.removeAfter(item);
			}
			if (eingabe.equals("7")) {
				System.out.println("Next Item:");
				item = br.readLine();
				System.out.println("Neues Item:");
				newItem = br.readLine();
				dbl.insertBefore(item, newItem);
			}
			if (eingabe.equals("8")) {
				System.out.println("Next Item:");
				item = br.readLine();
				System.err.println(dbl.getBefore(item));
			}
			if (eingabe.equals("9")) {
				System.out.println("Pre Item:");
				item = br.readLine();
				dbl.removeBefore(item);
			}
			System.out.println();
			System.out.println(dbl);
			System.out.println();

		} while (!eingabe.equals("0"));
	}

}
