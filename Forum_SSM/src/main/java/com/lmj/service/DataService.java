package com.lmj.service;

import java.util.List;

import com.lmj.model.Data;

public interface DataService {
	
	public List<Data> FindAllData();

	public Data FindDatabyId(int dataID);

	public int InsertData(Data data);
	
	public void UpdateDataAnsnum(Integer id,int i);

	public void DeleDataById(int id);
}
