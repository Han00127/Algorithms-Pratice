import java.util.Scanner;
/**
* Word Ladder
 * @author Kyeongtak Han
 * This class is called Driver. This class instantiate a new Word Ladder then, prompt the user to enter two words.
 * it'll pass those words to the find ladder method.  The Driver can print no word ladder was found if the public findLadder method returns false.
 * The private findLadder recursive method can print the word ladder if one is found.
 * Then, if user want to repeat this game, keep running the game. There is a main method.
 *
 */
public class Driver {
	public static Scanner keyboard;
	public static void main(String[] args) {
		keyboard = new Scanner(System.in);
		// The reason why I instantiate like this is that in the Word Ladder class I declare the same length of words set every time.
		WordLadder wl;
		String again = "";
		do {
			// Whenever this loop repeat, the Word Ladder object will be declared
			wl = new WordLadder();
			System.out.print("Enter a starting word: ");
			String startWord = keyboard.next().toLowerCase();
			System.out.print("Enter a ending word: ");
			String endWord = keyboard.next().toLowerCase();

			// if findLadder becomes true, automatically print out the word ladder set.
			if(wl.findLadder(startWord, endWord)) {
				System.out.print("");
			}

			// if false, print out that sentence.
			else {
				System.out.println("No word ladder was found");
			}

			System.out.print("Do you want to continue? (Y/N) ");
			again = keyboard.next();

		}while(again.equals("Y") || again.equals("y"));

		keyboard.close();
	}

}
