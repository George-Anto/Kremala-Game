import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
	
	private String randomWord;
	private ArrayList<Character> rWord = new ArrayList<>();
	private ArrayList<Character> processingWord = new ArrayList<>();
	
	public Dictionary() {
	
		randomWord = "";
	}
	
	public String getWord() {
		
		//Επιλογή τυχαίας λέξης
		int index = getRandomIntegerBetweenRange(0, 30);
		
		switch (index) {
		case 0: return randomWord = "UNIVERSITY";
		case 1: return randomWord = "COMPUTER";
		case 2: return randomWord = "LAPTOP";
		case 3: return randomWord = "HEADPHONES";
		case 4: return randomWord = "FUZZY";
		case 5: return randomWord = "DOG";
		case 6: return randomWord = "KEYHOLE";
		case 7: return randomWord = "TELEPHONE";
		case 8: return randomWord = "PRINTER";
		case 9: return randomWord = "BUILDING";
		case 10: return randomWord = "GREECE";
		case 11: return randomWord = "DOOR";
		case 12: return randomWord = "FLOWER";
		case 13: return randomWord = "BEAUTIFUL";
		case 14: return randomWord = "TEAM";
		case 15: return randomWord = "LONG";
		case 16: return randomWord = "SPOON";
		case 17: return randomWord = "FOOTBALL";
		case 18: return randomWord = "CANDAL";
		case 19: return randomWord = "ILLNESS";
		case 20: return randomWord = "HUG";
		case 21: return randomWord = "TREE";
		case 22: return randomWord = "EARTH";
		case 23: return randomWord = "ITALY";
		case 24: return randomWord = "LUNG";
		case 25: return randomWord = "FLAG";
		case 26: return randomWord = "CAR";
		case 27: return randomWord = "CONTINENT";
		case 28: return randomWord = "STONE";
		case 29: return randomWord = "OCEAN";
		case 30: return randomWord = "APARTMENT";
		default: return "Illegal index";
		}
		
	}
	
	//Μέθοδος παραγωγής τυχαίου αριθμού
	public int getRandomIntegerBetweenRange(int min, int max){
	    int x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	public void kremala() {
		
		//Δημιουργία συνδεδεμένων λιστών για συγκρίσεις χαρακτήρων 
		for (int i = 0; i < randomWord.length(); i++) {
			rWord.add(randomWord.charAt(i));
			processingWord.add('-');
		}
		int guesses = 7;
		int correctGuesses = 0;
		int falseGuesses = 0;
		System.out.printf("The random word is now: ");
		System.out.println(processingWord);
		System.out.println("You have " + (guesses+1) + " guesses left.");
		while(guesses >= 0 ^ rWord.equals(processingWord)) {
			System.out.println("Your guess?");
			Scanner in = new Scanner(System.in);
			char letter = in.next().charAt(0);
			int asciiLetter = letter;
			//Έλεγχος για είσοδο γράμματος και όχι άλλου χαρακτήρα
			while((asciiLetter < 65 || asciiLetter > 90) && (asciiLetter < 97 || asciiLetter > 122)) {
				System.out.println("You need to type a letter, please try again.");
				letter = in.next().charAt(0);
				asciiLetter = letter;
			}
			//Μετατροπή πεζού γράμματος σε κεφαλαίο
			if(asciiLetter > 90)
				letter = (char) (asciiLetter - 32);
			//Η flag1 μας δείχνει αν το γράμμα που έδωσε ο χρήστης υπάρχει στην κρεμάλα
			boolean flag1 = false;
			//Η flag2 δεν επιτρπέπει στην μεταβλητή correctGuesses να αυξηθεί κατά 1 όταν 
			//ο χρήστης δώσει γράμμα που έχει ήδη τοποθετηθέι στην κρεμάλα ως σωστό
			boolean flag2 = false;
			//Έλεγχος για το αν ο χαρακτήρας υπάρχει στην λέξη
			for (int i = 0; i < randomWord.length(); i++) {
				int randomWordLetter = rWord.get(i);
				if(randomWordLetter == letter || (randomWordLetter + 32) == letter) {
					flag1 = true;
					if(processingWord.get(i).equals('-')) {
						processingWord.set(i, letter);
						flag2 = true;
					}	
				}	
			}
			if(flag1) {
				if(flag2)
					correctGuesses++;
				flag2 = false;
				System.out.println("Your guess is correct!!");
				
			}else {
				falseGuesses++;
				System.out.println("There are no " + letter + "'s in the word.");
				guesses--;
			}
			if(!(rWord.equals(processingWord))){
				System.out.println("The random word is now: " + processingWord);
				System.out.println("You have " + (guesses+1) + " guesses left.");
			}
			//Εμφάνιση μηνυμάτων επιτυχίας αν ο χρήστης βρει την λέξη
			if(rWord.equals(processingWord)) {
				System.out.println("Congratulations! You guessed the word: " + processingWord);
				System.out.println("You made " + correctGuesses + " correct guesses and " + falseGuesses + " wrong guesses.");
			}else
				//Εμφάνιση μηνυμάτων αποτυχίας αν ο χρήστης δεν την βρει
				if(guesses == -1) {
					System.out.println("Unfortunately you lost this round.");
					System.out.println("The correct word was: " + rWord);
					System.out.println("You made " + correctGuesses + " correct guesses and " + falseGuesses + " wrong guesses.");
				}
			
		}
			
	}
	
	//Μέθοδος για έλεγχο νίκης ή ήττας της παρτίδας
	public boolean isGameWon() {
		return (rWord.equals(processingWord));
	}

}
