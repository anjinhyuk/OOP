import javax.swing.*;
import java.awt.*;

public class Theater extends JApplet {

	//age variable
	int age;
	//I am goning to use picture file
	ImageIcon picture;
	
	//make a box to ask how old is the person
	@Override
	public void init() {
		String tmp = JOptionPane.showInputDialog("what age are you in?");
		//whatever number puts, it is into age variable
		age = Integer.parseInt(tmp);
	}	

	//result screen
	@Override
	public void paint(Graphics g) {
	//background
		g.setColor(Color.WHITE);
		g.fillRect(0,0,200,200);
		g.setColor(Color.BLACK);
	
	//by using if, figure out things I can recommend
		//first condition
		if (age >= 0 && age < 3) {
			g.drawString("You get in free!",10,100);
			//picture file
			picture = new ImageIcon("planes2.jpg");
			picture.paintIcon(null, g, 10, 150);
		}
		//second condition
		if (age >= 3 && age <= 11) {
			g.drawString("You owe $6.50!",10,100);
			picture = new ImageIcon("strangemagic.jpg");
			picture.paintIcon(null, g, 10, 150);
		}
		//third condition
		if (age > 11 && age < 60) {
			g.drawString("You owe $9.50!",10,100);
			picture = new ImageIcon("turing.jpg");
			picture.paintIcon(null, g, 10, 150);
		}
		//fourth condition
		if (age >= 60 && age < 120) {
			g.drawString("That will be $6.50, please",10,100);
			picture = new ImageIcon("burbank.jpg");
			picture.paintIcon(null, g, 10, 150);
		}
		//the last condition
		if (age >= 120 || age < 0) {
			g.drawString("Are you crazy?",10,100);
		}
	}
		
}