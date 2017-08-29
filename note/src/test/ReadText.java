package test;

import java.io.IOException;


import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class ReadText {
	/*
	 * 实现java朗读文字
	 * 步骤：
	 * 1、将jacob-1.17-M2-x64.dll拷贝到jdk的bin目录（和windows/system32目录，实际操作并没有像这个文件夹拷贝）
	 * 2、引入jacob.jar包
	 * 
	 */
	public static void main(String[] args) throws IOException {
		   
	    ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
	  
	    Dispatch sapo = sap.getObject();
	    try {
	        // 音量 0-100
	        sap.setProperty("Volume", new Variant(100));
	        // 语音朗读速度 -10 到 +10
	        sap.setProperty("Rate", new Variant(0));
	        // 执行朗读
	        Dispatch.call(sapo, "Speak", new Variant(" abc吃葡萄不吐葡萄皮 不吃葡萄倒吐葡萄皮 不吃葡萄别吐葡萄皮 吃葡萄也别吐葡萄皮 不论吃葡萄不吃葡萄 都不要乱吐葡萄皮"));
	       
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        sapo.safeRelease();
	        sap.safeRelease();
	    }
	    }
}
