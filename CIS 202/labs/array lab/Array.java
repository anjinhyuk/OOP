import javax.swing.JApplet;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Array extends JApplet {
	//prepare array 
	int x;
	int y;
	int [][] star = new int [200][200];
	//put 0 for whole array
	
	public void init(){
		for (int i = 0 ; i < 200 ; i++) { 
		for (int j = 0 ; j < 200 ; j++) {
			star[i][j] = 0;
		}
	}
	String filename = "coordinates.txt"; //inputting a file
	File f = new File(filename);
		try {
			Scanner s = new Scanner(f);
			while (s.hasNext() == true) {
			//bring numbers from text file as a pair
			x = s.nextInt();
			y = s.nextInt();
			//use coordinate to draw a star
			star [x][y] = 1;
			star [x-1][y-1] = 1;
			star [x-2][y-2] = 1;
			star [x-3][y-3] = 1;
			star [x-1][y+1] = 1;
			star [x-2][y+2] = 1;
			star [x-3][y+3] = 1;
			star [x+1][y-1] = 1;
			star [x+2][y-2] = 1;
			star [x+3][y-3] = 1;
			star [x+1][y+1] = 1;
			star [x+2][y+2] = 1;
			star [x+3][y+3] = 1;
			star [x][y-1] = 1;
			star [x][y-2] = 1;
			star [x][y-3] = 1;
			star [x+1][y] = 1;
			star [x+2][y] = 1;
			star [x+3][y] = 1;
			star [x][y+1] = 1;
			star [x][y+2] = 1;
			star [x][y+3] = 1;
			star [x-1][y] = 1;
			star [x-2][y] = 1;
			star [x-3][y] = 1;
			
			}
		//if it fail to input file say this
		}catch (FileNotFoundException e) {
			System.out.println("Could not find file " + filename);
		}
	}
	@Override
	public void paint(Graphics g) {
		for (int i = 0 ; i < 200 ; i++) {
			for (int j = 0 ; j < 200 ; j++) {
				if (star[i][j] == 0) {
					g.setColor(Color.BLACK);
					g.fillRect(i,j,1,1);
				}
				else {
					g.setColor(Color.WHITE);
					g.fillRect(i,j,1,1);
				}
			}
		}
	}
}