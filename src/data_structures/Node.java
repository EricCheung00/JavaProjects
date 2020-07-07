package data_structures;

/**
 * Linked list implementation
 * 
 * @author ccheric
 *
 */
public class Node {
	
	private double data;
	private Node nextNode;
	
	/**
	 * Constructor for linked list node
	 * 
	 * @param data
	 */
	public Node (double data) {
		this.data = data;
	}
	
	public Node getNextNode() {
		return nextNode;
	}
	
	public double getData() {
		return data;
	}
	
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public void setData(double data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.data+"";
	}

}
