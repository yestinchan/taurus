package cn.edu.sdu.cs.starry.taurus.example;

import cn.edu.sdu.cs.starry.taurus.TaurusManager;
import cn.edu.sdu.cs.starry.taurus.common.exception.BusinessException;

public class TaurusTest{

	/**
	 * @param args
	 * @throws BusinessException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws BusinessException, InterruptedException {

		TaurusManager tm = TaurusManager.getTaurusManager();
		tm.startTaurus("server","conf/taurus/taurus-conf.xml");
//		
//		Thread.sleep(8000);
//		
//		tm.restartTaurus("server","conf/taurus2/taurus-conf.xml");
		
//		tm.startTaurus("server","conf/taurus4/taurus-conf.xml");
		
//		Thread.sleep(7000);
		
//		System.exit(0);
	}

}
