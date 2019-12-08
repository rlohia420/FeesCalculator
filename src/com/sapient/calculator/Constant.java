package com.sapient.calculator;

public class Constant {

	    public enum TRANSACTION_FEE {
	        FIVE_HUNDRED(500), HUNDRED(100), FIFTY(50), TEN(10);
	        private double fees;

	        TRANSACTION_FEE(double fees) {
	            this.fees = fees;
	        }

	        public double getFees() {
	            return fees;
	        }
	    }
	    public enum TRANSACTION_TYPE {
	        BUY("BUY", 1), SELL("SELL", 2), DEPOSIT("DEPOSIT", 3), WITHDRAW("WITHDRAW", 4);
	        private int type;
	        private String name;

	        TRANSACTION_TYPE(String name, int type) {
	            this.name = name;
	            this.type = type;
	        }

	        public int getType() {
	            return type;
	        }

	        public String getName() {
	            return name;
	        }
	    }
}
