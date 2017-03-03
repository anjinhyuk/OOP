
public class Vertex {
	int x;
	int y;
	
	public Vertex(int xx, int yy) {
		x = xx;
		y = yy;
	}
	
	public Vertex() {
		x = 0;
		y = 0;
	}
	
	//this is called a "COPY CONSTRUCTOR"
	public Vertex(Vertex v) {
		x = v.x;
		y = v.y;
	}

}
