package com.lmj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmj.dao.AnswerMapper;
import com.lmj.dao.DataMapper;
import com.lmj.model.Answer;
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
		Data d = new Data();
		d.setId(dataID);
		List<Data> list = dataDao.FindDataByData(d);
		return list.get(0);
	}
	
	public String FindDataIdByData(Data data) {
		List<Data> dataList = dataDao.FindDataByData(data);
		return dataList!=null?dataList.get(dataList.size()-1).getId():"";
	}

	public void InsertData(Data data) {
		dataDao.InsertData(data);
//		dataDao.FindDataByTitleAndContentAndUId(data.getTitle(), data.getDcontent(), data.getU_id());
	}

	public void UpdateDataAnsnum(String dataID, int ansnum) {
		Data d = new Data();
		d.setId(dataID);
		List<Data> list = dataDao.FindDataByData(d);
		dataDao.UpdateDataAnsnum(dataID, list.get(0).getAnsnum() + ansnum);
	}

	public void DeleteDataById(String dataID) {
		Answer answer = new Answer();
		answer.setD_id(dataID);
		answerDao.DeleteAnswerByAnswer(answer);
		dataDao.DeleteDataById(dataID);
	}
}
