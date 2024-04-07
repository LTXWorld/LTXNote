# Nginx快速入门

## 反向代理

VPN是正向代理，代理客户端；Nginx是反向代理，代理服务器<img src="/Users/lutao/GitT/Pic/image-20240405085054701.png" alt="image-20240405085054701" style="zoom:50%;" />

## 负载均衡

不同服务器加权轮询；不同服务器对于所有Session进行iphash操作

## 动静分离

提高资源加载速度

## 常用命令

- 启动Nginx：`nginx brew services start nginx`
- 停止服务：`nginx -s stop   brew services stop nginx`
- 测试配置文件：`nginx -t`

- 重载配置文件：`./nginx -s reload    brew service restart nginx`
- 查看服务状态：`brew services list`

## 操作举例

对于配置文件中的Server进行编辑即配置。

负载均衡使用upstream关键字

在这个配置中，`upstream` 指令定义了一个服务器组`kuangstudy`，其中包含两台服务器（`server1:8080`和`server2:8081`）。在`server`块中的`location`部分，`proxy_pass`将请求代理到了`kuangstudy`，根据定义的轮询策略在两个服务器间分配请求。

<img src="/Users/lutao/GitT/Pic/image-20240405092618884.png" alt="image-20240405092618884" style="zoom:50%;" /> 

location标志着请求路径

## 我的Nginx

我的Nginx使用Homebrew安装，安装目录在`/opt/homebrew/var/www/`

## 存在问题

1、负载均衡后面的服务器所提供的内容一样吗？

- 相同内容，为了保证用户体验一致。

