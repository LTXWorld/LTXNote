# LT学Git
## 直接上手
###创建Git仓库
- 先创建了一个文件夹用来作为git仓库文件夹
- 使用`git init`命令将文件夹变为Git可以管理的仓库——目前是一个空仓库，但其中有`.git`文件（**跟踪管理版本库**）
- 然后试着"给仓库里写文件"，这里用到了`echo`命令，（发现mac和windows里面这条指令是一样的，反倒是展示所有文件不一样，一个是`ls`一个是`dir`

###将文件放到Git仓库
分为两步
- 接着将文件**添加到**仓库中`git add xxx.txt`
- 使用commit命令告诉Git，将文件**提交到**仓库中`git commit -m "xxxxx"`(后面的-m是*本次提交的说明*)
- 总结一下：`add`操作是一种**暂存操作**，`commit`操作是**已暂存未提交状态**；add一次能add很多个文本文件，commit可以一次性将暂存区的全部提交

###修改文件，查询状态：
- 在macos中，我通常使用vim在终端里修改某个文本文件（但是如果是一个很长的笔记文件呢），修改过后可以通过git==查看状态==：`git status`每进行一步操作都可以查看当前状态——更细节一点，做两s次对比：工作区vs暂存区  暂存区vs仓库
- 想查看到底==修改了什么==：`git diff`——本质是*工作区和暂存区*的差异

###时光机穿梭（版本回退）：
- 对文件进行不断地修改之后，通过`git log`查看更改的历史记录（这时之前在commit -m后面写的注释就起作用了）；前面出现的一长串数字是每一次更改的**版本号**
- 如何回退：==HEAD代表了当前最新版本，可以把HEAD理解为一个指针==，使用`git reset --hard HEAD^`回退到上一个版本（一个^是一个版本）
- 如何再返回：这时就需要用到每次的**版本号**了`git reset --hard xxxx`
- 如果关机了呢，如何查看版本号：`git reflog`会记录你的每一次命令

####出状况了：
- windows怎么在回退时给我回复了一句more？
- 原因：windows中将^符号认作了转义字符，所以还是建议使用`HEAD~n`来代替回退多少

###工作区和暂存区：
- 暂存区（stage）+ 分支仓库（master)
- 进行add之后      <img src="/Users/lutao/Documents/LTXWorld.github.io/assets/blog_res/image-20231101103713597.png" alt="image-20231101103713597" style="zoom:50%;" />
- 进行commit之后<img src="/Users/lutao/Documents/LTXWorld.github.io/assets/blog_res/image-20231101103744148.png" alt="image-20231101103744148" style="zoom:50%;" />
- 详解status和diff：<img src="/Users/lutao/Documents/LTXWorld.github.io/assets/blog_res/image-20231101104644468.png" alt="image-20231101104644468" style="zoom:50%;" />
- 对于刚刚更改过的文件，status显示其还没在暂存区里也还没有提交；对于新建的文件，显示未被跟踪除非你暂存。

###Git管理的是修改而不是文件：
- 其实这句话就在讲整个Git的结构，==工作区-暂存区-仓库==。
- 你的修改只有先放在暂存区（add）才会被最终送到（commit）仓库。
- ps mac使用`cat`来显示文件内容；windows使用`type`显示

###撤销修改：
首先其实这些操作在每次`git status`时Git都会给出相应的提示的。
-  在工作区还未add时：`git restore filename`
-  已经在暂存区但还没commit时：`git restore --staged filename`*但会保留工作区的更改*
-  同时撤销工作区和暂存区的更改：`git restore --source=HEAD --staged --worktree <file>`
-  撤销仓库的更改：就是上面的版本回退`git reset --hard HEAD~1`

###删除文件
- 普通删除：`rm filename`
- 这时*会导致Git仓库和工作区的内容不一样*，会出现两种选择：
	1. 撤销这次删除：`git checkout -- file`,用版本库里的版本替换工作区中的版本
	2. 确认这次删除，并提交：`git rm file`+`git commit -m "descrbition"

##Git的独到优势：
### 利用Github作为远程库
- 可以在不联网状态下在本地工作，有网络了之后再统一提交到远程库当中。
- 碰到将远程库克隆到本地时我出现了疑问：那如果每个人都对文件进行了很多的更改，我该去看谁的呢，最终的样子会成什么样呢？（当然我自己的需求是：平时既要用macbook进行编程，笔记又要用windows进行，那么我希望每次打开某个笔记或者程序都是一个最新的版本。对我的需求好像比较简单，我认为无论是哪个设备，每次写完一个笔记或者程序时，我只需要按时将他们add到暂存区再commit到本地仓库，最后push到github的远程仓库即可，当然每次使用前需要知道此时的仓库是最新的版本。）
- 这就引出了分支管理这一问题

###分支管理
####创建和合并分支
- 如何理解分支：本质是==当前某个特定提交的指针==，主分支是仓库的默认分支，包含着*生产就绪*的代码
- 发生了什么：master指针指向主分支，HEAD指针指向当前操作的分支，而创建了新分支之后，就会去**操作新分支指针，master指针原地不动**;合并时直接将master指向当前指针即可
- 重要操作：
```bash
git branch//查看分支
git branch name//创建分支
git checkout name//切换分支
git merge name//合并xxx到现在的分支
git branch -d name//删除指定的分支
```

注意：*当你想要删除当前分支时，你得先回到主分支*
####解决冲突：
- 解决冲突的关键是*手动编辑文件，选择正确的更改，合并分支，并告诉Git已经完成了解决。*（使用`git status`会出现详细的冲突信息）
- 下面是出现冲突时执行`cat xxx.txt`的执行结果：
```bash
<<<<<<< HEAD
(你的更改)
=======
(对方的更改)
>>>>>>> (对方的分支名)
```
- 当你在两个分支都进行了更改并提交到本地库时：  <img src="/Users/lutao/Documents/LTXWorld.github.io/assets/blog_res/image-20231101200649104.png" alt="image-20231101200649104" style="zoom:50%;" />
- 合并之后（经历了更改再提交）的结果：<img src="/Users/lutao/Documents/LTXWorld.github.io/assets/blog_res/image-20231101200829939.png" alt="image-20231101200829939" style="zoom:50%;" />

