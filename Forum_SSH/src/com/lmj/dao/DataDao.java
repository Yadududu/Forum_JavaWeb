package com.lmj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.lmj.model.Data;
import com.lmj.util.HibernateUtils;

public class DataDao {
	
	public List<Data> FindAllData() {
		Session session = HibernateUtils.getCurrentSession();
		String sql = "SELECT user.username,data.id,data.title,data.dcontent,data.ansnum,data.u_id,data.dtime FROM user join data on user.id = data.u_id;";
		NativeQuery query = session.createSQLQuery(sql);
		query.addEntity(Data.class);
		
		List<Data> dataList = query.list();
		
		return dataList;
	}

	public Data FindDatabyId(String dataID) {
		Session session = HibernateUtils.getCurrentSession();
		String sql = "SELECT user.username,data.id,data.title,data.dcontent,data.ansnum,data.u_id,data.dtime FROM user join data on user.id = data.u_id where data.id=?;";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, dataID);
		query.addEntity(Data.class);
		
		Data data = (Data) query.uniqueResult();
		
		return data;
	}


	public void InsertData(Data data) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(data);
	}
	public void DeleData(Data data) {
		Session session = HibernateUtils.getCurrentSession();
		session.delete(data);
	}
	public List<Data> FindDatabyTitleAndContentAndUId(String title,String content,String uid) {
		Session session = HibernateUtils.getCurrentSession();
		String sql = "SELECT * FROM data where title=? and dcontent=? and u_id=?;";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, title);
		query.setParameter(2, content);
		query.setParameter(3, uid);
		query.addEntity(Data.class);
		
		List<Data> datas = query.list();
		
		return datas;
	}

	public void UpdateDataAnsnum(String id, int ansnum) {
		Session session = HibernateUtils.getCurrentSession();
		Data data = session.get(Data.class, id);
		data.setAnsnum(ansnum);
		session.update(data);
	}
}
