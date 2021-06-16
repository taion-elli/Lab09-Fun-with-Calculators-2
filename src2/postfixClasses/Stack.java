package postfixClasses;

public interface Stack<T> {

	abstract T pop();
	
	abstract T top();
	
    abstract void push(T elem);
		
    //public static final boolean isEmpty = true;

	boolean isEmpty();
	
}