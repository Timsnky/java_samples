import java.util.ArrayList;
import java.util.Scanner;

public class Parlour {
	public static void main(String [] args){
		ArrayList<String> players = new ArrayList<String>();
		ArrayList<String> nextRound = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		String name;
		int round = 1, total = 0, choice;
		boolean wrongChoice = false;
		
		System.out.println("Welcome to our Parlour Game. The Rules are that We will first Accept the names of the 12"
				+ " players in the game after which for each person in the game following the order you provided your names"
				+ " you will roll the two dice and if the total of the dice is even you get to continue playing and if odd you "
				+ "are eliminated. The winner is the last person remaining.\n\nStarting the Game...\n");
		
		
		
		do{
			round = 1;
			for(int i = 1; i < 13; i++){
				System.out.println("Enter the Name of Player " + i + ": ");
				name = input.next();
				players.add(name);
			}
			
			while(players.size() > 1){
				System.out.println("\nStarting Round " + round + " of the Game");
				System.out.println(players.size());
				for(int i = 0; i < players.size(); i ++){
					if(round > 2){
						System.out.println("Let " + players.get(i) + " Roll the Dice and Enter the Total Number Obtained: ");
					}else{
						System.out.println("Let Player " + (i + 1) + " Roll the Dice and Enter the Total Number Obtained: ");
					}
					total = input.nextInt();
					if(total % 2 != 0){
						System.out.println("Sorry, You have been Eliminated from the Game.");					
					}else{
						nextRound.add(players.get(i));
						System.out.println("Congratulations, You have qualified to move to the Next Round.");
					}
				}
				players = new ArrayList(nextRound);
				nextRound.clear();
				round ++;				
			}
			
			if(players.size() == 1){
				System.out.println("\nCongratulations " + players.get(0) + " , You are the Winner of the Game.\n");
							
			}else if(players.size() == 0) {
				System.out.println("Everybody was Eliminated in the Last Round so there is no Winnner.");
			}
			do{
				
				System.out.println("Would you wish to play the game again?\n1. Yes\n2. No");
				choice = input.nextInt();
				if(choice != 1 && choice != 2){
					wrongChoice = true;
					System.out.println("You have selected the wrong option, Please reselect again");
				}
			}while(wrongChoice);
			if(choice == 1){
				System.out.println("Starting a New Game...\n\n");
			}else if(choice == 2){
				System.out.println("Exiting the Game. Congratulations to the Winner and Consolation to the Losers");
			}
		}while(choice == 1);
	}

}
