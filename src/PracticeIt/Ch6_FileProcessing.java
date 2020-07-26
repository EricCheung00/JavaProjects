package PracticeIt;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ch6_FileProcessing {

	/*
	 * SCANNER TO READ FILE
	 * ---
	 * Scanner input = new Scanner(new File([file_path]));
	 * ---
	 */
	
	/*
	 * PRINTSTREAM TO PRINT FILE
	 * ---
	 * PrintStream output = new PrintStream(new File([file_path]));
	 * ---
	 */
	
	/*
	 * METHOD SIGNATURE W/ FILENOTFOUNDEXCEPTION
	 *   whenever the method contains a "new File()" constructor
	 * ---
	 * public static void main(String[] args) throws FileNotFoundException {
	 * ---
	 */
	
	/*
	 * PATTERN TO SCAN LINES FROM A FILE
	 * ---
	 * Scanner input = new Scanner(new File("input.txt"));
	 * while (input.hasNext()) {
	 *     String line = input.nextLine();
	 * }
	 */
	
	/*
	 * PATTERN TO SCAN TOKENS FROM A FILE
	 * ---
	 * Scanner input = new Scanner(new File("input.txt"));
	 * while (input.hasNext()) {
	 *     String line = input.nextLine();
	 *     Scanner lineReader = new Scanner(line);
	 *     while (lineReader.hasNext()){
	 *         String token = lineReader.next();
	 *     }
	 * }
	 */

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("This is your project path:");
		System.out.println(new File(".").getAbsolutePath());
		runEvenNumbers();
		runCountCoins();
		runStripHtmlTags();
		runPrintDuplicates();
		runPlusScores();
	}

	public static void runPlusScores()
			throws FileNotFoundException {
		// test case
		Path inputFilePath = Paths.get(PracticeItEnv.currentPath.toString(), PracticeItEnv.packagePath,
				PracticeItEnv.chapterInputsPath, "plusScores.txt");
		Scanner input = new Scanner(new File(inputFilePath.toString()));
		plusScores(input);
		input.close();
	}

	public static void plusScores(Scanner input) {
		boolean isName = true; // first line of an entry is the name;
		String name = null;
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (isName) {
				name = line;
				isName = false;
			} else {
				String[] chars = line.split("");
				int pluses = 0;
				int minuses = 0;
				for (int i=0; i<chars.length; i++) {
					if (chars[i].equals("+")) {
						pluses++;
					}
					if (chars[i].equals("-")) {
						minuses++;
					}
					isName = true;
				}
				double percentPlus = 100.00 * pluses/(pluses+minuses);
				System.out.println(String.format("%s: %.1f%% plus", name, percentPlus));
			}
		}
	}

	public static void runPrintDuplicates()
			throws FileNotFoundException {
		// test case
		Path inputFilePath = Paths.get(PracticeItEnv.currentPath.toString(), PracticeItEnv.packagePath,
				PracticeItEnv.chapterInputsPath, "printDuplicates_input.txt");
		Scanner input = new Scanner(new File(inputFilePath.toString()));
		printDuplicates(input);
		input.close();
	}

	public static void printDuplicates(Scanner input) 
			throws FileNotFoundException {
		while (input.hasNextLine()) {
			String line = input.nextLine();
			Scanner lineReader = new Scanner(line);
			String token = null;
			int count = 1;
			while (lineReader.hasNext()) {
				String current = lineReader.next();
				if (current.equals(token)) {
					count++;					
				}
				if (count>1 &&  (!current.equals(token) || !lineReader.hasNext())  ) {
					System.out.print(token + "*" + count + " ");
				}
				if (!current.equals(token)) {
					token = current;
					count = 1;
				}
			}
			System.out.println();
			lineReader.close();
		}
	}

	public static void runStripHtmlTags() 
			throws FileNotFoundException {
		// test case
		Path inputFilePath = Paths.get(PracticeItEnv.currentPath.toString(), PracticeItEnv.packagePath,
				PracticeItEnv.chapterInputsPath, "stripHtmlTags_input.txt");
		Scanner input = new Scanner(new File(inputFilePath.toString()));
		stripHtmlTags(input);
		input.close();
	}

	public static void stripHtmlTags(Scanner input) {
		boolean isTag = false;
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] charsInLine = line.split("");

			for (int i=0; i<charsInLine.length; i++) {
				if (charsInLine[i].equals("<")) {
					isTag = true;
				}
				if (isTag == false) {
					System.out.print(charsInLine[i]);
				}
				if (charsInLine[i].equals(">")) {
					isTag = false;
				}
			}			
			System.out.println();
		}
	}

	public static void runCountCoins() throws FileNotFoundException {
		// test case 1 - should print "Total money: $1.09"
		Path inputFilePath1 = Paths.get(PracticeItEnv.currentPath.toString(), PracticeItEnv.packagePath,
				PracticeItEnv.chapterInputsPath, "countCoins_input1.txt");
		Scanner input1 = new Scanner(new File(inputFilePath1.toString()));
		countCoins(input1);
		input1.close();
		// test case 2 - should print "Total money: $3.84"
		Path inputFilePath2 = Paths.get(PracticeItEnv.currentPath.toString(), PracticeItEnv.packagePath,
				PracticeItEnv.chapterInputsPath, "countCoins_input2.txt");
		Scanner input2 = new Scanner(new File(inputFilePath2.toString()));
		countCoins(input2); // should print "Total money: $1.09"
		input2.close();
	}

	public static void countCoins(Scanner input) {
		double pennies = 0.01;
		double nickels = 0.05;
		double dimes   = 0.10;
		double quarters = 0.25;
		double sum = 0; // total money

		boolean readingCoinCount = true;
		int coinCount = 0;
		String coinType = "";
		while (input.hasNextLine()) {
			String line = input.nextLine();
			Scanner lineReader = new Scanner(line);
			while (lineReader.hasNext()) {
				if (readingCoinCount) {
					coinCount = lineReader.nextInt();
					readingCoinCount = false;
				} else {
					coinType = lineReader.next();
					if (coinType.equalsIgnoreCase("pennies")) {
						sum = sum + coinCount * pennies;
					}
					if (coinType.equalsIgnoreCase("nickels")) {
						sum = sum + coinCount * nickels;
					}
					if (coinType.equalsIgnoreCase("dimes")) {
						sum = sum + coinCount * dimes;
					}
					if (coinType.equalsIgnoreCase("quarters")) {
						sum = sum + coinCount * quarters;
					}
					coinCount = 0;
					readingCoinCount = true;
				}
			}
			lineReader.close();
		}
		System.out.println(String.format("Total money: $%.2f", sum));
	}

	public static void runEvenNumbers() throws FileNotFoundException {
		Path inputFilePath = Paths.get(PracticeItEnv.currentPath.toString(), PracticeItEnv.packagePath,
				PracticeItEnv.chapterInputsPath, "numbers.text");
		Scanner input = new Scanner(new File(inputFilePath.toString()));
		evenNumbers(input);
	}

	public static void evenNumbers(Scanner read) {

		int sum = 0;
		int even = 0;
		double percent = 0.0;
		int count = 0;
		while (read.hasNextInt()) {
			int fileNumbers = read.nextInt();
			sum += fileNumbers;
			count++;
			if (fileNumbers % 2 == 0) {
				even++;
			}
		}
		percent = (double) even / count * 100;
		System.out.println(count + " numbers, sum " + sum);
		System.out.println(String.format("%d evens (%.2f%%)", even, percent));
	}

}
