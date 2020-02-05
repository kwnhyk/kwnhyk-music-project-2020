package kwnhyk.music.util;



public abstract class AbstractList<E> implements List<E> {
	protected int size ;
	
	
	@Override
	public int size() {
		return	this.size;
	}
	
	@Override
	public Iterator<E> iterator() {
	
		
		// TODO Auto-generated method stub
		return new ListIterator<>(this);
	}

}
