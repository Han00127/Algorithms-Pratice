package game;

import java.util.Scanner;

import players.Knight;
import players.Princess;
import players.Squire;

/**
 * Adventure Game
 *
 * @author Kyeongtak Han This class is called GameDrive. Also, this is a
 *         foundation of game It'll read the type of player and the number of
 *         tiles that the player want to do.
 */
public class GameDriver {
	private static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to the Longest Adventure.");
		System.out.println("*********************************");

		System.out.print("Please choose a number of tiles: ");
		int tiles = console.nextInt();
		console.nextLine(); // clear enter key from integer input

		System.out.print("Enter your player name: ");
		String name = console.nextLine();

		System.out.println("Please choose a player type (knight, princess, squire):");
		System.out.println("Knight - Tough travelers that can weather any adversity!");
		System.out.println("Princess - Smart and savvy, a princess is never caught off guard!");
		System.out.println("Squire - Squires have a knack for getting there quicker!");
		System.out.print("Enter your player type: ");
		String type = console.nextLine(); // This is a kind of the character user want to play ex knight

		// TODO: send in the number of tiles and a new player object here
		// use the type entered to determine which object to construct
		// Princess, Knight, or Squire ex.
		// Game game = new Game(tiles, new Princess(name));
		// you will need an if or switch statement
		Game game;

		if (type.equalsIgnoreCase("Squire")) {
			game = new Game(tiles, new Squire(name));
		} else if (type.equalsIgnoreCase("Knight")) {
			game = new Game(tiles, new Knight(name));
		} else {
			game = new Game(tiles, new Princess(name));
		}

		game.startGame();

		console.close();
	}
}
