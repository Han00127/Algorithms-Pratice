package players;

/**
 * Adventure Game
 *
 * @author Kyeongtak Han. This class is Princess class and extended class from
 *         Player class. There is on constructor that takes the player name as a
 *         parameter. for other field, I used the set methods to set up the
 *         correspond instance field.
 */
public class Squire extends Player {

	public Squire(String playerName) {
		super(playerName);  // This is only required condition in order to declare correspond class.
		// Set up the correspond condition
		super.setCurFatigue(0);
		super.setMaxFatigue(15);
		super.setSteps(3);
	}

	// These methods are from the abstract method and print out the status for thecharacter's feeling.
	public void stepsInMud() {
		System.out.println("I grew up in the mud, this won't affect me!");
	}

	public void stepsOnGrass() {
		System.out.println("I love the open grassy fields.");
	}

	public void stepsOnRoad() {
		System.out.println("I wonder how long this road will go on.");
	}

	public void stepsOnTrap() {
		System.out.println("Ugh a traph!");
	}

}
