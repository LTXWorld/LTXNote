# 二叉树在Java中存在

## 集合框架应用：

- **集合框架**：例如，在Java的`TreeMap`和`TreeSet`中，内部往往利用红黑树（一种自平衡的二叉搜索树）来实现。这些集合通过二叉树提供了高效的查找、插入和删除操作。
- **算法设计**：二叉树用于实现多种高效算法，如二叉树遍历、深度优先搜索（DFS）、广度优先搜索（BFS）等。

## 经典的二叉树

- 满二叉树，完全二叉树通过特定的**插入和遍历**方式维护
- 普通的二叉搜索树在最坏情况下可能会退化为链表，因此在实际应用中经常使用**自平衡的二叉搜索树，如AVL树或红黑树**。
- 一般二叉树结点的定义：

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```

