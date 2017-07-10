package com.gati.fileutil.filereader;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFlatFileReader {

	@Test
	public void should_read_csv_file() {
		Resource resource=new FileResource("testCSV");
		FileReader fileReader=new FlatFileReader();
		
		
	}

}
