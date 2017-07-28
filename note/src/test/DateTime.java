package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateTime {
	@Test
	public void main() throws ParseException {
		/*
		 * 1.Date类型与String类型相互转换，获得指定格式的日期
		 */
		SimpleDateFormat formatDate = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		String dateToString = formatDate.format(new Date());
		System.out.println(dateToString);

		Date stringToDate = formatDate.parse("2017-08-01 09:09:10");
		System.out.println(stringToDate);

		/*
		 * 2.Date类型与long类型相互转换，获得毫秒数
		 */
		long dateToLong = new Date().getTime();
		System.out.println(dateToLong);

		Date longToDate = new Date(dateToLong);
		System.out.println(longToDate);

		/*
		 * 3.Date类型与Calendar类型相互转换，用Date设置Calendar的值
		 */
		Calendar dateToCalendar = Calendar.getInstance();
		dateToCalendar.setTime(new Date());
		System.out.println(dateToCalendar);

		Date calendarToDate = Calendar.getInstance().getTime();
		System.out.println(calendarToDate);

	}
}
