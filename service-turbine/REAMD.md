Hystrix Turbine简介
看单个的Hystrix Dashboard的数据并没有什么多大的价值，要想看这个系统的Hystrix Dashboard数据就需要用到Hystrix Turbine。Hystrix Turbine将每个服务Hystrix Dashboard数据进行了整合
1、分别启动eureka-server、不同端口的eureka-client来充当服务角色(端口分别是:8762、8763)、service-turbine程序
(你如果自定义服务名称,同时也要更改对应的配置文件)


2、依次请求:
1)http://localhost:8762/hi?name=forezp  (你是开启的是不同端口的同一程序,你需要以不同端口来进行访问,否则只能显示单个服务,turbuine就没有任何意义)
2)在 http://localhost:8763/hystrix 对应输入 http://localhost:8764/turbine.stream  2000  miya  点击monitor stream 进入页面
3)可以看到这个页面聚合了2个service的hystrix dashbord数据。