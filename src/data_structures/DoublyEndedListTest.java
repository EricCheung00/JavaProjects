package data_structures;

public class DoublyEndedListTest {

	public static void main(String[] args) {
		DoublyEndedList list = new DoublyEndedList();
		
		list.insertAtTail(5);
		list.insertAtTail(10);
		list.insertAtTail(2);
		list.insertAtTail(12);
		list.insertAtTail(19);
		list.insertAtTail(20);
		
		System.out.println(list);

	}

}
