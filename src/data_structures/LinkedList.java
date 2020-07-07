package data_structures;

public class LinkedList {
	
	// linked list starts with the head element
	private Node head;
	
	/**
	 * Insert a new node at the head of the current linked list
	 * 
	 * @param data
	 */
	public void insertAtHead(double data) {
		
		// create new node with new data to be inserted
		Node newNode = new Node(data);
		
		// set new node to be the head
		// 	i.e. new node points to the existing list's head
		newNode.setNextNode(this.head);
		this.head = newNode;
	}
	
	/**
	 * Delete the head node from this linked list
	 */
	public void deleteFromHead() {
		this.head = this.head.getNextNode();
	}
	
	/**
	 * Find first node in linked list with data.
	 * Returns null if none is found.
	 * 
	 * @param data
	 * @return the node
	 */
	public Node find(double data) {
		
		Node current = this.head;
		while (current != null) {
			if (current.getData()==data) {
				return current;
			}
			current = current.getNextNode();
		}
		
		return null;
	}
	
	/**
	 * Returns the length of the linked list
	 * 
	 * @return the length
	 */
	public int length() {
		int len = 0;
		Node current = this.head;
		
		while (current != null) {
			len ++;
			current = current.getNextNode();
		}
		
		return len;
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
