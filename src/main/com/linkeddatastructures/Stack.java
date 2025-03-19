package com.linkeddatastructures;

/**
 * Stack interface for using Last-In-First-Out.
 *
 * @author Yousef AlShaikh
 * @version 01/12/2021
 */
public interface Stack<E>
{
    /**
     * Adds an object at the top of the stack.
     * 
     * @param data the object that should be stored in the stack.
     * 
     */
    public void push(E data);
    
    /**
     * Returns the value of the object at the top of the stack without removing it from the stack.
     * 
     * @return Data from the object at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     * 
     */
    public E peek();
    
    /**
     * Removes the object at the top of the stack and returns the object's data.
     * 
     * @return Data from the object at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     * 
     */
    public E pop();
    
    /**
     * Checks to see if the stack is empty
     * 
     * @return true if stack is empty, otherwise return false.
     * 
     */
    public boolean isEmpty();
    
}
