package com.bharavi.Blockchain.beans;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.FactoryBean;

public class BlockChain implements FactoryBean<BlockChain> {
	
	public BlockChain getObject() throws Exception {
        return new BlockChain();
    }

    public Class<?> getObjectType() {
        return BlockChain.class;
    }

    public boolean isSingleton() {
        return true;
    }
    
	List<Block> blocks;
	public BlockChain() {
		this.blocks = new LinkedList<Block>();
	}
	public List<Block> getBlocks() {
		return blocks;
	}
	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}
}
