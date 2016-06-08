package Blatt6;

import java.util.LinkedList;

public class Queue<T> {
	private LinkedList<T> list;

	public Queue() {
		list = new LinkedList<T>();
	}

	public T offer(T t) {
		list.add(t);
		return t;
	}

	public T pop() {
		return list.pop();
	}

	public T peek() {
		return list.peek();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public String toString() {
		String s = "";
		for (T t : list)
			s += t.toString() + " <- ";
		return s;
	}
}
