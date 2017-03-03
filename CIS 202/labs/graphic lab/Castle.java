import javax.swing.JApplet;
import java.awt.*;

public class Castle extends JApplet {

	@Override
	public void paint(Graphics g) {
		
		//draw a sky background
		g.setColor(new Color(80,224,184));
		g.fillRect(0,0,800,800);
		//draw grass
		g.setColor(Color.GREEN);
		g.fillRect(0,600,800,200);
		
		//draw river
		g.setColor(Color.BLUE);
		g.fillRect(0,700,800,100);
		
		//draw waves
		g.setColor(Color.GREEN);
		g.fillOval(-80,650,100,100);
		g.fillOval(0,650,100,100);
		g.fillOval(80,650,100,100);
		g.fillOval(160,650,100,100);
		g.fillOval(240,650,100,100);
		g.fillOval(320,650,100,100);
		g.fillOval(400,650,100,100);
		g.fillOval(480,650,100,100);
		g.fillOval(560,650,100,100);
		g.fillOval(640,650,100,100);
		g.fillOval(720,650,100,100);
				
		//draw a castle!
		int x = 0;
		g.setColor(new Color(192,192,192));
		g.fillRect(200,x+230,400,400);
		g.fillRect(160,x+180,100,150);
		g.fillRect(560,x+180,100,150);
		
		g.fillRect(150,x+160,30,30);
		g.fillRect(195,x+160,30,30);
		g.fillRect(240,x+160,30,30);
		
		g.fillRect(550,x+160,30,30);
		g.fillRect(595,x+160,30,30);
		g.fillRect(640,x+160,30,30);
		//draw clouds
		g.fillOval(70,80,40,40);
		g.fillOval(100,80,40,40);
		g.fillOval(130,80,40,40);
		g.fillOval(210,60,40,40);
		g.fillOval(240,60,40,40);
		g.fillOval(270,60,40,40);
		g.fillOval(320,100,40,40);
		g.fillOval(350,100,40,40);
		g.fillOval(380,100,40,40);
		
		//draw a door
		g.setColor(new Color(255,255,0));
		g.fillRect(350,x+430,100,200);
		g.fillOval(350,x+380,100,100);
		//sign
		g.setColor(new Color(255,255,255));
		g.fillRect(350,x+330,100,30);
		g.setColor(new Color(0,0,0));
		g.drawString("Scott's Castle", 350, x+350);
		//air plane
		g.setColor(new Color(255,0,0));
		g.fillOval(600,70,150,30);
		g.fillOval(700,40,20,80);
		//banner
		g.setColor(new Color(255,255,255));
		g.fillRect(500,80,100,30);
		g.setColor(new Color(0,0,0));
		g.drawString("GO SEASIDERS!", 500, 100);
	}

}