import java.io.PrintWriter;
import java.util.Scanner;

/**
 *  20 Questions
 * @author Kyeongtak Han The QuestionGame class is smart program that has wide
 *         variety question set if the computer lost the game. Also, This
 *         program never uses regular loop. Also, it will use the Node to
 *         declare the question and answer. There are two constructor one for
 *         declare the node and console, the other is reading the files.
 */

public class QuestionsGame {
	// Instance field.
	private QuestionNode overallRoot;
	private static Scanner console;

	public QuestionsGame(String object) {
		// instantiate the console
		console = new Scanner(System.in);
		// instantiate the overallRoot
		overallRoot = new QuestionNode(object);
	}

	// Method that read the files with scanner and based on the file, the program
	// will make the binary tree.
	public QuestionsGame(Scanner fileIn) {
		// instantiate the console
		console = new Scanner(System.in);
		// call recursive readTree method
		overallRoot = readTree(fileIn);
	}

	// QuestionsGame(Scanner fileIn) recursive helper method.
	private QuestionNode readTree(Scanner input) {
		// Declare a QuestionNode named root
		QuestionNode root = null;
		// if there are lines in the input file
		if (input.hasNextLine()) {
			String line = input.nextLine();
			if (line.startsWith("A")) {
				String line2 = input.nextLine();
				root = new QuestionNode(line2);
			} else {
				String line2 = input.nextLine();
				root = new QuestionNode(line2);
				root.left = readTree(input);
				root.right = readTree(input);
			}
		}
		return root;
	}

	// Method that save new Question from the user.
	public void saveQuestions(PrintWriter fileOut) {
		// call the writeTree recursive method
		writeTree(fileOut, overallRoot);
	}

	// saveQuestions recursive helper method. If the node is not leaf, it will made
	// the Q: question in the new text file.
	private void writeTree(PrintWriter output, QuestionNode root) {
		// if root is not null
		if (root != null) {
			// This is the Question condition which is not leaf.
			if (root.left != null && root.right != null) {
				// write Q: to file
				output.println("Q:\n");
			}
			// This is the Answer condition which is leaf.
			else {
				output.println("A :\n");

			}
			output.println(root.data);
			writeTree(output, root.left);
			writeTree(output, root.right);

		}
	}

	// Method that main playing game method by using recursive method. It has
	// ability to revise the binary tree.
	public void play() {
		// call recursive play method in x=change(x) style
		overallRoot = play(overallRoot);
	}

	// play recursive helper method that can modify the tree.
	private QuestionNode play(QuestionNode root) {
		if (root != null) {
			// if the node is a question
			if (root.left != null && root.right != null) {

				System.out.println(root.data);
				String str1 = console.nextLine().trim().toLowerCase();
				// If answer is Yes, always goes left side.
				if (str1.startsWith("y")) {
					// call recursive play method for root.left (yes is always the left subtree)
					root.left = play(root.left);
				}
				// else user replies no, root always goes right side.
				else {
					// call recursive play method for root.rignt (no is always the right subtree)
					root.right = play(root.right);
				}
			}
			// else node is an answer - may need to modify tree
			else {
				String answer = root.data;
				System.out.print("I guess that your object is " + root.data + "! \nAm I right? (y/n)?");

				String str2 = console.nextLine().trim().toLowerCase();
				// if answer and user answer is same, computer wins
				if (str2.startsWith("y")) {
					System.out.println("Awesome! I win!");
				}
				// If computer lose,
				else {
					 root = makeNewQuestionNode(root,answer);
				}
			}
		}
		// return the root
		return root;
	}
	// This is my private method to reduce the legnth of the code.
	private QuestionNode makeNewQuestionNode(QuestionNode root,String answer) {
		System.out.println("Boo! I Lose. Please help me get better! what is your object?");
		String newAnswer = console.nextLine();

		// read in newAnswer and construct a new QuestionNode
		QuestionNode tempRoot1 = new QuestionNode(newAnswer); // This is for new answer node and data

		System.out.println("Please give me a yes/no question that distinguishes between " + answer + " and " + newAnswer);
		String newQuestion = console.nextLine();

		// read in newQuestion and construct a new QuestionNode
		root  = new QuestionNode(newQuestion);

		System.out.println("Is the answer 'yes' for " + newAnswer + "? (y/n)?");

		String replies = console.nextLine().trim().toLowerCase();
		if (replies.startsWith("y")) {
			root.left = tempRoot1;
			root.right = new QuestionNode(answer);
		} else {
			root.right = tempRoot1;
			root.left = new QuestionNode(answer);
		}
		return root;
	}
}
