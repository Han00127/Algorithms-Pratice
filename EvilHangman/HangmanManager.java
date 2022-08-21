import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
/**
 * Evil Hangman
 * @author Kyeongtak Han
 * This class is called Hangman manager. This class will perform lots operations which are
 * record, making pattern etc. The key point for this class is that this program reproduce the format
 * and generate new set of words.
 */

public class HangmanManager {
    // instance variable fields
	private String pattern;
	private int max;

	private Set<String> groupOfWords;    // Set of the words
	private Set<Character> guessedChr;   // Set of the chracters that user typed
	private Map<String, Set<String>> recordMap; // Map mainly contains pattern and set of words
	private Map<Integer, String> patternWithCounter;

	// Constructor that passed a dictionary of words, a target word length and the maximum number of wrong guesses the player is allowed to make.
	// Pre - if length < 1 or max < 0
	public HangmanManager(List<String> dictionary, int length, int max) {
		this.max = max;
		if (length < 1 || max < 0) {
			throw new IllegalArgumentException();
		}
		// Store the correspond length of word into Set!
		groupOfWords = new TreeSet<>();
		for (String word : dictionary) {
			if (word.length() == length) {
				groupOfWords.add(word);
			}
		}
        // This set will contain the guessedChar from the user.
		guessedChr = new TreeSet<>();

		pattern = "";
		for (int i = 0; i < length; i++) {
			pattern += "- ";
		}
	}
    // This method is to get access to the current set of words being considered by the HangmanManager.
	public Set<String> words() {
		return groupOfWords;
	}
    // This method is to find out how many guesses the player has left.
	public int guessesLeft() {
		// this return max - the size of guessChar. The reason is I didn't change the max value.
		//Instead of changing the max value, I subtract the size of guessChar set.
		return max - guessedChr.size();
	}
    // This mehtod is to find out the current set of letters that have been guessed by the user.
	public Set<Character> guesses() {
		return guessedChr;
	}
    // This method returns the current pattern to be displayed for the hangman game. It will display the dashes if there is no matched character. Otherwise, print character.
	// If set of words are empty, throw exceptions.
	// Pre - Set of word is empty
	public String pattern() {
		if (groupOfWords.isEmpty()) {
			throw new IllegalStateException();
		}
		return pattern;
	}
    // Pre - guessLeft < 1 or set of words is empty and set of words is not empty and guessed characters contains guess character
	public int record(char guess) {
		if (guessesLeft() < 1 || groupOfWords.isEmpty())
			throw new IllegalStateException();
		if (!groupOfWords.isEmpty() && guessedChr.contains(guess))
			throw new IllegalArgumentException();
		guessedChr.add(guess);
		mainOfRecord(guess);
		maxChecker();
		finalPattern();
		int result = findNumberOfChar(guess);
		return result;
	}
    // ---------From here to the bottom of the code, this is my private method to make code be readable.------------------------------------------------------
	// Method that stores the set of words as the value and pattern as the key. To access the generated pattern, I used the another Map.
	private void mainOfRecord(char guess) {
		recordMap = new TreeMap<>();
		for (String word : groupOfWords) {
			int count = makingPattern(word, guess);
			if (!patternWithCounter.isEmpty()) {
				if (!recordMap.containsKey(patternWithCounter.get(count))) {
					Set<String> temp = new TreeSet<String>();
					temp.add(word);
					recordMap.put(patternWithCounter.get(count), temp);
				} else {
					recordMap.get(patternWithCounter.get(count)).add(word);
				}
			}
		}
	}
	// Method that makes the pattern when the record method called. This method uses the Map to make and store the number of matched characters and pattern.
	// return the count. The reason why it returns the count is that in the record method.Also, I'm going to use the count and pattern to store the correspond pattern.
	private int makingPattern(String word, char g) {
		// This map use the Integer as key, count of matched character And value is the pattern.
		patternWithCounter = new TreeMap<>();
		int count = 0;
		pattern = "";
		for (int i = 0; i < word.length(); i++) {
			// The reason why I add the word.charAt(i) is that word.charAt(i) is equal to character that the user typed and I need to keep the pattern being same
			// If I didn't add guessedChr.contains(word.charAt(i)), the pattern keeps changing.
			if (word.charAt(i) == g || guessedChr.contains(word.charAt(i))) {
				pattern += word.charAt(i) + " ";
				count++;
			} else {
				pattern += "- ";
			}
		}
		patternWithCounter.put(count, pattern);
		return count;
	}
	// Method that checks the maximum size of set of words. Then it'll pick the maximum set of words. reproduce the main group of words set.
	private void maxChecker() {
		int max = 0;
		for (Set<String> str : recordMap.values()) {
			if (str.size() > max) {
				max = str.size();
				groupOfWords = str;
			}
		}
	}
	// Method that find the number of matched characters and takes the character as the parameter.
	// Then return the number of matched characters.
	private int findNumberOfChar(char g) {
		int numberOfCount = 0;
		// This takes the new patterns.
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) == g) {
				numberOfCount++;
			}
		}
		if (numberOfCount >= 1) {
			max++;
		}
		return numberOfCount;
	}
    // Method that picks the pattern that will print out in the client program.
	private void finalPattern() {
		for (String newPattern : recordMap.keySet()) {
			if (recordMap.get(newPattern).equals(groupOfWords)) {
				pattern = newPattern;
			}
		}
	}
}
