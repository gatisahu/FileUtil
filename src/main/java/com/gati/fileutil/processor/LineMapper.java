/**
 * 
 */
package com.gati.fileutil.processor;

/**
 * @author sahug
 *
 */
public interface LineMapper<T> {
	
	public T map(String line);

}
