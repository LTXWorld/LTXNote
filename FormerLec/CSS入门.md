# CSS入门
## 何为CSS
- Cascading Style Sheet 层叠样式表
- CSS作为表现形式出现，（HTML是结构化格式）因为在2.0版本提出的二者分离的观念：  **内容和表现分离**  <img src="./../Pic/image-20231105231705591.png" alt="image-20231105231705591" style="zoom:50%;" />
- 本入门教程**最重要学习的是选择器**

## 快速入门：
- 一些语法规范：一般css和html文件都是分离的，css有其规范（例如重要的选择器）；二者可以通过link标签进行链接*（外部样式）*
- 分别在html和css中的代码：，如果二者写在一起，css是写在head里面的
```html
<head>
    <meta charset="UTF-8">
    <title>入门练习没有分离</title>

     <!-- style可以编写css的代码，目前是没有分离的
     语法：
        选择器{
          声明1;
          声明2；
        }
        每一个声明最好使用分号结尾
        链接css和html使用link标签，外部引用
     -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>


<h1>我是标题</h1>

</body>
```
```css
h1{
    color: aquamarine;
}
```
### 四种导入（链接）方式：
- 行内样式、内部样式、外部样式
- 优先级**遵循就近原则**，一般行内样式都是最近的。*后两者看谁在最下面*
```html
<head>
    <meta charset="UTF-8">
    <title>四种导入方式</title>
  <link rel="stylesheet" href="css2.css">
  <!--内部样式 -->
  <style>
    h1{
      color: green;
    }
  </style>

</head>
<body>
<!-- 行内样式，在标签元素中编写一个style属性，编写样式-->
<h1 style="color: blue">我是行内样式</h1>
</body>
```