"# company_db"
###how to star
###### 1.spring initializr一个新项目
```java
//2.加入依赖
compile('org.springframework.boot:spring-boot-starter-data-jpa')
	compile("org.flywaydb:flyway-core:4.1.1")

	runtime('com.h2database:h2')
```
###3.注意事项
#####1.在resource下建db，再创建migration
#####2.sql命名__(双下划线开头)
#####3.sql语句create()
4.Respository要声明泛型
###8080端口占用
######1.netstat -ano | findstr 8080 
######2.taskkill -pid 3168 -f