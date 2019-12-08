package com.sapient.calculator;

public class FileFactory {

	public TransactionReader getFileType(String fileType) {
		switch(fileType) {
			case "CSV":
				return new CsvReader();
			case "Text":
				return new TextReader();
			case "XML":
				return new XmlReader();
				default:
					return new TextReader();
		}
	}
}
