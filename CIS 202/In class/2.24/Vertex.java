//overloading
public class Vertex {
	int x;
	int y;
	
	//constructor using int xx, yy (variable names)
	//if use int x, y can confuse the computer to compile
	//local variable has same name as field
	
	public Vertex (int xx, int yy) {
		x = xx;
		y = yy;
	}
	
	//put this in front of variable to represent this is a variable
	//"this" is used to bring from the field
	/*public Vertex (int x, int y) {
		this.x = x;
		this.y = y;
	}*/
	
	//kind of default when nothing has been written
	//zero parameter
	public Vertex () {
		x = 0;
		y = 0;
	}
	
	//this is called a "COPY CONSTRUCTOR"
	public Vertex(Vertex v) {
		x = v.x;
		y = v.y;
	}
	
	//can have constructors with the same name
}
