package data_structures;

public class DoublyLinkedList {
	
	private DoublyLinkedNode head;
	
	public void insertAtHead(double data) {
		DoublyLinkedNode newNode = new DoublyLinkedNode(data);
		newNode.setNextNode(this.head);
		if (this.head != null) {
			this.head.setPrevNode(newNode);
		}
		this.head = newNode;
	}
	
	public DoublyLinkedNode getHead() {
		return this.head;
	}
	
	public boolean isHead(DoublyLinkedNode node) {
		return this.head == node;
	}
	
	public void setHead(DoublyLinkedNode head) {
		this.head = head;
	}
	
	/**
	 * Returns the length of the linked list
	 * 
	 * @return the length
	 */
	public int length() {
		int len = 0;
		DoublyLinkedNode current = this.head;
		
		while (current != null) {
			len ++;
			current = current.getNextNode();
		}
		
		return len;
	}
	
	@Override
	public String toString() {
		String result = "{";
		DoublyLinkedNode current = this.head;
		
		while (current != null) {
			result += current.toString() + ", ";
			current = current.getNextNode();
		}
		
		return result += "}";
	}

}
