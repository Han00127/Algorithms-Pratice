package fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileIterative {

	public static void main(String[] args) throws FileNotFoundException  {
		// read in quotes.txt with a Scanner Object 
		//System.out.println(System.getProperty("user.dir"));
		File file = new File("files/quotes.txt");
		Scanner input = new Scanner(file);
		while(input.hasNextLine()) {
			System.out.println(input.nextLine());
		}
		input.close();
		
	}

}
