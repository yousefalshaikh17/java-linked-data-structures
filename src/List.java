
/**
 * An interface that allows multiple objects to be stored in one variable/object.
 *
 * @author Yousef AlShaikh
 * @version 23/11/2021
 */
public interface List<E>
{
    /**
     * Checks to see if the stack is empty
     * 
     * @return true if list is empty, otherwise return false.
     * 
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of objects in the list.
     * 
     * @return the number of objects in the list
     * 
     */
    public int size();
    
    /**
     * Adds an object at the end of the list.
     * 
     * @param data object to be inserted.
     * 
     */
    public void add(E data);
    
    /**
     * Adds an object at the specified index.
     * 
     * @param index index of the position for object to be inserted.
     * @param data object to be inserted.
     * 
     */
    public void add(int index, E data);
    
    /**
     * Gets an object of specified index in the list.
     * 
     * @param index index of the position of the object.
     * @return the object at the index in the list.
     */
    public E get(int index);
    
    /**
     * Returns the index of the object specified.
     * 
     * @param data object to retrieve the index of.
     * @return the index of the object.
     * 
     */
    public int indexOf(E data);
    
    /**
     * Removes the object of the specified index and returns it.
     * 
     * @param index the index of the object.
     * @return the object being deleted.
     */
    public E remove(int index);
    
    /**
     * Removes the object provided from the list if present.
     * 
     * @param the object being deleted from the list.
     * @return true if the list contained the specified object and false if not.
     */
    public boolean remove(Object data);
    
    /**
     * Returns an array containing all elements in the list from first to last.
     * 
     * @return array containing all the elements in this list.
     * 
     */
    public Object[] toArray();

}
