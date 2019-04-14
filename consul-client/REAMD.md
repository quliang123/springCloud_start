一、consul 简介
consul 具有以下性质：

服务发现：consul通过http 方式注册服务，并且服务与服务之间相互感应。
服务健康监测
key/value 存储
多数据中心

二、去官网下载：https://www.consul.io/downloads.html
解压：


三、设置环境变量：

1、计算机  右键  属性 高级属性设置环境变量设置

2、在path下加上：D:\123\Software\consul_1.4.4_windows_amd64
(path添加的路径就是下载下来的exe文件)

3、cmd启动：consul agent -dev

可以看到启动成功。

四、打开网址：http://localhost:8500 ，可以看到界面，相关服务发现的界面。