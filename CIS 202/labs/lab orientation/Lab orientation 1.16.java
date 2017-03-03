import javax.swing.JApplet;
import java.awt.Graphics;

public class HelloApplet extends JApplet{

    //a-single-line comment begins with slash-slash
    /*
    a multi-line
    comment
    starts with slash-star
    and ends
    with star-slash
    */
    
    //we're OVERIDING the paint method
    //that already exists in the JApplet class.
    //We're replacing it with our own method
    //that will be far more interesting.
    @Override
    public void paint (Graphics g) {
        g.drawString ("A : Knock, kcnok!", 10, 10);
        g.drawString ("B : Who's there?", 10, 30);
        g.drawString ("A : Poo?", 10, 50);
        g.drawString ("B : Poo, who?", 10, 70);
        g.drawString ("A : Don't cry~", 10, 90);
    }
    
}