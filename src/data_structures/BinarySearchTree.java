package data_structures;

/**
 * Class for a Binary Search Tree.
 * 
 *   - all the data to the left of the node is smaller than the data at the node
 *   - all the data to the right of the node is greater than the data at the node
 * 
 * @author ccheric
 *
 */
public class BinarySearchTree {
	
	private TreeNode root;
	
	/**
	 * Soft delete a node in the binary search tree.
	 * 
	 * @param data
	 */
	public void delete(double data) {
		TreeNode toDel = find(data);
		if (toDel != null) {
			toDel.delete();
		} else {
			System.out.println("The data was not found in the tree. Nothing was deleted.");
		}
		
	}
	
	/*
	public void delete(double data) {
		TreeNode current = this.root;
		TreeNode parent = this.root;
		boolean isLeftChild = false;
		
		if (current == null) {
			return;
		}
		
		while (current != null && current.getData() != data) {
			parent = current;
			
			if (data < current.getData()) {
				// if data < this node, go down the LHS
				current = current.getLeftChild();
				isLeftChild = true;
			} else {
				// if data >  this node, go down the RHS
				current = current.getRightChild();
				isLeftChild = false;
			}
		}

		// CASE 1: the node to be deleted is a leaf node
		if (current.getLeftChild() == null && current.getRightChild() == null) {
			if (current == root) {
				// delete the root
				root = null;
			} else {
				if (isLeftChild) {
					// delete the leftChild reference of parent node
					parent.setLeftChild(null);
				} else {
					// delete the rightChild reference of parent node
					parent.setRightChild(null);
				}
			}
		}		
		// CASE 2a: the node to be deleted only has a leftChild
		else if (current.getRightChild() == null) {
			if (current == root) {
				root = current.getLeftChild();
			} else if (isLeftChild) {
				// if the current node is a leftChild, connect the parent node's leftChild
				// reference to the leftChild of the current node
				parent.setLeftChild(current.getLeftChild());
			} else {
				// if the current node is a rightChild, connect the parent node's rightChild
				// reference to the leftChild of the current node
				parent.setRightChild(current.getLeftChild());
			}
		}
		// CASE 2b: the node to be deleted only has a rightChild
		else if (current.getLeftChild() == null) {
			if (current == root) {
				root = current.getRightChild();
			} else if (isLeftChild) {
				// if the current node is a leftChild, connect the parent node's leftChild
				// reference to the rightChild of the current node
				parent.setLeftChild(current.getRightChild());
			} else {
				// if the current node is a rightChild, connect the parent node's rightChild
				// reference to the rightChild of the current node
				parent.setRightChild(current.getRightChild());
			}
		}

	}
	*/
	
	/**
	 * Search for a node containing the data.
	 * Returns null is no match is found or if the tree is null.
	 * 
	 * @param data
	 * 		the data to search for
	 * @return the TreeNode
	 */
	public TreeNode find(double data) {
		
		if (root != null) {
			return root.find(data);
		}
		return null;
	}
	
	/**
	 * Returns the smallest value of the tree.
	 * Returns null if the tree is null.
	 * 
	 * @return the value
	 */
	public Double smallest() {
		if (this.root != null) {
			return this.root.smallest();
		}
		return null;
	}
	
	/**
	 * Returns the largest value of the tree.
	 * Returns null if the tree is null.
	 * 
	 * @return the value
	 */
	public Double largest() {
		if (this.root != null) {
			return this.root.largest();
		}
		return null;		
	}
	
	/**
	 * Return the height of the tree.
	 * 
	 * @return the height
	 */
	public int height() {
		if (this.root == null) return 0;
		return this.root.height();
	}
	
	/**
	 * Return the number of leaves.
	 * 
	 * @return number of leaves
	 */
	public int numOfLeafNodes() {
		if (this.root == null) return 0;
		return this.root.numOfLeafNodes();
	}

	/**
	 * Insert data in the binary search tree.
	 * 
	 * @param data
	 */
	public void insert(double data) {
		
		if (root == null) {
			this.root = new TreeNode(data);
		} else {
			root.insert(data);
		}
	}
	
	public void traverseInOrder() {
		if (this.root != null)
			this.root.traverseInOrder();
		System.out.println();
	}

}
