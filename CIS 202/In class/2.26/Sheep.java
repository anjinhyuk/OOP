import java.awt.Color;
import java.awt.Graphics;


public class Sheep {
	//private makes the method cannot be called from different class
	private Color woolColor;
	private Vertex pos;
		
	public Sheep() {
		woolColor = Color.WHITE;
		pos = new Vertex();
	}
		
	public Sheep(int x, int y) {
		woolColor = Color.WHITE;
		pos = new Vertex(x,y);
	}
		
	public Sheep(Color c) {
		woolColor = c;
		pos = new Vertex();
	}
		
	//postion + color
	public Sheep(int x, int y, Color c) {
		woolColor = c;
		pos = new Vertex(x,y);
	}
		
	//moving method
	public void move(int dx, int dy) {
		pos.x += dx;
		pos.y += dy;
	}
		
		
	//drawing method
	public void draw(Graphics g) {
		//NOW, draw that sheep!
		g.setColor(woolColor);
		
		g.fillOval(pos.x+75,pos.y+200,225,100);
		g.fillOval(pos.x+50,pos.y+150,75,75);
		g.fillRect(pos.x+100,pos.y+250,25,100);
		g.fillRect(pos.x+150,pos.y+250,25,100);
		g.fillRect(pos.x+200,pos.y+250,25,100);
		g.fillRect(pos.x+250,pos.y+250,25,100);		
	}
}
