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

```
nohup sh bin/mqbroker -n localhost:9876 &
tail -f ~/logs/rocketmqlogs/broker.log 
```