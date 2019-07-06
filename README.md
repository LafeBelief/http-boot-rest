# 通过 api 接口重启SpringBoot应用程序

## 原因：
       在项目实际生产环境中，有时需要 重启 springboot 接口，此时 如果可以一键重启，那岂不是很方便。


## 描述：
   重启Spring Boot应用程序的关键步骤是对主类中SpringApplication.run(Application.class,args);方法返回值的处理。通过查看官方文档可以看到，ConfigurableApplicationContext接口类中定义了一个close()方法，可以用来关闭当前应用的上下文。在应用程序的main()方法中，我们可以使用一个临时变量来存放SpringApplication.run()返回的ConfigurableApplicationContext对象，当我们完成对Spring Boot应用程序中属性的设置后，调用ConfigurableApplicationContext的#close()方法，最后再调用SpringApplication.run()方法重新给ConfigurableApplicationContext对象进行赋值已达到重启的效果。

 简而言之，先关闭  application 程序，在启动 application。
## 
### 启动测试：

*  第一次访问  /info 返回 appBoot 。
*  第二次访问  /refresh。
*  第三次访问  /info 返回 SPRING-DYNAMIC-SERVER 。

## csdn
  https://blog.csdn.net/qq_41497111/article/details/94843391
