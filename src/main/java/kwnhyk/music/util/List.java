package kwnhyk.music.util;

public interface List<E> {

	void add(E e);

	void add(int index, E value);

	Object[] toArray();

	E[] toArray(E[] arr);

	E get(int index);

	E set(int index, E e);

	E remove(int index);
	int size();

}