/**
 * 
 */
package com.gati.fileutil.processor;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gati.fileutil.common.RowSet;

/**
 * @author gati.sahu@gmail.com
 *
 */
public class FileRowSet implements RowSet {

	private static final String[] TRUE_VALUES = { "true", "t", "yes", "y", "on" };
	private static final String[] FALSE_VALUES = { "false", "f", "no", "n", "off" };
	private final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

	private DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
	private NumberFormat numberFormat = NumberFormat.getInstance();

	private final String[] rowValue;
	private final List<String> columnNames;
	boolean isOpen = false;

	public FileRowSet(String[] rowValue) {
		this.rowValue = rowValue == null ? null : (String[]) rowValue.clone();
		columnNames = null;
		isOpen = true;
	}

	@Override
	public String[] getFieldNames() {
		return null;
	}

	@Override
	public boolean hasNames() {
		return columnNames != null;
	}

	@Override
	public String[] getFieldValues() {
		return rowValue;
	}

	@Override
	public String getString(int columnIndex) {
		return parseString(rowValue[columnIndex]);
	}

	@Override
	public boolean getBoolean(int columnIndex) {
		return parseBoolean(rowValue[columnIndex]);
	}

	@Override
	public short getShort(int columnIndex) {
		return parseShort(rowValue[columnIndex]);
	}

	@Override
	public int getInt(int columnIndex) {
		return parseInt(rowValue[columnIndex]);
	}

	@Override
	public long getLong(int columnIndex) {
		return parseLong(rowValue[columnIndex]);
	}

	@Override
	public float getFloat(int columnIndex) {
		return parseFloat(rowValue[columnIndex]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getDouble(int)
	 */
	@Override
	public double getDouble(int columnIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getBigDecimal(int, int)
	 */
	@Override
	public BigDecimal getBigDecimal(int columnIndex, int scale) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getBytes(int)
	 */
	@Override
	public byte[] getBytes(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getDateValue(int)
	 */
	@Override
	public Date getDateValue(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getString(java.lang.String)
	 */
	@Override
	public String getString(String columnName) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getBoolean(java.lang.String)
	 */
	@Override
	public boolean getBoolean(String columnName) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getShort(java.lang.String)
	 */
	@Override
	public short getShort(String columnName) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getInt(java.lang.String)
	 */
	@Override
	public int getInt(String columnName) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getLong(java.lang.String)
	 */
	@Override
	public long getLong(String columnName) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getFloat(java.lang.String)
	 */
	@Override
	public float getFloat(String columnName) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getDouble(java.lang.String)
	 */
	@Override
	public double getDouble(String columnName) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getBigDecimal(java.lang.String, int)
	 */
	@Override
	public BigDecimal getBigDecimal(String columnName, int scale) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getBytes(java.lang.String)
	 */
	@Override
	public byte[] getBytes(String columnName) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gati.fileutil.common.RowSet#getDateValue(java.lang.String)
	 */
	@Override
	public Date getDateValue(String columnName) {
		// TODO Auto-generated method stub
		return null;
	}

	private String parseString(String value) {
		return value;
	}

	private Boolean parseBoolean(String value) throws IllegalArgumentException {
		for (int i = 0; i < TRUE_VALUES.length; i++) {
			if (value.equalsIgnoreCase(TRUE_VALUES[i])) {
				return Boolean.TRUE;
			}
		}
		for (int i = 0; i < FALSE_VALUES.length; i++) {
			if (value.equalsIgnoreCase(FALSE_VALUES[i])) {
				return Boolean.FALSE;
			}
		}
		throw new IllegalArgumentException();
	}

	private Short parseShort(String value) throws NumberFormatException {
		if (numberFormat == null) {
			return Short.valueOf(value);
		} else {
			parseNumber(value, numberFormat).shortValue();
		}
		return null;
	}

	private Integer parseInt(String value) throws NumberFormatException {
		if (numberFormat == null) {
			return Integer.valueOf(value);
		} else {
			parseNumber(value, numberFormat).intValue();
		}
		return null;
	}

	protected Long parseLong(String value) throws NumberFormatException {
		if (numberFormat == null) {
			return Long.valueOf(value);
		} else {
			parseNumber(value, numberFormat).longValue();
		}
		return null;
	}

	protected Float parseFloat(String value) throws NumberFormatException {
		if (numberFormat == null) {
			return Float.valueOf(value);
		} else {
			parseNumber(value, numberFormat).floatValue();
		}
		return null;
	}

	protected Double parse(String value) throws NumberFormatException {
		if (numberFormat == null) {
			return Double.valueOf(value);
		} else {
			parseNumber(value, numberFormat).doubleValue();
		}
		return null;
	}

	private Number parseNumber(String value, NumberFormat numberFormat) {
		try {
			return numberFormat.parse(value);
		} catch (ParseException e) {
			throw new NumberFormatException("Unparseable number: " + value);
		}
	}
}
