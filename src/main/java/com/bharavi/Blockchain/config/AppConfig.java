package com.bharavi.Blockchain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bharavi.Blockchain.beans.BlockChain;


@Configuration
public class AppConfig {

	BlockChain blocks;
	@Bean
	BlockChain getBlockChain(){
		return new BlockChain();
	}
}
