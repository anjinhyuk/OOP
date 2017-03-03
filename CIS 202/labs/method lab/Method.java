import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

//star my method lab
public class Method extends JApplet {

//two array lists that I am going to use.
ArrayList<String> english = new ArrayList<>();
ArrayList<String> korean = new ArrayList<>();

	//bring text file as an array
	public void loadEnglishWords() {
		//input my file
		String filename = "english.txt";
		File f = new File(filename);
		try {
			Scanner s = new Scanner(f);
			//scan all array line by line
			while (s.hasNextLine()) {
				String line = s.nextLine();
				english.add(line);
			}
		} catch (FileNotFoundException e) { //wrong file name makes error massage pop up
			String errorMessage = "Wrong!";
			JOptionPane.showMessageDialog(null, errorMessage, "Wrong!",JOptionPane.ERROR_MESSAGE);
			
		}	
	}
	
	//same array job with English to compare
	public void loadKoreanWords() {
		String filename = "korean.txt";
		File f = new File(filename);
		try {
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				String line = s.nextLine();
				korean.add(line);
			}
		} catch (FileNotFoundException e) {
			String errorMessage = "Wrong!";
			JOptionPane.showMessageDialog(null, errorMessage, "Wrong!",JOptionPane.ERROR_MESSAGE);
			
		}	
	}

	//check each line to parallel my arrays to get to same position
	public String lookup(String word){
		for (int i = 0; i < english.size();i++) {
			if (word.equals(english.get(i))) {
				return korean.get(i);
			}
		}
		//wrong values in arrays 
		return "No match found";
	}
	
	//infinite loop to run my program until get the result
	public void mainLoop() {
		while (true) {
			//pop-up box to ask English words
			String tmp = JOptionPane.showInputDialog("Please Enter an English Word!");
			//store the result in variable r
			String r = lookup(tmp);
			String a;
			//
			if (r == ("No match found")) {
				a = "Write a Right Word!";
			} else {
				a = "The Korean word is : " + r + ". Play agian?";
				
			}
			//asking want to play more or not
			int result;
			result = JOptionPane.showConfirmDialog(null,a,"RESULT!",JOptionPane.YES_NO_OPTION);
			//doens't want to play then shut down
			if (result == JOptionPane.NO_OPTION) {
				break;
			}
		}

	}
	
	
	//make all things run in order
	@Override
	public void init() {
		loadEnglishWords();
		loadKoreanWords();
		mainLoop();	
	}
}
