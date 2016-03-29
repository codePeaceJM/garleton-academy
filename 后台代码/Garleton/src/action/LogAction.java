package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import service.LogService;
import service.LogServiceImpl;
import entity.Log;

public class LogAction extends ActionSupport{
	
	LogService logService;
	private ArrayList<Log> logList;
	
	public String test() {
		logList=logService.searchByTime("2002-01-01", "2005-01-01");
		for(Log log : logList){
			System.out.println(log.getTime());
		}
		return "test";
	}

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public ArrayList<Log> getLogList() {
		return logList;
	}

	public void setLogList(ArrayList<Log> logList) {
		this.logList = logList;
	}
}
