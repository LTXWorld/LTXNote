# Mysql01 下载运行Mysql
## 问题：
- 首先，从官网下载的时zip文件，存在的`install`的软件的页面与教程中的页面完全不同，根本不是自定义安装的页面。
- zip文件的坏处就是得自己手动进行配置，比如数据存放的文件路径，以及其他文件存放的路径，甚至是端口号，密码等等。
- 所以向GPT咨询了如何进行手动初始化配置。

## 解决：
### 手动配置：
- 手动配置`my.ini`文件（即包含了所有配置的文件）；所以什么是ini文件？**初始化文件！！！**
- **INI档案**是一种无固定标准格式的[设定档](https://zh.wikipedia.org/wiki/設定檔)。它以简单的文字与简单的结构组成，常常使用在[Windows作业系统](https://zh.wikipedia.org/wiki/Windows操作系统)上，许多程式也会采用INI档案做为设定档之用。Windows作业系统后来以[登录档](https://zh.wikipedia.org/wiki/登錄檔)的形式取代掉INI档。INI档案的命名来源，是取自英文“初始（Initial）”的首字缩写，正与它的用途——初始化程式相应

```ini
[mysqld]
# Set the port number
port=3306

# Set the MySQL installation directory
basedir="E:/Mysql"

# Set the directory for storing the data
datadir="E:/Mysql/data"

# Default character set
character-set-server=utf8mb4

# The maximum number of connections
max_connections=151

```
### 如何启动Mysql
- 完成`ini`文件之后我们需要进行命令行的初始化，首先我们得在对应安装的文件夹里的`bin`文件夹下进行操作。（最后我选择了不安全模式，因为我只在学习阶段所以在自己的电脑上操作即可）

```sh
mysqld --initialize-insecure --user=mysql
mysqld --initialize --user=mysql # 后者是root下的需要密码的更安全的模式

```

- 安装mysql服务，也可以为这个服务命名。

```sh
mysqld --install
mysqld --install [服务名]
```

- 登录到mysql服务器（这一步最为重要，要记得操作多一些）
- 以后再启动mysql时是不是只需要这一步就行了？
```sh
mysql -u root -p --port=3306 # 这里有更为普遍的操作要求，待补充
```
### 配置环境变量
- 为什么要配置环境变量呢？因为此时的mysql只在我们的安装文件夹中生效，我不想每次都要进入bin目录后才能调用mysql。
- 所以设置环境变量为当前bin文件夹所在的路径。这样**无论我在任何的路径下都可以直接去调用**`mysql`