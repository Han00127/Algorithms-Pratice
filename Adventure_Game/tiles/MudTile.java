package tiles;

import game.Game;
import players.Player;
/**
 *  Adventure Game
 *
 * @author Kyeongtak Han. This class is MudTile class and extended class from
 *         Basic class. There is on constructor that calls superclass with enum.
 *         By using the super class and this class we can make a new tile.
 */
public class MudTile extends BasicTile {
	// Constructor that calls the super class and use the enum value.
	public MudTile() {
		super(TileType.MUD);
	}

	// This is abstract method that takes game object and changed the player status.
	public void visitTile(Game game) {
		Player p = game.getPlayer();

		if(p.getMaxFatigue() == 15) {
			p.setCurFatigue(p.getCurFatigue() + 1);
		}
		else {
			p.setCurFatigue(p.getCurFatigue() + 2);
		}
		p.stepsInMud();
	}

}
