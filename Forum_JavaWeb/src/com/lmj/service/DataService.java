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

	public Data FindDatabyId(String dataID) {
		DataDao dataDao = new DataDao();
		return dataDao.FindDatabyId(dataID);
	}

	public boolean InsertData(Data data) {
		DataDao dataDao = new DataDao();
		int temp = dataDao.InsertData(data);
		return temp != 0 ? true : false;
	}

	public void UpdateDataAnsnum(String dataID, int i) {
		DataDao dataDao = new DataDao();
		Data data = dataDao.FindDatabyId(dataID);
		dataDao.UpdateDataAnsnum(dataID, data.getAnsnum() + i);
	}

	public void DeleDataById(String dataID) {
		DataDao dataDao = new DataDao();
		AnswerDao answerDao = new AnswerDao();
		answerDao.DeleAnswerByDId(dataID);
		dataDao.DeleDataById(dataID);
	}

}
