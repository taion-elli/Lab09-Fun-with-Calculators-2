package Postfix;

public interface Stack<T> {
	
	abstract void push(T obj) throws StackOverflow;
	abstract T pop() throws StackUnderflow;
	abstract T top() throws StackUnderflow;
	abstract boolean isEmpty();

}
