import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class TempleReader {

	public static void main(String args[]) {
		String filename = "temples.txt";
		File f = new File(filename);
		ArrayList<String> jaxon = new ArrayList<>();
		try {
			Scanner s = new Scanner(f);
			while (s.hasNext()) {
				String line = s.nextLine();
				jaxon.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Collections.sort(jaxon);
		//Collections.reverse(jaxon);
		//Collections.shuffle(jaxon);
		for (String t : jaxon) {
			System.out.println("Another temple: " + t);
			/*if (t.contains("Utah")) {
				System.out.println(t);
			}*/
		}

	}

}
