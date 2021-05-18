import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		char answer;
		int totalGames = 0;
		int totalWins = 0;
		int totalDefeats = 0;
		
		do {
			//Εμφάνιση μενού
			System.out.println("---------MAIN MENU---------");
			System.out.println(" - Start a new game (Type N)");
			System.out.println(" - Statistics (Type S)");
			System.out.println(" - Exit game (Type E)");
			System.out.println("---------------------------");
			System.out.println("Please enter your choice: ");
			do {
				//Επιλογή ενέργειας του χρήστη
				Scanner in = new Scanner(System.in);
				answer = in.next().charAt(0);
				if(answer != 'N' && answer != 'S' && answer != 'E')
					System.out.println("Please enter a valid choice: ");
			}while(answer != 'N' && answer != 'S' && answer != 'E');
			
			if(answer == 'N') {
				//Δημιουργία αντικειμένου τύπου Dictionary 
				Dictionary currentWord = new Dictionary();
				currentWord.getWord();
				//System.out.println(currentWord.getWord());
				//Κλήση μεθόδου υλοποίησης της κρεμάλας για το παραπάνω αντικείμενο
				currentWord.kremala();
				totalGames++;
				if(currentWord.isGameWon()) {
					totalWins++;
				}
				else {
					totalDefeats++;
				}		
			}
			
			else if(answer == 'S') {
				//Εμφάνιση των στατιστικών του χρήστη
				System.out.println("You have played " + totalGames + " game(s).");
				if(totalGames > 0)
					System.out.println("You won " + totalWins + " of them and lost " + totalDefeats + ".");
			}
			
				
			
		}while(answer != 'E');
		//Εμφάνιση μηνύματος τερματισμού του παιχνιδιού
		System.out.println("---GAME IS COMPLETED---");
		
	}	

}
