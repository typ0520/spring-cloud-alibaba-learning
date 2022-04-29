###官网
https://nacos.io/zh-cn/docs/quick-start.html

###安装nacos-server
```
https://codeload.github.com/alibaba/nacos/zip/refs/tags/2.0.3

docker pull nacos/nacos-server:v2.0.3
```

###启动
```
sh bin/startup.sh -m standalone

docker run -e MODE=standalone -p 8848:8848 -d nacos/nacos-server:2.0.3
```

访问http://localhost:8848/nacos ，默认用户名nacos/nacos

https://github.com/alibaba/spring-cloud-alibaba/tree/2.2.x/spring-cloud-alibaba-examples/nacos-example