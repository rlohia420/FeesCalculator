package com.sapient.calculator;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sapient.calculator.Constant.TRANSACTION_TYPE;

public class Utils {
	 public static Double parseMarketValue(String marketValue) {
	        try {
	            return Double.parseDouble(marketValue);
	        } catch (Exception ignored) {
	            return (double) 0;
	        }
	    }

	    public static Boolean getPriority(String priority) {
	        if (priority != null) {
	            priority = priority.trim();
	            return priority.equals("Y") || priority.equals("y");
	        } else {
	            return false;
	        }
	    }

	    public static Date parseDate(String date) {
	        try {
	            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	            Date convertedCurrentDate = sdf.parse(date);
	            System.out.println(convertedCurrentDate);
	            return convertedCurrentDate;
	        } catch (Exception ignored) {
	            return null;
	        }
	    }

	    public static Integer parseTransactionType(String type) {
	        switch (type) {
	            case "BUY":
	                return TRANSACTION_TYPE.BUY.getType();
	            case "SELL":
	                return TRANSACTION_TYPE.SELL.getType();
	            case "DEPOSIT":
	                return TRANSACTION_TYPE.DEPOSIT.getType();
	            case "WITHDRAW":
	                return TRANSACTION_TYPE.WITHDRAW.getType();
	        }
	        return null;
	    }

	    public static String getTypeName(Integer transactionType) {
	        if (transactionType == TRANSACTION_TYPE.BUY.getType()) {
	            return TRANSACTION_TYPE.BUY.getName() + "\t";
	        } else if (transactionType == TRANSACTION_TYPE.SELL.getType()) {
	            return TRANSACTION_TYPE.SELL.getName() + "\t";
	        } else if (transactionType == TRANSACTION_TYPE.DEPOSIT.getType()) {
	            return TRANSACTION_TYPE.DEPOSIT.getName();
	        } else if (transactionType == TRANSACTION_TYPE.WITHDRAW.getType()) {
	            return TRANSACTION_TYPE.WITHDRAW.getName();
	        }
	        return null;
	    }

	    public static Transaction getTransaction(String[] transactionAttributes) {
	        Transaction transaction = new Transaction();
	        transaction.setExternalTransactionID(transactionAttributes[0]);
	        transaction.setClientId(transactionAttributes[1]);
	        transaction.setSecurityId(transactionAttributes[2]);
	        transaction.setTransactionType(Utils.parseTransactionType(transactionAttributes[3]));
	        transaction.setTransactionDate(Utils.parseDate(transactionAttributes[4]));
	        transaction.setMarketValue(Utils.parseMarketValue(transactionAttributes[5]));
	        transaction.setPriority(Utils.getPriority(transactionAttributes[6]));
	        return transaction;
	    }
}
