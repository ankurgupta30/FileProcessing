package com.imesomeone.file;

public class FileProcessor {
	// private String inputFile =

	public static void main(String[] str) {
		String inputFileName = str[0];
		String outputFileName = str[1];
		System.out.println("Input File Name " + inputFileName);
		System.out.println("Output File Name " + outputFileName);
		try {
			new FileProcessor().startProcessing(inputFileName, outputFileName);
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("Exception occured while processing file " + exception);
		}

	}

	private void startProcessing(String inputFile, String outputFile) throws Exception {
		DataFileReader fileReader = ReaderFactory.getReader(inputFile);
		InputLine inputLine;
		OutputFile processedOutput = new OutputFile(outputFile);
		
		while((inputLine= fileReader.readNext()) != null) {
			System.out.println("Processing line " + inputLine.toString());
			if(inputLine.isValid()) {
				System.out.println("Data is valid..................");
				processedOutput.addLine(inputLine);
			}else {
				System.out.println("Unparsable Row data " + inputLine.toString());
			}
		}
		
		processedOutput.generateOutput();
	}
}
