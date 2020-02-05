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
	static class ListIterator<E> implements Iterator<E>{
		
		
		
		List<E> list;
		int cursor;
		public ListIterator(List<E> list) {
			this.list = list;
		
		}
		@Override
		public boolean hasNext() {
			return cursor < list.size();
		}

		@Override
		public E next() {
			
			return list.get(cursor++);
		}

	}

		
		
		
	}


