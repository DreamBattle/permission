项目搭建配置流程：
1.在pom.xml文件中引入相关依赖
2.在web.xml文件中配置引用上下文
3.配置spring-servlet.xml
4.配置applicationContext.xml
5.配置mybatis-config.xml
6.配置logback.xml（IntelliJ IDEA 注解@Slf4j后找不到log，在IntelliJ IDEA上安装lombok插件重启可以解决）

项目准备：
1.mybatis generate核心类生成
2.项目接口定义 common.JsonData -json,page
3.全局异常处理类 common.SpringExceptionReslover, Exception.PermissionException
4.校验工具-validator
5.Json转换工具-Jackon convert
6.获取Spring上下文
7.Http请求前后监听HttpInterceptor



