package lists;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedListInt list = new SinglyLinkedListInt();
		list.addLast(12);
		list.addLast(2);
		list.addLast(6);
		list.addLast(3);
		list.addLast(10);
		list.addLast(5);
		list.addLast(9);
		list.addLast(7);
		
		list.travarse();
		list.sort();
		list.travarse();
	}

}
