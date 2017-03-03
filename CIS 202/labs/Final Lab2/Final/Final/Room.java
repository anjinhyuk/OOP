import java.awt.*;

public class Room {
	//variables
	private Point pos;
	private Room exitEast;
	private Room exitWest;
	private Room exitNorth;
	private Room exitSouth;
	
	//set room position
	public Room(int x, int y) {
		pos = new Point(x,y);
		exitEast = null;
		exitWest = null;
		exitNorth = null;
		exitSouth = null;
	}
	
	//exit methods
	public void setEastExit(Room r) {
		exitEast = r;
		r.exitWest = this;
	}
	public void setWestExit(Room r) {
		exitWest = r;
		r.exitEast = this;
	}
	public void setNorthExit(Room r) {
		exitNorth = r;
		r.exitSouth = this;
	}
	public void setSouthExit(Room r) {
		exitSouth = r;
		r.exitNorth = this;
	}
	
	public void draw(Graphics g) {
		//room logics
		if (exitEast == null) {
			g.setColor(new Color(51,51,255));
			g.drawLine(pos.x+10,pos.y+10,pos.x+10,pos.y+60);
		} else {
			//wall
			g.setColor(new Color(51,51,255));
			g.drawLine(pos.x+10,pos.y+10,pos.x+10,pos.y+60);
			g.drawLine(pos.x+60,pos.y+30,pos.x+70,pos.y+30);
			g.drawLine(pos.x+70,pos.y+40,pos.x+70,pos.y+40);
			//hallway
			g.setColor(Color.BLACK);
			g.drawLine(pos.x+60,pos.y+30,pos.x+60,pos.y+40);
			g.drawLine(pos.x+70,pos.y+30,pos.x+70,pos.y+40);
		}
		
		if (exitWest == null) {
			g.setColor(new Color(51,51,255));
			g.drawLine(pos.x+60,pos.y+10,pos.x+60,pos.y+60);
		} else {
			//wall
			g.setColor(new Color(51,51,255));
			g.drawLine(pos.x+60,pos.y+10,pos.x+60,pos.y+60);
			g.drawLine(pos.x,pos.y+30,pos.x+10,pos.y+30);
			g.drawLine(pos.x,pos.y+40,pos.x+10,pos.y+40);
			//hallway
			g.setColor(Color.BLACK);
			g.drawLine(pos.x,pos.y+30,pos.x,pos.y+40);
			g.drawLine(pos.x+10,pos.y+30,pos.x+10,pos.y+40);
		}

		if (exitNorth == null) {
			g.setColor(new Color(51,51,255));
			g.drawLine(pos.x+10,pos.y+10,pos.x+60,pos.y+10);
		} else {
			//wall
			g.setColor(new Color(51,51,255));
			g.drawLine(pos.x+10,pos.y+10,pos.x+60,pos.y+10);
			g.drawLine(pos.x+30,pos.y,pos.x+30,pos.y+10);
			g.drawLine(pos.x+40,pos.y,pos.x+40,pos.y+10);
			//hall
			g.setColor(Color.BLACK);
			g.drawLine(pos.x+30,pos.y,pos.x+40,pos.y);
			g.drawLine(pos.x+30,pos.y+10,pos.x+40,pos.y+10);
		}
		
		if (exitSouth == null) {
			g.setColor(new Color(51,51,255));
			g.drawLine(pos.x+10,pos.y+60,pos.x+60,pos.y+60);
		} else {
			//wall
			g.setColor(new Color(51,51,255));
			g.drawLine(pos.x+10,pos.y+60,pos.x+60,pos.y+60);
			g.drawLine(pos.x+30,pos.y+60,pos.x+30,pos.y+70);
			g.drawLine(pos.x+40,pos.y+60,pos.x+40,pos.y+70);
			//hall
			g.setColor(Color.BLACK);
			g.drawLine(pos.x+30,pos.y+60,pos.x+40,pos.y+60);
			g.drawLine(pos.x+30,pos.y+70,pos.x+40,pos.y+70);
		}
	}
	
	//save positions in getPosion
	public Point getPosition() {
		return pos;
	}
}