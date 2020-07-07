package data_structures;

public class DoublyEndedList {

	private Node head;
	private Node tail;
	
	public void insertAtTail(double data) {
		
		Node newNode = new Node(data);
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setNextNode(newNode);
			this.tail = newNode;
		}
	}
	
	@Override
	public String toString() {
		String result = "{";
		Node current = this.head;
		
		while (current != null) {
			result += current.toString() + ", ";
			current = current.getNextNode();
		}
		
		return result += "}";
	}
	
}
