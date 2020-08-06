package com.lmj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lmj.model.Data;

public interface DataMapper {
	
	public List<Data> FindAllData();
	
	public List<Data> FindDataById(String dataId);

	/*FindDataByDataÌæ´ú**/
	public List<Data> FindDataByTitleAndContentAndUId(@Param("title")String title,
												@Param("dcontent")String dcontent,
												@Param("uid")String uid);
	
	public void InsertData(Data data);

	public void UpdateDataAnsnum(@Param("id")String dataId, 
								@Param("ansnum")int ansnum);

	public void DeleteDataById(String dataId);
	
	public List<Data> FindDataByData(Data data);
}
