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

## 目前已建表

### 博物馆信息（museum）

|   字段中文（注释）   |      字段英文       | 字段类型 |        备注         |
| :------------------: | :-----------------: | :------: | :-----------------: |
|      博物馆编号      |         id          |   int    | key（自增）不能为空 |
|      博物馆名称      |        name         |   char   |                     |
|     博物馆的类型     |        type         |   char   |                     |
|         地址         |       address       |   char   |                     |
|         门票         |     TicketPrice     |   int    |                     |
|       开放时间       |    OpeningHours     |   char   |                     |
|     建议游玩时间     | Suggestedtraveltime |   char   |                     |
|      博物馆等级      |     Museumlevel     |   char   |                     |
|     文物保护单位     |        units        |   char   |                     |
|     旅游景区级别     |   attractionlevel   |   char   |                     |
| 博物馆对应页面的编号 |       number        |   char   |                     |
|      博物馆简介      |    introduction     |   char   |                     |
|    景点景观/藏品     |       Scenery       |   char   |                     |
|       如何前往       |       Howtogo       |   char   |                     |
|      周围的景点      |  Scenicspotsaround  |   char   |                     |
|     封面（图片）     |        cover        |   char   |                     |
|       【经度】       |                     |  float   |      不能为空       |
|       【维度】       |                     |  float   |      不能为空       |

### 博物馆评分表(museumrating)

| 字段中文（注释） |  字段英文  | 字段类型 |        备注         |
| :--------------: | :--------: | :------: | :-----------------: |
|       编号       |     Id     |   int    | key（自增）不能为空 |
|    博物馆编号    |  MuseumId  |   int    |      不能为空       |
|     用户编号     |   UserId   |   int    |      不能为空       |
|      评分一      |  ScoreOne  | int(0~5) | 【如果空的话按2算】 |
|      评分二      |  ScoreTwo  | int(0~5) | 【如果空的话按2算】 |
|      评分三      | ScoreThree | int(0~5) | 【如果空的话按2算】 |

### 评论表(comments)

| 字段中文（注释） | 字段英文 |                   字段类型                    |                备注                |
| :--------------: | :------: | :-------------------------------------------: | :--------------------------------: |
|     评论编号     |    Id    |                      int                      |        key（自增）不能为空         |
|     用户编号     |  UserId  |                      int                      |              不能为空              |
|    【用户名】    | UserName |                     char                      | 不能为空，注意用户名和用户编号对应 |
|    博物馆编号    |  MumId   |                      int                      |              不能为空              |
|       内容       | Content  |                     char                      |                                    |
|     创建时间     |   Time   | CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP |                                    |

### 评论点赞表(commentlike)

| 字段中文（注释） | 字段英文  | 字段类型 |        备注         |
| :--------------: | :-------: | :------: | :-----------------: |
|       编号       |    Id     |   int    | key（自增）不能为空 |
|     评论编号     | CommentId |   int    |                     |
|     用户编号     |  UserId   |   int    |                     |
|     是否点赞     |  IsLike   |   int    |                     |

### 新闻分析表(news)

| 字段中文（注释） |      字段英文       | 字段类型 |        备注         |
| :--------------: | :-----------------: | :------: | :-----------------: |
|     新闻编号     |         Id          |   int    | key（自增）不能为空 |
|       标题       |        Title        |   char   |                     |
|       作者       |       Author        |   char   |                     |
|   新闻发布时间   |        Time         |   Date   |                     |
|     新闻内容     |       Content       |   char   |                     |
|     原文链接     |        Link         |   char   |                     |
|     爬取时间     |       GetTime       | Datetime |                     |
|  相关博物馆名称  |       MumName       |   char   |                     |
|      分类1       |  ClassificationOne  |   char   |                     |
|      分类2       |  ClassificationTwo  |   char   |                     |
|      分类3       | ClassificationThree |   char   |                     |

### 用户表(users)

| 字段中文（注释） | 字段英文 | 字段类型 |        备注         |
| :--------------: | :------: | :------: | :-----------------: |
|     用户编号     |    Id    |   int    | key（自增）不能为空 |
|      用户名      |   Name   |   char   |      不能为空       |
|       密码       | Password |   char   |      不能为空       |
|       电话       |  Phone   |   char   |  不能为空,唯一  |
|       邮箱       |  Email   |   char   |                     |
|       头像       |   Pic    |   char   |    头像存放路径     |
|       生日       |  Birth   |   Date   |                     |
|       备注       |   Note   |   char   |                     |

### 博物馆收藏表(museumcollection)

| 字段中文（注释） | 字段英文 | 字段类型 |              备注              |
| :--------------: | :------: | :------: | :----------------------------: |
|       编号       |    Id    |   int    |      key（自增）不能为空       |
|     用户编号     |  UserId  |   int    | 不能为空，和博物馆编号一起唯一 |
|    博物馆编号    |  MunId   |   int    |  不能为空，和用户编号一起唯一  |

## 🔺加【】表示其他小组提出的新要求还未更改



