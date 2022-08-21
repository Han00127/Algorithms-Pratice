package players;

/**
 *  Adventure Game
 *
 * @author Kyeongtak Han This class is called Player and abstract method. By
 *         using this player abstract class, I'll be able to made the three
 *         kind of characters in the game method. There are 4 instance
 *         fields to show the status of the game. Furthermore, There are getter
 *         and setter for all instance fields. The reason is that by declaring
 *         the getter and setter we should be able to set or get instance
 *         fields.
 */
public abstract class Player {
	/*
	 * Player objects will need to manage: name: the players name fatigue: the
	 * players current and maximum fatigue (a player loses when current == maximum)
	 * steps: the maximum number of steps a player can take (based on sub class)
	 */
	private String playerName;
	private int curFatigue;
	private int maxFatigue;
	private int steps;

	public Player(String playerName) {
		this.playerName = playerName;
	}

	public int getCurFatigue() {
		return curFatigue;
	}

	public void setCurFatigue(int curFatigue) {
		this.curFatigue = curFatigue;
	}

	public int getMaxFatigue() {
		return maxFatigue;
	}

	public void setMaxFatigue(int maxFatigue) {
		this.maxFatigue = maxFatigue;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	// These are the abstract methods
	public abstract void stepsInMud();

	public abstract void stepsOnGrass();

	public abstract void stepsOnRoad();

	public abstract void stepsOnTrap();
}
