package com.lmj.test;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lmj.dao.AnswerMapper;
import com.lmj.dao.DataMapper;
import com.lmj.dao.UserMapper;
import com.lmj.model.Answer;
import com.lmj.model.Data;
import com.lmj.model.User;
import com.lmj.service.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
public class TestProperty {

//	@Resource(name="user3")
//	private User user;

//	@Test
//	public void Test() {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		User user = (User) ac.getBean("user3");
//		
////		construtor constructor = (construtor) ac.getBean("user4");
//		System.out.println(user.toString());
//	}

	@Test
	public void TestMybatis() throws Exception {
		// 加载配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		// 创建SqlSessionFactory对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession对象
		SqlSession session = factory.openSession();
		// 获取到代理对象
		UserMapper u = session.getMapper(UserMapper.class);

		User user = u.FindUserById("1");
		System.out.println(user.toString());

		session.close();
		in.close();
	}

//	@Autowired
	@Resource(name = "sqlSessionFactory")
	SqlSessionFactory factory;

	public SqlSession GetSession() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SqlSessionFactory factory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
		SqlSession session = factory.openSession();

		return session;
	}

	@Test
	public void TestService() {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		SqlSessionFactory factory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
//		SqlSession session = factory.openSession();
//		
		UserMapper userMapper = GetSession().getMapper(UserMapper.class);
		User user = userMapper.FindUserById("1");
		System.out.println(user);

//		((ClassPathXmlApplicationContext)ac).close();
	}

	@Test
	public void TestFindUserByUser() {
		UserMapper userMapper = GetSession().getMapper(UserMapper.class);
		User user = new User();
//		user.setPhonenum("123");
		user.setAdmin(true);
		User u = userMapper.FindUserByUser(user);
		System.out.println(u);

	}

	@Test
	public void TestFindDataByData() {

		DataMapper dataMapper = GetSession().getMapper(DataMapper.class);
		Data data = new Data();
//		data.setId("1");
		data.setTitle("111");
		List<Data> datas = dataMapper.FindDataByData(data);
		datas.forEach(d -> System.out.println(d));

	}

	@Test
	public void TestDeleteAnswerByAnswer() {

		AnswerMapper answerMapper = GetSession().getMapper(AnswerMapper.class);
		Answer answer = new Answer();
		answer.setU_id("1");
		answerMapper.DeleteAnswerByAnswer(answer);
	}

	@Test
	public void TestFindAllData() {

		DataMapper dataMapper = GetSession().getMapper(DataMapper.class);
		List<Data> datas = dataMapper.FindAllData();
		datas.forEach(data -> System.out.println(data));
	}

}
