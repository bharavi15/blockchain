package com.bharavi.Blockchain.beans;

import java.util.UUID;

import com.bharavi.Blockchain.utils.Utils;

public class Transaction {
	
	String txnId;
	long timestamp;
	String debitAccount;
	String creditAccount;
	String digitalSignature;
	double amount;
	String txnHash;
	
	public Transaction() {
		txnId = UUID.randomUUID().toString();
		timestamp = System.currentTimeMillis();
	}
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

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
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

	public String getTxnHash() {
		return txnHash;
	}
	public void setTxnHash() {
		this.txnHash = Utils.getSha256(txnId+timestamp+debitAccount+creditAccount+amount);
	}
	@Override
	public String toString() {
		return "Transaction [txnId=" + txnId + ", timestamp=" + timestamp + ", debitAccount=" + debitAccount
				+ ", creditAccount=" + creditAccount + ", digitalSignature=" + digitalSignature + ", amount=" + amount
				+ ", txnHash=" + txnHash
				+ "]";
	}
	


}
