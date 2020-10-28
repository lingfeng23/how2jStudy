## Java框架-Spring

### IOC DONE

### AOP DONE

AOP 即 Aspect Oriented Program 面向切面编程

首先，在面向切面编程的思想里面，把功能分为核心业务功能和周边功能。
- 所谓的核心业务，比如登陆，增加数据，删除数据都叫核心业务
- 所谓的周边功能，比如性能统计，日志，事务管理等等

周边功能在Spring的面向切面编程AOP思想里，即被定义为切面

在面向切面编程AOP的思想里面，核心业务功能和切面功能分别独立进行开发
然后把切面功能和核心业务功能 "编织" 在一起，这就叫AOP