package com.lmj.service;

import java.util.List;

import com.lmj.dao.DataDao;
import com.lmj.model.Data;

public class DataServiceImpl implements DataService{
	
	
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
//		Data d = dataDao.FindDatabyTitleAndContentAndUId(data.getTitle(), data.getContent(), data.getU_id());
//		return d.getId();
		return 1;
	}

	public void UpdateDataAnsnum(Integer id, int i) {
		DataDao dataDao = new DataDao();
		Data data = dataDao.FindDatabyId(id);
		dataDao.UpdateDataAnsnum(id, data.getAnsnum() + i);
	}

	public void DeleDataById(int id) {
		DataDao dataDao = new DataDao();
		dataDao.DeleDataById(id);
	}
}
