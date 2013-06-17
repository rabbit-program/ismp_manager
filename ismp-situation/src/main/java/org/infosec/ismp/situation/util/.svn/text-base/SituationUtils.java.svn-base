package org.infosec.ismp.situation.util;

public class SituationUtils {
	
	/**
	 * 指标层数据得到r
	 * @param frequency
	 * @return
	 */
	private static float markerBed(int[] frequency){
		float x1 = (float) (frequency[0] / 10.0);
		float x2 = frequency[1];
		float x3 = (float) (frequency[2] * 10.0);
		float x4 = (float) (frequency[3] * 100.0);
		float x5 = (float) (frequency[4] * 1000.0);		
		float r = x1 + x2 + x3 + x4 + x5;
		return r * 10;
	}

	/**
	 * 得到主机／服务器的攻击威胁，病毒疫情，非法连接等指数
	 * @param r
	 * @return
	 */
	public static float exponentialCalculate(int[] frequency) {
		float r = markerBed(frequency);
		double res = 0;
		if (r > 0 && r<=10.0) {
			res = 0.000169083465793 * r - 0.005199223195825;
			res = res * r + 0.061701759236541;
			res = res * r - 0.357328775801422;
			res = res * r + 1.059000467470189;
			res = res * r + 0.011014031464144;
			res = res * (200 / 3.14);
		}else if (r>10 && r<=50.0) {
			res = 0.000002282031129 * r - 0.00026504819066;
			res = res * r + 0.010744006485676;
			res = res * r + 1.393145046447054;
			res = res * (200 / 3.14);
		}else if (r>50) {
			res = 100;
		}
		return (float) res;
	}
	
	/**
	 * 得到主机/服务器的总态势指数
	 * @param rt(攻击威胁指数)
	 * @param rv(病毒疫情指数)
	 * @param rc(非法连接指数)
	 * @return
	 */
	public static float hostExponential(float rt, float rv, float rc) {
		float res = (float) (2 / 5.0 * rt);
		res = (float) (res + 2 / 5.0 * rv);
		res = (float) (res + 1 / 5.0 * rc);
		return res;
	}
	
	public static void main(String[] args) {
//		SituationUtils aa = new SituationUtils();
//		int[] obj = new int[]{1000000,20,30,40,561};
//		float r = aa.markerBed(obj);
//		float rt = aa.attackExponential(r);
//		System.out.println(rt);
	}
}
