package kwnhyk.music.handler;

import java.util.Arrays;

import kwnhyk.music.domain.BoardInfo;

public class BoardList {

	  static final int DEFAULT_CAPACITY = 3;
	
    BoardInfo[] list ;
    int size = 0;
	
    public BoardList() {
    	this.list = new BoardInfo[DEFAULT_CAPACITY];
    }
    public BoardList(int capacity) {
    	if(capacity < DEFAULT_CAPACITY ||capacity >10000)
    		this.list = new BoardInfo[DEFAULT_CAPACITY];
    	else
    		this.list = new BoardInfo[capacity];
    }
	public BoardInfo[] toArray() {
	/*BoardInfo[] arr = new BoardInfo[this.size];
		for(int i  = 0; i< this.size;i++) {
			arr[i] = this.list[i];
		}
		*/
	return Arrays.copyOf(this.list, this.size);
		
	}
	public void add(BoardInfo BoardInfo) {
		if(this.size == this.list.length) {
			int oldCapacity = this.list.length;
			int newCapacity = oldCapacity +(oldCapacity >>1);
			/*BoardInfo[] arr = new BoardInfo[newCapacity];
			for(int i = 0; i< this.list.length; i++) {
				arr[i] = this.list[i];
			}
			this.list = arr;
			*/
			this.list = Arrays.copyOf(this.list, newCapacity);
			System.out.printf("새배열을 저장%d",newCapacity);
		}
		this.list[this.size++] =BoardInfo;
		// TODO Auto-generated method stub
		
	}
	public BoardInfo get(int no) {
		 for(int i = 0; i < this.size; i++) {
			 if(this.list[i].getNum() == no) {
				 return this.list[i];

			 }
	}
		 return null;
}
}