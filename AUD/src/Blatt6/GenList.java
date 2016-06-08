package Blatt6;

import java.util.LinkedList;
import java.util.List;

/**
 * Einfach verkettete generische Liste
 * 
 * @author Jonas-Lampe
 *
 * @param <T>
 */

public class GenList<T> {
	List<T> genList;

	/**
	 * Konstruktor
	 * Erstellt die Liste
	 */
	public GenList() {
		genList = new LinkedList<T>();
	}

	/**
	 * Hängt ein Element "t" ganzen hinten an die Liste an
	 * 
	 * @param t
	 * @return true, wenn die Liste verändert wurde
	 */
	public boolean populate(T t) {
		return genList.add(t);
	}

	/**
	 * Fügt bei "index" das Element "t" in die Liste ein
	 * 
	 * @param index
	 * @param t
	 */
	public void populate(int index, T t) {
		genList.add(index, t);
	}

	/**
	 * Löscht das erste gefundene Element "t" aus der Liste
	 * 
	 * @param t
	 * @return true, wenn die Liste verändert wurde
	 */
	public boolean depopulate(T t) {
		return genList.remove(t);
	}

	/**
	 * Löscht das Element beim Index "index" aus der Liste
	 * 
	 * @param index
	 */
	public void depopulate(int index) {
		genList.remove(index);
	}

	/**
	 * Gibt die Größe der Liste zurück
	 * 
	 * @return Größe der Liste
	 */
	public int getSize() {
		return genList.size();
	}

	/**
	 * Gibt an ob die Liste leer ist
	 * 
	 * @return true, wenn die Liste leer ist
	 */
	public boolean isEmpty() {
		return this.getSize() == 0;
	}

	/**
	 * Gibt den Index des ersten gefundenen Element "t" zurück
	 * 
	 * @param t
	 * @return index des Element "t"
	 */
	public int indexOf(T t) {
		return genList.indexOf(t);
	}

	/**
	 * Gibt zurück ob das Element "t" in der Liste vorhanden ist
	 * 
	 * @param t
	 * @return true, wenn das Element "t" gefunden wurde
	 */
	public boolean contains(T t) {
		return this.indexOf(t) >= 0;
	}

	/**
	 * Ersetzt das Element an der Stelle "index" durch das Element "t"
	 * 
	 * @param index
	 * @param t
	 * @return das alte Element an der Stelle "index"
	 */
	public T set(int index, T t) {
		return genList.set(index, t);
	}

	/**
	 * Gibt das Element an der Stelle "index" zurück
	 * 
	 * @param index
	 * @return Element an der Stelle "index"
	 */
	public T get(int index) {
		return genList.get(index);
	}

	/**
	 * Fügt hinter dem Element "t" das Element "n" ein
	 * 
	 * @param t
	 * @param n
	 * @return true, wenn die Liste verändert wurde
	 */
	public boolean setNextElem(T t, T n) {
		if (t == null || n == null)
			return false;
		populate(indexOf(t) + 1, n);
		return true;
	}

	/**
	 * Gibt das Element hinter dem Element "t" zurück
	 * 
	 * @param t
	 * @return Element hinter "t"
	 */
	public T getNextElem(T t) {
		return get(indexOf(t) + 1);
	}

	/**
	 * Löscht das Element hinter dem Element "t"
	 * 
	 * @param t
	 * @return Element was gelöscht wurde
	 */
	public T removeNextElem(T t) {
		T old = get(indexOf(t) + 1);
		depopulate(get(indexOf(t) + 1));
		return old;
	}

	/**
	 * Fügt vor dem Element "t" das Element "n" ein
	 * 
	 * @param t
	 * @param n
	 * @return true, wenn die Liste verändert wurde
	 */
	public boolean setPrevElem(T t, T n) {
		if (t == null || n == null)
			return false;
		if (indexOf(t) - 1 >= 0) {
			populate(indexOf(t) - 1, n);
			return true;
		}
		return false;
	}

	/**
	 * Gibt das Element vor dem Element "t" zurück
	 * 
	 * @param t
	 * @return Element hinter "t"
	 */
	public T getPrevElem(T t) {
		if (indexOf(t) - 1 >= 0)
			return get(indexOf(t) - 1);
		return null;
	}

	/**
	 * Löscht das Element vor dem Element "t"
	 * 
	 * @param t
	 * @return Element was gelöscht wurde
	 */
	public T removePrevElem(T t) {
		if (indexOf(t) - 1 >= 0) {
			T old = get(indexOf(t) - 1);
			depopulate(get(indexOf(t) - 1));
			return old;
		}
		return null;
	}

}
