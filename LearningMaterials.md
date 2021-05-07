## 服务器更新说明

### 第一步

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\1.png)

打开application-druid.yml，将数据库名改成rouyi-vue（注意不是ruoyi-vue，因为我的数据库名一开始拼错了，😅），将数据库密码改成12345678。

### 第二步

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\2.png)

打包项目生成.jar文件

### 第三步

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\3.png)

找到上面的文件

### 第四步

打开网址：http://8.140.136.108:8888/8430cbb7

输入账号：$nocxn1fj$

密码：$6e250946$

进入一下页面

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\6.png)

点击左侧文件，点击根目录，再双击rouyi

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\7.png)

删除log.out文件

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\8.png)

重命名ruoyi-admin.jar文件，作为旧版本，这里重命名为ruoyi-admin0.2.jar​

上传第三步获得的文件

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\9.png)

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\11.png)

### 第五步

点击左侧菜单栏中的终端，输入cd /rouyi​

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\12.png)

接着输入nohup java -jar ruoyi-admin.jar > log.out &，然后回车，然后过两三秒之后再回车

如果在文件中出现了log.out则表示成功了

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\13.png)

双击打开log.out，如果最下面没有出现ruoyi图标，则表示出现问题(别慌，出现问题是正常的，每次都会出现)，出现ERROR就表示出现问题了

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\14.png)

点击终端，输入cd /rouyi，然后输入ps -ef | grep java

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\15.png)

输入kill -9 271629，（271629这个数字会变，看上一个操作出来的第一行出现的数字）

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\17.png)

然后重新输入nohup java -jar ruoyi-admin.jar > log.out &，然后回车，然后过两三秒之后再回车，再打开log.out文件查看是否成功，出现下面图片里的若依启动成功则表示成功了

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\18.png)

### 第六步

打开网址$8.140.136.108:80$,出现以下页面，点击取消

![](C:\Users\cpz2000\Desktop\软件工程课设说明\pic\19.png)

