1、简介
Spring Cloud Gateway是Spring Cloud官方推出的第二代网关框架，取代Zuul网关。
网关作为流量的，在微服务系统中有着非常作用，网关常见的功能有路由转发、权限校验、
限流控制等作用。本文首先用官方的案例带领大家来体验下Spring Cloud的一些简单的功能，
在后续文章我会使用详细的案例和源码解析来详细讲解Spring Cloud Gateway.

1)协议转换，路由转发
2)流量聚合，对流量进行监控，日志输出
3)作为整个系统的前端工程，对流量进行控制，有限流的作用
4)作为系统的前端边界，外部流量只能通过网关才能访问系统
5)可以在网关层做权限的判断
6)可以在网关层做缓存

2、启动springboot项目，在浏览器上输入  http://localhost:8080/get
(headers 中有添加以hello为key的键值对)

3、在命令行中执行   curl --dump-header - --header Host: www.hystrix.com http://localhost:8080/delay/3
(响应回来的就是fallback字符串)


4、Predicate来自于java8的接口。Predicate 接受一个输入参数，返回一个布尔值结果。该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）。可以用于接口请求参数校验、判断新老数据是否有变化需要进行更新操作。add–与、or–或、negate–非。
![Image text](https://upload-images.jianshu.io/upload_images/12191355-7c74ff861a209cd9.png)

5、实现自定义过滤器   继承AbstractGatewayFilterFactory
![Image_text](https://upload-images.jianshu.io/upload_images/2279594-f97e1045cebc954c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

6、global filter  
Spring Cloud Gateway根据作用范围划分为GatewayFilter和GlobalFilter，二者区别如下：

GatewayFilter : 需要通过spring.cloud.routes.filters 配置在具体路由下，只作用在当前路由上或通过spring.cloud.default-filters配置在全局，作用在所有路由上

GlobalFilter : 全局过滤器，不需要在配置文件中配置，作用在所有的路由上，最终通过GatewayFilterAdapter包装成GatewayFilterChain可识别的过滤器，它为请求业务以及路由的URI转换为真实业务服务的请求地址的核心过滤器，不需要配置，系统初始化时加载，并作用在每个路由上。
![Image_text](https://raw.githubusercontent.com/guofazhan/image/master/GlobalFilter.png)

在命令行中进行测试 curl localhost:8080/customer?token=111

