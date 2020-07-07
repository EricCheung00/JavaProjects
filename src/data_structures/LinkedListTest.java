package data_structures;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.insertAtHead(5);
		list.insertAtHead(10);
		list.insertAtHead(2);
		list.insertAtHead(12);
		list.insertAtHead(19);
		list.insertAtHead(20);
		
		System.out.println(list);
		System.out.println("Length of linked list = " + list.length());
		
		list.deleteFromHead();
		System.out.println(list);
		System.out.println("Length of linked list = " + list.length());
		
		double findThis = 12;
		System.out.println("Looking for data = " + findThis);
		System.out.println("The data in this node = " + list.find(findThis));
	}

}
