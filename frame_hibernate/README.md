## Java框架-Hibernate

### 基础 DONE
实体类对象在Hibernate中有3种状态：瞬时，持久和脱管
- 瞬时 指的是没有和hibernate发生任何关系，在数据库中也没有对应的记录，一旦JVM结束，这个对象也就消失了
- 持久 指得是一个对象和hibernate发生联系，有对应的session,并且在数据库中有对应的一条记录
- 脱管 指的是一个对象虽然在数据库中有对应的一条记录，但是它所对应的session已经关闭了

### 关系 DONE

### 各类概念 DONE

#### 事务
在Mysql中，只有当表的类型是INNODB的时候，才支持事务，所以需要把表的类型设置为INNODB,否则无法观察到事务.

修改表的类型为INNODB的SQL：
```
alter table product ENGINE  = innodb;
``` 
查看表的类型的SQL
```
show table status from databaseName[数据库名];
``` 

#### 级联
级联有4种类型：
- all：所有操作都执行级联操作；
- none：所有操作都不执行级联操作；
- delete：删除时执行级联操作；
- save-update：保存和更新时执行级联操作；

级联通常用在one-many和many-to-many上，几乎不用在many-one上。

#### 缓存
hibernate默认是开启一级缓存的，一级缓存存放在session上

在hibernate.cfg.xml中开启二级缓存的配置，hibernate本身不提供二级缓存，都是使用第三方的二级缓存插件
这里用的是EhCache提供的二级缓存

#### 分页
Hibernate使用Criteria 来进行分页查询
- criteria.setFirstResult(2); 表示从第3条数据开始
- criteria.setMaxResults(5); 表示一共查询5条数据

#### 两种获取方式
- load方式是延迟加载，只有属性被访问的时候才会调用sql语句，id不存在会抛异常
- get方式是非延迟加载，无论后面的代码是否会访问到属性，马上执行sql语句，id不存在会返回null

#### 两种获取session的方式
- openSession
    - 获取的是否是同一个session对象：openSession每次都会得到一个新的Session对象
    - 事务提交的必要性：openSession只有在增加，删除，修改的时候需要事务，查询时不需要
- getCurrentSession
    - 获取的是否是同一个session对象：getCurrentSession在同一个线程中，每次都是获取相同的Session对象，但是在不同的线程中获取的是不同的Session对象
    - 事务提交的必要性：getCurrentSession是所有操作都必须放在事务中进行，并且提交事务后，session就自动关闭，不能够再进行关闭

#### 乐观锁
Hibernate使用乐观锁来处理脏数据问题

做法：
- 增加一个version字段，用于版本信息控制。这就是乐观锁的核心机制。
    - 比如session1获取product的时候，version=1，那么session1更新product的时候，就需要确保version还是1才可以进行更新，并且更新结束后，把version改为2。
- version元素必须紧跟着id后面，否则会出错。

### 注解