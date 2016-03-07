package examples;

import java.util.Scanner;

public class towersofHanoi {

	public static void main(String[] args) {
		// Obtain the number of rings from the user. 
		// Call the recursive move method to move the rings from peg 1 to peg 3 with peg 2 available for intermediate use.
		// Pre: number of rings != 64 Post: moves are printed into the terminal window
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter the number of rings: ");
		int numberofRings = reader.nextInt();
		move (numberofRings, 1, 3, 2 );
		}

	private static void move(int n, int i, int j, int k) {
		//print the moves for n rings going from peg i to peg j
		// Pre: N/A Post: the moves have been printed
			if(n>0){ //stops when number of rings is 0
				
				//move the n-1 smaller rings from peg i to peg k
				move(n-1, i, k, j);
				
				//move the largest ring from peg i to peg j
				System.out.println("Move ring " + n + " from peg " + i + " to " + j);
			
				//move the n-1 smaller rings from peg k to peg j
				move(n-1, k , j, i);
				//n rings have now been moved from peg i to peg j
			}
		
	}

}
