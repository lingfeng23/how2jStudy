## 分布式和集群

### 单体架构例子(product-service) DONE
- 项目很简单，就做两件事： 1. 提供数据 2. 展示数据。 这就是一个典型的单体结构。

  它把两个服务"提供数据"和"展示数据"放在了一起，这就会出现固有的缺点。
    - 如果要修改数据部分的代码， 那么必须把整个项目重新编译打包部署。 虽然展示部分，什么都没变但是也会因为重新部署而暂时不能使用，要部署完了，才能使用。
    - 如果提供数据部分出现了问题，比如有的开发人员改错了，抛出了异常，会导致整个项目不能使用，展示数据部分也因此受到影响。
    - 性能瓶颈难以突破
    - 等等。。。

### 分布式和集群 DONE

#### 微服务概念
微服务简单说，一个 springboot 就是一个 微服务，并且这个 springboot 做的事情很单纯。 

比如 product-service 这个项目，就可以拆成两个微服务，分别是"数据微服务"和"视图微服务"，其实就是俩 springboot, 只是各自做的事情都更单纯。

#### 服务注册
有了微服务，就存在如何管理这个微服务，以及这两个微服务之间如何通信的问题，所以就要引入一个"微服务注册中心"概念，这个微服务注册中心在 springcloud
里就叫做 eureka server, 通过它把就可以把微服务注册起来，以供将来调用。

#### 服务访问
在业务逻辑上，"视图微服务"需要"数据微服务"的数据，所以就存在一个微服务访问另一个微服务的需要。

而这俩微服务已经被注册中心管理起来了，所以"视图微服务"就可以通过"注册中心"定位并访问"数据微服务"了。

#### 分布式概念
在一个 springboot 里就完成的事情，现在分布在多个 springboot 里做。
- 如果我要更新数据微服务，视图微服务是不受影响的
- 可以让不同的团队开发不同的微服务，他们之间只要约定好接口，彼此之间是低耦合的。
- 如果视图微服务挂了，数据微服务依然可以继续使用 

#### 集群
原来数据微服务只有这一个springboot, 现在做同样数据微服务的有两个 springboot, 他们提供的功能一模一样，只是端口不一样，这样就形成了集群。
- 比起一个 springboot, 两个 springboot 可以分别部署在两个不同的机器上，那么理论上来说，能够承受的负载就是 x 2. 这样系统就具备通过横向扩展而
提高性能的机制。
- 如果 8001 挂了，还有 8002 继续提供微服务，这就叫做高可用 。

#### 分布式和集群周边服务
- 哪些微服务是如何彼此调用的？ sleuth 服务链路追踪
- 如何在微服务间共享配置信息？配置服务 Config Server
- 如何让配置信息在多个微服务之间自动刷新？ RabbitMQ 总线 Bus
- 如果数据微服务集群都不能使用了，视图微服务如何去处理? 断路器 Hystrix
- 视图微服务的断路器什么时候开启了？什么时候关闭了？ 断路器监控 Hystrix Dashboard
- 如果视图微服务本身是个集群，那么如何对他们进行聚合监控？ 断路器聚合监控 Turbine Hystrix Dashboard
- 如何不暴露微服务名称，并提供服务？ Zuul 网关

### 父子项目 DONE

### 服务注册中心 DONE

### 注册数据微服务 DONE

### 视图微服务-Ribbon
- 访问前面注册好的数据微服务， SpringCloud 提供了两种方式，一种是 Ribbon，一种是 Feign。
- Ribbon 是使用 restTemplate 进行调用，并进行客户端负载均衡。 
    - 什么是客户端负载均衡呢？ 
    - 在前面"注册数据微服务"里，注册了8001和8002两个微服务，Ribbon 会从注册中心获知这个信息，然后由 Ribbon 这个客户端自己决定是调用哪个，这个
    就叫做客户端负载均衡。
- Feign 是什么呢？ 
    - Feign 是对 Ribbon 的封装，调用起来更简单。

