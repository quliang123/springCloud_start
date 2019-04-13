在微服务架构中为例保证程序的可用性，防止程序出错导致网络阻塞，出现了断路器模型。
断路器的状况反应了一个程序的可用性和健壮性，它是一个重要指标。
Hystrix Dashboard是作为断路器状态的一个组件，提供了数据监控和友好的图形化界面。

1、在请求http://localhost:8762/actuator/hystrix.stream之前，
需要随便请求一个接口，例如： http://localhost:8762/hi?name=forezp，否则会一直ping ping ping

2、http://localhost:8762/hystrix  依次填入http://localhost:8762/actuator/hystrix.stream 、2000 、miya


3、 在另外一个窗口访问: http://localhost:8762/hi?name=forezp

4、重新刷新 步骤二  中的网页，你会看到良好的图形化界面
