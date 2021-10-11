docker啟動MYSQL:
	# docker cmd: docker run -di --name=mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=sa123456 centos/mysql-57-centos7
使用cmd登入MYSQL:
	1. docker exec 進入容器
	2. mysql -u root (不用加-p，root預設是不用密碼登入的)