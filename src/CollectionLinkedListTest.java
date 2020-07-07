import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list = new LinkedList<>(Arrays.asList(11,22,33));
		list.add(44);
		list.add(55);
		list.addAll(Arrays.asList(66,77,88));
		System.out.println(list);
	}

}
