import javax.swing.JApplet;
import java.awt.*;

public class SheepApplet extends JApplet {

	@Override
	public void paint(Graphics g) {
		int x; //declare a new whole-number variable
		x = 50;
		//draw a green background
		//g.setColor(Color.GREEN);
		
		g.setColor(new Color (90,100,39));
		g.fillRect(0,0,400,400);
		
		//Now, draw that sleep!
		
		g.setColor(Color.WHITE);
		
		g.fillOval(x+75,200,225,100);
		g.fillOval(x+50,150,75,75);
		
		g.fillRect(x+100,250,25,100);
		g.fillRect(x+150,250,25,100);
		g.fillRect(x+200,250,25,100);
		g.fillRect(x+250,250,25,100);
	}
}