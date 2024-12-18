## 平台简介

## 系统管理内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
3.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
4.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
5.  参数管理：对系统动态配置常用参数。
6.  通知公告：系统通知公告信息发布维护。
7.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
8. 登录日志：系统登录日志记录查询包含登录异常。
9. 在线用户：当前系统中活跃用户状态监控。
10. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
11. 代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
12. 系统接口：根据业务代码自动生成相关的api接口文档。
13. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
14. 缓存监控：对系统的缓存查询，删除、清空等操作。
15. 在线构建器：拖动表单元素生成相应的HTML代码。
16. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

## 本地启动
环境：JDK1.8、MySQL5.7+、Redis、Maven3.8+
1、数据库脚本：/my_blog/sql/my_blog.sql

2、修改配置文件：/my_blog/src/main/resources/application-dev.yml

2.1、主库数据源：数据库名，用户名，密码

2.2、邮件配置：邮箱服务器，用户名，密码

2.3、阿里云oss：存储空间，访问域名，AccessKey，SecretKey

3、启动项目：/my_blog/blog-admin/src/main/java/com/dragon/BlogApplication.java

## 在线体验

- admin/admin123  

后端演示地址：http://dragonwen.cn/admin
前端演示地址：http://dragonwen.cn

## 演示图

<table>
    <tr>
        <td><img src=""/></td>
        <td><img src=""/></td>
    </tr>
    <tr>
        <td><img src="="/></td>
        <td><img src=""/></td>
    </tr>
</table>
