import java.awt.*;
import javax.swing.*;


public class DuckExample extends JApplet {
	
	ImageIcon duck;
	
	@Override
	public void init() {
		duck = new ImageIcon ("duck.png");
	
	}
	
	@Override
	public void paint (Graphics g) {
		int x, y;
		x = 10;
		y = 10;
		
		int width = getWidth();
		
		/*while (x < width-50) {
			duck.paintIcon(null, g, x, y);
			x += 50;
		}*/
		
		for (int i = 0; i<5; i++) {
			duck.paintIcon(null, g, x, y);
			x += 50;
		}
	
	}


}