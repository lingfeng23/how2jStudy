## 《一本糊涂账》

本项目是基于Swing和JDBC开发的图形界面桌面应用，涵盖了J2SE的绝大部分基础知识。

涉及到如下内容：
- 基础内容：
    - 面向对象 字符串数字 日期

- 中级内容：
    - 异常 ，集合，JDBC, 反射机制，I/O，Swing， 利用TableModel更新数据, 图形界面的皮肤

- 高级内容：
    - 图表chart动态生成，数据库的备份与恢复，自定义圆形进度条

- 软件设计思想：
    - 单例模式，面板类与监听器类松耦合，Entity层设计，DAO层设计，Service层设计

- 业务常见处理手法：
    - CRUD操作，配置信息，配置信息初始化，报表生成，一对多关系，多对一关系

### 表结构设计

创建数据库
```
create database how2java;
```
根据业务需要，有三个表：
- 配置表信息 config
    - 用于保存每月预算和Mysql的安装路径( 用于备份还原用)
- 消费分类表 category
    - 用于保存消费分类，比如餐饮，交通，住宿
- 消费记录表 record
    - 用于存放每一笔的消费记录，并且会用到消费分类
    
表结构及关系参考：
```
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `key_` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置信息的键',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置信息的值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `spend` int(11) NULL DEFAULT NULL COMMENT '本次消费',
  `cid` int(11) NULL DEFAULT NULL COMMENT '消费分类ID',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `date` date NULL DEFAULT NULL COMMENT '消费时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_record_category`(`cid`) USING BTREE,
  CONSTRAINT `fk_record_category` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```

### 原型-基础
- 首先是Frame
    * 整个程序只有一个主Frame，所以把这个类规划到包 frame下

- 然后是Panel
    * JFrame本身有一个Panel，然后每一个功能模块都有一个Panel，所以把这些Panel规划到 panel下面去

- 接着是Listener
    * 把所有的监听器，都做成独立的类，实现ActionListener接口，并放在 listener包下

- 最后是Model
    * Model用于存放数据，在这个项目中会用到TableModel和ComboBoxModel，放在 model包下

#### 单例的面板类
各种按钮监听器的主要作用是获取组件的值，和修改组件的值。

如何使得监听器可以方便得获取组件？
    - 1. 在面板类中，把组件声明为public的属性
    - 2. 把面板类设计为单例模式

#### 居中面板
CenterPanel

#### GUIUtil
GUIUtil

#### ColorUtil
ColorUtil

#### CircleProgressBar
CircleProgressBar

#### ChartUtil
ChartUtil

#### 图片资源

### 原型-界面类

#### MainPanel
MainPanel

#### SpendPanel
SpendPanel

#### RecordPanel
RecordPanel

#### CategoryPanel
CategoryPanel

#### ReportPanel
ReportPanel

#### ConfigPanel
ConfigPanel

#### BackupPanel
BackupPanel

#### RecoverPanel
RecoverPanel

#### MainFrame
MainFrame

### 实体类和DAO

#### 实体类Entity

#### DBUtil

#### DateUtil

#### ConfigDao && CategoryDao && RecordDao
ConfigDao && CategoryDao && RecordDao
 
### 功能

#### 启动类Bootstrap

#### 主窗体工具栏

#### 配置

#### 消费分类

#### WorkingPanel

#### 记一笔

#### 消费一览

#### 月消费报表



