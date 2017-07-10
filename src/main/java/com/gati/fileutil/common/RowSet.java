/**
 * 
 */
package com.gati.fileutil.common;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author gati.sahu@gmail.com
 *
 */
public interface RowSet {

	public String[] getFieldNames();

	public boolean hasNames();

	public String[] getFieldValues();

	public String getString(int columnIndex);

	public boolean getBoolean(int columnIndex);

	public short getShort(int columnIndex);

	public int getInt(int columnIndex);

	public long getLong(int columnIndex);

	public float getFloat(int columnIndex);

	public double getDouble(int columnIndex);

	public BigDecimal getBigDecimal(int columnIndex, int scale);

	public byte[] getBytes(int columnIndex);

	public Date getDateValue(int columnIndex);

	public String getString(String columnName);

	public boolean getBoolean(String columnName);

	public short getShort(String columnName);

	public int getInt(String columnName);

	public long getLong(String columnName);

	public float getFloat(String columnName);

	public double getDouble(String columnName);

	public BigDecimal getBigDecimal(String columnName, int scale);

	public byte[] getBytes(String columnName);

	public Date getDateValue(String columnName);

}
