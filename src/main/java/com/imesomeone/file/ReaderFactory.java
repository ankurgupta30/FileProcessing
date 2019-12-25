package com.imesomeone.file;

public class ReaderFactory {

	public static DataFileReader getReader(String fileName) throws Exception {
		DataFileReader fileReader = null;
		if (isValid(fileName)) {
			throw new Exception("Please provide valid file name with file extension");
		}
		// String fileExtension = fileName.substring(fileName.indexOf('.'));
		fileReader = findReader(fileName);

		return fileReader;
	}

	protected static DataFileReader findReader(String fileName) throws Exception {
		if ("csv".equalsIgnoreCase(fileName.substring(fileName.indexOf('.') + 1))) {
			return new CSVFileReader(fileName);
		} else {
			throw new Exception("File Type not supported");
		}

	}

	private static boolean isValid(String fileName) {
		return null == fileName || fileName.isEmpty() || fileName.indexOf('.') == -1;
	}
}
