# 1

## Maven作用

### 管理Jar包

从镜像网站或者中央仓库下载库，且处理库之间的关系，避免版本冲突。使用坐标完成。

### 构建工具

java—jar包；web—war包

IDEA会自动构建，但是服务器上是Linux需要Maven来构建项目。

## 原理

需要三种jar包，自己工程中的jar包、网络上下载的jar包、maven插件需要使用的jar包

## 重要概念GAVP

这些元素一起，确保了**每个 Maven 项目和库的唯一性**，并允许 Maven 正确地构建项目并管理依赖项。当你在 Maven 中添加一个依赖时，通常需要指定 GAV，即 Group ID，Artifact ID 和 Version，Packaging 通常是可选的，因为大多数依赖项都是 jar 文件。

<img src="../Pic/image-20240110174820212.png" alt="image-20240110174820212" style="zoom:50%;" />

<img src="../Pic/image-20240110174838494.png" alt="image-20240110174838494" style="zoom:50%;" />