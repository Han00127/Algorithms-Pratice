package tiles;

import game.Game;
/**
 *  Adventure Game
 *
 * @author Kyeongtak Han This class is called BasicTile and abstract method. By
 *         using this BasicTile abstract class, I'll be able to made the four
 *         kind of tiles in the game class. Furthermore, There is one instance
 *         field to make specific and correspond tiles.
 */

public abstract class BasicTile
{
	private TileType type;

	public BasicTile(TileType type)
	{
		this.type = type;
	}

	public TileType getType()
	{
		return type;
	}

	public String toString()
	{
		return type.toString().substring(0, 1);
	}

	public abstract void visitTile(Game game);
}
