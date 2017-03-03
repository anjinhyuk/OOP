
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * The word "sprite" is an old word in computer graphics.
 * http://en.wikipedia.org/wiki/Sprite_(computer_graphics)
 * In simple terms, a sprite is simply a 2D pictures that
 * can move around the screen.
 * 
 * In this program, we limit the "mobility" of the sprite
 * somewhat so that it always is drawn relative to some
 * Room, rather than just anywhere.
 *
 */
public abstract class Sprite {
	protected Room currentRoom;
	protected ImageIcon image;
	private Point xyPosition;

	/**
	 * Set up the basic variables for the abstract base class Sprite
	 */
	public Sprite() {
		currentRoom = null;
		xyPosition = new Point();
	}

	/**
	 * Assign the Sprite to a room
	 * @param r the Room where the sprite belongs.
	 */
	public void setCurrentRoom(Room r) {
		currentRoom = r;
		if (currentRoom != null && image != null) {
			int iconWidth = image.getIconWidth();
			int iconHeight = image.getIconHeight();
			int x = currentRoom.getCorner().x + (Room.SIZE - iconWidth)/2;
			int y = currentRoom.getCorner().y + (Room.SIZE - iconHeight)/2;
			xyPosition.setLocation(x,y);
		}
	}

	/**
	 * Draw the sprite's image at its current position
	 * @param g the current Graphics context
	 */
	public void draw(Graphics g) {
		if (currentRoom != null) {
			image.paintIcon(null, g, xyPosition.x, xyPosition.y);
		}
	}

	/**
	 * Return the Room where the sprite is
	 * @return the current Room object
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Move the sprite to the room to its south, if possible
	 * @return true if we could move; false otherwise
	 */
	public boolean moveSouth() {
		if (currentRoom != null && currentRoom.hasSouthExit()) {
			setCurrentRoom(currentRoom.getSouthExit());
			return true;
		} else {
			return false;
		}		
	}

	/**
	 * Move the sprite to the room to its north, if possible
	 * @return true if we could move; false otherwise
	 */
	public boolean moveNorth() {
		if (currentRoom != null && currentRoom.hasNorthExit()) {
			setCurrentRoom(currentRoom.getNorthExit());
			return true;
		} else {
			return false;
		}		
	}

	/**
	 * Move the sprite to the room to its east, if possible
	 * @return true if we could move; false otherwise
	 */
	public boolean moveEast() {
		if (currentRoom != null && currentRoom.hasEastExit()) {
			setCurrentRoom(currentRoom.getEastExit());
			return true;
		} else {
			return false;
		}		
	}

	/**
	 * Move the sprite to the room to its west, if possible
	 * @return true if we could move; false otherwise
	 */
	public boolean moveWest() {
		if (currentRoom != null && currentRoom.hasWestExit()) {
			setCurrentRoom(currentRoom.getWestExit());
			return true;
		} else {
			return false;
		}		
	}
	

}
