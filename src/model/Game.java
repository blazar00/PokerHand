package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	public void printPlus(){
		System.out.println("++++++++++++++++++++++++++++++++");
	}

	public static void main() {
		Scanner in = new Scanner(System.in);
		System.out.print("How many players? ");
		int users = in.nextInt();
		ArrayList<Player> players = new ArrayList<Player>(users);
		for (int i = 0; i < users; i++) {
			players.add(new Player());
		}

		boolean isContinuing = true;
		while (isContinuing) {

			List<Card> cards = new ArrayList<Card>(52);
			for (Suit suit : Suit.values()) {
				for (Rank rank : Rank.values()) {
					cards.add(new Card(rank, suit));
				}
			}

			boolean inputIsInvalid = true;
			while (inputIsInvalid) {
				System.out.print("Continue? (y/n): ");

				String choice = in.next();

				if ("y".equalsIgnoreCase(choice)) {
					inputIsInvalid = false;
				} else if ("n".equalsIgnoreCase(choice)) {
					inputIsInvalid = false;
					isContinuing = false;
				} else {
					System.err.print("Error: Only valid answers are y/n.");
				}
			}
		}
		in.close();

	}

}
