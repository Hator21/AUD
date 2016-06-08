package Blatt6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Stack<T> {
	private ArrayList<T> list;

	public Stack() {
		list = new ArrayList<T>();
	}

	public T add(T t) {
		list.add(t);
		return t;
	}

	public T remove() {
		if (!isEmpty()) {
			T t = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			return t;
		}
		return null;
	}

	public T getLast() {
		if (!isEmpty())
			return list.get(list.size() - 1);
		return null;
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public String toString() {
		String s = "";
		int i = 1;
		for (T t : list) {
			s += i + ". " + t.toString() + "\n";
			i++;
		}
		return s;
	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String eingabe = null;
		String item = null;

		do {
			System.out.println("1. Add Item\n2. Remove Last\n3. Show Last\n4. is Empty?\n0. Exit\n");
			try {
				eingabe = br.readLine();
			} catch (IOException e) {
				System.out.println();
			}
			if (eingabe.equals("1")) {
				System.out.println("Item:");
				try {
					item = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				stack.add(item);
			}
			if (eingabe.equals("2")) {
				stack.remove();
			}
			if (eingabe.equals("3")) {
				System.err.println("Last Item is: " + stack.getLast().toString());
			}
			if (eingabe.equals("4")) {
				System.err.println(stack.isEmpty());
			}
			System.out.println();
			System.out.println(stack);
			System.out.println();

		} while (!eingabe.equals("0"));
	}
}
