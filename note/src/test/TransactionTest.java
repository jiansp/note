package test;

import com.jian.moble.ParamConfig;
import com.jian.service.TestService;
/*
 * 测试事物的回滚
 * 事务里包含一个delete操作和sava操作，让其中的delete报错，save操作回滚
 */
public class TransactionTest {
	public static void main(String[] args) {
		ParamConfig paramConfig = new ParamConfig();
		paramConfig.setId("22223");
		TestService testService = new TestService();
		testService.rollback(paramConfig);
	}
}
