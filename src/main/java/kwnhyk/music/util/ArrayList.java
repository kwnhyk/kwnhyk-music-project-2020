package kwnhyk.music.util;

import java.util.Arrays;

public class ArrayList<E>extends AbstractList<E>{

    private final static int DEFAULT_SIZE = 10;
    Object[] list;
    

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
        if(size ==list.length){
        grow();
        this.list[this.size++] = e;
    }
        
   
    this.list[size++] = e;
         

        }
  
   public void add(int index, E value) {
         if (index < 0 || index >= this.size)
           return;

         if (this.size == this.list.length) {
           grow();
         }

         for (int i = size - 1; i >= index; i--)
           this.list[i + 1] = this.list[i];

         this.list[index] = value;
         this.size++;
       }
       

    
    private int newCapacity(){
        int oldCapacity = this.list.length;
      return   oldCapacity +(oldCapacity >>1);
    }
    private Object[] grow(){
    	   /*E[] arr = new E[newCapacity];
        for(int i =0;i <this.size;i++){
            arr[i]= this.list[i];
        }
*/
       return this.list = Arrays.copyOf(list, newCapacity());
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
   

}