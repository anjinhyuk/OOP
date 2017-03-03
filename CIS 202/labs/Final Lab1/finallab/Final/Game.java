import java.awt.*;
import javax.swing.*;

public class Game extends JApplet {
	private Room room1;
	private Room room2;
	private Room room3;
	private Room room4;
	private Room room5;
	private Room room6;
	private Room room7;
	private Room room8;
	private Room room9;
	private Room room10;
	private Room room11;
	private Room room12;
	private Room room13;
	private Room room14;
	private Room room15;
	private Room room16;
	private Room room17;
	private Room room18;
	private Room room19;
	private Room room20;
	private Room room21;
	private Room room22;
	private Room room23;
	private Room room24;
	private Room room25;
		
	@Override
	public void init() {
	//ROOMS
	room1 = new Room(0,0);
	room2 = new Room(60,0);
	room3 = new Room(0,60);
	room4 = new Room(60,60);
	room5 = new Room(0,120);
	room6 = new Room(60,120);
	room7 = new Room(0,180);
	room8 = new Room(60,180);
	room9 = new Room(0,240);
	room10 = new Room(60,240);
	room11 = new Room(120,120);
	room12 = new Room(180,60);
	room13 = new Room(180,120);
	room14 = new Room(180,180);
	room15 = new Room(240,120);
	room16 = new Room(300,0);
	room17 = new Room(360,0);
	room18 = new Room(300,60);
	room19 = new Room(360,60);
	room20 = new Room(300,120);
	room21 = new Room(360,120);
	room22 = new Room(300,180);
	room23 = new Room(360,180);
	room24 = new Room(300,240);
	room25 = new Room(360,240);
	
	//PATH 1-10
	room1.setSouthExit(room3);
	room1.setEastExit(room2);
	room2.setSouthExit(room4);
	room4.setSouthExit(room6);
	room5.setEastExit(room6);
	room6.setEastExit(room11);
	room6.setSouthExit(room8);
	room8.setSouthExit(room10);
	room10.setWestExit(room9);
	room7.setSouthExit(room9);
	//PATH 11-20
	room11.setEastExit(room13);
	room13.setNorthExit(room12);
	room13.setSouthExit(room14);
	room13.setEastExit(room15);
	room16.setEastExit(room20);
	room18.setSouthExit(room20);
	room16.setSouthExit(room18);
	room16.setEastExit(room17);
	room17.setSouthExit(room19);
	room19.setSouthExit(room21);
	//PATH 21-25
	room20.setSouthExit(room22);
	room22.setSouthExit(room24);
	room24.setEastExit(room25);
	room23.setSouthExit(room25);
	room22.setEastExit(room23);
	}
	
	//background setting
	@Override
	public void paint (Graphics g) {
		int w = getWidth();
	    int h = getHeight();
	    g.setColor(Color.BLACK);
	    g.fillRect(0, 0, w, h);
	    //draw rooms
	    room1.draw(g);
	    room2.draw(g);
	    room3.draw(g);
	    room4.draw(g);
	    room5.draw(g);
	    room6.draw(g);
	    room7.draw(g);
	    room8.draw(g);
	    room9.draw(g);
	    room10.draw(g);
	    room11.draw(g);
	    room12.draw(g);
	    room13.draw(g);
	    room14.draw(g);
	    room15.draw(g);
	    room16.draw(g);
	    room17.draw(g);
	    room18.draw(g);
	    room19.draw(g);
	    room20.draw(g);
	    room21.draw(g);
	    room22.draw(g);
	    room23.draw(g);
	    room24.draw(g);
	    room25.draw(g);
	}
}
