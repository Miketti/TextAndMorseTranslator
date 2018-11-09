package mainpackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//This class does actual translation work

public class Translator {
	
	//Alphabets are determined. Every character in English alphabet has a Morse character in equivalent index.
	
   char[] englishAlphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
    		'h', 'i', 'j', 'k', 'l','m', 'n',
    		'o', 'p', 'q', 'r', 's', 't', 'u',
    		'v', 'w', 'x', 'y', 'z', 
    		'.', ',', '?', '/', '@', 
    		'1', '2', '3', '4', '5', '6','7', '8', '9', '0'};
    
    String[] morseAlphabet = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
    		"....", "..", ".---", "-.-", ".-..", "--", "-.",
    		"---", ".--.", "--.-", ".-.", "...", "-", "..-",
    		"...-", ".--", "-..-", "-.--", "--..",
    		".-.-.-","--..--", "..--..", "-..-.", ".--.-.", 
    		".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----" };
	
	public Translator() {
		
	}
	
	//This method translates English string to Morse code.
	public void textToMorseCode() throws IOException {
			
		System.out.println("Navigate the textfile you want translate to morse code or choose 0 to return main menu.\nConfirm your choice pressing ENTER.\nIMPORTANT! The input file must be in .txt extension.\n");
	    System.out.println("Navigate here the file you want to translate:");
		
	    String morseCodeOutputFile;
		Scanner englishtomorsefilescanner = new Scanner(System.in);
		String userInput = englishtomorsefilescanner.nextLine();
		if(userInput.equals("0")) { //Return to main menu
			return;
			}
			
		else {
			try {													//Let's check the input file is in .txt extension.
				FileReader filereader = new FileReader(userInput);
				
				String fileExtension = "";

				int f = userInput.lastIndexOf('.');
				int p = Math.max(userInput.lastIndexOf('/'), userInput.lastIndexOf('\\'));

				if (f > p) {
				    fileExtension = userInput.substring(f+1);
				}
				
				if (!fileExtension.equals("txt")) { //When the file is not in .txt extension, let's go back to the main menu.
					System.out.println("Unsupported file extension. Currently only .txt files are supported. Please check your file is in .txt extension and try again. \n");
					filereader.close();
					return;
				}
				
				//Input file path and extension seems to be correct, so let's turn the text in morse code.
			    BufferedReader bufferedreader = new BufferedReader(filereader);
				String englishString = bufferedreader.readLine().toLowerCase();
				char[] myChars = englishString.toCharArray();
				bufferedreader.close();
			    String morseString = "";
			    //The translating operation itself. Works, but not properly. Doesn't recognize for example spaces. Also, doesn't react inputs, which don't match to English alphabet at all.
			    for (int i = 0; i < myChars.length; i++) {
			        for (int j = 0; j < englishAlphabet.length; j++){
			        	if (englishAlphabet[j] == myChars[i]){
			                morseString = morseString + morseAlphabet[j] + " ";  
			            }
			        	
			        }
			    }
			    System.out.println("");
			    System.out.println("Translation to morse code completed.\n");
				System.out.println("Do you want to save the file? Choose Y if yes or N for no and press ENTER:");
				// Do-while -loop for offering the saving opinion. The user also needs only input the file name. 
				// The program will automatically save the file in .txt extension.
				// Unfortunately, no possibility to choose saving location. Saves somewhere (In my case, it is the same folder, where this project Eclipse workspace is).
				do {
				
				userInput = englishtomorsefilescanner.nextLine();
				if (userInput.equals("y") || userInput.equals ("Y")) {
					System.out.println("The output file will be saved in .txt extension.");
					System.out.println("Give name to the output file:\n");
					morseCodeOutputFile = englishtomorsefilescanner.nextLine();
					morseCodeOutputFile = morseCodeOutputFile + ".txt";
				    BufferedWriter writer = new BufferedWriter(new FileWriter(morseCodeOutputFile));
				    writer.write(morseString);
				    writer.close();
					System.out.println("File is saved. Going back to the main menu...\n");
					return;
				}
				
				else if (userInput.equals("n") || userInput.equals ("N")) {
					System.out.println("Nothing is saved. Going back to the main menu...\n");
					return;
				}
				
				else {
					System.out.println("Invalid choice. Choose Y if yes or N for no.\n");
				}
				
				} while (!userInput.equals("y") || !userInput.equals ("Y") || !userInput.equals("n") || !userInput.equals ("N"));
				
				//This prevents the program from crashing, if the user has input wrong file path.
			} catch (FileNotFoundException e) {
				System.out.println("File not found. Check your path and try again.\n");
				
			}
			
		}
	}
	
	//This method translates English string to Morse code. Steps are pretty much same than in the previous method.
	public void morseCodeToText() throws IOException {
		System.out.println("Navigate the morse code file you want translate to morse code or choose 0 to return main menu.\nConfirm your choice pressing ENTER.\nIMPORTANT! The input file must be in .txt extension.\n");
	    System.out.println("Navigate here the file you want to translate:");
		
	    String englishOutputFile;
		Scanner morsetoenglishfilescanner = new Scanner(System.in);
		String userInput = morsetoenglishfilescanner.nextLine();
		if(userInput.equals("0")) {
			return;
			}
			
		else {
			try {
				FileReader filereader = new FileReader(userInput);
				
				String fileExtension = "";

				int f = userInput.lastIndexOf('.');
				int p = Math.max(userInput.lastIndexOf('/'), userInput.lastIndexOf('\\'));

				if (f > p) {
				    fileExtension = userInput.substring(f+1);
				}
				
				if (!fileExtension.equals("txt")) {
					System.out.println("Unsupported file extension. Currently only .txt files are supported. Please check your file is in .txt extension and try again. \n");
					filereader.close();
					return;
				}
				
				//Translation doesn't work
			    BufferedReader bufferedreader = new BufferedReader(filereader);
				String morseString = bufferedreader.readLine();
				bufferedreader.close();
			    String englishString = "";
			    for (int i = 0; i < morseString.length(); i++) {
			        for (int j = 0; j < morseAlphabet.length; j++){
			        	/*if (morseAlphabet[j] == morseString.charAt(i)){
			                englishString = englishString + englishAlphabet[j] + " ";
			                englishString.toUpperCase();
			            }*/
			        	
			        }
			    }
			    System.out.println("");
			    System.out.println("Translation to morse code completed.\n");
				System.out.println("Do you want to save the file? Choose Y if yes or N for no and press ENTER:");
				
				do {
				
				userInput = morsetoenglishfilescanner.nextLine();
				if (userInput.equals("y") || userInput.equals ("Y")) {
					System.out.println("The output file will be saved in .txt extension.");
					System.out.println("Give name to the output file:\n");
					englishOutputFile = morsetoenglishfilescanner.nextLine();
					englishOutputFile = englishOutputFile + ".txt";
				    BufferedWriter writer = new BufferedWriter(new FileWriter(englishOutputFile));
				    writer.write(englishString);
				    writer.close();
					System.out.println("File is saved. Going back to the main menu...\n");
					return;
				}
				
				else if (userInput.equals("n") || userInput.equals ("N")) {
					System.out.println("Nothing is saved. Going back to the main menu...\n");
					return;
				}
				
				else {
					System.out.println("Invalid choice. Choose Y if yes or N for no.\n");
				}
				
				} while (!userInput.equals("y") || !userInput.equals ("Y") || !userInput.equals("n") || !userInput.equals ("N"));
				
			} catch (FileNotFoundException e) {
				System.out.println("File not found. Check your path and try again.\n");
				
			}
			
		}
	}
	
}

