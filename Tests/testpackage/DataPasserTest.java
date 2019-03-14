package testpackage;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mainpackage.DataPasser;

class DataPasserTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testDataPasser() throws FileNotFoundException {
		DataPasser testDataPasser = new DataPasser();
		String testInputFilePath = "SomeFilePath";
		
		assertNull(testDataPasser.getInputfilepath());
		assertNull(testDataPasser.getFilereader());
		assertNull(testDataPasser.getTranslatedString());
		assertNull(testDataPasser.getOutputfilename());
		
		testDataPasser.setInputfilepath(testInputFilePath);
		testDataPasser.setTranslatedString("TranslatedString");
		assertNotNull(testDataPasser.getInputfilepath());
		assertNotNull(testDataPasser.getTranslatedString());
	}

}
