import javax.swing.JApplet;
import java.awt.*;

public class SheepApplet extends JApplet {

	//int lima;
	
	@Override
	public void paint(Graphics g) {
		int w = getWidth();
		int h = getHeight();
		
		//draw a green background
		g.setColor(Color.GREEN);
		g.fillRect(0,0,w,h);
	
		//
		Vertex lito = new Vertex(100, 200); //declare variables vertex to create x, y
		drawSheep(g, lito);
		Vertex gabriel = new Vertex(lito);
		gabriel.x += 400;
		drawSheep(g, gabriel);
	}
	
	public void drawSheep(Graphics g, Vertex V) { //class variable just write whatever the name is 
		//Vertex V is local variable
		//NOW, draw that sheep!
		g.setColor(Color.WHITE);
		
		g.fillOval(V.x+75,V.y+200,225,100); //use V. to bring ints inside the Vertex
		g.fillOval(V.x+50,V.y+150,75,75);
	
		g.fillRect(V.x+100,V.y+250,25,100);
		g.fillRect(V.x+150,V.y+250,25,100);
		g.fillRect(V.x+200,V.y+250,25,100);
		g.fillRect(V.x+250,V.y+250,25,100);		
	}

}
