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

#### 部署到 Linux

#### WebSocket

#### QRCode(qrcode) DONE
* 使用 Java 生成以及解析二维码
* 使用 JavaScript 方式创建二维码

#### 搜索引擎技术

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

#### Shiro

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