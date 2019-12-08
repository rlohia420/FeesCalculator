package com.sapient.calculator;
import java.io.IOException;
import java.util.List;

public class FeeEngine {
	  public static void main(String[] args) throws IOException {
		  FeeEngine fee = new FeeEngine();
		  fee.doTask();
	    }
	  
	  public boolean doTask() {
		  List<Transaction> transactions  = new FileFactory().getFileType("TEXT").read( "/home/neha/NehaLohia/projects/lohia/FeesCalculator/src/resources/SampleData.txt");
	        FeeCalculator calculator = new FeeCalculator();
	        calculator.addTransaction(transactions);
	        calculator.displayTransactionReport();
	        calculator.generateReport();
	        return true;
	  }
}
