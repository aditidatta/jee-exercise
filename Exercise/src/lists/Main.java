package lists;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		/*list.addLast("aditi");
		list.addLast("anurag");
		list.addLast("bob");
		list.addLast("ananda");
		list.addLast("ajit");
		list.addLast("charlie");
		list.addLast("erik");
		list.addLast("sidney");
		*/
		SinglyLinkedListInt list = new SinglyLinkedListInt();
		list.addLast(1);
		list.addLast(4);
		list.addLast(5);
		list.addLast(3);
		list.addLast(2);
		list.addLast(6);
		list.addLast(7);
		list.addLast(8);
		
		list.travarse();
		list.insertionSort();
		list.travarse();
	}
	
	public static void sortSinglyLinkedList(SinglyLinkedList<String> list){
		
	}

}
