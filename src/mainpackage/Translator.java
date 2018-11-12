package mainpackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

//This class does actual translation work

public class Translator {
	
	DataPasser datapasser = new DataPasser(); //Let's make DataPasser object to pass data between methods
	
	//Hashmap, where both cleartext characters and their morse code equivalents are present and divided in pairs.
    HashMap<Character, String> alphabetHashMap = new HashMap<>(); {
        alphabetHashMap.put('a', ".-");
        alphabetHashMap.put('b', "-...");
        alphabetHashMap.put('c',  "-.-");
        alphabetHashMap.put('d',  "-..");
        alphabetHashMap.put('e',    ".");
        alphabetHashMap.put('f', "..-.");
        alphabetHashMap.put('g',  "--.");
        alphabetHashMap.put('h', "....");
        alphabetHashMap.put('i',   "..");
        alphabetHashMap.put('j', ".---");
        alphabetHashMap.put('k',   "-.");
        alphabetHashMap.put('l', ".-..");
        alphabetHashMap.put('m',   "--");
        alphabetHashMap.put('n',   "-.");
        alphabetHashMap.put('o',  "---");
        alphabetHashMap.put('p', ".--.");
        alphabetHashMap.put('q', "--.-");
        alphabetHashMap.put('r', ".-.");
        alphabetHashMap.put('s',  "...");
        alphabetHashMap.put('t',   "-");
        alphabetHashMap.put('u',  "..-");
        alphabetHashMap.put('v', "...-");
        alphabetHashMap.put('w',  ".--");
        alphabetHashMap.put('x', "-..-");
        alphabetHashMap.put('y', "-.--");
        alphabetHashMap.put('z', "--..");
        alphabetHashMap.put('.', ".-.-.-");
        alphabetHashMap.put(',',  "--..--");
        alphabetHashMap.put('?', "..--..");
        alphabetHashMap.put('/', "-..-.");
        alphabetHashMap.put('@', ".--.-.");
        alphabetHashMap.put('1', ".----");
        alphabetHashMap.put('2', "..---");
        alphabetHashMap.put('3', "...--");
        alphabetHashMap.put('4', "....-");
        alphabetHashMap.put('5', ".....");
        alphabetHashMap.put('6', "-....");
        alphabetHashMap.put('7', "--...");
        alphabetHashMap.put('8', "---..");
        alphabetHashMap.put('9', "----.");
        alphabetHashMap.put('0', "-----");
    }
	
	public Translator() {
		
	}
	
	//This method translates English string to Morse code.
	public void englishToMorseCode() throws IOException {
		resetDataPasser(); //Lets's reset the datapasser to ensure that data handled in possible previous operations are not interfering the current operation.
		System.out.println("Navigate the textfile you want translate to morse code or choose 0 to return main menu.\nConfirm your choice pressing ENTER.\nIMPORTANT! The input file must be in .txt extension.\n");
	    System.out.println("Navigate here the file you want to translate:");
		
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		if(userInput.equals("0")) { //Return to main menu
			System.out.println("Going back to the main menu...\n");
			return;	
		}	
		else {
			datapasser.setInputfilepath(userInput);
			openFile(datapasser);
			if (datapasser.getFilereader() == null) {
				return;
			}
			else {
				//Input file path and extension seems to be correct, so let's turn the text in morse code.
			    BufferedReader bufferedreader = new BufferedReader(datapasser.getFilereader());
				String englishString = bufferedreader.readLine().toLowerCase(); //Because our keys are lowercase in the HashMap, we also need lowercase the String from the file.
				bufferedreader.close();
			    String morseString = "";
			    //The translating operation itself. Works, but not properly. Doesn't recognize for example spaces. Also, doesn't react inputs, which don't match to English alphabet at all.
			    for (int i = 0; i < englishString.length(); i++) {
			    	String character = alphabetHashMap.get(englishString.charAt(i));
			    	if (character!= null) {
			    		morseString = morseString + character + " ";
			    	}
			    	else {
			    		morseString = morseString + " ";
			    	}
			    }
			    System.out.println(morseString);
			    datapasser.setTraslatedString(morseString);
			    System.out.println("");
			    System.out.println("File contents are now translated to morse code.\n");
				System.out.println("Do you want to save the file? Choose Y if yes or N for no and press ENTER:");
				// Do-while -loop for offering the saving opinion. The user also needs only input the file name. 
				// The program will automatically save the file in .txt extension.
				// Unfortunately, no possibility to choose saving location. Saves somewhere (In my case, it is the same folder, where this project Eclipse workspace is).
				}
			doSavingChoice();
		}
	}
	
