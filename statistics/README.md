# 自用账单统计系统
> 此项目为个人测试使用，设计功能为自用账单统计系统的API接口项目
---
## 所用工具
|         名称          | 版本 |         说明        |
|  -----------------  | ----  | ------------------ |
|       springboot  |   2.4.0 |        框架         |
|            lombok | 与spring boot保持一直 | 简化代码 |
|        mysql        | 匹配所用数据库版本  | 数据持久化 |
|       mybatis        | 2.1.4 |      操作数据库      |
|      swagger2        | 2.9.2 |     生成Api文档      |
| swagger-bootstrap-ui | 1.9.6 |  美化swagger2文档页面 |
|       jwt            | 3.4.0 |     token认证       | 
## 设计模块
### 用户管理
1. 用户表 tb_user

|  column  |  type  |  description  |
|  ----  |  ----  |  ----  |
|  id  |  int  |  primary key  |
|  username | varchar2 | 用户名 |
| password | varchar2 | 密码 |
| status | int | 状态 |
