###《工具和中间件》
#### Maven

#### 调试 略

#### Git 略

#### Intellij IDEA DONE
- 修改配置文件位置
    - 关闭 IDEA
    - 打开 idea.properties(目录：/bin/idea.properties)
    - 配置 idea.config.path=${user.home}/.IntelliJIdea/config
    - 配置 idea.system.path=${user.home}/.IntelliJIdea/system
        ```
        idea.config.path=D:/software/.IntelliJIdea/config
        idea.system.path=D:/software/.IntelliJIdea/system
        ```
    - 重启 IDEA
    
#### Redis(redis) DONE

#### Nginx

##### Nginx
- Nginx 命令(在 Nginx 的目录下执行)
    - start nginx 启动
    - nginx -s stop 关闭
    - nginx -s reload 重启

- nginx.conf 配置文件
    - 端口号
    listen 80;
    - 页面存放位置：表示页面都存放在nginx的html目录下
    root html;
    - 欢迎页面：默认会访问index.html或者index.htm文件
    index  index.html index.htm;
- 反向代理概念
    - 先说正向代理，比如要访问 youtube,但是不能直接访问，只能先找个翻墙软件，通过翻墙软件才能访问 youtube. 翻墙软件就叫做正向代理。
    - 所谓的反向代理，指的是用户要访问 youtube,但是 youtube 悄悄地把这个请求交给 bilibili 来做，那么 bilibili 就是反向代理了。
    - 这里 Nginx 的反向代理指的是访问 nginx,但是 nginx 把请求交给 tomcat 来做。
- Nginx 反向代理的好处/意义？
    - nginx 在处理静态文件的吞吐量上面比 tomcat 好很多，通常他们俩配合，不会把所有的请求都如本例所示的交给 tomcat, 而是把静态请求交给 nginx，
    动态请求，如 jsp, servlet, ssm, struts 等请求交给 tomcat，从而达到动静分离的效果。
- 动静分离
    - 动静分离就是指图片，css, js 之类的都交给 nginx 来处理，nginx 处理不了的，比如 jsp 就交给 tomcat 来处理

#### 部署到 Linux

#### WebSocket

#### QRCode(qrcode) DONE
* 使用 Java 生成以及解析二维码
* 使用 JavaScript 方式创建二维码

#### 搜索引擎技术(searchEngine)

##### Lucene DONE
安装依赖 jar 包
- commons-io-1.3.2
- IKAnalyzer6.5.0 // 分词器
- lucene-analyzers-common-6.5.0
- lucene-core-7.2.1
- lucene-highlighter-7.2.1
- lucene-memory-7.2.1
- lucene-queryparser-7.2.1

###### Lucene 入门
like 也可以进行查询，那么使用 lucene 的方式有什么区别呢？ 主要是两点：
- 相关度
通过观察运行结果，可以看到不同相关度的结果都会查询出来，但是使用 like，就做不到这一点了
- 性能
数据量小的时候，like 也会有很好的表现，但是数据量一大，like 的表现就差很多了。

Lucene 的工作步骤
- 首先搜集数据
    - 数据可以是文件系统，数据库，网络上，手工输入的，或者像本例直接写在内存上的
- 通过数据创建索引
- 用户输入关键字
- 通过关键字创建查询器
- 根据查询器到索引里获取数据
- 然后把查询结果展示在用户面前

###### Lucene 分词器概念
分词器指的是搜索引擎如何使用关键字进行匹配，如入门中的关键字：护眼带光源。 如果使用 like,那么%护眼带光源%，匹配出来的结果就是要么全匹配，要不都不匹配。
而使用分词器，就会把这个关键字分为 护眼，带，光源 3个关键字，这样就可以找到不同相关程度的结果了。

###### Lucene 分页
分页查询是很常见的需求，比如要查询第10页，每页10条数据。

Lucene 分页通常来讲有两种方式：
- 第一种是把100条数据查出来，然后取最后10条。 优点是快，缺点是对内存消耗大。
- 第二种是把第90条查询出来，然后基于这一条，通过searchAfter方法查询10条数据。 优点是内存消耗小，缺点是比第一种更慢


#### Quartz(quartz) DONE

##### Quartz Job管理
Job 其实是由 3 个部分组成
- JobDetail: 用于描述这个 Job 是做什么的
- 实现 Job 的类: 具体干活的
- JobDataMap: 给 Job 提供参数用的

Cron 表达式举例

