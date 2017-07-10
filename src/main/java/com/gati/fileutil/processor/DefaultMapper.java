/**
 * 
 */
package com.gati.fileutil.processor;

import java.text.DateFormat;
import java.text.NumberFormat;

import com.gati.fileutil.common.LineTokenizer;

/**
 * @author sahug
 *
 */
public class DefaultMapper<RowSet> implements LineMapper<RowSet> {

	private LineTokenizer tokenizer;

	private DateFormat dateFormat;

	private NumberFormat numberFormat;

	DefaultMapper(LineTokenizer tokenizer) {
		this.setTokenizer(tokenizer);
	}

	@Override
	public RowSet map(String line) {
		return null;
	}

	public LineTokenizer getTokenizer() {
		return tokenizer;
	}

	public void setTokenizer(LineTokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}

	public DateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public NumberFormat getNumberFormat() {
		return numberFormat;
	}

	public void setNumberFormat(NumberFormat numberFormat) {
		this.numberFormat = numberFormat;
	}

}
