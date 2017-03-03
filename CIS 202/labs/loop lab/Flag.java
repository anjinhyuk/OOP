import java.awt.*;
import javax.swing.*;


public class Flag extends JApplet {

	//variables for pop-up boxes
	int numStripes;
	int numStarRows;
	int numStarCols;

@Override
	//pop-up boxes
	public void init() {
		String tmp = JOptionPane.showInputDialog("How many stripes do you want? Have to be more than 8");
		numStripes = Integer.parseInt(tmp);
		
		String tmp1 = JOptionPane.showInputDialog("How many stars do you want in a row?");
		numStarRows = Integer.parseInt(tmp1);
		
		String tmp2 = JOptionPane.showInputDialog("How many stars do you want in a column");
		numStarCols = Integer.parseInt(tmp2);
	}

@Override
	//prepare for drawing 
	public void paint(Graphics g) {
		int w = getWidth();
		int h = getHeight();
		int blueboxW = w*2/5;
		int StripeH = h / numStripes;
		int blueboxH = 7 * StripeH;
		int StarH = blueboxH / numStarRows;
		int StarW = blueboxW / numStarCols;
		int x;
		x = -1;
		
		//background
		g.setColor(Color.RED);
		g.fillRect(0,0,w,h);
		
		//draw columns
		g.setColor(Color.WHITE);
		for (int i=0; i<=((numStripes+1)/2); i++) {
			g.fillRect(0, (x+=2) * (h / numStripes), w ,h/numStripes);
		}
		
		//draw blue square
		g.setColor(Color.BLUE);
		g.fillRect(0,0,blueboxW,blueboxH);
		
		//draw stars
		g.setColor(Color.WHITE);
		//use for loop to work it until fill the blue box
		for (int i=0; i <= numStarRows ; i++) {
			for (int j=0; j <= numStarCols; j++) {
				g.fillOval((j-1) * (blueboxW / numStarCols), (i-1) * (blueboxH / numStarRows) ,StarW,StarH);
			}
		}	
	}
}