package mainpackage;

import java.io.FileReader;

//This class is used to pass data between methods. Stores filepaths, strings etc.

public class DataPasser {
	private String inputfilepath;
	private FileReader filereader;
	private String translatedString;
	private String outputfilename;
	
public DataPasser() {
	
}

public String getInputfilepath() {
	return inputfilepath;
	}

public void setInputfilepath(String inputfilepath) {
	this.inputfilepath = inputfilepath;
	}

public FileReader getFilereader() {
	return filereader;
	}

public void setFilereader(FileReader filereader) {
	this.filereader = filereader;
	}

public String getTranslatedString() {
	return translatedString;
}

public void setTranslatedString(String traslatedString) {
	this.translatedString = traslatedString;
}

public String getOutputfilename() {
	return outputfilename;
	}

public void setOutputfilename(String outputfilename) {
	this.outputfilename = outputfilename;
	}
}
