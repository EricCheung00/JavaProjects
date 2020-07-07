package data_structures;

public class InsertionSortDoublyLinkedList {
	
	public void sort(DoublyLinkedList data) {
		DoublyLinkedNode node = data.getHead();
		while (node != null) { // This is the outer loop where node represents the node pointed by the black pointer in the video 
			DoublyLinkedNode prevNode = node.getPrevNode();
			while (prevNode != null && (prevNode.getData() > node.getData())) {
				prevNode = prevNode.getPrevNode();
			}
			// At this stage prevNode represents the node pointed by the green pointer (in video lecture)
			DoublyLinkedNode next = node.getNextNode(); // we keep a reference to the next node of the black pointer for easier access
			if (prevNode != null || !data.isHead(node)) {
				node.getPrevNode().setNextNode(next);
				if (next != null) {
					next.setPrevNode(node.getPrevNode());
				}
				node.setPrevNode(prevNode);
			}
			if (prevNode == null) { // set the node as head
				if (!data.isHead(node)) {
					node.setNextNode(data.getHead());
					node.getNextNode().setPrevNode(node);
					data.setHead(node);
				}
			} else { // of course the following connections can be made only when the prevNode is not null
				node.setNextNode(prevNode.getNextNode());
				prevNode.getNextNode().setPrevNode(node);
				prevNode.setNextNode(node);
			}
			node = next;
		}
	}

}
