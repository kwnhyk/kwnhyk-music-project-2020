package kwnhyk.music.handler;

import java.util.Arrays;


public class ArrayList<E>{

    private final static int DEFAULT_SIZE = 10;
    Object[] list;
    int size = 0;

    public ArrayList(){

        list = new Object[DEFAULT_SIZE];

    }
    
    public ArrayList(int init){
        if(init > DEFAULT_SIZE)
        this.list = new Object[init];
        else
        this.list = new Object[DEFAULT_SIZE];

    }
    public Object[] toArray(){
        /*
        E[] arr = new E[this.size];
        for(int i =0 ; i<this.size;i++){
            arr[i]= this.list[i];           
        }
        return arr;
        */
        return Arrays.copyOf(this.list, this.size);

    }
    @SuppressWarnings("unchecked")
	public E[] toArray(E[] arr){
        if(arr.length<this.size){
            return (E[]) Arrays.copyOf(this.list,this.size, arr.getClass());
        }
        System.arraycopy(this.list, 0, arr, 0, this.size);
        return arr;
    }
    public void add(E e){
        if(size >=list.length){
            int oldCapacity = list.length;
            int newCapacity = oldCapacity +(oldCapacity >>1);
            /*E[] arr = new E[newCapacity];
            for(int i =0;i <this.size;i++){
                arr[i]= this.list[i];
            }
*/


           this.list = Arrays.copyOf(list, newCapacity);

        }
        this.list[size++] = e;

    }
    @SuppressWarnings("unchecked")
	public E get(int index){
         if(index<0 || index>=this.size){
             return null;
         }
    return (E)this.list[index];

    }
    @SuppressWarnings("unchecked")
	public E set(int index ,E e){
        
        if(index<0 || index>=this.size){
            return null;
        }
        
        this.list[index] = e;
       E old = (E)this.list[index];
        return old;
    }

    @SuppressWarnings("unchecked")
	public E remove(int index){
        if(index<0 ||index>=this.size){
            return null;

        }
        E old = (E)this.list[index];
        System.arraycopy(this.list,index, this.list , index-1,this.size-(index+1));
       /* for(int i = index+1;i<this.size;i++){
            this.list[i-1] = this.list[i];
        }
        */
        this.size--;
        
        return old;
    }
    public int size() {
    return	this.size;
    }
}