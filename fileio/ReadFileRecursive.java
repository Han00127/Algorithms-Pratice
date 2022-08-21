package fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileRecursive {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("files/quotes.txt");
		Scanner input = new Scanner(file);
		readFile(input);
	}
	
	public static void readFile(Scanner input) {
		if(input.hasNextLine()) {
			System.out.println(input.nextLine());
			readFile(input);
		}
		
		
	}
}
