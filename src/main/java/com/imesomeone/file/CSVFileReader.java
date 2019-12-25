package com.imesomeone.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CSVFileReader implements DataFileReader {

	private String filePath;
	private BufferedReader bufferedReader;

	public CSVFileReader(String filePath) throws FileNotFoundException {
		this.filePath = filePath;
		bufferedReader = new BufferedReader(new FileReader(filePath));
	}

	public InputLine readNext() throws Exception {
		String nextLine = bufferedReader.readLine();
		return (nextLine == null) ? null : InputLine.parse(nextLine);
	}

}
