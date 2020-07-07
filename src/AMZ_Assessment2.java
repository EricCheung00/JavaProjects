import java.util.List;
import java.util.ArrayList;

public class AMZ_Assessment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> logLines = new ArrayList<>();
		logLines.add("a1 9 2 3 1");
		logLines.add("g1 asfd asdr");
		logLines.add("z04 4 7");
		logLines.add("ab1 off key dog");
		logLines.add("a8 act zoo");
		System.out.println(logLines);
		
		String[] line = logLines.get(0).split(" ");
		int test = "a1".compareToIgnoreCase("b1");
		System.out.println(test);
		

	}

}
