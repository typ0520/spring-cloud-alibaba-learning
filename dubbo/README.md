### 官网

[https://dubbo.apache.org/zh/docs/v2.7/user/](https://dubbo.apache.org/zh/docs/v2.7/user/)

### 基础使用(单机直连)
- 使用xml文件做配置，demo工程basic-client和basic-server
- 使用springboot做集成，demo工程springboot-basic-server

添加依赖
```
<dependency>
    <groupId>org.apache.dubbo</groupId>
    <artifactId>dubbo-spring-boot-starter</artifactId>
</dependency>
```

springboot启动类增加@EnableDubbo注解

实现类增加org.apache.dubbo.config.annotation.Service注解

### 使用注册中心
支持consul、zookeeper、eureka、redis、nacos等作为注册中心，接入方法都一样非常方便，加上相关依赖，配置下服务地址就可以了

- nacos，demo工程basic-client-nacos和basic-server-nacos

添加依赖
```
<dependency>
    <groupId>com.alibaba.nacos</groupId>
    <artifactId>nacos-client</artifactId>
</dependency>
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
</dependency>
```

把注册中心地址从N/A改为nacos服务地址
```
<dubbo:registry address="nacos://localhost:8848" />
dubbo.registry.address=nacos://localhost:8848
```

- zeekeeper

添加依赖
```
<dependency>
    <groupId>org.apache.curator</groupId>
    <artifactId>curator-recipes</artifactId>
    <version>4.2.0</version>
</dependency>
<dependency>
    <groupId>org.apache.curator</groupId>
    <artifactId>curator-framework</artifactId>
    <version>4.2.0</version>
</dependency>
```

配置地址
```
<dubbo:registry address="zookeeper://127.0.0.1:2181" />
dubbo.registry.address=zookeeper://127.0.0.1:2181
```