/**
 * 
 */
package com.gati.fileutil.filereader;

/**
 * @author gati.sahu@gmail.com
 *
 */
public class FileRederBuilder {
	private Resource sourceResource;

	public FileRederBuilder() {
	}

	public FileRederBuilder withResourceType(ResourceType resourceType, String path) {
		sourceResource = resourceType.getResource(path);
		return this;
	}

}
