
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

/**
 * This is the "main" class of the program.
 * This is where all the other objects are created, and where
 * all the rendering (drawing) is initiated.
 *
 */
public class Maze extends JApplet implements KeyListener {

	private ArrayList<Room> rooms;
	public static int WINDOW_SIZE;
	private David boy;
	private Goliath giant;
	private ArrayList <Stone> stones;

	/**
	 * The init method runs once, at the very start of the program.
	 */
	@Override
	public void init() {
		addKeyListener(this);
		WINDOW_SIZE = getWidth();

		rooms = new ArrayList<Room>();
		stones = new ArrayList<Stone>();
		Room r1 = new Room(10, 10);
		Room r2 = new Room(70, 10);
		Room r3 = new Room(130, 10);
		Room r4 = new Room(190, 10);
		Room r5 = new Room(10, 70);
		Room r6 = new Room(70, 70);
		Room r7 = new Room(130, 70);
		Room r8 = new Room(190, 70);
		Room r9 = new Room(10, 130);
		Room r10 = new Room(70, 130);
		Room r11 = new Room(130, 130);
		Room r12 = new Room(190, 130);
		Room r13 = new Room(10, 190);
		Room r14 = new Room(70, 190);
		Room r15 = new Room(130, 190);
		Room r16 = new Room(190, 190);

		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		rooms.add(r4);
		rooms.add(r5);
		rooms.add(r6);
		rooms.add(r7);
		rooms.add(r8);
		rooms.add(r9);
		rooms.add(r10);
		rooms.add(r11);
		rooms.add(r12);
		rooms.add(r13);
		rooms.add(r14);
		rooms.add(r15);
		rooms.add(r16);

		r1.setEastExit(r2);
		r2.setEastExit(r3);
		r2.setSouthExit(r6);
		r3.setEastExit(r4);
		r5.setEastExit(r6);
		r6.setEastExit(r7);
		r8.setSouthExit(r12);
		r9.setEastExit(r10);
		r9.setSouthExit(r13);
		r10.setEastExit(r11);
		r10.setSouthExit(r14);
		r11.setNorthExit(r7);
		r12.setSouthExit(r16);
		r14.setEastExit(r15);
		r15.setEastExit(r16);

		boy = new David();
		giant = new Goliath();
		boy.setCurrentRoom(r13);
		giant.setCurrentRoom(r4);
		for (int i=0; i<5; i++) {
			stones.add(new Stone());
		}
		stones.get(0).setCurrentRoom(r1);
		stones.get(1).setCurrentRoom(r5);
		stones.get(2).setCurrentRoom(r10);
		stones.get(3).setCurrentRoom(r8);
		stones.get(4).setCurrentRoom(r16);

	}


	/**
	 * This method initiates all the drawing for the applet.
	 * Rather than drawing things directly, however, it delegates
	 * all the rendering to the individual Room/Sprite objects.
	 */
	@Override
	public void paint(Graphics g) {
		WINDOW_SIZE = getWidth();

		//fill in the background color
		g.setColor(new Color(200, 255, 200));
		g.fillRect(0, 0, WINDOW_SIZE, WINDOW_SIZE);

		//draw the rooms
		for (int i=0; i<rooms.size(); i++) {
			rooms.get(i).draw(g);
		}

		//draw the sprites
		boy.draw(g);
		giant.draw(g);
		for (Stone s: stones) {
			s.draw(g);
		}
	}

	/**
	 * Accept the user's keyboard input.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_UP:
			boy.moveNorth();
			break;
		case KeyEvent.VK_DOWN:
			boy.moveSouth();
			break;
		case KeyEvent.VK_LEFT:
			boy.moveWest();
			break;
		case KeyEvent.VK_RIGHT:
			boy.moveEast();
			break;
		default: break;
		}

		repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

}
