package com.lmj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmj.dao.AnswerMapper;
import com.lmj.dao.DataMapper;
import com.lmj.model.Data;

@Service
public class DataServiceImpl implements DataService{
	
	@Autowired
	private DataMapper dataDao;
	
	@Autowired
	private AnswerMapper answerDao;
	
	public List<Data> FindAllData() {
		return dataDao.FindAllData();
	} 

	public Data FindDataById(String dataID) {
		return dataDao.FindDataById(dataID);
	}
	
	public String FindDataIdByData(Data data) {
		List<Data> dataList = dataDao.FindDatabyTitleAndContentAndUId(data);
		return dataList!=null?dataList.get(dataList.size()-1).getId():"";
	}

	public void InsertData(Data data) {
		dataDao.InsertData(data);
//		dataDao.FindDataByTitleAndContentAndUId(data.getTitle(), data.getDcontent(), data.getU_id());
	}

	public void UpdateDataAnsnum(String dataID, int ansnum) {
		Data data = dataDao.FindDataById(dataID);
		dataDao.UpdateDataAnsnum(dataID, data.getAnsnum() + ansnum);
	}

	public void DeleteDataById(String dataID) {
//		answerDao.DeleteAnswerById(dataID);
		answerDao.DeleteAnswerByDid(dataID);
		dataDao.DeleteDataById(dataID);
	}
}
