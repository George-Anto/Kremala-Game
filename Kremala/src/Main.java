import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		char answer;
		int totalGames = 0;
		int totalWins = 0;
		int totalDefeats = 0;
		
		do {
			//�������� �����
			System.out.println("---------MAIN MENU---------");
			System.out.println(" - Start a new game (Type N)");
			System.out.println(" - Statistics (Type S)");
			System.out.println(" - Exit game (Type E)");
			System.out.println("---------------------------");
			System.out.println("Please enter your choice: ");
			do {
				//������� ��������� ��� ������
				Scanner in = new Scanner(System.in);
				answer = in.next().charAt(0);
				if(answer != 'N' && answer != 'S' && answer != 'E')
					System.out.println("Please enter a valid choice: ");
			}while(answer != 'N' && answer != 'S' && answer != 'E');
			
			if(answer == 'N') {
				//���������� ������������ ����� Dictionary 
				Dictionary currentWord = new Dictionary();
				currentWord.getWord();
				//System.out.println(currentWord.getWord());
				//����� ������� ���������� ��� �������� ��� �� �������� �����������
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
				//�������� ��� ����������� ��� ������
				System.out.println("You have played " + totalGames + " game(s).");
				if(totalGames > 0)
					System.out.println("You won " + totalWins + " of them and lost " + totalDefeats + ".");
			}
			
				
			
		}while(answer != 'E');
		//�������� ��������� ����������� ��� ����������
		System.out.println("---GAME IS COMPLETED---");
		
	}	

}
