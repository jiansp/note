package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class Bug {
	@Test
	public void main() {
		
		/*
		 * 1.删除list中某个元素，直接用remove会造成下标越界的异常
		 */
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		List<Integer> copyList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > 1) {
				copyList.add(list.get(i));
			}
		}
		System.out.println(copyList);
		
		SimpleDateFormat dateTime = new SimpleDateFormat("MM月dd日 HH点mm分");
		System.out.println(dateTime.format(new Date()));
	}
}
