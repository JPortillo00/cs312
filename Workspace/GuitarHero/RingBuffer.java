/*
 * CS312 Assignment 12.
 * On my honor, Jairo Portillo, this programming assignment is my own work.
 * Section Number:
 *
 * A program to play 37 notes mimicking guitar string plucking.
 *
 *  Name: Jairo Portillo
 *  email address: portillo.jairojr@gmail.com
 *  UTEID:jep2896
 *  Section 5 digit ID: 53565
 *  Grader name: Taylor
 *  No slip days are allowed on this assignment:
 */
import java.util.*;

public class RingBuffer{
    private int capacity;
    private ArrayList <Double> ringBuff;
    private String list[];

    // create an empty ring buffer, with given max capacity     
    public RingBuffer(int capacity){
        this.ringBuff = new ArrayList <Double> (capacity); 
        this.capacity = capacity;    
    }

    // return number of items currently in the buffer
    public int size(){
        return ringBuff.size();
    }

    // is the buffer empty (size equals zero)?
    public boolean isEmpty(){
        if(size() == 0)
            return true;
        else 
            return false;
    }                 

    // is the buffer full  (size equals capacity)?
    public boolean isFull(){
        if(size() == capacity)
            return true;
        else
            return false;
    }                 

    // add item x to the end
    public void enqueue(double x){
        if(ringBuff.size()==capacity)
            throw new RuntimeException();
        else
            ringBuff.add(x);
    }         

    // delete and return item from the front
    public double dequeue(){
        if(ringBuff.size()== 0)
            throw new RuntimeException();
        else{
            double temp =  ringBuff.get(0);
            ringBuff.remove(0);
            return temp;
        }
    }                 

    // return (but do not delete) item from the front
    public double peek(){
        return ringBuff.get(0);
    }                    

    // overrride toString. Return a String of the form [front, next, next, last] 
    public String toString(){
        list = new String [ringBuff.size()];
        for(int i = 0; i < ringBuff.size(); i++){
          list[i] = ringBuff.get(i).toString();
        }        
             
        return Arrays.toString(list);
    }

}