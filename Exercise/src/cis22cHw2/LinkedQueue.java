package cis22cHw2;

/**
   A class that implements the ADT queue by using a chain of nodes
   that has both head and tail references.

   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
   UPDATED by C. Lee-Klawender
   NOTE: the LinkedQueue class includes the Node class as an inner class
*/
public class LinkedQueue<T extends DeepCloneable<T>> implements QueueInterface<T>, DeepCloneable<LinkedQueue<T>>
{
  private Node frontNode; // References node at front of queue
  private Node backNode;  // References node at back of queue
  private int count = 0;

	public LinkedQueue()
	{
		frontNode = null;
		backNode = null;
	} // end default constructor

	public boolean enqueue(T newEntry)
	{
	
		Node prevNode = backNode;  				// defining current backNode as previous node
		backNode = new Node(newEntry); 			// Creating a new node with new entry
		if (isEmpty()) frontNode = backNode; 	// if the queue is empty, make frontNode egual to the backNode (because there's only one node right now)
        else           prevNode.next = backNode; //else linking the new backNode from the previous Node
		++count;  								// incrementing the count of nodes
		return true;
	} // end enqueue

	public T peekFront()
	{
		if (isEmpty()) 				//if the queue is empty, there's no node, so return null
			return null; 			
		else
            return frontNode.getData();	//returns the data of the frontNode 
	} // end of peekFront

	public T dequeue()
	{
	   T front = peekFront(); //peeking the node from front (FIFO)
       if( count > 0 )        // if more than one node left, point frontNode to the next one. 
       {

           frontNode = frontNode.next; //pointing to next NOde
           --count;                    // reducing the count of nodes
           if (isEmpty()) backNode = null; // if empty, make backNode = null
        }

        return front;						//returning front
	} // end of dequeue

	public boolean isEmpty()
	{
		return frontNode == null; //if (frontNode == null) --> true or false, if true the queue is empty, otherwise not
	} // end isEmpty

    public int size()
    {
        return count;             //returns count

    }
   
  
	private class Node
	{
		private T    data; // Entry in queue
		private Node next; // Link to next node

		private Node(T dataPortion)
		{
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(T dataPortion, Node linkPortion)
		{
			data = dataPortion;
			next = linkPortion;
		} // end constructor

		private T getData()
		{
			return data;
		} // end getData

		private void setData(T newData)
		{
			data = newData;
		} // end setData

		private Node getNextNode()
		{
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node

	/*----- overriding the method deepClone of DeepCloneable interface----*/ 
	@Override
  	public LinkedQueue<T> deepClone() {
  		LinkedQueue<T> queueCopy = new LinkedQueue<T>(); // creating an empty queue
  		Node newNode = this.frontNode; 					 // creating a newNode which points to the original queue's frontNode
  		queueCopy.enqueue((newNode.data).deepClone());	 // creating original data's deepClone using deepClone method in T class
  		newNode = newNode.next;							 // newNode pointing to the next node now
  		
  		while(newNode != null){	//if its not null then continue copying					
 
  			queueCopy.enqueue((newNode.data).deepClone());	//create new clone of data and enqueue it to the new queue
  			newNode = newNode.next;
  		}
  		
  		return queueCopy; //return the clone
  	}
} // end Linkedqueue