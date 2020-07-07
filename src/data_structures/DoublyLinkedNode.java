package data_structures;

public class DoublyLinkedNode {
	
	private double data;
	private DoublyLinkedNode nextNode;
	private DoublyLinkedNode prevnode;
	
	public DoublyLinkedNode(double data) {
		this.data = data;
	}
	
	public double getData() {
		return data;
	}
	
	public void setData(double data) {
		this.data = data;
	}
	
	public DoublyLinkedNode getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(DoublyLinkedNode nextNode) {
		this.nextNode = nextNode;
	}
	
	public DoublyLinkedNode getPrevNode() {
		return prevnode;
	}
	
	public void setPrevNode(DoublyLinkedNode prevnode) {
		this.prevnode = prevnode;
	}
	
	@Override
	public String toString() {
		return this.data+"";
	}

}
