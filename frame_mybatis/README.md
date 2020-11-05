## Java框架-Mybatis

### Mybatis 基础 DONE

#### Mybatis入门 DONE
基本原理：
- 应用程序找 Mybatis 要数据
- mybatis 从数据库中找来数据
    - 通过 mybatis-config.xml 定位哪个数据库
    - 通过 Category.xml 执行对应的 select 语句
    - 基于 Category.xml 把返回的数据库记录封装在 Category 对象中
    - 把多个 Category 对象装在一个 Category 集合中
- 返回一个 Category 集合

#### Mybatis-CRUD DONE

#### Mybatis 更多查询 DONE

#### Mybatis 一对多 DONE

#### Mybatis 多对一 略

#### Mybatis 多对多 略

### 动态SQL DONE

#### Mybatis if DONE

#### Mybatis where DONE

#### Mybatis choose DONE

#### Mybatis foreach DONE

#### Mybatis bind DONE

### 注解 DONE

#### Mybatis CRUD DONE

#### Mybatis 一对多 DONE

#### Mybatis 多对一 DONE

#### Mybatis 多对多 DONE

#### Mybatis 动态SQL语句 略

### 相关概念

#### Mybatis 日志 DONE
- 使用 log4j依赖包
- 在 src 目录下增加 log4j 配置文件`log4j.properties`
 
#### Mybatis 事务
- 在 Mysql 中，只有当表的类型是 INNODB 的时候，才支持事务
- 查询表的类型的SQL
    ```
    show table status from how2java; 
    ```
- 修改表的引擎的SQL
    ```
    alter table tablename engine = innodb;
    ```
#### Mybatis 延迟加载
在 mybatis-config.xml 中配置
```
<settings>
    <!-- 打开延迟加载的开关 -->
    <setting name="lazyLoadingEnabled" value="true" />
    <!-- 将积极加载改为消息加载即按需加载 -->
    <setting name="aggressiveLazyLoading" value="false"/>
</settings>
```
