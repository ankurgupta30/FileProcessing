package com.imesomeone.file;

import java.io.IOException;

public interface DataFileReader {//TODO: check new changes regarding interface

	InputLine readNext() throws IOException, Exception;

//	boolean hasMoreRows();
}
