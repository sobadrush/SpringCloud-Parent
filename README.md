docker啟動MYSQL:
	# docker cmd: docker run -di --name=mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=sa123456 centos/mysql-57-centos7
使用cmd登入MYSQL:
	1. docker exec 進入容器
	2. mysql -u root (不用加-p，root預設是不用密碼登入的)

最詳細的 Spring Boot 多模組開發與排坑指南 ---> 設定共用模組引用基礎元件
	https://www.gushiciku.cn/pl/pC1D/zh-tw

Maven - 排除 dependency , <exclusions>
	https://stackoverflow.com/questions/51239227/how-to-exclude-specific-dependencies-from-spring-boot-starter-parent