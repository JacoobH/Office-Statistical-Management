![](https://img.shields.io/badge/update-today-blue.svg) ![](https://img.shields.io/badge/gitbook-making-lightgrey.svg)</br></br>

[:pencil2:](#说明-pencil2) [:hammer:](#项目功能-hammer) [:computer:](#运行效果-computer) [:memo:](#配置-memo)  </br></br>

## 说明 :pencil2:

写字楼的办公室统计管理系统，作为刚接触javaweb的练手项目

jdk版本：10.0.1

数据库：mysql

服务器：apache-tomcat-9.0.11

框架：(前端)bootstrap, bootstrap-table, chart.js

## 项目功能 :hammer:

系统管理员:  用户管理、在线用户查看

物业公司管理员：办公室信息信息、相关单位(公司)信息管理、单位(公司)统计信息

## 运行效果 :computer:

> [系统管理员权限](https://github.com/JacoobH/Office-Statistical-Management/master/files/operation_effect_system.md)

> [物业公司管理员权限](https://github.com/JacoobH/Office-Statistical-Management/master/files/operation_effect_properties.md)

## 配置 :memo:


数据库(mysql)：

url：jdbc:mysql//localhost:8080/xzldbgstjglxt

用户:root

密码:123456

> [表脚本](https://github.com/JacoobH/Office-Statistical-Management/tree/master/files/table-script)

> [连接池配置(Tomcat)](https://github.com/JacoobH/Office-Statistical-Management/tree/master/files/context.xml)

配置方法：

tomcat根目录\conf\context.xml

方法一：替换context.xml

方法二：在<content>标签内粘贴以下代码：

    <Resource
    	name = "office_manager_JDBC_pool"
    	auth = "Container"
    	type = "javax.sql.DataSource"
    	driverClassName = "com.mysql.jdbc.Driver"
    	url = "jdbc:mysql://localhost:3306/xzldbgstjglxt"
    	username = "root"
    	password = "595525934"
    	maxIdle = "2"
    	maxActive = "20"
    	maxWait = "5000"
    />
    
> [相关jar包](https://github.com/JacoobH/Office-Statistical-Management/tree/master/files/jars)
