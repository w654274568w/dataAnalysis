package cn.dataAnalysis.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类
 * 
 * @author 
 */
public class DateUtils {

	private static Logger log = LoggerFactory.getLogger(DateUtils.class);

	public static String DEFAULT_FORMAT = "yyyy-MM-dd";
	public static String DEFAULT_FORMAT_INFO = "yyyy年MM月dd日";
    /**
     * yyyyMMdd
     */
    public static String FORMAT1 = "yyyyMMdd";
    
	private static String timePattern = "HH:mm";

	public static String timePattern2 = "yyyyMMddHHmmss";

	public static String dateTimePattern = "yyyy-MM-dd HH:mm:ss";

	public static String fyTimePattern = "yyyyMMdd"; // 富友交易日期
	
	

	/**
	 * 根据日期格式，返回日期按DEFAULT_FORMAT格式转换后的字符串
	 * 
	 * @param aDate
	 *            日期对象
	 * @return 格式化后的日期的页面显示字符串
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(DEFAULT_FORMAT);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	public static final String parseToDateTimeStr(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(dateTimePattern);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}
	/**
	 * 
	 * @param date
	 * @return yyyyMMddHHmmss
	 */
	public static final String dateToStr(Date date)
	{
		SimpleDateFormat df = null;
		String returnValue = "";
		
		if (date != null)
		{
			df = new SimpleDateFormat(timePattern2);
			returnValue = df.format(date);
		}
		
		return (returnValue);
	}
	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long time1 = cal.getTimeInMillis(); // smdate
			cal.setTime(bdate);
			long time2 = cal.getTimeInMillis(); // bdate
			long between_days = (time2 - time1) / (1000 * 3600 * 24);

			return Integer.parseInt(String.valueOf(between_days));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	

	/**
	 * 计算两个日期之间相差的月数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差月数
	 * @throws ParseException
	 */
	public static int getMonthSpace(Date smdate, Date bdate)
			throws ParseException {

		int result = 0;

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(smdate);
		c2.setTime(bdate);

		result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

		return result == 0 ? 1 : Math.abs(result);

	}

	public static int getMonth(Date smdate, Date bdate) throws ParseException {

		int result = 0;

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(smdate);
		c2.setTime(bdate);

		result = c2.get(Calendar.DAY_OF_MONTH) - c1.get(Calendar.DAY_OF_MONTH);

		return result == 0 ? 1 : Math.abs(result);

	}

	/**
	 * 按照日期格式，将字符串解析为日期对象
	 * 
	 * @param aMask
	 *            输入字符串的格式
	 * @param strDate
	 *            一个按aMask格式排列的日期的字符串描述
	 * @return Date 对象
	 * @see SimpleDateFormat
	 * @throws ParseException
	 */
	public static final Date convertStringToDate(String aMask, String strDate)
			throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		if (log.isDebugEnabled()) {
			log.debug("converting '" + strDate + "' to date with mask '"
					+ aMask + "'");
		}

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			// log.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method returns the current date time in the format: yyyy/MM/dd HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * This method returns the current date in the format: yyyy-MM-dd
	 * 
	 * @return the current date
	 * @throws ParseException
	 */
	public static Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(DEFAULT_FORMAT);

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));

		return cal;
	}
	public static Calendar parseDate8(String dStr) {
		try {
			SimpleDateFormat sdf= new SimpleDateFormat(FORMAT1);
			Date date =sdf.parse(dStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			return cal;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see SimpleDateFormat
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			log.error("aDate is null!");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * 根据日期格式，返回日期按DEFAULT_FORMAT格式转换后的字符串
	 * 
	 * @param aDate
	 * @return
	 */
	public static final String convertDateToString(Date aDate) {
		return getDateTime(DEFAULT_FORMAT, aDate);
	}

	/**
	 * 按照日期格式，将字符串解析为日期对象
	 * 
	 * @param strDate
	 *            (格式 yyyy-MM-dd)
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String strDate)
			throws ParseException {
		Date aDate = null;

		try {
			if (log.isDebugEnabled()) {
				log.debug("converting date with pattern: " + DEFAULT_FORMAT);
			}

			aDate = convertStringToDate(DEFAULT_FORMAT, strDate);
		} catch (ParseException pe) {
			log.error("Could not convert '" + strDate
					+ "' to a date, throwing exception");
			pe.printStackTrace();
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());

		}

		return aDate;
	}

	/**
	 * 时间相加
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDay(Date date, int day) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}

	public static Date addHour(Date date, int hour) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, hour);
		return calendar.getTime();
	}

	/**
	 * 月相加
	 * 
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date addMonth(Date date, int month) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}

	public static int getDay(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 *            日期对象
	 * @return String 日期字符串
	 */

	/**
	 * 本年的第一天
	 */
	public static String getYearFirst(Integer year) {
		return formatDate(getCurrYearFirst(year));
	}

	/**
	 * 本年的最后一天
	 * 
	 * @author cjx 2013-2-25 DateUtil String
	 * @param year
	 * @return
	 * 
	 *         getYearLast
	 */
	public static String getYearLast(Integer year) {
		return formatDate(getCurrYearLast(year));
	}

	public static Integer getYear() {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy");
		String year = f.format(date);
		return Integer.valueOf(year);

	}

	/**
	 * 
	 * return yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
		String sDate = f.format(date);
		return sDate;
	}

	public static String formatDate(String formatPattern, Date date) {
		SimpleDateFormat f = new SimpleDateFormat(formatPattern);
		String sDate = f.format(date);
		return sDate;
	}
	
	
	/**
	 * 
	 * return yyyy年MM月dd日
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateForDateInfo(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT_INFO);
		String sDate = f.format(date);
		return sDate;
	}
	

	/**
	 * 获取某年第一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static Date getCurrYearFirst(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	public static Date preciseToDay(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取某年最后一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static Date getCurrYearLast(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();

		return currYearLast;
	}
	
	/**
	 * 格式化时间为时间
	 * @param pattern 格式
	 * @param date 时间
	 * @return
	 */
	public static Date formatDateToDate(String pattern, Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date afterFormatDate = null;
		try {
			afterFormatDate = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return afterFormatDate;
	}

    /**
     * 
     * @param date
     * @return yyyyMMdd
     */
    public static String formatDate8(Date date){  
    	return formatDate(FORMAT1,date);
    }

	/**
	 *
	 * return yyyyMMdd
	 *
	 * @param date
	 * @return
	 */
	public static String fyFormatDate(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(fyTimePattern);
		String sDate = f.format(date);
		return sDate;
	}
}
