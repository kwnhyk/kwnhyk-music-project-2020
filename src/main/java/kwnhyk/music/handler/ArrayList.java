package kwnhyk.music.handler;

import java.util.Arrays;


public class ArrayList{

    final static int DEFAULT_SIZE = 10;
    Object[] list;
    int size = 0;

    public ArrayList(){

        list = new Object[DEFAULT_SIZE];

    }
    
    public ArrayList(int init){
        if(init > DEFAULT_SIZE)
        list = new Object[init];
        else
        list = new Object[DEFAULT_SIZE];

    }
    public Object[] toArray(){
        return Arrays.copyOf(list, size);

    }
    public void add(Object obj){
        if(size >=list.length){
            int oldCapacity = list.length;
            int newCapacity = oldCapacity +(oldCapacity >>1);
            list = Arrays.copyOf(list, newCapacity);

        }
        list[size++] = obj;

    }
}