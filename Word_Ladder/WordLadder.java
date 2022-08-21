import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/**
 *  Word Ladder
 * @author Kyeongtak Han
 * This class is called Word Ladder. This class implements the recursion to find the word ladder. It will read the dictionary files automatically when
 * this class is instantiated. Also, It checks out and finds the one letter difference word from the word that user typed
 * and print out the word ladders.
 *
 */
public class WordLadder {
	// Instance fields
	List<String> words;
	List<String> ladder;
	//int steps; This is not used in this class.
    // This is constant variable.
	private static Scanner fileIn;

	// constructor that reads the input file and load each word into the list "words"
	public WordLadder() {
		words = new ArrayList<>();
		readFiles();
		ladder = new ArrayList<>();
	}
	// The method that find the word ladder set. This is the key method in this class with using recursive method.
	// Also, personally, I use the Set collection to reduce the running time. It's because there are tons of words in the list.
	public boolean findLadder(String startWord, String endWord) {

		// startWord.toLowerCase makes my code case insensitive. So, user type any case, my code will work.
		ladder.add(startWord);

		reduceWords(endWord);
		return findLadders(startWord, endWord);
	}

	private boolean findLadders(String sW, String eW) {
		// First base case
		if (sW.equalsIgnoreCase(eW)) {
			System.out.println("Success");
			printList(ladder);
			return true;
		}
		else {
			// I used the regular for loop to revise the word ladder
			for(int i=0; i < words.size(); i ++) {
				String str = words.get(i);
				if (oneDiff(sW, str) && !inList(str, ladder)) {  // if the word met the this condition, it should add in the ladder list.
					ladder.add(str);  // add this word in ladder.

					// This if statement try to check out this is the word ladder set. If so, returns true.
					if(findLadders(str, eW)) {
						return true;
					}

					// if false to that ladder case, remove it in ladder list. The reason why I have to remove it is that
					// I add the word above before the
			        else {
			        	// By using this statement, the result is shorter than the regular one.
			        	words.remove(str);
						ladder.remove(str);
					}

			     }
			}
			return false;
		}
	}

	// method that function as just printing out the ladder set.
	public void printList(List<String> list) {

		for(String s: list) {
			System.out.println(s);
		}
	}

	// Method that check out whether the list contains the words or not.
	public boolean inList(String word, List<String> ladder) {
		return (ladder.contains(word));
	}
	// Method that check out the difference between two words. If there is exactly one difference between them,
	// it'll return true. Other wise returns false.
	public boolean oneDiff(String s1, String s2) {
		// The reason why I change this String to lower case is to make it be in case insensitive.

		int count = 0;
		if (s1.length() != s2.length())
			return false;
		else {
			// Count the number of different letter.
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i))
					count++;
			}
		}
		return (count == 1);
	}
	// This is my private method to read and put the words from the text file.
	private void readFiles() {
		File files = new File("files/words.txt");
		try {
			fileIn = new Scanner(files);
			while (fileIn.hasNext()) {
				words.add(fileIn.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Can't find the file " + e.getMessage());
		}
	}
	// This is the private method to reduce the size of words list.
	private void reduceWords(String word) {
		Iterator<String> itr = words.iterator();
		while (itr.hasNext()) {
			if(itr.next().length() != word.length()) {
				itr.remove();
			}
		}
	}
}
