package project2;

public class QueueArray<T>{
	private T[] array;
    private int first;
    private int arrayLength;
    private int size;
    public QueueArray(int arraySize)
    {	
    	size = 0;
    	arrayLength = arraySize;
        array = (T[]) new Object[arrayLength];
        first = 0;
    }
    
    public void enqueue(T value){
    	if(size == arrayLength){
    		System.err.println("Queue is full");
    	}
    	else{
    		int pos = (first + size)%arrayLength;
    		array[pos] = value;
    		size++;
    	}
    }
    
    public void dequeue(){
    	if(isEmpty())
    		System.err.println("Queue is empty");
    	else{
    		array[first] = null;
    		first = (first + 1)%arrayLength;
    		size--;	
    	}
    }
    
    public T peekFront()
    {
    	if (isEmpty()) return null;
        return array[first];
    }
    
    public T element(int pos){
    	return array[first + pos];
    }
    public boolean isEmpty()
    {
        return(size == 0);
    }
    
    public int size(){
    	return size;
    }
    public void print()
    {
        for(int i = first; i < size; i++)
        {
            System.out.println(""+array[i]);
        }
    }
    
}

