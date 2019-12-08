package com.sapient.calculator;
import java.util.List;

public interface TransactionReader {

	public List<Transaction> read(String path) ;
	
}
