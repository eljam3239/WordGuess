/*
 * Program edited to track score by eli

 */

package wordguess;
import java.util.Scanner;
 
 /**
  * Plays a word guessing game with one player.
  */
 public class Wordguess {

	public static void main(String[] args) {
		final String SECRET_WORD = "BRAIN";
		final String FLAG = "!";
		String wordSoFar = "", updatedWord = "";
		String letterGuess, wordGuess = "";
		int numGuesses = 0;
		Scanner input = new Scanner(System.in);
                int score = 100;
		
		/* begin game */
		System.out.println("WordGuess game.\n");
		for (int i = 0; i < SECRET_WORD.length(); i++) {
			wordSoFar += "-";								//word as dashes
		}
		System.out.println(wordSoFar + "\n");				//display dashes
	
		/* allow player to make guesses*/
		do {
			System.out.print("Enter a letter (" + FLAG + " to guess entire word): ");
			letterGuess = input.nextLine();
			letterGuess = letterGuess.toUpperCase();			
		
			/* increment number of guesses */
			numGuesses += 1;
                       
			
			/* player correctly guessed a letter--extract string in wordSoFar up to the letter 
			 * guessed and then append guessed letter to that string. Next, extract rest of 
			 * wordSoFar and append after the guessed letter
			 */
			if (SECRET_WORD.indexOf(letterGuess) >= 0) {
				updatedWord = wordSoFar.substring(0, SECRET_WORD.indexOf(letterGuess)); 
				updatedWord += letterGuess;												
				updatedWord += wordSoFar.substring(SECRET_WORD.indexOf(letterGuess)+1, wordSoFar.length());
				wordSoFar = updatedWord;
			}
				
			/* display guessed letter instead of dash */
			System.out.println(wordSoFar + "\n");
		} while (!letterGuess.equals(FLAG) && !wordSoFar.equals(SECRET_WORD) && numGuesses !=10);//when the user has guessed 10 times, they lose
		
		/* finish game and display message and number of guesses */
		if (letterGuess.equals(FLAG)) {
			System.out.println("What is your guess? ");
			wordGuess = input.nextLine();
			wordGuess = wordGuess.toUpperCase();
		}
		if (wordGuess.equals(SECRET_WORD)) {
			System.out.println("You won!");
                        score = score -numGuesses*10+10;
                        System.out.println(score);//score if the guess the whole word
		} else if (wordSoFar.equals(SECRET_WORD)){//score if they guess each letter
			score = score-numGuesses*10;
                        System.out.println(score);
		} else   {//score when they lose: 0
                    System.out.println("Sorry. You lose.");
                    score = 0;
                    System.out.println("Your score is : " + (score));
                }
		System.out.println("The secret word is " + SECRET_WORD);
		System.out.println("You made " + numGuesses + " guesses.");
                
	}
}