/**
 * 
 */
package com.gati.fileutil.filereader;

/**
 * @author sahug
 *
 */
public interface FileReader<T> extends Reader<T> {

	public void open();

	public void close();

}
