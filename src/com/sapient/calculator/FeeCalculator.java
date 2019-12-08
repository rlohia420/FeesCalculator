package com.sapient.calculator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FeeCalculator {
	private List<Transaction> transactionList = new ArrayList<>();

	public void addTransaction(Transaction transaction) {
		transactionList.add(calculateFee(transaction));
	}

	public void addTransaction(List<Transaction> transactions) {
		transactions.forEach(this::addTransaction);
	}

	private Transaction calculateFee(Transaction transaction) {
		if (isIntradayTransaction(transaction)) {
			transaction.setTransactionFees(Constant.TRANSACTION_FEE.TEN.getFees());
		} else {
			if (transaction.getPriority()) {
				transaction.setTransactionFees(Constant.TRANSACTION_FEE.FIVE_HUNDRED.getFees());
			} else {
				if (transaction.getTransactionType() == Constant.TRANSACTION_TYPE.SELL.getType()
						|| transaction.getTransactionType() == Constant.TRANSACTION_TYPE.WITHDRAW.getType()) {
					transaction.setTransactionFees(Constant.TRANSACTION_FEE.HUNDRED.getFees());
				} else if (transaction.getTransactionType() == Constant.TRANSACTION_TYPE.BUY.getType()
						|| transaction.getTransactionType() == Constant.TRANSACTION_TYPE.DEPOSIT.getType()) {
					transaction.setTransactionFees(Constant.TRANSACTION_FEE.FIFTY.getFees());
				}
			}
		}
		return transaction;
	}

	private boolean isIntradayTransaction(Transaction other) {
		boolean isIntraDayTransaction = false;
		if (transactionList.size() > 0) {
			for (Transaction transaction : transactionList) {
				if (transaction.getClientId().equals(other.getClientId())
						&& transaction.getSecurityId().equals(other.getSecurityId())
						&& transaction.getTransactionDate().equals(other.getTransactionDate())) {
					if ((transaction.getTransactionType() == Constant.TRANSACTION_TYPE.BUY.getType()
							&& other.getTransactionType() == Constant.TRANSACTION_TYPE.SELL.getType())
							|| (transaction.getTransactionType() == Constant.TRANSACTION_TYPE.SELL.getType()
									&& other.getTransactionType() == Constant.TRANSACTION_TYPE.BUY.getType())) {
						isIntraDayTransaction = true;
						transaction.setTransactionFees(Constant.TRANSACTION_FEE.TEN.getFees());
						break;
					}
				}
			}
		}
		return isIntraDayTransaction;
	}

	public void displayTransactionReport() {
		transactionList
				.sort(Comparator.comparing(Transaction::getClientId).thenComparing(Transaction::getTransactionType)
						.thenComparing(Transaction::getTransactionDate).thenComparing(Transaction::getPriority));
		System.out.println("Calculated Fees:-");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Client Id | Transaction Type | Transaction Date | Priority | Processing Fee    |");
		for (Transaction transaction : transactionList) {
			System.out.println("--------------------------------------------------------------------------------");
			printTransactionFields(transaction,null);
		}
		System.out.println("--------------------------------------------------------------------------------");
	}

	public void generateReport() {
		try (BufferedWriter writer = Files.newBufferedWriter(
				Paths.get("/home/neha/NehaLohia/projects/lohia/FeesCalculator/src/resources/output.txt"),
				Charset.forName("UTF-8"))) {
			for (Transaction tx : transactionList)
				printTransactionFields(tx,writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void printTransactionFields(Transaction transaction,BufferedWriter writer) {
		if (writer!=null) {
			try {
				writer.write(transaction.getClientId() + "\t| " + Utils.getTypeName(transaction.getTransactionType())
				+ "\t| " + transaction.getTransactionDate() + "\t| "
				+ (transaction.getPriority() ? "HIGH\t" : "NORMAL") + "\t| " + transaction.getTransactionFees()
				+ "\t|");
				writer.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(transaction.getClientId() + "\t| " + Utils.getTypeName(transaction.getTransactionType())
			+ "\t| " + transaction.getTransactionDate() + "\t| "
			+ (transaction.getPriority() ? "HIGH\t" : "NORMAL") + "\t| " + transaction.getTransactionFees()
			+ "\t|");
		}
	}
}
