package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTime {
	@Test
	public void main(){
		/*
		 * 1.��ʽ��ʱ���String����
		 */ 
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = formatDate.format(new Date());
		System.out.println(date);
		
	}
}
