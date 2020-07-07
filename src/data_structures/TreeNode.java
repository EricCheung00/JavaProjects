package data_structures;

/**
 * Binary Tree TreeNode class.
 * 
 * The data should be immutable after construction --> no setter for data
 * 
 * @author ccheric
 *
 */
public class TreeNode {
	
	private double data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	private boolean isDeleted = false;
	
	/**
	 * Constructor for a TreeNode.
	 * 
	 * @param data
	 */
	public TreeNode(double data) {
		this.data = data;
	}
	
	/**
	 * Return the height of the tree recursively.
	 * 
	 * @return height
	 */
	public int height() {
		if (isLeaf()) return 1;
		int left = 0;
		int right = 0;
		if (this.leftChild != null)
			left = this.leftChild.height();
		if (this.rightChild != null)
			right = this.rightChild.height();
		return (left > right) ? (left + 1) : (right + 1);
	}
	
	/**
	 * Return the number of leaves recursively
	 * 
	 * @return number
	 */
	public int numOfLeafNodes() {
		if (isLeaf()) return 1;
		int leftLeaves = 0;
		int rightLeaves = 0;
		if (this.leftChild != null)
			leftLeaves = leftChild.numOfLeafNodes();
		if (this.rightChild != null)
			rightLeaves = rightChild.numOfLeafNodes();
		return leftLeaves + rightLeaves;
	}
	
	/**
	 * Returns the TreeNode that contains a value that matches the data.
	 * 
	 * @param data
	 * @return the TreeNode
	 */
	public TreeNode find(double data) {
		// if this node contains the data, return this node
		if (this.data == data  &&  !isDeleted) {
			return this;
		}
		// if this node contains value greater than the data, search recursively down
		// the left child
		if (data < this.data  &&  leftChild != null) {
			return leftChild.find(data);
		}
		// if this node contains value smaller than the data, search recursively down
		// the right child
		if (data > this.data  &&  rightChild != null) {
			return rightChild.find(data);
		}
		return null;
	}
	
	/**
	 * Return smallest (left-most leaf) value of the tree recursively
	 * 
	 * @return the smallest value
	 */
	public double smallest() {
		if (this.leftChild == null) {
			return this.data;
		}
		return this.leftChild.smallest();
	}
	
	/**
	 * Return largest (right-most leaf) value of the tree recursively
	 * 
	 * @return the largest value
	 */
	public double largest() {
		if (this.rightChild == null) {
			return this.data;
		}
		return this.rightChild.largest();
	}
	
	/**
	 * Insert data in the binary search tree.
	 * 
	 * @param data
	 */
	public void insert(double data) {
		if (data>=this.data) {
			// if data >= the value in this node, insert down the RHS
			if (this.rightChild == null) {
				// if rightChild is null, create a new TreeNode as rightChild
				this.rightChild = new TreeNode(data);
			} else {
				// if rightChild has a node, recursively insert down the RHS
				this.rightChild.insert(data);
			}
		} else {
			// if data < the value in this node, insert down the LHS
			if (this.leftChild == null) {
				// if leftChild is null, create a new TreeNode as leftChild
				this.leftChild = new TreeNode(data);
			} else {
				// if leftChild has a node, recursively insert down the LHS
				this.rightChild.insert(data);
			}
		}
	}
	
	/**
	 * If the node is a leaf node.
	 * 
	 * @return boolean
	 */
	public boolean isLeaf() {
		return this.leftChild == null && this.rightChild == null;
	}
	
	/**
	 * In-order traversal recursion.
	 */
	public void traverseInOrder() {
		if (this.leftChild != null)
			this.leftChild.traverseInOrder();
		System.out.print(this.data + " ");
		if (this.rightChild != null)
			this.rightChild.traverseInOrder();
	}
	
	public double getData() {
		return data;
	}
	
	public TreeNode getLeftChild() {
		return leftChild;
	}
	
	public TreeNode getRightChild() {
		return rightChild;
	}
	
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public void delete() {
		this.isDeleted = true;
	}
	
	public boolean isDeleted() {
		return this.isDeleted;
	}

}
