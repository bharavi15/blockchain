package com.bharavi.Blockchain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bharavi.Blockchain.beans.Block;
import com.bharavi.Blockchain.beans.Transaction;
import com.bharavi.Blockchain.utils.Constants;
import com.bharavi.Blockchain.utils.Utils;

@SpringBootApplication
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	Map<String, String> hashesMap = new HashMap<String, String>();
    	hashesMap.put("71eaec1d6d54c759596f827e9971241607da8ab43c2ba1ac4cf010c9bd432377",
    			"MIGeMA0GCSqGSIb3DQEBAQUAA4GMADCBiAKBgE0TllvMeok1OXtUSvTrInvPlvw+0q2TTT2z2VhWLSQ3cgTAbzr/kzpjGMKJgOgeuwRuPwrE/b0F4PsU+IM4p39G42C0cClqt+6G5MnEX3SBxMUMK06xKHuZBacwIFizK7ZxGu69GonLB6vtU6HIJacvEysb9M1jK/mMcMCOFj87AgMBAAE=");
    	
    	hashesMap.put("5eb69c79f7e91048bcdf11b3300fc67d48e5410efa06b9e5a8e313cdf1fc6b6d",
    			"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC4HuYRbO25FZ+yPp10oIaO3FHKO1n3vO8vkIcoJ3cIEORVBCz0CPLtFn3XsHT/JeMPM2MMqFYFm+Qg7fXYTGAnh1FWcbiXFjWRJgETJvBSLzp9AI3RqLj+/g077EGX8pFTfo3Ct16j3pgOmpKDZfbHsR76bksH6PM6eS4NobSz8wIDAQAB");
    	
    	hashesMap.put("1bec8e1553f40f6e2bf77ed7e7134162bed1676fe076872a6d0a7e10f987906e",
    			"MIGeMA0GCSqGSIb3DQEBAQUAA4GMADCBiAKBgHgMfjCJKS6+9F/gRJ5xVYsz5chxqNJM2eidC44u4FwTnOZwLqdfCKDVispOcgXk+UdPcRphgZYedHXUsp55tyz182YwKqaoCpuknDR1rMjTdVHesjc031o8iSdhQ7fqxaXjgXX468ZDzd1L5G26YBK5c5r8PDagVhhRJYZfi+hlAgMBAAE=");
    	
    	hashesMap.put("d65a622d475fd515b099744c4e2058f084887b503f1c200dd59e1053a71b4e17",
    			"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCDB/Bc6crgaIsZTp7Tr2Z42V+t6dvmF/qLrH/nsnoo/3EWC95CsOHP90rW3tNUE5otYRoPWlaV0TCEjS6vq/6zGmLqATg7cIMOwFA7Q2m0MhQh4Ev0h0NbUrm+tnkqBT3HLRHEywFEUPvxFujAbwvpE+bKa6iAeHwh4gjjz++oQQIDAQAB");
//        ApplicationContext ctx =
//                SpringApplication.run(App.class, args);
    	//TO-DO 
    	//1. find invalid transactions
    	//2. find digital signature
