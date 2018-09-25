# springboot2 项目模板
springboot2的项目模板
## 说明

### 安装说明
idea需要安装 lombok插件

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
/adminUI springboot2 adminUI
```
### 引用
将默认servlet容器改为jetty

模板引擎 ：pebble

mysql连接池 ：阿里druid

restful接口文档： swagger2

解析JSON：jackson

减少重复代码的书写 ：lombok

服务状态检查 ： Actuator

## 打包
mvn clean package

## 后续计划
1. Actuator监控增加身份认证
1. 全局错误捕获
1. 增加grpc的service层
1. 增加shrio身份认证
1. Scala 语言支持