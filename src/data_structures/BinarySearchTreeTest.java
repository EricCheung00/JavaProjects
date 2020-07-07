package data_structures;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(5);
		tree.insert(10);
		tree.insert(2);
		tree.insert(12);
		tree.insert(19);
		tree.insert(20);
		
		tree.traverseInOrder();
		
		tree.insert(8);
		tree.traverseInOrder();
		
		tree.delete(19);
		tree.traverseInOrder();
		tree.delete(31);

		double smallest = tree.smallest();
		System.out.println(smallest + "");
		double largest = tree.largest();
		System.out.println(largest + "");
		
		int height = tree.height();
		System.out.println(height + "");
		tree.insert(21);
		height = tree.height();
		System.out.println(height + "");
		tree.insert(50);
		height = tree.height();
		System.out.println(height + "");
		tree.traverseInOrder();
	}

}
