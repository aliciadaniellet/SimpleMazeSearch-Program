/**
 * MyDeque.java
 * Name: Alicia Danielle
 * ID: A16845693
 * Email: adanielle@ucsd.edu
 * Sources used: Zybooks
 * 
 * This file contains a generic class called MyDeque, which is 
 * an implementation of the provided DequeInterface. Only methods
 * shown in the interface are implemented and no use of java built-in 
 * data structure implementations are allowed.
 * 
 */

/**
 * This generic class implements the provided Dequeinterface. 
 * Methods implemented are: size(), expandCapacity(), 
 * addFirst(E element), addLast(E element), removeFirst(), 
 * removeLast(), peekFirst(), peekLast()
 * 
 */
public class MyDeque<E> implements DequeInterface<E> {
    Object[] data;
    int size;
    int rear;
    int front;
    private static final int DEFAULT_VALUE = 10;

    /**
     * Constructor to create new MyDeque object.
     * Initialization of instance variables.
     * 
     * @param initialCapacity max amount of elements this data structure
     * can hold.
     */
    public MyDeque(int initialCapacity){
        if(initialCapacity<0){
            throw new IllegalArgumentException();
        }
        //initialize instance variables
        data = new Object[initialCapacity];
        size = 0;
        rear = 0;
        front = 0;
    }

    /**
     * Returns the number of elements in this deque.
     * 
     * @return the number of elements in the deque
     */
    public int size(){
        return this.size;
    }

    /**
     * Expands the capacity of this deque.
     * 
     */
    public void expandCapacity(){
        //capacity is 0, no element
        if(data.length == 0){
            Object[] expand = new Object[DEFAULT_VALUE];
            data = expand;
            front = 0;
            rear = 0;
        }
        //has element
        else {
            Object[] expand = new Object[data.length * 2];
            for(int i=0; i < size; i++){
                expand[i] = data[i];
            }
            data = expand;
            front = 0;
            rear = size -1;
        }
    }

    /**
     * Adds the specified element to the front of this deque
     * and update front and size.
     * 
     * @param element the element to be added to this deque
     */
    public void addFirst(E element){
        if(element == null){
            throw new NullPointerException();
        }
        //deque is at capacity
        if(size == data.length){
            this.expandCapacity();
        }
        //no element
        if(size == 0){
            data[front]=element;
            front=rear;
        }
        //has element
        else{
            //front points to start of array, wrap
            if(front == 0){
                data[data.length-1]=element;
                front = data.length-1;
            }
            else{
                data[front-1]=element;
                //decrement front
                front--;
            }
        }
        //update size
        size++;
    }

    /**
     * Adds the specified element to the rear of this deque
     * and update rear and size.
     * 
     * @param element the element to be added to this deque
     */
    public void addLast(E element){
        if(element == null){
            throw new NullPointerException();
        }
        //deque is at capacity
        if(size == data.length){
            this.expandCapacity();
        }
        //no element; rear==front
        if(size == 0){
            data[rear]=element;
            rear=front;
        }
        //has element
        else{
            //rear points to end of array, wrap
            if(rear == data.length-1){
                data[0] = element;
                rear = 0;
            }
            else{
                data[rear+1] = element;
                //update rear
                rear++;
            }
        }
        //update size
        size++;
    }

    /**
     * Removes the element at the front of this deque.
     * Returns the element removed, or null if there was no such element.
     * 
     * @return the element removed, or null if the size was zero.
     */
    @SuppressWarnings("unchecked")
    public E removeFirst(){
        //no element
        if(size == 0){
            return null;
        }
        //size > 0
        //element returned n removed
        E returned = (E) data[front];
        //change removed elem to null, capacity stays the same
        data[front] = null;
        //one element
        if(size == 1){
            size = 0 ;
            return returned;
        }
        //>1 element
        else{
            //front points to end of array, wrap
            if(front == data.length-1){
                front = 0;
            }
            else{
                //update front
                front++;
            }
            size-- ;
            return returned;
        }
    }

    /**
     * Removes the element at the rear of this deque.
     * Returns the element removed, or null if there was no such element.
     * 
     * @return the element removed, or null if the size was zero.
     */
    @SuppressWarnings("unchecked")
    public E removeLast(){
        //no element
        if(size == 0){
            return null;
        }
        //size > 0
        //element returned n removed
        E returned = (E) data[rear];
        //change removed elem to null, capacity stays the same
        data[rear] = null;
        //one element
        if(size == 1){
            size = 0 ;
            return returned;
        }
        //>1 element
        else{
            //rear points to start of array, wrap
            if(rear == 0){
                rear = data.length-1;
            }
            else{
                //update rear
                rear--;
            }
            size-- ;
            return returned;
        }
    }

    /**
     * Returns the element at the front of this deque,
     * or null if there was no such element.
     * 
     * @return the element at the front, or null if the size was zero.
     */
    @SuppressWarnings("unchecked")
    public E peekFirst(){
        //no element
        if(size == 0){
            return null;
        }
        return (E) data[front];
    }

    /**
     * Returns the element at the rear of this deque,
     * or null if there was no such element.
     * 
     * @return the element at the rear or null if the size was zero.
     */
    @SuppressWarnings("unchecked")
    public E peekLast(){
        //no element
        if(size == 0){
            return null;
        }
        return (E) data[rear];
    }

}
