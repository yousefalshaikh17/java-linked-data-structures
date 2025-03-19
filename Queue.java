
/**
 * Queue interface for using First-In-First-Out.
 *
 * @author Yousef AlShaikh
 * @version 19/03/2025
 */
public interface Queue<E>
{
    /**
     * Adds an object at the end of the queue.
     * 
     * @param data the object that should be stored in the queue.
     * 
     */
    public void add(E data);
    
    /**
     * Returns the value of the object at the top of the queue without removing it.
     * 
     * @return The head of the queue or null if the queue is empty.
     * 
     */
    public E peek();
    
    /**
     * Retrieves and removes the head of this queue.
     * 
     * @return The head of the queue or null if the queue is empty.
     * 
     */
    public E poll();
    
    /**
     * Checks to see if the queue is empty.
     * 
     * @return true if queue is empty, otherwise return false.
     * 
     */
    public boolean isEmpty();
    
}
