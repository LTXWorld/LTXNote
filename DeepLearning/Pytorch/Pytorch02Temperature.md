# Pytorch02Temperature

## 数据处理

### 独热编码处理

```python
# 独热编码
features = pd.get_dummies(features)
features.head(5)
```

使用了Pandas库中的`get_dummies`函数来对`features` DataFrame进行独热编码。

- 将**分类变量**（而不是数值类型）转换为机器学习模型可以理解的形式的过程。它为每个类别创建一个新的二进制列，如果原始数据中的记录属于该类别，则在对应列中用1表示，否则用0表示。
- 例如，如果有一个名为`color`的特征，它的值是`red`和`blue`，`get_dummies`会创建两列：`color_red`和`color_blue`

### 标准化处理

```python
from sklearn import preprocessing
input_features = preprocessing.StandardScaler().fit_transform(features)
```

- `preprocessing` 模块提供了多种数据预处理功能，包括缩放、中心化、归一化和二值化等。
- `fit_transform(features)` 函数对 `features` 数据集进行拟合和转换
- `preprocessing.StandardScaler()` 创建了一个 `StandardScaler` 对象。`StandardScaler` 是用于标准化数据的工具

### 构建网络模型

