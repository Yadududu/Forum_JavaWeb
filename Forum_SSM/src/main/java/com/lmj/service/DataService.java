package com.lmj.service;

import java.util.List;

import com.lmj.model.Data;

public interface DataService {
	
	public List<Data> FindAllData();

	public Data FindDataById(String dataID);
	
	public String FindDataIdByData(Data data);

	public void InsertData(Data data);
	
	public void UpdateDataAnsnum(String dataID,int ansnum);

	public void DeleteDataById(String dataID);
	
}
