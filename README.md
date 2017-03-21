# MyActionbar
在日常的工作中，ActionBar使用的频率非常的高，而系统自带的ActionBar捆绑的东西有太多，而上面多数的效果我们都用不到。

如果不用系统的ActionBar，我们该怎样把自定义ActionBar的工作做到最简化呢。

这里就分享一下我在项目中的做法。

效果如图：
![image](https://github.com/yanjunhui2014/MyActionbar/blob/master/picture/simple.png)
![image](https://github.com/yanjunhui2014/MyActionbar/blob/master/picture/gif.gif)

编程思想：

1、编写好包含左菜单、标题、右菜单的 布局文件，<include .../> 到实现的 layout文件中。同时在BaseActivity中封装相关方法，在具体Activity中调用；

2、自定一个View，该View 包含所有ActionBar的元素（左菜单、标题、右菜单），然后作为一个widget使用；

3、扩展：略。