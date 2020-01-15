package kwnhyk.music.util;

import java.lang.reflect.Array;

public class LinkedList<E>extends AbstractList<E>{
    Node<E> head;
    Node<E> tail;
   

    public void add(E value){
     Node<E> newNode = new Node<>();
     newNode.value = value;
     if(head == null){
        tail = head = newNode;
     }else{
         tail.next = newNode;
         tail = newNode;
     }
     this.size++;
     }
	public void add(int index,E value){
         if(index<0 || index >=size)
         return;
         Node<E> newNode = new Node<>();
         newNode.value = value;
         Node<E> cursor = head;
         for(int i =0; i< index; i++){
             cursor = cursor.next;
         }
         if(index ==0){
             newNode.next = head;
             head = newNode;

         }else{
             newNode.next = cursor.next;
             cursor.next =newNode;

         }
         this.size++;

     }
    public E get(int index){
        if(index < 0|| index>=size)
        return null;
        
    Node<E> cursor = head;
    for(int i = 0;i < index; i++){
        cursor = cursor.next;
    }
    return cursor.value;
        
    }
    public E remove(int index){
        if(index<0 ||index >= size)
        return  null;
    Node<E> cursor = head;
    for(int i = 0 ; i< index-1;i++){
        cursor = cursor.next;
    }
    Node<E> deletedNode =null;
    if(index ==0){
        deletedNode = head;
        head = deletedNode.next;
    }
    deletedNode.next =null;
    size--;
    return deletedNode.value;
    }
    public E set(int index, E value){
        if(index<0 ||index >= size)
        return  null;

        Node<E> cursor = head;
        for(int i =0;i<index;i++){
            cursor = cursor.next;
            
        }
        E oldValue = cursor.value;
        cursor.value = value;
        return oldValue;

    }
    public Object[] toArray(){
        Object[] arr =new Object[size];
        Node<E> cursor = head;
        for(int i =0; i<size ; i++){
            arr[i] = cursor.value;
            cursor = cursor.next;

        }
        return arr;

    }
    @SuppressWarnings("unchecked")
	public E[] toArray(E[] arr){
        if(arr.length <size){
            arr =(E[]) Array.newInstance(arr.getClass().getComponentType(), size);
        }
        Node<E> cursor = head;
        for(int i =0; i<size ; i++){
            arr[i] = cursor.value;
            cursor = cursor.next;

        }
        return arr;
    }
  
    static class Node<T>{
    T value;
    Node<T> next;

    }


}