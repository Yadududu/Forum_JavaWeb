package com.lmj.service;

import java.util.List;

import com.lmj.dao.DataDao;
import com.lmj.model.Data;

public class DataService {
	
	public List<Data> GetDatas() {
		DataDao dataDao = new DataDao();
		return dataDao.GetAllData();
	}

	public Data GetData(int dataID) {
		DataDao dataDao = new DataDao();
		return dataDao.GetData(dataID);
	}

	public int AddData(Data data) {
		DataDao dataDao = new DataDao();
		dataDao.AddData(data);
		return dataDao.GetID(data);
	}
}
