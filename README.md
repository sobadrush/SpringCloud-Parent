
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
|一次打包引發的思考，原來maven還能這麼玩？|https://iter01.com/552665.html|
|客戶端註冊地址( ★★★ 這邊要一定要寫 /eureka，不是寫 serviceName)|一定要加上/Eureka <br> http://127.0.0.1:8888/eureka|
|獲取SpringBoot啟動參數|https://springhow.com/spring-boot-application-arguments/|
|修改Ribbon附載均衡策略|https://cloud.tencent.com/developer/article/1332634|
|附載均衡攔截器LoadBalancerInterceptor|可用Eclipse 的 Open Type找到其中的intercept方法|

## 高可用Eureka Server (HA架構 / 分散式架構)
* 為避免Eureka服務器崩潰，起2台
* 將2台Eureka服務器彼此註冊，底層機制會將服務列表互相拷貝，若一台崩潰了另一台活著依然可以Discovery到服務URL
* For集群配置-可編輯Eclipse中的Spring Boot App啟動配置修改port起多個instance
* For集群配置-spring.application.name都要相同
* For集群配置-client端服務要對2個Eureka註冊(逗號分隔

## 電影購票服務
* microservice-movie 調用 microservice-user
* 稱 microservice-movie 為 『服務調用方』
* 稱 microservice-user 為 『服務提供方』
* 消費方：fetch-registry 必須要為 true，才可獲得提供方
* 消費方：register-with-eureka 不一定要是 true

## Eureka 失效剔除與自我保護
* 失效剔除 - Eureka Server每隔60秒對其認定為失效的服務(超過90秒沒續約的)進行剔除
* 	修改掃描失效服務的間隔時間(預設60秒): eureka.server.eviction-interval-timer-in-ms: 60000 (單位毫秒)
* 自我保護 - Eureka會統計最近15分鐘心跳失敗的服務之比例是否超過85%，就將服務剔除，但實務上可能因為網路速度等其他因素造成，PROD環境最好可以調整此參數
* 	enable-self-preservation: false # 自我保護機制(false: 取消，預設是 true)

## 導入OpenFeign
1. 『調用方』導入OpenFeign依賴
2. 編寫『代理interface』(底層是"動態代理"，類似MyBatis中的Mapper介面)
3. 於『代理interface』上標注 @FeignClient(value = "被調用的服務ID")
4. 把『被調用方』的方法copy到此，並於 @RequestMapping 上補全完整調用URI
5. 於SpringBoot啟動類別上標注 @EnableFeignClients