#### Ribbon 调用过程解读
- 首先数据微服务和视图微服务都被 eureka 管理起来了。
- 数据服务是由两个实例的集群组成的，端口分别是 8001，8002
- 视图微服务通过注册中心调用微服务，然后负载均衡到 8001 或者 8002 端口的应用上。

### 视图微服务-Feign
Feign 是对 Ribbon的封装，使用注解的方式，调用起来更简单，也是主流的方式。

#### Feign 调用过程解读
- 首先数据微服务和视图微服务都被 eureka 管理起来了。
- 数据服务是由两个实例的集群组成的，端口分别是 8001，8002
- 视图微服务通过注册中心调用微服务，然后负载均衡到 8001 或者 8002 端口的应用上。

### 服务链路追踪
通过 zipkin 服务链路追踪服务器这个东西来用图片进行识别微服务之间的调用关系
- 操作步骤
    - 运行启动 /parent/lib 下的 zipkin-server-2.10.1-exec.jar
    ```
    java -jar zipkin-server-2.10.1-exec.jar
    ```
    - 挨个启动 eureka-server, 改造后的 product-data-service 和 product-view-service-feign
    - 访问一次 http://127.0.0.1:8012/products 通过 视图微服务去访问数据微服务，这样链路追踪服务器才知道有这事儿发生
    - 然后打开链路追踪服务器 http://localhost:9411/zipkin/dependency/ 就可以看到视图微服务调用数据微服务的图形了。
    
### 配置服务器
配置服务的需要
- 有时候，微服务要做集群，这就意味着，会有多个微服务实例。在业务上有时候需要修改一些配置信息，比如说版本信息吧，倘若没有配置服务，那么就需要挨个修改
微服务，挨个重新部署微服务，这样就比较麻烦。
- 为了偷懒，这些配置信息就会放在一个公共的地方，比如 git，然后通过配置服务器把它获取下来，然后微服务再从配置服务器上取下来。
- 这样只要修改 git 上的信息，那么同一个集群里的所有微服务都立即获取相应信息了，这样就大大节约了开发，上线和重新部署的时间了。
步骤
- git 上准备好配置文件
    - https://github.com/lingfeng23/how2jStudy/blob/master/respo/product-view-service-feign-dev.properties
    ```
    version = malf springcloud version 1.0
    ```
- 创建配置服务器微服务(config-server)
- application.yml 中配置
```
spring:
  application:
    name: config-server
  cloud:
    config:
      # label 表示分支
      label: master
      server:
        git:
          # uri 表示 git 地址
          uri: https://github.com/lingfeng23/how2jStudy
          # searchPaths 表示目录
          searchPaths: respo
```
- 启动项目访问 http://localhost:8030/version/dev
- 显示如下内容就表示配置服务准备好了
    - {"name":"version","profiles":["dev"],"label":null,"version":"d1ab60fab7daa717eca40119d8a8014a93950214","state":null,"propertySources":[]}

### 配置客户端 DONE

### 消息总线 Bus DONE
RabbitMQ
- SpringCloud 通过 RabbitMQ 来进行消息广播，以达到有配置信息发生改变的时候，广播给多个微服务的效果。
- 对服务链路追踪的影响
    - 因为视图服务进行了改造，支持了 rabbitMQ, 那么在默认情况下，它的信息就不会进入 Zipkin了。 在Zipkin 里看不到视图服务的资料了。
    - 为了解决这个问题，在启动 Zipkin 的时候带一个参数就好了：--zipkin.collector.rabbitmq.addresses=localhost
    ```
    java -jar zipkin-server-2.10.1-exec.jar --zipkin.collector.rabbitmq.addresses=localhost
    ```
 
### 断路器 HYSTRIX DONE
所谓的断路器，就是当被访问的微服务无法使用的时候，当前服务能够感知这个现象，并且提供一个备用的方案出来。

### 断路器监控 DONE

### 断路器聚合监控 DONE

### 网关 DONE
