package players;

/**
 *  Adventure Game
 * @author Kyeongtak Han. This class is Princess class and extended class from
 *         Player class. There is on constructor that takes the player name as a
 *         parameter. for other field, I used the set methods to set up the
 *         correspond instance field.
 */
public class Princess extends Player {

	public Princess(String playerName) {
		super(playerName);  // This is only required condition in order to declare correspond class.
		// Set up the correspond condition
		super.setCurFatigue(0);
		super.setMaxFatigue(12);
		super.setSteps(3);
	}

	// These methods are from the abstract method and print out the status for thecharacter's feeling.
	public void stepsInMud() {
		System.out.println("This mud is going to stain my dress!");
	}

	public void stepsOnGrass() {
		System.out.println("This grass feels great between my toes");
	}

	public void stepsOnRoad() {
		System.out.println("This road is dusty");
	}

	public void stepsOnTrap() {

		System.out.println("This trap won't affect me!");
	}

}
