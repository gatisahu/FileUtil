/**
 * 
 */
package com.gati.fileutil.filereader;

import java.io.File;

import org.springframework.util.StringUtils;

/**
 * @author gati.sahu@gmail.com
 *
 */
public class FileResource implements Resource {

	private final File file;

	private final String path;

	public FileResource(String path) {
		this.file = new File(path);
		this.path = StringUtils.cleanPath(path);
	}

}
