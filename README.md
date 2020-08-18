# JavaWebPractice
```
分别使用JavaWeb，SSH，SSM搭建的小型论坛，目的为了学习和对比不同的框架
JavaWeb
	使用了监听器(Listener)
		做了单点登录
	使用了过滤器(Filter)
		做了首页初始化
		做了未登录访问跳转到登录页
		做了统一编码(Encoding)
	使用Servlet直接与前端交互,前端通过jstl与el表达式获取数据
	数据库使用c3p0连接池连接Mysql数据库,使用dbutils工具读取数据
	已经打包并发布，发布地址：http://forum.mylmj.club/
	
SSH(Struts+Hibernate)
	使用了监听器(Listener)
		做了单点登录
	使用了过滤器(Filter)
		做了首页初始化
	使用Struts的Action与前端交互,前端通过ognl获取数据
		使用了Struts的过滤器做了未登录访问跳转到登录页
	数据库使用Hibernate连接Mysql数据库,启动时自动生成数据库,并配置了事务管理
		其中User,Data,Answer三个表分别配置了一对多,多对一的关系
		使用Hibernate自带的增删改查和结合SQL查询数据库
	已经打包并发布，发布地址：http://sshforum.mylmj.club/

SSM(Spring+SpringMVC+Mybatis)
	使用了监听器(Listener)
		做了单点登录
	使用了过滤器(Filter)
		做了首页初始化
	使用Spring容器
		获取DataSource(也是使用C3P0连接池),
		获取mybatis sqlSessionFactory
		使用mapper动态扫描开发
		配置了事务管理(aop)
	使用SpringMVC与前端交互,前端通过jstl与el表达式获取数据
		使用了SpringMVC的过滤器做了未登录访问跳转到登录页
		自定义了Exception页面
	数据库使用mybatis操作数据库
		其中User,Data,Answer三个表分别配置了一对多,多对一的关系
	使用了Maven搭建，已经打包并发布，发布地址：http://ssmforum.mylmj.club/
```
