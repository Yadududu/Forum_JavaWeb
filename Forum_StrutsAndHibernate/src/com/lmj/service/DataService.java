package com.lmj.service;

import java.util.List;

import org.hibernate.Transaction;

import com.lmj.dao.DataDao;
import com.lmj.model.Data;
import com.lmj.util.HibernateUtils;

public class DataService {
	
	public List<Data> FindAllData() {
		DataDao dataDao = new DataDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		List<Data> dataList=null;
		try {
			dataList=dataDao.FindAllData();
		}catch(Exception e){
			transaction.rollback();
		}
		transaction.commit();
		
		return dataList;
	}

	public Data FindDatabyId(String dataID) {
		DataDao dataDao = new DataDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		Data data=null;
		try {
			data = dataDao.FindDatabyId(dataID);
		}catch(Exception e){
			transaction.rollback();
		}
		transaction.commit();
		
		return data;
	}
	
	public String FindDataIdbyData(Data data) {
		DataDao dataDao = new DataDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		List<Data> dataList=null;
		try {
			dataList = dataDao.FindDatabyTitleAndContentAndUId(data.getTitle(),data.getDcontent(),data.getU_id());
		}catch(Exception e){
			transaction.rollback();
		}
		transaction.commit();
		
		return dataList!=null?dataList.get(dataList.size()-1).getId():"";
	}
	public Data InsertData(Data data) {
		DataDao dataDao = new DataDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		try {
			data = dataDao.InsertData(data);
		}catch(Exception e) {
			transaction.rollback();
		}
		transaction.commit();
		return data;
	}
	public void DeleDataById(String dataID) {
		DataDao dataDao = new DataDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		try {
			Data data = dataDao.FindDatabyId(dataID);
			dataDao.DeleData(data);
		}catch(Exception e) {
			transaction.rollback();
		}
		transaction.commit();
	}
	public void UpdateAnsnum(String id,int i) {
		DataDao dataDao = new DataDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		try {
			Data data = dataDao.FindDatabyId(id);
			dataDao.UpdateDataAnsnum(id,data.getAnsnum()+i);
		}catch(Exception e){
			transaction.rollback();
		}
		transaction.commit();
	}
}
