package cn.edu.cuit.icloud.custom;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.Test;

/**
 * TODO
 * @date: 2020Äê3ÔÂ23ÈÕ
 * @author: flfan
 */
public class DateTest {
	
	@Test
	public void testPrintDate(){
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
	}
	@Test
	public void testDateStr(){
		String date1 = "2020-03-27T00:00:00";
		String date2 = "2020-03-27T00:00:00";
		String d1 = date1.split("T")[0];
		String d2 = date2.split("T")[0];
		boolean equals = d1.equals(d2);
		System.out.println(equals);
	}
}
