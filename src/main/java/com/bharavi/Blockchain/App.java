package com.bharavi.Blockchain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.AbstractDocument.BranchElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bharavi.Blockchain.beans.Block;
import com.bharavi.Blockchain.beans.Transaction;

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
    	do {
		System.out.println();
		Transaction t = new Transaction();
		System.out.print("Enter debit account:");
		t.setDebitAccount(br.readLine());
		System.out.print("Enter credit account:");
		t.setCreditAccount(br.readLine());
		System.out.print("Enter amount:");
		t.setAmount(Double.parseDouble(br.readLine()));
		block.getTransactions().add(t);
		if(block.getTransactions().size()>=2) {			
			blocks.add(block);
			block = new Block();
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
