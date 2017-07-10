package com.gati.fileutil.processor;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gati.fileutil.common.DefaultTokenizer;

public class TestLineMapper {
	
	DefaultTokenizer tokenizer = new DefaultTokenizer();
	DefaultMapper mapper=new DefaultMapper<FieldValue>(tokenizer);

	@Test
	public void testDefaultMapperImpl() {
		
	}

}
