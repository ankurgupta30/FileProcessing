package com.imesomeone.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputFile {

	private String filePath;
	List<OutputLine> outputLines;
	Map<String, List<Double>> inputData;

	public OutputFile(String filePath) {
		this.filePath = filePath;
	}

	public void addLine(InputLine inputLine) throws Exception {
		
		if (inputData == null) {
			inputData = new HashMap<String, List<Double>>();
		} 
		
		System.out.println("\n\t>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Adding Data : " + inputLine.toString());
		Double amountInUSD = inputLine.getAmountInUSD();
		String key = inputLine.getCityGenderKey();
		if (inputData.containsKey(inputLine.getCityGenderKey())) {
			List<Double> averageAmountList = inputData.get(key);
			averageAmountList.add(amountInUSD);
		} else {
			List<Double> averageAmountList = new ArrayList<Double>();
			averageAmountList.add(amountInUSD);
			inputData.put(inputLine.getCityGenderKey(), averageAmountList);
		}
		System.out.println("inputData " + inputData);
		System.out.println("*******************************************\\n\\t");
		

	}

	public void generateOutput() throws IOException {
	
		// Deserialize list of files.
		if (inputData == null || inputData.isEmpty()) {
			System.out.println("No data to write to the file");
		} else {
			//printData();
			System.out.println("Generating output............");
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
			for (Entry<String, List<Double>> line : inputData.entrySet()) {
				writeToFile(line, bufferedWriter);
			}
			bufferedWriter.flush();
			bufferedWriter.close();
			System.out.println("Processing completed successfully");
			System.out.println("Generated File location " + filePath);
		}
	}

	private void printData() {
		System.out.println("Printing collated data------------------------------------");
		for (Entry<String, List<Double>> line : inputData.entrySet()) {
			System.out.println("line : " + line);
		}
		System.out.println("-----------------------------------------------------------");
	}

	private void writeToFile(Entry<String, List<Double>> entry, BufferedWriter bufferedWriter) throws IOException {
		OutputLine line = new OutputLine(entry);
		bufferedWriter.write(line.toString());
		bufferedWriter.newLine();
	}

	/*
	 * public void generateOutput() throws IOException { // Deserialize list of
	 * files. if (outputLines == null || outputLines.isEmpty()) {
	 * System.out.println("No data to write to the file"); } else { BufferedWriter
	 * bufferedWriter = new BufferedWriter(new FileWriter(filePath)); for
	 * (OutputLine line : outputLines) { bufferedWriter.write(line.toString());
	 * bufferedWriter.newLine();
	 * 
	 * } bufferedWriter.flush(); bufferedWriter.close(); } }
	 */
}
