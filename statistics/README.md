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
|  username | varchar | 用户名 |
| password | varchar | 密码 |
| status | int | 状态 |

2. 收支类型表 tb_in_out_type

| column | type | description |
| ---- | ---- | ---- |
| id | int | primary key |
| code | varchar | 代码 |
| name | varchar | 名称 |
| userId | int | 关联用户id |

3. 资金类型表 tb_fund_type

| column | type | description |
| ---- | ---- | ---- |
| id | int | primary key |
| code | varchar | 类型代码 |
| name | varchar | 类型名称 |
| status | int | 0启用 1停用 |
| userId | int | 关联用户id |

4. 收支来源去向分类 tb_in_out_sources

| column | type | description |
| ---- | ---- | ---- |
| id | int | primary key |
| name | varchar | 名称 |
| status | int | 状态 0启用 1停用 |
| parentId | int | 上级id |
| inOutTypeId | int | 关联收支类型id |

5. 总资金 tb_total_funds

| column | type | description |
| ---- | ---- | ---- |
| id | int | primary key |
| totalFunds | double | 总资金 |
| name | varchar | 名称 |
| updateDate | datetime | 修改日期 |
| description | varchar | 说明 |
| userId | int | 关联用户id |
| fundTypeId | int | 关联资金类型id |

6. 资金变更记录表 tb_fund_change_record

| column | type | description |
| ---- | ---- | ---- |
| id | int | primary key |
| changeMoney | double | 记录关联金额 |
| recordDate | datetime | 记录日期 |
| moneyBeforeChange | double | 变更前金额 |
| moneyAfterChange | double | 变更后金额 |
| name | varchar | 名称 |
| description | varchar | 说明 |
| inOutTypeId | int | 关联收支类型id |
| inOutSourcesId | int | 关联收支来源去向id |
| totalFundsId | int | 关联总资金id |
| userId | int | 关联用户id |