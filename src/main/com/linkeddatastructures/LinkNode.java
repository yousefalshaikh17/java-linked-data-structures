package com.linkeddatastructures;

/**
 * A node containing data and the reference for the node after it.
 *
 * @author Yousef AlShaikh
 * @version 01/12/2021
 */
public class LinkNode<E>
{
    protected E data;
    protected LinkNode<E> next;
    
    public LinkNode(E data, LinkNode nextNode)
    {
        this.data = data;
        next = nextNode;
    }
    
    public LinkNode(E data)
    {
        this.data = data;
        this.next = null;
    }
}