	//This method translates Morse code string to English. Many steps are pretty much same than in the previous method.
	public void morseCodeToEnglish() throws IOException {
		resetDataPasser(); //Lets's reset the datapasser to ensure that data handled in possible previous operations are not interfering the current operation.
		
		//We have the HashMap already, but let's reverse it for this operation. Keys and values are swapped inside pairs.
		HashMap<String, Character> reversedAlphabetHashMap = new HashMap<>();
		for(HashMap.Entry<Character, String> entry : alphabetHashMap.entrySet()){
			reversedAlphabetHashMap.put(entry.getValue(), entry.getKey());
		}
		
		System.out.println("Navigate the textfile you want translate to English or choose 0 to return main menu.\nConfirm your choice pressing ENTER.\nIMPORTANT! The input file must be in .txt extension.\n");
	    System.out.println("Navigate here the file you want to translate:");
		
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		if(userInput.equals("0")) { //Return to main menu
			System.out.println("Going back to the main menu...\n");
			return;	
		}	
		else {
			datapasser.setInputfilepath(userInput);
			openFile(datapasser);
			if (datapasser.getFilereader() == null) {
				return;
			}
			else {
				//Input file path and extension seems to be correct, so let's turn the text in English.
			    BufferedReader bufferedreader = new BufferedReader(datapasser.getFilereader());
				String mmorseString = bufferedreader.readLine();
				bufferedreader.close();
			    String eenglishString = "";
			  /*Because morse characters are tricky, it's better to spilt the morse string from the file at first, 
			    place morse characters in array and then compare them to the HashMap keys one by one.*/
			    String [] morseCharacters = mmorseString.split(" ");
			    for (int i = 0; i < morseCharacters.length; i++) {
			    	char englishLetter = reversedAlphabetHashMap.get(morseCharacters[i]);
			    	eenglishString = eenglishString + englishLetter;
			    }
			    eenglishString = eenglishString.toUpperCase(); //This turns the translated string to uppercase.
			    System.out.println(eenglishString);
			    datapasser.setTraslatedString(eenglishString);
			    System.out.println("");
			    System.out.println("File contents are now translated to English.\n");
				System.out.println("Do you want to save the file? Choose Y if yes or N for no and press ENTER:");
				// Do-while -loop for offering the saving opinion. The user also needs only input the file name. 
				// The program will automatically save the file in .txt extension.
				// Unfortunately, no possibility to choose saving location. Saves somewhere (In my case, it is the same folder, where this project Eclipse workspace is).
				}
			doSavingChoice();
		}
	}
	
	//This handles file opening process. Checks that file is existing and file is in supported extension.
	public DataPasser openFile(DataPasser mDataPasser) throws IOException {
		try {
			FileReader filereader = new FileReader(mDataPasser.getInputfilepath());
			
			String fileExtension = "";

			int f = mDataPasser.getInputfilepath().lastIndexOf('.');
			int p = Math.max(mDataPasser.getInputfilepath().lastIndexOf('/'), mDataPasser.getInputfilepath().lastIndexOf('\\'));

			if (f > p) {
			    fileExtension = mDataPasser.getInputfilepath().substring(f+1);
			    }
			
			if (!fileExtension.equals("txt")) { //When the file is not in .txt extension, let's go back to the main menu.
				System.out.println("Unsupported file extension. Currently only .txt files are supported. Please check your file is in .txt extension and try again. \n");
				filereader.close();
				}
			else {
				mDataPasser.setFilereader(filereader);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Check your path and try again.\n"); 
			
		}
		
		return mDataPasser;
	}
	
	//File writing and saving
	public void writeAndSaveFile(DataPasser mDataPasser) throws IOException {
		System.out.println("The output file will be saved in .txt extension.");
		System.out.println("IMPORTANT! If you give a name of the existing file, the file will be overwritten.");
		System.out.println("Give name to the output file:");
		Scanner scanner = new Scanner(System.in);
		String morseCodeOutputFile = scanner.nextLine();
		morseCodeOutputFile = morseCodeOutputFile + ".txt";
	    BufferedWriter writer = new BufferedWriter(new FileWriter(morseCodeOutputFile));
	    writer.write(mDataPasser.getTraslatedString());
	    writer.close();
		System.out.println("The file is saved. Going back to the main menu...\n");
	}
	
	//Saving choices shown to the user
	public void doSavingChoice() throws IOException {
		String userInput;
		do {
			Scanner scanner = new Scanner(System.in);
			userInput = scanner.nextLine();
			if (userInput.equals("y") || userInput.equals ("Y")) {
				writeAndSaveFile(datapasser);
				return;
			}
			else if (userInput.equals("n") || userInput.equals ("N")) {
				System.out.println("Nothing is saved. Going back to the main menu...\n");
				return;
			}
			else {
				System.out.println("Invalid choice. Choose Y if you want to save file or N if you don't want to save.\nPlease type your choice (Y/N) again and press ENTER");
			}
			
		} while (!userInput.equals("y") || !userInput.equals ("Y") || !userInput.equals("n") || !userInput.equals ("N"));
	}
	
	//Resets Datapasser object
	public void resetDataPasser() {
		datapasser.setInputfilepath(null);
		datapasser.setFilereader(null);
		datapasser.setTraslatedString(null);
		datapasser.setOutputfilename(null);
	}
}

