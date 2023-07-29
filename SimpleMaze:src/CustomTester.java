/**
 * CustomTester.java
 * Name: Alicia Danielle
 * ID: A16845693
 * Email: adanielle@ucsd.edu
 * Sources used: Zybooks, and Lecture Slides
 * 
 * This is the custom tester file for PA6. 
 * It contains test cases for the implementation of 
 * MyDeque class, MyStack class, and MyQueue class
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * This class contains public tests which purpose is to test 
 * the methods in MyDeque class, MyStack class, and MyQueue class.
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {

    private static final int DEFAULT_VALUE = 10;
    private static final int NEG_VALUE = -1;
    private static final int ZERO = 0;

    // ----------------MyDeque class----------------
    /**
     * Test the constructor when initial capacity < 0
     */
    @Test
    public void testMyDequeConstructor() {
        try{
            MyDeque<Integer> testDeque = new MyDeque<>(NEG_VALUE);
        } catch(Exception e){
        }
    }

    /**
     * Test the expandCapacity method when capacity is 0
     */
    @Test
    public void testMyDequeExpandCapacity() {
        MyDeque<Integer> testDeque = new MyDeque<>(ZERO);
        testDeque.expandCapacity();

        assertEquals("Capacity should have doubled", DEFAULT_VALUE, 
        testDeque.data.length);
    }

    /**
     * Test the addFirst method when element added is null
     */
    @Test
    public void testAddFirst() {
        MyDeque<Integer> testDeque = new MyDeque<>(DEFAULT_VALUE);
        try{
            testDeque.addFirst(null);
        } catch(Exception e){
        }
    }

    /**
     * Test the addLast method when element added is null
     */
    @Test
    public void testAddLast() {
        MyDeque<Integer> testDeque = new MyDeque<>(DEFAULT_VALUE);
        try{
            testDeque.addLast(null);
        } catch(Exception e){
        }
    }

    /**
     * Test the removeFirst method when size is 0
     */
    @Test
    public void testRemoveFirst() {
        MyDeque<Integer> testDeque = new MyDeque<>(DEFAULT_VALUE);

        assertEquals("Should be null", null, 
        testDeque.removeFirst());
    }

    /**
     * Test the removeLast method when size is 0
     */
    @Test
    public void testRemoveLast() {
        MyDeque<Integer> testDeque = new MyDeque<>(DEFAULT_VALUE);

        assertEquals("Should be null", null, 
        testDeque.removeLast());
    }

    /**
     * Test the peekFirst method when size is 0
     */
    @Test
    public void testPeekFirst(){
        MyDeque<Integer> testDeque = new MyDeque<>(DEFAULT_VALUE);

        assertEquals("Should be null", null, 
        testDeque.peekFirst());
    }

    /**
     * Test the peekLast method when size is 0
     */
    @Test
    public void testPeekLast(){
        MyDeque<Integer> testDeque = new MyDeque<>(DEFAULT_VALUE);

        assertEquals("Should be null", null, 
        testDeque.peekLast());
    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when element added is null
     */
    @Test
    public void testMyStack(){
        MyStack<Integer> testStack = new MyStack<>(DEFAULT_VALUE);

        try{
            testStack.theStack.addFirst(null);;
        } catch(Exception e){
        }
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when capacity < 0
     */
    @Test
    public void testMyQueue(){
        try{
            MyQueue<Integer> testQueue = new MyQueue<Integer>(NEG_VALUE);
        } catch(Exception e){
        }
    }
}
