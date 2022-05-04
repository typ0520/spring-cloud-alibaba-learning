### 官网

[https://rocketmq.apache.org/docs/quick-start/](https://rocketmq.apache.org/docs/quick-start/)

[https://github.com/apache/rocketmq](https://github.com/apache/rocketmq)

### 安装
- 单机

  下载资源包 
[https://www.apache.org/dyn/closer.cgi?path=rocketmq/4.9.3/rocketmq-all-4.9.3-bin-release.zip](https://www.apache.org/dyn/closer.cgi?path=rocketmq/4.9.3/rocketmq-all-4.9.3-bin-release.zip)
  
```
 > unzip rocketmq-all-4.9.3-source-release.zip
  > cd rocketmq-all-4.9.3/
  > mvn -Prelease-all -DskipTests clean install -U
  > cd distribution/target/rocketmq-4.9.3/rocketmq-4.9.3
```

#### Start Name Server

```
nohup sh bin/mqnamesrv &
tail -f ~/logs/rocketmqlogs/namesrv.log
```

#### Start Broker

修改conf/broker.conf文件，添加brokerIP1=localhost
```
nohup sh bin/mqbroker -n localhost:9876 -c ./conf/broker.conf autoCreateTopicEnable=true &
tail -f ~/logs/rocketmqlogs/broker.log 
```

### 示例

添加依赖
```
 <dependency>
    <groupId>org.apache.rocketmq</groupId>
    <artifactId>rocketmq-client</artifactId>
    <version>4.9.3</version>
</dependency>
```

[https://rocketmq.apache.org/docs/simple-example/](https://rocketmq.apache.org/docs/simple-example/)
[https://github.com/apache/rocketmq/tree/master/example](https://github.com/apache/rocketmq/tree/master/example)