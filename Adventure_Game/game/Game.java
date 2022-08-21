package game;

import java.util.Random;
import java.util.Scanner;

import players.Player;
import tiles.BasicTile;
import tiles.GrassTile;
import tiles.MudTile;
import tiles.RoadTile;
import tiles.TrapTile;

/* Adventure Game
 *
 * @author Kyeongtak Han This class is called Game. This is a foundation of game
 *         using player objects and tile object. It'll perform making basic
 *         tiles, star game method which is starting game. There is a few
 *         restriction to continue game. The details are below.
 */
public class Game {
	private static Scanner kb = new Scanner(System.in);

	// stores tile objects
	private BasicTile[] tiles;
	/*
	 * stores the index of player (which tile the player is located within inside
	 * the tiles array
	 */
	private int position = -1;

	// the player object
	private Player player;

	public Game(int numTiles, Player player) {
		this.player = player;
		tiles = new BasicTile[numTiles];
	}

	// This is public method that will play actual game. Then, it makes the tiles
	// and check out the condition whether it plays or not.
	public void startGame() {
		// this creates our array of tile objects
		buildTiles();
		/*
		 * The main game loop should be declared here. Each turn the player should move
		 * a random distance forward from maxSteps.
		 *
		 * NOTE: maxSteps should be stored in the Player class and should be 2 for
		 * Knights and 3 for squires or princesses.
		 */
		int maxStep = this.player.getSteps();
		boolean gameOver = false;
		Random gen = new Random();

		// THIS A KEY CONDTION WHETHER OR NOT TO PLAY GAME OVER AND OVER.
		while (!gameOver && (this.player.getCurFatigue() < this.player.getMaxFatigue())) {
			int step = gen.nextInt(maxStep) + 1;

			if (movePlayer(step) && (tiles.length - position >= 1)) {
				System.out.println("Player moves " + step + " step(s) to a " + this.tiles[position].getType());
				System.out.println(this.toString());
				this.tiles[position].visitTile(this);
				System.out.println("Player fatigue: " + this.player.getCurFatigue() + "/" + this.player.getMaxFatigue());
			} else {
				break;
			}
			System.out.print("Do you want to quit playing?(true/false) ");
			gameOver = kb.nextBoolean();

		}
		if (position >= tiles.length) {
			System.out.println();
			System.out.println();
			System.out.println("Congrats!! you got win!!");
		}
		else {
			System.out.println();
			System.out.println();
			System.out.println("So close, yet so far, you lose!!!");
		}
		System.out.println("Thank you for playing");

	}

	public Player getPlayer() {
		return player;
	}

	public boolean movePlayer(int distance) {
		/*
		 * This method moves the player the given distance. A positive value will move
		 * the player to the later indices in the tiles[] array, while a negative value
		 * will move the player back to lower indices.
		 *
		 * Return false if the distance passed falls outside the range 0 -->
		 * tiles.length - 1
		 */
		if(((tiles.length - position) < distance) && (tiles.length - position < 1))
			return false;
		else {
			if(distance < 0) {
				position--;
				return true;
			}
			else {
				position = position + distance;
				return true;
			}

		}
	}


	// private methods it will be used in the game object only.
	/*
	 * This method should instantiate tile objects to fill the tiles[] array above.
	 * 10% of the tiles should be trap tiles, 20% mud, 40% grass and 30% road.
	 */
	private void buildTiles() {
		Random random = new Random();
		for (int i = 1; i <= tiles.length; i++) {
			// generate a number from 1-10
			int num = random.nextInt(10) + 1;
			if (num <= 1) { // 1
				tiles[i - 1] = new TrapTile();
			} else if (num <= 5) { // 2,3,4,5
				tiles[i - 1] = new GrassTile();
			} else if (num <= 7) { // 6,7
				tiles[i - 1] = new MudTile();
			} else { // number <= 10 8,9,10
				tiles[i - 1] = new RoadTile();
			}
		}
	}

	public String toString() {
		String result = "[";
		for (int i = 0; i < tiles.length; i++) {
			if (i != 0) {
				result += ", ";
			}
			// player is in this tile
			if (position == i) {
				result += tiles[i].toString() + " - (player)";
			} else {
				result += tiles[i].toString();
			}
		}
		result += "]";

		if (position >= tiles.length) {
			result += " (player)";
		}
		return result;
	}
}
