package com.gati.fileutil.common;

import java.util.ArrayList;
import java.util.List;

public class DefaultTokenizer implements LineTokenizer<List<String>> {

	public static final String DELIMITER_COMMA = ",";

	public static final String DELIMITER_TAB = "\t";

	private String delimiter;

	public DefaultTokenizer() {
		this(DELIMITER_COMMA);
	}

	public DefaultTokenizer(String delimiter) {
		this.delimiter = delimiter;
	}

	@Override
	public List<String> tokenize(String line) {
		List<String> tokenList = new ArrayList<String>();
		char[] charArray = line.toCharArray();
		int startPosition = 0;
		int endPosition = 0;
		for (int i = 0; i < charArray.length; i++) {
			boolean isEnd = isEnd(charArray, i);
			boolean isDlimiterChar = isDelimiterChar(charArray, i);
			if (isDlimiterChar) {
				endPosition = i - startPosition;
				String value = getTokenValue(charArray, startPosition, endPosition);
				tokenList.add(value);
			}
			if (isEnd && !isDlimiterChar) {
				endPosition = i - startPosition + 1;
				String value = getTokenValue(charArray, startPosition, endPosition);
				tokenList.add(value);
			}

			if (isDlimiterChar && !isEnd) {
				startPosition = i + 1;
			}
		}
		return tokenList;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	private boolean isDelimiterChar(char[] charArray, int i) {
		if (getDelimiter().equals(String.valueOf(charArray[i]))) {
			return true;
		}
		return false;
	}

	private boolean isEnd(char[] charArray, int i) {
		if (i == charArray.length - 1) {
			return true;
		}
		return false;
	}

	private String getTokenValue(char[] charArray, int startPosition, int endPosition) {
		String value = new String(charArray, startPosition, endPosition);
		value = removeSpace(value);
		return value;
	}

	private String removeSpace(String value) {
		if (value != null) {
			return value.trim();
		}
		return value;
	}
}
