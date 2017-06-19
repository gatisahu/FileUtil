/**
 * 
 */
package com.gati.fileutil.filereader;

import java.util.Iterator;
import java.util.List;

/**
 * @author gati.sahu@gmail.com
 *
 */
public interface Reader<T> {

	T readNext();

	List<T> readAll();

	Iterator<String[]> iterator();

}