|表达式|含义|
| ---- | ---- |
|0 0 12 8 * ?|每天12:00触发|
|0 15 10 ? * *|每天10:15触发|
|0 15 10 * * ?|每天10:15触发|
|0 15 10 * * ? *|每天10:15触发|
|0 15 10 * * ? 2005|2005年的每天10:15触发|
|0 * 14 * * ?|每天14:00到14:59每分钟触发|
|0 0/5 14 * * ?|每天14:00到14:55每5分钟触发|
|0 0/5 14,18 * * ?|每天14:00到14:55每5分钟触发，18:00到18:55每5分钟触发|
|0 0-5 14 * * ?|每天14:00到14:05每分钟触发|
|0 10,,44 14 ? 3 WED|三月份的每个周三14:10到14:44触发|
|0 15 10 ? * MON-FRI|每个周一至周五上午10:15触发|
|0 15 10 15 * ?|每月15号10:15触发|
|0 15 10 L * ?|每月最后一天10:15触发|
|0 15 10 L-2 * ?|每月倒数第2天10:15触发|
|0 15 10 ? * 6L|每月最后一个周五10:15触发|
|0 15 10 ? * 6L 2002-2005|2002年至2005年每月最后一个周五10:15触发|
|0 15 10 ? * 6#3|每月第3个周五10:15触发|
|0 0 12 1/5 * ?|每月的第一天开始，每个第5天12:00触发|
|0 11 11 11 11 ?|每年11月11号11:11触发|

#### Shiro(shiro)

##### Shiro 入门 DONE
shiro.ini 配置文件方式鉴权

##### Shiro 数据库支持 DONE
RBAC 是当下权限系统的设计基础，同时有两种解释：
- 一： Role-Based Access Control，基于角色的访问控制
    - 即，你要能够删除产品，那么当前用户就必须拥有产品经理这个角色
- 二：Resource-Based Access Control，基于资源的访问控制
    - 即，你要能够删除产品，那么当前用户就必须拥有删除产品这样的权限

基于 RBAC 概念， 就会存在3 张基础表： 用户，角色，权限， 以及 2 张中间表来建立 用户与角色的多对多关系，角色与权限的多对多关系。 用户与权限之间也是多对多关系，但是是通过 角色间接建立的。

创建数据库脚本
```
drop table if exists user;
drop table if exists role;
drop table if exists permission;
drop table if exists user_role;
drop table if exists role_permission;
 
create table user (
  id bigint auto_increment,
  name varchar(100),
  password varchar(100),
  constraint pk_users primary key(id)
) charset=utf8 ENGINE=InnoDB;
 
create table role (
  id bigint auto_increment,
  name varchar(100),
  constraint pk_roles primary key(id)
) charset=utf8 ENGINE=InnoDB;
 
create table permission (
  id bigint auto_increment,
  name varchar(100),
  constraint pk_permissions primary key(id)
) charset=utf8 ENGINE=InnoDB;
 
create table user_role (
  uid bigint,
  rid bigint,
  constraint pk_users_roles primary key(uid, rid)
) charset=utf8 ENGINE=InnoDB;
 
create table role_permission (
  rid bigint,
  pid bigint,
  constraint pk_roles_permissions primary key(rid, pid)
) charset=utf8 ENGINE=InnoDB;
```
##### Shiro 加密 DONE

##### Shiro Web支持(Servlet) 略

##### Shiro SSM && 权限维护一套 && 基于URL配置权限 略

##### Shiro SpringBoot(重点项目) DOING

#### 虚拟机安装 Linux

#### docker

#### 消息中间件

#####

##### RabbitMQ
与 ActiveMQ 一样， RabbitMQ 也是一种消息中间件的实现。与之的区别在于，RabbitMQ 更专业，更灵活，大企业，大型高要求的应用，普遍会采用
RabbitMQ 来支持。
- RabbitMQ 安装
    - RabbitMQ 是基于 erlang 语言开发的，就如同 activemq 需要安装 java 环境一样， 为了使用 RabbitMQ 需要安装 erlang 环境。
    - 安装 erlang，配置环境变量(同 Java 环境变量)，终端运行 `erl`，显示版本信息即为安装成功。
    - 安装 RabbitMQ(官网下载安装)
    - 管理员身份停止重启 RabbitMQ：`net stop RabbitMQ && net start RabbitMQ`
    - 访问管理界面
        - http://127.0.0.1:15672
        - 账号：guest
        - 密码：guest
- RabbitMQ 模式讲解
    - AMQP
        - 与 activemq 不一样，rabbitmq 使用的是一种叫做 AMQP 的协议来通信。 AMQP 是 dvanced Message Queuing Protocol 的缩写。
    - 消息路由过程
        - 与 ActiveMQ 拿到消息就直接放在队列等待消费者拿走不同，Rabbit 拿到消息之后，会先交给 交换机（Exchange）, 然后交换机再根据预先设定
        的不同绑定( Bindings )策略，来确定要发给哪个队列。
    - 模式
        - RabbitMQ 提供了四种 Exchange 模式：fanout、direct、topic、header，header模式在实际使用中较少。
            - fanout 模式：fanout 模式就是广播模式，消息来了，会发给所有的队列。
            - Direct 模式：Direct 模式就是指定队列模式， 消息来了，只发给指定的 Queue, 其他Queue 都收不到。
            - Topic 模式：ActivityMQ 里的主题，更像是广播模式。