package kwnhyk.music.util;

import java.util.Arrays;

public class Stack<E> implements Cloneable {
	private static final int DEFAULT_CAPACITY = 10;
	Object[] elementData;
	
	int size;
	

	

	public Stack() {
		this.elementData = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		
		
		
		
	}
	
	
	
	
	public void push(E value) {
		
		if(this.size ==elementData.length) {
			grow();
			
		}
		this.elementData[size++] = value;
		
		
		
		
		
	}
	@SuppressWarnings("unchecked")
	public E pop() {
		if(this.empty()) 
			return null;
		
			E value =(E) this.elementData[--this.size];
			
			this.elementData[this.size] = null;
			return value;
		
		
		
	}
	public boolean empty() {
		return this.size == 0;
		
	}
	private void grow() {
		this.elementData = Arrays.copyOf(this.elementData, newCapacity());
		
		
		
	}
	private int newCapacity() {
		int oldCapacity = elementData.length;
		
		return oldCapacity +(oldCapacity >>1);
				
	}
	@SuppressWarnings("unchecked")
	@Override
	public Stack<E> clone() {
		try {
			Stack<E> temp = (Stack<E>)super.clone();
			Object[] arr = new Object[this.size];
			for(int i =0; i<this.size; i++) {
				arr[i] = this.elementData[i];
				
				
			}
			temp.elementData = arr;
			return temp;
			
			
		}catch(CloneNotSupportedException ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public Iterator<E> iterator(){
		
		 return new Iterator<>(){
	 

		Stack<E> stack;
		{
			this.stack = Stack.this.clone();
		// TODO Auto-generated constructor stub
	}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !stack.empty();
		}

		@Override
		public E next() {
			
			return stack.pop();
		}
		
	};

}
}
