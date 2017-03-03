import javax.swing.*;
import java.awt.*;

public class NumbersExample extends JApplet {

	int age;

	@Override
	public void init() {
		try {
			String tmp = JOptionPane.showInputDialog("How old are you?");
			age = Integer.parseInt(tmp);		
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Sorry, I don't understand. Using default age of 16.");
			age = 16;
		}
	}

	@Override
	public void paint(Graphics g) {
		//these next five lines are a dice-simulator,
		//unrelated to the "teen power" example.
		g.setColor(Color.WHITE);
		g.fillRect(0,0,200,200);
		g.setColor(Color.BLACK);
		int r = (int)(Math.random() * 6 + 1);		
		g.drawString(""+r, 10, 10);	
		
		if (age >= 13 && age <= 19) {
			g.drawString("You have TEEN POWER!!!!!", 10, 50);
		} else {
			g.drawString("Sorry, no teen power for YOU.", 10, 50);
		}
		
	}

}