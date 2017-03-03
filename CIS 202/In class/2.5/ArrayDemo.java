import java.io.*;
import java.util.Scanner;

public class ArrayDemo {

	public static void main(String[] args) {
		//int[] score;
		//score = new int[5];
		/*int[] score = new int[5];
		score[0] = 8;
		score[1] = 6;
		score[2] = 0;
		score[3] = 10;
		score[4] = 7;*/
		int[] score = {8,6,0,10,7};

		for (int i=0; i<5; i++) {
			System.out.println("Original score " + i + " : " + score[i]);
		}
		for (int i=0; i<5; i++) {
			score[i]++;
		}
		for (int i=0; i<5; i++) {
			System.out.println("Modified score " + i + " : " + score[i]);
		}
		
		//2D array
		//question how many elements?
		double[][] nums = new double[5][7];
		nums[1][3]=42;
		
		
		//HERE, WE RE STARTING A FILE-INPUT EXAMPLE.
		String filename = "numbers.txt";
		//file variable
		File f = new File(filename);
		try {
			Scanner s = new Scanner(f);
			//scan and read the file
			
			
			for (int i=0; i<10; i++) {
				int jordan = s.nextInt();
				System.out.println("I found " + jordan + " in the file.");	
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file " + filename);
		}
	}

}


// int[][] sky = new int [200][200]
//set all zero
//open file
//int ():
/*paint 
for (x = 0 to 200)
	 for(y=0to200)
		if (sky[x][y]==0)
			draw black pixel
		else
			draw white pixel


*/
/*while(~~~~) {
		int x = s.next
		sky[x][y] = 1
}*/



