package postfixClasses;

public class StackAsList<T> implements Stack<T> {
	private Node top;

	@Override
	public T pop() {
		if (top.next != null) {
			T topString = top.data;
			top = top.next;
			return topString;
		}
		else if (top != null) {
			T topString = top.data;
			top = null;
			return topString;
		}
		else {
			return null;
		}
	}

	@Override
	public void push(T elem) {
		if (top == null) {
			Node newNode = new Node(elem, null);
			top = newNode;
		}
		else {
			Node formerTop = top;
			Node newNode = new Node(elem, formerTop);
			top = newNode;
		}
	}

	public static void main(String[] args) {
		
	}
	
	@Override
	public String toString() {
		String toString = "";
		Node currentNode = top;
		while(currentNode != null) {
			toString = toString + currentNode.data;
			currentNode = currentNode.next;
		}
		return null;
	}

	private class Node {
		T data;
		Node next;
		
		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	@Override
	public T top() {
		if (top != null) {
			return top.data;
		}
		else {
			return null;
		}
	}

	@Override 
	public boolean isEmpty() {
		if(top == null) {
			return true;
		}
		return false;
	}	
}