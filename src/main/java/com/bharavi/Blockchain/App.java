package com.bharavi.Blockchain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

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
//        ApplicationContext ctx =
//                SpringApplication.run(App.class, args);
    	//TO-DO 
    	//1. find invalid transactions
    	//2. find digital signature
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
//		System.out.print("Enter debit account:");
//		t.setDebitAccount(br.readLine());
//		System.out.print("Enter credit account:");
//		t.setCreditAccount(br.readLine());
//		System.out.print("Enter amount:");
//		t.setAmount(Double.parseDouble(br.readLine()));
		System.out.print("Enter debit account:");
		t.setDebitAccount("asdf");
		System.out.print("Enter credit account:");
		t.setCreditAccount("asdfg");
		System.out.print("Enter amount:");
		t.setAmount(String.valueOf(100));
		block.getTransactions().add(t);
		
		if(block.getTransactions().size()>= Constants.MAX_TXN_PER_BLOCK) {	
			if(!isFirstBlock)
				blocks.add(block);
			isFirstBlock = false;
			String blockHashString = Utils.getSha256(block.toString());
			block = new Block();
			block.setHashPointer(blockHashString);
		}
		
    	System.out.print("Any more transactions?");
    	ch = br.readLine();
		} while (!"".equals(ch));
    	System.out.print("");
        System.out.println( "Hello World!" );
        System.out.println(blocks);
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
}
