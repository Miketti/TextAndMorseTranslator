package mainpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
	
	public static void main (String [] args) throws NumberFormatException, IOException {
		
		//Welcome text will be shown to the user. After the welcome text, showOpinions method shows available opinons for the user.
		System.out.println("WELCOME! \n\nThis program translates text to morse code and vice versa.\n");
		showOpinions();
		
		int number_choice = 3;
		Translator translator = new Translator();
		
		//User input will be read using BufferedReader
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		/*Do while -loop will be used for keeping program execution alive until the user wants to close the program. 
		 * That enables the program execution continuing after invalid user commands and also after translation operations. */
		do {
			try {
				
				number_choice = Integer.parseInt(stdin.readLine());
				
				switch (number_choice) {
				
				case 1:
					translator.englishToMorseCode();
					showOpinions();
				break;
			
				case 2:
					translator.morseCodeToEnglish();
					showOpinions();
				break;
				
				case 0:
					System.out.println("Program execution ended.");
				break;
				
				//If user selects some other number than 1,2 or 0, the user will be informed and available opinions are shown again.
				default:
				System.out.println("Invalid choice. The number must be 1,2 or 0.\n");
				showOpinions();
			}
			
		} catch (NumberFormatException e) {
			
			//If user input is not a number at all, the user will be informed and available opinions are shown again.
			System.out.println("Invalid choice. You must choose a number.\n");
			showOpinions();
			
		}
		
			//This loop will be run unless the user selects number 0.
		} while (number_choice != 0);
	}
	
	//These opinions will be shown for the user. The user will select one of those methods using numbers in keyboard.
	public static void showOpinions() {
		System.out.println("THIS IS THE MAIN MENU OF THE PROGRAM");
		System.out.println("Choose corresponding number on your keyboard and press ENTER: \n");
		System.out.println("1: Text to morse code");
		System.out.println("2: Morse code to text");
		System.out.println("0: Exit program");
	}
	
}
