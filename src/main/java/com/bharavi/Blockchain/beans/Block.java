package com.bharavi.Blockchain.beans;

import java.util.List;
import java.util.ArrayList;

public class Block {
	public Block() {
		this.transactions = new ArrayList<Transaction>();
	}
	List<Transaction> transactions;
	String hashPointer;
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public String getHashPointer() {
		return hashPointer;
	}
	public void setHashPointer(String hashPointer) {
		this.hashPointer = hashPointer;
	}
	@Override
	public String toString() {
		return "Block [transactions=" + transactions + ", hashPointer=" + hashPointer + "]";
	}

}
