package com.linkeddatastructures;

/**
 * An object that uses LinkedList to represent a Queue.
 *
 * @author Yousef AlShaikh
 * @version 19/03/2025
 */
public class LinkedQueue<E> implements Queue<E>
{
    // LinkedList container
    private LinkedList<E> list;

    /**
     * Constructor for objects of class LinkedQueue
     */
    public LinkedQueue()
    {
        // initialise instance variables
        list = new LinkedList<E>();
    }

    /**
     * Adds an object at the end of the queue.
     * 
     * @param data the object that should be stored in the queue.
     * 
     */
    public void add(E data)
    {
        list.addLast(data);
    }

    /**
     * Returns the value of the object at the top of the queue without removing it.
     * 
     * @return The head of the queue or null if the queue is empty.
     * 
     */
    public E peek()
    {
        if (list.isEmpty())
            return null;
        
        return list.getFirst();
    }

    /**
     * Retrieves and removes the head of this queue.
     * 
     * @return The head of the queue or null if the queue is empty.
     * 
     */
    public E poll()
    {
        if (isEmpty())
            return null;
        
        return list.removeFirst();
    }

    /**
     * Checks to see if the queue is empty.
     * 
     * @return true if queue is empty, otherwise return false.
     * 
     */
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
}
