
# 本SpringCloud專案相關說明
## 使用技術
* SpringBoot + SprintCloud(注意搭配版本)
* docker + MySql
* Eureka
    
## 相關操作
|動作|說明|
|:----:|---|
|docker啟動MYSQL| # docker cmd: docker run -di --name=mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=sa123456 centos/mysql-57-centos7 |
|使用cmd登入MYSQL|1. docker exec -it mysql /bin/sh<br>2.mysql -u root (不用加-p，root預設是不用密碼登入的)|
|進入Eureka Web畫面|http://localhost:8888/|    

## 其他問題
|問題|連結|
|:----:|---|
|設定Maven共用模組引用基礎元件|最詳細的 Spring Boot 多模組開發與排坑指南<br>https://www.gushiciku.cn/pl/pC1D/zh-tw|
|Maven - 排除 dependency , <exclusions>|shorturl.at/eEJP5|
|Spring-Boot vs Spring-cloud版本造成錯誤|SpringCloud: Error creating bean with name ‘configurationPropertiesBeans‘<br>shorturl.at/luHJ8|
|dependencyManagement作用说明|裡只是聲明依賴，並不自動實現引入，因此子項目需要顯示的聲明需要用的依賴。 如果不在子項目中聲明依賴，是不會從父項目中繼承下來的；只有在子項目中寫了該依賴項，並且沒有指定具體版本，才會從父項目中繼承該項，並且version和scope都讀取自父pom;另外如果子項目中指定了版本號，那麼會使用子項目中指定的jar版本|