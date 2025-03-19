package com.linkeddatastructures;

import java.lang.IndexOutOfBoundsException;
import java.util.NoSuchElementException;

/**
 * List object for storing objects of a certain type in.
 *
 * Originally created on 01/12/2021.
 * 
 * @author Yousef AlShaikh
 * @version 19/03/2025
 */
public class LinkedList<E> implements List<E>
{
    // First object in List
    private LinkNode<E> head;
    // Last object in List
    private LinkNode<E> tail;
    // Size of the List
    private int size;

    /**
     * Constructor for objects of class LinkedList.
     * Initializes the list to be empty.
     */
    public LinkedList()
    { 
        size = 0; 
        head = null;
        tail = null;
    }

    /**
     * Checks to see if the list is empty.
     * 
     * @return true if list is empty, otherwise false.
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Returns the number of objects in the list.
     * 
     * @return the number of objects in the list.
     */
    public int size()
    {
        return size;
    }

    /**
     * Adds an object at the end of the list.
     * 
     * @param data object to be inserted.
     */
    public void add(E data)
    {
        addLast(data);
    }

    /**
     * Adds an object at the specified index.
     * 
     * @param index index of the position for object to be inserted.
     * @param data object to be inserted.
     * 
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public void add(int index, E data)
    {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();

        if (index == size) {
            addLast(data);  // Adding to the end of the list
        } else if (index == 0) {
            addFirst(data);  // Adding to the beginning of the list
        } else {
            LinkNode<E> currentNode = getNodeAtIndex(index - 1);
            LinkNode<E> newNode = createNode(data, currentNode.next);
            currentNode.next = newNode;
            size++;
        }
    }

    /**
     * Adds an object to the start of the list.
     * 
     * @param data object to be inserted.
     */
    public void addFirst(E data)
    {
        head = createNode(data, head);
        size++;
        if (tail == null)
            tail = head;
    }

    /**
     * Adds an object at the end of the list.
     * 
     * @param data object to be inserted.
     */
    public void addLast(E data)
    {
        LinkNode<E> newNode = createNode(data);
        if (isEmpty())
            head = newNode;
        
        tail = newNode;
        size++;
    }

    /**
     * Gets an object of specified index in the list.
     * 
     * @param index index of the position of the object.
     * @return the object at the index in the list.
     */
    public E get(int index)
    {
        LinkNode<E> currentNode = getNodeAtIndex(index);
        return currentNode.data;
    }

    /**
     * Returns the object at the start of the list.
     * 
     * @return the object at the start of the list.
     * @throws NoSuchElementException if the linked list is empty.
     */
    public E getFirst()
    {
        if (isEmpty())
            throw new NoSuchElementException();

        return head.data;
    }

    /**
     * Returns the object at the end of the list.
     * 
     * @return the object at the end of the list.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E getLast()
    {
        if (isEmpty())
            throw new NoSuchElementException();

        return tail.data;
    }

    /**
     * Returns the index of the object specified.
     * 
     * @param data object to retrieve the index of.
     * @return the index of the object.
     */
    public int indexOf(E data)
    {
        if (isEmpty())
            return -1;

        LinkNode<E> currentNode = head;
        int count = 0;
        while (currentNode != null)
        {
            if (data == null ? currentNode.data == null : data.equals(currentNode.data))
                return count;

            currentNode = currentNode.next;
            count++;
        }
        return -1;
    }

    /**
     * Removes the first object on the list.
     * 
     * @return the object being removed from the list.
     */
    public E remove()
    {
        return removeFirst();
    }

    /**
     * Removes the object of the specified index and returns it.
     * 
     * @param index the index of the object.
     * @return the object being removed from the list.
     */
    public E remove(int index)
    {
        if (isEmpty())
            throw new NoSuchElementException();

        if (index == 0)
            return removeFirst();

        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        // Get target node and node prior to it
        LinkNode<E> previousNode = getNodeAtIndex(index-1);
        LinkNode<E> targetNode = previousNode.next;
        removeNode(targetNode, previousNode);

        return targetNode.data;
    }

    /**
     * Removes the object provided from the list if present.
     * 
     * @param data the object being removed from the list.
     * @return true if the list contained the specified object, false if not.
     */
    public boolean remove(Object data)
    {
        if (isEmpty())
            return false;

        LinkNode<E> previousNode = null;
        LinkNode<E> currentNode = head;
        while (currentNode != null)
        {
            // Check if the values match
            if (data == null ? currentNode.data == null : data.equals(currentNode.data)) 
                break;

            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode == null)
            return false;

        removeNode(currentNode, previousNode);

        return true;
    }

    /**
     * Removes the first object on the list.
     * 
     * @return the object being removed from the list.
     * @throws NoSuchElementException if the linked list is empty.
     */
    public E removeFirst()
    {
        LinkNode<E> node = removeFirstNode();
        return node.data;
    }

    /**
     * Removes the last object on the list.
     * 
     * @return the object being remvoed from the list.
     * @throws NoSuchElementException if the linked list is empty.
     */
    public E removeLast()
    {        
        if (size == 1)
            return removeFirst();

        return remove(size-1);
    }

    /**
     * Returns an array containing all elements in the list from first to last.
     * 
     * @return array containing all the elements in this list.
     */
    public Object[] toArray()
    {
        Object[] array = new Object[size];
        LinkNode<E> currentNode = head;

        for (int i = 0; i < size; i++)
        {
            array[i] = currentNode.data;
            currentNode = currentNode.next;
        }
        return array;
    }

    /**
     * Method to create a node and return it.
     * 
     * @param data the object to be inserted into the node.
     * @return the node that will store the object provided.
     */
    private LinkNode<E> createNode(E data)
    {
        return new LinkNode<E>(data);
    }

    /**
     * Method to create a node and return it.
     * 
     * @param data the object to be inserted into the node.
     * @param nextNode the node that comes after this node.
     * @return the node that will store the object provided.
     */
    private LinkNode<E> createNode(E data, LinkNode<E> nextNode)
    {
        return new LinkNode<E>(data, nextNode);
    }

    /**
     * Retrieves node at the requested index.
     * 
     * @param index the index of the node.
     * @return the node at the index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    private LinkNode<E> getNodeAtIndex(int index)
    {
        if (size <= index || index < 0)
            throw new IndexOutOfBoundsException();

        if (index == 0)
            return head;

        if (index-1 == size)
            return tail;

        LinkNode<E> currentNode = head;

        for (int i = 0; i < index; i++)
        {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    /**
     * Removes the first node in the list.
     * 
     * @return the previous head node.
     * @throws NoSuchElementException if the list is empty.
     */
    private LinkNode<E> removeFirstNode()
    {
        if (isEmpty())
            throw new NoSuchElementException();
        
        LinkNode<E> temp = head;
        head = head.next;
        temp.next = null;
        size--;

        // If the head was also the tail, change tail value.
        if (temp == tail)
            tail = temp;

        return temp;
    }

    /**
     * Removes the node from the list.
     * 
     * @param node the node to be removed.
     * @param previousNode the node preceding the one to be removed.
     */
    private void removeNode(LinkNode<E> node, LinkNode<E> previousNode)
    {
        if (node == head)
        {
            removeFirstNode();
            return;
        }

        if (previousNode == null)
            throw new NoSuchElementException("Previous node is null.");

        previousNode.next = node.next;
        node.next = null;
        size--;

        // If the node was the tail, change tail value.
        if (node == tail)
            tail = previousNode;
        
    }
}
