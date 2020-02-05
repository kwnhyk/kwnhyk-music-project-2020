package kwnhyk.music.util;

public class StackIterator<E> implements Iterator<E> {
	
	Stack<E> stack;
	public StackIterator(Stack<E> stack) {
		this.stack = stack.clone();
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

}
