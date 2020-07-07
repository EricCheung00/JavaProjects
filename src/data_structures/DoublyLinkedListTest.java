package data_structures;

public class DoublyLinkedListTest {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.insertAtHead(5);
		list.insertAtHead(10);
		list.insertAtHead(2);
		list.insertAtHead(12);
		list.insertAtHead(19);
		list.insertAtHead(20);
		
		System.out.println(list);
		System.out.println("Length of linked list = " + list.length());
		
		InsertionSortDoublyLinkedList sorter = new InsertionSortDoublyLinkedList();
		sorter.sort(list);
		System.out.println("This sorted list is: " + list);
		
	}

}
