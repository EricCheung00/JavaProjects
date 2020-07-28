package PracticeIt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ch6_Proj_countChange {

	public static void main(String[] args) 
			throws FileNotFoundException {
		// prompt for input file name
		// 		test file 1: "countChange.txt"
		//		test file 2: "countChange"
		System.out.print("What is the name of the input file? ");
		Scanner console = new Scanner(System.in);
		String inputFileName = console.nextLine();
		
		// construct output file name
		String fileName; // e.g. countChange.txt --> fileName = "countChange"
		String fileExt;  // e.g. countChange.txt --> fileExt  = "txt"
		String outputFileName;
		fileName = inputFileName.split("\\.")[0];
		if (inputFileName.contains(".")) {
			fileExt = inputFileName.split("\\.")[1];
			outputFileName = fileName + "-out." + fileExt;
		} else {
			outputFileName = fileName + "-out";
		}
		
		// construct path to input and output files
		Path inputFilePath = Paths.get(PracticeItEnv.currentPath.toString(), PracticeItEnv.packagePath,
				PracticeItEnv.chapter6InputsPath, inputFileName);
		Path outputFilePath = Paths.get(PracticeItEnv.currentPath.toString(), PracticeItEnv.packagePath,
				PracticeItEnv.chapter6InputsPath, outputFileName);
		
		// open Scanner to read input file; open PrintStream to print output file
		Scanner input = new Scanner(new File(inputFilePath.toString()));
		PrintStream output = new PrintStream(new File(outputFilePath.toString()));
		
		// call countChange method
		countChange(input, output);
		
		// close i/o
		console.close();
		output.close();
	}
	
	/**
	 * Print the line-by-line change and average change per line to output file.
	 *  
	 * @param input
	 * 			Scanner object reading the input file
	 * @param output
	 * 			FileStream object printing the output file
	 */
	public static void countChange(Scanner input, PrintStream output) {
		double total = 0;
		
		int lineCounter = 0;
		double lineChange = 0;
		while (input.hasNext()) {
			String line = input.nextLine();
			lineChange = processLine(line);
			total = total + lineChange;
			lineCounter++;
			//System.out.println(String.format("Line %d : $%.2f", lineCounter, lineChange));
			output.println(String.format("Line %d : $%.2f", lineCounter, lineChange));
		}
		double average = total/lineCounter;
		//System.out.println(String.format("Tota: $%.2f", total));
		//System.out.println(String.format("Average Change: $%.2f", average));
		output.println(String.format("Total: $%.2f", total));
		output.println(String.format("Average Change: $%.2f", average));
	}

	/**
	 * Returns the sum of change parsed from a single line of String.
	 * 
	 * @param line
	 * 			String
	 * @return the sum
	 */
	public static double processLine(String line) {
		double sum = 0.00;
		
		double penny  = 0.01;
		double nickel = 0.05;
		double dime   = 0.10;
		double quarter = 0.25;
		
		Scanner lineReader = new Scanner(line);
		while (lineReader.hasNext()) {
			if (lineReader.hasNextInt()) { // token is numeric, i.e. 1, 5, 10, 25
				int num = lineReader.nextInt();
				if (num == 1) {
					sum = sum + num/100.0;
				} else if (num == 5) {
					sum = sum + num/100.0;
				} else if (num == 10) {
					sum = sum + num/100.0;
				} else if (num == 25) {
					sum = sum + num/100.0;
				} 
			} else { // token is string, i.e. penny, nickel, dime, quarter
				String coin = lineReader.next();
				if (coin.equalsIgnoreCase("penny")) {
					sum = sum + penny;
				} else if (coin.equalsIgnoreCase("nickel")) {
					sum = sum + nickel;
				} else if (coin.equalsIgnoreCase("dime")) {
					sum = sum + dime;
				} else if (coin.equalsIgnoreCase("quarter")) {
					sum = sum + quarter;
				} 
			}
		}
		lineReader.close();
		return sum;
	}

}
