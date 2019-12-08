package com.sapient.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextReader implements TransactionReader {

	@Override
	public List<Transaction> read(String path) {
		List<Transaction> list = new ArrayList<>();
		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
			while ((line = br.readLine()) != null) {
				String[] transactionAttributes = line.split(cvsSplitBy);
				Transaction transaction = Utils.getTransaction(transactionAttributes);
				list.add(transaction);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Transaction t : list) {
			System.out.println(t.toString());
		}
		return list;
	}

}
