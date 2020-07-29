package com.lmj.service;

import java.util.List;

import com.lmj.dao.AnswerDao;
import com.lmj.dao.DataDao;
import com.lmj.model.Data;

public class DataService {
	
	public List<Data> FindAllData() {
		DataDao dataDao = new DataDao();
		return dataDao.FindAllData();
	}

	public Data FindDatabyId(int dataID) {
		DataDao dataDao = new DataDao();
		return dataDao.FindDatabyId(dataID);
	}

	public int InsertData(Data data) {
		DataDao dataDao = new DataDao();
		dataDao.InsertData(data);
		List<Data> dataList=null;
		dataList = dataDao.FindDatabyTitleAndContentAndUId(data.getTitle(),data.getDcontent(),data.getU_id());
		return dataList!=null?dataList.get(dataList.size()-1).getId():0;
	}
	public void UpdateDataAnsnum(Integer id,int i) {
		DataDao dataDao = new DataDao();
		Data data = dataDao.FindDatabyId(id);
		dataDao.UpdateDataAnsnum(id,data.getAnsnum()+i);
	}

	public void DeleDataById(int id) {
		DataDao dataDao = new DataDao();
		AnswerDao answerDao = new AnswerDao();
		answerDao.DeleAnswerByDId(id);
		dataDao.DeleDataById(id);
	}
}
