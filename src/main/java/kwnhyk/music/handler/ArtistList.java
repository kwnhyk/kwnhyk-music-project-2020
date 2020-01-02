package kwnhyk.music.handler;

import java.util.Arrays;

import kwnhyk.music.domain.ArtistInfo;

public class ArtistList {


final static int DEFAULT_SIZE = 100;
	 ArtistInfo[] list ;

	 int size = 0;

	 public ArtistList(){
		this.list = new ArtistInfo[DEFAULT_SIZE];


	 }
	 public ArtistList(int capacity){
		 if(capacity>10000 || capacity <DEFAULT_SIZE)
			 this.list = new ArtistInfo[DEFAULT_SIZE];
		else
			this.list = new ArtistInfo[capacity];
		 
		

	 }
    public ArtistInfo[] toArray(){
	/*	ArtistInfo[] arr = new ArtistInfo[this.size];
		for (int i = 0; i < this.size; i++) {
			 arr[i] = this.list[i];


	}
*/
	return Arrays.copyOf(this.list,this.size );
}
	public void add(ArtistInfo artist) {
		if(this.size == this.list.length)
		{
			int oldCapacity = this.list.length;
			int newCapacity = oldCapacity +(oldCapacity >>1);
		
			this.list = Arrays.copyOf(this.list,newCapacity);
		}
		this.list[this.size++] = artist;
		
	}
}