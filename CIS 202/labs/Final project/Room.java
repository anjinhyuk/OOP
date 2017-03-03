
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * This class represents a single room within a larger building.
 * Each room has a (x,y) position, as well as links to other rooms
 * to the north, east, south, and west.
 */
public class Room {
	private Point pos;
	private Room exitEast;
	private Room exitWest;
	private Room exitNorth;
	private Room exitSouth;
	
	public static final int SIZE = 50;
	public static final int DOOR = 5;
	
	public Room(int x, int y) {
		pos = new Point(x,y);
		exitEast = null;
		exitWest = null;
		exitNorth = null;
		exitSouth = null;
	}
	
	public void setEastExit(Room r) {
		exitEast = r;
		r.exitWest = this;
	}
	
	public void setNorthExit(Room r) {
		exitNorth = r;
		r.exitSouth = this;
	}
	
	public void setWestExit(Room r) {
		exitWest = r;
		r.exitEast = this;
	}
	
	public void setSouthExit(Room r) {
		exitSouth = r;
		r.exitNorth = this;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		
		if  (exitNorth == null) {
			g.drawLine(pos.x, pos.y, pos.x+SIZE, pos.y);
		} else {
			g.drawLine(pos.x, pos.y, pos.x+SIZE/2-DOOR, pos.y);
			g.drawLine(pos.x+SIZE/2+DOOR, pos.y, pos.x+SIZE, pos.y);
			g.drawLine(pos.x+SIZE/2+DOOR, pos.y, pos.x+SIZE/2+DOOR, pos.y-DOOR);
			g.drawLine(pos.x+SIZE/2-DOOR, pos.y, pos.x+SIZE/2-DOOR, pos.y-DOOR);
		}
		
		if  (exitSouth == null) {
			g.drawLine(pos.x, pos.y+SIZE, pos.x+SIZE, pos.y+SIZE);
		} else {
			g.drawLine(pos.x, pos.y+SIZE, pos.x+SIZE/2-DOOR, pos.y+SIZE);
			g.drawLine(pos.x+SIZE/2+DOOR, pos.y+SIZE, pos.x+SIZE, pos.y+SIZE);
			g.drawLine(pos.x+SIZE/2+DOOR, pos.y+SIZE, pos.x+SIZE/2+DOOR, pos.y+SIZE+DOOR);
			g.drawLine(pos.x+SIZE/2-DOOR, pos.y+SIZE, pos.x+SIZE/2-DOOR, pos.y+SIZE+DOOR);
		}
		
		if (exitEast == null) {
			g.drawLine(pos.x+SIZE, pos.y, pos.x+SIZE, pos.y+SIZE);
		} else {
			g.drawLine(pos.x+SIZE, pos.y, pos.x+SIZE, pos.y+SIZE/2-DOOR);
			g.drawLine(pos.x+SIZE, pos.y+SIZE/2+DOOR, pos.x+SIZE, pos.y+SIZE);
			g.drawLine(pos.x+SIZE, pos.y+SIZE/2+DOOR, pos.x+SIZE+DOOR, pos.y+SIZE/2+DOOR);
			g.drawLine(pos.x+SIZE, pos.y+SIZE/2-DOOR, pos.x+SIZE+DOOR, pos.y+SIZE/2-DOOR);
		}

		if (exitWest == null) {
			g.drawLine(pos.x, pos.y, pos.x, pos.y+SIZE);
		} else {
			g.drawLine(pos.x, pos.y, pos.x, pos.y+SIZE/2-DOOR);
			g.drawLine(pos.x, pos.y+SIZE/2+DOOR, pos.x, pos.y+SIZE);
			g.drawLine(pos.x, pos.y+SIZE/2+DOOR, pos.x-DOOR, pos.y+SIZE/2+DOOR);
			g.drawLine(pos.x, pos.y+SIZE/2-DOOR, pos.x-DOOR, pos.y+SIZE/2-DOOR);
		}
	}
	
	public Point getCorner() {
		return pos;
	}

	public boolean hasSouthExit() {
		return exitSouth != null;
	}
	
	public boolean hasNorthExit() {
		return exitNorth != null;
	}
	
	public boolean hasEastExit() {
		return exitEast != null;
	}
	
	public boolean hasWestExit() {
		return exitWest != null;
	}
	
	public Room getWestExit() {
		return exitWest;
	}
	
	public Room getEastExit() {
		return exitEast;
	}
	
	public Room getNorthExit() {
		return exitNorth;
	}
	
	public Room getSouthExit() {
		return exitSouth;
	}
}
