package kwnhyk.music.handler;

import java.util.Arrays;

import kwnhyk.music.domain.MusicInfo;

public class MusicList {


	final static int  MUSIC_SIZE = 100;
	 MusicInfo[] list ;
	 int size = 0;


     public MusicList(){
        this.list = new MusicInfo[MUSIC_SIZE];


     }
     public MusicList(int capacity){
        if(capacity >10000 || capacity <MUSIC_SIZE)
        this.list = new MusicInfo[MUSIC_SIZE];
        else
        this.list = new MusicInfo[capacity];


     }
	public MusicInfo[] toArray() {
        
          
            return Arrays.copyOf(this.list,this.size);
            
	
    }
	public void add(MusicInfo music) {
      
        if(this.size == this.list.length){

      
       int oldCapacity = this.list.length;
       int newCapacity = oldCapacity+(oldCapacity >>1);
       
        
        Arrays.copyOf(this.list,newCapacity);
        System.out.printf("새배열을저장 %d",newCapacity);
      }
      this.list[this.size++] =music  ;  
}
}