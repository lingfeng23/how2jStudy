* DONE
###《Java 高级》
####反射机制（reflection）    DONE
getField和getDeclaredField的区别
- 这两个方法都是用于获取字段
- getField 只能获取public的，包括从父类继承来的字段。
- getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。 (注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true))
####注解（annotation）  DONE
    - Hibernate注解（annotation/hibernate）