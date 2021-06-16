package Postfix;
import static java.lang.System.exit;

import java.util.EmptyStackException;

/**
 * This is a class that implements a Stack as LinkedList
 *
 * @author Elisa
 * @param <T> - type of Data that it passed into the stack
 * @version 1.0
 */
public class StackAsList<T> implements Stack<T> {
	
	private Node currentNode;
	
	/**
	 * Constructor of StackAsList
	 */
	public StackAsList() {
		this.currentNode = null;
	}
	
	
	/**
	 * A Node represents a "piece" of data in a Stack
	 */
	 class Node{
		
		/**
		 * The nodes content
		 */
		public T content;
		
		/**
		 * This node represents the node after the current node
		 */
		public Node next;
		
		/**
		 * Cnstructor of Node
		 */
		public Node() {}
		
		/**
		 * An accessor to get the content of a node
		 * @return the content of the node
		 * This has become unnecessary as it does not work in the push method
		 */
		/*public T getContent() {
			return content;
		}*/
		
	}
	
	/**
	 * This pushes the given object onto the Stack
	 * @param T obj that contains the data to be pushed
	 */
	@Override
	public void push(T obj) {
		
		Node node = new Node();
		node.content = obj;
		node.next = currentNode;
		currentNode = node;		
	}
	
	/**
	 * This method removes an object from the top of the Stack 
	 * @return Object that was removed
	 */
	
	@Override
	public T pop() throws StackUnderflow {
		if(isEmpty()) {
			throw new StackUnderflow();
		
		}
		T currentContent = currentNode.content;
		currentNode = currentNode.next;
		return currentContent;
	}
	/**
	 * This method returns the element on top of a stack
	 */
	@Override
	public T top() throws StackUnderflow {
		if(isEmpty()) {
			throw new StackUnderflow();
		}
		else return currentNode.content;
	}
	
	/**
	 * A boolean method that returns true if the Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if(currentNode == null) {
			return true;
		}
		else return false;
	}

	public String toString() {
		return (String) currentNode.content;
		
		
	}
	
	
	public void display()
	{
		// check for stack underflow
		if (currentNode == null) {
			System.out.printf("\nStack Underflow");
			exit(1);
		}
		else {
			Node node = currentNode;
			while (node != null) {

				// print node data
				System.out.printf("%d->", node.content);

				// assign temp link to temp
				node = node.next;
			}
		}
	}
	
	
	
}
