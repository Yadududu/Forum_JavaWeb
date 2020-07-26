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

	public User FindUserByUsernameAndPassword(@Param("username")String username,
											@Param("password") String password);
	
	public User FindUserByUsername(String username);
	
//	@Select("select * from user where id = #{id}")
	public User FindUserById(String id);
	
	public User FindUserByUsernameAndPhonenum(@Param("username")String username,
											@Param("phonenum") String phonenum);
	
	public void InsertUser(User user);
	
	public void UpdateUserPassword(User user);
}
