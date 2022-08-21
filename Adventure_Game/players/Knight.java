package players;

/**
 * Adventure Game
 *
 * @author Kyeongtak Han. This class is Knight class and extended class from
 *         Player class. There is on constructor that takes the player name as a
 *         parameter. for other field, I used the set methods to set up the
 *         correspond instance field.
 */
public class Knight extends Player {

	public Knight(String playerName) {
		super(playerName);  // This is only required condition in order to declare correspond class.
		// Set up the correspond condition
		super.setCurFatigue(0);
		super.setMaxFatigue(25);
		super.setSteps(2);
	}

	// These methods are from the abstract method and print out the status for the character's feeling.
	public void stepsInMud() {
		System.out.println("Mud, yuck, mud everywhere!");
	}

	public void stepsOnGrass() {
		System.out.println("This grass is slowing me down.");
	}

	public void stepsOnRoad() {
		System.out.println("This road is more to my liking.");
	}

	public void stepsOnTrap() {
		System.out.println("Lucky my armor is on, ouch!");
	}

}
