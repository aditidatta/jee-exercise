package lists;


public class SinglyLinkedListInt {

	
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	public SinglyLinkedListInt( ) { }
	
	public int size( ) { 
		return size; 
	}
	
	public boolean isEmpty( ) { 
		return size == 0; 
	}
	
	public int first( ) {
		if (isEmpty( )) return 0;
		return head.getElement( );

	}
	
	
	public int last( ) {
		if (isEmpty( )) return 0;
		return tail.getElement( );

	}

	public void addFirst(int e) {
		head = new Node(e, head);
		if (size == 0)
			tail = head;
		size++;
	}
	
	public void addLast(int e) {
		Node newest = new Node(e, null); 
		if (isEmpty( ))
		head = newest;
		else
		tail.setNext(newest);
		tail = newest;
		size++;
	}
	
	public int removeFirst( ) {
		if (isEmpty( )) return 0;
		int answer = head.getElement( );
		head = head.getNext( );
		size--;
		if (size == 0)
			tail = null;
		return answer;
	}
	
	public void sort(){
		int indexOfI = 1;
		//int indexOfJ = 0;
		Node i = head.next;
		
		Node temp = null;
		while(i != null){
			Node j = head;
			int indexOfJ = 0;
			if(j.getElement() > i.getElement()){
				j.next = i.next;
				i.next = j;
				head = i;
				travarse();
			}
			else{
				while(indexOfJ < indexOfI){
					temp = j;
					j = j.next;
					indexOfJ++;
					if(j.getElement() > i.getElement()){
						j.next = i.next;
						i .next = j;
						temp.next = i;
					}
				}
			}
			indexOfI++;
		}
	}
	
	
	public void travarse(){
		Node current = head;
		while(current!=null){
			System.out.print(current.getElement()+" ");
			current = current.next;
		}
	}
	
	
	
	private class Node {

		private int element;
		private Node next;

		public Node(int e, Node n) {
			element = e;
			next = n;
		}
		
		public int getElement( ) { return element; }
		public Node getNext( ) { return next; }
		public void setNext(Node n) { next = n; }
	}
}
