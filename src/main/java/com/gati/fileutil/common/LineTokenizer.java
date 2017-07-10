/**
 * 
 */
package com.gati.fileutil.common;

/**
 * @author sahug
 *
 */
public interface LineTokenizer<T> {
 
	T tokenize(String line);
}
