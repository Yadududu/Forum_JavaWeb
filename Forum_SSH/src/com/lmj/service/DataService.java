package com.lmj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmj.dao.DataDao;
import com.lmj.model.Data;

@Service
public class DataService {
	
	@Autowired
	private DataDao dataDao;
	
	public List<Data> FindAllData() {
		List<Data> dataList=dataDao.FindAllData();
		
		return dataList;
	}

	public Data FindDatabyId(String dataID) {
		Data data = dataDao.FindDatabyId(dataID);
		
		return data;
	}
	
	public String FindDataIdbyData(Data data) {
		List<Data> dataList = dataDao.FindDatabyTitleAndContentAndUId(data.getTitle(),data.getDcontent(),data.getU_id());
		
		return dataList!=null?dataList.get(dataList.size()-1).getId():"";
	}
	public Data InsertData(Data data) {
		data = dataDao.InsertData(data);
		
		return data;
	}
	public void DeleteDataById(String dataID) {
		Data data = dataDao.FindDatabyId(dataID);
		dataDao.DeleData(data);
	}
	public void UpdateDataAnsnum(String id,int i) {
		Data data = dataDao.FindDatabyId(id);
		dataDao.UpdateDataAnsnum(id,data.getAnsnum()+i);
	}
}
