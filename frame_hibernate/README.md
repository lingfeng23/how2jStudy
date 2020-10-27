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

### 注解 DONE

#### 类相关注解
- @Entity：将一个类声明为一个实体bean(即一个持久化POJO类)
- @Table：注解声明了该实体bean映射指定的表（table）,目录（catalog）和schema的名字

#### 属性相关注解
- @Id：注解声明了该实体bean的标识属性（对应表中的主键）。
- @Column：注解声明了属性到列的映射。该注解有如下的属性
    - name 可选，列名（默认值是属性名）
    - unique 可选，是否在该列上设置唯一约束（默认值false）
    - nullable 可选，是否设置该列的值可以为空（默认值false）
    - insertable 可选，该列是否作为生成的insert语句中的一个列（默认值true）
    - updatable 可选，该列是否作为生成的update语句中的一个列（默认值true）
    - columnDefinition 可选，为这个特定列覆盖sql ddl片段（这可能导致无法在不同数据库间移植）
    - table 可选，定义对应的表（默认为主表）
    - length 可选，列长度（默认值255）
    - precision 可选，列十进制精度（decimal precision)(默认值0）
    - scale 可选，如果列十进制数值范围（decimal scale）可用，在此设置（默认值0）
- @GeneratedValue：注解声明了主键的生成策略。该注解有如下属性
    - strategy 指定生成的策略（JPA定义的），这是一个GenerationType。默认是GenerationType. AUTO
        - GenerationType.AUTO 主键由程序控制
        - GenerationType.TABLE 使用一个特定的数据库表格来保存主键
        - GenerationType.IDENTITY 主键由数据库自动生成（主要是自动增长类型）
        - GenerationType.SEQUENCE 根据底层数据库的序列来生成主键，条件是数据库支持序列。（这个值要与generator一起使用）
    - generator 指定生成主键使用的生成器（可能是orcale中的序列）。
- @SequenceGenerator：注解声明了一个数据库序列。该注解有如下属性
    - name 表示该表主键生成策略名称，它被引用在@GeneratedValue中设置的“gernerator”值中
    - sequenceName 表示生成策略用到的数据库序列名称。
    - initialValue 表示主键初始值，默认为0.
    - allocationSize 每次主键值增加的大小，例如设置成1，则表示每次创建新记录后自动加1，默认为50.
    
#### 关系相关注解
- @ManyToOne 设置多对一关联
    - 方法一
    ```
    @ManyToOne(cascade={CasCadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="外键")
    public 主表类 get主表类(){return 主表对象}
    ```
    - 方法二
    ```
    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="关联表名"，
        joinColumns = @JoinColumn(name="主表外键"),
        inverseJoinColumns = @JoinColumns(name="从表外键")
        )
    ```
- @OneToMany 设置一对多关联。
    - 方法一：“一端”配置
    ```
    @OneToMany(mappedBy="“多端”的属性")
    public List<“多端”类> get“多端”列表(){return “多端”列表}
    “多端”配置参考@ManyToOne.
    ```
    - 方法二：“一端”配置
    ```
    @OneToMany(mappedBy="“多端”的属性")
    @MapKey(name="“多端”做为Key的属性")
    public Map<“多端”做为Key的属性的类,主表类> get“多端”列表（）{return “多端”列表}
    “多端”配置参考@ManyToOne.
    ```
    - 方法三：“一端”配置，使用这种配置，在为“一端”添加“多端”时，可以修改“多端”的外键。
    ```
    @OneToMany
    @JoinColumn(name="“多端”外键")
    public List<“多端”类> get“多端”列表(){return “多端”列表}
    “多端”配置参考@ManyToOne.
    ```
  
#### XMl和注解对比
- XML配置方式：
    - 优：容易编辑，配置比较集中，方便修改，在大业务量的系统里面，通过xml配置会方便后人理解整个系统的架构，修改之后直接重启应用即可
    - 缺：比较繁琐，配置形态丑陋, 配置文件过多的时候难以管理
- 注解方式：
    - 优：方便，简洁，配置信息和 Java 代码放在一起，有助于增强程序的内聚性。
    - 缺：分散到各个class文件中，所以不宜维护, 修改之后你需要重新打包，发布，重启应用。