//    	int i = 0;
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String ch = "";
    	List<Block> blocks = new LinkedList<Block>();
		Block block = new Block();
		blocks.add(block);
		boolean isFirstBlock = true;
		System.out.println("Genesis block created");
		System.out.println(Utils.getSha256("abcd"));
    	do {
		Transaction t = new Transaction();
		System.out.print("Enter debit account:");
		String debitAccount = Utils.getSha256(hashesMap.getOrDefault(Utils.getSha256(br.readLine()), ""));
		t.setDebitAccount(debitAccount);
		System.out.print("Enter credit account:");
		t.setCreditAccount(Utils.getSha256(hashesMap.getOrDefault(Utils.getSha256(br.readLine()), "")));
		System.out.print("Enter amount:");
		double debitAmount = Double.parseDouble(br.readLine());
		List<Block> b = new LinkedList<Block>();
		b.add(block);
		double accountBalance = findAccountBalance(blocks, debitAccount)+ findAccountBalance(block, debitAccount);
		if(accountBalance<debitAmount) {
			System.out.println("Invalid transaction, debit amount more than account balance");
			continue;
		}
		t.setAmount(debitAmount);
		
		t.setTxnHash();
//		System.out.print("Enter debit account:");
//		t.setDebitAccount("asdf");
//		System.out.print("Enter credit account:");
//		t.setCreditAccount("asdfg");
//		System.out.print("Enter amount:");
//		t.setAmount(String.valueOf(100));
		block.getTransactions().add(t);
		
		if(block.getTransactions().size()>= Constants.MAX_TXN_PER_BLOCK) {	
			if(!isFirstBlock)
				blocks.add(block);
			isFirstBlock = false;
			String blockHashString = Utils.getSha256(block.toString());
			block = new Block();
			block.setHashPointer(blockHashString);
		}
//		i++;
    	System.out.print("Any more transactions?");
    	ch = br.readLine();
		} while (!"".equals(ch));
//    	} while (i<8);
    	System.out.println();
        System.out.println(blocks);
        System.out.println("Account balance of 5eb69c79f7e91048bcdf11b3300fc67d48e5410efa06b9e5a8e313cdf1fc6b6d is "+findAccountBalance(blocks, "5eb69c79f7e91048bcdf11b3300fc67d48e5410efa06b9e5a8e313cdf1fc6b6d" ));
//        Block firstBlock = new Block();
//        Transaction first = new Transaction();
//        first.setDebitAccount("Bharavi");
//        first.setCreditAccount("Asit");
//        first.setAmount(100);
//        firstBlock.getTransactions().add(first);
//        Transaction second = new Transaction();
//        second.setDebitAccount("Harini");
//        second.setCreditAccount("Supurna");
//        second.setAmount(200);
//        firstBlock.getTransactions().add(second);
//        System.out.println(firstBlock);
//        Block secondBlock = new Block();
//        first = new Transaction();
//        first.setDebitAccount("Dyutisri");
//        first.setCreditAccount("Rajjat");
//        first.setAmount(100);
//        secondBlock.getTransactions().add(first);
//        second = new Transaction();
//        second.setDebitAccount("Ajay");
//        second.setCreditAccount("Raghav");
//        second.setAmount(200);
//        secondBlock.getTransactions().add(second);
//        System.out.println(secondBlock);
    }
    
    public static double findAccountBalance(List<Block> blocks, String accountNumber) {
    	if("71eaec1d6d54c759596f827e9971241607da8ab43c2ba1ac4cf010c9bd432377".equalsIgnoreCase(accountNumber)) {
    		return Double.MAX_VALUE;
    	}
    	double accountBalance = 0;
		for(Block block : blocks) {
			for(Transaction transaction: block.getTransactions()) {
				if(transaction.getCreditAccount().equalsIgnoreCase(accountNumber))
					accountBalance+=transaction.getAmount();
				if(transaction.getDebitAccount().equalsIgnoreCase(accountNumber))
					accountBalance-=transaction.getAmount();
			}
		}
    	return accountBalance;
    }
    public static double findAccountBalance(Block block, String accountNumber) {
    	if("71eaec1d6d54c759596f827e9971241607da8ab43c2ba1ac4cf010c9bd432377".equalsIgnoreCase(accountNumber)) {
    		return Double.MAX_VALUE;
    	}
    	double accountBalance = 0;
    	for(Transaction transaction: block.getTransactions()) {
    		if(transaction.getCreditAccount().equalsIgnoreCase(accountNumber))
    			accountBalance+=transaction.getAmount();
    		if(transaction.getDebitAccount().equalsIgnoreCase(accountNumber))
    			accountBalance-=transaction.getAmount();
    	}

    	return accountBalance;
    }
}
