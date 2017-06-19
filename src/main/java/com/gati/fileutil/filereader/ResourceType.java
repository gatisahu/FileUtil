/**
 * 
 */
package com.gati.fileutil.filereader;

/**
 * @author gati.sahu@gmail.com
 *
 */
public enum ResourceType {
	FILE_SYSTEM_RESOURCE {
		@Override
		public Resource getResource(String path) {
			return new FileResource(path);
		}
	},
	URI_RESOURCE {
		@Override
		public Resource getResource(String path) {
			return null;
		}
	};
	public abstract Resource getResource(String path);

}
