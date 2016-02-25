package project2;

public class StackArray<T>{
	T[] stack;
	int top;
	int size;
	
	public StackArray(int arraySize)
	{
		size = arraySize;
		stack = (T[]) new Object[50];
		top = -1;
   
	}
	public void push(T value)
	{
		if(top==size -1)
			System.out.println("Stack Overflow");
		else
		{
			top =top + 1;
			stack[top] = value;
		}
		
	}
	public T pop()
	{
		T returnValue = null;
		if(!isEmpty())
		{
			returnValue = stack[top];
			top--;
		}
		else 
			System.out.println("Stack Underflow");
		return returnValue;
	}
	
	public T element(int pos){
		
		return stack[pos];
	}
	public boolean isEmpty()
	{
		return top==-1;
	}
	
}
