# springboot2 项目模板
springboot2的项目模板
## 说明
### 结构
```
/pom.xml
/readme.md 本文件
/util 工具类
/entity 实体类
/dao 数据访问
/service 业务
/controller  控制器
/web
```
### 引用
将默认servlet容器改为jetty

模板引擎 ：pebble

mysql连接池 ：阿里druid

restful接口文档： swagger2

解析JSON：jackson

## 打包
mvn clean package

## 后续计划
1. 增加grpc的service层
1. 增加shrio身份认证
1. Scala 语言支持