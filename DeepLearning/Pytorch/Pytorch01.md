# Pytorch实战01

## 在macbook上安装Pytorch

进入Pytorch官网发现其直接根据机器类型给出了安装方法，

### 1、直接在本机系统中使用`pip3`安装

![image-20240204111340863](/Users/lutao/GitT/Pic/image-20240204111340863.png)

- 可以发现由于macbook没有cuda，所以只能安装Default版本。

### 2、在自己的conda环境下进行安装（类比jupyter notebook)

- 首先老命令了，查看当前的conda环境都有什么，决定在Jupyter的环境中安装pytorch

```bash
conda env list
conda activate jupyter_env #退出时使用conda deactivate
#再使用官网的关于conda的指令进行安装
```

![image-20240204114126561](/Users/lutao/GitT/Pic/image-20240204114126561.png)

### 突发奇想的问题

这张截图中的Package中的东西和Compute Platform中的东西都是什么？

- 例如Conda、Pip这些是Python的包管理器，可以类比于Java中的maven包管理器
- CUDA是英伟达的计算平台，而对于我的macbook只能使用默认选项（即CPU而非GPU）
- tmd这么一看是不是9k买macbook亏了，9k应该能买到一个足以进行机器学习的windows？

## 稍微了解基础

### Tensor格式

与Numpy很类似，从ndarrary来到了tensor格式。

### 自动计算反向传播

### 线性回归demo

```python
x_values = [i for i in range(11)]
x_train = np.array(x_values, dtype = np.float32)
x_train = x_train.reshape(-1, 1)#其中1的意思是列维度上只有一个元素，即每行只有一列；-1意味着numpy会自动进行计算剩下的维度（即有几行）
#构建y=2x+1
y_values = [2*i + 1 for i in x_values]
y_train = np.array(y_values, dtype=np.float32)
y_train = y_train.reshape(-1,1)
y_train.shape
#定义线性回归模型，在其中使用到了一个线性层是全连接层
import torch.nn as nn
class LinearRegressionModel(nn.Module):
    def __init__(self, input_dim, output_dim):
        super(LinearRegressionModel, self).__init__()
        self.linear = nn.Linear(input_dim, output_dim)#构造函数需要用到了什么层，就在这里写什么层
    def forward(self, x):
        out = self.linear(x)#前向传播层具体是怎么走的，同理用到了什么层写什么层
        return out
#定义了模型的输入和输出维度，二者全为1是一个典型的线性回归模型，预测一个连续的数值
input_dim=1
output_dim =1
model = LinearRegressionModel(input_dim, output_dim)
#指定轮数，学习率，优化器和损失函数
epochs = 1000
learning_rate = 0.01
optimizer = torch.optim.SGD(model.parameters(), lr=learning_rate)
criterion = nn.MSELoss()
#开始进行线性回归
for epoch in range(epochs):
    epoch += 1
    #将ndarray转换为tensor张量
    inputs = torch.from_numpy(x_train)
    labels = torch.from_numpy(y_train)
    #进行梯度的清零，防止每次的梯度累计——因为默认情况下，梯度是累加的
    optimizer.zero_grad()
    #得到实例的输出
    outputs = model(inputs)
    #计算损失函数
    loss = criterion(outputs, labels)
    #对损失函数进行反向传播，根据损失函数计算每个参数的梯度——损失相对于每个参数的局部变化率，它指示了损失最快减小的方向。
    loss.backward()
    #应用所得到的梯度更新权重，会朝着损失减小的方向移动（这里更新的参数就是权重和偏置）
    optimizer.step()
    if epoch % 50 == 0:
        print('epoch {}, loss{}'.format(epoch, loss.item()))
```

#### 保存并读取模型

保存其权重和偏置参数

```python
torch.save(model.state_dict(),'model.pkl')
model.load_state_dict(torch.load('model.pkl'))
```

### Pytorch的好处

设计模型时只需要把前向传播写好，反向传播软件会自动进行。

### 不同形状的Tensor

#### Scalar

通常就是一个数值

```python
x = tensor(42.)
x.dim
2*x
x.item
```

#### Vector

一个向量，通常指一个特征；一组值的集合。

#### Matrix

多个特征组合在一起，成为矩阵。

#### 更高维

图像和文字都是三维数据

## Hub模块

在Pytorch官网中以及github上已经存在了许多已有的模型

<img src="../../Pic/image-20240205200555888.png" alt="image-20240205200555888" style="zoom:50%;" />