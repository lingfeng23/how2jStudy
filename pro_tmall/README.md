## 天猫整站(SpringBoot版本)

### 基础

### 需求分析

#### 展示

#### 交互

#### 后台

### 表结构设计

### 原型设计

### 后台

#### 后台-分类管理
- AdminPageController.java
    - 因为是做前后端分离，所以数据是通过 RESTFUL接口来取的，而在业务上，除了 RESTFUL 服务要提供，还要提供页面跳转服务，所以所有的后台页面跳转都放在 AdminPageController 这个控制器里。 而RSTFUL 专门放在 Category 对应的控制器 CategoryController.java 里面。 
- CORSConfiguration.java
    - 因为是二次请求，第一次是获取 html 页面， 第二次通过 html 页面上的 js 代码异步获取数据，一旦部署到服务器就容易面临跨域请求问题，所以允许所有访问都跨域，就不会出现通过 ajax 获取数据获取不到的问题了。
- GloabalExceptionHandler.java
    - 异常处理，主要是在处理删除父类信息的时候，因为外键约束的存在，而导致违反约束。