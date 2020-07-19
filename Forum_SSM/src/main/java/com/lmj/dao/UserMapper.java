package com.lmj.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lmj.model.User;

//@Repository("userMapper")
//@Repository
//@Component
//@Mapper
public interface UserMapper {

	public User FindUserbyUsernameAndPassword(@Param("username")String username,
											@Param("password") String password);
	
	public User FindUserbyUsername(String username);
	
//	@Select("select * from user where id = #{id}")
	public User FindUserbyId(String id);
	
	public void InsertUser(User user);
	
	public void UpdateUserPassword(User user);
}
