package com.bharavi.Blockchain.beans;

public class Transaction {
	String txnId;
	String timestamp;
	String debitAccount;
	String creditAccount;
	String digitalSignature;
	double amount;
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(String debitAccount) {
		this.debitAccount = debitAccount;
	}

	public String getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(String creditAccount) {
		this.creditAccount = creditAccount;
	}

	public String getDigitalSignature() {
		return digitalSignature;
	}

	public void setDigitalSignature(String digitalSignature) {
		this.digitalSignature = digitalSignature;
	}

	@Override
	public String toString() {
		return "Transaction [txnId=" + txnId + ", timestamp=" + timestamp + ", debitAccount=" + debitAccount
				+ ", creditAccount=" + creditAccount + ", digitalSignature=" + digitalSignature + ", amount=" + amount
				+ "]";
	}
	


}
