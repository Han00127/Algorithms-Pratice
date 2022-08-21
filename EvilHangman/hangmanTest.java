import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class hangmanTest {
	public static final String DICTIONARY_FILE = "dictionary2.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Welcome to the cse143 hangman game.");
		System.out.println();

		// open the dictionary file and read dictionary into an ArrayList
		Scanner input = new Scanner(new File(DICTIONARY_FILE));
		List<String> dictionary = new ArrayList<String>();
		while (input.hasNext()) {
			dictionary.add(input.next().toLowerCase());
		}

		// set basic parameters
		Scanner console = new Scanner(System.in);
		System.out.print("What length word do you want to use? ");
		int length = console.nextInt();
		System.out.print("How many wrong answers allowed? ");
		int max = console.nextInt();
		System.out.println();
		List<String> dictionary2 = Collections.unmodifiableList(dictionary);
		HangmanManager hangman = new HangmanManager(dictionary2, length, max);
		System.out.println(hangman.guesses());
		System.out.println(hangman.pattern());
	}

}
