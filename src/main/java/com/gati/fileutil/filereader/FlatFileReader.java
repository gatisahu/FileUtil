/**
 * 
 */
package com.gati.fileutil.filereader;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gati.fileutil.common.LineMapper;

/**
 * @author gati.sahu@gmail.com
 *
 */
public class FlatFileReader<T> implements FileReader<T> {
	
	private static final Log logger = LogFactory.getLog(FlatFileReader.class);
	
	private Resource resource;
	
	private Reader reader;
	
	private LineMapper<T> lineMapper;

	@Override
	public void open() {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public T readNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<String[]> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

}
