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
	/*��½У��**/
	public User FindUserByUsernameAndPassword(@Param("username")String username,
											@Param("password") String password);
	/*FindUserByUser���**/
	public User FindUserByUsername(String username);
	
	/*FindUserByUser���**/
//	@Select("select * from user where id = #{id}")
	public User FindUserById(String id);
	
	/*�һ�����У��**/
	public User FindUserByUsernameAndPhonenum(@Param("username")String username,
											@Param("phonenum") String phonenum);
	
	public void InsertUser(User user);
	
	public void UpdateUserPassword(User user);
	
	public User FindUserByUser(User user);
}
