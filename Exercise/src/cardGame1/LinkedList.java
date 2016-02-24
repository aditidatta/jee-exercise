package cardGame1;

public class LinkedList<T> {
	public Node head;
	public Node tail; 
	public int size;
	
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	class Node{
		T data;
		Node next;
	
		public Node(T value){
			this.data = value; 
			this.next = null;
		}

	}
	
	public void getItems(LinkedList<T> otherList){
		T temp = otherList.removeFirst();
		while(temp != null){
			this.addFirst(temp);
			temp = otherList.removeFirst();
		}
	}
	
	public  void printList(){
		Node temp = head; 
		while(temp.next !=null){
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	
	}

	public boolean isEmpty() {
		return size == 0;
	}

	
	public void addFirst(T item){
		Node First = new Node(item);//create node "first"
		First.next = head;
		head = First;
		if(isEmpty())
			tail = head;
		
		size++;
		
	}
	public void addAfter(T item, Node target) {
		Node After = new Node(item);
		After.next = target.next;
		target.next = After;
		size++;
	}
	public T removeFirst() {
		if(size > 0){
			Node temp = head;
			head = head.next;
			size--;
			return temp.data;
		}
		/*else if(size == 1){
			Node temp = head.next;
			head.next = null;
			size--;
			return temp.data;
		}*/
			
		return null;
	}
	public T removeAfter(Node target) {
		Node temp = target.next; 
		if(temp != null){
			target.next = target.next.next;
			size--;
			return temp.data;
		}
		return null;
	}
	public Node getNode(int index)  {
		Node node = head;
		for(int i=0; i<index & node != null; i++) {
			node = node.next;
		}
		return node;
	}
	//Adds to the end of the list
	public void add(T item) {
		addAfter(item, getNode(size-1));
		}
	public void add(T item, int index){
		if(index < 0 || index > size)
			return;
		if(index == 0)
			addFirst(item);
			else
				addAfter(item, getNode(index-1));
	}
}
