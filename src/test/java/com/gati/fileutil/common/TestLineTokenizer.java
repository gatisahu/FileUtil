package com.gati.fileutil.common;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestLineTokenizer {
	DefaultTokenizer tokenizer = new DefaultTokenizer();

	@Test
	public void testLineTokenizerwithcommaDelimeter() {
		String line = "gati,gati1,gati2,gati3";
		List<String> tokenList = tokenizer.tokenize(line);
		assertEquals("gati", tokenList.get(0));
		assertEquals("gati1", tokenList.get(1));
		assertEquals("gati2", tokenList.get(2));
		assertEquals("gati3", tokenList.get(3));
	}
	@Test
	public void testLineTokenizerwithTabDelimeter() {
		String line = "gati| gati1| gati2| gati3";
		tokenizer.setDelimiter("|");
		List<String> tokenList = tokenizer.tokenize(line);
		assertEquals("gati", tokenList.get(0));
		assertEquals("gati1", tokenList.get(1));
		assertEquals("gati2", tokenList.get(2));
		assertEquals("gati3", tokenList.get(3));
	}

}
