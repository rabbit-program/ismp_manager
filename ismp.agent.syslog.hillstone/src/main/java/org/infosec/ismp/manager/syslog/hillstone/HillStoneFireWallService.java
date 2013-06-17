package org.infosec.ismp.manager.syslog.hillstone;

import java.util.Date;

import org.infosec.ismp.manager.model.HillStoneFireWall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class HillStoneFireWallService {
	
	private HillStoneFireWallDao hillstoneDao;
	
	@Autowired(required=true)
	public void setHillstoneDao(HillStoneFireWallDao hillstoneDao) {
		this.hillstoneDao = hillstoneDao;
	}

	public String getTimestamp(String timestamp)throws Exception{
		Date date = new Date();
		String day = null;
		String time = null;
		String[] str = date.toString().split(" ");
		String year = str[str.length-1];
		String[] strs = timestamp.split(" ");
		String month = strs[0].trim();
		if(strs[1].trim().equals("")){
			day = "0" + strs[2].trim();
			time = strs[3].trim();
		}else{
			day = strs[1].trim();
			time = strs[2].trim();
		}

		if (month.equals("Jan")) {
			month = "01";
		}else if (month.equals("Feb")) {
			month = "02";
		}else if (month.equals("Mar")) {
			month = "03";
		}else if (month.equals("Apr")) {
			month = "04";
		}else if (month.equals("May")) {
			month = "05";
		}else if (month.equals("Jun")) {
			month = "06";
		}else if (month.equals("Jul")) {
			month = "07";
		}else if (month.equals("Aug")) {
			month = "08";
		}else if (month.equals("Sep")) {
			month = "09";
		}else if (month.equals("Oct")) {
			month = "10";
		}else if (month.equals("Nov")) {
			month = "11";
		}else if (month.equals("Dec")) {
			month = "12";
		}
		String res = year+"-"+month+"-"+day+" "+time;
		return res;
	}
	
	@Transactional
	public void saveHillstone(HillStoneFireWall hillstone){
		hillstoneDao.save(hillstone);
	}
}
