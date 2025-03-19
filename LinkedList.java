import java.util.EmptyStackException;
import java.lang.IndexOutOfBoundsException;
import java.util.NoSuchElementException;

/**
 * List object for storing objects of a certain type in.
 *
 * @author Yousef AlShaikh
 * @version 01/12/2021
 */
public class LinkedList<E> implements List<E>
{
    // First object in List
    private LinkNode<E> head;
    // Size of the List
    private int size;
    
    /**
     * Constructor for objects of class LinkedList
     */
    public LinkedList()
    { 
        size = 0; 
    }

    /**
     * Checks to see if the stack is empty
     * 
     * @return true if list is empty, otherwise return false.
     * 
     */
    public boolean isEmpty()
    {
        return head == null;
    }
    
    /**
     * Returns the number of objects in the list.
     * 
     * @return the number of objects in the list
     * 
     */
    public int size()
    {
        return size;
    }

    /**
     * Adds an object at the end of the list.
     * 
     * @param data object to be inserted.
     * 
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
     */
    public void add(int index, E data)
    {
        if (index == size)
        {
            addLast(data);
        }
        else if (index == 0)
        {
            addFirst(data);
        }
        else if (index < size)
        {
            LinkNode<E> tempNode = createNode(data);
            LinkNode<E> currentNode = head;
            for (int i = 0; i < index-1; i++)
            {
                currentNode = currentNode.next;
            }
            currentNode.next = createNode(data, currentNode.next);
            size++;
        } else
        {
            throw new IndexOutOfBoundsException();
        }
    }
    
    /**
     * Adds an object to the start of the list.
     * 
     *  @param data object to be inserted.
     *  
     */
    public void addFirst(E data)
    {
        head = createNode(data, head);
        size++;
    }
    
    /**
     * Adds an object at the end of the list.
     * 
     * @param data object to be inserted.
     * 
     */
    public void addLast(E data)
    {
        LinkNode<E> tempNode = createNode(data);
        if (isEmpty())
        {
            head = tempNode;
        } else {
            LinkNode<E> currentNode = head;
            while (currentNode.next!=null)
            {
                currentNode = currentNode.next;
            }
            currentNode.next = tempNode;
        }
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
        LinkNode<E> currentNode = head;
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0)
        {
            return getFirst();
        }
        for (int i = 0; i < index; i++)
        {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }
    
    /**
     * Returns the object at the start of the list.
     * 
     * @return the object at the start of the list.
     * 
     */
    public E getFirst()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        return head.data;
    }
    
    /**
     * Returns the object at the end of the list.
     * 
     * @return the object at the end of the list.
     * 
     */
    public E getLast()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        LinkNode<E> currentNode = head;
        while (currentNode.next!=null)
        {
            currentNode = currentNode.next;
        }
        
        return currentNode.data;
    }
    
    /**
     * Returns the index of the object specified.
     * 
     * @param data object to retrieve the index of.
     * @return the index of the object.
     * 
     */
    public int indexOf(E data)
    {
        if (isEmpty())
        {
            return -1;
        }
        LinkNode<E> currentNode = head;
        int count = 0;
        while ( currentNode.next!=null && currentNode.data != data )
        {
            currentNode = currentNode.next;
            count++;
        }
        if (currentNode.data == data)
        {
            return count;
        }
        return -1;
    }
    
    /**
     * Removes the first object on the list.
     * 
     * @return the object being deleted.
     */
    public E remove()
    {
        return removeFirst();
    }
    
    /**
     * Removes the object of the specified index and returns it.
     * 
     * @param index the index of the object.
     * @return the object being deleted.
     */
    public E remove(int index)
    {
        if (index == 0)
        {
            return removeFirst();
        }
        else if (index == size-1)
        {
            return removeLast();
        }
        else if (index < size)
        {
            LinkNode<E> currentNode = head;
            for (int i = 0; i < index-1; i++)
            {
                currentNode = currentNode.next;
            }
            LinkNode<E> tempNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            size--;
            return tempNode.data;
        } else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes the object provided from the list if present.
     * 
     * @param the object being deleted from the list.
     * @return true if the list contained the specified object and false if not.
     */
    public boolean remove(Object data)
    {
        if (isEmpty())
        {
            return false;
        }
        LinkNode<E> currentNode = head;
        while ( currentNode.next!=null && currentNode.data != data )
        {
            currentNode = currentNode.next;
        }
        if (currentNode.data == data)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Removes the first object on the list.
     * 
     * @return the object being deleted.
     */
    public E removeFirst()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        LinkNode<E> temp = head;
        head = head.next;
        size--;
        return temp.data;
    }
    
    /**
     * Removes the last object on the list.
     * 
     * @return the object being deleted.
     */
    public E removeLast()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        LinkNode<E> currentNode = head;
        for (int i = 0; i < size-2; i++)
        {
            currentNode = currentNode.next;
        }
        LinkNode<E> tempNode = currentNode.next;
        currentNode.next = null;
        size--;
        return tempNode.data;
    }
    
    /**
     * Returns an array containing all elements in the list from first to last.
     * 
     * @return array containing all the elements in this list.
     * 
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
}
