package com.linkeddatastructures;

import java.util.EmptyStackException;
/**
 * An object that uses LinkedList to represent a Stack.
 *
 * @author Yousef AlShaikh
 * @version 01/12/2021
 */
public class LinkedStack<E> implements Stack<E>
{
    // LinkedList container
    private LinkedList<E> list;

    /**
     * Constructor for objects of class LinkedStack
     */
    public LinkedStack()
    {
        // initialise instance variables
        list = new LinkedList<E>();
    }

    /**
     * Adds an object at the top of the stack.
     * 
     * @param data the object that should be stored in the stack.
     * 
     */
    public void push(E data)
    {
        list.addFirst(data);
    }
    
    /**
     * Returns the value of the object at the top of the stack without removing it from the stack.
     * 
     * @return Data from the object at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     * 
     */
    public E peek()
    {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list.getFirst();
    }
    
    /**
     * Removes the object at the top of the stack and returns the object's data.
     * 
     * @return Data from the object at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     * 
     */
    public E pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }
    
    /**
     * Checks to see if the stack is empty
     * 
     * @return true if stack is empty, otherwise return false.
     * 
     */
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
}
