/**
 * 
 */
package com.gati.fileutil.processor;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * @author gati.sahu@gmail.com
 *
 */
public class Property {

	private static final String[] TRUE_VALUES = { "true", "t", "yes", "y", "on" };
	private static final String[] FALSE_VALUES = { "false", "f", "no", "n", "off" };
	private final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

	private DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);

	private NumberFormat numberFormat =NumberFormat.getInstance();

	private String propertyName;

	private String propertyValue;

	public Property(String propertyName, String propertyValue) {
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
	}

	private abstract class Value<T> {
		private T value;
		private IllegalArgumentException exception;
		boolean isProcessed;

		public T getValue() {
			if (!isProcessed) {
				try {
					value = propertyValue == null ? null : parse(propertyValue);
				} catch (Exception e) {
					value = null;
					exception = new IllegalArgumentException(e);
				} finally {
					isProcessed = true;
				}
			}
			if (exception == null)
				return value;
			else
				throw exception;

		}

		public T getValue(T defaultValue) {
			try {
				T result = getValue();
				return (result == null) ? defaultValue : result;
			} catch (IllegalArgumentException e) {
				return defaultValue;
			}
		}

		protected abstract T parse(String value) throws Exception;
	}

	private Value<Boolean> booleanValue = new Value<Boolean>() {
        protected Boolean parse(String value) throws IllegalArgumentException {
            for (int i = 0; i < TRUE_VALUES.length; i++){
                if (value.equalsIgnoreCase(TRUE_VALUES[i])) {
                    return Boolean.TRUE;
                }
            }
            for (int i = 0; i < FALSE_VALUES.length; i++){
                if (value.equalsIgnoreCase(FALSE_VALUES[i])) {
                    return Boolean.FALSE;
                }
            }
            throw new IllegalArgumentException();
        }
    };

    private Value<String> cachedStringValue = new Value<String>() {
        protected String parse(String value) {
            return value;
        }
    };

    private Value<Integer> integerValue = new Value<Integer>() {
        protected Integer parse(String value) throws NumberFormatException {
           if(numberFormat==null){
        	   return Integer.valueOf(value);
           }else{
        	   parseNumber(value,numberFormat);
           }
		return null;
        }
    };

    private Value<Long> longValue = new Value<Long>() {
        protected Long parse(String value) throws NumberFormatException {
            return Long.valueOf(value);
        }
    };

    private Value<Float> floatValue = new Value<Float>() {
        protected Float parse(String value) throws NumberFormatException {
            return Float.valueOf(value);
        }
    };

    private Value<Double> doubleValue = new Value<Double>() {
        protected Double parse(String value) throws NumberFormatException {
            return Double.valueOf(value);
        }
    };
    private Number parseNumber(String value, NumberFormat numberFormat) {
		try {
			return numberFormat.parse(value);
		} catch (ParseException e) {
			throw new NumberFormatException("Unparseable number: " + value);
		}
		
		
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
