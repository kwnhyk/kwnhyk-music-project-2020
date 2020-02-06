package kwnhyk.music.util;

public class Queue<E> extends LinkedList<E>implements Cloneable {

	public void offer(E value) {
		this.add(value);
	
}
	
	
	
	public E poll() {
		return this.remove(0);
	}
	@Override
	public Queue<E> clone() {
		Queue<E> temp = new Queue<>();
		
		for(int i =0; i<this.size();i++) {
			temp.offer(this.get(i));
		}
		return temp;
		
		
		
		
	}
	@Override
	public Iterator<E> iterator(){
	
		return new Iterator<>() {
	

		

		  Queue<E> queue;
		  
		
		 {
		    this.queue = Queue.this.clone();
		  }
		  
		  @Override
		  public boolean hasNext() {
		    return queue.size() > 0;
		  }
		  
		  @Override
		  public E next() {
		    return queue.poll();
		  }
		};
		
	}
}


