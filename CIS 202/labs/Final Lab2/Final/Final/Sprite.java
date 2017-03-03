import java.awt.*;

import javax.swing.*;

//This class is for icons
public class Sprite {
	protected Room currentRoom;
	protected ImageIcon image;
	private Point pos;
	
	//set null position and image
	public Sprite() {
		currentRoom = null;
		image = null;
	}
	
	//bring positions from Room class
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	//use method to find position where the icon will be
	public void setCurrentRoom(Room r) {
		currentRoom = r;
		pos = r.getPosition();
	}
	
	//draw method to make icons drawn
	public void draw(Graphics g) {
		image.paintIcon(null,g,pos.x+20,pos.y+20);
	}
}
