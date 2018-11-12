package mainpackage;

import java.io.FileReader;

//This class is used to pass data between methods. Stores filepaths, strings etc.

public class DataPasser {
	String inputfilepath;
	FileReader filereader;
	String traslatedString;
	String outputfilename;
	
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

public String getTraslatedString() {
	return traslatedString;
}

public void setTraslatedString(String traslatedString) {
	this.traslatedString = traslatedString;
}

public String getOutputfilename() {
	return outputfilename;
	}

public void setOutputfilename(String outputfilename) {
	this.outputfilename = outputfilename;
	}
}
