import java.util.Random;

public class GeneralTesting {

	public static void main(String[] args) {
		
		System.out.println(isDigitsDescending(1234));
		System.out.println(isDigitsDescending(-4321));
		System.out.println(isDigitsDescending(-2));
		System.out.println(isDigitsDescending(4323));
		
				
		System.out.println(generateId("John", 3));
		System.out.println(generateId("John", 8));
		
		generateRandomInRange(5,10,20);
	}

	private static void generateRandomInRange(int start, int end, int len) {
		int rangeStart = start;
		int rangeEnd = end;
		int counter = 0;
		Random r = new Random();
		while (counter < len) {
			int randomNumber = r.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
			System.out.print(randomNumber + " , ");
			counter++;
		}
	}

	private static String generateId(String name, int count) {
		
		String id = "";
		
		name = name.toLowerCase();
		int len = name.length();
		Random r = new Random();
		
		//while loop to add name, pad with char if necessary
		int i=0;
		while (i<count) {
			if (i<len) {
				id = id + name.charAt(i);
			} else {
				id = id + (char) (r.nextInt(26) + 'a');
			}
			i++;
		}
		// while loop to add random digits
		int j=0;
		while (j<count) {
			int digit = r.nextInt(10);
			id = id + digit;
			j++;
		}
		
		return id;
	}
	
	private static boolean isDigitsDescending(int num) {
		boolean flag = true;
		num = Math.abs(num);
		int len = new String(num+"").split("").length;
		
		int i=len;
		while (i > 1) {
			int firstDigit = num / (int) Math.pow(10, i-1) % 10;
			int nextDigit  = num / (int) Math.pow(10, i-2) % 10;
			if ( nextDigit > firstDigit) {
				flag = false;
			}
			i--;
		}		
		
		return flag;
	}
	
	


}
