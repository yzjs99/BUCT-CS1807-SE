# 后台管理子系统

## 任务目标

按照教师给出的软件工程题目要求，本小组的任务为：

>主要包括：
>1）用户管理：管理后台用户信息、后台管理员日志、手机端用户信息。如增加管理员，修改管理员密码，禁止一个发布过非法评论的手机端用户再次发布评论等。
>2）讲解审核：审核用户上传的讲解。
>3）数据管理：管理1-4系统中涉及所有数据，如一个博物馆的基本信息、展览信息、藏品信息、新闻信息、讲解信息、评论等。例如，删除一个用户发布的非法评论信息。
>4） 数据备份和恢复：支持本系统的数据库和服务器端重要文件的备份和恢复。

## 小组概况

本小组现有六名成员

## 小组周报

周报详见【WeekReport】文件夹内，按照周数进行编号

## 小组文档

对于其他组成员，对于需要使用表和需要定义字段的，应参照本小组目前的接口文档来查找。

文档可[参见此处](../Docs/README.md)。

对于需要变更定义的，应及时通过GitHub Issue或者社交软件~~或者宿舍砸门~~的方式，向

## 目前已经实现的接口

localhost/dev-api/system/museum/select/all/{name}

查询名字为……的博物馆的所有信息(支持模糊查询)

localhost/dev-api/system/comments/list

查询评论列表

localhost/dev-api/system/comments/select/all/{mumid}

返回指定博物馆下所有评论

localhost/dev-api/system/users/select/all/{Phone}

通过手机号得到用户信息(除密码)

localhost/dev-api/system/museumcollection/select/all/{userid}

查询编号为id的用户收藏的博物馆

localhost/dev-api/system/museumcollection

新增收藏信息

localhost/dev-api/system/users

新增用户

localhost/dev-api/system/museum

新增一个博物馆


