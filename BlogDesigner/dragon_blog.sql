/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50558
 Source Host           : localhost:3306
 Source Schema         : dragon_blog

 Target Server Type    : MySQL
 Target Server Version : 50558
 File Encoding         : 65001

 Date: 30/07/2019 14:02:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bg_blacklist
-- ----------------------------
DROP TABLE IF EXISTS `bg_blacklist`;
CREATE TABLE `bg_blacklist`  (
  `blacklist_id` int(11) NOT NULL AUTO_INCREMENT,
  `ip_addr` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '黑名单的IP地址',
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封禁原因',
  `count` int(11) NULL DEFAULT 0 COMMENT '拦截次数',
  `last_access_time` datetime NULL DEFAULT NULL COMMENT '最近一次访问的时间',
  `last_access_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上一次请求的地址',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`blacklist_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '黑名单' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bg_blacklist
-- ----------------------------
INSERT INTO `bg_blacklist` VALUES (1, '153.37.86.48', '言论不当', 0, '2019-06-24 22:43:55', 'http://dragonwen.wicp.vip/my_blog/blog', 'admin', '2019-06-24 22:44:38', NULL, NULL);

-- ----------------------------
-- Table structure for bg_blog
-- ----------------------------
DROP TABLE IF EXISTS `bg_blog`;
CREATE TABLE `bg_blog`  (
  `blog_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客id\n',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '归类id',
  `title` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博文标题',
  `summary` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博文摘要',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '博文状态，1表示已经发表，2表示在草稿箱，3表示在垃圾箱',
  `weight` int(11) NULL DEFAULT 0 COMMENT '权重',
  `support` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否推荐，1表示推荐，0表示不推荐',
  `click` int(11) NULL DEFAULT 0 COMMENT '点击次数',
  `header_img` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标图展示地址',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '2' COMMENT '博文类型，1表示markdown，2表示富文本',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '博文正文内容',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bg_blog
-- ----------------------------
INSERT INTO `bg_blog` VALUES (1, 50, 'MyEclipse2017 CI7 集成开发环境的破解与使用', 'MyEclipse，是在eclipse 基础上加上自己的插件开发而成的功能强大的企业级集成开发环境，主要用于Java、Java EE以及移动应用的开发。MyEclipse的功能非常强大，支持也十分广泛，尤其是对各种开源产品的支持相当不错。', '1', 0, '0', 185, 'http://images.bianxiaofeng.com/657b07046abc1a8dd3de65ea80f37ded.jpg', '2', '<h1><a href=\"#myeclipse2017-ci7-集成开发环境的破解与使用\" name=\"myeclipse2017-ci7-集成开发环境的破解与使用\"></a>MyEclipse2017 CI7 集成开发环境的破解与使用</h1>\n<blockquote>\n  <p>MyEclipse，是在eclipse 基础上加上自己的插件开发而成的功能强大的企业级集成开发环境，主要用于Java、Java EE以及移动应用的开发。MyEclipse的功能非常强大，支持也十分广泛，尤其是对各种开源产品的支持相当不错。<br>MyEclipse企业级工作平台（MyEclipseEnterprise Workbench ，简称MyEclipse）是对EclipseIDE的扩展，利用它我们可以在数据库和JavaEE的开发、发布以及应用程序服务器的整合方面极大的提高工作效率。它是功能丰富的JavaEE集成开发环境，包括了完备的编码、调试、测试和发布功能，完整支持HTML，Struts，JSP，CSS，Javascript，Spring，SQL，Hibernate 。<br>MyEclipse 是一个十分优秀的用于开发Java, J2EE的 Eclipse 插件集合，MyEclipse的功能非常强大，支持也十分广泛，尤其是对各种开源产品的支持十分不错。MyEclipse可以支持Java Servlet，AJAX，JSP，JSF，Struts，Spring，Hibernate，EJB3，JDBC数据库链接工具等多项功能。可以说MyEclipse是几乎囊括了目前所有主流开源产品的专属eclipse开发工具。——  [百度百科 ]</p>\n</blockquote>\n<p><em>本文主要通过本人自己的经验对网上的一些各类大神的教程进行总结与更新（大神们的教程已经发布很久了，不能适用现在的最新版本）。</em><br>备注：本教程默认读者是配置好了JAVA的相关环境的，请读者自行配置相关环境。</p>\n<h2><a href=\"#下载\" name=\"下载\"></a>下载</h2>\n<h3><a href=\"#下载地址\" name=\"下载地址\"></a>下载地址</h3>\n<p>下载地址建议还是去官方的网站吧，为了安全。嘻嘻</p>\n<pre><code>    附上下载地址：http://www.myeclipsecn.com/download/\n</code></pre>\n<p>注：下载需要微信扫码获取密码。<br><img src=\"http://img.blog.csdn.net/20170907122010684?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"注意我使用的版本为MyEclipse 2017 CI 7（2017-7-12更新），以后更新的版本有可能破解方法不能适用\"><br> 注意我使用的版本为MyEclipse 2017 CI 7（2017-7-12更新）</p>\n<p>下载默认安装即可。</p>\n<h3><a href=\"#注意事项\" name=\"注意事项\"></a>注意事项</h3>\n<p><strong><em>安装完毕之后，一定要记住，不要选择那个默认的打开MyEclipse ！！！</em></strong></p><p><strong><em><br></em></strong></p>\n<p><img src=\"http://img.blog.csdn.net/20170907162256989?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"></p>\n<h2><a href=\"#破解\" name=\"破解\"></a>破解</h2>\n<p>然后使用我们的破解工具：<br> 破解工具下载地址：http://download.csdn.net/download/qq_32454537/9968200</p>\n<h3><a href=\"#1-解压文件后打开文件夹-\" name=\"1-解压文件后打开文件夹-\"></a>1、解压文件后打开文件夹：</h3>\n<p><img src=\"http://img.blog.csdn.net/20170907122456966?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"> </p>\n<h3><a href=\"#2-复制这里面的所有内容-\" name=\"2-复制这里面的所有内容-\"></a>2、复制这里面的所有内容：</h3>\n<p><img src=\"http://img.blog.csdn.net/20170907122549774?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"></p>\n<h3><a href=\"#3-到myeclipse的安装目录下-\" name=\"3-到myeclipse的安装目录下-\"></a>3、到MyEclipse的安装目录下：</h3>\n<p><img src=\"http://img.blog.csdn.net/20170907122656782?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"></p>\n<h3><a href=\"#4-复制到这个plugins文件夹内-覆盖就可-\" name=\"4-复制到这个plugins文件夹内-覆盖就可-\"></a>4、复制到这个plugins文件夹内，覆盖就可。</h3>\n<p>ps：一共是64个文件。</p>\n<h3><a href=\"#5-打开myeclipse2017-keygen这个文件夹\" name=\"5-打开myeclipse2017-keygen这个文件夹\"></a>5、打开myeclipse2017_keygen这个文件夹</h3>\n<p><img src=\"http://img.blog.csdn.net/20170907122900501?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"></p>\n<h3><a href=\"#6-打开之后双击打开红框部分\" name=\"6-打开之后双击打开红框部分\"></a>6、打开之后双击打开红框部分</h3>\n<p><img src=\"http://img.blog.csdn.net/20170907122934081?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"></p>\n<h3><a href=\"#7-打开后如图\" name=\"7-打开后如图\"></a>7、打开后如图</h3>\n<p>填写UserCode为任意英文或者数字，这里填写为admin、<br>下面一个下拉选择框选择BLUE<br>按SystemId按钮，可能需要按两下，知道SystemId输入框出现一连串的“莫名其妙”的符号。<br>这个时候再按Active按钮，此时最下面的TextView就会出现这么一坨东西，代表基本成功<br><img src=\"http://img.blog.csdn.net/20170907162902448?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"><br>这个时候，还需要点击Tools，选择tools里的save propertity<br><img src=\"http://img.blog.csdn.net/20170907163006825?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"></p>\n<p>PS：附上操作顺序图<br><img src=\"http://img.blog.csdn.net/20170907123217745?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"></p>\n<p>然后打开MyEclipse敬请享用吧。</p>\n<p>如果有问题欢迎回复。我在线都会答。</p>\n<h2><a href=\"#其他事项\" name=\"其他事项\"></a>其他事项</h2>\n<h3><a href=\"#2017年9月8日更新-\" name=\"2017年9月8日更新-\"></a>2017年9月8日更新：</h3>\n<p>如果出现了破解失败，即进去显示还有5天就到期。<br>请按照以下步骤执行：<br>1、首先卸载MyEclipse ，卸载完毕后请删除MyEclipse中的所有的文件。<br>2、按住Windows键+R，输入regedit，进去注册表编辑页面，按住Ctrl+F，出来搜索框，请输入：MyEclipse，然后回车，进行搜索，搜索出来了按del键进行删除。然后再按住F3继续搜索，直到搜索完毕。<br>3、重新按照如上步骤，重新破解安装。</p>\n<h3><a href=\"#2017年12月30日更新-\" name=\"2017年12月30日更新-\"></a>2017年12月30日更新：</h3>\n<p>也没更新啥，就换了下排版嘻嘻嘻！</p>\n<p>本文链接：http://blog.csdn.net/qq_32454537/article/details/77880294</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:36:19');
INSERT INTO `bg_blog` VALUES (2, 47, 'Hexo博文置顶（自定义排序）', 'HEXO默认是按照时间顺序排一条线，然后按照时间顺序来决定显示的顺序的。按照网上的教程整理了一份方法。</p>博文置顶-自定义排序-\" name=\"hexo博文置顶-自定义排序-\"></a>Hexo', '1', 0, '0', 785, 'http://images.bianxiaofeng.com/c395ec9d24ac314bf9ab182a1e7f05f9', '2', '<blockquote>\n  <p>HEXO默认是按照时间顺序排一条线，然后按照时间顺序来决定显示的顺序的。按照网上的教程整理了一份方法。</p>\n</blockquote>\n<h1><a href=\"#hexo博文置顶-自定义排序-\" name=\"hexo博文置顶-自定义排序-\"></a>Hexo博文置顶（自定义排序）</h1>\n<p>修改Hexo文件夹下的node_modules/hexo-generator-index/lib/generator.js<br><br>打开在最后添加如下<code>javascript</code>代码 </p>\n<pre><code>posts.data = posts.data.sort(function(a, b) {\n}\n    return -1;\n}\n    return 1;\n}\nelse return b.date - a.date; // 都没定义按照文章日期降序排\n</code></pre>\n<p>}); </p>\n<p>文章有多种属性，一个一个添加是不是很麻烦呢？ </p>\n<p>这个时候可以修改：HEXO博客的<code>scaffolds\\post.md</code></p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:10:34');
INSERT INTO `bg_blog` VALUES (3, 50, 'Android Studio 优化', '安装好Android Studio之后需要根据自己的习惯进行一些设置，下载些插件、设置下软件的相关属性等等。刚好重装了下系统，针对这个Android Studio进行了相关的设置，在这里将经历说一下，避免自己以后晚了相关设置也方便一些需要帮助的朋友', '1', 0, '0', 183, 'http://images.bianxiaofeng.com/7725d208415a957e91facd27ec740cbb.png', '2', '<p><br></p>\n<blockquote>\n  <p><em>安装好Android Studio之后需要根据自己的习惯进行一些设置，下载些插件、设置下软件的相关属性等等。刚好重装了下系统，针对这个Android Studio进行了相关的设置，在这里将经历说一下，避免自己以后晚了相关设置也方便一些需要帮助的朋友</em> </p>\n</blockquote>\n<p>更新记录：2017年12月24日22:32:37更新<br><br>本文主要分为设置篇和插件篇： </p>\n<h1><a href=\"#技巧篇\" name=\"技巧篇\"></a>技巧篇</h1>\n<p>##快速查找以及快捷键搜索<br>在AS的面板上双击<code>shift</code>键，即可调出全局搜索。</p>\n<p><img src=\"http://img.blog.csdn.net/20171224213924058?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"><br>AS有很多的快捷键，对于这些快捷键你不一定随时都能记得，这个时候可以使用<code>Win+Shift+A</code>键输入你想用的功能。后面会提示相关的快捷键的。<br><img src=\"http://img.blog.csdn.net/20171224214158337?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"> </p>\n<h2><a href=\"#恢复默认布局\" name=\"恢复默认布局\"></a>恢复默认布局</h2>\n<p>当你各种乱动默认的面板布局的时候，有的面板你想找的时候却发现找不到了，这个时候按住 <code>Shift+F12</code>就可以重置默认面板。<br><img src=\"http://img.blog.csdn.net/20171224214521926?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"> </p>\n<h2><a href=\"#tip-of-the-day\" name=\"tip-of-the-day\"></a>Tip of the day</h2>\n<p>打开软件的时候随机显示关于Android Studio的相关使用提示。（很有用的，别关）</p>\n<p><img src=\"http://img.blog.csdn.net/20171224215949578?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"></p>\n<h2><a href=\"#android-studio相关网站\" name=\"android-studio相关网站\"></a>Android Studio相关网站</h2>\n<ul>\n  <li><a href=\"http://www.android-studio.org/\">Android Studio 中文社区</a></li>\n  <li><a href=\"https://stackoverflow.com/\">优质的问答社区（英文的）</a></li>\n</ul>\n<h1><a href=\"#设置篇\" name=\"设置篇\"></a>设置篇</h1>\n<blockquote>\n  <p>Android Studio到底是外国人开发的，这个东西拿到手感觉和我们日常使用的IDE有点···· </p>\n</blockquote>\n<h2><a href=\"#鼠标滚轮滑动调整字体大小\" name=\"鼠标滚轮滑动调整字体大小\"></a>鼠标滚轮滑动调整字体大小</h2>\n<p>打开<code>File</code>里的<code>Setting</code> 勾选<code>Change font size(Zoom)with Ctrl——Mouse Wheel</code><br><img src=\"http://img.blog.csdn.net/20171224214754310?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"> </p>\n<h2><a href=\"#查看参数定义\" name=\"查看参数定义\"></a>查看参数定义</h2>\n<p>使用快捷键<code>Ctrl+P</code>可以查看当前鼠标所在位置的方法的参数定义。<br><img src=\"http://img.blog.csdn.net/20171224222531022?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"> </p>\n<h2><a href=\"#鼠标移动显示api文档\" name=\"鼠标移动显示api文档\"></a>鼠标移动显示API文档</h2>\n<p>设置当鼠标移动到方法上的时候显示API文档。<code>Editor-&gt;General-&gt;show quick document on mouse move</code> 后面那个Delay Time 是设置延时的，单位为毫秒。但是建议电脑性能差一点的不要开，会很卡。<br><img src=\"http://img.blog.csdn.net/20171224222926874?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"></p>\n<h2><a href=\"#设置默认的字体大小\" name=\"设置默认的字体大小\"></a>设置默认的字体大小</h2>\n<p>打开AS的时候发现蚊子一样大小的代码，密密麻麻的密集恐惧症受不了。<code>Editor-&gt;Colors&amp;Fonts-&gt;Font</code><br>一般设置到18就行了<br><img src=\"http://img.blog.csdn.net/20171224215037079?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"> </p>\n<h2><a href=\"#更改快捷键\" name=\"更改快捷键\"></a>更改快捷键</h2>\n<p>设置<code>Keymap</code>，快捷键太多，可以使用搜索框搜索 </p>\n<p><img src=\"http://img.blog.csdn.net/20171224220232053?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"></p>\n<h2><a href=\"#设置代码提示\" name=\"设置代码提示\"></a>设置代码提示</h2>\n<p>Android Studio的代码提示是对大小写敏感的，选择None就可以匹配到很多方法或者关键字，这个在你忘了这个方法怎么写的时候非常有用。<br>此外**Ctrl+Q**快捷键也可以设置代码提示。<br><img src=\"http://img.blog.csdn.net/20171224220954002?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"></p>\n<p>## 去掉代码编辑区的竖线 </p>\n<p>编辑区域总是有一条竖线，这条竖线的作用是用来警示程序员代码不要写的过长的。<br> <img src=\"http://p2sj58chj.bkt.clouddn.com/QQ截图20180320143743.png\" alt=\"QQ截图20180320143743\"> </p>\n<p>## 设置方法之间横线隔开<br>操作方法如图：勾选 <strong>Show method separators</strong></p>\n<p><img src=\"http://p2sj58chj.bkt.clouddn.com/QQ截图20180320143838.png\" alt=\"QQ截图20180320143838\"> </p>\n<h2><a href=\"#炫酷的log\" name=\"炫酷的log\"></a>炫酷的Log</h2>\n<p>设置地址：Preferences → Editor → Colors &amp; Fonts → Android Logcat<br>将各种类型的log设置颜色：<br>参考别人的配色如下：附上<a href=\"https://meedamian.com/post/deuglifying-android-studio/\">链接</a></p>\n<p>Type Color<br>verbose: #BBB<br>debug: #33B5E5<br>info: #9C0<br>assert: #A6C<br>error: #F44<br>warning: #FB3<br> <br>效果如下：<br><img src=\"http://p2sj58chj.bkt.clouddn.com/QQ截图20180320150409.png\" alt=\"QQ截图20180320150409\"></p>\n<h1><a href=\"#插件篇\" name=\"插件篇\"></a>插件篇</h1>\n<h2><a href=\"#androidaccessors\" name=\"androidaccessors\"></a>AndroidAccessors</h2>\n<p>快速生成<code>get</code>和<code>set</code>系列方法。这个在你定义<code>JavaBean</code>的时候非常有用。<br><img src=\"http://img.blog.csdn.net/20171224221252982?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"> </p>\n<h2><a href=\"#butterknifezelezny-插件\" name=\"butterknifezelezny-插件\"></a>ButterKnifeZelezny 插件</h2>\n<p>如果你厌倦了findViewById这样的写法，那么这个插件是你的选择。这个配合ButterKnife使用的。</p>\n<h2><a href=\"#recitewords\" name=\"recitewords\"></a>ReciteWords</h2>\n<p>是一个IntelliJ IDEA、Android Studio 记单词翻译插件,可以将英文翻译为中文并记录到生词本提供查阅。，项目地址为：<a href=\"https://github.com/BolexLiu/ReciteWords\">ReciteWords</a></p>\n<p>功能： </p>\n<ul>\n  <li>划词翻译 整句翻译 拆分驼峰命名翻译等</li>\n  <li>生词本保存翻译过后的历史记录</li>\n</ul>\n<p>使用方法： </p>\n<ul>\n  <li>\n  <p>Clone项目，获取根目录下的ReciteWords.jar。</p></li>\n  <li>\n  <p>打开Android Studio， Preferences -&gt; Plugins -&gt; Install plugin from disk -&gt; 获取ReciteWords.jar安装并重启Android Studio。</p></li>\n  <li>\n  <p>选中代码，按下 Alt+Q(也可以自己设定)。即可翻译。效果如下:<br><img src=\"https://github.com/BolexLiu/ReciteWords/raw/master/img/1.png\"></p></li>\n  <li>\n  <p>设置快捷键<br>使用键盘快捷键触发，Preferences -&gt; Keymap -&gt; 获取ReciteWords - &gt; 右键 add Keyboard Shortcut. 输入你想要的快捷键即可。</p></li>\n</ul>\n<h2><a href=\"#主题\" name=\"主题\"></a>主题</h2>\n<p>这里我推荐一个<code>MaterialDesign AS UI Theme</code> 这个主题比较好用，尤其是配合黑色的AS主题的时候。</p>\n<p>顺便推荐一个http://color-themes.com/ 这个网站下载你喜欢的主题，然后导入主题即可。<br><img src=\"http://img.blog.csdn.net/20171224222110962?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzI0NTQ1Mzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"></p>\n<p>插件及常用的快捷键请看我之前的博客：http://blog.csdn.net/qq_32454537/article/details/77870200</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:10:57');
INSERT INTO `bg_blog` VALUES (4, 47, '站点被百度谷歌收录', '精心写一篇博文但是没人看怎么办呢？百度搜不到，谷歌搜不到？别慌，还需要将你的网站提交到百度和谷歌。在开始之前，你可以按照以下格式在百度和谷歌搜索下你的网站：', '1', 0, '0', 188, 'http://images.bianxiaofeng.com/c395ec9d24ac314bf9ab182a1e7f05f9', '2', '<p>精心写一篇博文但是没人看怎么办呢？百度搜不到，谷歌搜不到？别慌，还需要将你的网站提交到百度和谷歌。</p>\n<p>在开始之前，你可以按照以下格式在百度和谷歌搜索下你的网站：<br><br></p><p>注意：提交到谷歌需要科学上网。</p>\n<h1><a href=\"#提交百度搜索引擎\" name=\"提交百度搜索引擎\"></a>提交百度搜索引擎</h1>\n<p>登录<a href=\"http://ziyuan.baidu.com/site/index\">http://ziyuan.baidu.com/site/index</a></p>\n<p>ps：可能需要个人信息认证，按照提示认证即可！</p>\n<h2><a href=\"#点击添加站点\" name=\"点击添加站点\"></a>点击添加站点</h2>\n<p>会看到如下界面：<br></p>\n<h2><a href=\"#在图中文本框添加你的个人网站域名\" name=\"在图中文本框添加你的个人网站域名\"></a>在图中文本框添加你的个人网站域名</h2>\n<p>最好是带上<code>www</code></p>\n<h2><a href=\"#设置站点领域\" name=\"设置站点领域\"></a>设置站点领域</h2>\n<p>这里我选择<code>信息技术</code>，点击下一步。 </p>\n<h2><a href=\"#选择验证方式\" name=\"选择验证方式\"></a>选择验证方式</h2>\n<h3><a href=\"#验证方式一-文件验证\" name=\"验证方式一-文件验证\"></a>验证方式一：文件验证</h3><p> 这里我选择的是文件验证，建议大家也使用文件验证方式，这样比较简单。 </p>\n<blockquote>\n  <ol>\n    <li>\n    <p>请点击 下载验证文件 获取验证文件（当前最新：baidu_verify_Rkofa3ZBzc.html）</p></li>\n    <li>\n    <p>将验证文件放置于您所配置域名(www.bianxiaofeng.com)的根目录下</p></li>\n    <li>\n    <p>点击这里确认验证文件可以正常访问</p></li>\n    <li>\n    <p>请点击“完成验证”按钮</p></li>\n  </ol>\n  <p>为保持验证通过的状态,成功验证后请不要删除HTML文件 </p>\n</blockquote>\n<p>网站的根目录在那里呢？ </p>\n<p>在你的博客的本地根目录的<code>Source</code>文件夹内。 </p>\n<p><br> 然后控制台输入：<code>hexo g -d</code>，部署到网站上。</p>\n<p>验证方式：<br>点击3步骤的验证。如果能点击进去证明成功。 </p>\n<h2><a href=\"#随后点完成验证-\" name=\"随后点完成验证-\"></a>随后点完成验证。</h2>\n<h3><a href=\"#html标签验证\" name=\"html标签验证\"></a>HTML标签验证</h3>\n<p>本文使用的是Next主题。在<code>themes/next/layout/_partials/head.swig</code>内：修改meta标签为站长网站上给出的标签即可：</p>\n<p><br></p>\n<p>同时，在themes/next/_config.yml中将google-site-verification和baidu_site_verification的值设置为true即可。</p>\n<p>然后控制台输入：<code>hexo g -d</code>，部署到网站上。</p>\n<h2><a href=\"#cname验证\" name=\"cname验证\"></a>CNAME验证</h2>\n<p><br></p>\n<p>配置方式如图：</p>\n<p><br></p>\n<h1><a href=\"#谷歌验证\" name=\"谷歌验证\"></a>谷歌验证</h1>\n<p>登录<a href=\"https://www.google.com/webmasters/tools/home?hl=zh-CN\">https://www.google.com/webmasters/tools/home?hl=zh-CN</a><br>如图：<br><br></p>\n<h2><a href=\"#在上图输入你的网站地址\" name=\"在上图输入你的网站地址\"></a>在上图输入你的网站地址</h2>\n<h2><a href=\"#验证\" name=\"验证\"></a>验证</h2>\n<p><br></p>\n<p>按照下图进行选择：</p>\n<p><br></p>\n<p>在阿里云的解析当中添加下面的解析：<br><br></p>\n<p>点击验证即可。 </p>\n<p><br></p>\n<h1><a href=\"#站点地图\" name=\"站点地图\"></a>站点地图</h1>\n<blockquote>\n  <p>站点地图是一种文件，您可以通过该文件列出您网站上的网页，从而将您网站内容的组织架构告知Google和其他搜索引擎。Googlebot等搜索引擎网页抓取工具会读取此文件，以便更加智能地抓取您的网站。 </p>\n</blockquote>\n<h2><a href=\"#安装百度谷歌的站点地图文件\" name=\"安装百度谷歌的站点地图文件\"></a>安装百度谷歌的站点地图文件</h2>\n<pre><code>npm install hexo-generator-sitemap --save\n\nnpm install hexo-generator-baidu-sitemap --save  \n</code></pre>\n<h2><a href=\"#修改博客配置文件\" name=\"修改博客配置文件\"></a>修改博客配置文件</h2>\n<p>打开站点配置文件：<br><br></p>\n<p>主要是将url设置为你的站点名称。</p>\n<p>然后执行：<code>hexo clean</code>和<code>hexo g</code> </p>\n<p>这样在你的网站根目录的<code>public</code>文件夹下生成sitemap.xml文件和baidusitemap.xml文件： </p>\n<p><br></p>\n<p>其中sitemap.xml文件是搜索引擎通用的文件，baidusitemap.xml是百度专用的sitemap文件。 </p>\n<h2><a href=\"#向谷歌提交链接\" name=\"向谷歌提交链接\"></a>向谷歌提交链接</h2>\n<p>google站点平台：<a href=\"https://www.google.com/webmasters/tools/home?hl=zh-CN\">https://www.google.com/webmasters/tools/home?hl=zh-CN</a>，然后就是注册账号、验证站点、提交sitemap，</p>\n<p><img src=\"https://i.imgur.com/A5rvI8A.png\"> </p>\n<p><img src=\"https://i.imgur.com/UOvfbDi.png\"> </p>\n<p>提交你的site就行了</p>\n<h2><a href=\"#百度收录\" name=\"百度收录\"></a>百度收录</h2>\n<p>百度收录很麻烦，效率比谷歌差远了。</p>\n<h3><a href=\"#设置自动推送\" name=\"设置自动推送\"></a>设置自动推送</h3>\n<p>在主题配置文件下设置,将baidu_push设置为true：</p>\n<pre><code># Enable baidu push so that the blog will push the url to baidu automatically which is very helpful for SEO\nbaidu_push: true \n</code></pre>\n<h3><a href=\"#sitemap\" name=\"sitemap\"></a>sitemap</h3>\n<p>将生成的baidusitemap.xml提交到百度<a href=\"http://ziyuan.baidu.com/linksubmit/index\">http://ziyuan.baidu.com/linksubmit/index</a></p>\n<p>点击链接提交 ：</p>\n<p><img src=\"https://i.imgur.com/sCONlMv.png\"> </p>\n<p>输入文件地址提交 </p>\n<p><img src=\"https://i.imgur.com/M8JJBIe.png\"></p>\n<p>稍后你刷新页面，就可以看到状态了。</p>\n<p>本文参考：<br><a href=\"http://blog.csdn.net/sunshine940326/article/details/70936988\">http://blog.csdn.net/sunshine940326/article/details/70936988</a></p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:41:34');
INSERT INTO `bg_blog` VALUES (5, 47, '2018最新版hexo+Github搭建个人博客教程（2018-09-10 更新）', '现在是大三了，身边的甚多朋友技术都还不错，动不动就搭建自己的网站什么的。本着向大佬学习（zhuangbi）的心情，我也开始在阿里云上面买了一个云服务器（学生套餐9.9），使用phpstudy软件一键部署了一个web服务器。但是想想其实没什么', '1', 0, '0', 737, 'http://images.bianxiaofeng.com/c395ec9d24ac314bf9ab182a1e7f05f9', '2', '<p><span style=\"color: inherit; font-family: inherit; font-size: 24px;\">前言</span><br></p>\n<blockquote>\n  <p>现在是大三了，身边的甚多朋友技术都还不错，动不动就搭建自己的网站什么的。本着向大佬学习（zhuangbi）的心情，我也开始在阿里云上面买了一个云服务器（学生套餐9.9），使用phpstudy软件一键部署了一个web服务器。但是想想其实没什么用，我只是想找一个属于自己的个人博客而已。所以将目光转向了hexo。 经过很多的摸索，终于是做好了我的博客：<a href=\"http://bianxiaofeng.com\">http://bianxiaofeng.com</a>, 就像每个语言入门必写<code>hello world</code>一样，我也想把自己使用hexo的相关经历写下来，方便自己以后查阅也希望能够帮助到更多的朋友。<br><br>博主使用是Windows10操作系统，其他系统自测。</p>\n  <h2><a href=\"#总述\" name=\"总述\"></a>总述</h2>\n</blockquote>\n<p>搭建的过程分为以下几步： </p>\n<ol>\n  <li>\n  <p>安装Node.js</p></li>\n  <li>\n  <p>安装Git软件 </p></li>\n  <li>\n  <p>安装hexo博客框架 </p></li>\n  <li>\n  <p>测试本地运行（线下访问个人博客） </p></li>\n  <li>\n  <p>部署到Coding以及GitHub上（线上访问个人博客） </p></li>\n  <li>\n  <p>设置域名解析 </p></li>\n  <li>\n  <p>其他（写一篇新的博文，设置categories,tags）</p></li>\n</ol>\n<h2><a href=\"#安装node-js\" name=\"安装node-js\"></a>安装Node.js</h2>\n<p>Node.js下载地址：<a href=\"https://nodejs.org/en/download/\">https://nodejs.org/en/download/</a> </p>\n<p>安装过程一路默认安装即可。 </p>\n<p>详细安装文档参看：<a href=\"http://www.runoob.com/nodejs/nodejs-install-setup.html\">http://www.runoob.com/nodejs/nodejs-install-setup.html</a> </p>\n<h2><a href=\"#安装git软件\" name=\"安装git软件\"></a>安装Git软件</h2>\n<p>Git软件下载地址：<a href=\"https://git-scm.com/download\">https://git-scm.com/download</a> </p>\n<p>安装过程一路默认安装即可。 </p>\n<p>关于更多的Git讲解参看： </p>\n<p><a href=\"https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000\">https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000</a> </p>\n<h2><a href=\"#安装hexo\" name=\"安装hexo\"></a>安装Hexo</h2>\n<h3><a href=\"#什么是-hexo-\" name=\"什么是-hexo-\"></a>什么是 Hexo？</h3>\n<p>Hexo 是一个快速、简洁且高效的博客框架。Hexo 使用 Markdown（或其他渲染引擎）解析文章，在几秒内，即可利用靓丽的主题生成静态网页。 </p>\n<p>Hexo官方网站：<a href=\"https://hexo.io/zh-cn/\">https://hexo.io/zh-cn/</a></p>\n<h3><a href=\"#安装\" name=\"安装\"></a>安装</h3>\n<p>安装命令： </p>\n<pre><code>npm install -g hexo-cli  #-g表示全局安装\n</code></pre>\n<p><em>这里提一下：关于hexo的终端操作最好是在管理员模式下，读者可以采用<code>按住Shift然后再点击鼠标右键</code>选择弹出菜单的<code>在此处打开Powershell窗口</code>保证运行在管理员状态下。</em> </p>\n<h3><a href=\"#初始化hexo\" name=\"初始化hexo\"></a>初始化hexo</h3>\n<p>在电脑合适的位置新建一个文件夹存放博客。本文中取名为<code>Blog</code>文件夹。 </p>\n<p>控制台命令行使用cd命令进入到Blog文件夹，输入以下命令进行初始化： </p>\n<pre><code>hexo init  # 初始化 \n</code></pre>\n<p>初始化完成之后，因为会出现有些依赖包未安装成功的情况，所以请再输入以下命令安装依赖包: </p>\n<pre><code>hexo install   # 安装依赖包  \n</code></pre>\n<h2><a href=\"#测试本地运行\" name=\"测试本地运行\"></a>测试本地运行</h2>\n<p>完成以上安装步骤后，便可以在本地预览博客效果了。 </p>\n<p>输入以下命令： </p>\n<pre><code>hexo g   # 等同于hexo generate，生成静态文件\nhexo s   # 等同于hexo server，在本地服务器运行\n</code></pre>\n<p>然后打开浏览器地址栏输入：<a href=\"http://localhost:4000/\">http://localhost:4000/</a>便可以预览生成的博客框架雏形了。 </p>\n<h2><a href=\"#部署到github以及coding上\" name=\"部署到github以及coding上\"></a>部署到GitHub以及Coding上</h2>\n<blockquote>\n  <p>建立博客网站肯定是要让大家看到的，由于Github是歪果仁的网站，且禁止百度爬虫访问，所以会导致百度搜不到你的网站。所以我们要做好两手准备：国内采用Coding托管，国外采用GitHub托管。 </p>\n</blockquote>\n<p>分别注册GitHub以及Coding的账号。 </p>\n<ul>\n  <li>\n  <p>GitHub网址如下：<a href=\"http://www.github.com\">http://www.github.com</a></p></li>\n  <li>\n  <p>Coding网址如下：<a href=\"https://coding.net\">https://coding.net</a> </p></li>\n</ul>\n<h3><a href=\"#github注册\" name=\"github注册\"></a>GitHub注册</h3>\n<p>1、在GitHub首页点击<code>Start Project</code> </p>\n<p>2、创建Repository </p>\n<p><img src=\"https://i.imgur.com/HKup5ys.png\"> </p>\n<p>PS：创建时，填写<code>Repository name</code>的时候，Repository name的格式必须为{user_name}.github.io，其中{user_name}必须与你的用户名一样，这是GitHub Pages的特殊命名规范（亲测不区分大小写）。</p>\n<h3><a href=\"#coding注册\" name=\"coding注册\"></a>Coding注册</h3>\n<blockquote>\n  <p>CODING 是国内专业的一站式云端软件服务平台，成立于 2014 年 2 月，总部位于深圳，并于北京、上海、成都、西雅图设立分部，已获得了 IDG 和光速的两轮投资共计 1500 万美元。旗下自主研发运营 Coding.net 云端开发协作平台，累积 25 万开发者，37 万个项目。在云计算时代，把代码托管、产品演示、WebIDE 等开发工具集成到浏览器中，免除繁杂的开发环境部署，节省成本，帮助软件开发者提高生产效率，并实现 “Coding Anytime Anywhere” 的愿景。2015 年 10 月，基于 Coding.net 的工具平台，CODING 推出云端软件众包服务平台 “码市”，旨在通过云端协作以及众包的方式提高软件交付的效率，帮助软件开发行业实现高效的资源匹配。</p>\n  <p>Coding.net 为开发者提供了免费的基础服务，包括但不限于 Git 代码托管，项目管理，Pages 服务，代码质量管理。您可以在 Coding.net 一站完成代码及代码质量，项目及项目人员的管理，Coding.net 让开发变得前所未有的敏捷和简单。</p>\n</blockquote>\n<p>Coding的仓库容量只有256M，但是用来发布博文是够了的。 </p>\n<p>注册步骤没啥好说的。 </p>\n<p>主要说一下创建仓库的时候（顺便说一句：Coding毕竟还是国内的，各方面比较适合国人的习惯，操作起来是比GitHub顺手点。 ） </p>\n<p>点击下面的“加号”创建一个仓库： </p>\n<p><img src=\"https://i.imgur.com/vanCb7s.png\"> </p>\n<p>然后输入项目名称以及项目描述： </p>\n<p><img src=\"https://i.imgur.com/0ze8avx.png\"><br><em>此处的项目名称不像GitHub那样有着严格的命名规范，你可以按照你能想象到的方式输入。建议不要输入中文，不然后面会走的很安详。这里我是输入的自己的用户名作为项目名称。</em> </p>\n<p>开启Pages服务（步骤如下图） </p>\n<p><img src=\"https://i.imgur.com/F4nGZCc.png\"><br>选择部署来源为<code>master分支</code>，然后点击<a href=\"http://username.coding.me/yourRepoName\"> http://username.coding.me/yourRepoName</a>就可以查看你的博客了，不过你点进去是404，因为你仓库里面啥都没有。 </p>\n<p>到此，注册和创建仓库一步骤已经全部完成了。 </p>\n<h3><a href=\"#部署到线上-github和coding-\" name=\"部署到线上-github和coding-\"></a>部署到线上（GitHub和Coding）</h3>\n<blockquote>\n  <p>我看到很多博客上面说到配置文件的时候，没有区分站点配置文件和主题配置文件，这里我先说清楚。站点配置文件和主题配置文件名称都是一样的<code>_config.yml</code>，站点配置文件在网站根目录，主题配置文件在根目录下的theme文件的具体theme下的<code>_config.yml</code>。 </p>\n</blockquote>\n<h4><a href=\"#修改站点配置文件\" name=\"修改站点配置文件\"></a>修改站点配置文件</h4>\n<p>打开<code>_config.yml</code>到最后<code>deploy</code>选项：<br>配置如下： </p>\n<pre><code># Deployment\n## Docs: https://hexo.io/docs/deployment.html\ndeploy:\n  type: git\n  repo:\n    github: https://github.com/DimpleFeng/dimplefeng.github.io.git,master\n    coding: https://git.coding.net/DimpleFeng/test.git,master\n</code></pre>\n<p>注意：每个冒号后面都是有一个空格的，这是node的语法。 </p>\n<h4><a href=\"#部署\" name=\"部署\"></a>部署</h4>\n<p>部署之前需要安装<code>git</code>部署插件，否则会提示<code>Deployer not found</code>错误。 </p>\n<pre><code>npm install hexo-deployer-git --save\n</code></pre>\n<p>安装完毕后控制台输入： </p>\n<pre><code>hexo g -d   \n</code></pre>\n<p>随后访问你的以下网址（注意替换）：</p>\n<p><a href=\"yourName.github.io\">yourName.github.io </a><br><a href=\"yourName.coding.me\">yourName.coding.me </a> </p>\n<h2><a href=\"#设置域名解析\" name=\"设置域名解析\"></a>设置域名解析</h2>\n<blockquote>\n  <p>作为一个有梦想的程序员，总是希望拥有自己别具一格的域名，这怎么办呢，你可以选择购买域名，然后指向你的静态pages。具体怎么做呢，请看下面。 </p>\n</blockquote>\n<h3><a href=\"#购买域名\" name=\"购买域名\"></a>购买域名</h3>\n<p>你可以在<a href=\"https://dnspod.cloud.tencent.com/?from=qcloudHpProductDns\">腾讯云</a>以及<a href=\"https://wanwang.aliyun.com/?utm_content=se_1101812\">阿里云</a>上购买你的域名。</p>\n<h3><a href=\"#设置域名解析\" name=\"设置域名解析\"></a>设置域名解析</h3>\n<p>这里我分别以阿里云和腾讯云的举例：</p>\n<h4><a href=\"#腾讯云\" name=\"腾讯云\"></a>腾讯云</h4>\n<p>进入<a href=\"https://console.cloud.tencent.com/domain/mydomain\">腾讯云DNS解析网站</a>，然后是点击解析。<img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-2018122142027.png\" alt=\"{mdFileName}-2018122142027\"> </p>\n<p>添加如图所示的几条解析指令。 </p>\n<p><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-2018122142345.png\" alt=\"{mdFileName}-2018122142345\"> </p>\n<p>注意：此处的记录名是github填写你的仓库名，Coding按照我上面的填写。 </p>\n<h4><a href=\"#阿里云\" name=\"阿里云\"></a>阿里云</h4>\n<p>进入<a href=\"https://dc.console.aliyun.com/dns/\">阿里云DNS解析网站</a>点击解析设置：<br><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-2018122143222.png\" alt=\"{mdFileName}-2018122143222\"> </p>\n<p>添加以下几条解析命令：</p>\n<p><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-2018122143452.png\" alt=\"{mdFileName}-2018122143452\"></p>\n<h2><a href=\"#设置coding和github\" name=\"设置coding和github\"></a>设置Coding和GitHub</h2>\n<p>按照上面的步骤添加完毕之后，分别设置Coding和GitHub的指向。 </p>\n<h3><a href=\"#coding\" name=\"coding\"></a>Coding</h3>\n<p>打开Coding，然后点击你的网站仓库，按照下面的步骤，添加你的域名 </p>\n<p><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-2018122143916.png\" alt=\"{mdFileName}-2018122143916\"></p>\n<h3><a href=\"#github\" name=\"github\"></a>GitHub</h3>\n<p>在你的博客的文件夹中找到Source文件夹，在里面加添一个CNMAE的文件，文件内容为你的域名，比如我的就是：<code>bianxiaofeng.com</code> </p>\n<p><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-2018122144052.png\" alt=\"{mdFileName}-2018122144052\"></p>\n<p>OK ,大功告成，你可以通过你的域名访问你的网站了。<a href=\"http://www.bianxiaofeng.com\">Dimple</a></p>\n<p>###</p>\n<h1><a href=\"#其他\" name=\"其他\"></a>其他</h1>\n<h2><a href=\"#写一篇新的博文\" name=\"写一篇新的博文\"></a>写一篇新的博文</h2>\n<p>两种方法：<br>- 在博文根目录的Source文件夹的post文件夹下直接新建一个md文件<br>- 在博文根目录打来PowerShell，然后输入<code>hexo new \'你的标题\'</code>回车在你的post文件夹下就新建了一个博文，打开编辑即可。然后使用<code>hexo g -d</code>部署到线上。 </p>\n<h1><a href=\"#后续\" name=\"后续\"></a>后续</h1>\n<p>接下来呢，我还会针对Next主题、相关的网站配置以及域名和百度谷歌收录进行说明，欢迎关注我的系列文章。</p>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>洋洋洒洒的写了4000+字，确实每一步都是在仔仔细细的做，记录。这篇博文参考了hexo的官方文档，以及百度谷歌的各种教程，重复杂乱居多，网上各种文章都是复制粘贴重复很多且不是最新的，我只想用最平凡的文字记录最清晰的道路。我是一个被代码耽误的诗人，这是我朋友给我的评价哈哈哈。</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:12:26');
INSERT INTO `bg_blog` VALUES (6, 47, 'Hexo内嵌html或者Js代码遇到的问题', '在没有遇到这个坑之前我是完全不知道原来markdown里面是可以嵌入html或者js代码运行的。好吧是我孤陋寡闻了。在了解了原来还有这种操作的时候，整个人是惊呆了。，但想想也是，不然一个博客里面随随便便冒出一个button还能点击是怎么做出来的。', '1', 0, '0', 293, 'http://images.bianxiaofeng.com/a84de350481ef677137400738fbb533f.png', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p><br>在没有遇到这个坑之前我是完全不知道原来markdown里面是可以嵌入html或者js代码运行的。好吧是我孤陋寡闻了。在了解了原来还有这种操作的时候，整个人是惊呆了，但想想也是，不然一个博客里面随随便便冒出一个<code>button</code>还能点击是怎么做出来的。<br></p>\n<h1><a href=\"#进坑过程\" name=\"进坑过程\"></a>进坑过程</h1>\n<p><code>\n &lt;script type=\"text/javascript\"  alert(\"hello world！\");&gt;</code></p>\n<p>比如上面一段代码，写出来了，在<code>markdownpad</code>上面还是可以看到的，但是在<code>hexo</code>中就看不到了。此时脸上笑嘻嘻，心里***。（以上代码我是直接用``括起来的，如果没有扩起来的话，博文后面的内容是完全看不到的。）也是很奇怪这个东西，好像是因为hexo把MD文档全部按照它自己的语法编译了一次，这样就导致编译看起来效果不错，发布出去到处是坑。</p>\n<p>昨晚上我写了一篇博文，<code>hexo g</code>的时候就宝一大堆错，我尝试在其报错的位置进行解决，但是左看右看确实没错。原来是因为hexo文档中的有js代码，引起了连锁反应。毕竟hexo到现在虽然很不错了，但是还有些问题。 </p>\n<h1><a href=\"#脱坑过程\" name=\"脱坑过程\"></a>脱坑过程</h1>\n<p>遇事不决用谷歌，带着问题翻墙出去。结果发现没有人遇到和我一样的问题。难受。各个大佬群咨询，大佬们给出的建议都尝试了，还是没有办法。</p>\n<p>卸载重装，我就差换电脑了，哈哈哈。 </p>\n<p>好了，说下脱坑方法，在你的JS或者HTML代码前面加上4个空格，编译完美通过。</p>\n<p>记录下我的经历，方便以后遇到同样问题的兄弟。</p>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>遇到问题不要慌。能够解决问题的程序员才是好程序员。不断的写bug，不断解决bug才是开发的乐趣。hexo是可以内嵌前端代码的，注意不要被这个坑了，好了，现在弄得差不多了，后面准备回归我的老本行了，写Android了。 </p>\n<p>最近新发现了一个markdown编辑器，还不错，如果不是因为不支持上传图片的话，我就转过去了。我也和开发的人聊了下，准备接入图床或者七牛云的接口。据说是hexo定制的，现在hexo的github主页就挂的这个编译器。有需要的可以去试试。 </p>\n<p>附上链接地址：<a href=\"https://github.com/zhuzhuyule/HexoEditor\">HEXOEditor </a> </p>\n<p>好了就到这里，踩了很多坑，不一一列出来了，大家有问题的话可以留言评论！</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:30:35');
INSERT INTO `bg_blog` VALUES (7, 46, '2018React-Native环境安装及运行第一个demo', 'Android放下很久了，前段时间一直扎根于前端三大件（HTML、CSS、JavaScript）的学习，目的呢是想为之后的学习React Native学习做好准备。趁着离考试还有一段时间，也是重新走上Android开发的道路。现在确实是移动设备占优，现在智能', '1', 0, '0', 517, 'http://images.bianxiaofeng.com/21a05ce30419264ee53d68fb38049e23.jpg', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>Android放下很久了，前段时间一直扎根于前端三大件（HTML、CSS、JavaScript）的学习，目的呢是想为之后的学习React Native学习做好准备。趁着离考试还有一段时间，也是重新走上Android开发的道路。<br>现在确实是移动设备占优，现在智能手机能够完成网页端很多的工作。大有一统江山的趋势。移动开发在未来的很长时间里面都是热门。<br>工欲善其事必先利其器，本文主要是结合自己的相关经验搭建开发环境，来开始关于React Native的第一篇博文。纵观网上的各种教程，还有官方的一些教程吧，写的是比较简略的，所以本文的定位是写一点比较详细的环境安装教程。<br></p>\n<h1><a href=\"#关于react-native\" name=\"关于react-native\"></a>关于react native</h1>\n<p>还是老规矩，介绍下这个东东吧。 </p>\n<blockquote>\n  <p>React Native 是一个 JavaScript 的框架，用来撰写实时的、可原生呈现 iOS 和 Android 的应用。其是基于 React的，而 React 是 Facebook 的用于构建用户界面的 JavaScript 库，但是这里不是给浏览器解释的，而是为移动平台。换句话说：如果你是一名 web 开发者，你可以使用熟悉的框架和单一的 JavaScript 代码库，即 React Native来撰写清晰的、高效的移动应用。</p>\n  <p>相比较于 iOS 和 Android 原生的开发，React Native 提供更好的开发者体验。因为你的程序大多数都是 JavaScript，你可以从 web 开发中汲取大量的经验，比如能够立即“刷新”你的应用来查看你代码的修改。相比于在传统的应用开发中花很长的时间去等待构建的过程，会让人感觉这简直是天赐之物。</p>\n  <p>另外，React Native 还为开发者提供了智能的错误报告和标准的 JavaSript 调试工具，这些让移动开发更加的顺手。 </p>\n</blockquote>\n<p>确实现在的开发，RN在后面的很长时间是主流。毕竟原生开发存在着诸多问题，最大的问题是在用户体验上。废话不多说，进入正题。</p>\n<h1><a href=\"#安装\" name=\"安装\"></a>安装</h1>\n<p>安装过程可以参考<a href=\"https://reactnative.cn/docs/0.51/getting-started.html\">React Native中文网</a><br>那你以为这样就完了吗？没有。</p>\n<p>官方文档上面说了，必须安装的东西，其实有些东西是没有必要的，比如Chocolatey这个包管理器，下载速度及其慢，完了还不支持断点续传，网络一有波动就GG。</p>\n<p>所以遇到按照官方的步骤配置的遇到错误的，到我这里来就对了。 </p>\n<h2><a href=\"#node-js以及python安装\" name=\"node-js以及python安装\"></a>Node.js以及Python安装</h2>\n<p>这里需要用到的两个软件分别是Python2和Node.js（其中Python必须安装2.x.x版本，Node.js随便安装都无所谓）。</p>\n<p>我们采用安装包的方式安装这两个软件，下载地址为： </p>\n<ul>\n  <li>Python：<a href=\"https://www.python.org/downloads/release/python-2714/\">Python2.7.14</a></li>\n  <li>Node.js:<a href=\"https://nodejs.org/en/\">Node.js 8.9.4LTS</a></li>\n</ul>\n<p>安装过程一路默认就行，但是要注意，需要把Python的根目录添加到环境变量。C:\\Python27 </p>\n<p>其次，Node.js也是需要将其根目录配置到环境变量的。 </p>\n<p>具体流程就不详细介绍了，如果有问题请询度娘。</p>\n<h2><a href=\"#yarn-react-native安装\" name=\"yarn-react-native安装\"></a>Yarn、React Native安装</h2>\n<p>Yarn是Facebook提供的替代npm的工具，可以加速node模块的下载。React Native的命令行工具用于执行创建、初始化、更新项目、运行打包服务（packager）等任务。</p>\n<pre><code>npm install -g yarn react-native-cli\n</code></pre>\n<p>安装完yarn设置镜像源：</p>\n<pre><code>yarn config set registry https://registry.npm.taobao.org --global\nyarn config set disturl https://npm.taobao.org/dist --global    \n</code></pre>\n<p>PS：这里不设置也是可以的，亲测没有什么差别。 </p>\n<h2><a href=\"#android-studio安装\" name=\"android-studio安装\"></a>Android Studio安装</h2>\n<p>React Native是支持3.x版本的。所以博主是用的3.1的版本，这个版本的Android虚拟机做了些优化，无论是启动速度还是性能各个方面都很优秀。另外3.x出来快大半年了，还停留在2.3版本的朋友可以考虑给手中的AS升级了。 </p>\n<p>关于Android Studio的安装我就不详细介绍了，官方教程写的还是很详细的，另外官方教程的安装步骤2.3和3.1的没有差别。</p>\n<p>PS：这里再说一下，Java JDK不支持9.0版本的，我之前用的就是9.0版本，发现不兼容，果断换回了8.0. </p>\n<p>这里直接简述下安装过程，相信AS这种级别的软件安装不是很难吧。</p>\n<p>下载地址：<a href=\"http://www.android-studio.org/\">Android Studio中文社区</a> </p>\n<ul>\n  <li>安装软件的步骤是一路Next就行，没有坑</li>\n  <li>安装完成后打开AS，然后这里会下载一些组件，请保持网络连接。</li>\n  <li>确保 Android SDK和Android Device Emulator选中</li>\n  <li>打开软件后选择custom选项，接下来会叫你选择主题什么的，你开心就好</li>\n  <li>这里SDK Components Setup 里面的东西全部选中，当然你要更改SDK的路径也是可以的</li>\n  <li>安装完成后，在Android Studio的欢迎界面中选择Configure | SDK Manager。</li>\n  <li>在SDK Platforms窗口中，选择Show Package Details，然后在Android 6.0 (Marshmallow)中勾选Google APIs、Android SDK Platform 23、Intel x86 Atom System Image、Intel x86 Atom_64 System Image以及Google APIs Intel x86 Atom_64 System Image。</li>\n  <li>在SDK Tools窗口中，选择Show Package Details，然后在Android SDK Build Tools中勾选Android SDK Build-Tools 23.0.1（必须包含有这个版本。当然如果其他插件需要其他版本，你可以同时安装其他多个版本）。然后还要勾选最底部的Android Support Repository.</li>\n  <li>将SDK的目录加到环境变量，单独配置Android SDK的tools和platform-tools目录添加到PATH变量中。</li>\n</ul>\n<h2><a href=\"#git\" name=\"git\"></a>Git</h2>\n<p>这个安不安装在现阶段是无所谓的，但是作为一个程序员，不用Git感觉就像村里没通电一样。 </p>\n<h2><a href=\"#配置android-device-emulator\" name=\"配置android-device-emulator\"></a>配置Android Device Emulator</h2>\n<p>用过AS的可以跨过这一步。 </p>\n<p>打开Android virture Devices Manager，然后新建就行了。</p>\n<p><br></p>\n<p>OK，到现在基本上环境是安装好了。接下来弄一个小小的demo测试下。 </p>\n<h1><a href=\"#测试\" name=\"测试\"></a>测试</h1>\n<p>在你合适的位置新建一个文件夹用来放置RN的文件。 在此处发开PowerShell（Shift+鼠标右键，选择PowerShell）。输入命令： </p>\n<pre><code>react-native init 你的项目名  \n</code></pre>\n<p><br></p>\n<p>PS：这个下载过程有点长，我用的最短时间是0.25分钟，最长5分钟。 </p>\n<p>接下来在cd进入你的项目，输入以下命令：（在此之前，需要打开模拟器）</p>\n<pre><code>react-native run-android \n</code></pre>\n<p>此时会弹出Node的命令行界面：</p>\n<p><br></p>\n<p>稍等一会就会出现以下界面： </p>\n<p><br></p>\n<p>代表安装成功。 </p>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>只是简单的简述了下我的配置RN的过程，路漫漫其修远兮。后面我会继续学习RN，同时还需要准备下算法学习备战蓝桥杯个人赛。记录下我的安装步骤，在安装的过程中也是需要耐心的，官方教程也不是万能宝典，还是要辩证的来看吧，使用包管理器确实下载很不方便，而且出了问题也不知道出在哪里，还是安装包直接点。如果在安装过程中有不懂的地方，欢迎留言评论。</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:29:44');
INSERT INTO `bg_blog` VALUES (8, 47, 'Hexo-NexT主题添加评论功能（来必力、Hypercomments、畅言、友言）', '最近捣鼓着博客的评论功能，看到很多形形色色的评论插件，比如来必力，畅言等等之类的。功能是各不一样，网上教程是关于某一类的评论插件的介绍，不是很全面，所以本文主要是弄一个全面的评论插件集成，然后分别说一下各自的优点以及不足，千挑万选之后总有一个适合你。我使用的是NexT主题，NexT主题是集成了评论功能的。所以这里就直接是以NexT主题为例了。', '1', 0, '0', 697, 'http://images.bianxiaofeng.com/c395ec9d24ac314bf9ab182a1e7f05f9', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<blockquote>\n  <p>最近捣鼓着博客的评论功能，看到很多形形色色的评论插件，比如来必力，畅言等等之类的。功能是各不一样，网上教程是关于某一类的评论插件的介绍，不是很全面，所以本文主要是弄一个全面的评论插件集成，然后分别说一下各自的优点以及不足，千挑万选之后总有一个适合你。<br>我使用的是NexT主题，NexT主题是集成了评论功能的。所以这里就直接是以NexT主题为例了。<br></p>\n  <h1><a href=\"#多说\" name=\"多说\"></a>多说</h1>\n  <p>多说的功能还是很强大的，加上很早之前就有了各种社交途径的分享，很受大家喜爱。虽然多说在2017年6月1日正式停止，但是还是纪念下多说吧。虽然我没有用过，但是我在一些技术交流群中还是听到很多人在说多说。<br><img src=\"https://i.imgur.com/IcR5S7r.png\"> </p>\n  <h1><a href=\"#hypercomments\" name=\"hypercomments\"></a>Hypercomments</h1>\n  <p>Communication is Empathy.<br>Tailored comment system for your site. </p>\n</blockquote>\n<p><img src=\"https://i.imgur.com/BgAR237.png\"></p>\n<h2><a href=\"#说在前面\" name=\"说在前面\"></a>说在前面</h2>\n<p>这是一个国外的评论系统，总的来说，界面设计等等还是很不错的。在NexT主题中操作也还算简单，事实上所有的评论在NexT上的操作都还是很简单的。 </p>\n<p>但是这个界面是繁体中文的，目前我还没有找到改为简体中文的方法，看着是有一点难受。这个呢，可以**匿名评论**，说到匿名评论其实做的还是不错的，匿名评论可以添加能够联系到你的邮箱地址，这样当有人回答你的时候有邮件提醒。不得不说这点还是不错的。 </p>\n<h2><a href=\"#添加hypercomments评论\" name=\"添加hypercomments评论\"></a>添加Hypercomments评论</h2>\n<ol>\n  <li>在<a href=\"https://www.hypercomments.com/\">Hypercomments</a>官网登录，目前只支持谷歌账号登录，国内有万里长城阻隔，翻墙注意安全！</li>\n  <li>选择Lite版本，点击Install。<img src=\"https://i.imgur.com/gsT39R9.png\"></li>\n  <li>在设置中（齿轮图标的那个），点击Widget，然后在代码框中找到<code>Widget_id</code>，记录下来。</li>\n  <li>在NexT主题的配置文件<code>—config</code>中搜索hypercomments_id，然后去掉前面的#号，冒号后面加一个空格填入上面记录的Id。</li>\n  <li>部署就能看到效果。</li>\n</ol>\n<h2><a href=\"#参考界面\" name=\"参考界面\"></a>参考界面</h2>\n<ol>\n  <li>评论效果： <img src=\"https://i.imgur.com/448OmUd.png\"></li>\n  <li>匿名评论界面：<img src=\"https://i.imgur.com/zdUopLe.png\"></li>\n  <li>Lite Demo ：<a href=\"https://www.hypercomments.com/en/demo?type=blogs\">Demo</a></li>\n</ol>\n<h2><a href=\"#总结\" name=\"总结\"></a>总结</h2>\n<p>繁体中文看的我是很难受。虽然只有几行而已。优点呢是评论可以匿名，可以评论上传图片、影片等。功能还是比较强大，设置界面是英文，且没有中文支持！</p>\n<h1><a href=\"#畅言\" name=\"畅言\"></a>畅言</h1>\n<p><img src=\"https://i.imgur.com/TxLKDXM.png\"></p>\n<blockquote>\n  <p>畅言是业内领先的社会化评论系统，支持PC和移动端两种接入方式，为网站提供了一种全新的评论方式。畅言拥有多种常用账号登录、三重过滤机制、实时的数据统计、快捷数据导出、全面支持移动端等领先功能。充分满足了当前各大网站对于用户登录、评论、分享 、审核等方面的需求。<br>畅言在业内率先实现三重过滤机制。当评论数据产生后，首先经过搜狐垃圾过滤系统，防灌水、防垃圾、防广告；然后经过官方提供违禁词库和站长自定义的敏感词过滤；最后是网站的自主审核，所有畅言合作网站都有专属的管理后台，管理所有本网评论。网站对本站评论拥有完全的管理，可以设置先发后审与先审后发等多种审核形式。 </p>\n</blockquote>\n<h2><a href=\"#添加方法\" name=\"添加方法\"></a>添加方法</h2>\n<ol>\n  <li>注册畅言 <a href=\"https://changyan.kuaizhan.com/\">Go</a></li>\n  <li>\n    <p>将畅言密钥复制到NexT主题的配置文件<code>—config</code>中，搜索changyan，填写下面的代码，注意替换成你的代码。</p>\n    <h1><a href=\"#changyan\" name=\"changyan\"></a>changyan</h1>\n    <p>changyan:<br> enable: true<br> appid: yourid<br> appkey: yourkey</p>\n  </li>\n</ol>\n<p>## 参考界面<br> 1.畅言后台 <img src=\"https://i.imgur.com/Kpb83UA.png\"><br> 2.评论登录后需要手机号码验证：<img src=\"https://i.imgur.com/TsA80yh.png\"><br> 3.评论界面：<img src=\"https://i.imgur.com/C9JCqzJ.png\"><br> ## 总结<br> 关于畅言，大家可能印象最深的是灌水功能了，这个功能目前已经是出于失灵与半失灵的状态，官方估计也没怎么维护了。最难受的是，需要手机号验证，这也就阻挡了大部分的评论者。如果能够添加一个像Hypercomments的匿名功能的话，可能会好很多。最最重要的是，畅言是需要你的备案号的，就是说，你一个没有备案的网站是没法长时间使用畅言的。</p>\n<p># 友言<br> <img src=\"https://i.imgur.com/F9aMLio.png\"><br> &gt; 友言是一个简单而强大的社会化评论及聚合平台。用户可以使用社交账号一键评论同步至社交网络，将内容和自己的评论分享给好友。增加第三方网站用户活跃度，调动好友参与评论，帮助网站实现社会化网络优化SMO，有效提升网站社会化流量！ </p>\n<h2><a href=\"#添加方法\" name=\"添加方法\"></a>添加方法</h2>\n<p>友言的添加方法也极其简单：</p>\n<ol>\n  <li>在<a href=\"http://www.uyan.cc\">友言官网</a>注册账号，得到用户ID</li>\n  <li>将友言ID复制到NexT主题的配置文件<code>—config</code>中，搜索youyan，将youyan_uid前面的#号去掉，将id填写到youyan_uid：后面。</li>\n  <li>部署到你的网站。</li>\n</ol>\n<p>PS：部署成功后可能不会立即显示你的网站，这个时候你去你的网站评论一下就行了。</p>\n<h2><a href=\"#参考界面\" name=\"参考界面\"></a>参考界面</h2>\n<ol>\n  <li>留言评论界面<img src=\"https://i.imgur.com/LK7ij0Z.png\"></li>\n  <li>\n  <p>后台管理界面：<img src=\"https://i.imgur.com/rWfmRzF.png\"><img src=\"https://i.imgur.com/hsEwGrE.png\"></p>\n  <h2><a href=\"#总结\" name=\"总结\"></a>总结</h2>对于友言，我觉得确实是我比较喜欢的类型了，支持匿名评论功能（默认是关闭的，需要手动开启），但是匿名只是匿名，没有留联系方式的地方，这点我觉得还是有点不好。</li>\n</ol>\n<h1><a href=\"#来必力\" name=\"来必力\"></a>来必力</h1>\n<p><img src=\"https://i.imgur.com/UEsZmFf.png\"></p>\n<blockquote>\n  <p>使用社交网站账户登录，免去注册过程。<br>提高用户的参与和沟通意愿。<br>管理/删除我的评论内容。<br>提供管理页面，管理网站文章及评论内容。</p>\n</blockquote>\n<h2><a href=\"#添加方法\" name=\"添加方法\"></a>添加方法</h2>\n<ol>\n  <li>在<a href=\"https://livere.com/\">来必力</a>的官网上注册账号。</li>\n  <li>在<a href=\"https://livere.com/insight/myCode\">此处</a>获取data-uid。</li>\n  <li>打开NexT主题的配置文件<code>—config</code>中，搜索livere_uid，将livere_uid前面的#号去掉，将id填写到livere_uid：后面。</li>\n</ol>\n<h2><a href=\"#参考界面\" name=\"参考界面\"></a>参考界面</h2>\n<ol>\n  <li>设置界面<img src=\"https://i.imgur.com/dvonjM1.png\"></li>\n  <li>数据分析界面<img src=\"https://i.imgur.com/NLFltb6.png\"></li>\n  <li>体验Demo：<a href=\"https://livere.com/city-demo\">Demo</a></li>\n</ol>\n<h2><a href=\"#总结\" name=\"总结\"></a>总结</h2>\n<p>如果大家仔细观察应该能发现这是韩国人的东西，但也正是因为这是外国人的东西，收到国内的各种条条框框的限制比较少。对于来必力，这个产品比较不错，首先界面美化上就比之前的几种类型要好很多。但是没有匿名评论，支持邮箱账号注册评论。</p>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>考试之前就像写一篇博文来介绍这几类评论工具了，但是平时的时候没有特别认真听，导致那个时候一点时间都不敢耽搁。哎~。评论工具还有很多很多，如果需要的话，还是需要自己修改一些代码才行。就我个人感觉而言，我觉得Hypercomments、来必力还有友言都还不错，畅言需要备案。就看各位老铁们喜欢什么了。</p>\n<p>顺便说一句，寒假快乐！</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:27:01');
INSERT INTO `bg_blog` VALUES (9, 51, '大学期间的视频文档', '考完试恍恍惚惚，简直不敢相信大三已经又过去了一半了，时间是真的快。经历了前两天去西岭雪山玩的时候手机丢了的不愉快，决定好好整理了下大学做过的一些东西，做一个备份。', '1', 0, '0', 490, 'http://images.bianxiaofeng.com/657b07046abc1a8dd3de65ea80f37ded.jpg', '2', '<p><span style=\"color: inherit; font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 36px;\">前言</span><br></p>\n<p>考完试恍恍惚惚，简直不敢相信大三已经又过去了一半了，时间是真的快。经历了前两天去西岭雪山玩的时候手机丢了的不愉快，决定好好整理了下大学做过的一些东西，做一个备份。 </p>\n<h2><a href=\"#视频篇\" name=\"视频篇\"></a>视频篇</h2>\n<h3><a href=\"#成都大学信息科学与工程学院-2016年迎新晚会暖场视频\" name=\"成都大学信息科学与工程学院-2016年迎新晚会暖场视频\"></a>成都大学信息科学与工程学院 2016年迎新晚会暖场视频</h3>\n<p>这是我担任学生会科文部部长的时候带领小干事们做的一些东西。权当留个纪念吧，我相信这套视频，对于16级的小同学们来说有着特别的意义。</p><p><a href=\"http://www.iqiyi.com/w_19rwhy0npt.html\" target=\"_blank\">http://www.iqiyi.com/w_19rwhy0npt.html</a><br></p><p> </p>\n<h3>成都大学信息科学与工程学院学生会招新视频</h3><p><a href=\"http://v.youku.com/v_show/id_XMTY5NjQ5NTM4NA==.html\" target=\"_blank\">http://v.youku.com/v_show/id_XMTY5NjQ5NTM4NA==.html</a><br></p>\n<h3>《基于无线传感器网的物联网智慧农业系统》展示视频</h3>\n<p>这一套系统呢是由我担任硬件开发兼项目负责人，我的学长余悦担任软件开发，当时大一小朋友蒋蕊担任项目答辩。最好的成绩呢是获得了全国物联网大赛一等奖。</p><p><a href=\"http://www.iqiyi.com/w_19rwhxeq81.html\" target=\"_blank\">http://www.iqiyi.com/w_19rwhxeq81.html</a><br></p>\n<h3><a href=\"#来影-一款基于ar与3d的旅游软件项目展示\" name=\"来影-一款基于ar与3d的旅游软件项目展示\"></a>来影——一款基于AR与3D的旅游软件项目展示</h3>\n<p>这个是我担任Android开发以及项目负责人做的视频，获得了中星杯计算机作品大赛二等奖，计算机设计大赛，互联网+大赛的一些奖。</p><p><a href=\"http://www.iqiyi.com/w_19rwhwxmw1.html\" target=\"_blank\">http://www.iqiyi.com/w_19rwhwxmw1.html</a><br></p>\n<p>还有很多给老师做的一些视频就不放上来了。 </p>\n<h2><a href=\"#文档篇\" name=\"文档篇\"></a>文档篇</h2>\n<h3><a href=\"#office使用手册\" name=\"office使用手册\"></a>OFFICE使用手册</h3>\n<h4><a href=\"#ppt使用手册\" name=\"ppt使用手册\"></a>PPT使用手册</h4>\n<p><a href=\"https://pan.baidu.com/s/1c3T7Nf6\">PPT 使用手册</a> </p>\n<p><br></p>\n<h4><a href=\"#word使用手册\" name=\"word使用手册\"></a>Word使用手册</h4>\n<p><a href=\"https://pan.baidu.com/s/1sneCBmt\">Word 使用手册</a> </p>\n<p><br></p>\n<h4><a href=\"#excel使用手册\" name=\"excel使用手册\"></a>Excel使用手册</h4>\n<p><a href=\"https://pan.baidu.com/s/1pNaCVvt\">Excel 使用手册</a> </p>\n<p><br></p>\n<p>洋洋洒洒的几十页，在成都大学信工学院的学生群里面传播，也希望能够实实在在的帮助到他们。 如果有需要的话可以直接下载了。 </p>\n<h3><a href=\"#it来袭策划书\" name=\"it来袭策划书\"></a>IT来袭策划书</h3>\n<p>当然了，作为部长的我是经历了成都大学第八届、第九届、第十届的IT来袭的，覆盖全校的校级大型活动，作为负责人还是很辛苦的，也很感谢我身边的人，不管是我的老部长还有小干事们，还有帮助我们活动的各位老大们。 </p>\n<p><br></p>\n<p>链接：<a href=\"https://pan.baidu.com/s/1mkd0ScS\" target=\"_blank\">https://pan.baidu.com/s/1mkd0ScS </a>密码：0hdb </p>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>还是有一些感触的，很多视频做的时候就完全不知道怎么做，逼出来的，现在看看还是很不错的。权当留个纪念吧，自己的电脑是一日不如一日，不知道什么时候就彻底歇逼了。对于IT来袭活动，印象应该是最深的了吧。我全程陪伴，全程关注。分配了任务，我会一点一点的督促落实，也得到了各位老师同学的肯定，参与人数达历史新高，近2000人。<br>科文部确实是一个很好的部门，带给人的影响积极而无声。</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:28:51');
INSERT INTO `bg_blog` VALUES (10, 47, '使用VSCode+七牛云图床插件+自定义快捷键配置Hexo博文编写环境', '在我的电脑上安装了MarkdownPad++还有VSCode（主要是用来写前端的），VSCode也是可以写md文章的。之所以之前我是安装了MarkdownPad++，是因为它有一个可以上传图片的功能，再加上它还有一些VSCode没有的快捷键，所以一直是两个软件并存，直到今天重新捣鼓了一下，终于可以去掉MarkdownPad++了。不得不说VSCode确实很强大，更加难得的是支持中文，这使我对这个软件的好感度哧溜的加加加。特写下这个教程，方便同样是我这种情况的朋友。', '1', 0, '0', 148, 'http://images.bianxiaofeng.com/a84de350481ef677137400738fbb533f.png', '2', '<p><br></p>\n<h1><a href=\"#使用vscode-七牛云图床插件-自定义快捷键配置hexo博文编写环境\" name=\"使用vscode-七牛云图床插件-自定义快捷键配置hexo博文编写环境\"></a>使用VSCode+七牛云图床插件+自定义快捷键配置Hexo博文编写环境</h1>\n<h1>前言</h1><p><br></p><p>PS:本文图片失效，所有内容失效。</p><p><br></p>\n<p>在我的电脑上安装了MarkdownPad++还有VSCode（主要是用来写前端的），VSCode也是可以写md文章的。之所以之前我是安装了MarkdownPad++，是因为它有一个可以上传图片的功能，再加上它还有一些VSCode没有的快捷键，所以一直是两个软件并存，直到今天重新捣鼓了一下，终于可以去掉MarkdownPad++了。不得不说VSCode确实很强大，更加难得的是支持中文，这使我对这个软件的好感度哧溜的加加加。 </p>\n<p>特写下这个教程，方便同样是我这种情况的朋友。<br></p>\n<h1><a href=\"#过程\" name=\"过程\"></a>过程</h1>\n<ul>\n  <li>\n  <p>首先你得要有VSCode对吧，没有的话我也是附上链接：<a href=\"https://code.visualstudio.com/\">Go</a></p></li>\n  <li>\n  <p>其次是在VSCode中安装一个预览MD文件的插件<code>Markdown Preview Enhanced</code>，这样写文章的时候能够做到实时预览了。</p><p><br></p><p> </p></li>\n</ul>\n<p><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-2018119155259.png\" alt=\"{mdFileName}-2018119155259\"></p>\n<ul>\n  <li>为了能够最大程度的获得一些markdown的通用快捷键，这里可以下载一个<code>Markdown Shortcuts</code>插件，比如Ctrl+l插入链接、Ctrl+B加粗之类的。</li>\n</ul>\n<p><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-2018119155358.png\" alt=\"{mdFileName}-2018119155358\"> </p>\n<ul>\n  <li>\n    <p>最核心的一步——安装七牛云图床插件。</p>\n    <ul>\n      <li>\n      <p>安装插件<code>qiniu-upload-image</code>。<br><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-2018119155541.png\" alt=\"{mdFileName}-2018119155541\"></p></li>\n      <li>\n      <p>注册<a href=\"https://www.qiniu.com/\">七牛云</a>（注册后需要认证，我的认证时间是半天。）<br>接着在<img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-201811916325.png\" alt=\"{mdFileName}-201811916325\">新建对象存储。这里会有一个默认的【测试域名】，如果你的网站还没有备案的话，就用这个默认的吧。备案了的可以自定义域名。</p></li>\n      <li>\n        <p>配置VSCode过程 </p>\n        <ul>\n          <li>依次打开【文件】-【首选项】-【设置】</li>\n          <li>在【搜索设置】中搜索<code>qiniu</code>关键字</li>\n          <li>将【qiniu configuration】中的6个子设置从【默认设置】拷贝到【用户设置】<br><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-2018119155911.png\" alt=\"{mdFileName}-2018119155911\"></li>\n          <li>其中的【AccessKey 签名授权】【SecretKey 签名授权】在<a href=\"https://portal.qiniu.com/user/key\">密钥管理</a></li>\n          <li>七牛图片上传空间是你的存储空间的名字，七牛图床域名为测试域名。</li>\n        </ul>\n      </li>\n    </ul>\n  </li>\n  <li>\n    <p>接着还想在VSCode里面直接完成部署功能。<br>有两种方法：</p>\n    <ul>\n      <li>1 安装<code>vscode-Hexo</code>插件 然后直接在命令面板中输入以下命令：<br><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-201811916939.png\" alt=\"{mdFileName}-201811916939\"></li>\n      <li>2 按住Ctrl+` 在VSCode中弹出终端，也可以在这里面直接输入命令操作。<br><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-2018119161338.png\" alt=\"{mdFileName}-2018119161338\"></li>\n    </ul>\n  </li>\n</ul>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>卸载掉MarkdownPad ，电脑又轻松了几百M。如果需要帮助的盆友请留言。</p>\n<p>2018年5月29日12:32:48更新</p>\n<p>最近收到读者给我发的邮件说会出现如下情况：</p>\n<p><img src=\"http://p2sj58chj.bkt.clouddn.com/QQ截图20180529123226.png\" alt=\"QQ截图20180529123226\"></p>\n<p>经过研究，这里出现的原因是因为快捷键冲突，因为七牛云的插件的默认设置是：</p>\n<p><em>粘贴图片路径上传：SHIFT + P<br>直接选择图片上传：SHIFT + O</em></p>\n<p>所以，在设置里面更改快捷键，比如我相关**Ctrl+G**表示上传图片。</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:35:58');
INSERT INTO `bg_blog` VALUES (12, 52, 'Android BroadcastReceiver 的静态动态注册及区别', '为了方便Android系统各个应用程序及程序内部进行通信，Android系统引入了一套广播机制。各个应用程序可以对感兴趣的广播进行注册，当系统或者其他程序发出这条广播的时候，对发出的广播进行注册的程序便能够收到这条广播。为此，Android系统中有一套完整的API，允许程序只有的发送和接受广播。本文会分别介绍静态注册广播和动态注册广播的方法并比较这两种的区别。', '1', 0, '0', 180, 'http://images.bianxiaofeng.com/7725d208415a957e91facd27ec740cbb.png', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>为了方便Android系统各个应用程序及程序内部进行通信，Android系统引入了一套广播机制。各个应用程序可以对感兴趣的广播进行注册，当系统或者其他程序发出这条广播的时候，对发出的广播进行注册的程序便能够收到这条广播。为此，Android系统中有一套完整的API，允许程序只有的发送和接受广播。<br>本文会分别介绍静态注册广播和动态注册广播的方法并比较这两种的区别。<br><br><strong>在此会先说明发送广播的两种方法</strong></p>\n<h1><a href=\"#广播两种基本类型\" name=\"广播两种基本类型\"></a>广播两种基本类型</h1>\n<p>在一个程序中，可以发送广播供当前程序的广播接收器收到。首先我们来看下两种方式的发送广播。<br>在Android系统中，主要有两种基本的广播类型：<br>- 标准广播（Normal Broadcasts）<br>- 有序广播（Ordered Broadcasts） </p>\n<h2><a href=\"#标准广播\" name=\"标准广播\"></a>标准广播</h2>\n<p>是一种完全异步执行的广播，在广播发出之后，所有的广播接收器会在同一时间接收到这条广播，广播无法被截断。 </p>\n<p>发送广播的方式十分简单，只需要实例化一个**Intent**对象，然后调用**context**的** sendBroadcast() **方法。 </p>\n<pre><code>        //intent中的参数为action\n        Intent intent=new Intent(\"com.example.dimple.BROADCAST_TEST\");\n        sendBroadcast(intent);\n</code></pre>\n<p>这样就完成了广播的发送，至于接收呢，需要用到广播接收器，这个下面会写到。 </p>\n<h2><a href=\"#有序广播\" name=\"有序广播\"></a>有序广播</h2>\n<p>是一种同步执行的广播，在广播发出之后，优先级高的广播接收器可以优先接收到这条广播，并可以在优先级较低的广播接收器之前截断停止发送这条广播。 </p>\n<p>至于有序广播： </p>\n<pre><code>        //intent中的参数为action\n        Intent intent=new Intent(\"com.example.dimple.BROADCAST_TEST\");\n        sendOrderBroadcast(intent，null);//第二个参数是与权限相关的字符串。\n</code></pre>\n<p>到此时，如果你的程序中只有一个广播接收器的话，是体现不出有序广播的特点的，<br>右击包名——New——Other——BroadcastReceiver多创建几个广播接收器。 </p>\n<p>此时你还是会发现，所有的广播接收器是同时接收到广播消息的。注意上面介绍的时候说到优先级，这个时候我们需要设置优先级，在AndroidManifest文件中的Receiver标签中设置广播接收器的优先级。 </p>\n<pre><code>        &lt;receiver\n            android:name=\".MyReceiver\"\n            android:enabled=\"true\"\n            android:exported=\"true\"&gt;\n            &lt;!--注意此时有一个Priority属性--&gt;\n            &lt;intent-filter android:priority=\"100\"&gt;\n                &lt;action android:name=\"android.intent.action.BROADCAST_TEST\"&gt;&lt;/action&gt;\n            &lt;/intent-filter&gt;\n        &lt;/receiver&gt;\n</code></pre>\n<p>优先级越高的广播接收器可以先收到广播，也可以在收到广播的时候调用**abortBroadcast()**方法截断广播。优先级低的广播接收器就无法接收到广播了。</p>\n<h1><a href=\"#注册广播\" name=\"注册广播\"></a>注册广播</h1>\n<h2><a href=\"#自定义broadcastreceiver\" name=\"自定义broadcastreceiver\"></a>自定义BroadcastReceiver</h2>\n<p>在Android的广播接收机制中，如果需要接收广播，就需要创建广播接收器。而创建广播接收器的方法就是**新建一个类（可以是单独新建类，也可以是内部类（public））** 继承自**BroadcastReceiver** </p>\n<pre><code>   class myBroadcastReceiver extends BroadcastReceiver{\n\n        @Override\n        public void onReceive(Context context, Intent intent) {\n            //接收到广播的处理，注意不能有耗时操作，当此方法长时间未结束，会报错。\n            //同时，广播接收器中不能开线程。\n        }\n    } \n\n</code></pre>\n<h2><a href=\"#两种注册方法\" name=\"两种注册方法\"></a>两种注册方法</h2>\n<h3><a href=\"#动态注册\" name=\"动态注册\"></a>动态注册</h3>\n<p>所谓动态注册是指在代码中注册。步骤如下 ：<br>- 实例化自定义的广播接收器。<br>- 创建**IntentFilter**实例。<br>- 调用**IntentFilter**实例的**addAction()**方法添加监听的广播类型。<br>- 最后调用**Context**的**registerReceiver(BroadcastReceiver,IntentFilter)**动态的注册广播。 </p>\n<p>此时，已经为我们自定义的广播接收器绑定了广播，当收到和绑定的广播一直的广播的时候，就会调用广播接收器中的**onReceiver**方法。 </p>\n<pre><code>        MyBroadcastReceiver myBroadcastReceiver=new MyBroadcastReceiver();\n        IntentFilter intentFilter=new IntentFilter();\n        intentFilter.addAction(\"com.example.dimple.MY_BROADCAST\");\n        registerReceiver(myBroadcastReceiver,intentFilter);\n</code></pre>\n<p>PS:这里提醒一点，如果需要接收系统的广播（比如电量变化，网络变化等等），别忘记在AndroidManifest配置文件中加上权限。 </p>\n<p>另外，动态注册的广播在活动结束的时候需要取消注册： </p>\n<pre><code>    @Override\n    protected void onDestroy() {\n        super.onDestroy();\n        unregisterReceiver(myBroadcastReceiver);\n    }  \n</code></pre>\n<h3><a href=\"#静态注册\" name=\"静态注册\"></a>静态注册</h3>\n<p>这里我们使用静态注册来接收开机广播。<br>使用Android Studio 中的快捷方法来创建广播接收器。 </p>\n<p>右击包名——New——Other——BroadcastReceiver。 </p>\n<p><br></p><p><img src=\"http://images.bianxiaofeng.com/0a57cd5786f277552c214d355a3f840f.png\" style=\"\"><br></p><p> </p>\n<p>PS：静态注册的广播接收器需要在AndroidManifest文件中注册，由于使用的AS的快捷方式，所以已经创建好了。<br>如图所示：</p><p><br></p><p><img src=\"http://images.bianxiaofeng.com/a9c64edbbae3798c65dd510777d11596.png\" style=\"\"><br></p>\n<p>在创建好的广播接收器中添加一个Toast提示。代码如下： </p>\n<pre><code class=\"public class MyReceiver extends BroadcastReceiver {\">    @Override\n    public void onReceive(Context context, Intent intent) {\n        Toast.makeText(context,\"开机启动！\",Toast.LENGTH_LONG).show();\n    }  \n}```\n    \n然后在AndroidManifest文件中添加：  \n\n- 权限  \n`&lt;uses-permission android:name=\"android.permission.RECEIVE_BOOT_COMPLETED\"&gt;&lt;/uses-permission&gt; `    \n\n- Intent-filter  \n\n</code></pre>\n<pre><code>    &lt;receiver\n        android:name=\".MyReceiver\"\n        android:enabled=\"true\"\n        android:exported=\"true\"&gt;\n        &lt;!--添加以下3行--&gt;\n        &lt;intent-filter&gt;\n            &lt;action android:name=\"android.intent.action.BOOT_COMPLETED\"&gt;&lt;/action&gt;\n        &lt;/intent-filter&gt;\n    &lt;/receiver&gt;\n</code></pre>\n<p>```</p>\n<p>此时重启Android系统就可以收到开机提示了。 </p>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>动态注册和静态注册的区别： </p>\n<ul>\n  <li>\n  <p>动态注册的广播接收器可以自由的控制注册和取消，有很大的灵活性。但是只能在程序启动之后才能收到广播，此外，不知道你注意到了没，广播接收器的注销是在onDestroy()方法中的。所以广播接收器的生命周期是和当前活动的生命周期一样。</p></li>\n  <li>\n  <p>静态注册的广播不受程序是否启动的约束，当应用程序关闭之后，还是可以接收到广播。</p></li>\n</ul>\n<p>标准广播和有序广播的接收和发送都是全局性的，这样会使得其他程序有可能接收到广播，会造成一定的安全隐患。为了解决这个问题，Android系统中有一套本地广播的机制。这个机制是让所有的广播事件（接收与发送）都在程序内部完成。主要是采用的一个<b>localBroadcastReceiver</b>对广播进行管理。 </p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:36:34');
INSERT INTO `bg_blog` VALUES (13, 52, 'Android Activity生命周期', '在Android开发的过程中，有一个特别重要的组件：Activity，它是除了Windows、Dialog和Toast之外我们用户可以直接看到的界面。本文主要记录下研究Activity中的一些感悟。首先Activity的生命周期总体来说可以分为两种：', '1', 0, '0', 186, 'https://i0.wp.com/picjumbo.com/wp-content/uploads/DSC01899.jpg?w=2210&quality=50', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>在Android开发的过程中，有一个特别重要的组件：Activity，它是除了Windows、Dialog和Toast之外我们用户可以直接看到的界面。本文主要记录下研究Activity中的一些感悟。<br>首先Activity的生命周期总体来说可以分为两种： </p>\n<ul>\n  <li>正常情况下的Activity生命周期</li>\n  <li>\n  <p>异常情况下的Activity生命周期<br></p>\n  <h1><a href=\"#正常情况下的生命周期\" name=\"正常情况下的生命周期\"></a>正常情况下的生命周期</h1>\n  <blockquote>\n    <p>所谓的正常的生命周期是指：在有用户的参与的情况下，Activity经历的生命周期的改变。 </p>\n  </blockquote></li>\n</ul>\n<p>首先上一张Activity的生命流程切换的图： </p>\n<p><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-201835125748.png\" alt=\"{mdFileName}-201835125748\"> </p>\n<h2><a href=\"#7种状态方法说明\" name=\"7种状态方法说明\"></a>7种状态方法说明</h2>\n<p>接着对每个方法进行解释说明：<br> - onCreate()方法：——【**此时处于Activity在后台不可见**】<br> 表示Activity正在被创建，这是在Android开发中接触的最多的方法，比如常见的**setContentView()**加载布局资源，对控件和某些数字进行初始化等等。 </p>\n<ul>\n  <li>onStart()方法：——【**此时Activity在后台可见**】<br> 表示启动，此时的Activity已经是处于可见状态了，但是还没有出现在前台，所以还不能进行交互。</li>\n  <li>onResume()方法——【**此时Activity在前台且可见**】<br> 表示Activity已经可见了，且出现在前台。和**onStart()和onResume()**方法的都是可见状态，但是**onResume()**方法表示工作在前台。</li>\n  <li>\n  <p>onPause()方法——【**此时Activity在前台可见**】 </p></li>\n</ul>\n<p>表示Activity即将终止，此时主要做一些比较耗时的操作，如相关资源回收等。 </p>\n<ul>\n  <li>\n  <p>onDestroy()方法——【**Activity不可见**】<br>表示Activity即将被销毁，这是Activity的最后一个生命周期，在这里了可以做一些最终资源的回收和资源的释放工作等等。</p></li>\n  <li>\n  <p>onRestart()方法——【**Activity重新可见**】<br>表示Activity正在重新启动，触发条件为从不可见转为可见。比如从当前Activity回到上一个Activity，或者从桌面返回到应用程序中去。 </p></li>\n</ul>\n<h2><a href=\"#具体场景分析\" name=\"具体场景分析\"></a>具体场景分析</h2>\n<ul>\n  <li>Activity启动——Activity可见状态的回调情况：<br><code>onCreate()--onStart()--onResume();</code></li>\n  <li>当打开新的Activity或者从当前Activity返回到桌面：</li>\n  <li>当再次返回到原Activity(从不可见状态切换到可见状态)：<br><code>onRestart()--onStart()--onResume()</code></li>\n  <li>当按下Back键或者退出应用程序：</li>\n</ul>\n<h2><a href=\"#疑难问题\" name=\"疑难问题\"></a>疑难问题</h2>\n<ul>\n  <li>当用户启动一个新的Activity，那么之前Activity的onPause和当前Activity的onResume谁先执行？</li>\n</ul>\n<p>onPause方法先执行，只有当前的Activity的onPause执行完毕之后才会执行新的Activity的onResume方法。 </p>\n<h1><a href=\"#异常情况下的生命周期\" name=\"异常情况下的生命周期\"></a>异常情况下的生命周期</h1>\n<blockquote>\n  <p>Android 系统出了会受到用户操作导致正常的生命周期异常结束，还有一些异常情况，比如当Android资源配置改变以及系统内存不足的情况下，Activity可能会被杀死。这个时候的生命周期可能会有一些不同。 </p>\n</blockquote>\n<h2><a href=\"#资源相关的系统配置发生改变导致activity被杀死\" name=\"资源相关的系统配置发生改变导致activity被杀死\"></a>资源相关的系统配置发生改变导致Activity被杀死</h2>\n<p>在默认情况下，如果Activity不做特别处理的话，当系统配置发生改变之后，Activity会被销毁并被重新创建。 </p>\n<p>而关于保存和恢复View中的内容的系统工作流程如下：<br>首先Activity异常后，会直接调用onSaveInstaenceState保存数据，然后Activity会委托Windows保存数据，接着WWindows会调用上面的顶层容器去保存数据，最后顶层容器再通知每一个子View保存数据。 </p>\n<p>只有在Activity异常终止的时候才会onSaveInstanceState和onRestoreInstanceState来存储和恢复数据，其他的情况是不会触发这个过程的。 </p>\n<h2><a href=\"#资源内存不足导致低优先级的activity被杀死\" name=\"资源内存不足导致低优先级的activity被杀死\"></a>资源内存不足导致低优先级的Activity被杀死</h2>\n<p>Activity优先级如下：<br>- 前台Activity——正在和用户进行交互的Activity，其优先级最高。<br>- 可见但是非前台的Activity——比如Activity中弹出一个对话框，导致Activity可见但是位于前台无法直接和用户进行交互。 </p>\n<p>当系统内存不足的时候，系统会按照优先级的顺序从低到高的杀死目标Activity的进程，然后通过onSaveInstanceState和onRestoreInstance来存储和恢复数据。<br>一些后台工作不适合脱离四大组件运行，这样的话进程很快被系统杀死。所以一般的做法是将后台工作放在Services中来保证进程具有一定的优先级，这样进程才不会被轻易的杀死。 </p>\n<p>当系统的配置发生改变之后，Activity会被重新创建。采用以下方式可以不让Activity重新创建。<br>可以在AndroidManifest中给Activity指定configChanges属性。 </p>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:27:41');
INSERT INTO `bg_blog` VALUES (14, 52, 'Android Activity的启动模式', '当用户多次启动同一个Activity的时候，系统默认会一直为这个Activity创建实例，并将实例放入任务栈中，在用户按back键的时候会一一回退，每按一次任务栈的时候，栈顶的任务就会出栈，当任务栈为空的时候系统会回收这个任务栈。这就是在默认的情况下，系统对于Activity的处理方式。而这种默认的方式在某些时候可能不太符合开发者的意图。所以Android出现了多种的启动模式和标志位来更改这一默认的行为。', '1', 0, '0', 188, 'http://images.bianxiaofeng.com/7725d208415a957e91facd27ec740cbb.png', '2', '<p><span style=\"color: inherit; font-family: inherit; font-size: 30px;\">前言</span><br></p>\n<p>当用户多次启动同一个Activity的时候，系统默认会一直为这个Activity创建实例，并将实例放入任务栈中，在用户按back键的时候会一一回退，每按一次任务栈的时候，栈顶的任务就会出栈，当任务栈为空的时候系统会回收这个任务栈。这就是在默认的情况下，系统对于Activity的处理方式。而这种默认的方式在某些时候可能不太符合开发者的意图。所以Android出现了多种的启动模式和标志位来更改这一默认的行为。<br></p>\n<h1><a href=\"#activity的launchmode\" name=\"activity的launchmode\"></a>Activity的LaunchMode</h1>\n<p>目前有四种LaunchMode，分别是：standard、singleTop、singleTask以及singleInstance。<br>为了方便说明和解释，我这里写了一个Demo，以上传到GitHub，详情请<a href=\"https://github.com/DimpleFeng/Android-Activity-LaunchMode\">点击</a>。界面如下：<br><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-201837155052.png\" alt=\"{mdFileName}-201837155052\"><br>分别对应4种状态的LaunchMode。</p>\n<h2><a href=\"#standard-launchmode\" name=\"standard-launchmode\"></a>standard LaunchMode</h2>\n<p>标准模式，这是系统默认的模式，每次启动的Activity的时候会默认创建一个实例，不管这个实例是不是存在。被创建的Activity实例符合典型情况下的生命周期。<br>在这种情况下，谁启动了这个Activity，那么这个Activity就属于启动它的Activity的任务栈中。比如： A启动了B，那么B就属于A的任务栈的成员。 </p>\n<p>Demo点击第一项按钮4下结果如下：<br><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-201837123217.png\" alt=\"{mdFileName}-201837123217\"><br>可以看到：<br>这里依次调用了4次的onCreate，且每次的hashcode都不一样。说明分别创建了4次Activity实例。而且任务栈的ID一直都是88.这也就说明了**谁启动Activity，该Activity就位于哪个任务栈中的说法**。</p>\n<h2><a href=\"#singletop-launchmode\" name=\"singletop-launchmode\"></a>singleTop LaunchMode</h2>\n<p>栈顶复用模式。在这种模式下，如果新的Activity已经处于任务栈的栈顶，那么这个Activity将不会被创建。同时，它的onNewIntent方法会被回调，通过此方法就可以取出当前请求的信息。但是如果新的Activity不是位于栈顶，那么这个Activity会被实例化。<br>比如： 一个任务栈中从栈顶到栈底的Activity顺序是：ABCD，如果需要启动任务A，任务A的启动模式为singleTop，那么这个A不会被实例化，而是会调用onNewIntent方法。如果需要启动B，任务B的启动模式为singleTop，那么由于B不在栈顶，那么依然会实例化B，此时任务栈的顺序是：BABCD。 </p>\n<p>Demo第二项点击4下Log如图所示：<br><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-201837155237.png\" alt=\"{mdFileName}-201837155237\"><br>可以看到：<br>只第一次点击的时候调用了onCreate方法，之后便是调用的onNewIntent方法。而且hashcode都是一样的。这就说明：**新的Activity如果位于栈顶，那么新的Activity不会被实例化。**</p>\n<h2><a href=\"#singletask-launchmode\" name=\"singletask-launchmode\"></a>singleTask LaunchMode</h2>\n<p>栈内复用模式。在这种模式下，只要Activity在任务栈中存在，那么就不会重新创建实例，和singleTop一样，系统会自动回调onNewIntent方法。<br>比如：当前任务栈中有ABCD四个Activity，需要启动一个Activity C，这个时候任务栈中有Activity C，那么会直接将Activity C调到栈顶，同时回调onNewIntent方法，**由于singleTask具有cleanTop的效果**，所以此时的任务栈的Activity为CD。如果需要启动Activity F，而Activity F不存在，所以会直接实例化Activity F，并压入栈顶。 </p>\n<p>log截图如下： </p>\n<p><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-201837155659.png\" alt=\"{mdFileName}-201837155659\"> </p>\n<p>这里的操作步骤是：<br>点击进入到singleTask界面，此时出现第一个onCreate，然后点击进入到其他Activity，出现第二个onCrete。此时应该注意到，任务栈的栈顶是其他Activity，这个时候在其他Activity点击返回到singTask。由于采用的是singleTask模式，singleTask已经在任务栈中，所以是直接调用，回调onNewIntent。 </p>\n<p><strong>而且由于cleanTop效果，按返回键的时候，其他Activity是不会再出现的。</strong>这一点的话，在BaseActivity.java中重写生命周期的方法就能看出来。 </p>\n<h2><a href=\"#singleinstance-launchmode\" name=\"singleinstance-launchmode\"></a>singleInstance LaunchMode</h2>\n<p>单实例模式。这是一种加强的singleTask模式，具有singleTask的所有特性（cleanTop等），还有一点：使用这种模式的Activity只能单独的位于一个单独的任务栈中。<br>比如：Activity A是singleInstance模式，当A启动后，系统会单独为这个A创建一个任务栈，由于栈内复用的原因，不会再创建新的Activity A的实例。<br><img src=\"http://p2sj58chj.bkt.clouddn.com/%7BmdFileName%7D-2018371622.png\" alt=\"{mdFileName}-2018371622\"><br>由于这个是单实例模式，对于同一个Activity来说，是直接复用。 </p>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>TaskAffinity，任务相关性，这个参数标识了一个Activity需要的任务栈的名字，在默认情况下，这个任务栈的名字为应用的包名。任务栈分为前台任务栈和后台任务栈。位于后台任务栈的Activity是处于暂停状态。</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:27:26');
INSERT INTO `bg_blog` VALUES (15, 52, 'Android InterFilter 匹配', '一般来说，启动Activity的方法有两种，显式启动和隐式启动。对于显示启动来说，只需要实例化一个Intent对象，指明被启动对象的组件信息，包括包名以及类名。例如', '1', 0, '0', 190, 'http://images.bianxiaofeng.com/7725d208415a957e91facd27ec740cbb.png', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>一般来说，启动Activity的方法有两种，显式启动和隐式启动。对于显示启动来说，只需要实例化一个Intent对象，指明被启动对象的组件信息，包括包名以及类名。例如 </p>\n<pre><code>Intent intent=new Intent(MainActivity.this,OtherActivity.class);\n</code></pre>\n<p>原则上是单独的使用隐式启动和显式启动，如果两者并存的话，以显式启动为准。<br>隐式调用需要Intent能够匹配目标组件的IntentFilter设置的过滤信息，如果不匹配的话是不能正常的启动Activity。Intent中需要过滤的信息包括：action、category和data。 </p>\n<h1><a href=\"#intentfilter的匹配规则\" name=\"intentfilter的匹配规则\"></a>IntentFilter的匹配规则</h1>\n<p>一个过滤列表中的action，category，data可以有多个，所有的action，category，data分别构成不同的类别。只要有一个Intent能够同时匹配action、category、data类别才能匹配成功。一个Activity可以有多个IntentFilter，只要成功的符合一组IntentFilter就可以启动相应的Activity。 </p>\n<h2><a href=\"#action的匹配规则\" name=\"action的匹配规则\"></a>action的匹配规则</h2>\n<p>action是一个字符串，系统定义了一些，同时也支持自定义此字符串。action**严格区分大小写**。 </p>\n<p>一个过滤规则中可以有多个action，只要有一个action和intent匹配，就可以匹配成功。 </p>\n<p><strong>IntentFilter必须存在，否则不能启动Activity。</strong> </p>\n<h2><a href=\"#category匹配规则\" name=\"category匹配规则\"></a>category匹配规则</h2>\n<p>category也是字符串，系统也有默认的字符串，和action匹配规则不同的是，在intent中可以不用特别指明category属性。 </p>\n<p><strong>IntentFilter中必须要有</strong><code>&lt;category android:name=\"android.intent.category.DEFAULT\"/&gt;</code> 无论intent是否调用addCategory()方法。 </p>\n<p>在Manifest文件中也可以像action一样设置多个category标签，只要有一个匹配就可以。 </p>\n<pre><code> Intent intent = new Intent();\n     intent.setAction(\"com.example.dimple.action.activity2\");\n     intent.addCategory(\"com.example.dimple.category.activity2\");\n    //判断是否有Activity能够匹配intent。防止启动报错！\n     if (intent.resolveActivity(getPackageManager()) != null) {\n         startActivity(intent);\n      }\n</code></pre>\n<h2><a href=\"#data的匹配规则\" name=\"data的匹配规则\"></a>data的匹配规则</h2>\n<p>data的匹配规则和action类似，如果过滤规则中定义了data，那么在Intent中也需要有可以与之匹配的data。但data可以省略不写。 </p>\n<p>语法如下： </p>\n<pre><code> &lt;data android:scheme=\"string\" \n android:host=\"string\" \n android:port=\"number\" \n android:path=\"/string\" \n android:pathPattern=\"string\" \n android:pathPrefix=\"/string\" \n android:mimeType=\"string\"/&gt;\n</code></pre>\n<p>data 由两部分组成，mimeType和URL（mimeType表示媒体类型，比如image/jpg、audio/mp3等，可以表示图，文本等不同格式），URL的格式如下： </p>\n<p><code>&lt;scheme&gt;://&lt;host&gt;:&lt;port&gt;/[&lt;path&gt;|&lt;pathPrefix&gt;|&lt;pathPattern&gt;]</code><br>- scheme:URL的模式，比如http、file、content，如果URL中没有scheme，那么URL无效。<br>- host：主机名称，比如www.bianxiaofeng.com，如果没有host，则URL无效。<br>- port：端口<br>-path、pathPattern、pathPrefix：表示路径信息 </p>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>在通过隐式启动Activity的时候，最好是通过PackageManager的resolveActivity方法或者Intent的resolveActivity方法来判断下是不是有能够负责匹配规则的Activity存在，防止异常出错。 </p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:27:14');
INSERT INTO `bg_blog` VALUES (16, 52, 'Execution failed for task \':app:transformDexArchiveWithExternalLibsDexMergerForDebug\'的解决办法', '在Android的开源环境下，也就多出来很多优秀的第三方的项目，但是因为很多第三方的项目和目前你正在开发的APP使用的Lib有些是重复的，这样会导致transformClassesWithDexForDebug', '1', 0, '0', 420, 'http://images.bianxiaofeng.com/7725d208415a957e91facd27ec740cbb.png', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>在Android的开源环境下，也就多出来很多优秀的第三方的项目，但是因为很多第三方的项目和目前你正在开发的APP使用的Lib有些是重复的，这样会导致<b>transformClassesWithDexForDebug</b></p>\n<p><img src=\"http://images.bianxiaofeng.com/615a231d32e95f7c17055c7b906d9c20.png\" style=\"\"><br></p>\n<p>本文介绍年两种方法来处理这个问题。<br></p>\n<h1><a href=\"#解决方案\" name=\"解决方案\"></a>解决方案</h1>\n<h2><a href=\"#添加-multidexenabled-true-到-defaultconfig\" name=\"添加-multidexenabled-true-到-defaultconfig\"></a>添加“multiDexEnabled true”到 defaultConfig</h2>\n<p>在app的build.gradle文件中的 defaultConfig添加： </p>\n<p><code>multiDexEnabled true</code><br>如图所示：</p><p><img src=\"http://images.bianxiaofeng.com/a562375d9b1458bc22e0c43ddfeba579.png\" style=\"\"><br></p>\n<p>这样的设置只能解决一部分的问题，而更加难受的情况是在项目中引入了很多的第三方库，这个时候鬼知道哪个库出了问题，一个一个试可能能够找出来，但是找出来黄花菜都凉了。 </p>\n<p>这个时候请移步解决方法二 </p>\n<h2><a href=\"#根据message信息找到重复的包\" name=\"根据message信息找到重复的包\"></a>根据Message信息找到重复的包</h2>\n<p>在Setting-&gt;Build,Execution,Deployment-&gt;Compiler中的Command-line Opptions中输入**–stacktrace**启用堆栈跟踪</p><p><img src=\"http://images.bianxiaofeng.com/2e03c48ad95cd4925f9ff167419f9c7d.png\" style=\"\"><br></p>\n<p>接着运行APP，就能够在Message上面输出： </p>\n<p><img src=\"http://images.bianxiaofeng.com/962eb9aa80df78c5158c5cf0f2e43cf4.png\" style=\"\"><br></p>\n<p>这样我根据上面消息找到了butterknife重复包。 </p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:35:39');
INSERT INTO `bg_blog` VALUES (17, 15, 'Qt实现串口通信控制51单片机（上下位机）', 'Qt是我在大一下学期开始接触的，当时刚学完C++，然后每天对着黑漆漆的console窗口，在偶然的机会接触到Qt这个跨平台的C++应用程序开发框架。又在老师的怂恿下（单片机老师说如果做出上下位机实验成绩就是满分），使用Qt来进行上下位机的开发。当然实现的功能很简单，控制LED灯的明灭，输入数字显示在数码管上，控制继电器和蜂鸣器以及定时器。', '1', 0, '0', 160, 'http://images.bianxiaofeng.com/f6cb09b6ccd9ee4b6beec27b1d40fb26.jpg', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>Qt是我在大一下学期开始接触的，当时刚学完C++，然后每天对着黑漆漆的console窗口，在偶然的机会接触到Qt这个跨平台的C++应用程序开发框架。又在老师的怂恿下（单片机老师说如果做出上下位机实验成绩就是满分），使用Qt来进行上下位机的开发。当然实现的功能很简单，控制LED灯的明灭，输入数字显示在数码管上，控制继电器和蜂鸣器以及定时器。<br></p>\n<h1><a href=\"#功能介绍\" name=\"功能介绍\"></a>功能介绍</h1>\n<p>首先是界面截图 </p>\n<p><img src=\"http://images.bianxiaofeng.com/d41cd950f17ad2a1d9e90686d70bd915.png\" style=\"\"><img src=\"http://images.bianxiaofeng.com/ca5e64499f38d37d3ff7a273f4c0dc4f.png\" style=\"\"></p><p><img src=\"http://images.bianxiaofeng.com/2a5a549ee8b2cc352076af2cbabb6250.png\" style=\"\"><img src=\"http://images.bianxiaofeng.com/bcd58503e4a2de5218fb777beecb5955.png\" style=\"\"></p><p><img src=\"http://images.bianxiaofeng.com/e933fc3b154ec202c1b705879660e552.png\" style=\"\"><br></p>\n<h1><a href=\"#实现原理\" name=\"实现原理\"></a>实现原理</h1>\n<p>其实实现的原理很简单，Qt已经是封装好了串口通信的 QSerialPort类，我们只需要设置好串口通信的相关属性（波特率、数据位、奇偶校验位等等），然后调用 QSerialPort的write方法发送命令到下位机就行。当然了，还需要相应的编写下位机的代码。 </p>\n<pre><code>void MainWindow::on_openButton_clicked()\n{\n    if(ui-&gt;openButton-&gt;text()==tr(\"打开串口\"))\n    {\n        serial = new QSerialPort;\n        //设置串口名\n        serial-&gt;setPortName(ui-&gt;PortBox-&gt;currentText());\n        //打开串口\n        serial-&gt;open(QIODevice::ReadWrite);\n        //设置波特率\n        serial-&gt;setBaudRate(ui-&gt;BaudBox-&gt;currentText().toInt());\n        //设置数据位数\n        switch(ui-&gt;BitNumBox-&gt;currentIndex())\n        {\n         case 8: serial-&gt;setDataBits(QSerialPort::Data8); break;\n        default: break;\n        }\n        //设置奇偶校验\n        switch(ui-&gt;ParityBox-&gt;currentIndex())\n        {\n        case 0: serial-&gt;setParity(QSerialPort::NoParity); break;\n        default: break;\n        }\n        //设置停止位\n        {\n        default: break;\n        }\n        //设置流控制\n        serial-&gt;setFlowControl(QSerialPort::NoFlowControl);\n\n        //关闭设置菜单使能\n        ui-&gt;PortBox-&gt;setEnabled(false);\n        ui-&gt;BaudBox-&gt;setEnabled(false);\n        ui-&gt;BitNumBox-&gt;setEnabled(false);\n        ui-&gt;ParityBox-&gt;setEnabled(false);\n        ui-&gt;openButton-&gt;setText(tr(\"关闭串口\"));\n\n        //连接信号槽\n        QObject::connect(serial, &amp;QSerialPort::readyRead, this, &amp;MainWindow::Read_Data);\n    }\n    else\n    {\n        //关闭串口\n        serial-&gt;clear();\n        serial-&gt;close();\n        serial-&gt;deleteLater();\n\n        //恢复设置使能\n        ui-&gt;PortBox-&gt;setEnabled(true);\n        ui-&gt;BaudBox-&gt;setEnabled(true);\n        ui-&gt;BitNumBox-&gt;setEnabled(true);\n        ui-&gt;ParityBox-&gt;setEnabled(true);\n        ui-&gt;openButton-&gt;setText(tr(\"打开串口\"));\n    }\n}\n\n</code></pre>\n<p>相关代码上传至百度云：<br>链接：<a href=\"https://pan.baidu.com/s/1fCpx_fFD9qsZVWKf89QkXg\" target=\"_blank\">https://pan.baidu.com/s/1fCpx_fFD9qsZVWKf89QkXg</a> 密码：0oqe</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:35:27');
INSERT INTO `bg_blog` VALUES (18, 49, 'JavaEE之Session理解', '在互联网生活中，通常大家在使用浏览器的时候会接触到session。由于HTTP的无状态性，也就是说，当打开浏览器输入http://www.bianxiaofeng.com 网址，然后该请求会被服务器处理后，返回所请求的网页的内容，至此，整个Request/Response过程已经完全结束了。当你接下', '1', 0, '0', 202, 'http://images.bianxiaofeng.com/64b56e20e7edd8d9e8bc38ba896e9b64.png', '2', '<p><br></p>\n<h1><a href=\"#session应用场景\" name=\"session应用场景\"></a>Session应用场景</h1>\n<blockquote>\n  <p>在互联网生活中，通常大家在使用浏览器的时候会接触到session。由于HTTP的无状态性，也就是说，当打开浏览器输入http://www.bianxiaofeng.com 网址，然后该请求会被服务器处理后，返回所请求的网页的内容，至此，整个Request/Response过程已经完全结束了。当你接下来访问网站的时候，网站服务器端是不认识你的。这就是无状态性。为了解决这个问题（比如在某个需要输入密码的网页登录，不能说每一次打开该网站的新的网页就要输入一次密码。对吧？）。此时session的作用就体现出来了。简单的说。就是让服务器知道你就是你。<br></p>\n  <h1><a href=\"#面对无状态性的解决方案\" name=\"面对无状态性的解决方案\"></a>面对无状态性的解决方案</h1>\n</blockquote>\n<p>Java Servlet 通过引入session机制来跟踪客户端的状态。当用户访问网站的时候，网站会分配给该客户端一个sessionID用于标识该客户端，至此，在接下来的一段时间内，用户可以请求不同的服务器资源。当网页被关闭的时候，服务器会释放掉这个ID。比如在线购物的过程，浏览物品，到添加购物车到付款完成关闭页面这整个过程就是一个session。</p>\n<h1><a href=\"#session的使用\" name=\"session的使用\"></a>Session的使用</h1>\n<p>session的使用方式很多，常见的方式是使用jsp和servlet。 </p>\n<p>jsp的9大内置对象中就有session，所以在jsp页面可以直接使用。在servlet中，需要构建出session实例，然后才能使用。构建方式有两种：</p>\n<pre><code>        HttpSession session=request.getSession();\n        HttpSession session=request.getSession(Boolean b);\n        //参数为true：若会话存在就返回该对话，如果不存在就创建一个对话；\n        //参数为false：若会话存在就返回该对话，如果不存在就返回null\n</code></pre>\n<p><strong>常用方法</strong> </p>\n<pre><code>        session.isNew();//返回值为Boolean，判断是不是新创建的session\n        session.setAttribute(String s,Object o);//在session范围内保存对象\n        session.getAttribute(String s);//获取在session范围内保存的对象，一般涉及到cast强转\n        session.removeAttribute(String s);//去除session范围内的键为s的对象\n        session.getId();//返回sessionID，返回值为String\n        session.invalidate();//使session立即失效，包括保存在session范围内的对象\n</code></pre>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>Session将信息保存在服务器端，而cookie保存在客户端，session比cookie安全，但是session更加占用资源。如果客户端禁用了cookie，那么服务器端的session也无法使用。这种问题的解决方案是重写url。</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:34:24');
INSERT INTO `bg_blog` VALUES (19, 49, 'JavaEE Async 异步支持', 'Async技术是Servlet3.0 之后添加的，用于处理异步请求。在此之前，大多为同步请求，客户端向服务器提交请求，假设请求很耗时，那么按照之前同步的处理办法，servlet在接收到这个请求之后，会调用去处理这个耗时操作，如果这个耗时操作长时间没有返回，那么就造成了服务器的阻塞，服务器资源得不到有效利用，这样的结果显然对于服务器的高并发是非常不利的。服务器可以异步执行，在等待长时间的过程完成期间，控制容器执行其他任务，当耗时操作完成返回后，再调用资源处理这个返回请求。', '1', 0, '0', 212, 'http://images.bianxiaofeng.com/64b56e20e7edd8d9e8bc38ba896e9b64.png', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<blockquote>\n  <p>Async技术是Servlet3.0 之后添加的，用于处理异步请求。在此之前，大多为同步请求，客户端向服务器提交请求，假设请求很耗时，那么按照之前同步的处理办法，servlet在接收到这个请求之后，会调用去处理这个耗时操作，如果这个耗时操作长时间没有返回，那么就造成了服务器的阻塞，服务器资源得不到有效利用，这样的结果显然对于服务器的高并发是非常不利的。<br> 服务器可以异步执行，在等待长时间的过程完成期间，控制容器执行其他任务，当耗时操作完成返回后，再调用资源处理这个返回请求。<br></p>\n  <h1><a href=\"#使用async的步骤\" name=\"使用async的步骤\"></a>使用Async的步骤</h1>\n</blockquote>\n<h2><a href=\"#启用async\" name=\"启用async\"></a>启用async</h2>\n<p>异步行为需要在Servlet中显式启用 ，其方法有两种： </p>\n<ul>\n  <li>添加@WebServlet的**asyncSupported**属性实现</li>\n</ul>\n<pre><code>@WebServlet(urlPatterns = \"/async\", asyncSupported = true)\n</code></pre>\n<ul>\n  <li>在**web.xml**文件中实现</li>\n</ul>\n<pre><code>    &lt;servlet&gt;\n        &lt;servlet-name&gt;AsyncServlet&lt;/servlet-name&gt;\n        &lt;servlet-class&gt;com.dimple.servlet.AsyncServlet&lt;/servlet-class&gt;\n        &lt;async-supported&gt;true&lt;/async-supported&gt; &lt;!--设置启用Async--&gt;\n    &lt;/servlet&gt;\n</code></pre>\n<h2><a href=\"#在servlet中开启async\" name=\"在servlet中开启async\"></a>在Servlet中开启async</h2>\n<pre><code>@WebServlet(name = \"AsyncServlet\", urlPatterns = \"/async\",asyncSupported = true)\npublic class AsyncServlet extends HttpServlet {\n    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {\n        doGet(request, response);\n    }\n\n    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {\n        PrintWriter out = response.getWriter();\n        //输出Servlet开始的时候的系统时间\n        out.println(\"Servlet is starting：\"+new Date());\n        //创建AsyncContext，开始异步调用\n        AsyncContext asyncContext=request.startAsync();\n        //设置超时时长,单位为毫秒\n        asyncContext.setTimeout(60*1000);\n        //启动异步调用的线程\n        asyncContext.start(new MyTask(asyncContext));\n        //输出Servlet结束的时间\n        out.println(\"Servlet is ending ：\"+new Date());\n    }\n}\n</code></pre>\n<p>MyTask内容：</p>\n<pre><code>public class MyTask implements Runnable {\n    AsyncContext context;\n\n    public MyTask(AsyncContext context) {\n        this.context = context;\n    }\n\n    /**\n     * 此处单开一个线程进行耗时操作，为了模拟耗时操作，这里先让线程Sleep5秒。\n     */\n    @Override\n    public void run() {\n        try {\n            Thread.sleep(5*1000);\n            context.getResponse().getWriter().print(\"async is ending : \"+new Date());\n        } catch (InterruptedException | IOException e) {\n            e.printStackTrace();\n        }\n    }\n}\n\n</code></pre>\n<p><strong>执行结果如下：</strong></p>\n<p><img src=\"https://img-blog.csdn.net/20180326183601303?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMyNDU0NTM3/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70\" alt=\"这里写图片描述\"> </p>\n<p>注意：这是采用IDEA开发的，可能采用Eclipse的小伙伴的开发的和我这边的url不一样。 </p>\n<h1><a href=\"#asynclistener-异步监听器\" name=\"asynclistener-异步监听器\"></a>AsyncListener 异步监听器</h1>\n<p>为了更加清晰的看到异步操作的各种细节，可以借助异步监听器实现。<br>异步监听器需要实现AsyncListener接口，该接口需要实现如下方法： </p>\n<pre><code>            @Override\n            public void onComplete(AsyncEvent asyncEvent) throws IOException {\n                //当异步调用完成后被调用\n            }\n\n            @Override\n            public void onTimeout(AsyncEvent asyncEvent) throws IOException {\n                //超时被调用\n            }\n\n            @Override\n            public void onError(AsyncEvent asyncEvent) throws IOException {\n                //出现错误的时候被调用\n            }\n\n            @Override\n            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {\n                //启动Async的时候被调用\n            }\n</code></pre>\n<p>添加监听器的方法： </p>\n<pre><code>asyncContext.addListener(new MyAsyncListener);\n</code></pre>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>使用Servlet3.0的Async异步支持，步骤总结如下： </p>\n<ul>\n  <li>首先先声明异步支持（web.xml或者注解@webServlet）</li>\n  <li>在相应的Servlet中获取AsyncContext实例。一般采用<code>request.startAsync();</code>该方法发挥一个AsyncContext对象。</li>\n  <li>设置超时<code>context.setTimeout();</code></li>\n  <li>启动线程<code>context.start(Runable runable);</code></li>\n  <li>在相应的实现Runable接口的方法里进行耗时操作。</li>\n</ul>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:34:13');
INSERT INTO `bg_blog` VALUES (20, 49, 'JavaWeb获取表单数据的三种方式（属性封装，表达式封装，模型驱动封装）', '在JavaWeb中，常常会遇到用户注册、提交表单数据等等，这个时候使用Struts2框架怎么获取页面的数据呢？传统的有通过域对象的方法来挨个使用getParameter方法来获取表单数据再进行操作（比如封装到一个JavaBean等等），本文主要使用Struts2框架来获取表单数据。', '1', 0, '0', 73, 'http://images.bianxiaofeng.com/3b5d357dd6f37f8b1d7de410c022224a.jpg', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>在JavaWeb中，常常会遇到用户注册、提交表单数据等等，这个时候使用Struts2框架怎么获取页面的数据呢？传统的有通过域对象的方法来挨个使用getParameter方法来获取表单数据再进行操作（比如封装到一个JavaBean等等），本文主要使用Struts2框架来获取表单数据。</p>\n<p>在首先会通过最传统的方法通过Servlet来获取表单数据，接着会介绍三种获取表单数据的方式，最后会对这几种方式来进行比较。<br> <br>本文各类环境如下： </p>\n<p>Struts2版本：struts-2.5.16-all<br>IDE：Intellij IDEA 2018.1 </p>\n<p>此外关于添加Struts2 jar包不再叙述。</p>\n<h1><a href=\"#servlet域对象获取表单数据\" name=\"servlet域对象获取表单数据\"></a>Servlet域对象获取表单数据</h1>\n<p>此处使用的是最原始的方式获取表单数据，主要是操作request域来获取数据的。</p>\n<h2><a href=\"#方法步骤\" name=\"方法步骤\"></a>方法步骤</h2>\n<ul>\n  <li>编写一个JavaBean（User），属性值为username、password。</li>\n  <li>新建一个JSP页面。</li>\n  <li>在action中通过ServletActionContext来获取request对象，通过request的getParameter方法来获取数据。</li>\n  <li>将属性值封装到JavaBean中。</li>\n</ul>\n<h2><a href=\"#具体实现\" name=\"具体实现\"></a>具体实现</h2>\n<p>1、编写JavaBean User<br>新建一个包：com.dimple.entity,然后新建一个Class，名为User。 </p>\n<pre><code>public class User {\n    private String username;\n    private String password;\n    /**\n    * 省略部分get和set方法。\n    */\n}\n\n</code></pre>\n<p>2、新建一个JSP页面，名为login<br>导入标签库：</p>\n<pre><code>&lt;%@ taglib prefix=\"s\" uri=\"/struts-tags\" %&gt;\n</code></pre>\n<p>新建一个form表单，body内容如下： </p>\n<pre><code>&lt;body&gt;\n&lt;s:form label=\"登陆\" action=\"login\"&gt;\n    &lt;tr&gt;\n        &lt;td&gt;\n            账号：\n        &lt;/td&gt;\n        &lt;td&gt;\n            &lt;input type=\"text\" name=\"username\"/&gt;\n        &lt;/td&gt;\n    &lt;/tr&gt;\n    &lt;tr&gt;\n        &lt;td&gt;\n            密码：\n        &lt;/td&gt;\n        &lt;td&gt;\n            &lt;input type=\"text\" name=\"password\"/&gt;\n        &lt;/td&gt;\n    &lt;/tr&gt;\n    &lt;tr&gt;\n        &lt;td colspan=\"2\"&gt;\n            &lt;input type=\"submit\" value=\"登陆\"/&gt;\n        &lt;/td&gt;\n    &lt;/tr&gt;\n&lt;/s:form&gt;\n&lt;/body&gt;\n&lt;/html&gt;\n</code></pre>\n<p>3、新建一个包名为：com.dimple.actin，新建一个LoginAction类。</p>\n<pre><code>public class LoginAction extends ActionSupport {\n\n    @Override\n    public String execute() throws Exception {\n        //获取Request对象\n        HttpServletRequest request = ServletActionContext.getRequest();\n        //获取表单属性\n        String password = request.getParameter(\"password\");\n        String username = request.getParameter(\"username\");\n        //将表单数据封装到JavaBean中\n        User user = new User();\n        user.setPassword(password);\n        user.setUsername(username);\n        //输出获取到的内容\n        System.out.println(user.toString());\n        return NONE;\n    }\n}\n</code></pre>\n<p>4、配置struts.xml </p>\n<pre><code>&lt;struts&gt;\n    &lt;package name=\"login\" extends=\"struts-default\" namespace=\"/\"&gt;\n        &lt;action name=\"login\" class=\"com.dimple.action.LoginAction\"&gt;\n            &lt;!--因为设置的返回值为none，所以不需要配置result标签--&gt;\n        &lt;/action&gt;\n    &lt;/package&gt;\n&lt;/struts&gt;\n</code></pre>\n<p>PS:别忘了还有web.xml的filter标签哦。 </p>\n<p>结果如下：<br>输入账号密码后：</p>\n<p><img src=\"http://images.bianxiaofeng.com/bfaa24a877f7f1b9a38aaf6f44c33214.png\" style=\"\"><br></p><p><br></p>\n<p>output页面显示： </p>\n<p><img src=\"http://images.bianxiaofeng.com/90c384a1ea4d514243ed00d4531bdfc3.png\" style=\"\"><br></p>\n<h1><a href=\"#属性封装\" name=\"属性封装\"></a>属性封装</h1>\n<p>属性封装是一种比原始方式好一点的一种做法，但是在实际工作中的使用和原始方式一样，用的不是特别多。是一种直接将表单属性封装到action属性的一种方法。 </p>\n<h2><a href=\"#实现步骤\" name=\"实现步骤\"></a>实现步骤</h2>\n<ul>\n  <li>在action类中定义属性变量（注意：必须和jsp页面的属性值保持一致）</li>\n  <li>生成get和set方法</li>\n</ul>\n<h2><a href=\"#具体实现\" name=\"具体实现\"></a>具体实现</h2>\n<p>PS:直接在上一个示例上修改。 </p>\n<p>修改loginAction代码如下： </p>\n<pre><code>public class LoginAction extends ActionSupport {\n    //定义变量\n    private String username;\n    private String password;\n    //生成对应的get和set方法\n/**\n* 省略get和set方法\n*/\n    @Override\n    public String execute() throws Exception {\n        //将变量值封装到对象中\n        User user=new User();\n        user.setUsername(getUsername());\n        user.setPassword(getPassword());\n        System.out.println(user.toString());\n        return NONE;\n    }\n}\n\n</code></pre>\n<p>结果如下： </p>\n<p><img src=\"http://images.bianxiaofeng.com/5a89da91016ba365cd57488b4812156e.png\" style=\"\"><br></p>\n<p><img src=\"http://images.bianxiaofeng.com/af4a9739b92b6ad71d8a3a4c7c25d53d.png\" style=\"\"><br></p>\n<h2><a href=\"#框架实现原理分析\" name=\"框架实现原理分析\"></a>框架实现原理分析</h2>\n<p>只能是最简单的白话文的分析：<br>在action类中通过request域对象来获取变量名称和值，然后与action类中的成员变量名称进行比对，如果属性名一样，那么就调用set方法将值写入。 </p>\n<h1><a href=\"#模型驱动封装\" name=\"模型驱动封装\"></a>模型驱动封装</h1>\n<p>模型驱动封装是要实现Model Driven接口。 </p>\n<h2><a href=\"#实现步骤\" name=\"实现步骤\"></a>实现步骤</h2>\n<ul>\n  <li>让action类继承Model Driven接口</li>\n  <li>实现接口中的方法getModel();</li>\n  <li>在action中创建JavaBean类对象</li>\n</ul>\n<h2><a href=\"#具体实现\" name=\"具体实现\"></a>具体实现</h2>\n<p>action中代码如下： </p>\n<pre><code>public class LoginAction extends ActionSupport implements ModelDriven&lt;User&gt; {\n    //创建实体类对象\n    User user=new User();\n\n    @Override\n    public String execute() throws Exception {\n        System.out.println(user.toString());\n        return NONE;\n    }\n    //实现接口中的方法，返回user\n    @Override\n    public User getModel() {\n        return user;\n    }\n}\n</code></pre>\n<h2>实现截图</h2><p><img src=\"http://images.bianxiaofeng.com/00b2bef85bb96a7c9fbe5c550c8702a8.png\" style=\"\"><br></p>\n<p><img src=\"http://images.bianxiaofeng.com/0c0a416473445210c329e389b3fc5edc.png\" style=\"\"><br></p>\n<h1><a href=\"#表达式封装\" name=\"表达式封装\"></a>表达式封装</h1>\n<p>表达式封装是用的比较多的，具体的原因后面的比较会说到。 </p>\n<h2><a href=\"#实现步骤\" name=\"实现步骤\"></a>实现步骤</h2>\n<ul>\n  <li>在action类中声明JavaBean【注意只是声明，没有实现】</li>\n  <li>生成实体类的get和set方法</li>\n  <li>在JSP页面的form表单中使用表达式形式</li>\n</ul>\n<h2><a href=\"#具体实现\" name=\"具体实现\"></a>具体实现</h2>\n<p>action类代码如下： </p>\n<pre><code>public class LoginAction extends ActionSupport  {\n    //只是声明并不实现\n    User user;\n\n    public User getUser() {\n        return user;\n    }\n\n    public void setUser(User user) {\n        this.user = user;\n    }\n\n    @Override\n    public String execute() throws Exception {\n        System.out.println(user.toString());\n        return NONE;\n    }\n\n}\n</code></pre>\n<p>Jsp页面中的body部分(注意和前面的进行比较)： </p>\n<pre><code>&lt;s:form label=\"登陆\" action=\"login\"&gt;\n    &lt;tr&gt;\n        &lt;td&gt;\n            账号：\n        &lt;/td&gt;\n        &lt;td&gt;\n            &lt;input type=\"text\" name=\"user.username\"/&gt;\n        &lt;/td&gt;\n    &lt;/tr&gt;\n    &lt;tr&gt;\n        &lt;td&gt;\n            密码：\n        &lt;/td&gt;\n        &lt;td&gt;\n            &lt;input type=\"text\" name=\"user.password\"/&gt;\n        &lt;/td&gt;\n    &lt;/tr&gt;\n    &lt;tr&gt;\n        &lt;td colspan=\"2\"&gt;\n            &lt;input type=\"submit\" value=\"登陆\"/&gt;\n        &lt;/td&gt;\n    &lt;/tr&gt;\n&lt;/s:form&gt;\n&lt;/body&gt;\n</code></pre>\n<h2>实现截图</h2><p><img src=\"http://images.bianxiaofeng.com/ecf170c9acadfb88b314e6135ab94476.png\" style=\"\"><br></p>\n<p><img src=\"http://images.bianxiaofeng.com/16e1c28ee16bd693b137cdd014227d36.png\" style=\"\"><br></p>\n<h1><a href=\"#模型封装和表达式封装比较\" name=\"模型封装和表达式封装比较\"></a>模型封装和表达式封装比较</h1>\n<p>共同点：这两种方式都能够将数据直接封装到实体类中去。 </p>\n<p>不同点：<br>- 使用模型驱动封装的方式，由于在实现接口的时候，就指明了泛型为user，这样就只能够将数据封装到一个实体类中。<br>- 使用表达式封装，在JSP页面就已经设置了该数据传入的对象，所以是可以将数据封装到多个实体类中的，只不过是在action方法中再多生成几个get和set方法而已。 </p>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>获取表单数据，这样就能与用户进行数据交互。同时，表达式封装还可以封装List、Map等等。其实方法都一样，生成对应的额get和set方法，区别主要是在JSP页面中的写法，比如封装到List中，那么JSp页面可能就要这样写了</p>\n<pre><code>&lt;input type=\"text\" name=\"list[0].password\"/&gt;\n</code></pre>\n<p>同理，封装到Map呢？map是键值对的结构，那么肯定是不能按照list（类似于数组）的方式来。通过使用键来获得值：</p>\n<pre><code>&lt;input type=\"text\" name=\"map[\'key\'].password\"/&gt;\n</code></pre>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:34:04');
INSERT INTO `bg_blog` VALUES (23, 49, 'JavaEE-SSH框架整合（Spring5.04+Struts2.5.16+Hibernate5.3）', '本文主要是通过一个简单的注册登录来说明SSH框架的整合过程。在项目中，可以使用注解或者是XML的方式来配置依赖。', '1', 0, '0', 253, 'http://images.bianxiaofeng.com/64b56e20e7edd8d9e8bc38ba896e9b64.png', '2', NULL, 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:33:34');
INSERT INTO `bg_blog` VALUES (24, 48, 'Java中的内存回收与内存泄漏的防治', '对于JVM（Java虚拟机）的GC（垃圾回收机制）来说，是否回收一个对象的标准是：是否还有引用变量指向该对象。只有有引用变量指向该对象，那么JVM就不会考虑去回收它。而在学习Java的时候，一般都是会说：Java有一套完整的垃圾回收机制，程序员可以不需要考虑内存。但是在实际应用中，还是会出现“内存泄漏”的情况。', '1', 0, '0', 757, 'http://images.bianxiaofeng.com/75c0c7d78482671b30e81f3978bbb5f9', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>对于JVM（Java虚拟机）的GC（垃圾回收机制）来说，是否回收一个对象的标准是：是否还有引用变量指向该对象。只有有引用变量指向该对象，那么JVM就不会考虑去回收它。</p>\n<p>而在学习Java的时候，一般都是会说：Java有一套完整的垃圾回收机制，程序员可以不需要考虑内存。但是在实际应用中，还是会出现“内存泄漏”的情况。<br></p>\n<h1><a href=\"#对象在内存中的状态\" name=\"对象在内存中的状态\"></a>对象在内存中的状态</h1>\n<p>基本上可以将JVM中的对象引用理解为离散中学到的有向图。</p>\n<p>将对象当做有向图的**顶点**，将引用关系当做有向图的有向边，有向边总是从引用端指向被引用的变量。在JVM中，Java的各种对象都是由各个线程创建的，所以可以将Java的线程对象作为有向图的起点。</p>\n<p>如果按照上述的方式，对于某一个对象来说，始终有大于等于一条路径能够从起点指到它，那么它就不会被GC。当然，如果找不到一条路径能够指向它，那么它就可能会被回收（注意这里说的是可能，因为GC的回收机制是由一套相对复杂的算法来决定的，所有的对象并不是失去引用马上就会被回收）。</p>\n<p>那么，是不是所有的对象，只要有引用指向它，它就不会被回收呢？但是是否定的，原因请继续往下看。</p>\n<p>而一般来说，对于Java中的对象引用有4种方式：强引用、弱引用、软引用和虚引用。</p>\n<p>关于这几种引用的概念，简单的说明如如下：</p>\n<h2><a href=\"#强引用\" name=\"强引用\"></a>强引用</h2>\n<p>对于强引用来说，可能我们平时在写代码的时候，都是用的强引用，被强引用的Java对象时不会被垃圾回收机制给回收的。即使系统资源非常紧张，即使有些变量以后都不会用到，JVM也不会强制回收被强类型引用的变量，如果系统内存实在不够，程序会直接抛出OutOfMemory异常。</p>\n<p>而我们在平常的开发中，使用的最多的也是这种，比如<br><code>1Person person =new Person();</code></p>\n<h2><a href=\"#软引用\" name=\"软引用\"></a>软引用</h2>\n<p>软引用需要通过SoftReference来实现，当一个对象只具有SoftReference时，它可能会被垃圾回收机制给回收，但是对于SoftReference的对象来说，当系统资源足够时，它是不会被系统回收，程序可以使用该对象，但是当系统资源不够的时候，GC会回收它。</p>\n<p>使用的方法一般如下：</p>\n<p><code>SoftReference&lt;Person&gt;[] persons=new SoftReference[1000000]</code></p>\n<h2><a href=\"#弱引用\" name=\"弱引用\"></a>弱引用</h2>\n<p>弱引用和软引用有些相似，区别在于 弱引用的生命周期更短，弱引用需要通过WeakReference来实现，对于只有弱引用对象，当GC运行时，无论系统资源是否足够，该对象都会被回收。（这里还是需要提醒一下，GC的运行不是实时的，不是说当该对象不再被引用变量引用的时候，GC会立即运行来回收它）</p>\n<p>当然了，这样的设计是有一定的道理的，这样是为了更加好的解决系统资源。由于GC的不定时，所以可能会遇到空指针异常，所以在进行业务逻辑处理的时候，建议在开始的时候，判断下该对象是不是为空。</p>\n<h2><a href=\"#虚引用\" name=\"虚引用\"></a>虚引用</h2>\n<p>虚引用通过PhantomReference类实现，它完全类似于没有引用。虚引用主要用于跟踪对象被垃圾回收的状态，虚引用不能单独被使用，虚引用必须要和引用队列（ReferenceQueue）一起使用。</p>\n<h2><a href=\"#对象在堆中的几种状态\" name=\"对象在堆中的几种状态\"></a>对象在堆中的几种状态</h2>\n<p>一个对象在堆中运行时，根据它在有向图中的状态可以分为3种：</p>\n<h3><a href=\"#可达状态\" name=\"可达状态\"></a>可达状态</h3>\n<p>当一个对象被创建后，有一个以上的引用变量引用它，在有向图中可以从起始顶点导航到该对象，那么就处于可达状态。</p>\n<h3><a href=\"#可恢复状态\" name=\"可恢复状态\"></a>可恢复状态</h3>\n<p>如果程序中某个对象不在有任何引用变量引用它，它将先进入可恢复状态，此时从有向图的顶点不能导航到该对象，在这个状态下，系统的垃圾回收机制准备回收该对象所占用的内存，在回收该对象之前，会调用可恢复状态的对象的finalize方法进行资源清理，如果在系统调用finalize方法重新让一个以上的引用引用该对象，那么这个对象就可以变成可达状态。否则，该对象将进入到不可达状态。</p>\n<h3><a href=\"#不可达状态\" name=\"不可达状态\"></a>不可达状态</h3>\n<p>当对象的所有关联都被切断，且系统调用所有对象finalize依然没有使该对象变为可达状态，那这个对象将永久性的失去引用，当一个对象处于不可达状态时，系统才会真正的回收该对象所占用的资源。</p>\n<h1><a href=\"#java的内存泄漏\" name=\"java的内存泄漏\"></a>Java的内存泄漏</h1>\n<blockquote>\n  <p>定义：程序运行过程中会不断的分配内存空间，那些不再使用的内存空间应该立即回收它，从而保证系统再次使用这些内存，如果存在无用的内存被回收回来，那么就叫内存泄漏。</p>\n</blockquote>\n<h2><a href=\"#内存管理的技巧\" name=\"内存管理的技巧\"></a>内存管理的技巧</h2>\n<p>1、尽量使用直接量，比如String s=:“hello”;而不是String s=new String (“hello”)，这两种方法都会在再字符串缓冲池里面有缓存，区别是使用new的方式底层会创建一个char[]数组。</p>\n<p>2、使用StringBuilder和StringBuffer进行字符串连接。如果使用String对象进行字符串连接，会生成大量的临时字符串会导致性能下降。</p>\n<p>3、尽早释放无用对象的引用。</p>\n<p>4、尽量少使用静态变量，因为静态变量的生命周期和类同步，只要class没有被卸载，那么就会一直常驻内存。</p>\n<p>5、避免在经常调用的方法，循环中创建Java对象。这样会导致系统不断的为变量分配释放空间。</p>\n<p>6、缓存经常使用的对象：如果有些对象需要被经常使用，那么可以考虑将这些对象用缓冲池保存起来，典型的缓存就是数据连接池。 </p>\n<p>PS：缓存的设计本身就是一种牺牲系统空间来换取运行时间的方式。如何控制缓存容器占用的内存空间不至于太大，同时又能保存大部分需要使用到的对象，这是缓存的设计的关键。</p>\n<p>7、尽量不要使用finalize方法</p>\n<p>8、考虑使用softReference，但是要注意软引用的不确定性。</p>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>引用对象有4个级别，其由高到低一次为：强引用、软引用、弱引用和虚引用。在需要严格考虑系统资源的情况下，还是需要考虑到这个系统的消耗的，这个时候就不能一味的使用强类型引用了。</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:33:18');
INSERT INTO `bg_blog` VALUES (25, 48, 'Java异常', '异常：程序在运行的过程中，如果程序执行出错，阻止了程序的正常运行，那么就会产生异常。而在Java中有一套解决方案，这就是异常处理机制。Java中的异常机制是针对正常运行程序的一个必要补充，一般来说没有加入异常机制，程序也能正常运行，但是，由于入参、程序逻辑的严谨度，总会有期望之外的结果生成，因此加入异常机制的补充，就是为了更好的处理意料之外的结果。', '1', 0, '0', 647, 'http://images.bianxiaofeng.com/75c0c7d78482671b30e81f3978bbb5f9', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>在面试的过程中一般会问道关于Java的异常处理相关的内容，异常处理是一般容易被忽略的，但是确是很考验一个程序员功底的方面。本文会介绍关于异常，以及关于异常的面试会问到的一些问题。</p>\n<h1><a href=\"#异常的分类\" name=\"异常的分类\"></a>异常的分类</h1>\n<blockquote>\n  <p>异常：程序在运行的过程中，如果程序执行出错，阻止了程序的正常运行，那么就会产生异常。而在Java中有一套解决方案，这就是异常处理机制。Java中的异常机制是针对正常运行程序的一个必要补充，一般来说没有加入异常机制，程序也能正常运行，但是，由于入参、程序逻辑的严谨度，总会有期望之外的结果生成，因此加入异常机制的补充，就是为了更好的处理意料之外的结果。<br><br>首先说第一点：</p>\n</blockquote>\n<p><strong>所有的异常类的父类是throwable</strong>，这个出现在我的笔试题上面，是一道判断题，但是当时没有回答正确。</p><p><img src=\"http://images.bianxiaofeng.com/b2bd059993649deadffa577b09489d11.png\" style=\"\"><br></p>\n<p><img src=\"http://images.bianxiaofeng.com/968c09f90098bdc6239e5c33ce1dadfe.png\" style=\"\"><br></p>\n<p>通过以上两张图就能看到Exception和Error的直接父类是Throwable，而Throwable是实现了Serializable接口，Object的子类。</p>\n<p>以上就是它们三者的关系。</p>\n<p>首先具体说下Exception。</p>\n<h1><a href=\"#exception的分类\" name=\"exception的分类\"></a>Exception的分类</h1>\n<p>Java中的异常分为两大类：</p>\n<ul>\n  <li>Checked Exception （受检异常，也叫非运行时异常）</li>\n  <li>Unchecked Exception （也叫RuntimeException，运行时异常）</li>\n</ul>\n<p>所有的运行时异常都是直接或者间接的继承自RuntimeException类的，比如下面图中的空指针异常。</p><p><img src=\"http://images.bianxiaofeng.com/be9cdb13ac0d67414bb69ca6f4ab1e23.png\" style=\"\"><br></p>\n<p>凡是没有继承RuntimeException而是直接继承的Exception的，叫做受检异常。<br>比如IO异常。</p><p><img src=\"http://images.bianxiaofeng.com/4a3e9bf06aa4a468ccbbf1faeddaba82.png\" style=\"\"><br></p>\n<p>接下来具体的说明这些异常：</p>\n<p><img src=\"http://images.bianxiaofeng.com/175665caadc19bda8d43702d579972d9.png\" style=\"\"><br></p>\n<p>其他要说的：</p>\n<h2><a href=\"#checked-exception\" name=\"checked-exception\"></a>Checked Exception</h2>\n<p>对于Checked Exception ，Java要求程序员对这样的操作进行预处理。即用try、catch、finally或者throws，要么在方法中使用TCF三连，或者直接抛出交给他的上一级进行处理。</p>\n<p>对于这样的情况是必须要进行处理的，如果不进行处理，程序都不能被编译。</p>\n<p>比如常见的加载驱动：<br><code>Class.forName(\"xxx\")</code>就必须要进行处理，否则会抛出ClassNotFoundException受检异常，不处理是不能通过编译的。</p>\n<h2><a href=\"#unchecked-exception\" name=\"unchecked-exception\"></a>Unchecked Exception</h2>\n<p>对于Unchecked Exception来说，一般是不需要进行处理的，程序能正常的通过编译。但是为了程序的严谨性，一般还是会在可能发生异常的地方进行TCF三连处理。这类异常常见的如下：<br>* ArithmeticException 算术异常<br>* NullPointerException 空指针异常<br>* ClassCastException 类转换异常<br>* ArrayIndexOutOfBoundsException 数组索引越界异常</p>\n<p>OK，再说下异常的捕获，关于异常，**一般是先捕获小的异常（子类），再捕获大的异常（父类）**。一般是不建议直接用Exception来全给捕获了。</p>\n<p>最后加一个面试题：</p>\n<pre><code> public void testException1() {\n        try {\n            System.out.println(\"In try first\");\n            int i = 3 / 0;\n            System.out.println(\"In try\");\n            return;\n        } catch (ArithmeticException a) {\n            System.out.println(\"In catch\");\n        }finally {\n            System.out.println(\"In finally\");\n        }\n         System.out.println(\"In end\");\n    }\n    public void testException2() {\n        try {\n            int i = 3 / 0;\n            System.out.println(\"In try\");\n            return;\n        } catch (ArithmeticException a) {\n            System.out.println(\"In catch\");\n        }finally {\n            System.out.println(\"In finally\");\n            return;\n        }\n         System.out.println(\"In end\");        \n    }\n</code></pre>\n<p>关于以上的代码，可以自己打断点看一下运行过程：</p>\n<p>结论如下：</p>\n<p>1、在TCF语句中，try部分的代码如果产生了异常，会被catch到然后转入catch语句块中进行处理，最后调用finally语句块（如果有的话）进行最后的资源清理等等工作。</p>\n<p>2、但是如果在finally语句块中有return语句，那么是不会再执行下面的语句的。</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:42:47');
INSERT INTO `bg_blog` VALUES (26, 46, 'AJAX异步请求和JQuery的post,get,getJSON,ajax函数的使用', 'ajax:是一种与服务器交互的技术，在不刷新全部网页的情况下，更新某些表单项的数据。实现对部分网页的刷新。\n常用场景：百度或者谷歌的时候，输入的时候给出具体的提示', '1', 0, '0', 243, 'http://images.bianxiaofeng.com/d2dad8c62636d857e9139b426ce176b7.jpg', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<blockquote>\n  <p>ajax:是一种与服务器交互的技术，在不刷新全部网页的情况下，更新某些表单项的数据。实现对部分网页的刷新。<br>常用场景：百度或者谷歌的时候，输入的时候给出具体的提示。<br></p>\n</blockquote>\n<h1><a href=\"#关于xhr-xmlhttprequest-\" name=\"关于xhr-xmlhttprequest-\"></a>关于XHR（XMLHttpRequest）</h1>\n<p>XHR时AJAX的基础，所有的浏览器都支持XMLHTTPRequest对象，老年版本的IE5/6使用的是ActiveXObject。所以一般来说，为了兼容性，还是会做一个判断，判断用户的浏览器支不支持XHR。检测的方法如下：</p>\n<pre><code>var xhr;\nif(window.XMLHttpRequest){\n    xhr=new XMLHttpRequest();\n}else{\n    xhr=new ActiveXObject(\"Mircosoft.XMLHTTP);\n}\n</code></pre>\n<p>创建XHR：<br><code>xhr=new XMLHttpRequest</code></p>\n<p>老年IE：<br><code>xhr=new ActiveXObject(\"Microsoft.XMLHTTP\")</code></p>\n<h2>XHR请求</h2><h1><a href=\"#xhr请求\" name=\"xhr请求\"></a></h1>\n<p>如果需要将请求发送到服务器，需要使用到XMLHttpRequest对象的open()和send()方法。</p>\n<pre><code>xhr.open(method,url,async);\nxhr.send();\n</code></pre>\n<p><h2>&nbsp;open()</h2> 相当于设置参数。</p>\n<p>原型如下：<br> <code>\nopen(method,url,async);\n</code><br> * method: 请求的类型，GET和POST。<br> <em>注意：使用POST还是GET需要根据具体的情况，下面是一张比对图：</em><br><img src=\"http://images.bianxiaofeng.com/dcec1d4cc1c33f1d1ee23e171bf5a1ae.png\" style=\"\"><br></p>\n<ul>\n  <li>url：在服务器上访问的地址</li>\n  <li>async：Boolean，true（异步），false（同步，注意，如果为false，那么在加载数据的时候会直接禁止掉当前窗口，不能再做其他交互）</li>\n</ul>\n<h2><a href=\"#send-方法\" name=\"send-方法\"></a>send()方法</h2>\n<p>将请求发送到服务器。</p>\n<p>当使用的是GET方法的时候，直接使用send()。如果使用的是POST方法，send(String string)。一般string的内容为要发送的数据。</p>\n<h2><a href=\"#post和get请求服务器方式对比-\" name=\"post和get请求服务器方式对比-\"></a>POST和GET请求服务器方式对比：</h2>\n<h3><a href=\"#不带参数-\" name=\"不带参数-\"></a>不带参数：</h3>\n<p>POST： </p>\n<p>xhr.open(“POST”,“/test”,true);<br>xhr.send();</p>\n<p>GET:</p>\n<p>xhr.open(“GET’,”/test\",true);<br>xhr.send();</p>\n<p>可以看到在不带参数的时候都一样的，区别在于，使用GET可能会导致查询到缓存数据，解决的办法是添加唯一标识，比如当前的时间或者随机数等。</p>\n<h3><a href=\"#带参数\" name=\"带参数\"></a>带参数</h3>\n<p>POST:</p>\n<p>xhr.open(“POST”,“/test”,true);<br>xhr.send(“name=test&amp;age=19”);</p>\n<p>GET:</p>\n<pre><code>xhr=open(\"GET\",\"/test?name=test&amp;age=19\",true);\nxhr=send();\n</code></pre>\n<p>可以看到，这里的区别是使用GET是直接将参数添加到url中，使用POST是直接将参数添加到send()的形参中。</p>\n<h1><a href=\"#xhr响应\" name=\"xhr响应\"></a>XHR响应</h1>\n<p>使用XMLHttpRequest对象的responseText或responseXML属性。<br>* responseText：获取字符串形式的响应数据。<br>* responseXML:获取XML形式的响应数据。</p>\n<h1><a href=\"#onreadystatechange事件\" name=\"onreadystatechange事件\"></a>onreadystatechange事件</h1>\n<p>当请求被发送到服务器的时候，需要做一个基于响应的任务。<br>每当readyState改变时，就会触发onreadystatechange事件。</p>\n<p>readyState属性存有XMLHTTPRequest的状态信息。</p><p><img src=\"http://images.bianxiaofeng.com/d59d1c8759311e5c61f31828a06c1c5e.png\" style=\"\"><br></p>\n<p>readyState有五个状态（0-4）：<br>* 0：请求未初始化<br>* 1：服务器连接已建立<br>* 2：请求接收<br>* 3：请求处理<br>* 4：请求处理完成</p>\n<p>当readyState == 4的时候，表示后台已经处理完成了request，status == 200,表示返回的结果是OK的。（注：onreadystatechange事件被触发5次，对应着状态0-4）</p>\n<pre><code>xhr=function(){\n    if(xhr.readyState==4&amp;&amp;xhr.status==200){\n        /*执行操作*/\n    }\n\n}\n</code></pre>\n<h1><a href=\"#jquery使用ajax\" name=\"jquery使用ajax\"></a>Jquery使用AJAX</h1>\n<p>一般来说，JQuery中有\\$.get、\\$.post、\\$.getJSON以及最原始的ajax()函数等。</p>\n<h2><a href=\"#get-\" name=\"get-\"></a>get()</h2>\n<p>写法如下：<code>$(selector).get(url,data,success(response,status,xhr),dataType)</code></p>\n<p>等价于：</p>\n<pre><code>$.ajax({  \n  url: url,  \n  data: data,  \n  success: callback,  \n  dataType: dataType  \n}); \n</code></pre>\n<p>关于参数含义如下：</p>\n<table>\n  <thead>\n    <tr>\n      <th>参数 </th>\n      <th align=\"center\">是否必须 </th>\n      <th align=\"right\">解释</th>\n    </tr>\n  </thead>\n  <tbody>\n    <tr>\n      <td>url </td>\n      <td align=\"center\">是</td>\n      <td align=\"right\">表示请求的url</td>\n    </tr>\n    <tr>\n      <td>data </td>\n      <td align=\"center\">否 </td>\n      <td align=\"right\">表示连同请求发送到服务器的数据</td>\n    </tr>\n    <tr>\n      <td>success(response,status,xhr) </td>\n      <td align=\"center\">否 </td>\n      <td align=\"right\">表示当请求成功后运行的函数。respose表示包含来回请求的结果数据。status表示请求的状态，xhr表示XMLHttpRequest对象。</td>\n    </tr>\n    <tr>\n      <td>dataType </td>\n      <td align=\"center\">否 </td>\n      <td align=\"right\">表示预计的服务器响应的数据类型，默认JQuery会自动判断。</td>\n    </tr>\n  </tbody>\n</table>\n<h2><a href=\"#post-\" name=\"post-\"></a>post()</h2>\n<p>函数原型：<code>￥（selector）.post(url,data,success(response,status,xhr),dataType)</code></p>\n<p>等价于：</p>\n<pre><code>$.ajax({  \n  url: url,  \n  data: data,  \n  success: callback,  \n  dataType: dataType  \n}); \n</code></pre>\n<p>关于参数含义如下：</p>\n<table>\n  <thead>\n    <tr>\n      <th>参数 </th>\n      <th align=\"center\">是否必须 </th>\n      <th align=\"right\">解释</th>\n    </tr>\n  </thead>\n  <tbody>\n    <tr>\n      <td>url </td>\n      <td align=\"center\">是</td>\n      <td align=\"right\">表示请求的url</td>\n    </tr>\n    <tr>\n      <td>data </td>\n      <td align=\"center\">否 </td>\n      <td align=\"right\">表示连同请求发送到服务器的数据</td>\n    </tr>\n    <tr>\n      <td>success(response,status,xhr) </td>\n      <td align=\"center\">否 </td>\n      <td align=\"right\">表示当请求成功后运行的函数。respose表示包含来回请求的结果数据。status表示请求的状态，xhr表示XMLHttpRequest对象。</td>\n    </tr>\n    <tr>\n      <td>dataType </td>\n      <td align=\"center\">否 </td>\n      <td align=\"right\">表示预计的服务器响应的数据类型，默认JQuery会自动判断。</td>\n    </tr>\n  </tbody>\n</table>\n<h2><a href=\"#getjson-\" name=\"getjson-\"></a>getJSON()</h2>\n<p>函数原型：<code>$(selector).getJSON(url,data,success(data,status,xhr))</code><br>等价于：</p>\n<pre><code>$.ajax({  \n  url: url,  \n  data: data,  \n  success: callback,  \n  dataType: json  \n}); \n</code></pre>\n<table>\n  <thead>\n    <tr>\n      <th>参数 </th>\n      <th align=\"center\">是否必须 </th>\n      <th align=\"right\">解释</th>\n    </tr>\n  </thead>\n  <tbody>\n    <tr>\n      <td>url </td>\n      <td align=\"center\">是</td>\n      <td align=\"right\">表示请求的url</td>\n    </tr>\n    <tr>\n      <td>data </td>\n      <td align=\"center\">否 </td>\n      <td align=\"right\">表示连同请求发送到服务器的数据</td>\n    </tr>\n    <tr>\n      <td>success(response,status,xhr) </td>\n      <td align=\"center\">否 </td>\n      <td align=\"right\">表示当请求成功后运行的函数。respose表示包含来回请求的结果数据。status表示请求的状态，xhr表示XMLHttpRequest对象。</td>\n    </tr>\n  </tbody>\n</table>\n<p>函数没有type参数，返回的结果默认为json类型。</p>\n<h2><a href=\"#ajax-\" name=\"ajax-\"></a>ajax()</h2>\n<p>ajax主要是执行异步请求，是JQUery的底层AKAX封装的实现，高层封装为$.get(),$.post()等。另外ajax()方法返回一个XMLHTTPRequest对象。</p>\n<p>比如下面代码：</p>\n<pre><code>var xmlHttpRequest=$.ajax({url:\"test\",async:false})\n</code></pre>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>在进行前端代码编写的时候，如果只是更改小规模的数据的时候，采用ajax的方式能更好的方便用户体验，而使用JS的底层的代码显得相对复杂，JQuery能够帮助我们更好的进行开发。同时\\$.get()和\\$.post()方法返回的都是字符串（不设置dataType的情况）,\\$.getJSON()返回的是JSON数据。使用\\$.ajax()，返回的是一个XMLHttpRequest对象。</p>', 'DragonWen', '2019-01-30 00:00:00', NULL, '2019-02-18 00:00:00');
INSERT INTO `bg_blog` VALUES (27, 48, 'ObjectMapper类', 'ObjectMapper类是Jackson库的主要类。它提供一些功能将转换成Java对象匹配JSON结构，反之亦然。它使用JsonParser和JsonGenerator的实例实现JSON实际的读/写。', '1', 0, '0', 293, 'http://images.bianxiaofeng.com/75c0c7d78482671b30e81f3978bbb5f9', '2', '<p><span style=\"color: inherit; font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 36px;\">前言</span><br></p>\n<p>ObjectMapper类是Jackson库的主要类。它提供一些功能将转换成Java对象匹配JSON结构，反之亦然。它使用JsonParser和JsonGenerator的实例实现JSON实际的读/写。<br></p>\n<h1><a href=\"#使用\" name=\"使用\"></a>使用</h1>\n<p>使用Jackson，首先需要相关的jar包。对于使用maven的，需要添加以下依赖：</p>\n<pre><code>&lt;!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind --&gt;\n&lt;dependency&gt;\n    &lt;groupId&gt;com.fasterxml.jackson.core&lt;/groupId&gt;\n    &lt;artifactId&gt;jackson-databind&lt;/artifactId&gt;\n    &lt;version&gt;2.9.5&lt;/version&gt;\n&lt;/dependency&gt;\n\n&lt;!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core --&gt;\n&lt;dependency&gt;\n    &lt;groupId&gt;com.fasterxml.jackson.core&lt;/groupId&gt;\n    &lt;artifactId&gt;jackson-core&lt;/artifactId&gt;\n    &lt;version&gt;2.9.5&lt;/version&gt;\n&lt;/dependency&gt;\n\n&lt;!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations --&gt;\n&lt;dependency&gt;\n    &lt;groupId&gt;com.fasterxml.jackson.core&lt;/groupId&gt;\n    &lt;artifactId&gt;jackson-annotations&lt;/artifactId&gt;\n    &lt;version&gt;2.9.5&lt;/version&gt;\n&lt;/dependency&gt;\n\n\n</code></pre>\n<p>同时，也可以直接下载Jar包。</p>\n<p><a href=\"https://download.csdn.net/download/qq_32454537/10475066\">点我直达</a></p>\n<p>当然了，也可以通过maven的仓库，然后选择jar包下载。</p>\n<p><a href=\"http://mvnrepository.com/\">点我直达</a></p>\n<h1><a href=\"#实例演示\" name=\"实例演示\"></a>实例演示</h1>\n<h2><a href=\"#java对象转换为json对象\" name=\"java对象转换为json对象\"></a>Java对象转换为JSON对象</h2>\n<pre><code><br>ObjectMapper objectMapper = new ObjectMapper();  \n          \n        //序列化的时候序列对象的所有属性  \n        objectMapper.setSerializationInclusion(Include.ALWAYS);  \n          \n        //反序列化的时候如果多了其他属性,不抛出异常  \n        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  \n          \n        //如果是空对象的时候,不抛异常  \n        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);  \n          \n        //取消时间的转化格式,默认是时间戳,可以取消,同时需要设置要表现的时间格式  \n        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);  \n        objectMapper.setDateFormat(new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\"))  \n</code></pre>\n<p>Person 类：</p>\n<pre><code><br>public class Person {\n    private int id;\n    private String name;\n    private String password;\n\n    public Person() {\n        super();\n    }\n\n    public Person(int id, String name, String password) {\n        this.id = id;\n        this.name = name;\n        this.password = password;\n    }\n    /*省略get和set方法*/\n}\n</code></pre>\n<p>测试demo：</p>\n<pre><code>package com.dimple.ObjectMapperDemo;\n\nimport com.fasterxml.jackson.core.JsonProcessingException;\nimport com.fasterxml.jackson.databind.ObjectMapper;\n\npublic class ObjectMapperTest {\n\n    public static void main(String[] args) throws JsonProcessingException {\n\n        ObjectMapper objectMapper = new ObjectMapper();\n        Person person = new Person(1, \"tom\", \"123\");\n        String jsonString = objectMapper.writeValueAsString(person);\n        System.out.println(\"JsonString: \" + jsonString);\n\n    }\n\n}\n\n</code></pre>\n<p>运行截图如下：</p><p><img src=\"http://images.bianxiaofeng.com/cbdecbe49de0ba8d0e164a6a81431010.png\" style=\"\"><br></p>\n<p>可以看到，使用Jackson类就可以将Java对象转换为Json对象。</p>\n<p>PS：还需要注意，如果ObjectMapper的configure设置FAIL_ON_EMPTY_BEANS为false，那么对应的实体类的属性没有get方法也不会抛出异常，但是这个属性默认的是true，即必须要有get方法，这个需要注意。</p>\n<p>错误如图：</p>\n<blockquote>\n  <p>com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class com.dimple.ObjectMapperDemo.Person and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)</p>\n</blockquote>\n<p><img src=\"http://images.bianxiaofeng.com/5bd444e20c71347a44ba45a1fbca2bb9.png\" style=\"\"><br></p>\n<h2><a href=\"#json对象转为java对象\" name=\"json对象转为java对象\"></a>JSON对象转为Java对象</h2>\n<pre><code>public class ObjectMapperTest {\n\n    public static void main(String[] args) throws IOException {\n\n        ObjectMapper objectMapper = new ObjectMapper();\n        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);\n        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);\n        Person person = new Person(1, \"tom\", \"123\");\n        String jsonString = objectMapper.writeValueAsString(person);\n        System.out.println(\"JsonString: \" + jsonString);\n\n        Person person1 = objectMapper.readValue(jsonString, Person.class);\n        System.out.println(person1.toString());\n\n    }\n\n}\n\n</code></pre>\n<p>结果如图：</p>\n<p><img src=\"http://images.bianxiaofeng.com/5716bf2d792ce5402990feea3a407f45.png\" style=\"\"><br></p>\n<h2><a href=\"#java数组对象和json数组对象转换\" name=\"java数组对象和json数组对象转换\"></a>Java数组对象和JSON数组对象转换</h2>\n<pre><code>public class ObjectMapperTest {\n\n    public static void main(String[] args) throws IOException {\n\n        ObjectMapper objectMapper = new ObjectMapper();\n        //Java数组转换为JSON数组\n        Person person = new Person(1, \"tom\", \"123\");\n        Person person1 = new Person(2, \"jack\", \"123445\");\n        List&lt;Person&gt; personList = new ArrayList&lt;&gt;();\n        personList.add(person);\n        personList.add(person1);\n        String jsonString = objectMapper.writeValueAsString(personList);\n        System.out.println(\"JsonString List: \" + jsonString);\n        //Json数组转换为Java数组\n        //JavaType\n        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Person.class);\n        List&lt;Person&gt; list = objectMapper.readValue(jsonString,javaType);\n        //打印出list中的值\n        for (Person person2 : list) {\n            System.out.println(person2.toString());\n        }\n    }\n\n}\n</code></pre>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:43:16');
INSERT INTO `bg_blog` VALUES (28, 46, 'Jquery的attr()和prop()方法', '在jQuery中有许多的功能能够简化开发流程，jQuery是一个JavaScript的库，封装了许多方法，很多时候，你会发现，在实现某个功能的时候，会发现这个功能的实现可以使用多种方法。\n\n本文主要是介绍jQuery设置属性的两个方法：attr（attributes）和prop（properties）。', '1', 0, '0', 162, 'http://images.bianxiaofeng.com/d2dad8c62636d857e9139b426ce176b7.jpg', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>在jQuery中有许多的功能能够简化开发流程，jQuery是一个JavaScript的库，封装了许多方法，很多时候，你会发现，在实现某个功能的时候，会发现这个功能的实现可以使用多种方法。</p>\n<p>本文主要是介绍jQuery设置属性的两个方法：attr（attributes）和prop（properties）。<br></p>\n<h1><a href=\"#官方介绍\" name=\"官方介绍\"></a>官方介绍</h1>\n<p>我们知道有的浏览器在input表单项中写disabled或者checked就可以了，但是有的浏览器需要写成disabled=“disabled”或者checked=“checked”才可以，比如用attr(“checked”)获取checkbox的checked属性时选中的时候可以取到值,值为“checked”但没选中获取值就是undefined。</p>\n<p>jQuery1.6之后，使用prop来获取这些属性就能解决问题，使用统一的返回true或者false。</p>\n<p>在jQuery的3.3.1中有以下说明，截图如下：</p>\n<h2>attr</h2><p><img src=\"http://images.bianxiaofeng.com/a64989a22987e24e88339b09a9b7f011.png\" style=\"\"><br></p>\n<p><span style=\"color: inherit; font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 30px;\">prop</span><br></p>\n<p><img src=\"http://images.bianxiaofeng.com/b894162f895e8323cb220beb298c5699.png\" style=\"\"><br></p>\n<h2><a href=\"#对比\" name=\"对比\"></a>对比</h2>\n<p>对于以上，官方文档上说到：</p>\n<p>对于prop：</p>\n<blockquote>\n  <p>获取在匹配的元素集中的第一个元素的属性值。<br>随着一些内置属性的DOM元素或window对象，如果试图将删除该属性，浏览器可能会产生错误。jQuery第一次分配undefined值的属性，而忽略了浏览器生成的任何错误</p>\n</blockquote>\n<p>对于attr：</p>\n<blockquote>\n  <p>设置或返回被选元素的属性值。</p>\n</blockquote>\n<h2><a href=\"#代码对比\" name=\"代码对比\"></a>代码对比</h2>\n<pre><code>&lt;html&gt;\n&lt;head&gt;\n    &lt;meta charset=\"utf-8\"&gt;\n    &lt;title&gt;嘿咻&lt;/title&gt;\n    &lt;meta charset=\"utf-8\"&gt;\n    &lt;%--此处的库需要换成你自己的或者是cdn--%&gt;\n    &lt;script src=\"jquery/jquery-3.3.1.js\"&gt;&lt;/script&gt;\n&lt;/head&gt;\n&lt;body&gt;\n\nc1:&lt;input id=\"c1\" name=\"checkbox\" type=\"checkbox\" checked=\"checked\" /&gt;&lt;/br&gt;\nc2:&lt;input id=\"c2\" name=\"checkbox\" type=\"checkbox\" checked=true/&gt;&lt;/br&gt;\nc3:&lt;input id=\"c3\" name=\"checkbox\" type=\"checkbox\" checked=\"\"/&gt;&lt;/br&gt;\nc4:&lt;input id=\"c4\" name=\"checkbox\" type=\"checkbox\" checked/&gt;&lt;/br&gt;\nc5:&lt;input id=\"c5\" name=\"checkbox\" type=\"checkbox\" /&gt;&lt;/br&gt;\nc6:&lt;input id=\"c6\" name=\"checkbox\" type=\"checkbox\" checked=false/&gt;&lt;/br&gt;\n\n\n&lt;script&gt;\n    var a1=$(\"#c1\").attr(\"checked\");\n    var a2=$(\"#c2\").attr(\"checked\");\n    var a3=$(\"#c3\").attr(\"checked\");\n    var a4=$(\"#c4\").attr(\"checked\");\n    var a5=$(\"#c5\").attr(\"checked\");\n    var a6=$(\"#c6\").attr(\"checked\");\n\n    var p1=$(\"#c1\").prop(\"checked\");\n    var p2=$(\"#c2\").prop(\"checked\");\n    var p3=$(\"#c3\").prop(\"checked\");\n    var p4=$(\"#c4\").prop(\"checked\");\n    var p5=$(\"#c5\").prop(\"checked\");\n    var p6=$(\"#c6\").prop(\"checked\");\n\n    console.log(\"a1:\"+a1);\n    console.log(\"a2:\"+a2);\n    console.log(\"a3:\"+a3);\n    console.log(\"a4:\"+a4);\n    console.log(\"a5:\"+a5);\n    console.log(\"a6:\"+a6);\n\n    console.log(\"p1:\"+p1);\n    console.log(\"p2:\"+p2);\n    console.log(\"p3:\"+p3);\n    console.log(\"p4:\"+p4);\n    console.log(\"p5:\"+p5);\n    console.log(\"p6:\"+p6);\n&lt;/script&gt;\n&lt;/body&gt;\n&lt;/html&gt;\n</code></pre>\n<p>结果如下：</p><p><img src=\"http://images.bianxiaofeng.com/08e5ab4745b801db46abad2659f76519.png\" style=\"\"><br></p>\n<p>可以看到使用attr去获取标签的固有属性的时候，返回的是undefined。而prop返回的是true或者false。</p>\n<p>那么什么时候使用atrr什么时候使用prop呢：</p>\n<p>总结如下：</p><p><br><b>添加属性名称就能够生效的时候使用prop，比如checked和selected</b></p>\n<ul>\n  <li>\n  <p><b>具有true和false两个返回值的属性使用prop方法</b></p></li>\n  <li>\n  <p><b>对于HTML元素本身就带有的固有属性，在处理时，使用prop方法</b></p></li>\n  <li>\n  <p><b>对于HTML元素我们自己自定义的DOM属性，在处理时，使用attr方法</b></p></li>\n</ul>', 'DragonWen', '2019-01-30 00:00:00', NULL, '2019-02-18 00:00:00');
INSERT INTO `bg_blog` VALUES (29, 49, '关于REST风格的编程', '表现层状态转换（REST，英文：Representational State Transfer）是Roy Thomas Fielding博士于2000年在他的博士论文 中提出来的一种万维网软件架构风格，目的是便于不同软件/程序在网络（例如互联网）中互相传递信息。', '1', 0, '0', 475, 'http://images.bianxiaofeng.com/d9ef8c602b4aa98833b448c5db86d883.jpg', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<blockquote>\n  <p>表现层状态转换（REST，英文：Representational State Transfer）是Roy Thomas Fielding博士于2000年在他的博士论文 中提出来的一种万维网软件架构风格，目的是便于不同软件/程序在网络（例如互联网）中互相传递信息。</p>\n</blockquote>\n<p>REST本身不是架构，只是一种架构风格，理解它的时候要参考这个架构风格出现的环境所施加的约束条件。<br>REST的目的是“建立十年内不会过时的软件系统架构“，所以它具备三个特点：<br>1. 状态无关 —— 确保系统的横向拓展能力<br>2. 超文本驱动，Fielding的原话是”hypertext-driven\" —— 确保系统的演化能力<br>3. 对 resource 相关的模型建立统一的原语，例如：uri、http的method定义等 —— 确保系统能够接纳多样而又标准的客户端。<br><br>这样对URL进行了限制，用于定义资源。简单来说就是定义了**如何设计系统来对外提供服务**。使用HTTP+JSON就可以搞定一切。</p>\n<h1><a href=\"#rest详解\" name=\"rest详解\"></a>REST详解</h1>\n<p>REST究竟是什么？因为REST的内涵非常丰富，所以很难用一两句话解释清楚这个问题。</p>\n<p>首先，REST是Web自身的架构风格。REST也是Web之所以取得成功的技术架构方面因素的总结。REST是世界上最成功的分布式应用架构风格（成功案例：Web，还不够吗？）。它是为 运行在互联网环境 的 分布式 超媒体系统量身定制的。互联网环境与企业内网环境有非常大的差别，最主要的差别是两个方面：</p>\n<p>可伸缩性需求无法控制：并发访问量可能会暴涨，也可能会暴跌。</p>\n<p>安全性需求无法控制：无法控制客户端发来的请求的格式，很可能会是恶意的请求。</p>\n<p>而所谓的“超媒体系统”，即，使用了超文本的系统。可以把“超媒体”理解为超文本+媒体内容。</p>\n<p>REST是HTTP/1.1协议等Web规范的设计指导原则，HTTP/1.1协议正是为实现REST风格的架构而设计的。新的Web规范，其设计必须符合REST的要求，否则整个Web的体系架构会因为引入严重矛盾而崩溃。这句话不是危言耸听，做个类比，假如苏州市政府同意在市区著名园林的附近大型土木，建造大量具有后现代风格的摩天大楼，那么不久之后世界闻名的苏州园林美景将不复存在。</p>\n<p>上述这些关于“REST是什么”的描述，可以总结为一句话：REST是所有Web应用都应该遵守的架构设计指导原则。当然，REST并不是法律，违反了REST的指导原则，仍然能够实现应用的功能。但是违反了REST的指导原则，会付出很多代价，特别是对于大流量的网站而言。</p>\n<h1><a href=\"#springmvc的rest风格请求\" name=\"springmvc的rest风格请求\"></a>SpringMVC的REST风格请求</h1>\n<p>在HTTP协议里面，有以下几个表示操作方式的动词：<br>GET、POST、PUT、DELETE，分别对应着查询、增加、修改、删除操作。</p>\n<p>在SpringMVC中可以使用rest风格占位符的方式，使用注解@PAthVariable实现将URL中的数据复制到Java的具体变量上。</p>\n<p>比如以下：</p>\n<table>\n  <thead>\n    <tr>\n      <th>路径 </th>\n      <th align=\"center\">HTTP方式 </th>\n      <th align=\"right\">解释</th>\n    </tr>\n  </thead>\n  <tbody>\n    <tr>\n      <td><a href=\"http://localhost:8080/stu/1\">http://localhost:8080/stu/1</a> </td>\n      <td align=\"center\">GET</td>\n      <td align=\"right\">获取id为1的数据（这里假设要取的是学生数据）</td>\n    </tr>\n    <tr>\n      <td><a href=\"http://localhost:8080/stu\">http://localhost:8080/stu</a> </td>\n      <td align=\"center\">GET </td>\n      <td align=\"right\">获取所有的学生数据</td>\n    </tr>\n    <tr>\n      <td><a href=\"http://localhost:8080/stu/1\">http://localhost:8080/stu/1</a> </td>\n      <td align=\"center\">DELETE </td>\n      <td align=\"right\">删除id为1的学生的数据信息</td>\n    </tr>\n    <tr>\n      <td><a href=\"http://localhost:8080/stu/1\">http://localhost:8080/stu/1</a> </td>\n      <td align=\"center\">PUT </td>\n      <td align=\"right\">修改id为1的学生的数据信息</td>\n    </tr>\n    <tr>\n      <td><a href=\"http://localhost:8080/stu\">http://localhost:8080/stu</a> </td>\n      <td align=\"center\">POST </td>\n      <td align=\"right\">新增一条学生数据</td>\n    </tr>\n  </tbody>\n</table>\n<p>对于以上的URL可以采用以下controller处理：</p>\n<h2><a href=\"#get\" name=\"get\"></a>GET</h2>\n<p>对应URL：http://localhost:8080/stu 获取所有的学生的数据</p>\n<pre><code>@responseBody//表示返回的JSON数据\n@RequestMapping(value=\"/stu\",method=RequestMethod.GET)\npublic Msg toAddPage(){//这里的Msg是自己封装的utils，封装了返回给client端的数据\n    //获取到service端处理的数据\n    return Msg.success().add(\"students\",studentService.getStudents());\n}\n</code></pre>\n<p>对应URL：http://localhost:8080/stu/1 获取学生id为1的学生数据</p>\n<h2><a href=\"#post\" name=\"post\"></a>POST</h2>\n<p>对应URL：http://localhost:8080/stu 新增一条数据</p>\n<p>所有的数据都在formData中（可以F12查看网络请求）,使用SpringMVC自动封装</p>\n<pre><code>@responseBody//表示返回的JSON数据\n@RequestMapping(value=\"/stu\",method=RequestMethod.POST)\npublic Msg toAddPage(Student student){//这里的Msg是自己封装的utils，封装了返回给client端的数据\n    studentService.saveStudent(student);\n    return Msg.success();\n}\n</code></pre>\n<h2><a href=\"#put\" name=\"put\"></a>PUT</h2>\n<p>对应的URL：http://localhost:8080/stu/1 更新学生id为1的数据</p>\n<pre><code>@responseBody//表示返回的JSON数据\n@RequestMapping(value=\"/stu{id}\",method=RequestMethod.PUT)\npublic Msg toAddPage(Student student){//这里的Msg是自己封装的utils，封装了返回给client端的数据\n    studentService.updateStudentById(id);//此时student中是有id的，是SpringMVC封装好了的\n    return Msg.success().add(\"student\",student);\n}\n</code></pre>\n<p>使用PUT、DELETE方法的时候，还需要注意一点就是，底层的Tomcat容器是只支持POST方式的，为了方便的使用rest风格的URL,在SpringMVC中提供一个过滤器：HiddenHttpMethodFilter，配置好此过滤器就可以使用PUT这些方法了。</p>\n<h2><a href=\"#delete\" name=\"delete\"></a>DELETE</h2>\n<p>对应的URL：http://localhost:8080/stu/1 删除id为1的学生的数据</p>\n<pre><code>@responseBody//表示返回的JSON数据\n@RequestMapping(value=\"/stu{id}\",method=RequestMethod.PUT)\npublic Msg toAddPage(@pathVariable(value=\"id\"Integer id)){//这里的Msg是自己封装的utils，封装了返回给client端的数据\n    studentService.deleteStudentById(id);\n    return Msg.success();\n}\n</code></pre>', 'DragonWen', '2019-01-30 00:00:00', NULL, '2019-02-11 00:00:00');
INSERT INTO `bg_blog` VALUES (30, 49, 'SpringMVC拦截器', '拦截器是Spring MVC中强大的控件，它可以在处理器之前做一些操作，或者是在处理器完成后做一个操作，甚至是在渲染视图，也就是viewResolver之后做一些操作。我们知道，', '1', 0, '0', 284, 'http://images.bianxiaofeng.com/8acfa54bfd191dbefe29a68a725f6f38.png', '2', '<p><span style=\"color: inherit; font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 36px;\">前言</span><br></p>\n<p>拦截器是Spring MVC中强大的控件，它可以在处理器之前做一些操作，或者是在处理器完成后做一个操作，甚至是在渲染视图，也就是viewResolver之后做一些操作。我们知道，在web.xml网站描述文件中，我们会配置DispatchServlet，然后SpringMVC启动的时候就回通过@requestMapping的注解解析统一资源定位符URI和处理器handler之间的关系，在运行的时候，通过URL请求找到对应的HandlerMapping，然后构建HandlerExecuteChain对象，再交给handleradapter执行。<br></p>\n<h1><a href=\"#handlerinterceptor\" name=\"handlerinterceptor\"></a>HandlerInterceptor</h1>\n<p>一般要实现拦截器，需要实现HandlerInterceptor接口，这个接口有三个方法，如下：</p>\n<pre><code>public interface HandlerInterceptor {\n\n\n	default boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)\n			throws Exception {\n		return true;\n	}\n\n	default void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,\n			@Nullable ModelAndView modelAndView) throws Exception {\n	}\n\n\n	default void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,\n			@Nullable Exception ex) throws Exception {\n	}\n\n}\n\n\n</code></pre>\n<p>以上三个方法意义：</p>\n<p>1、preHandler():在处理器之前执行的前置方法，这样SpringMVC可以在进入到处理器之前进行一些处理，需要注意的是，这里返回的是一个Boolean，这会影响到后面的SpringMVC的执行。<br>2、postHandler():在处理器执行之后执行的后置方法，处理器handler执行完毕会调用它。<br>3、afterCompletion():无论是否产生异常，都会在渲染视图之后执行。</p><p><br></p><p><img src=\"http://images.bianxiaofeng.com/e7adf343904a81abdfc0fedc11e86ea0.png\" style=\"\"><br></p>\n<p>这里需要注意的是，当preHandler返回false后，就不会执行postHandler和afterCompletion方法。</p>\n<h2><a href=\"#拦截器实现\" name=\"拦截器实现\"></a>拦截器实现</h2>\n<p>拦截器需要实现HandlerInterceptor接口，在SpringMVC中，可以通过一个虚类拦截器来实现。</p>\n<pre><code>public class MyInterceptor extends HandlerInterceptorAdapter {\n    @Override\n    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {\n        System.out.println(\"preHandle\");\n        return true;\n    }\n\n    @Override\n    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {\n        System.out.println(\"postHandle\");\n\n    }\n\n    @Override\n    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {\n        System.out.println(\"afterCompletion\");\n\n    }\n}\n\n</code></pre>\n<p>此外，还需要在SpringMVC的配置文件中设置：</p>\n<pre><code>    &lt;mvc:interceptors&gt;\n        &lt;mvc:interceptor&gt;\n            &lt;!--配置拦截器拦截的路径--&gt;\n            &lt;mvc:mapping path=\"/*.do\"/&gt;\n            &lt;!--配置拦截器--&gt;\n            &lt;bean class=\"com.dimple.interceptor.RoleInterceptor\"/&gt;\n        &lt;/mvc:interceptor&gt;\n    &lt;/mvc:interceptors&gt;\n\n</code></pre>\n<h2><a href=\"#多个拦截器\" name=\"多个拦截器\"></a>多个拦截器</h2>\n<p>这里限于篇幅，只是随便说一下多个拦截器执行的顺序，当配置了多个拦截器后，执行的顺序和责任链的执行顺序一样。<br>按照配置文件配置：<br> 如果在配置文件中按照顺序配置拦截器1、拦截器2、拦截器3</p>\n<p>在正常情况下，Spring会从第一个拦截器进入到前置方法，这样前置方法是按照配置顺序执行的，然后再运行处理器的代码，最后再运行后置方法。**注意这里的后置方法和前置方法是逆序的，和责任链的运行顺序是一样的。**</p>\n<p>如下的结果：</p>\n<pre><code>preHandler1\npreHandler2\npreHandler3\n···\n/**控制器执行的方法*/\n···\npostHandler3\npostHandler2\npostHandler1\n···\nafterCompletion3\nafterCompletion2\nafterCompletion1\n</code></pre>\n<p>但是如果前置方法返回false，那么后面的prehandler方法也不会执行了，而控制器和所有的postHandler也不会执行。执行过preHandler方法且方法返回为true的拦截器的完成方法afterCompletion会按照配置顺序的逆序执行。</p>', 'DragonWen', '2019-01-30 00:00:00', NULL, '2019-02-18 00:00:00');
INSERT INTO `bg_blog` VALUES (31, 48, '线程相关总结', '五种状态：New 新建状态：线程被创建后就进入到了新建状态，Thread thread=new Thread();Runnable 就绪状态：线程被创建后，其他线程调用该线程的start方法来启动该线程。处于就绪状态的线程，随时可能被CPU调度。Running 运行状态：线程获取CPU执行。线程只能从就绪状态转为运行状态。Blocked 阻塞状态： 线程因为某种原因放弃CPU的使用。只有直到线程进入到就绪状态，才有机会转入运行状态。', '1', 0, '0', 299, 'http://images.bianxiaofeng.com/75c0c7d78482671b30e81f3978bbb5f9', '2', '<p><span style=\"color: inherit; font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 30px;\">1、Object类的wait()、notify()；Thread类中接口、synchronized关键字。</span><br></p>\n<p>五种状态：</p>\n<p><strong>New 新建状态</strong>：线程被创建后就进入到了新建状态，Thread thread=new Thread();</p>\n<p><strong>Runnable 就绪状态</strong>：线程被创建后，其他线程调用该线程的start方法来启动该线程。处于就绪状态的线程，随时可能被CPU调度。</p>\n<p><strong>Running 运行状态</strong>：线程获取CPU执行。线程只能从就绪状态转为运行状态。</p>\n<p><strong>Blocked 阻塞状态：</strong> 线程因为某种原因放弃CPU的使用。只有直到线程进入到就绪状态，才有机会转入运行状态。</p>\n<p><strong>等待阻塞</strong>： 调用线程的wait()方法，让线程等待某工作完成。</p>\n<p><strong>同步阻塞</strong>： 线程在获取synchronized同步锁失败（同步锁被其他线程占用），会进入到同步阻塞状态。</p>\n<p><strong>其他阻塞</strong>： 通过调用线程的sleep()或join或发出IO请求。</p>\n<p><strong>Dead 死亡状态</strong>：线程执行完毕或者因为一场退出run()方法。<br></p>\n<h2><a href=\"#2-实现多线程的两种方式\" name=\"2-实现多线程的两种方式\"></a>2、实现多线程的两种方式</h2>\n<ul>\n  <li>\n  <p>实现runnable接口</p></li>\n  <li>\n  <p>继承Thread类，该类实现了runnable接口</p></li>\n</ul>\n<p>Thread 和 Runnable 的相同点：都是“多线程的实现方式”。</p>\n<p>Thread 和 Runnable 的不同点：</p>\n<p>Thread 是类，而Runnable是接口；Thread本身是实现了Runnable接口的类。我们知道“一个类只能有一个父类，但是却能实现多个接口”，因此Runnable具有更好的扩展性。</p>\n<p>此外，Runnable还可以用于“资源的共享”。即，多个线程都是基于某一个Runnable对象建立的，它们会共享Runnable对象上的资源。</p>\n<p>通常，建议通过“Runnable”实现多线程！</p>\n<h2><a href=\"#3-start-和run-的区别\" name=\"3-start-和run-的区别\"></a>3、start()和run()的区别</h2>\n<p>start() : 它的作用是启动一个新线程，新线程会执行相应的run()方法。start()不能被重复调用。<br>run() : run()就和普通的成员方法一样，可以被重复调用。单独调用run()的话，会在当前线程中执行run()，而并不会启动新线程！</p>\n<p>target是一个runnale对象，run()就是直接调用Thread的Runnable的run()方法。</p>\n<h2><a href=\"#4-synchronized关键字\" name=\"4-synchronized关键字\"></a>4、Synchronized关键字</h2>\n<p>在java中，每一个对象有且仅有一个同步锁。这也意味着，同步锁是依赖于对象而存在。</p>\n<p>当我们调用某对象的synchronized方法时，就获取了该对象的同步锁。例如，synchronized(obj)就获取了“obj这个对象”的同步锁。</p>\n<p>不同线程对同步锁的访问是互斥的。</p>\n<p>原则</p>\n<p>第一条：当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。</p>\n<p>第二条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程仍然可以访问“该对象”的非同步代码块。</p>\n<p>第三条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞。</p>\n<p>##5、线程的等待与唤醒<br>在Object类中定义了wait()、notify()和notifyAll()等接口；</p>\n<p>wait()的作用是让当前线程进入等待状态，同时，wait()也会让当前线程释放它所持有的锁；<br>而notify()和notifyAll()的作用，则是唤醒当前对象上的等待线程；notify()是唤醒单个线程，而notifyAll()是唤醒所有的线程；</p>\n<p>Object类中关于等待/唤醒的API详细信息如下：</p>\n<p>notify() – 唤醒在此对象监视器上等待的单个线程。</p>\n<p>notifyAll() – 唤醒在此对象监视器上等待的所有线程。</p>\n<p>wait() – 让当前线程处于“等待(阻塞)状态”，“直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法”，当前线程被唤醒(进入“就绪状态”)。</p>\n<p>wait(long timeout) – 让当前线程处于“等待(阻塞)状态”，“直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者超过指定的时间量”，当前线程被唤醒(进入“就绪状态”)。</p>\n<p>wait(long timeout, int nanos) – 让当前线程处于“等待(阻塞)状态”，“直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者其他某个线程中断当前线程，或者已超过某个实际时间量”，当前线程被唤醒(进入“就绪状态”)。</p>\n<h2><a href=\"#6-线程让步\" name=\"6-线程让步\"></a>6、线程让步</h2>\n<p>方法：yieId()<br>作用：让步，让当前的线程由运行状态进入到就绪状态，从而让其他具有相同优先级的线程获得执行权。但是不能保证其他线程就一定能获得执行权，也有可能是当前线程又进入到运行状态继续运行。</p>\n<p>yieId和wait区别：</p>\n<p>(01) wait()是让线程由“运行状态”进入到“等待(阻塞)状态”，而不yield()是让线程由“运行状态”进入到“就绪状态”。</p>\n<p>(02) wait()是会线程释放它所持有对象的同步锁，而yield()方法不会释放锁。</p>\n<h2><a href=\"#7-线程休眠\" name=\"7-线程休眠\"></a>7、线程休眠</h2>\n<p>sleep在一下Thread类中，作用是让当前的线程休眠，即当前线程会从运行状态进入到阻塞状态。当时间到了的时候，会从阻塞状态变为就绪状态，等待CPU调度。</p>\n<p>sleep和wait的比较：</p>\n<p>wait的作用是让当前线程由运行状态进入到阻塞状态，同时释放掉同步锁。而sleep的作用也是让当前线程进入到阻塞状态，但是不会释放掉同步锁。</p>\n<h2><a href=\"#8-join\" name=\"8-join\"></a>8、join</h2>\n<p>join()定义在Thread类中。<br>作用为：让“主线程”等待“子线程”结束之后才运行。</p>\n<h2><a href=\"#9-interrupt-和线程终止方式\" name=\"9-interrupt-和线程终止方式\"></a>9、interrupt()和线程终止方式</h2>\n<p>interrupt()的作用是中断本线程。本线程中断自己是被允许的，其他线程调用本线程的interrupt方法的时候，会通过checkAccess()检查权限，这有可能抛出SecurityException异常。</p>\n<p>通常我们会通过中断方式终止处于“阻塞状态”的线程。</p>\n<p>当线程由于调用了sleep()、wait()、join()等方法而进入到阻塞状态；此时若调用线程的interrupt()方法将线程的中断标记设为了true，由于处于阻塞状态，中断标记会被清除，同时产生一个interruptException异常。将interruptException放在适当的位置就能终止线程；</p>\n<p>interrupt()并不会终止“运行状态”的线程，它会将线程的中断标记设为true。（通过isInterrupted()方法判断线程是不是处于中断状态）。</p>\n<p>终止线程的通用写法：</p>\n<pre><code>@Override\npublic void run() {\n    try {\n        // 1. isInterrupted()保证，只要中断标记为true就终止线程。\n        while (!isInterrupted()) {\n            // 执行任务...\n        }\n    } catch (InterruptedException ie) {  \n        // 2. InterruptedException异常保证，当InterruptedException异常产生时，线程被终止。\n    }\n}\n</code></pre>\n<p>interrupted() 和 isInterrupted()都能够用于检测对象的“中断标记”。<br>区别是，interrupted()除了返回中断标记之外，它还会清除中断标记(即将中断标记设为false)；而isInterrupted()仅仅返回中断标记。</p>\n<h2><a href=\"#10-线程优先级和守护线程\" name=\"10-线程优先级和守护线程\"></a>10、线程优先级和守护线程</h2>\n<p>Java 中的线程的优先级是1—10，默认优先级是5。</p>\n<p>Java中有两种线程，用户线程和守护线程。可以通过isDaemon()（守护线程）方法来区别。用户线程一般执行用户级线程，而守护线程也就是后台线程。</p>\n<p>PS：Java虚拟机在“用户线程”都结束后退出。</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:43:40');
INSERT INTO `bg_blog` VALUES (32, 48, 'Java创建对象的几种方式', 'Java是一门面向对象的程序设计语言，在日常开发中可能最常见的就是使用new关键字进行对象的创建了。其实创建对象的方式有很多中，在此，准备将实例化对象的方式进行总结，归纳整理。在此之前，先简单的说明一般会有以下五种方式实例化对象：①、使用new关键字；②、使用Class类的newInstance方法；③、使用Constructor类的newInstance方法；④、使用Object类的clone方法；⑤、使用反序列化的方式；', '1', 0, '1', 126, 'http://images.bianxiaofeng.com/75c0c7d78482671b30e81f3978bbb5f9', '2', '<p><span style=\"color: inherit; font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 36px;\">前言</span><br></p>\n<p>Java是一门面向对象的程序设计语言，在日常开发中可能最常见的就是使用new关键字进行对象的创建了。其实创建对象的方式有很多中，在此，准备将实例化对象的方式进行总结，归纳整理。</p>\n<p>在此之前，先简单的说明一般会有以下五种方式实例化对象：</p>\n<p>①、使用new关键字；</p>\n<p>②、使用Class类的newInstance方法；</p>\n<p>③、使用Constructor类的newInstance方法；</p>\n<p>④、使用Object类的clone方法；</p>\n<p>⑤、使用反序列化的方式；<br></p>\n<h1><a href=\"#实例化对象的几种方式\" name=\"实例化对象的几种方式\"></a>实例化对象的几种方式</h1>\n<h2><a href=\"#new关键字实例化对象\" name=\"new关键字实例化对象\"></a>new关键字实例化对象</h2>\n<p>最常见，也是最简单的实例化对象的方式，通过这种方式，可以调用任意一个构造函数。</p>\n<p>如：</p>\n<pre><code>    Student student = new Student();\n    Student student = new Student(\"小明\");\n</code></pre>\n<h2><a href=\"#使用class类的newinstance方法\" name=\"使用class类的newinstance方法\"></a>使用Class类的newInstance方法</h2>\n<p>使用Class类的newInstance方法，此方法会默认调用对象的无参构造器，所以如果有重写构造器的话需要显式写出无参构造器，否则会报“InstantiationException”异常。</p>\n<pre><code>	Student classStudent = (Student) Class.forName(\"com.dimple.NewObject.Student\").newInstance();//需要无参构造器，使用Class的\n	classStudent.sayHello();\n</code></pre>\n<p>当然了，也可以这样写：</p>\n<pre><code>    Student classStudent = Student.class.newInstance();\n	classStudent.sayHello();\n</code></pre>\n<p><em>使用Student.class代替常常的全限定名。</em></p>\n<h2><a href=\"#使用constructor的newinstance方法\" name=\"使用constructor的newinstance方法\"></a>使用Constructor的newInstance方法</h2>\n<p>java.lang.reflect.Constructor类中也有一个newInstance方法可以反射创建对象。<br>查看源码可以看到newInstance的方法如下：</p><p><img src=\"http://images.bianxiaofeng.com/57f897e9d2d1c78422651876a1ac19cc.png\" style=\"\"><br></p>\n<p>可以看到该方法是有不定参数的，而这个参数最终是调用ConstructorAccessor的newInstance方法的参数，所以Contstructor的newInstance方法是可以调用有参构造器的。</p>\n<p>反观Class类的newInstance方法是没有任何参数可以传递的，这也就意味它不能调用有参构造，只能是使用默认的构造器进行实例化。</p>\n<pre><code>    Constructor&lt;Student&gt; constructor = Student.class.getConstructor(String.class);\n	Student constructorStudent = constructor.newInstance(\"小明\");\n</code></pre>\n<p><em>Spring、Hibernate、Struts等开源框架，也是采用的这种方式进行实例化对象，并采用复杂的处理对它们进行管理。</em></p>\n<h2><a href=\"#使用clone方法\" name=\"使用clone方法\"></a>使用Clone方法</h2>\n<p>Clone方法是Object类的方法，而我们知道所有的类的父类都是Object，所以每个类都是可以使用clone方法的。在此之前，此类需要实现Cloneable接口，否则会触发CloneNotSupportedException异常。</p>\n<pre><code>		Student clone = (Student) constructorStudent.clone();\n		clone.sayHello();\n</code></pre>\n<p>当调用一个对象的clone方法的时候，JVM会创建一个新的对象，然后将该对象的内容全部拷贝到新的对象中。需要注意的是，使用clone方法不会调用构造函数。</p>\n<h2><a href=\"#使用反序列化\" name=\"使用反序列化\"></a>使用反序列化</h2>\n<p>很早之前，在学习流的时候，有一个ObjectInputStream，在书上介绍的时候说到是序列化的时候用到的，当然了，现在整理这些知识的的时候也能够将以前的知识给串通。</p>\n<p>把对象转换为字节序列的过程称为对象的序列化。<br>把字节序列恢复为对象的过程称为对象的反序列化。</p>\n<p>java.io.ObjectOutputStream代表对象输出流，它的writeObject(Object obj)方法可对参数指定的obj对象进行序列化，把得到的字节序列写到一个目标输出流中。 </p>\n<p>java.io.ObjectInputStream代表对象输入流，它的readObject()方法从一个源输入流中读取字节序列，再把它们反序列化为一个对象，并将其返回。</p>\n<p>为了实现序列化，需要让该类实现Serializable接口，否则会触发NotSerializableException异常。</p>\n<pre><code>		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(\"data.o\"));\n		objectOutputStream.writeObject(clone);\n		objectOutputStream.close();\n\n		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(\"data.o\"));\n		Student studentSerialization = (Student) objectInputStream.readObject();\n		objectInputStream.close();\n		studentSerialization.sayHello();\n</code></pre>\n<p>首先是将对象序列化，然后通过反序列化获得一个新的对象，这种方式也是不走构造器的，直接由JVM创建对象。</p>\n<h2><a href=\"#源码\" name=\"源码\"></a>源码</h2>\n<p>为了方便说明，也是直接写了几行代码。</p>\n<pre><code>package com.dimple.NewObject;\n\nimport java.io.*;\nimport java.lang.reflect.Constructor;\nimport java.lang.reflect.InvocationTargetException;\n\n/**\n * Created by Dimple on 2018/7/22/20:04\n */\npublic class Student implements Cloneable {\n	private String name;\n\n	//含参构造器\n	public Student(String name) {\n		this.name = name;\n	}\n\n	//无参构造器\n	public Student() {\n		super();\n	}\n\n	//定义的方法\n	public void sayHello() {\n		System.out.println(\"Hello \" + name);\n	}\n\n	public String getName() {\n		return name;\n	}\n\n	public void setName(String name) {\n		this.name = name;\n	}\n\n	//所有异常全部抛出\n	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException, IOException {\n//		1、使用new关键字创建对象\n		Student newStudent = new Student(\"小明\");\n//		调用对象的方法\n		newStudent.sayHello();\n//		2、使用Class类的newInstance方法\n		Student classStudent = Student.class.newInstance();//需要无参构造器\n		classStudent.setName(\"小明\");\n		classStudent.sayHello();\n//		3、使用Constructor类的newInstance方法\n		Constructor&lt;Student&gt; constructor = Student.class.getConstructor(String.class);//说明有参构造器的形参类型\n		Student constructorStudent = constructor.newInstance(\"小明\");//使用的是有参构造器\n		constructorStudent.sayHello();\n//		4、使用Object类的clone方法，需要实现Cloneable接口\n		Student clone = (Student) constructorStudent.clone();\n		clone.sayHello();\n//		5、使用反序列化创建对象，需要实现Serializable接口\n//		    先进行序列化\n		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(\"data.o\"));\n		objectOutputStream.writeObject(clone);\n		objectOutputStream.close();\n//		    再反序列化成为一个新的对象\n		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(\"data.o\"));\n		Student studentSerialization = (Student) objectInputStream.readObject();\n		objectInputStream.close();\n		studentSerialization.sayHello();\n	}\n}\n\n</code></pre>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:44:15');
INSERT INTO `bg_blog` VALUES (33, 49, 'SpringMVC文件AJAX上传+JQuery文件进度条', '文件上传是一个很常用的功能，比如头像上传，视频上传等等，本文主要使用SpringMVC+Ajax实现文件上传，下载，删除等操作，同时重写CommonsMultipartResolver添加监听器ProgressListener，通过客户端轮询的方式来获取上传文件的进度。本文会首先介绍文件AJAX上传并获取进度的操作。', '1', 0, '1', 209, 'http://images.bianxiaofeng.com/3b5d357dd6f37f8b1d7de410c022224a.jpg', '2', '<p><span style=\"color: inherit; font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 36px;\">前言</span><br></p>\n<p>文件上传是一个很常用的功能，比如头像上传，视频上传等等，本文主要使用SpringMVC+Ajax实现文件上传，下载，删除等操作，同时重写CommonsMultipartResolver添加监听器ProgressListener，通过客户端轮询的方式来获取上传文件的进度。本文会首先介绍文件AJAX上传并获取进度的操作。<br><br>* <a href=\"#前言\">前言</a><br>* <a href=\"#文件上传\">文件上传</a><br>	* <a href=\"#前端设计\">前端设计</a><br>	* <a href=\"#java后端设计\">Java后端设计</a><br>	* <a href=\"#commonsmultipartresolver文件上传解析器\">CommonsMultipartResolver文件上传解析器</a><br>	* <a href=\"#监听器\">监听器</a><br>	* <a href=\"#progress-bean\">Progress Bean</a><br>	* <a href=\"#controller\">controller</a><br>* <a href=\"#误区\">误区</a><br>	* <a href=\"#在spring的配置文件中的commonmutipartresolver配置的id名称\">在Spring的配置文件中的CommonMutipartResolver配置的id名称</a><br>	* <a href=\"#轮询的方式\">轮询的方式</a><br>	* <a href=\"#demo文件下载地址\">Demo文件下载地址</a></p>\n<h1><a href=\"#文件上传\" name=\"文件上传\"></a>文件上传</h1>\n<p>一般就文件上传的方式来说，有两种：</p>\n<ul>\n  <li>第一种：使用FORM表单提交的方式，在这种提交的方式中，需要将FORM表单的==method==设置为POST方式，同时需要将==enctype==设置为multipart/form-data</li>\n  <li>第二种：使用AJAX的方式，使用这种方式来获取form表单中的二进制流也有两种实现策略：\n    <ul>\n      <li>1、使用FormData对象：FormData对象是HTML5 的一个对象，目前的很多浏览器已经兼容。</li>\n      <li>2、使用Jquery.form.js插件：它提供了大量的操作表单的方法。<a href=\"http://jquery.malsup.com/form/\">详情可以点击这里查看官方文档</a></li>\n    </ul>\n  </li>\n</ul>\n<p>在开始之前需要添加以下依赖：</p>\n<pre><code class=\"xml\"> &lt;!-- https://mvnrepository.com/artifact/commons-io/commons-io --&gt;\n        &lt;dependency&gt;\n            &lt;groupId&gt;commons-io&lt;/groupId&gt;\n            &lt;artifactId&gt;commons-io&lt;/artifactId&gt;\n            &lt;version&gt;2.6&lt;/version&gt;\n        &lt;/dependency&gt;\n        &lt;!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload --&gt;\n        &lt;dependency&gt;\n            &lt;groupId&gt;commons-fileupload&lt;/groupId&gt;\n            &lt;artifactId&gt;commons-fileupload&lt;/artifactId&gt;\n            &lt;version&gt;1.3.3&lt;/version&gt;\n        &lt;/dependency&gt;\n</code></pre>\n<h2><a href=\"#前端设计\" name=\"前端设计\"></a>前端设计</h2>\n<p>效果如图：</p>\n<p><img src=\"http://p2sj58chj.bkt.clouddn.com/blog/20180808205344.png\"></p>\n<pre><code class=\"jsp\">&lt;%@ page contentType=\"text/html;charset=UTF-8\" language=\"java\" %&gt;\n&lt;!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"&gt;\n&lt;html&gt;\n&lt;head&gt;\n    &lt;title&gt;文件上传下载&lt;/title&gt;\n    &lt;script src=\"jquery/jquery-3.3.1.js\"&gt;&lt;/script&gt;\n&lt;/head&gt;\n&lt;body&gt;\n&lt;style&gt;\n    #progressbar {\n        width: 200px;\n        border: 1px solid darkgray;\n        height: 15px;\n        border-radius: 1rem;\n        display: none;\n    }\n    #fill {\n        height: 15px;\n        text-align: center;\n        line-height: 15px;\n        border-radius: 1rem;\n        background-color: mediumturquoise;\n    }\n&lt;/style&gt;\n\n\n&lt;div id=\"progressbar\"&gt;\n    &lt;div id=\"fill\"&gt;&lt;/div&gt;\n&lt;/div&gt;\n&lt;form action=\"#\" id=\"form\"&gt;\n    &lt;input type=\"file\" name=\"file\"/&gt;\n    &lt;input type=\"button\" value=\"上传\" onclick=\"upload()\"/&gt;\n&lt;/form&gt;\n&lt;/body&gt;\n&lt;/html&gt;\n&lt;script type=\"text/javascript\"&gt;\n    var interval;\n    function upload() {\n        var formData = new FormData($(\"form\")[0]);\n        interval = setInterval(getProgress, 100);//开启定时器（间歇调用）\n        $.ajax({\n            url: \"/upload\",\n            type: \"POST\",\n            data: formData,\n            cache: false,\n            processData: false,//此处需要设置为false\n            contentType: false,//此处需要设置为false\n            success: function (data) {\n                console.log(data);\n            }\n        });\n    }\n    //轮询获取文件上传进度的方法\n    function getProgress() {\n        $(\"#progressbar\").show()\n        $.ajax({\n            url: \"getInfo\",\n            type: \"get\",\n            success: function (progressdata) {\n                    clearInterval(interval);\n                }\n                $(\"#fill\").css(\"width\", progressdata+\"%\");\n                $(\"#fill\").text(progressdata+\"%\");\n                console.log(progressdata);\n            }\n        });\n    }\n&lt;/script&gt;\n&lt;/html&gt;\n</code></pre>\n<p>这里解释下：</p>\n<p>使用的是刚才说到的第一种方式，即使用FormData对象的方式来进行ajax上传。</p>\n<h2><a href=\"#java后端设计\" name=\"java后端设计\"></a>Java后端设计</h2>\n<p>刚才说到了我们的核心思想分为下面几步：</p>\n<h2><a href=\"#commonsmultipartresolver文件上传解析器\" name=\"commonsmultipartresolver文件上传解析器\"></a>CommonsMultipartResolver文件上传解析器</h2>\n<p>1、重写CommonsMultipartResolver文件上传解析器，如果只是文件上传是不需要重写的，这里需要用到重写是因为需要设置文件上传的监听器。</p>\n<pre><code class=\"java\">/*CustomMultipartResolver.java*/\npublic class CustomMultipartResolver extends CommonsMultipartResolver {\n	@Autowired\n	FileUploadProgressListener progressListener;\n	@Override\n	public MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {\n		String encoding = determineEncoding(request);//获取字符编码，这个很重要\n		FileUpload fileUpload = prepareFileUpload(encoding);//获取FileUpload对象\n		progressListener.setSession(request.getSession());//保存数据到session\n		fileUpload.setProgressListener(progressListener);//设置监听器\n		try {\n			List&lt;FileItem&gt; fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);//解析数据\n			return parseFileItems(fileItems, encoding);\n		} catch (FileUploadBase.SizeLimitExceededException ex) {\n			throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), ex);\n		} catch (FileUploadException ex) {\n			throw new MultipartException(\"Could not parse multipart servlet request\", ex);\n		}\n	}\n}\n\n</code></pre>\n<p>当然了以上的代码除了需要自己添加设置监听器的代码，其他的可以参考源码实现：</p>\n<p><img src=\"http://p2sj58chj.bkt.clouddn.com/blog/20180808211423.png\" alt=\"enter description here\"></p>\n<p>为了让Spring知道这个multipartResolver的存在，还需要在springMVC.xml中配置：</p>\n<pre><code class=\"xml\"> &lt;bean id=\"multipartResolver\" class=\"com.dimple.resolver.CustomMultipartResolver\"&gt;\n        &lt;!--&lt;property name=\"defaultEncoding\" value=\"UTF-8\"/&gt;--&gt;\n        &lt;!--&lt;property name=\"maxUploadSize\" value=\"102400000 \"/&gt;   &amp;lt;!&amp;ndash; 最大文件大小限制 &amp;ndash;&amp;gt;--&gt;\n &lt;/bean&gt;\n</code></pre>\n<h2><a href=\"#监听器\" name=\"监听器\"></a>监听器</h2>\n<p>2、既然说到了要监听，那么就需要设置一个监听器，此监听器是实现了ProgressListener接口，重写了update方法。</p>\n<p>监听器代码如下：</p>\n<pre><code class=\"java\"><br>/*FileUploadProgressListener.java*/\n@Component\npublic class FileUploadProgressListener implements ProgressListener {\n\n	private HttpSession session;\n\n	/**\n	 * 设置Session，这样能够将状态保存在session域中\n	 * @param session\n	 */\n	public void setSession(HttpSession session) {\n		this.session = session;\n		Progress status = new Progress();\n		session.setAttribute(\"status\", status);\n	}\n\n	/**\n	 * 文件上传会回调的update方法\n	 * @param bytesRead 已经读取到的字节数\n	 * @param contentLength 该上传文件的总字节数\n	 * @param items 当前是上传第几个文件，默认为1\n	 */\n	@Override\n	public void update(long bytesRead, long contentLength, int items) {\n		Progress status = (Progress) session.getAttribute(\"status\");\n		status.setBytesRead(bytesRead);\n		status.setContentLength(contentLength);\n		status.setItems(items);\n	}\n}\n\n</code></pre>\n<h2><a href=\"#progress-bean\" name=\"progress-bean\"></a>Progress Bean</h2>\n<p>3、以上可以看到有一个Progress类，此类为JavaBean，方便数据传递。</p>\n<p>代码如下：</p>\n<pre><code class=\"java\">/*Progress.java*/\npublic class Progress {\n	private long bytesRead;//已经上传的字节数\n	private long contentLength;//所有文件的总长度\n	private long startTime = System.currentTimeMillis();//开始上传的时间\n	private int items;//正在上传第几个文件\n    /*Geter and Seter*/\n    /*toString*/\n</code></pre>\n<h2><a href=\"#controller\" name=\"controller\"></a>controller</h2>\n<p>4、以上所有都是为了Controller服务的，在Controller中，需要实现两个目标：<br> - 实现文件上传<br> - 实现进度查询</p>\n<p>文件上传的方式很简单：通过File类来设置文件上传的路径的问题，比如这个要放到哪个文件夹中，判断文件夹是否存在等等，还有文件的删除也需要用到File类。创建好文件夹后，便需要将它上传到刚才创建好的文件夹中。</p>\n<pre><code class=\"java\">/*FileUploadController.java*/\n@Controller\npublic class FileUploadController {\n	/**\n	 * 文件上传的处理\n	 *\n	 * @param request request用于获取Session，方便向session存值\n	 * @param file    文件上传类\n	 * @return 文件上传状态字符串：ok，error\n	 */\n	@ResponseBody\n	@RequestMapping(value = \"/upload\", method = RequestMethod.POST)\n	public String upload(HttpServletRequest request, @RequestParam(\"file\") CommonsMultipartFile[] file) {\n		String path = request.getSession().getServletContext().getRealPath(\"upload\");\n		for (int i = 0; i &lt; file.length; i++) {\n			String fileName = file[i].getOriginalFilename();//获取原始的文件名称\n			System.out.println(path);\n			File targetFile = new File(path, fileName);\n			if (!targetFile.exists()) {\n				targetFile.mkdirs();//创建文件夹\n			}\n			try {\n				file[i].transferTo(targetFile);//将文件转移到指定的文件夹中\n			} catch (Exception e) {\n				e.printStackTrace();\n				return \"error\";\n			}\n		}\n		return \"ok\";\n	}\n\n	/**\n	 * 用于处理客户端轮询获取文件上传进度\n	 * @param request 用于从session中取出值\n	 * @throws IOException\n	 */\n	@RequestMapping(\"getInfo\")\n	@ResponseBody\n	public String getProgress(HttpServletRequest request) throws IOException {\n		Progress progress = (Progress) request.getSession().getAttribute(\"status\");\n		System.out.println(progress);\n		DecimalFormat decimalFormat = new DecimalFormat(\"0\");\n		String result = decimalFormat.format((float) progress.getBytesRead() / (float) progress.getContentLength() * 100);\n		if (\"100\".equals(result)) {\n		}\n		return result;\n	}\n}\n</code></pre>\n<p>在getProgress方法中，就很简单了，由于监听器是将数据放在session域里面的，只需要将数据取出来进行处理传递到客户端即可。</p>\n<h1><a href=\"#误区\" name=\"误区\"></a>误区</h1>\n<h2><a href=\"#在spring的配置文件中的commonmutipartresolver配置的id名称\" name=\"在spring的配置文件中的commonmutipartresolver配置的id名称\"></a>在Spring的配置文件中的CommonMutipartResolver配置的id名称</h2>\n<p>此处的id必须要为multipartResolver，因为在SpringMV的DispatcherServlet中有一个==initMultipartResolver==方法，方法源码如下：</p>\n<pre><code class=\"java\">/**\n	 * Initialize the MultipartResolver used by this class.\n	 * &lt;p&gt;If no bean is defined with the given name in the BeanFactory for this namespace,\n	 * no multipart handling is provided.\n	 */\n	private void initMultipartResolver(ApplicationContext context) {\n		try {\n			this.multipartResolver = context.getBean(MULTIPART_RESOLVER_BEAN_NAME, MultipartResolver.class);\n			if (logger.isDebugEnabled()) {\n				logger.debug(\"Using MultipartResolver [\" + this.multipartResolver + \"]\");\n			}\n		}\n		catch (NoSuchBeanDefinitionException ex) {\n			// Default is no multipart resolver.\n			this.multipartResolver = null;\n			if (logger.isDebugEnabled()) {\n				logger.debug(\"Unable to locate MultipartResolver with name \'\" + MULTIPART_RESOLVER_BEAN_NAME +\n						\"\': no multipart request handling provided\");\n			}\n		}\n	}\n</code></pre>\n<p>在注释上就说明了如果不按照这个名字进行配置的话，就不会有multipart处理。</p>\n<h2><a href=\"#轮询的方式\" name=\"轮询的方式\"></a>轮询的方式</h2>\n<p>在这个例子中，使用的是普通的轮询方法，就是隔一段时间就向客户端发送请求，服务器收到请求后马上返回响应消息并马上关闭连接。这种写法很简单，但是带来的问题也是显而易见的，因为这样的请求中，就拿我们的文件上传的进度来说，如果文件足够大，500ms去请求服务器，可能很多次都是获取的同样的数据，这样的方式占用带宽比较严重，比较浪费服务器的资源。</p>\n<h2><a href=\"#demo文件下载地址\" name=\"demo文件下载地址\"></a>Demo文件下载地址</h2>\n<p><a href=\"https://github.com/DimpleFeng/FileUploadSSM\">Click Me</a></p>', 'DragonWen', '2019-01-30 00:00:00', NULL, '2019-02-18 00:00:00');
INSERT INTO `bg_blog` VALUES (34, 48, '对HashMap的思考', 'HashMap是一个散列表，它存储的内容是==Key-Value==键值对的映射。类原型如下：继承自抽象类AbstractMap<K,V>，实现Map接口，Cloneable主要是用于clone方法，以及序列化接口。', '1', 0, '1', 167, 'http://images.bianxiaofeng.com/75c0c7d78482671b30e81f3978bbb5f9', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>HashMap是一个散列表，它存储的内容是==Key-Value==键值对的映射。</p>\n<p>类原型如下：</p>\n<p>继承自抽象类AbstractMap&lt;K,V&gt;，实现Map接口，Cloneable主要是用于clone方法，以及序列化接口。</p>\n<pre><code class=\"java\">public class HashMap&lt;K,V&gt; extends AbstractMap&lt;K,V&gt;\n    implements Map&lt;K,V&gt;, Cloneable, Serializable {\n</code></pre>\n<h1>Map的常用类型</h1><p><br></p><p>继承Map接口的有以下几种：</p>\n<ul>\n  <li>HashMap：根据键的HashCode值进行数据的存储，可以直接根据键获取值，访问速度很快。是非同步的，即线程不安全。==key和value都可以为null，但是只能有一个为null的key，value无限制。==</li>\n  <li>TreeMap：能够根据底层的红黑二叉树来对插入的数据按照==key==进行从小到大的排序。且其key不能为null，value可以为null。==key为null时，在代码编写阶段不会报错，但运行时报NullPointerException。==同时TreeMap非同步的，线程不安全。</li>\n  <li>HashTable：HashTable的key与value是不能为null，且和HashMap最大的区别是HashTable是线程安全的，其方法都是有==synchronized==关键字修饰的，其继承自==Dictionary==。但是不建议使用，因为并发不如ConcurrentHashMap，因为ConcurrentHashMap引入了分段锁。</li>\n  <li>LinkHashMap：采用的是链表的方式存储数据，使用Iterator进行遍历的时候，先得到的是最先插入的，即==保留了记录的插入顺序==，和HashMap的底层实现不同，导致使用LinkHashMap的时候的遍历效率比HashMap慢。同时key和value都可以为null，非同步，线程不安全。</li>\n</ul>\n<h1><a href=\"#hashmap的jdk1-6-1-7实现\" name=\"hashmap的jdk1-6-1-7实现\"></a>HashMap的JDK1.6\\1.7实现</h1>\n<p>在JDK1.6,1.7中，HashMap采用的是数组+链表的方式，即使用数组存放链表。同一个HashCode值的元素都是存储在一个链表里面，但是如果位于同一个链表的元素（就是HashCode值相等的元素）增多的时候，查找元素的时候就不能很好的发挥HashMap的功效了。</p>\n<p><img src=\"http://p2sj58chj.bkt.clouddn.com/blog/QQ截图20180809101056.png\" alt=\"enter description here\"></p>\n<p>如图：</p>\n<p>当调用map的put方法放入key-value键值对，那么首先会根据key的hashCode值，计算出在给定的key在数组中的位置，然后放在其后的单链表中。</p>\n<p>这样的设计的好处是减少了Hash碰撞，即HashCode值相同并不一定意味着对象是相同的。那么这些HashCode怎么转化为数组空间的呢？一般是hash(key)%length来得到的。</p>\n<h2><a href=\"#疑问\" name=\"疑问\"></a>疑问</h2>\n<p>1、如果多个key通过hashCode%length这样的算法得到的index都是相同的，会不会被覆盖？</p>\n<p>不会。当A通过计算得到index=1，放在链表中，如果接下来来了一个B，B通过计算得到的index也=1，那么做的事情就是使用头插法将新来的元素插入到链表的头结点。为什么使用头插法呢？可能是觉得新来的元素被查找的概率要高一点吧，毕竟查找是从头开始。</p>\n<p>2、HashMap是允许存入key-value为null的Entry的，那么他们在什么位置呢？</p>\n<p>null key总是放在entry的第一个元素。</p>\n<p>3、get操作原理</p>\n<p>get的函数原型如下：<code>public V get(Object key)</code>，先根据key的HashCode定位到数组的index，然后在这个index位置的链表进行遍历。</p>\n<h1><a href=\"#hashmap在jdk1-8的实现\" name=\"hashmap在jdk1-8的实现\"></a>HashMap在JDK1.8的实现</h1>\n<p>在JDK1.8之后，也许是意识到了当链表长度过长带来的遍历效率的问题，因此，在JDK1.8中最重要的变化之一就是引入了红黑树，当同一个hash值的节点数不小于8时，不再采用单链表形式存储，而是采用红黑树。</p>\n<p>Node是HashMap的一个内部类，实现了Map.Entry接口，本质是就是一个映射(键值对)。</p>\n<p>有时两个key会定位到相同的位置，表示发生了Hash碰撞。当然Hash算法计算结果越分散均匀，Hash碰撞的概率就越小，map的存取效率就会越高。</p>\n<p>HashMap类中有一个非常重要的字段，就是 Node[] table，即哈希桶数组，明显它是一个Node的数组。</p>\n<p>如果哈希桶数组很大，即使较差的Hash算法也会比较分散，如果哈希桶数组数组很小，即使好的Hash算法也会出现较多碰撞，所以就需要在空间成本和时间成本之间权衡，其实就是在根据实际情况确定哈希桶数组的大小，并在此基础上设计好的hash算法减少Hash碰撞。那么通过什么方式来控制map使得Hash碰撞的概率又小，哈希桶数组（Node[] table）占用空间又少呢？答案就是好的Hash算法和扩容机制。</p>\n<h1><a href=\"#常用api\" name=\"常用api\"></a>常用API</h1>\n<p>| clear() | 从 Map 中删除所有映射 |<br>| remove(Object key) | 从 Map 中删除键和关联的值 |<br>| put(Object key, Object value) | 将指定值与指定键相关联 |<br>| putAll(Map t) | 将指定 Map 中的所有映射复制到此 map |<br>| entrySet() | 返回 Map 中所包含映射的 Set 视图。Set 中的每个元素都是一个 Map.Entry 对象，可以使用 getKey() 和 getValue() 方法（还有一个 setValue() 方法）访问后者的键元素和值元素 |<br>| keySet() | 返回 Map 中所包含键的 Set 视图。删除 Set 中的元素还将删除 Map 中相应的映射（键和值） |<br>| values() | 返回 map 中所包含值的 Collection 视图。删除 Collection 中的元素还将删除 Map 中相应的映射（键和值） |<br>| get(Object key) | 返回与指定键关联的值 |<br>| containsKey(Object key) | 如果 Map 包含指定键的映射，则返回 true |<br>| containsValue(Object value) | 如果此 Map 将一个或多个键映射到指定值，则返回 true |<br>| isEmpty() | 如果 Map 不包含键-值映射，则返回 true |<br>| size() | 返回 Map 中的键-值映射的数目 |</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:44:56');
INSERT INTO `bg_blog` VALUES (35, 48, 'Java中的前置++和后置++的理解', '在C、C++等编程语言中都会存在i++，++i,在实际运用中我们总能记住一句话==i++(后置++)是先使用在+1，而++i(前置++)是先自增再使用==。但是在一些很烧脑的场合，这种规律就会“失效”。本文会首先简单的介绍下前置和后置++在一些场合的实际应用，可以看到的是合理的使用++会使得代码简洁不少。', '1', 0, '1', 635, 'http://images.bianxiaofeng.com/75c0c7d78482671b30e81f3978bbb5f9', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>在C、C++等编程语言中都会存在i++，++i,在实际运用中我们总能记住一句话==i++(后置++)是先使用在+1，而++i(前置++)是先自增再使用==。但是在一些很烧脑的场合，这种规律就会“失效”。</p>\n<p>本文会首先简单的介绍下前置和后置++在一些场合的实际应用，可以看到的是合理的使用++会使得代码简洁不少。<br></p>\n<h1><a href=\"#前置后置的实际使用\" name=\"前置后置的实际使用\"></a>++前置后置的实际使用</h1>\n<pre><code class=\"java\">package com.dimple.javabase;\n\nimport java.util.Arrays;\n\n/**\n * @program: JavaSEProject\n * @description: 测试++运算符\n * @author: Dimple\n * @create: 2018-08-14 16:46\n **/\npublic class AddOpt {\n\n	public static void main(String[] args) {\n		int i = 0;\n		String[] people = {\"Dennis Ritchie\", \"Bjarne Stroustrup\", \"James Gosling\"};\n		System.out.println(Arrays.asList(people).toString());\n		System.out.println(\"preposition ++\");\n		System.out.println(\"        before operation···\");\n		System.out.println(\"        i= \"+i);\n		System.out.println(\"        \"+people[i++]);\n		System.out.println(\"        after operation···\");\n		System.out.println(\"        i= \"+i);\n		System.out.println(\"postposition ++\");\n		i = 0;\n		System.out.println(\"        before operation···\");\n		System.out.println(\"        i= \"+i);\n		System.out.println(\"        \"+people[++i]);\n		System.out.println(\"        after operation···\");\n		System.out.println(\"        i= \"+i);\n\n	}\n}\n</code></pre>\n<p>运行结果如下：</p>\n<pre><code class=\"java\">[Dennis Ritchie, Bjarne Stroustrup, James Gosling]\npreposition ++\n        before operation···\n        i= 0\n        Dennis Ritchie\n        after operation···\n        i= 1\npostposition ++\n        before operation···\n        i= 0\n        Bjarne Stroustrup\n        after operation···\n        i= 1\n\nProcess finished with exit code 0\n</code></pre>\n<p>上面的都是很基础的，只是单纯的为了回忆一下，所有需要记住的是：</p>\n<p>==前置++（++i）是先进行++操作后再赋值==<br>==后置++（i++）是先进行赋值再进行++操作==</p>\n<p>最近在网上看到这样一个题，本文的主要目的是这道题。</p>\n<h1><a href=\"#一道很烧脑的题\" name=\"一道很烧脑的题\"></a>一道很烧脑的题</h1>\n<p>朋友在面试的时候遇到了一道题,然后我们一起交流的时候,他把这道题给我说了下,结果我也做错了.所以在此记录下:</p>\n<p>题是这样的:</p>\n<pre><code class=\"java\">package com.dimple.javabase;\n\n/**\n * @program: JavaSEProject\n * @description: 面试题中的一道烧脑题\n * @author: Dimple\n * @create: 2018-08-14 17:00\n **/\npublic class Increment {\n	private static int k = 0;\n	public static void main(String[] args) {\n		int j=0;\n		int n=0;\n		for(int i=0;i&lt;100 ;i++){\n			j=j++;\n			k=k++;\n			n=++n;\n\n		}\n		System.out.println(j);\n		System.out.println(k);\n		System.out.println(n);\n\n	}\n}\n</code></pre>\n<p>答案出乎我的意料：</p>\n<pre><code class=\"java\">0\n0\n100\n</code></pre>\n<p>不需要去看编译后的字节码，其实很简单的就可以看出来：</p>\n<p>分析：<br>在分析之前我们还是先看一个这样的代码：</p>\n<pre><code class=\"java\">package com.dimple.javabase;\n\nimport java.util.Arrays;\n\n/**\n * @program: JavaSEProject\n * @description: 测试++运算符\n * @author: Dimple\n * @create: 2018-08-14 16:46\n **/\npublic class AddOpt {\n\n	public static void main(String[] args) {\n		int j=0;\n		 j = j++;\n		System.out.println(j);\n	}\n}\n</code></pre>\n<p>以上代码如果我们使用的是IDEA编译器的话，在j下面有一个小波浪线提示以下话：</p>\n<blockquote>\n  <p>The value changed at ‘j++’ is never used less… (Ctrl+F1)<br>Inspection info: This inspection points out the cases where a variable value is never used after its assignment, i.e.: &nbsp;- the variable never gets read after assignment OR &nbsp;- the value is always overwritten with another assignment before the next variable read OR &nbsp;- the variable initializer is redundant (for one of the above two reasons)</p>\n</blockquote>\n<p>以上提示说的是：该j变量并没有被使用。emmmmm不是让它=j了吗？以上只是一个小的插曲，接下来开始我们的分析。</p>\n<p>首先我们看到==j=j++;==这样的一句话，本身是有问题的（为了说明，我们把表达式左边的j叫做j1，右边的j叫做j2（注意，只是叫做！））：<br> 1. 执行时，首先是会执行等号右边的话，也就是==j1=j2==这一句话，那么这样的一句话，得到的结果是j1=0，对吧。<br> 2. 这个时候如果按照正常的逻辑，那么应该是执行j++这句话了对吧。是这样没错，肯定是会执行j++这一句话的。注意：执行这个j2++的时候，并不和j1在同一个工作区，j2++完了之后，并没有任何的变量去接收它。导致j2++废弃。所以j一直都是0.</p>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>–操作符同理，其实细致点这个问题是可以看出来的，还是需要修炼基本功呀···</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:45:38');
INSERT INTO `bg_blog` VALUES (36, 48, 'Java读取Properties文件的几种方式', '在Spring的时候，通过XML配置文件的方式进行配置数据库连接池的时候，就会使用==context:property-placeholder==标签进行读取，在这里呢，也是通过Java几种比较基础的方式来读取Properties文件。在开始之前，说下目前比价常用的几种方式：1. 使用java.util.Properties类,可以使用它的load方法加载inputStream字节流。2. 使用java.util.ResourceBundle类来读取。', '1', 0, '1', 184, 'http://images.bianxiaofeng.com/75c0c7d78482671b30e81f3978bbb5f9', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>在Spring的时候，通过XML配置文件的方式进行配置数据库连接池的时候，就会使用==context:property-placeholder==标签进行读取，在这里呢，也是通过Java几种比较基础的方式来读取Properties文件。</p>\n<p>在开始之前，说下目前比价常用的几种方式：<br> 1. 使用java.util.Properties类,可以使用它的load方法加载inputStream字节流。<br> 2. 使用java.util.ResourceBundle类来读取。<br></p>\n<h1><a href=\"#使用properties类\" name=\"使用properties类\"></a>使用Properties类</h1>\n<p>Properties类继承自Hashtable，而Hashtable是实现了Map接口的，所以对Properties类的操作和Map有些相似。</p>\n<p>使用Properties来加载.properties文件的主要关键是在于load方法。而load方法需要的是InputStream流。</p>\n<p>这里比较常用的流的获取有以下几种：</p>\n<ol>\n  <li>使用当前类的ClassLoader()的getResourceAsStream()，getResourcesAsStream返回一个InputStream。</li>\n  <li>使用ClassLoader类的getSystemResourceAsStream()，该方法也返回一个InputStream。</li>\n  <li>使用文件输入流的方式。</li>\n</ol>\n<p>具体示例如下，为了方便，我直接使用的log4j.properties。</p>\n<pre><code class=\"java\">/**\n	 * 单独抽取的方法，用户检测能否正确操纵Properties\n	 *\n	 * @param inputStream\n	 * @throws IOException 为了排版美观，直接抛出异常\n	 */\n	public void printKeyValue(InputStream inputStream) throws IOException {\n		Properties properties = new Properties();\n		properties.load(inputStream);\n		Set&lt;Object&gt; keys = properties.keySet();\n		for (Object key : keys) {\n			System.out.println(key + \" = \" + properties.get(key));\n		}\n	}\n\n	/***\n	 * 从当前的类加载器的getResourcesAsStream来获取.\n	 * 使用Class.class.getClassLoader().getResourcesAsStream()进行获取的时候，所填写的路径只能为项目的绝对路径\n	 * @throws IOException\n	 */\n	@Test\n	public void getPropertiesFromResourceAsStream() throws IOException {\n		InputStream resourceAsStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(\"com/dimple/getproperityfile/mylog4j.properties\");\n		printKeyValue(resourceAsStream);\n	}\n\n	/***\n	 * 从文件中获取,使用InputStream字节\n	 * 主要是需要加上src这个文件夹名。。。路径配置需要精确到绝对地址级别\n	 * 什么意思，就是如果这个mylog4j文件在com/dimple/getproperityfile/mylog4j.properties下，而这个com文件夹\n	 * 又在src目录下，那么写的时候需要加上这个src，这样的相对路径+项目地址能够构成一个完整的访问地址即可\n	 * @throws IOException\n	 */\n	@Test\n	public void getPropertiesFromFile() throws IOException {\n		InputStream inputStream = new FileInputStream(new File(\"src/com/dimple/getproperityfile/mylog4j.properties\"));\n		printKeyValue(inputStream);\n	}\n\n	/**\n	 * 使用Class类的getSystemResourceAsStream方法\n	 * 和使用当前类的ClassLoader是一样的\n	 *\n	 * @throws IOException\n	 */\n	@Test\n	public void getPropertiesFromClassLoader() throws IOException {\n		InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream(\"com/dimple/getproperityfile/mylog4j.properties\");\n		printKeyValue(systemResourceAsStream);\n	}\n</code></pre>\n<h1><a href=\"#使用resourcebundle类\" name=\"使用resourcebundle类\"></a>使用ResourceBundle类</h1>\n<p>使用ResourcesBundle类也两种方法可以读取到配置文件</p>\n<ol>\n  <li>使用类ResourcesBundle的getBundle方法加载properties文件。</li>\n  <li>使用其派生类PropertyResourceBundle()，通过传入一个InputStream来读取数据。</li>\n</ol>\n<p>代码如下：</p>\n<pre><code class=\"java\">/***\n	 * 使用java.util.ResourceBundle类来加载properties文件，注意不需要带上后缀名。\n	 */\n	@Test\n	public void getPropertiesFromResourceBundle() {\n		ResourceBundle resourceBundle = ResourceBundle.getBundle(\"com/dimple/getproperityfile/mylog4j\");\n		Enumeration&lt;String&gt; keys = resourceBundle.getKeys();\n		while (keys.hasMoreElements()) {\n			String s = keys.nextElement();\n			System.out.println(s + \" = \" + resourceBundle.getString(s));\n		}\n	}\n\n	/**\n	 * 使用InputStream流来进行操作ResourceBundle，获取流的方式由以上几种。\n	 * @throws IOException\n	 */\n	@Test\n	public void getPropertiesFromResourceBundleInputStream() throws IOException {\n		InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream(\"com/dimple/getproperityfile/mylog4j.properties\");\n		ResourceBundle resourceBundle = new PropertyResourceBundle(systemResourceAsStream);\n		Enumeration&lt;String&gt; keys = resourceBundle.getKeys();\n		while (keys.hasMoreElements()) {\n			String s = keys.nextElement();\n			System.out.println(s + \" = \" + resourceBundle.getString(s));\n		}\n	}\n</code></pre>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>以上代码的的方法具体有什么用已经表明了，遇到的问题已经不是代码问题了。而是路径。对于这个路径，相对路径，绝对路径，项目路径，这个路径确实让我有些头痛，在File的Test代码哪里，文件路径近乎是我试出来的。当然读者可能会说，直接拿鼠标去点，能点进去的就是对的，但是，在File那里，我没有加src，是可以点击去的，但是项目报错提示FileNotFound，加上src就能正常访问，但是点不进去。这个原因是因为IDEA这里，有一个工程路径的说法，工程路径并不包含src，而代码是写在src下的，所以导致最后的绝对路径不可达，所以报错。</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:46:09');
INSERT INTO `bg_blog` VALUES (38, 47, '\'OpenSSL SSL_connectSSL_ERROR_SYSCALL in connection to github.com', '今天写了一篇博客，然后准备推到GitHub的时候发现报以下错误', '1', 0, '1', 689, 'http://images.bianxiaofeng.com/eaf4bc2d199e636a63a6b3543fb7beca.jpg', '2', '<p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<p>今天写了一篇博客，然后准备推到GitHub的时候发现报以下错误</p>\n<pre><code>unable to access \'https://github.com/DimpleFeng/dimplefeng.github.io.git/\': OpenSSL SSL_connect: SSL_ERROR_SYSCALL in connection to github.com:443\n</code></pre>\n<h1><a href=\"#解决办法\" name=\"解决办法\"></a>解决办法</h1>\n<p>Git支持三种协议，分别是：git://、ssh://和http://<br>因为HEXO也是将博文编译为静态的文件,然后再push到Git 上的。解决方法是取消http代理。</p>\n<p>打开Git Bash输入以下命令：</p>\n<pre><code>git config --global --unset http.proxy\n</code></pre>\n<p>然后再提交HEXO博文就没问题了。</p>', 'DragonWen', '2019-01-30 00:00:00', NULL, '2019-02-11 00:00:00');
INSERT INTO `bg_blog` VALUES (40, 48, 'Java中接口和抽象类', '经常看到关于Java中的接口和抽象类的比较，看着这两难兄难弟确实还是有些像，又有些不想，借此，想好好总结下他们两。', '1', 0, '1', 175, 'http://images.bianxiaofeng.com/75c0c7d78482671b30e81f3978bbb5f9', '2', '<p><span style=\"color: inherit; font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 36px;\">前言</span><br></p>\n<p>经常看到关于Java中的接口和抽象类的比较，看着这两难兄难弟确实还是有些像，又有些不想，借此，想好好总结下他们两。</p>\n<h1><a href=\"#关于抽象类\" name=\"关于抽象类\"></a>关于抽象类</h1>\n<p>在Java中，抽象类是以abstract关键字修饰的。有抽象方法的一定是抽象类，反之，抽象类不一定有抽象方法，这句话是《Java编程思想》这本书中提到的，说的是只要是被关键字abstract修饰的类都叫抽象类，而不管这个类中是否含有抽象方法。抽象类的定义格式为：</p>\n<pre><code>abstaract class ClassName{}\n</code></pre>\n<p>抽象方法： 抽象方法是一种特殊的方法，只有方法的声明，但是没有方法的实现。抽象方法的声明格式为：</p>\n<pre><code> abstract void function();\n</code></pre>\n<p>抽象类是为了继承而存在的，抽象出子类共有的一些特点，然后交给其具体的实现。</p>\n<p>抽象类并不一定包含抽象方法，它和普通的类一样，也是可以拥有成员变量和普通的成员方法。</p>\n<p>抽象类和普通的类的三点区别：<br>* 抽象方法必须为public或者protected，缺省默认为public。</p>\n<ul>\n  <li>\n  <p>抽象方法不能用来创建对象。</p></li>\n  <li>\n  <p>如果一个类继承自一个抽象类，那么需要实现这个类的所有方法，如果没有实现这个类的所有方法，那么该类也需要被定义为abstract。<br><img src=\"http://p2sj58chj.bkt.clouddn.com/TIM截图20180801205707.png\" alt=\"TIM截图20180801205707\"></p></li>\n</ul>\n<p><strong>另外抽象类是可以有构造器的。</strong></p>\n<h1><a href=\"#关于接口\" name=\"关于接口\"></a>关于接口</h1>\n<p>接口（interface）是对行为的抽象。在java 中定义一个接口的方式如下：</p>\n<pre><code>interface InterfaceName{}\n</code></pre>\n<p>接口中可以含有方法和变量。其中变量会被隐式的指定为public final static 类型。其中的方法会被隐式的指定为public abstract，且不能有方法的实现（“Interface abstract methods cannot have body”）。</p>\n<p>实现一个接口需要用到implements关键字</p>\n<pre><code>class ClassName implements InterfaceA,InterfaceB{}\n</code></pre>\n<p>一个类可以实现多个接口。如果一个抽象类implements某个接口，可以不实现这个接口中的方法。非抽象类implements某个结构就必须要实现该接口中的所有方法。</p>\n<h1><a href=\"#抽象类和接口的区别\" name=\"抽象类和接口的区别\"></a>抽象类和接口的区别</h1>\n<p>区别之处：</p>\n<p>1、接口中的所有方法都是隐含的abstract的，而抽象类亦可以同时包含抽象和非抽象的方法。</p>\n<p>2、一个类可以实现很多接口，但是只能继承自一个抽象类。</p>\n<p>3、类可以不实现抽象类和接口中的所有方法，这种情况下的类需要被声明为abstract。</p>\n<p>4、接口中的变量都是被默认声明为public static final的，而抽象类中的成员变量可以是各种类型的。</p>\n<p>5、Java接口中的成员函数默认都是public的，抽象类中的成员函数可以是private、protected、public的。</p>\n<p>其他：</p>\n<p>1、接口是可以被接口继承的，通过extends关键字声明一个接口是一个接口的子接口，由于接口中的方法和常量都是public的，子接口将继承胡接口的全部方法和常量。</p>\n<p>2、抽象类可以继承自实体类。</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:46:41');
INSERT INTO `bg_blog` VALUES (41, 49, 'Error running \'Tomcat\'Unable to open debugger port (127.0.0.1:2148)的解决办法', '在Web项目运行的时候，IDEA可能会报Error running : Unable to open debugger port (127.0.0.1:2148): java.net.SocketExcept', '1', 0, '1', 741, 'http://images.bianxiaofeng.com/3b5d357dd6f37f8b1d7de410c022224a.jpg', '2', '<p>Web项目运行的时候，IDEA可能会报Error running ‘Tomcat’: Unable to open debugger port (127.0.0.1:2148): java.net.SocketException “socket closed”错误，启动不了Tomcat，在这种时候，网上的解决办法大多都是修改端口的这种方式，但是这种方式治标不治本。<br></p>\n<p>错误截图如下：</p><p><img src=\"http://images.bianxiaofeng.com/8e0f119679a29c2c492cf483dda3650b.png\" style=\"\"><br></p>\n<p>解决办法：</p>\n<p>打开CMD命令行界面：</p>\n<p>输入以下命令，查看1099端口号的占用。</p>\n<pre><code>netstat -ano | find \"1099\"\n</code></pre>\n<p>这里看到的是PID为5440的进程占用1099端口，所以输入以下命令终止进程：</p>\n<pre><code>taskkill -f -pid 5440</code></pre>\n<p><br></p><p><img src=\"http://images.bianxiaofeng.com/4520f1ef3da1e34e051abc9dae22f6be.png\" style=\"width: 595px;\"><br></p><p><br></p><p>重新启动Web项目就不会报错了</p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:48:26');
INSERT INTO `bg_blog` VALUES (42, 48, 'Git常用个人备份笔记', '使用Git的一些笔记；一、新建代码库\n\n1、在当前目录下创建一个Git代码库\n\ngit init\n创建的.git默认是隐藏的，使用命令ls -ah显示出来。\n\n2、新建一个目录，并初始化为Git的代码库', '1', 0, '1', 299, 'http://images.bianxiaofeng.com/2b3994476d088b93917a88fa37a4e128.jpg', '2', '<p><span style=\"color: inherit; font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 36px;\">一、新建代码库</span><br></p>\n<p>1、在当前目录下创建一个Git代码库<br></p>\n<pre><code class=\"ebnf\">git init\n</code></pre>\n<p>创建的.git默认是隐藏的，使用命令ls -ah显示出来。</p>\n<p>2、新建一个目录，并初始化为Git的代码库</p>\n<pre><code class=\"stata\">git init [dir-name]\n</code></pre>\n<p>3、克隆一个项目包括其提交历史</p>\n<pre><code class=\"crmsh\">git clone [url] [local-dir-name]\n</code></pre>\n<h1><a href=\"#二-配置\" name=\"二-配置\"></a>二、配置</h1>\n<p>1、显示当前Git配置</p>\n<pre><code class=\"lua\">git config --list\n</code></pre>\n<p>2、设置提交的时候的用户信息</p>\n<pre><code class=\"verilog\">git config [--global] user.name \"username\"\ngit config [--global] user.email \"email address\"\n</code></pre>\n<h1><a href=\"#三-增加删除文件\" name=\"三-增加删除文件\"></a>三、增加删除文件</h1>\n<p>1、添加指定文件到暂存区</p>\n<pre><code class=\"inform7\">git add [file1] [file2] ···\n</code></pre>\n<p>2、添加指定目录到暂存区，包括子目录</p>\n<pre><code class=\"mipsasm\">git add [dir name]\n</code></pre>\n<p>3、将当前目录下的所有文件到暂存区（包括当前目录下的已经修改的文件夹）</p>\n<pre><code class=\"dockerfile\">git add .\n</code></pre>\n<p>4、删除工作区文件，并且将这次删除放入到暂存区</p>\n<pre><code class=\"inform7\">git rm [file1] [file2]\n</code></pre>\n<p>从版本库中找回rm的文件</p>\n<pre><code class=\"gams\">git checkout --[file]\n</code></pre>\n<p>5、停止追踪指定文件，但该文件会保留到工作区，文件内容不变。</p>\n<pre><code class=\"stata\">git rm --cached [file]\n</code></pre>\n<h1><a href=\"#四-代码提交\" name=\"四-代码提交\"></a>四、代码提交</h1>\n<p>1、提交暂存区到版本库</p>\n<pre><code class=\"inform7\">git commit -m [message]\n</code></pre>\n<p>2、提交暂存区的指定文件到仓库</p>\n<pre><code class=\"markdown\">git commit [file1][file2]··· -m [message]\n</code></pre>\n<p>3、提交工作区自上次commit之后的变化，直接到仓库区</p>\n<pre><code class=\"bash\">git commit -a\n</code></pre>\n<p>4、提交时显示所有的diff信息</p>\n<pre><code class=\"ebnf\">git commit -v\n</code></pre>\n<p>5、使用一次新的commit，代替上一次提交；如果代码没有变化，就用来改写上一次的commit提交信息。commit的SHA1会发生改变，上一次的提交的内容不会发生改变。</p>\n<pre><code class=\"sql\">git commit --amend -m [meesage]\n</code></pre>\n<p>6、重做上一次的commit，并包括指定文件的新变化（此时不需要讲file1和file2添加到暂存区）</p>\n<pre><code class=\"inform7\">git commit --amend [file1] [file2]\n</code></pre>\n<h1><a href=\"#五-分支\" name=\"五-分支\"></a>五、分支</h1>\n<p>1、列出所有的分支</p>\n<pre><code class=\"ebnf\">git branch\n</code></pre>\n<p>2、列出所有的远程分支</p>\n<pre><code class=\"stata\">git branch -r\n</code></pre>\n<p>3、新建一个新的分支，但还是停留在当前的分支。工作区会复用，即在master上面修改的内容还没有提交，那么如果新建了一个分支，并切换过去，master的未提交的内容也会跟着带到新的分支。</p>\n<pre><code class=\"irpf90\">git branch [branch-name]\n</code></pre>\n<p>4、新建一个分支，并切换到该分支</p>\n<pre><code class=\"stylus\">git checkout -b [branch-name]\n</code></pre>\n<p>5、新建一个分支，并指定指向的commit，此时如果工作区不干净，切换可能会出现失败，需要使用git stash 将当前工作区的修改给隐藏掉。</p>\n<pre><code class=\"inform7\">git branch [branch-name] [commit id]\n</code></pre>\n<p>6、切换到上一个分支</p>\n<pre><code class=\"nginx\">git branch -\n</code></pre>\n<p>7、在当前的分支和指定的远程分支之间建立追踪关系</p>\n<pre><code class=\"gams\">git branch --set-upstream [branch] [remote-branch]\n</code></pre>\n<p>8、合并指定分支到当前分支</p>\n<pre><code class=\"stata\">git merge [branch]\n</code></pre>\n<p>9、删除分支</p>\n<pre><code class=\"bash\">git branch -d [branch-name]\n</code></pre>\n<p>10、删除一个没有被合并过的分支需要使用-D参数：</p>\n<pre><code class=\"irpf90\">git branch -D [branch-name]\n</code></pre>\n<p>11、删除远程分支</p>\n<pre><code class=\"maxima\">git push [origin-name] --d [branch-name]\n</code></pre>\n<p>12、新建一个分支，指向某个tag</p>\n<pre><code class=\"inform7\">git checkout -b [branch] [tag]\n</code></pre>\n<p>13、显示分支图</p>\n<pre><code class=\"stata\">git log --graph\n</code></pre>\n<p>14、修改分支名称</p>\n<pre><code class=\"irpf90\">git banch -m [old-name] [new-name]\n</code></pre>\n<p>15、合并多次commit</p>\n<pre><code class=\"stata\">git rebase -i [commit]\n</code></pre>\n<p>上面的命令表示的是head分支到commit上一个commit的合并，注意不包括该commit。</p>\n<p>在弹出的Vim编辑页面输入命令： </p>\n<p>Commands:<br> <code>\n# p, pick &lt;commit&gt; = use commit\n# r, reword &lt;commit&gt; = use commit, but edit the commit message\n# s, squash &lt;commit&gt; = use commit, but meld into previous commit\n# f, fixup &lt;commit&gt; = like \"squash\", but discard this commit\'s log message\n# x, exec &lt;command&gt; = run command (the rest of the line) using shell\n# d, drop &lt;commit&gt; = remove commit\n# l, label &lt;label&gt; = label current HEAD with a name\n# t, reset &lt;label&gt; = reset HEAD to a label\n# m, merge [-C &lt;commit&gt; | -c &lt;commit&gt;] &lt;label&gt; [# &lt;oneline&gt;]\n</code></p>\n<p>然后wq保存，再弹出一个Vim编辑框，修改commit信息。</p>\n<p>16、恢复删除的分支</p>\n<pre><code>git reflog 查看之前的这个已经删除的分支的提交历史\ngit branch &lt;之前提交的那个分支的名字&gt; &lt;上一步操作查询到sha1&gt;\n</code></pre>\n<h1><a href=\"#六-标签\" name=\"六-标签\"></a>六、标签</h1>\n<p>1、列出所有标签</p>\n<pre><code class=\"ebnf\">git tag\n</code></pre>\n<p>2、新建一个指向当前commit的tag</p>\n<pre><code class=\"crmsh\">git tag [tag-name]\n</code></pre>\n<p>3、新建一个tag在指定的commit</p>\n<pre><code class=\"crmsh\">git tag [tag-nam] [commit]\n</code></pre>\n<p>4、删除本地tag</p>\n<pre><code class=\"crmsh\">git tag -d [tag-name]\n</code></pre>\n<p>5、删除远程tag</p>\n<pre><code class=\"elixir\">git push [origin-name]:refs/tags/[tag-name]\n</code></pre>\n<p>6、查看tag信息</p>\n<pre><code class=\"maxima\">git show tag\n</code></pre>\n<p>7、提交本地所有tag</p>\n<pre><code class=\"maxima\">git push [origin-name] --tags\n</code></pre>\n<p>8、提交指定tag</p>\n<pre><code class=\"maxima\">git push [origin-name] [tag]\n</code></pre>\n<h1><a href=\"#七-查看信息\" name=\"七-查看信息\"></a>七、查看信息</h1>\n<p>1、查看有变更的文件</p>\n<pre><code class=\"maxima\">git status\n</code></pre>\n<p>2、显示当前分支的版本历史</p>\n<pre><code class=\"vbscript\">git log\n</code></pre>\n<p>3、显示commit历史，以及每次commit发生变更的文件</p>\n<pre><code class=\"perl\">git log --stat\n</code></pre>\n<p>4、显示代码差异</p>\n<pre><code class=\"maxima\">git diff\n</code></pre>\n<p>暂存区没有文件：比较的是当前工作区和上一次的commit的差别。</p>\n<p>暂存区有文件：比较的是当前工作区和暂存区的差别。</p>\n<p>5、显示暂存区和上一次commit的差异</p>\n<pre><code class=\"mipsasm\">git diff --cached [file]\n</code></pre>\n<p>6、显示工作区和当前分支的最新commit的差异</p>\n<pre><code class=\"maxima\">git diff head\n</code></pre>\n<p>7、显示两次提交之间的差异（commit1 和 commit的顺序需要注意，不一样会导致新增和删除错位）</p>\n<pre><code class=\"inform7\">git diff [commit1] [commit2]\n</code></pre>\n<p>8、显示某次提交的元数据的和内容变化</p>\n<pre><code class=\"sql\">git show [commit]\n</code></pre>\n<h1><a href=\"#八-远程同步\" name=\"八-远程同步\"></a>八、远程同步</h1>\n<p>配置远程仓库：</p>\n<pre><code class=\"dockerfile\">git remote add test http://xxxx@git.XXXX.com/scm/wbqa/xxxx.git\n</code></pre>\n<p>test为远程仓库的别名，后面的htpp为远程仓库地址。<br>删除远程仓库：</p>\n<pre><code class=\"stata\">git remote rm test\n</code></pre>\n<p>test为别名</p>\n<p>1、下载远程仓库的所有变动</p>\n<pre><code class=\"inform7\">git fetch [remote]\n</code></pre>\n<p>2、显示所有的远程仓库</p>\n<pre><code class=\"ebnf\">git remote -v\n</code></pre>\n<p>和git remote的差别</p>\n<pre><code class=\"gams\">$ git remote\norigin\n$ git remote -v\norigin  https://github.com/DimpleFeng/GitTest.git (fetch)\norigin  https://github.com/DimpleFeng/GitTest.git (push)\n</code></pre>\n<p>3、取回远程仓库的变化，并和本地分支合并</p>\n<pre><code class=\"inform7\">git pull [remote] [branch]\n</code></pre>\n<p>4、上传本地指定分支到远程仓库</p>\n<pre><code class=\"inform7\">git push [remote] [branch]\n</code></pre>\n<p>5、强行推送当前分支到远程仓库即使有冲突</p>\n<pre><code class=\"avrasm\">git push [remote] --force\n</code></pre>\n<p>6、git remote 通常用于查看别人的进行，因为取回的代码对本地没有影响。</p>\n<pre><code class=\"xml\">git remote add &lt;主机名&gt; &lt;网址&gt; 添加远程主机\ngit remote rm &lt;主机名&gt; 删除远程主机\ngit remote rename &lt;原主机名&gt;&lt;新主机名&gt;\n</code></pre>\n<p>7、git pull 取回远程主机某个分支的更新，再和本地的分支进行合并。</p>\n<pre><code class=\"xml\">git pull &lt;远程主机名&gt; &lt;远程分支名&gt;:&lt;本地分支名&gt;\n</code></pre>\n<p>取回origin主机的next分支，与本地的master合并</p>\n<pre><code class=\"vbscript\">git pulll origin next:master\n</code></pre>\n<p>如果远程分支是和当前的分支进行合并，则冒号后面可以省略。</p>\n<p>在某些场合，Git会自动在远程分支和本地分支之间创建一个追踪关系，如果当前分支和远程分支存在着追踪关系，就可以省略远程分支名称。</p>\n<p>如果当前分支只有一个追踪分支，远程主机名也可以省略。</p>\n<p>8、git push 将本地分支的更新，推送到远程主机</p>\n<pre><code class=\"xml\">git push &lt;远程主机名&gt;&lt;本地分支名&gt;:&lt;远程分支名&gt;\n</code></pre>\n<p>如果省略远程分支名，表示将本地分支推送给与之存在追踪关系的远程分支，如果该分支不存在会被新建。</p>\n<p>如果省略本地分支名，则表示删除指定的远程分支：git push origin :master<br>如果当前分支和远程分支存在追踪关系，则本地分支和远程分支都可以省略。<br>如果只存在一个追踪分支，那么主机名可以省略.</p>\n<p>如果远程主机的版本比本地的新，那么推送到Git的时候会报错，这个时候可以采用git push –force origin强制覆盖远程主机的版本。</p>\n<h1><a href=\"#九-撤销\" name=\"九-撤销\"></a>九、撤销</h1>\n<p>1、恢复暂存区的指定文件到工作区。会丢失提交到暂存区后对该文件的所有操作。</p>\n<pre><code class=\"gams\">git checkout [file]\n</code></pre>\n<p>2、恢复某次commit的指定文件到暂存区和工作区（git处于等待commit状态，同时会丢失在这之前对工作区的修改的内容）</p>\n<pre><code class=\"inform7\">git checkout [commit] [file]\n</code></pre>\n<p>3、恢复暂存区所有文件到工作区。会丢失在提交到暂存区之后的对文件的所有修改。</p>\n<pre><code class=\"erlang\">git checkout .\n</code></pre>\n<p>4、重置暂存区和工作区，与上一次commit一致</p>\n<pre><code class=\"sql\">git reset --hard\n</code></pre>\n<p>5、重置当前分支的head为指定的commit，同时重置暂存区和工作区，与指定commit一致。</p>\n<pre><code class=\"sql\">git reset --hard [commit]\n</code></pre>\n<p>git reset [file] 将file从暂存区回退到工作区（修改内容不会丢失）</p>\n<p>6、将未保存的变化隐藏</p>\n<pre><code class=\"ebnf\">git stash\n</code></pre>\n<p>弹出</p>\n<pre><code class=\"avrasm\">git stash pop\n</code></pre>\n<p>7、查看历史命令</p>\n<pre><code class=\"ebnf\">git reflog\n</code></pre>', 'DragonWen', '2019-01-30 00:00:00', NULL, '2019-02-11 00:00:00');
INSERT INTO `bg_blog` VALUES (43, 48, '常见排序算法总结（归并排序）——Java语言（二）', '归并排序（英语：Merge sort，或mergesort），是创建在归并操作上的一种有效的排序算法，效率为 O(NlogN)（大O符号）。1945年由约翰·冯·诺伊曼首次提出。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用，且各层分治递归可以同时进行。', '1', 0, '1', 175, 'http://images.bianxiaofeng.com/75c0c7d78482671b30e81f3978bbb5f9', '2', '<p></p><p><br></p>\n<h1><a href=\"#前言\" name=\"前言\"></a>前言</h1>\n<blockquote>\n  <p>归并排序（英语：Merge sort，或mergesort），是创建在归并操作上的一种有效的排序算法，效率为 O(NlogN)（大O符号）。1945年由约翰·冯·诺伊曼首次提出。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用，且各层分治递归可以同时进行。<br><br>归并排序的图示：</p>\n</blockquote>\n<p><img src=\"http://images.bianxiaofeng.com/df38e3a21566f1b82c93220684d75fe4.gif\" style=\"float: none;\" class=\"\"></p>\n<h1><a href=\"#算法讲解\" name=\"算法讲解\"></a>算法讲解</h1>\n<p>归并排序算法是采用经典的分治策略，将问题divide成一些小问题，然后在conquer阶段将分的阶段得到的答案修补在一起，即为分而治之。</p><p><img src=\"http://images.bianxiaofeng.com/df38e3a21566f1b82c93220684d75fe4.gif\" style=\"width: 280px; float: none;\"></p><br><p>任何的递归都可以采用迭代来实现，递归行为实质上是压栈和出栈的过程。</p>\n<h1><a href=\"#算法实例\" name=\"算法实例\"></a>算法实例</h1>\n<p>算法流程：</p>\n<ul>\n  <li>对待排序数组array进行拆分，即分治思想中的分。</li>\n  <li>将array分为两组之后进行排序,保证子序列有序。在保证子序列有序的过程中还会递归上一步骤，直到left==right的时候。</li>\n</ul>\n<pre><code>    /**\n     * 传入参数合法性校验，然后调用归并排序的方法\n     *\n     * @param array 目标数组\n     */\n    public static void mergeSort(int array[]) {\n        if (array == null || array.length &lt; 2) {\n            return;\n        }\n        sort(array, 0, array.length - 1);\n    }\n\n    /**\n     * 归并排序的实现，这里用到的是分治的思想\n     *\n     * @param array\n     * @param left\n     * @param right\n     */\n    private static void sort(int[] array, int left, int right) {\n        //递归终止条件\n        if (left == right) {\n            return;\n        }\n        int mid = left + ((right - left) &gt;&gt; 1);\n        sort(array, left, mid);\n        sort(array, mid + 1, right);\n        //归并\n        merge(array, left, right);\n    }\n\n    /**\n     * 归并算法\n     *\n     * @param array\n     * @param left\n     * @param right\n     */\n    private static void merge(int[] array, int left, int right) {\n        int mid = left + ((right - left) &gt;&gt; 1);//防止因为left和right太大导致的integer越界，相当于left+(right-left)/2\n        int[] help = new int[right - left + 1];//建立辅助数组\n        int i = 0;\n        int p1 = left;//p1指向left的数组第一个\n        int p2 = mid + 1;//p2指向right数组的第一个\n        while (p1 &lt;= mid &amp;&amp; p2 &lt;= right) {\n            //比较，谁小填入辅助数组\n            help[i++] = array[p1] &lt; array[p2]   ? array[p1++] : array[p2++];\n        }\n        //上面的while循环结束，当且只当p1和p2有一个越界，下面的两个while是将剩下的数组数据填到辅助数组\n        while (p1 &lt;= mid) {\n            help[i++] = array[p1++];\n        }\n        while (p2 &lt;= right) {\n            help[i++] = array[p2++];\n        }\n        //数据回填，将辅助数组的数据回填到原数组\n        for (i = 0; i &lt; help.length; i++) {\n            array[left + i] = help[i];\n        }\n    }\n\n</code></pre>\n<h1><a href=\"#总结\" name=\"总结\"></a>总结</h1>\n<p>时间复杂度分析：</p>\n<p>递归行为可以采用master公式：</p>\n<p class=\"alert alert-success\">T(N)=a*T(N/b)+O(N^d)</p>\n<p>以上算法针对的是对于一个数据，可以分为b个部分进行处理。</p>\n<pre><code><br>1) log(b,a) &gt; d -&gt; 复杂度为O(N^log(b,a))\n2) log(b,a) = d -&gt; 复杂度为O(N^d * logN)\n3) log(b,a) &lt; d -&gt; 复杂度为O(N^d)\n</code></pre>\n<p>对于归并来说，可以看做是将一个数据分为两部分来进行处理。</p>\n<p>这里的公式为：</p>\n<pre><code class=\"T(N)=2*T(N/2)+O(N)```\"><br>```d=1,log(b,a)=1```,那么这个时间复杂度为\n\n</code></pre>\n<p>关于master公式：<a href=\"http://www.gocalf.com/blog/algorithm-complexity-and-mastertheorem.html\" target=\"_blank\">www.gocalf.com/blog/algorithm-complexity-and-mastertheorem.html</a></p><p></p>', 'DragonWen', '2019-01-30 00:00:00', 'admin', '2019-04-02 15:47:19');
INSERT INTO `bg_blog` VALUES (44, 53, '我为什么要做一个博客系统', '一直以来都有写博客的习惯，原因很简单，记录和分享。前后经历了CSDN，HEXO等，CSDN给人感觉广告太多，而且不是自己的网站，所以多多少少有点受限的感觉，文章发布了还需要审核，审核时长时长时短。于是后期我转向HEXO，HEXO给了自己DIY的空间，HEXO是一个静态网页集合，而G', '1', 0, '1', 1240, 'http://images.bianxiaofeng.com/ced846eab08578468670a87333e05b5f.jpg', '2', '<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;一直以来都有写博客的习惯，原因很简单，记录和分享。前后经历了CSDN，HEXO等，CSDN给人感觉广告太多，而且不是自己的网站，所以多多少少有点受限的感觉，文章发布了还需要审核，审核时长时长时短。于是后期我转向HEXO，HEXO给了自己DIY的空间，HEXO是一个静态网页集合，而GitHub或者Coding这类代码托管网站也同时提供免费的静态网页托管服务，而我需要付出的，仅仅是一个域名就行，域名做解析，配置cname&nbsp;，解析到静态网页IP地址就行，本地需要安装Node.js做编译，无专门的一体化的Markdown文章编辑器，使用git讲编译好的html静态页面推送到托管平台，如是而已。Hexo有很多好看的主题，首推的就是Next主题，用的人数很多，基于这个的文档教程特多。接下来给大家预览下我之前的网站界面，所有皮肤样式已经上传到GitHub，如果有需要的可以clone下来试试。Hexo的问题在于，免费的托管，国内访问GitHub的速度不是很快，虽然后面接上了Coding，做了分区域解析，但是好像没啥用。在很久之前我也写过几篇关于Hexo使用的博文，我也一并转移到了现在的网站。链接如下：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp; &nbsp; 经历过这些博客平台后，我意识到，只有自己做一个博客系统，才能在锻炼自己的同时做到深度定制化，我是计算机专业的，利用自己的专业知识，做一款博客系统应该不是很难。<br>&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp; &nbsp; 然而我失算了，开始正式做的时间是18年11月20日左右，我给自己定的line是一个月，就是19年1月前。这段时间我在实习，时间不足是其一，第二点，尽管自己在大学期间作为负责人带过几个项目，在中铁二院做了半年的项目经理助理，算个半吊子产品经理，分析需求的时候，没有从各个维度去分析，导致后面功能点在增加，有的时候需要把前面写的一些代码推翻重来。<br><br>&nbsp; &nbsp; 时间不足的问题，我通过每天晚上下班后接着搞它，大学4年，我3年的时间都是呆在学校工作室，我已经养成了晚上学习的习惯，所以这对我不是什么问题。经历过一段时间的需求混乱之后，我下决心革 命，我开始停下来，认真的分析我需要什么，需要以怎样的方式实现，分清主次。逻辑优化点在哪里，我要以什么样的技术去给出solution。<br><br>&nbsp; &nbsp; 两个月的努力吧，有了现在您所看到的，我承认它不是一个好的作品，但在我看来，是两个月的心血，我在细细的打磨它，以前在，现在在，以后也在，每个人都有无限的可能，而我的博客系统也有，它今天可能这样子，明天可能那样子，但无论什么样子，都是我喜欢的样子。<br><br></p>', 'DragonWen', '2019-02-02 00:00:00', 'admin', '2019-04-02 14:58:49');
INSERT INTO `bg_blog` VALUES (47, 53, '测试博客', '这是一个测试', '3', 0, '0', 458, 'http://images.bianxiaofeng.com/0673a81655e93804c2f9bacea88b6998.jpg', '2', '<p>测试</p>', 'DragonWen', '2019-02-02 00:00:00', NULL, '2019-02-11 00:00:00');
INSERT INTO `bg_blog` VALUES (48, 45, 'SpringBoot2——YAML语法', '在一般的Java工程项目中，会使用properties文件，通过properties文件的K:V的格式来读取配置文件中的属性，而在SpringBoot中，推荐使用YAML来代替properties，因为相对于properties文件来说，YAML格式比较清晰，层级关系和结构关', '3', 0, '0', 82, 'http://images.bianxiaofeng.com/75451ad928cd05c935072c1f12b51062.png', '2', '<blockquote>在一般的Java工程项目中，会使用properties文件，通过properties文件的K:V的格式来读取配置文件中的属性，而在SpringBoot中，推荐使用YAML来代替properties，因为相对于properties文件来说，YAML格式比较清晰，层级关系和结构关系比较明显；YAML是一个类似 XML、JSON 的标记性语言。YAML 强调以数据为中心，并不是以标识语言为重点。因而 YAML 本身的定义比较简单，号称“一种人性化的数据格式语言”。</blockquote><h1 style=\"color: rgb(0, 0, 0);\">YAML语法</h1><p style=\"margin-bottom: 0px;\"><br></p><h2 style=\"color: rgb(0, 0, 0);\">1、基本语法</h2><p style=\"margin-bottom: 0px;\"><br></p><p style=\"margin-top: 5px; margin-bottom: 0px;\">格式：K:(空格)V：表示一堆键值对，<b>注意此处的空格是必须要有的；</b></p><p style=\"margin-top: 5px; margin-bottom: 0px;\">以空格的缩进来控制层级关系，只要是左对齐的一列数据，都是一个层级的；如：</p><pre class=\"prettyprint linenums\" style=\"line-height: 1.42857;\"><code class=\"language-java\">server:\n  port: 80</code></pre><p class=\"text-danger\" style=\"margin-bottom: 0px;\">Note：其属性和值都是大小写敏感的；</p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><h2 style=\"color: rgb(0, 0, 0);\">2、值的写法</h2><p style=\"margin-bottom: 0px;\">字面量：普通的值（数字，字符串，布尔）</p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><p style=\"margin-top: 5px; margin-bottom: 0px;\">K:V :字面量直接写，字符串默认不加单引号或者双引号；但是在某些情况下，加上单引号和双引号是有区别的：</p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><p class=\"alert alert-info\" style=\"margin-top: 5px; margin-bottom: 0px;\">\"\":双引号；不会转义字符串里面的特殊字符；特殊字符会作为本身想表达的意思存在：</p><p style=\"margin-top: 5px; margin-bottom: 0px;\">比如：</p><pre class=\"prettyprint linenums\"><code class=\"language-html\">name: “dimple \\n blog</code></pre><p style=\"margin-top: 5px; margin-bottom: 0px;\">如果使用@Value注解读取会输出：</p><p style=\"margin-top: 5px; margin-bottom: 0px;\">note：注意此处是有换行的</p><pre class=\"prettyprint linenums\"><code class=\"language-java\">dimple\nblog</code></pre><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"alert alert-info\">\'\':单引号，会转义特殊字符，最终输出的只是一个普通的字符串；</p><p style=\"margin-top: 5px; margin-bottom: 0px;\">比如</p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"btn btn-success\">测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"jumbotron\">测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"lead\">测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"img-rounded btn\">测试</p><hr><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><hr><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"btn btn-success\">测试</p><hr><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"btn btn-danger\">测试测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"text-muted\">测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"text-primary\">测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"text-warning\">测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"text-danger\">测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"text-success\">测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"table-bordered\">测试测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"table-responsive\">测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><hr><p style=\"margin-top: 5px; margin-bottom: 0px;\" class=\"alert\">v测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><p style=\"margin-top: 5px; margin-bottom: 0px;\">测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\">测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\">测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\">测试</p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p><p style=\"margin-top: 5px; margin-bottom: 0px;\"><br></p>', 'DragonWen', '2019-02-13 00:00:00', NULL, '2019-02-13 00:00:00');
INSERT INTO `bg_blog` VALUES (49, 49, 'Spring 常用注解', '注解本身没有功能的，就和 xml 一样。注解和 xml 都是一种元数据，元数据即解释数据的数据，这就是所谓配置。', '1', 0, '0', 177, 'http://images.bianxiaofeng.com/cf3fdf8fd09c5c08569c58bd1bf9b5bf.jpg', '2', '<h4>注解本身没有功能的，就和 xml 一样。注解和 xml 都是一种元数据，元数据即解释数据的数据，这就是所谓配置。</h4><p class=\"\">本文主要罗列Spring及SpringMVC相关注解：</p><h2>一、Spring部分</h2><h4>1、声明Bean的注解</h4><pre class=\"prettyprint linenums\"><code class=\"language-java\">@Component注解：组件，没有明确的角色；\n@Service注解：在业务Service层使用；\n@Repository注解：在数据访问层使用；\n@Controller注解：在表现层申明控制器；</code></pre><h4>2、注入bean的注解</h4><pre class=\"prettyprint linenums\"><code class=\"language-java\">@Autowired注解：注入bean，由Spring提供，可用于属性上，set方法上；\n@inject注解：由JSR-330提供；\n@Resource注解：由JSR-250提供</code></pre><p class=\"alert alert-info\">为了简洁好看，可以写在属性上，但是为了逻辑的严密性，比如判断是否为空，为空怎么办？或者是一些需要特殊处理的逻辑性问题，写在set方法上可以加一些逻辑处理；</p><h5>2.1、@Bean</h5><p>@Scope设置Spring容器如何创建Bean，可选值有：</p><pre class=\"prettyprint linenums\"><code class=\"language-java\">1. Singleton：单例，一个Spring容器中只有一个bean的实例，默认；\n2. Protetype：多例，每次调用都会创建一个Bean的实例；\n3. Request：（Web）request表示该针对每一次HTTP请求都会产生一个新的bean，同时该bean仅在当前HTTP request内有效；\n4. Session：（Web）session作用域表示该针对每一次HTTP请求都会产生一个新的bean，同时该bean仅在当前HTTP session内有效;\n5. Global session：（Web） global session作用域类似于标准的HTTP Session作用域，不过它仅仅在基于portlet的web应用中才有意义；</code></pre><p>@PostConstruct 由JSR-250提供，在<b>构造函数执行完之后</b>执行，等价于xml配置文件中bean的initMethod；</p><p>@PreDestory 由JSR-250提供，在<b>Bean销毁之前</b>执行，等价于xml配置文件中bean的destroyMethod；</p><h4>3、配置类相关</h4><pre class=\"prettyprint linenums\"><code class=\"language-java\">@Configuration注解：声明当前类为配置类，相当于XML形式的配置，其内部有@Component注解，表示是一个该类也是一个bean；\n@Bean注解：使用位置在方法上，表示当前方法的返回值为一个bean，相当于XML形式的Bean标签；\n@ComponentScan注解：用于对Component进行扫描装配，相当于XML中的autoScan标签；</code></pre><h4>4、切面相关</h4><pre class=\"prettyprint linenums\"><code class=\"language-java\">@Aspect注解：在类上使用，声明一个切面；\n@After注解：在方法执行之后执行（方法上）；\n@Before注解： 在方法执行之前执行（方法上）；\n@Around注解：在方法执行之前与之后执行（方法上）；\n@PointCut注解：声明切点；</code></pre><p class=\"alert alert-info\">在配置类中需要使用<span style=\"color: rgb(51, 51, 51); font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif; font-size: 15px; letter-spacing: 0.544px;\">@EnableAspectJAutoProxy开启Spring对AspectJ代理的支持；</span></p><h4>5、值注入@Value</h4><p>@Value 为属性注入值（属性上）<br></p><p class=\"\">注入普通字符串</p><pre class=\"prettyprint linenums\"><code class=\"language-java\">    @Value(\"normal\")\n    private String normal; // 注入普通字符串</code></pre><p class=\"\">注入操作系统属性</p><pre class=\"prettyprint linenums\"><code class=\"language-java\">    @Value(\"#{systemProperties[\'os.name\']}\")\n    private String systemPropertiesName; // 注入操作系统属性</code></pre><p class=\"\">注入表达式结果</p><pre class=\"prettyprint linenums\"><code class=\"language-java\">    @Value(\"#{ T(java.lang.Math).random() * 100.0 }\")\n    private double randomNumber; //注入表达式结果</code></pre><p class=\"\">注入其他Bean属性：注入beanInject对象的属性another</p><pre class=\"prettyprint linenums\"><code class=\"language-java\">    @Value(\"#{beanInject.another}\")\n    private String fromAnotherBean;</code></pre><p class=\"\">注入文件资源</p><pre class=\"prettyprint linenums\"><code class=\"language-java\">    @Value(\"classpath:com/hry/spring/configinject/config.txt\")\n    private Resource resourceFile; // 注入文件资源</code></pre><p class=\"\">注入URL资源</p><pre class=\"prettyprint linenums\"><code class=\"language-java\">    @Value(\"http://www.baidu.com\")\n    private Resource testUrl; // 注入URL资源</code></pre><h4>6、异步相关</h4><pre class=\"prettyprint linenums\"><code class=\"language-java\">@EnableAsync注解：配置类中，通过此注解开启对异步任务的支持，叙事性AsyncConfigurer接口（类上）；<br>\n@Async注解：</code>在实际执行的bean方法使用该注解来申明其是一个异步任务（方法上或类上所有的方法都将异步，需要@EnableAsync开启异步任务）</pre><p class=\"alert alert-warning\">注意：异步调用比如由外部函数调用，不能由本类函数调用，否则会绕过代理，变成同步操作；</p><h4>7、定时任务相关</h4><pre class=\"prettyprint linenums\"><code class=\"language-java\">@EnableScheduling注解：在配置类上使用，开启计划任务的支持（类上）<br>@Scheduled注解：<br></code>来申明这是一个任务，包括cron,fixDelay,fixRate等类型（方法上，需先开启计划任务的支持）</pre><h4>8、Enable*相关</h4><p class=\"\">用于开启对XXX的支持；</p><pre class=\"prettyprint linenums\"><code class=\"language-java\">@EnableAspectJAutoProxy注解：开启对AspectJ自动代理的支持<br>\n@EnableAsync注解：开启异步方法的支持<br>\n@EnableScheduling注解：开启计划任务的支持<br>\n@EnableWebMvc注解：开启Web MVC的配置支持<br>\n@EnableConfigurationProperties注解：开启对@ConfigurationProperties注解配置Bean的支持<br>\n@EnableJpaRepositories注解：开启对SpringData JPA Repository的支持<br>\n@EnableTransactionManagement注解：开启注解式事务的支持<br>\n@EnableTransactionManagement注解：开启注解式事务的支持<br>\n@EnableCaching注解：开启注解式的缓存支持</code></pre><h2>二、SpringMVC部分</h2><pre class=\"prettyprint linenums\"><code class=\"language-java\">@EnableWebMvc注解：在配置类中开启Web MVC的配置支持，如一些ViewResolver或者MessageConverter等，若无此句，重写WebMvcConfigurerAdapter方法（用于对SpringMVC的配置）。\n\n@Controller注解：声明该类为SpringMVC中的Controller\n\n@RequestMapping注解：用于映射Web请求，包括访问路径和参数（类或方法上）\n\n@ResponseBody注解：支持将返回值放在response内，而不是一个页面，通常用户返回json数据（返回值旁或方法上）\n\n@RequestBody注解：允许request的参数在request体中，而不是在直接连接在地址后面。（放在参数前）\n\n@PathVariable注解：用于接收路径参数，比如@RequestMapping(“/hello/{name}”)申明的路径，将注解放在参数中前，即可获取该值，通常作为Restful的接口实现方法。\n\n@RestController注解：该注解为一个组合注解，相当于@Controller和@ResponseBody的组合，注解在类上，意味着，该Controller的所有方法都默认加上了@ResponseBody。\n\n@ControllerAdvice注解：通过该注解，我们可以将对于控制器的全局配置放置在同一个位置，注解了@Controller的类的方法可使用@ExceptionHandler、@InitBinder、@ModelAttribute注解到方法上，这对所有注解了 @RequestMapping的控制器内的方法有效。\n\n@ExceptionHandle注解：用于全局处理控制器里的异常\n\n@InitBinder注解：用来设置WebDataBinder，WebDataBinder用来自动绑定前台请求参数到Model中。\n\n@ModelAttribute注解：本来的作用是绑定键值对到Model里，在@ControllerAdvice中是让全局的@RequestMapping都能获得在此处设置的键值对。</code></pre>', 'DragonWen', '2019-02-18 00:00:00', 'admin', '2019-04-02 14:56:03');
INSERT INTO `bg_blog` VALUES (50, 50, 'Intellij IDEA 2019 最新优化配置', '之前在CSDN上写了一点关于IDEA的优化配置之类的文章，有些图片失效了，很多人都希望会有继续更新，于是有了这篇文章', '1', 0, '1', 800, 'http://images.bianxiaofeng.com/a998b9bdf62e2de288c16e5499a4493f.png', '2', '<p></p><p><span style=\"color: inherit; font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 30px;\">前言</span></p><p class=\"alert alert-info\">好吧工欲善其事必先利其器，我平时比较喜欢使用IDEA，这个软件可以很大程度上提高工作效率。IDEA全称IntelliJ IDEA，是用于java语言开发的集成环境（也可用于其他语言），IntelliJ在业界被公认为最好的java开发工具之一，尤其在智能代码助手、代码自动提示、重构、J2EE支持、Ant、JUnit、CVS整合、代码审查、 创新的GUI设计等方面的功能可以说是超常的。IDEA是JetBrains公司的产品，这家公司总部位于捷克共和国的首都布拉格，开发人员以严谨著称的东欧程序员为主。 一直都有想过写一篇关于IDEA的设置优化的博文，因为确实网上的不是很适合我的风格。且网上的优化教程不是很多，自己摸索出来一下，希望能够帮到大家。</p><p>本文呢，会分为一下三部分进行说明：&nbsp;</p><p>1. IDEA设置优化&nbsp;</p><p>2. IDEA的插件优化&nbsp;</p><p>路径：Setting ——&gt; Editor ——&gt; Code Completion ——&gt; Match case3. IDEA的快捷键优化&nbsp;</p><p>其中呢，会针对个别插件进行说明。</p><h2>一、IDEA设置优化</h2><p class=\"alert alert-success\">IDEA破解方法：使用的是最新版的IDEA，破解方法是采用<a href=\"http://idea.lanyus.com/\" target=\"_blank\" style=\"background-color: rgb(255, 255, 255);\">http://idea.lanyus.com/</a>的方法。另外提供破解补丁的方法：JetBrains全系列破解补丁v1.0：<a href=\"https://www.ghpym.com/jetbrainspath.html\" target=\"_blank\"> https://www.ghpym.com/jetbrainspath.html</a></p><h3>1.1、代码提示</h3><p>IDEA默认是不区分大小写的，晚上很多教程都是使用的2017版本的IDEA，事实上，从2018版本开始，IDEA的设置中心已经进行稍微调整；</p><p class=\"btn btn-success\">路径：Setting ——&gt; Editor ——&gt;General ——&gt; Code Completion ——&gt; Match case</p><p></p><p>取消 <b>Match Case</b> 前的选择即可；</p><p>图如下：</p><p><img src=\"http://images.bianxiaofeng.com/c20b2a8f29a4e251c16c375034d74959.png\" style=\"width: 100%; float: none;\" class=\"\"></p><h3>1.2、自动导包</h3><p>我需要在使用某个类的时候自动导入需要的包，默认的方式是要手动进行导包；</p><p class=\"btn btn-success\">路径：Setting ——&gt; Editor ——&gt; General ——&gt; Auto Import&nbsp;</p><p class=\"\"><br></p><p class=\"alert alert-info\">Add Unambiguous inports on the fly: 在写代码的时候会自动的优化； optimize imports on the fly：在写代码的时候会自动导包；</p><p class=\"\">我的设置如下：（注意，因为optimize imports on the fly这个设置是只针对当前项目的，所以如果需要，请在每创建一个项目的时候都来设置下）</p><p><img src=\"http://images.bianxiaofeng.com/881e09921689bba69df1f307b2207be1.png\" style=\"width: 100%;\"></p><p><br></p><h3><span style=\"color: inherit; font-family: inherit;\">1.3、取消启动时自动进入上一次工程</span></h3><p>IDEA默认是启动的时候进入到上一次打开的项目中，这个设置可能会在我们想换一个项目打开的时候出现一些画蛇添足。</p><p class=\"btn btn-success\">路径：Setting ——&gt; Appearance &amp; Behavior ——&gt; System Setting&nbsp;</p><p>取消勾选<b>Reopen last project on startup;</b></p><p>设置截图如下：</p><p><img src=\"http://images.bianxiaofeng.com/2c08c7fa3ac1a532e1daead9e7bdd9c7.png\" style=\"width: 100%;\"><br></p><p><br></p><h3><b>1.4、鼠标滑轮调整编辑区域字体大小</b>&nbsp;</h3><p>写代码的时候眼睛酸痛，需要临时的放大或者缩小编辑区的代码字体大小；</p><p class=\"btn btn-success\">路径：Setting ——&gt; Editor ——&gt; General&nbsp;</p><p>在Mouse中<b>勾选\"change font size (Zoom ) with Ctrl + Mouse Wheel\"</b>；</p><p class=\"\">截图如下：</p><p class=\"\"></p><p class=\"\"><img src=\"http://images.bianxiaofeng.com/ea2541cc18b70f5d0fb308acdef2470d.png\" style=\"width: 100%;\"></p><h3>1.5、自动保存</h3><p class=\"\">自动保存与其他软件的自动保存不一样，其他软件的自动保存会丢失自己的修改记录，Ctrl+Z就回不去了，而IDEA不一样；自动保存是IDEA默认开启的，如果需要关闭的话可以参照以下方式：</p><p class=\"btn btn-success\">路径：Setting ——&gt; Appearance&amp;Behaior ——&gt; System Settings&nbsp;</p><p class=\"\">勾选或取消\"<b>Synchronize files on frame or editor table activation </b>\"以及\"<b>Save files on frame deactivation</b>\"；</p><p class=\"\">截图如下：</p><p class=\"\"><img src=\"http://images.bianxiaofeng.com/eada5b7b8544d2d78ac8fa6733b78b45.png\" style=\"width: 100%;\"></p><p class=\"\"><br></p><h3>1.6、设置自带的Terminal为Git Bash</h3><p>Windows环境下的Terminal是CMD的，如果电脑上有git的话，我更加喜欢将Terminal改为Git Bash，修改方式如下：</p><p class=\"btn btn-success\">路径：Setting ——&gt; Tools ——&gt; Terminal&nbsp;</p><p><b>修改Shell path 为git的bash.exe的路径</b>即可；</p><p>截图如下：</p><p><img src=\"http://images.bianxiaofeng.com/d5eb717cbb9fe8efc99730244194a323.png\" style=\"width: 100%;\"></p><p class=\"alert alert-warning\">修改后的Terminal如果内容里面有中文是会显示乱码的，解决方式：在Git的安装目录的etc目录下，如：D:\\Program Files\\Git\\etc，找到bash.bashrc文件在其最后面添加以下代码，然后重新启动IDEA即可；</p><pre class=\"prettyprint linenums\"><code class=\"language-java\"># 解决中文乱码\nexport LANG=\"zh_CN.UTF-8\"\nexport LC_ALL=\"zh_CN.UTF-8\"</code></pre><h3><span style=\"color: inherit; font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 24px;\">1.7、设置模板</span></h3><p>请参考以下博文：</p><p><a href=\"https://blog.csdn.net/u013412790/article/details/52807102\" target=\"_blank\">https://blog.csdn.net/u013412790/article/details/52807102</a><br></p><h1><span style=\"color: inherit; font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 30px;\">二、插件篇</span></h1><h3>2.1、Lombok plugin</h3><p>开发神器，可以简化你的实体类，让你i不再写get/set方法，还能快速的实现builder模式，以及链式调用方法，总之就是为了简化实体类而生的插件。</p><p><img src=\"http://images.bianxiaofeng.com/3f7a6d4d52cecebb7cbac9899949c875.gif\" style=\"width: 100%;\"><br></p><p></p><h3>2.2、GsonFormat</h3><p>一键根据json文本生成java类&nbsp; 非常方便</p><p><img src=\"http://images.bianxiaofeng.com/28592ad1bf2eb90bd1d5f0482a91095b.gif\" style=\"width: 100%;\"><br></p><p></p><h3>2.3、Rainbow Brackets</h3><p>彩虹颜色的括号&nbsp; 看着很舒服 敲代码效率变高。可以很清楚明白的区分各个括号的范围</p><p><img src=\"http://images.bianxiaofeng.com/364c537db064657e9182724989bc7b7f.png\" style=\"width: 100%;\"><br></p><p></p><h3>2.4、Translation</h3><p>一款翻译插件，多翻译引擎：Google翻译、有道翻译、百度翻译、多语言互译、语音朗读、自动选词、自动单词拆分等功能</p><p><img src=\"https://github.com/YiiGuxing/TranslationPlugin/raw/master/images/screenshots.gif\" style=\"width: 100%;\"></p><h3>2.5、GrepConsole</h3><p>Idea console输出日志一大推，想要快速找到自己想要的类型日志，使用此插件可以快速定位到自己关注的类型日志，比如error，warn，自己也可以配置自己喜欢的颜色~</p><p>自己喜欢的一套配色：</p><pre class=\"prettyprint linenums\"><code class=\"language-java\">Type        Color\nverbose:    #BBB\ndebug:      #33B5E5\ninfo:       #9C0\nassert:     #A6C\nerror:      #F44\nwarning:    #FB3</code></pre><h3>2.6、FindBugs-IDEA</h3><p>完代码后检测下 避免低级bug，强烈建议用一下，一不小心就发现很多老代码的bug<br></p><p><img src=\"http://images.bianxiaofeng.com/58c2df1506cd80bfbe521bdff205fe8d.gif\" style=\"width: 100%;\"><br></p><h3>2.7、其他</h3><p>还有一些很优秀的插件，不完全列举如下：</p><p>CodeGlance<span style=\"white-space:pre\">	</span>右侧文档结构图</p><p>.ignore<span style=\"white-space:pre\">	</span>git 文件提交过滤</p><p>Maven Helper<span style=\"white-space:pre\">	</span>maven插件，打开该pom文件的Dependency Analyzer视图</p><h2>三、快捷键</h2><h3>3.1、自动代码</h3><pre class=\"prettyprint linenums\"><code class=\"language-java\">Ctrl+Alt+O 优化导入的类和包 \nAlt+Insert 生成代码(如get,set方法,构造函数等) 或者右键（Generate） \nfori/sout/psvm + Tab \nCtrl+Alt+T 生成try catch 或者 Alt+enter \nCTRL+ALT+T 把选中的代码放在 TRY{} IF{} ELSE{} 里 \nCtrl + O 重写方法 \nCtrl + I 实现方法 \nCtr+shift+U 大小写转化 \nALT+回车 导入包,自动修正 \nALT+/ 代码提示 \nCTRL+J 自动代码 \nCtrl+Shift+J，整合两行为一行 \nCTRL+空格 代码提示 \nCTRL+SHIFT+SPACE 自动补全代码 \nCTRL+ALT+L 格式化代码 \nCTRL+ALT+I 自动缩进 \nCTRL+ALT+O 优化导入的类和包 \nALT+INSERT 生成代码(如GET,SET方法,构造函数等) \nCTRL+E 最近更改的代码 \nCTRL+ALT+SPACE 类名或接口名提示 \nCTRL+P 方法参数提示 \nCTRL+Q，可以看到当前方法的声明\nShift+F6 重构-重命名 (包、类、方法、变量、甚至注释等) \nCtrl+Alt+V 提取变量\n</code></pre><h3>3.2、查询快捷键</h3><pre class=\"prettyprint linenums\"><code class=\"language-java\">Ctrl＋Shift＋Backspace可以跳转到上次编辑的地 \nCTRL+ALT+ left/right 前后导航编辑过的地方 \nALT+7 靠左窗口显示当前文件的结构 \nCtrl+F12 浮动显示当前文件的结构 \nALT+F7 找到你的函数或者变量或者类的所有引用到的地方 \nCTRL+ALT+F7 找到你的函数或者变量或者类的所有引用到的地方\nCtrl+Shift+Alt+N 查找类中的方法或变量 \n双击SHIFT 在项目的所有目录查找文件 \nCtrl+N 查找类 \nCtrl+Shift+N 查找文件 \nCTRL+G 定位行 \nCTRL+F 在当前窗口查找文本 \nCTRL+SHIFT+F 在指定窗口查找文本 \nCTRL+R 在 当前窗口替换文本 \nCTRL+SHIFT+R 在指定窗口替换文本 \nALT+SHIFT+C 查找修改的文件 \nCTRL+E 最近打开的文件 \nF3 向下查找关键字出现位置 \nSHIFT+F3 向上一个关键字出现位置 \n选中文本，按Alt+F3 ，高亮相同文本，F3逐个往下查找相同文本 \nF4 查找变量来源\nCTRL+SHIFT+O 弹出显示查找内容\nCtrl+W 选中代码，连续按会有其他效果 \nF2 或Shift+F2 高亮错误或警告快速定位 \nCtrl+Up/Down 光标跳转到第一行或最后一行下\nCtrl+B 快速打开光标处的类或方法 \nCTRL+ALT+B 找所有的子类 \nCTRL+SHIFT+B 找变量的类\nCtrl+Shift+上下键 上下移动代码 \nCtrl+Alt+ left/right 返回至上次浏览的位置 \nCtrl+X 删除行 \nCtrl+D 复制行 \nCtrl+/ 或 Ctrl+Shift+/ 注释（// 或者/…/ ）\nCtrl+H 显示类结构图 \nCtrl+Q 显示注释文档\nAlt+F1 查找代码所在位置 \nAlt+1 快速打开或隐藏工程面板\nAlt+ left/right 切换代码视图 \nALT+ ↑/↓ 在方法间快速移动定位 \nCTRL+ALT+ left/right 前后导航编辑过的地方 \nCtrl＋Shift＋Backspace可以跳转到上次编辑的地 \nAlt+6 查找TODO\n</code></pre><h3>3.3、其他快捷键</h3><pre class=\"prettyprint linenums\"><code class=\"language-java\">SHIFT+ENTER 另起一行 \nCTRL+Z 倒退(撤销) \nCTRL+SHIFT+Z 向前(取消撤销) \nCTRL+ALT+F12 资源管理器打开文件夹 \nALT+F1 查找文件所在目录位置 \nSHIFT+ALT+INSERT 竖编辑模式 \nCTRL+F4 关闭当前窗口 \nCtrl+Alt+V，可以引入变量。例如：new String(); 自动导入变量定义 \nCtrl+~，快速切换方案（界面外观、代码风格、快捷键映射等菜单</code></pre><h3>3.4、调试快捷键</h3><pre class=\"prettyprint linenums\"><code class=\"language-java\">alt+F8 debug时选中查看值 \nAlt+Shift+F9，选择 Debug \nAlt+Shift+F10，选择 Run \nCtrl+Shift+F9，编译 \nCtrl+Shift+F8，查看断点\nF7，步入 \nShift+F7，智能步入 \nAlt+Shift+F7，强制步入 \nF8，步过 \nShift+F8，步出 \nAlt+Shift+F8，强制步过\nAlt+F9，运行至光标处 \nCtrl+Alt+F9，强制运行至光标处 \nF9，恢复程序 \nAlt+F10，定位到断点</code></pre><h3>3.5、重构</h3><pre class=\"prettyprint linenums\"><code class=\"language-java\">Ctrl+Alt+Shift+T，弹出重构菜单 \nShift+F6，重命名 \nF6，移动 \nF5，复制 \nAlt+Delete，安全删除 \nCtrl+Alt+N，内联</code></pre><p><br></p><p><br></p>', 'DragonWen', '2019-03-08 00:00:00', 'admin', '2019-04-02 14:45:03');

-- ----------------------------
-- Table structure for bg_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `bg_blog_tag`;
CREATE TABLE `bg_blog_tag`  (
  `blog_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`blog_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bg_blog_tag
-- ----------------------------
INSERT INTO `bg_blog_tag` VALUES (1, 30);
INSERT INTO `bg_blog_tag` VALUES (2, 18);
INSERT INTO `bg_blog_tag` VALUES (3, 19);
INSERT INTO `bg_blog_tag` VALUES (4, 18);
INSERT INTO `bg_blog_tag` VALUES (4, 31);
INSERT INTO `bg_blog_tag` VALUES (5, 18);
INSERT INTO `bg_blog_tag` VALUES (6, 18);
INSERT INTO `bg_blog_tag` VALUES (7, 20);
INSERT INTO `bg_blog_tag` VALUES (8, 18);
INSERT INTO `bg_blog_tag` VALUES (9, 21);
INSERT INTO `bg_blog_tag` VALUES (9, 22);
INSERT INTO `bg_blog_tag` VALUES (10, 18);
INSERT INTO `bg_blog_tag` VALUES (10, 29);
INSERT INTO `bg_blog_tag` VALUES (12, 20);
INSERT INTO `bg_blog_tag` VALUES (13, 20);
INSERT INTO `bg_blog_tag` VALUES (14, 20);
INSERT INTO `bg_blog_tag` VALUES (15, 20);
INSERT INTO `bg_blog_tag` VALUES (16, 20);
INSERT INTO `bg_blog_tag` VALUES (17, 27);
INSERT INTO `bg_blog_tag` VALUES (17, 28);
INSERT INTO `bg_blog_tag` VALUES (18, 24);
INSERT INTO `bg_blog_tag` VALUES (18, 26);
INSERT INTO `bg_blog_tag` VALUES (19, 24);
INSERT INTO `bg_blog_tag` VALUES (20, 24);
INSERT INTO `bg_blog_tag` VALUES (20, 25);
INSERT INTO `bg_blog_tag` VALUES (23, 24);
INSERT INTO `bg_blog_tag` VALUES (24, 23);
INSERT INTO `bg_blog_tag` VALUES (25, 23);
INSERT INTO `bg_blog_tag` VALUES (25, 32);
INSERT INTO `bg_blog_tag` VALUES (27, 23);
INSERT INTO `bg_blog_tag` VALUES (27, 33);
INSERT INTO `bg_blog_tag` VALUES (31, 23);
INSERT INTO `bg_blog_tag` VALUES (31, 34);
INSERT INTO `bg_blog_tag` VALUES (32, 23);
INSERT INTO `bg_blog_tag` VALUES (32, 35);
INSERT INTO `bg_blog_tag` VALUES (34, 23);
INSERT INTO `bg_blog_tag` VALUES (34, 36);
INSERT INTO `bg_blog_tag` VALUES (35, 23);
INSERT INTO `bg_blog_tag` VALUES (36, 23);
INSERT INTO `bg_blog_tag` VALUES (36, 37);
INSERT INTO `bg_blog_tag` VALUES (40, 23);
INSERT INTO `bg_blog_tag` VALUES (40, 38);
INSERT INTO `bg_blog_tag` VALUES (40, 39);
INSERT INTO `bg_blog_tag` VALUES (41, 41);
INSERT INTO `bg_blog_tag` VALUES (41, 42);
INSERT INTO `bg_blog_tag` VALUES (43, 23);
INSERT INTO `bg_blog_tag` VALUES (43, 40);
INSERT INTO `bg_blog_tag` VALUES (44, 17);
INSERT INTO `bg_blog_tag` VALUES (49, 14);
INSERT INTO `bg_blog_tag` VALUES (49, 15);
INSERT INTO `bg_blog_tag` VALUES (49, 16);
INSERT INTO `bg_blog_tag` VALUES (50, 13);
INSERT INTO `bg_blog_tag` VALUES (51, 12);
INSERT INTO `bg_blog_tag` VALUES (51, 43);

-- ----------------------------
-- Table structure for bg_carousel_map
-- ----------------------------
DROP TABLE IF EXISTS `bg_carousel_map`;
CREATE TABLE `bg_carousel_map`  (
  `carousel_id` int(11) NOT NULL AUTO_INCREMENT,
  `img_url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '背景图片地址',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '标题\n',
  `sub_title` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '副标题',
  `display` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否显示，1表示显示，0表示不显示',
  `url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '点击的url地址',
  `target` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '是否当前窗口打开，0表示否，1表示是',
  `click` int(11) NULL DEFAULT 0 COMMENT '点击量',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_by` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`carousel_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '轮播图设置' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bg_carousel_map
-- ----------------------------
INSERT INTO `bg_carousel_map` VALUES (1, '123', 'Spring 常用注解', '21321', '1', '21', '1', 1111, NULL, NULL, NULL, '2019-04-08 17:29:57');

-- ----------------------------
-- Table structure for bg_category
-- ----------------------------
DROP TABLE IF EXISTS `bg_category`;
CREATE TABLE `bg_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `weight` int(11) NULL DEFAULT NULL COMMENT '权重\n',
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `support` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否推荐，1表示推荐，0表示不推荐',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bg_category
-- ----------------------------
INSERT INTO `bg_category` VALUES (15, '其他资料', 1, '其他资料', '0', 'admin', '2019-04-02 15:34:58', 'admin', '2019-04-02 16:37:43');
INSERT INTO `bg_category` VALUES (45, 'SpringBoot', 1, 'SpringBoot', '1', NULL, '2019-01-30 11:22:38', NULL, '2019-01-30 11:22:38');
INSERT INTO `bg_category` VALUES (46, '前端知识', 0, '包括BootStrap、Layui、Echart等多个开源前端框架使用', '0', NULL, '2019-01-12 11:19:15', NULL, '2019-02-01 14:14:11');
INSERT INTO `bg_category` VALUES (47, 'HEXO博客', 0, '以前使用HEXO的时候的一些博客，虽然HEXO在更新换代，但它已经很稳定了，所以这个分类下面的博文仍然适用', '1', NULL, '2019-01-30 11:23:04', NULL, '2019-01-30 11:23:04');
INSERT INTO `bg_category` VALUES (48, 'Java基础', 12, 'Java基础相关，包括Java常见语法，Java集合，Java多线程等知识', '1', NULL, '2019-01-12 11:19:23', NULL, '2019-02-01 15:42:39');
INSERT INTO `bg_category` VALUES (49, 'JavaEE', 0, 'JavaEE 部分知识，包括SpringMVC，Spring，Mybatis，Hibernate，JPA等知识', '1', NULL, '2019-02-01 14:11:48', NULL, '2019-02-01 14:11:48');
INSERT INTO `bg_category` VALUES (50, '软件工具', 0, '软件工具的使用教程，破解方法等', '0', NULL, '2019-02-01 14:12:59', NULL, '2019-02-01 14:12:59');
INSERT INTO `bg_category` VALUES (51, '大学期间资料', 0, '大学期间的资料分享', '1', NULL, '2019-02-01 14:14:40', NULL, '2019-02-01 14:14:40');
INSERT INTO `bg_category` VALUES (52, 'Android', 0, 'Android相关知识', '0', NULL, '2019-02-01 14:15:04', NULL, '2019-02-01 14:15:04');
INSERT INTO `bg_category` VALUES (53, '闲言碎语', 10, '关于我的一些生活感悟之类的', '1', NULL, '2019-02-02 08:03:45', NULL, '2019-02-02 08:03:45');
INSERT INTO `bg_category` VALUES (54, '最代码', 11, 'zuidaima分类', '1', 'admin', '2019-04-23 23:39:40', NULL, NULL);

-- ----------------------------
-- Table structure for bg_link
-- ----------------------------
DROP TABLE IF EXISTS `bg_link`;
CREATE TABLE `bg_link`  (
  `link_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '友链的名称',
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '友链描述',
  `header_img` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '友链图标地址',
  `click` int(11) NULL DEFAULT 0 COMMENT '友链点击数',
  `weight` int(11) NULL DEFAULT 0 COMMENT '友链权重',
  `available` int(11) NULL DEFAULT 1 COMMENT '友链是否能访问，1表示能，0表示不能',
  `processed` int(11) NULL DEFAULT 0 COMMENT '友链是否已经处理，1表示已经处理，0表示没有处理',
  `display` int(11) NULL DEFAULT 0 COMMENT '友链是否显示，1表示显示，0表示不显示',
  `url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '友链的地址',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系邮箱',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`link_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '友链信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bg_link
-- ----------------------------
INSERT INTO `bg_link` VALUES (1, 'test', 'test', 'http://www.bianxiaofeng.com/imgs/favicon.ico', 4, 0, 1, 1, 1, 'http://www.baidu.com', 'owenb@synnex.com', 'admin', '2019-03-26 10:09:32', NULL, NULL);
INSERT INTO `bg_link` VALUES (2, 'test', 'test', 'http://www.bianxiaofeng.com/imgs/favicon.ico', 4, 0, 1, 1, 1, 'http://www.bianxiaofeng.com', 'test@test.com', 'admin', '2019-03-26 10:24:49', NULL, NULL);
INSERT INTO `bg_link` VALUES (3, '最代码', '最代码网站', 'http://static.zuidaima.com/resource/img/logo.png', 0, 1111, 1, 1, 1, NULL, 'zuidaima@qq.com', 'admin', '2019-04-23 23:43:55', NULL, NULL);

-- ----------------------------
-- Table structure for bg_tag
-- ----------------------------
DROP TABLE IF EXISTS `bg_tag`;
CREATE TABLE `bg_tag`  (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签内容',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE,
  UNIQUE INDEX `bg_tag_tag_title_uindex`(`tag_title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标签' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bg_tag
-- ----------------------------
INSERT INTO `bg_tag` VALUES (12, '测试', 'admin', '2019-04-02 12:10:20', NULL, NULL);
INSERT INTO `bg_tag` VALUES (13, 'IDEA', 'admin', '2019-04-02 14:43:42', NULL, NULL);
INSERT INTO `bg_tag` VALUES (14, 'Spring', 'admin', '2019-04-02 14:55:54', NULL, NULL);
INSERT INTO `bg_tag` VALUES (15, 'Java', 'admin', '2019-04-02 14:55:54', NULL, NULL);
INSERT INTO `bg_tag` VALUES (16, '注解', 'admin', '2019-04-02 14:55:54', NULL, NULL);
INSERT INTO `bg_tag` VALUES (17, '个人博客', 'admin', '2019-04-02 14:58:48', NULL, NULL);
INSERT INTO `bg_tag` VALUES (18, 'HEXO', 'admin', '2019-04-02 15:10:33', NULL, NULL);
INSERT INTO `bg_tag` VALUES (19, 'Android Studio', 'admin', '2019-04-02 15:10:56', NULL, NULL);
INSERT INTO `bg_tag` VALUES (20, 'Android', 'admin', '2019-04-02 15:27:13', NULL, NULL);
INSERT INTO `bg_tag` VALUES (21, '视频文档', 'admin', '2019-04-02 15:28:50', NULL, NULL);
INSERT INTO `bg_tag` VALUES (22, '大学资料', 'admin', '2019-04-02 15:28:50', NULL, NULL);
INSERT INTO `bg_tag` VALUES (23, 'Java基础', 'admin', '2019-04-02 15:33:18', NULL, NULL);
INSERT INTO `bg_tag` VALUES (24, 'JavaEE', 'admin', '2019-04-02 15:33:34', NULL, NULL);
INSERT INTO `bg_tag` VALUES (25, '表单数据', 'admin', '2019-04-02 15:34:04', NULL, NULL);
INSERT INTO `bg_tag` VALUES (26, 'Session', 'admin', '2019-04-02 15:34:23', NULL, NULL);
INSERT INTO `bg_tag` VALUES (27, 'Qt', 'admin', '2019-04-02 15:35:26', NULL, NULL);
INSERT INTO `bg_tag` VALUES (28, 'C++', 'admin', '2019-04-02 15:35:27', NULL, NULL);
INSERT INTO `bg_tag` VALUES (29, 'VSCode', 'admin', '2019-04-02 15:35:58', NULL, NULL);
INSERT INTO `bg_tag` VALUES (30, 'MyEclipse', 'admin', '2019-04-02 15:36:18', NULL, NULL);
INSERT INTO `bg_tag` VALUES (31, '收录', 'admin', '2019-04-02 15:41:34', NULL, NULL);
INSERT INTO `bg_tag` VALUES (32, '异常', 'admin', '2019-04-02 15:42:47', NULL, NULL);
INSERT INTO `bg_tag` VALUES (33, 'Object类', 'admin', '2019-04-02 15:43:16', NULL, NULL);
INSERT INTO `bg_tag` VALUES (34, '线程', 'admin', '2019-04-02 15:43:39', NULL, NULL);
INSERT INTO `bg_tag` VALUES (35, '创建对象', 'admin', '2019-04-02 15:43:57', NULL, NULL);
INSERT INTO `bg_tag` VALUES (36, 'HashMap', 'admin', '2019-04-02 15:44:55', NULL, NULL);
INSERT INTO `bg_tag` VALUES (37, 'Properties文件', 'admin', '2019-04-02 15:46:09', NULL, NULL);
INSERT INTO `bg_tag` VALUES (38, '接口', 'admin', '2019-04-02 15:46:40', NULL, NULL);
INSERT INTO `bg_tag` VALUES (39, '抽象类', 'admin', '2019-04-02 15:46:40', NULL, NULL);
INSERT INTO `bg_tag` VALUES (40, '归并排序', 'admin', '2019-04-02 15:47:18', NULL, NULL);
INSERT INTO `bg_tag` VALUES (41, 'JavaWeb', 'admin', '2019-04-02 15:48:25', NULL, NULL);
INSERT INTO `bg_tag` VALUES (42, 'Tomcat', 'admin', '2019-04-02 15:48:25', NULL, NULL);
INSERT INTO `bg_tag` VALUES (43, '最代码', 'admin', '2019-04-23 23:37:30', NULL, NULL);

-- ----------------------------
-- Table structure for bg_tool
-- ----------------------------
DROP TABLE IF EXISTS `bg_tool`;
CREATE TABLE `bg_tool`  (
  `tool_id` int(11) NOT NULL AUTO_INCREMENT,
  `tool_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工具名称',
  `description` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工具描述	',
  `display` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '显示状态，1表示显示，0表示不显示',
  `url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接地址',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `head_img` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `weight` int(11) NULL DEFAULT 0 COMMENT '权重',
  `tool_category_id` int(11) NULL DEFAULT NULL,
  `update_by` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`tool_id`) USING BTREE,
  INDEX `bg_tool_bg_tool_category_tool_category_id_fk`(`tool_category_id`) USING BTREE,
  CONSTRAINT `bg_tool_bg_tool_category_tool_category_id_fk` FOREIGN KEY (`tool_category_id`) REFERENCES `bg_tool_category` (`tool_category_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '常用工具' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for bg_tool_category
-- ----------------------------
DROP TABLE IF EXISTS `bg_tool_category`;
CREATE TABLE `bg_tool_category`  (
  `tool_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `tool_category_title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类的标题',
  `weight` int(11) NULL DEFAULT NULL COMMENT '权重',
  `display` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否显示，1表示显示，0表示不显示',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`tool_category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工具的分类' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for bg_visit_log
-- ----------------------------
DROP TABLE IF EXISTS `bg_visit_log`;
CREATE TABLE `bg_visit_log`  (
  `visit_id` int(11) NOT NULL AUTO_INCREMENT,
  `ip_addr` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `location` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问地址',
  `browser` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器类型',
  `os` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `spider` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '爬虫',
  `request_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `error_msg` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问错误的提示信息',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求的模块',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问状态,1表示正常，0表示不正常',
  PRIMARY KEY (`visit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 171 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '访问日志记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bg_visit_log
-- ----------------------------
INSERT INTO `bg_visit_log` VALUES (1, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'f09a7184-e515-4505-82d8-68b0493bc42e', '2019-07-24 23:41:16', '1');
INSERT INTO `bg_visit_log` VALUES (2, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', 'd9a9b6b6-f7f8-4cc4-8132-f00d4b54b5f0', '2019-07-25 13:54:52', '1');
INSERT INTO `bg_visit_log` VALUES (3, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', '40e3de61-ab5d-4541-912f-876e7aaf54a3', '2019-07-26 14:02:22', '1');
INSERT INTO `bg_visit_log` VALUES (4, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '40e3de61-ab5d-4541-912f-876e7aaf54a3', '2019-07-26 22:24:25', '1');
INSERT INTO `bg_visit_log` VALUES (5, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '40e3de61-ab5d-4541-912f-876e7aaf54a3', '2019-07-26 22:28:11', '1');
INSERT INTO `bg_visit_log` VALUES (6, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '6909b414-2cc1-4694-a576-170b59ad7324', '2019-07-26 22:30:04', '1');
INSERT INTO `bg_visit_log` VALUES (7, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '6909b414-2cc1-4694-a576-170b59ad7324', '2019-07-26 22:30:24', '1');
INSERT INTO `bg_visit_log` VALUES (8, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '6909b414-2cc1-4694-a576-170b59ad7324', '2019-07-26 22:43:50', '1');
INSERT INTO `bg_visit_log` VALUES (9, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '6909b414-2cc1-4694-a576-170b59ad7324', '2019-07-26 22:48:14', '1');
INSERT INTO `bg_visit_log` VALUES (10, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '6909b414-2cc1-4694-a576-170b59ad7324', '2019-07-26 23:03:41', '1');
INSERT INTO `bg_visit_log` VALUES (11, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '6909b414-2cc1-4694-a576-170b59ad7324', '2019-07-26 23:04:19', '1');
INSERT INTO `bg_visit_log` VALUES (12, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '6909b414-2cc1-4694-a576-170b59ad7324', '2019-07-26 23:11:40', '1');
INSERT INTO `bg_visit_log` VALUES (13, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '6909b414-2cc1-4694-a576-170b59ad7324', '2019-07-26 23:12:25', '1');
INSERT INTO `bg_visit_log` VALUES (14, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '6909b414-2cc1-4694-a576-170b59ad7324', '2019-07-26 23:14:09', '1');
INSERT INTO `bg_visit_log` VALUES (15, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '6909b414-2cc1-4694-a576-170b59ad7324', '2019-07-26 23:14:34', '1');
INSERT INTO `bg_visit_log` VALUES (16, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '6909b414-2cc1-4694-a576-170b59ad7324', '2019-07-26 23:15:18', '1');
INSERT INTO `bg_visit_log` VALUES (17, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '6909b414-2cc1-4694-a576-170b59ad7324', '2019-07-26 23:15:31', '1');
INSERT INTO `bg_visit_log` VALUES (18, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'edbc626f-719a-4914-ac65-93656de5d8f1', '2019-07-27 17:08:37', '1');
INSERT INTO `bg_visit_log` VALUES (19, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'edbc626f-719a-4914-ac65-93656de5d8f1', '2019-07-27 17:10:47', '1');
INSERT INTO `bg_visit_log` VALUES (20, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '4e2d29ff-a6f1-45f9-ae69-8848b75f1bca', '2019-07-27 17:10:58', '1');
INSERT INTO `bg_visit_log` VALUES (21, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '9270dfd8-79da-466b-83d2-362737d59386', '2019-07-27 17:18:40', '1');
INSERT INTO `bg_visit_log` VALUES (22, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', '679c6b63-10f2-4282-b056-512cf1abb6c1', '2019-07-27 17:24:35', '1');
INSERT INTO `bg_visit_log` VALUES (23, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 17:33:01', '1');
INSERT INTO `bg_visit_log` VALUES (24, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', '679c6b63-10f2-4282-b056-512cf1abb6c1', '2019-07-27 17:37:29', '1');
INSERT INTO `bg_visit_log` VALUES (25, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 17:38:59', '1');
INSERT INTO `bg_visit_log` VALUES (26, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 17:43:26', '1');
INSERT INTO `bg_visit_log` VALUES (27, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '679c6b63-10f2-4282-b056-512cf1abb6c1', '2019-07-27 17:43:48', '1');
INSERT INTO `bg_visit_log` VALUES (28, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 17:48:40', '1');
INSERT INTO `bg_visit_log` VALUES (29, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '679c6b63-10f2-4282-b056-512cf1abb6c1', '2019-07-27 17:59:08', '1');
INSERT INTO `bg_visit_log` VALUES (30, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 18:06:31', '1');
INSERT INTO `bg_visit_log` VALUES (31, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', '679c6b63-10f2-4282-b056-512cf1abb6c1', '2019-07-27 18:06:38', '1');
INSERT INTO `bg_visit_log` VALUES (32, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 18:15:39', '1');
INSERT INTO `bg_visit_log` VALUES (33, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', '3db83ba3-3613-49e5-bf5f-f9b3745819b4', '2019-07-27 18:16:15', '1');
INSERT INTO `bg_visit_log` VALUES (34, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 18:30:42', '1');
INSERT INTO `bg_visit_log` VALUES (35, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 18:32:22', '1');
INSERT INTO `bg_visit_log` VALUES (36, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 18:33:12', '1');
INSERT INTO `bg_visit_log` VALUES (37, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 18:33:18', '1');
INSERT INTO `bg_visit_log` VALUES (38, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 18:33:38', '1');
INSERT INTO `bg_visit_log` VALUES (39, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 18:33:59', '1');
INSERT INTO `bg_visit_log` VALUES (40, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/1.html', NULL, '博客', '679c6b63-10f2-4282-b056-512cf1abb6c1', '2019-07-27 18:34:05', '1');
INSERT INTO `bg_visit_log` VALUES (41, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 18:34:10', '1');
INSERT INTO `bg_visit_log` VALUES (42, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '96c0bbee-e50b-4ed0-8685-6c827f5e9644', '2019-07-27 18:36:40', '1');
INSERT INTO `bg_visit_log` VALUES (43, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/3.html', NULL, '博客', '6d20819f-fe20-43b9-b119-de3c7f0531d7', '2019-07-27 18:36:44', '1');
INSERT INTO `bg_visit_log` VALUES (44, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/3.html', NULL, '博客', '3ec681c7-5acc-4c24-8bd1-73bd80cdf606', '2019-07-27 19:05:20', '1');
INSERT INTO `bg_visit_log` VALUES (45, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/3.html', NULL, '博客', '3ec681c7-5acc-4c24-8bd1-73bd80cdf606', '2019-07-27 19:16:27', '1');
INSERT INTO `bg_visit_log` VALUES (46, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/3.html', NULL, '博客', '3ec681c7-5acc-4c24-8bd1-73bd80cdf606', '2019-07-27 19:17:38', '1');
INSERT INTO `bg_visit_log` VALUES (47, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/3.html', NULL, '博客', '3ec681c7-5acc-4c24-8bd1-73bd80cdf606', '2019-07-27 19:17:39', '1');
INSERT INTO `bg_visit_log` VALUES (48, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/3.html', NULL, '博客', '3ec681c7-5acc-4c24-8bd1-73bd80cdf606', '2019-07-27 19:17:39', '1');
INSERT INTO `bg_visit_log` VALUES (49, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '3ec681c7-5acc-4c24-8bd1-73bd80cdf606', '2019-07-27 19:22:34', '1');
INSERT INTO `bg_visit_log` VALUES (50, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '3ec681c7-5acc-4c24-8bd1-73bd80cdf606', '2019-07-27 19:22:35', '1');
INSERT INTO `bg_visit_log` VALUES (51, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '3ec681c7-5acc-4c24-8bd1-73bd80cdf606', '2019-07-27 19:22:35', '1');
INSERT INTO `bg_visit_log` VALUES (52, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '3ec681c7-5acc-4c24-8bd1-73bd80cdf606', '2019-07-27 19:22:36', '1');
INSERT INTO `bg_visit_log` VALUES (53, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/4.html', NULL, '博客', '3ec681c7-5acc-4c24-8bd1-73bd80cdf606', '2019-07-27 19:22:39', '1');
INSERT INTO `bg_visit_log` VALUES (54, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/4.html', NULL, '博客', '3ec681c7-5acc-4c24-8bd1-73bd80cdf606', '2019-07-27 19:28:08', '1');
INSERT INTO `bg_visit_log` VALUES (55, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '3ec681c7-5acc-4c24-8bd1-73bd80cdf606', '2019-07-27 19:28:45', '1');
INSERT INTO `bg_visit_log` VALUES (56, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '3ec681c7-5acc-4c24-8bd1-73bd80cdf606', '2019-07-27 19:28:55', '1');
INSERT INTO `bg_visit_log` VALUES (57, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '583bb25e-c0af-4e3a-a97a-bcce47550f20', '2019-07-27 22:19:01', '1');
INSERT INTO `bg_visit_log` VALUES (58, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ce3fea0f-e46d-4f96-98ef-03672e9ffa0c', '2019-07-27 22:30:40', '1');
INSERT INTO `bg_visit_log` VALUES (59, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ce3fea0f-e46d-4f96-98ef-03672e9ffa0c', '2019-07-27 22:33:31', '1');
INSERT INTO `bg_visit_log` VALUES (60, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ce3fea0f-e46d-4f96-98ef-03672e9ffa0c', '2019-07-27 22:44:07', '1');
INSERT INTO `bg_visit_log` VALUES (61, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ce3fea0f-e46d-4f96-98ef-03672e9ffa0c', '2019-07-27 22:44:47', '1');
INSERT INTO `bg_visit_log` VALUES (62, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ce3fea0f-e46d-4f96-98ef-03672e9ffa0c', '2019-07-27 22:56:24', '1');
INSERT INTO `bg_visit_log` VALUES (63, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '9cd02461-b41f-4077-9f6a-4db40be3db2e', '2019-07-27 23:00:08', '1');
INSERT INTO `bg_visit_log` VALUES (64, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'a6ad8d12-1e1f-49f2-bbd6-23e459cbc0f2', '2019-07-27 23:00:25', '1');
INSERT INTO `bg_visit_log` VALUES (65, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '9cd02461-b41f-4077-9f6a-4db40be3db2e', '2019-07-27 23:07:59', '1');
INSERT INTO `bg_visit_log` VALUES (66, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '3e06ec3f-3951-45bc-8a64-f5adb8c6b293', '2019-07-27 23:15:54', '1');
INSERT INTO `bg_visit_log` VALUES (67, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ffbd832f-ffc4-42c9-a17f-5992b251eb0e', '2019-07-27 23:38:49', '1');
INSERT INTO `bg_visit_log` VALUES (68, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '3e06ec3f-3951-45bc-8a64-f5adb8c6b293', '2019-07-27 23:41:39', '1');
INSERT INTO `bg_visit_log` VALUES (69, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '3e06ec3f-3951-45bc-8a64-f5adb8c6b293', '2019-07-27 23:41:53', '1');
INSERT INTO `bg_visit_log` VALUES (70, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '3e06ec3f-3951-45bc-8a64-f5adb8c6b293', '2019-07-27 23:47:24', '1');
INSERT INTO `bg_visit_log` VALUES (71, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '3e06ec3f-3951-45bc-8a64-f5adb8c6b293', '2019-07-27 23:47:25', '1');
INSERT INTO `bg_visit_log` VALUES (72, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '3e06ec3f-3951-45bc-8a64-f5adb8c6b293', '2019-07-27 23:47:38', '1');
INSERT INTO `bg_visit_log` VALUES (73, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '3e06ec3f-3951-45bc-8a64-f5adb8c6b293', '2019-07-27 23:50:58', '1');
INSERT INTO `bg_visit_log` VALUES (74, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ffbd832f-ffc4-42c9-a17f-5992b251eb0e', '2019-07-27 23:51:16', '1');
INSERT INTO `bg_visit_log` VALUES (75, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ffbd832f-ffc4-42c9-a17f-5992b251eb0e', '2019-07-27 23:52:45', '1');
INSERT INTO `bg_visit_log` VALUES (76, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ffbd832f-ffc4-42c9-a17f-5992b251eb0e', '2019-07-27 23:53:46', '1');
INSERT INTO `bg_visit_log` VALUES (77, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '3e06ec3f-3951-45bc-8a64-f5adb8c6b293', '2019-07-27 23:54:21', '1');
INSERT INTO `bg_visit_log` VALUES (78, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ffbd832f-ffc4-42c9-a17f-5992b251eb0e', '2019-07-27 23:55:07', '1');
INSERT INTO `bg_visit_log` VALUES (79, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '3e06ec3f-3951-45bc-8a64-f5adb8c6b293', '2019-07-27 23:58:02', '1');
INSERT INTO `bg_visit_log` VALUES (80, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '3e06ec3f-3951-45bc-8a64-f5adb8c6b293', '2019-07-27 23:58:42', '1');
INSERT INTO `bg_visit_log` VALUES (81, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ffbd832f-ffc4-42c9-a17f-5992b251eb0e', '2019-07-28 00:01:22', '1');
INSERT INTO `bg_visit_log` VALUES (82, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ffbd832f-ffc4-42c9-a17f-5992b251eb0e', '2019-07-28 00:01:33', '1');
INSERT INTO `bg_visit_log` VALUES (83, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ffbd832f-ffc4-42c9-a17f-5992b251eb0e', '2019-07-28 00:05:17', '1');
INSERT INTO `bg_visit_log` VALUES (84, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ffbd832f-ffc4-42c9-a17f-5992b251eb0e', '2019-07-28 00:07:06', '1');
INSERT INTO `bg_visit_log` VALUES (85, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'ffbd832f-ffc4-42c9-a17f-5992b251eb0e', '2019-07-28 00:10:16', '1');
INSERT INTO `bg_visit_log` VALUES (86, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', 'ffbd832f-ffc4-42c9-a17f-5992b251eb0e', '2019-07-28 00:10:50', '1');
INSERT INTO `bg_visit_log` VALUES (87, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/49.html', NULL, '博客', '81483031-f8b3-49cf-8585-1190a55074c9', '2019-07-28 00:16:08', '1');
INSERT INTO `bg_visit_log` VALUES (88, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/9.html', NULL, '博客', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 15:22:23', '1');
INSERT INTO `bg_visit_log` VALUES (89, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 15:36:56', '1');
INSERT INTO `bg_visit_log` VALUES (90, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 15:38:05', '1');
INSERT INTO `bg_visit_log` VALUES (91, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 15:38:09', '1');
INSERT INTO `bg_visit_log` VALUES (92, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 15:38:10', '1');
INSERT INTO `bg_visit_log` VALUES (93, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 15:38:13', '1');
INSERT INTO `bg_visit_log` VALUES (94, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 15:38:15', '1');
INSERT INTO `bg_visit_log` VALUES (95, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 15:38:19', '1');
INSERT INTO `bg_visit_log` VALUES (96, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 15:39:34', '1');
INSERT INTO `bg_visit_log` VALUES (97, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 15:39:36', '1');
INSERT INTO `bg_visit_log` VALUES (98, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 16:05:03', '1');
INSERT INTO `bg_visit_log` VALUES (99, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/44.html', NULL, '博客', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 16:05:28', '1');
INSERT INTO `bg_visit_log` VALUES (100, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/50.html', NULL, '博客', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 16:05:33', '1');
INSERT INTO `bg_visit_log` VALUES (101, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 16:12:25', '1');
INSERT INTO `bg_visit_log` VALUES (102, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 16:13:17', '1');
INSERT INTO `bg_visit_log` VALUES (103, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/category/48.html', NULL, '分类', 'ab8eea18-f16e-4ec9-8bff-65d2fa291c7f', '2019-07-28 16:13:21', '1');
INSERT INTO `bg_visit_log` VALUES (104, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/category/48.html', NULL, '分类', '46bbc258-b2d3-4594-8fe6-405751c97d4e', '2019-07-28 16:22:52', '1');
INSERT INTO `bg_visit_log` VALUES (105, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', '46bbc258-b2d3-4594-8fe6-405751c97d4e', '2019-07-28 16:24:45', '1');
INSERT INTO `bg_visit_log` VALUES (106, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/category/54.html', NULL, '分类', '46bbc258-b2d3-4594-8fe6-405751c97d4e', '2019-07-28 16:24:55', '1');
INSERT INTO `bg_visit_log` VALUES (107, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', '27adbad6-3a2d-4efb-a6a6-b14fce30a1fe', '2019-07-28 16:41:39', '1');
INSERT INTO `bg_visit_log` VALUES (108, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', '27adbad6-3a2d-4efb-a6a6-b14fce30a1fe', '2019-07-28 16:42:17', '1');
INSERT INTO `bg_visit_log` VALUES (109, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog/blog', NULL, '个人博客', '27adbad6-3a2d-4efb-a6a6-b14fce30a1fe', '2019-07-28 16:42:18', '1');
INSERT INTO `bg_visit_log` VALUES (110, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', '27adbad6-3a2d-4efb-a6a6-b14fce30a1fe', '2019-07-28 18:56:03', '1');
INSERT INTO `bg_visit_log` VALUES (111, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog/blog', NULL, '个人博客', '27adbad6-3a2d-4efb-a6a6-b14fce30a1fe', '2019-07-28 18:56:06', '1');
INSERT INTO `bg_visit_log` VALUES (112, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', '27adbad6-3a2d-4efb-a6a6-b14fce30a1fe', '2019-07-28 19:05:16', '1');
INSERT INTO `bg_visit_log` VALUES (113, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', '27adbad6-3a2d-4efb-a6a6-b14fce30a1fe', '2019-07-28 19:05:28', '1');
INSERT INTO `bg_visit_log` VALUES (114, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog/blog', NULL, '个人博客', '27adbad6-3a2d-4efb-a6a6-b14fce30a1fe', '2019-07-28 19:05:30', '1');
INSERT INTO `bg_visit_log` VALUES (115, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog/blog', NULL, '个人博客', '8267dd5c-8ef9-4a19-8ef9-d3b8fad66e87', '2019-07-28 19:10:11', '1');
INSERT INTO `bg_visit_log` VALUES (116, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', '8267dd5c-8ef9-4a19-8ef9-d3b8fad66e87', '2019-07-28 19:19:22', '1');
INSERT INTO `bg_visit_log` VALUES (117, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog/sourcecode', NULL, '源码库', 'e8275138-165a-43a9-84ed-9ec1bb42f1ec', '2019-07-28 20:02:09', '1');
INSERT INTO `bg_visit_log` VALUES (118, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog/repository', NULL, '知识库', 'e8275138-165a-43a9-84ed-9ec1bb42f1ec', '2019-07-28 20:02:16', '1');
INSERT INTO `bg_visit_log` VALUES (119, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', 'e8275138-165a-43a9-84ed-9ec1bb42f1ec', '2019-07-28 20:02:40', '1');
INSERT INTO `bg_visit_log` VALUES (120, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'e8275138-165a-43a9-84ed-9ec1bb42f1ec', '2019-07-28 20:19:31', '1');
INSERT INTO `bg_visit_log` VALUES (121, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'e8275138-165a-43a9-84ed-9ec1bb42f1ec', '2019-07-28 20:19:53', '1');
INSERT INTO `bg_visit_log` VALUES (122, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'e8275138-165a-43a9-84ed-9ec1bb42f1ec', '2019-07-28 20:20:49', '1');
INSERT INTO `bg_visit_log` VALUES (123, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '5554ffe7-9ab1-4ad7-9dd6-8befc30a094d', '2019-07-28 20:26:12', '1');
INSERT INTO `bg_visit_log` VALUES (124, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '7ed4b372-bfeb-4e2b-9bc3-603b90d8b505', '2019-07-28 22:32:20', '1');
INSERT INTO `bg_visit_log` VALUES (125, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', '1677487b-46e7-437d-9930-f0d43bf51674', '2019-07-29 13:36:12', '1');
INSERT INTO `bg_visit_log` VALUES (126, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '995f005c-9f95-4bb2-8752-81197c510221', '2019-07-29 13:44:48', '1');
INSERT INTO `bg_visit_log` VALUES (127, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/category/54.html', NULL, '随笔分类', '23cbefab-ba27-40bc-afed-2136cdbffd15', '2019-07-29 13:56:56', '1');
INSERT INTO `bg_visit_log` VALUES (128, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/category/48.html', NULL, '随笔分类', '23cbefab-ba27-40bc-afed-2136cdbffd15', '2019-07-29 13:57:38', '1');
INSERT INTO `bg_visit_log` VALUES (129, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/category/48.html', NULL, '随笔分类', '23cbefab-ba27-40bc-afed-2136cdbffd15', '2019-07-29 14:04:02', '1');
INSERT INTO `bg_visit_log` VALUES (130, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/category/48.html', NULL, '随笔分类', '23cbefab-ba27-40bc-afed-2136cdbffd15', '2019-07-29 14:05:27', '1');
INSERT INTO `bg_visit_log` VALUES (131, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/category/48.html', NULL, '随笔分类', '23cbefab-ba27-40bc-afed-2136cdbffd15', '2019-07-29 14:05:30', '1');
INSERT INTO `bg_visit_log` VALUES (132, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/category/48.html', NULL, '随笔分类', '23cbefab-ba27-40bc-afed-2136cdbffd15', '2019-07-29 14:05:31', '1');
INSERT INTO `bg_visit_log` VALUES (133, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/category/48.html', NULL, '随笔分类', '23cbefab-ba27-40bc-afed-2136cdbffd15', '2019-07-29 14:06:11', '1');
INSERT INTO `bg_visit_log` VALUES (134, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/category/48.html', NULL, '随笔分类', '23cbefab-ba27-40bc-afed-2136cdbffd15', '2019-07-29 14:07:33', '1');
INSERT INTO `bg_visit_log` VALUES (135, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', '23cbefab-ba27-40bc-afed-2136cdbffd15', '2019-07-29 14:07:37', '1');
INSERT INTO `bg_visit_log` VALUES (136, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog/blog', NULL, '个人博客', '23cbefab-ba27-40bc-afed-2136cdbffd15', '2019-07-29 14:07:53', '1');
INSERT INTO `bg_visit_log` VALUES (137, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog/blog', NULL, '个人博客', '23cbefab-ba27-40bc-afed-2136cdbffd15', '2019-07-29 14:15:17', '1');
INSERT INTO `bg_visit_log` VALUES (138, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog/blog', NULL, '个人博客', '23cbefab-ba27-40bc-afed-2136cdbffd15', '2019-07-29 14:15:39', '1');
INSERT INTO `bg_visit_log` VALUES (139, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '5d822ff2-c1a0-4dce-8720-f431df5d3ee3', '2019-07-29 14:18:11', '1');
INSERT INTO `bg_visit_log` VALUES (140, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', 'f958d607-7ef5-4e42-91f8-f9701c516348', '2019-07-29 14:26:32', '1');
INSERT INTO `bg_visit_log` VALUES (141, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', '5d822ff2-c1a0-4dce-8720-f431df5d3ee3', '2019-07-29 14:27:22', '1');
INSERT INTO `bg_visit_log` VALUES (142, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/tag/18.html', NULL, '标签', 'f958d607-7ef5-4e42-91f8-f9701c516348', '2019-07-29 14:27:31', '1');
INSERT INTO `bg_visit_log` VALUES (143, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/category/49.html', NULL, '随笔分类', 'f958d607-7ef5-4e42-91f8-f9701c516348', '2019-07-29 14:27:49', '1');
INSERT INTO `bg_visit_log` VALUES (144, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', '5d822ff2-c1a0-4dce-8720-f431df5d3ee3', '2019-07-29 14:27:57', '1');
INSERT INTO `bg_visit_log` VALUES (145, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '3e84aede-9e22-4bae-8d77-2984640596e7', '2019-07-29 14:45:41', '1');
INSERT INTO `bg_visit_log` VALUES (146, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/41.html', NULL, '博客', '3e84aede-9e22-4bae-8d77-2984640596e7', '2019-07-29 14:52:30', '1');
INSERT INTO `bg_visit_log` VALUES (147, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog', NULL, '首页', '51b6b8b5-f952-4ce9-bc6e-2c6404445463', '2019-07-29 14:55:41', '1');
INSERT INTO `bg_visit_log` VALUES (148, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'a123e9f2-0ccc-4292-9eb5-e602da170cd0', '2019-07-29 21:20:46', '1');
INSERT INTO `bg_visit_log` VALUES (149, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '259ad04a-05b8-4370-a900-a9f6c7e4a2d3', '2019-07-29 21:40:48', '1');
INSERT INTO `bg_visit_log` VALUES (150, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/1.html', NULL, '博客', '259ad04a-05b8-4370-a900-a9f6c7e4a2d3', '2019-07-29 21:49:56', '1');
INSERT INTO `bg_visit_log` VALUES (151, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '259ad04a-05b8-4370-a900-a9f6c7e4a2d3', '2019-07-29 21:58:56', '1');
INSERT INTO `bg_visit_log` VALUES (152, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '259ad04a-05b8-4370-a900-a9f6c7e4a2d3', '2019-07-29 21:59:06', '1');
INSERT INTO `bg_visit_log` VALUES (153, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '259ad04a-05b8-4370-a900-a9f6c7e4a2d3', '2019-07-29 21:59:06', '1');
INSERT INTO `bg_visit_log` VALUES (154, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '259ad04a-05b8-4370-a900-a9f6c7e4a2d3', '2019-07-29 22:01:48', '1');
INSERT INTO `bg_visit_log` VALUES (155, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '259ad04a-05b8-4370-a900-a9f6c7e4a2d3', '2019-07-29 22:01:49', '1');
INSERT INTO `bg_visit_log` VALUES (156, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/1.html', NULL, '博客', '259ad04a-05b8-4370-a900-a9f6c7e4a2d3', '2019-07-29 22:07:39', '1');
INSERT INTO `bg_visit_log` VALUES (157, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '259ad04a-05b8-4370-a900-a9f6c7e4a2d3', '2019-07-29 22:11:56', '1');
INSERT INTO `bg_visit_log` VALUES (158, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/3.html', NULL, '博客', '259ad04a-05b8-4370-a900-a9f6c7e4a2d3', '2019-07-29 22:20:18', '1');
INSERT INTO `bg_visit_log` VALUES (159, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '259ad04a-05b8-4370-a900-a9f6c7e4a2d3', '2019-07-29 22:25:18', '1');
INSERT INTO `bg_visit_log` VALUES (160, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', '259ad04a-05b8-4370-a900-a9f6c7e4a2d3', '2019-07-29 22:25:21', '1');
INSERT INTO `bg_visit_log` VALUES (161, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'f107ddbd-17a2-4564-b156-c582e7fa431d', '2019-07-29 22:31:17', '1');
INSERT INTO `bg_visit_log` VALUES (162, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'f107ddbd-17a2-4564-b156-c582e7fa431d', '2019-07-29 22:37:15', '1');
INSERT INTO `bg_visit_log` VALUES (163, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'f107ddbd-17a2-4564-b156-c582e7fa431d', '2019-07-29 22:37:15', '1');
INSERT INTO `bg_visit_log` VALUES (164, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/', NULL, '首页', 'f107ddbd-17a2-4564-b156-c582e7fa431d', '2019-07-29 22:40:19', '1');
INSERT INTO `bg_visit_log` VALUES (165, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog/about', NULL, '关于我', 'f107ddbd-17a2-4564-b156-c582e7fa431d', '2019-07-29 22:45:27', '1');
INSERT INTO `bg_visit_log` VALUES (166, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog/repository', NULL, '知识库', 'f107ddbd-17a2-4564-b156-c582e7fa431d', '2019-07-29 22:45:31', '1');
INSERT INTO `bg_visit_log` VALUES (167, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/category/54.html', NULL, '随笔分类', 'f107ddbd-17a2-4564-b156-c582e7fa431d', '2019-07-29 22:45:56', '1');
INSERT INTO `bg_visit_log` VALUES (168, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/24.html', NULL, '博客', 'f107ddbd-17a2-4564-b156-c582e7fa431d', '2019-07-29 22:46:03', '1');
INSERT INTO `bg_visit_log` VALUES (169, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/my_blog/blog', NULL, '个人博客', 'f107ddbd-17a2-4564-b156-c582e7fa431d', '2019-07-29 22:47:13', '1');
INSERT INTO `bg_visit_log` VALUES (170, '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', NULL, '/f/article/5.html', NULL, '博客', 'f107ddbd-17a2-4564-b156-c582e7fa431d', '2019-07-29 22:47:19', '1');

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `blob_data` blob NULL,
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `calendar_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`sched_name`, `calendar_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cron_expression` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time_zone_id` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('DimpleScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', '0/10 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('DimpleScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', '0/20 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('DragonWenScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', '0/10 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('DragonWenScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', '0/20 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', '0/10 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', '0/20 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `entry_id` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `instance_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fired_time` bigint(13) NOT NULL,
  `sched_time` bigint(13) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `job_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_nonconcurrent` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `requests_recovery` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sched_name`, `entry_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `job_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `job_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job_class_name` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_durable` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_nonconcurrent` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_update_data` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `requests_recovery` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `job_data` blob NULL,
  PRIMARY KEY (`sched_name`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('DimpleScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', NULL, 'com.dragon.project.monitor.job.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F5045525449455373720029636F6D2E647261676F6E2E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200094C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C000C6D6574686F64506172616D7371007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E00097872002A636F6D2E647261676F6E2E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E078707400007070707400013174000E302F3130202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E697A0E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672795461736B74000A72794E6F506172616D7374000074000130740001317800);
INSERT INTO `qrtz_job_details` VALUES ('DimpleScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', NULL, 'com.dragon.project.monitor.job.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F5045525449455373720029636F6D2E647261676F6E2E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200094C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C000C6D6574686F64506172616D7371007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E00097872002A636F6D2E647261676F6E2E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E078707400007070707400013174000E302F3230202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E69C89E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000672795461736B7400087279506172616D7374000561646D696E74000133740001317800);
INSERT INTO `qrtz_job_details` VALUES ('DragonWenScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', NULL, 'com.dragon.project.monitor.job.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F5045525449455373720029636F6D2E647261676F6E2E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200094C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C000C6D6574686F64506172616D7371007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E00097872002A636F6D2E647261676F6E2E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E078707400007070707400013174000E302F3130202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E697A0E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672795461736B74000A72794E6F506172616D7374000074000130740001317800);
INSERT INTO `qrtz_job_details` VALUES ('DragonWenScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', NULL, 'com.dragon.project.monitor.job.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F5045525449455373720029636F6D2E647261676F6E2E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200094C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C000C6D6574686F64506172616D7371007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E00097872002A636F6D2E647261676F6E2E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E078707400007070707400013174000E302F3230202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E69C89E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000672795461736B7400087279506172616D7374000561646D696E74000133740001317800);
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', NULL, 'com.dimple.project.monitor.job.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F5045525449455373720029636F6D2E64696D706C652E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200094C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C000C6D6574686F64506172616D7371007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E00097872002A636F6D2E64696D706C652E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E078707400007070707400013174000E302F3130202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E697A0E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672795461736B74000A72794E6F506172616D7374000074000130740001317800);
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', NULL, 'com.dimple.project.monitor.job.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F5045525449455373720029636F6D2E64696D706C652E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200094C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C000C6D6574686F64506172616D7371007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E00097872002A636F6D2E64696D706C652E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E078707400007070707400013174000E302F3230202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E69C89E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000672795461736B7400087279506172616D73740002727974000133740001317800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lock_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`sched_name`, `lock_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('DimpleScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('DimpleScheduler', 'TRIGGER_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('DragonWenScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('DragonWenScheduler', 'TRIGGER_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RuoyiScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RuoyiScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`sched_name`, `trigger_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `instance_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_checkin_time` bigint(13) NOT NULL,
  `checkin_interval` bigint(13) NOT NULL,
  PRIMARY KEY (`sched_name`, `instance_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('DimpleScheduler', 'LAPTOP-GHVKEMRU1562567957101', 1562568051632, 15000);
INSERT INTO `qrtz_scheduler_state` VALUES ('DragonWenScheduler', 'LAPTOP-GHVKEMRU1564410491064', 1564413736152, 15000);
INSERT INTO `qrtz_scheduler_state` VALUES ('RuoyiScheduler', 'localhost1554707745537', 1554779698368, 15000);

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `repeat_count` bigint(7) NOT NULL,
  `repeat_interval` bigint(12) NOT NULL,
  `times_triggered` bigint(10) NOT NULL,
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `str_prop_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `str_prop_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `str_prop_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `int_prop_1` int(11) NULL DEFAULT NULL,
  `int_prop_2` int(11) NULL DEFAULT NULL,
  `long_prop_1` bigint(20) NULL DEFAULT NULL,
  `long_prop_2` bigint(20) NULL DEFAULT NULL,
  `dec_prop_1` decimal(13, 4) NULL DEFAULT NULL,
  `dec_prop_2` decimal(13, 4) NULL DEFAULT NULL,
  `bool_prop_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bool_prop_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `job_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `job_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `next_fire_time` bigint(13) NULL DEFAULT NULL,
  `prev_fire_time` bigint(13) NULL DEFAULT NULL,
  `priority` int(11) NULL DEFAULT NULL,
  `trigger_state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trigger_type` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `start_time` bigint(13) NOT NULL,
  `end_time` bigint(13) NULL DEFAULT NULL,
  `calendar_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `misfire_instr` smallint(2) NULL DEFAULT NULL,
  `job_data` blob NULL,
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  INDEX `sched_name`(`sched_name`, `job_name`, `job_group`) USING BTREE,
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('DimpleScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', 'TASK_CLASS_NAME1', 'DEFAULT', NULL, 1562567960000, -1, 5, 'PAUSED', 'CRON', 1562567957000, 0, NULL, 0, '');
INSERT INTO `qrtz_triggers` VALUES ('DimpleScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', 'TASK_CLASS_NAME2', 'DEFAULT', NULL, 1562567960000, -1, 5, 'PAUSED', 'CRON', 1562567957000, 0, NULL, 2, '');
INSERT INTO `qrtz_triggers` VALUES ('DragonWenScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', 'TASK_CLASS_NAME1', 'DEFAULT', NULL, 1564410500000, -1, 5, 'PAUSED', 'CRON', 1564410491000, 0, NULL, 0, '');
INSERT INTO `qrtz_triggers` VALUES ('DragonWenScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', 'TASK_CLASS_NAME2', 'DEFAULT', NULL, 1564410500000, -1, 5, 'PAUSED', 'CRON', 1564410491000, 0, NULL, 2, '');
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', 'TASK_CLASS_NAME1', 'DEFAULT', NULL, 1554716610000, -1, 5, 'PAUSED', 'CRON', 1554716609000, 0, NULL, 0, '');
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', 'TASK_CLASS_NAME2', 'DEFAULT', NULL, 1554716620000, -1, 5, 'PAUSED', 'CRON', 1554716611000, 0, NULL, 2, '');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参数配置表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-16 19:25:41', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '初始化密码 123456');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 115 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典数据表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '性别男');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '性别女');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES (10, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '系统默认是');
INSERT INTO `sys_dict_data` VALUES (11, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '系统默认否');
INSERT INTO `sys_dict_data` VALUES (12, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '通知');
INSERT INTO `sys_dict_data` VALUES (13, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '公告');
INSERT INTO `sys_dict_data` VALUES (14, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES (15, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '关闭状态');
INSERT INTO `sys_dict_data` VALUES (16, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `sys_dict_data` VALUES (17, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '修改操作');
INSERT INTO `sys_dict_data` VALUES (18, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '删除操作');
INSERT INTO `sys_dict_data` VALUES (19, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '授权操作');
INSERT INTO `sys_dict_data` VALUES (20, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '导出操作');
INSERT INTO `sys_dict_data` VALUES (21, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '导入操作');
INSERT INTO `sys_dict_data` VALUES (22, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '强退操作');
INSERT INTO `sys_dict_data` VALUES (23, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '生成操作');
INSERT INTO `sys_dict_data` VALUES (24, 8, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '清空操作');
INSERT INTO `sys_dict_data` VALUES (25, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES (26, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES (100, 1, '已发布', '1', 'blog_blog_status', '', 'primary', 'N', '0', 'admin', '2019-03-16 08:34:13', 'admin', '2019-03-23 12:04:37', '博客正常状态');
INSERT INTO `sys_dict_data` VALUES (101, 2, '草稿箱', '2', 'blog_blog_status', '', 'warning', 'Y', '0', 'admin', '2019-03-16 16:40:13', 'admin', '2019-03-16 16:40:49', '博客草稿箱状态');
INSERT INTO `sys_dict_data` VALUES (102, 3, '垃圾箱', '3', 'blog_blog_status', '', 'danger', 'Y', '0', 'admin', '2019-03-16 16:40:34', 'admin', '2019-03-16 16:40:58', '博客垃圾箱状态');
INSERT INTO `sys_dict_data` VALUES (103, 1, '是', '1', 'blog_blog_support', '', 'success', 'Y', '0', 'admin', '2019-03-24 13:29:44', 'admin', '2019-03-24 13:30:26', '');
INSERT INTO `sys_dict_data` VALUES (104, 2, '否', '0', 'blog_blog_support', NULL, 'default', 'Y', '0', 'admin', '2019-03-24 13:30:40', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (105, 1, '是', '1', 'blog_category_support', NULL, 'primary', 'Y', '0', 'admin', '2019-03-25 17:29:52', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (106, 2, '否', '0', 'blog_category_support', NULL, 'default', 'Y', '0', 'admin', '2019-03-25 17:30:05', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (107, 1, '死链', '0', 'link_link_available', '', 'danger', 'Y', '0', 'admin', '2019-03-26 09:47:44', 'admin', '2019-03-26 10:14:42', '死链');
INSERT INTO `sys_dict_data` VALUES (108, 2, '正常', '1', 'link_link_available', '', 'success', 'Y', '0', 'admin', '2019-03-26 09:48:01', 'admin', '2019-03-26 10:14:37', '');
INSERT INTO `sys_dict_data` VALUES (109, 1, '显示', '1', 'link_link_display', '', 'primary', 'Y', '0', 'admin', '2019-03-26 09:50:23', 'admin', '2019-03-26 10:26:19', '');
INSERT INTO `sys_dict_data` VALUES (110, 2, '隐藏', '0', 'link_link_display', NULL, 'default', 'Y', '0', 'admin', '2019-03-26 09:50:38', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (111, 1, '显示', '1', 'system_carouselMap_display', NULL, 'primary', 'Y', '0', 'admin', '2019-04-08 16:48:55', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (112, 1, '隐藏', '0', 'system_carouselMap_display', NULL, 'default', 'Y', '0', 'admin', '2019-04-08 16:49:10', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (113, 1, '是', '1', 'system_carouselMap_target', NULL, 'primary', 'Y', '0', 'admin', '2019-04-08 16:55:34', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (114, 2, '否', '0', 'system_carouselMap_target', NULL, 'default', 'Y', '0', 'admin', '2019-04-08 16:55:55', '', NULL, NULL);

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典类型表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '系统是否', 'sys_yes_no', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (6, '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知状态', 'sys_notice_status', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (8, '操作类型', 'sys_oper_type', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (9, '系统状态', 'sys_common_status', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '登录状态列表');
INSERT INTO `sys_dict_type` VALUES (10, '博客状态', 'blog_blog_status', '0', 'admin', '2019-03-16 08:37:55', 'admin', '2019-03-16 08:38:02', '博客状态列表');
INSERT INTO `sys_dict_type` VALUES (101, '博客推荐', 'blog_blog_support', '0', 'admin', '2019-03-24 13:28:43', 'admin', '2019-03-24 13:29:00', '博客推荐列表');
INSERT INTO `sys_dict_type` VALUES (102, '分类推荐', 'blog_category_support', '0', 'admin', '2019-03-25 17:29:27', 'admin', '2019-03-25 17:29:36', '分类推荐列表');
INSERT INTO `sys_dict_type` VALUES (103, '友链死链状态', 'link_link_available', '0', 'admin', '2019-03-26 09:46:29', '', NULL, '友链死链状态');
INSERT INTO `sys_dict_type` VALUES (104, '友链显示状态', 'link_link_display', '0', 'admin', '2019-03-26 09:49:53', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (105, '轮播图状态', 'system_carouselMap_display', '0', 'admin', '2019-04-08 16:48:37', '', NULL, '轮播图是否显示');
INSERT INTO `sys_dict_type` VALUES (106, '轮播图打开状态', 'system_carouselMap_target', '0', 'admin', '2019-04-08 16:55:11', '', NULL, '轮播图是否当前窗口打开');

-- ----------------------------
-- Table structure for sys_file_list
-- ----------------------------
DROP TABLE IF EXISTS `sys_file_list`;
CREATE TABLE `sys_file_list`  (
  `file_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件路径',
  `file_shuffix` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件后缀',
  `content_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path_id` int(20) NULL DEFAULT NULL COMMENT '路径ID',
  `file_size` int(20) NULL DEFAULT NULL COMMENT '文件大小',
  `upload_time` datetime NULL DEFAULT NULL COMMENT '上传时间',
  `file_user_id` int(20) NULL DEFAULT NULL COMMENT '文件上传用户',
  `file_istrash` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '文件是否在垃圾箱',
  `file_isshare` int(20) NULL DEFAULT NULL COMMENT '文件是否共享',
  PRIMARY KEY (`file_id`) USING BTREE,
  INDEX `FKfshy9n300pqxjsweo9247jgqs`(`path_id`) USING BTREE,
  INDEX `FKlj6l9qroivus28aiqluue4bew`(`file_user_id`) USING BTREE,
  CONSTRAINT `FKfshy9n300pqxjsweo9247jgqs` FOREIGN KEY (`path_id`) REFERENCES `sys_file_path` (`path_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKlj6l9qroivus28aiqluue4bew` FOREIGN KEY (`file_user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_file_path
-- ----------------------------
DROP TABLE IF EXISTS `sys_file_path`;
CREATE TABLE `sys_file_path`  (
  `path_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '路径ID',
  `parent_id` int(20) NULL DEFAULT NULL COMMENT '父节点ID',
  `path_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径名称',
  `path_user_id` int(20) NULL DEFAULT NULL COMMENT '路径关联用户ID',
  `path_istrash` int(20) NULL DEFAULT 0 COMMENT '路径是否删除',
  PRIMARY KEY (`path_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_file_path
-- ----------------------------
INSERT INTO `sys_file_path` VALUES (1, 0, '根目录', NULL, 0);
INSERT INTO `sys_file_path` VALUES (2, 1, 'admin', 1, 0);
INSERT INTO `sys_file_path` VALUES (28, 2, '温文星', 1, 0);
INSERT INTO `sys_file_path` VALUES (29, 28, '博客照片', 1, 0);

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `job_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '任务组名',
  `method_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '任务方法',
  `method_params` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法参数',
  `cron_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES (1, 'ryTask', '系统默认（无参）', 'ryNoParams', '', '0/10 * * * * ?', '0', '1', '1', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-21 20:33:59', '');
INSERT INTO `sys_job` VALUES (2, 'ryTask', '系统默认（有参）', 'ryParams', 'admin', '0/20 * * * * ?', '3', '1', '1', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `job_log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务组名',
  `method_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务方法',
  `method_params` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法参数',
  `job_message` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志信息',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '异常信息',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`  (
  `info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '提示消息',
  `login_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统访问记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor` VALUES (693, 'admin', '172.16.30.13', '内网IP', 'Firefox', 'Windows 10', '1', '退出成功', '2019-01-09 17:38:00');
INSERT INTO `sys_logininfor` VALUES (694, 'admin', '172.16.30.13', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-09 17:38:05');
INSERT INTO `sys_logininfor` VALUES (695, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-09 17:50:01');
INSERT INTO `sys_logininfor` VALUES (696, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-09 17:58:28');
INSERT INTO `sys_logininfor` VALUES (697, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-09 18:00:44');
INSERT INTO `sys_logininfor` VALUES (698, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-09 18:02:07');
INSERT INTO `sys_logininfor` VALUES (699, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-09 18:58:56');
INSERT INTO `sys_logininfor` VALUES (700, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-09 19:23:13');
INSERT INTO `sys_logininfor` VALUES (701, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-09 19:55:26');
INSERT INTO `sys_logininfor` VALUES (702, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-09 21:11:45');
INSERT INTO `sys_logininfor` VALUES (703, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-10 10:50:03');
INSERT INTO `sys_logininfor` VALUES (704, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-10 10:50:53');
INSERT INTO `sys_logininfor` VALUES (723, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-10 13:36:38');
INSERT INTO `sys_logininfor` VALUES (724, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-10 13:36:52');
INSERT INTO `sys_logininfor` VALUES (725, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-10 14:04:40');
INSERT INTO `sys_logininfor` VALUES (726, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-10 14:08:35');
INSERT INTO `sys_logininfor` VALUES (727, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-10 14:08:46');
INSERT INTO `sys_logininfor` VALUES (728, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-10 14:14:46');
INSERT INTO `sys_logininfor` VALUES (729, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-10 14:23:06');
INSERT INTO `sys_logininfor` VALUES (730, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-10 14:23:27');
INSERT INTO `sys_logininfor` VALUES (731, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-10 14:24:38');
INSERT INTO `sys_logininfor` VALUES (732, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-10 14:25:31');
INSERT INTO `sys_logininfor` VALUES (733, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-10 15:17:02');
INSERT INTO `sys_logininfor` VALUES (734, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-10 15:46:38');
INSERT INTO `sys_logininfor` VALUES (735, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-10 15:52:31');
INSERT INTO `sys_logininfor` VALUES (736, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-10 16:51:05');
INSERT INTO `sys_logininfor` VALUES (737, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-10 17:03:29');
INSERT INTO `sys_logininfor` VALUES (738, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-10 19:10:15');
INSERT INTO `sys_logininfor` VALUES (739, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-10 19:13:36');
INSERT INTO `sys_logininfor` VALUES (740, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-10 19:17:44');
INSERT INTO `sys_logininfor` VALUES (741, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-10 19:31:48');
INSERT INTO `sys_logininfor` VALUES (742, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-10 19:53:49');
INSERT INTO `sys_logininfor` VALUES (743, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-11 09:28:03');
INSERT INTO `sys_logininfor` VALUES (744, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-11 09:31:49');
INSERT INTO `sys_logininfor` VALUES (745, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-11 10:39:48');
INSERT INTO `sys_logininfor` VALUES (746, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-11 10:40:00');
INSERT INTO `sys_logininfor` VALUES (747, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 10:45:47');
INSERT INTO `sys_logininfor` VALUES (748, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 10:53:28');
INSERT INTO `sys_logininfor` VALUES (749, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 10:53:43');
INSERT INTO `sys_logininfor` VALUES (750, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 10:54:07');
INSERT INTO `sys_logininfor` VALUES (751, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 11:04:23');
INSERT INTO `sys_logininfor` VALUES (752, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 11:07:42');
INSERT INTO `sys_logininfor` VALUES (754, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 11:11:26');
INSERT INTO `sys_logininfor` VALUES (755, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 11:12:01');
INSERT INTO `sys_logininfor` VALUES (756, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 11:20:45');
INSERT INTO `sys_logininfor` VALUES (757, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-11 11:21:22');
INSERT INTO `sys_logininfor` VALUES (758, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 11:24:30');
INSERT INTO `sys_logininfor` VALUES (759, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-11 11:24:32');
INSERT INTO `sys_logininfor` VALUES (760, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 11:24:38');
INSERT INTO `sys_logininfor` VALUES (761, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 11:25:06');
INSERT INTO `sys_logininfor` VALUES (762, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-11 11:59:32');
INSERT INTO `sys_logininfor` VALUES (763, 'admin', '10.17.80.89', '内网IP', 'Microsoft Edge', 'Windows 10', '1', '登录成功', '2019-01-11 12:00:13');
INSERT INTO `sys_logininfor` VALUES (764, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-11 12:00:51');
INSERT INTO `sys_logininfor` VALUES (765, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:02:22');
INSERT INTO `sys_logininfor` VALUES (766, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:04:07');
INSERT INTO `sys_logininfor` VALUES (767, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:04:28');
INSERT INTO `sys_logininfor` VALUES (768, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:04:38');
INSERT INTO `sys_logininfor` VALUES (769, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:05:20');
INSERT INTO `sys_logininfor` VALUES (770, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:08:23');
INSERT INTO `sys_logininfor` VALUES (772, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:18:02');
INSERT INTO `sys_logininfor` VALUES (773, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:46:55');
INSERT INTO `sys_logininfor` VALUES (774, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:48:22');
INSERT INTO `sys_logininfor` VALUES (775, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:49:30');
INSERT INTO `sys_logininfor` VALUES (776, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:50:49');
INSERT INTO `sys_logininfor` VALUES (777, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:52:03');
INSERT INTO `sys_logininfor` VALUES (778, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:52:53');
INSERT INTO `sys_logininfor` VALUES (779, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 12:53:03');
INSERT INTO `sys_logininfor` VALUES (780, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 13:53:49');
INSERT INTO `sys_logininfor` VALUES (781, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 16:24:18');
INSERT INTO `sys_logininfor` VALUES (782, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-11 16:24:48');
INSERT INTO `sys_logininfor` VALUES (783, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 16:24:56');
INSERT INTO `sys_logininfor` VALUES (784, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-11 16:25:02');
INSERT INTO `sys_logininfor` VALUES (785, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 16:25:20');
INSERT INTO `sys_logininfor` VALUES (786, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-11 16:26:19');
INSERT INTO `sys_logininfor` VALUES (787, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 16:26:36');
INSERT INTO `sys_logininfor` VALUES (788, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-11 16:27:21');
INSERT INTO `sys_logininfor` VALUES (789, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 16:27:33');
INSERT INTO `sys_logininfor` VALUES (790, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-11 16:27:54');
INSERT INTO `sys_logininfor` VALUES (791, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 16:28:04');
INSERT INTO `sys_logininfor` VALUES (792, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-11 16:44:43');
INSERT INTO `sys_logininfor` VALUES (793, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 16:44:55');
INSERT INTO `sys_logininfor` VALUES (794, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 16:54:51');
INSERT INTO `sys_logininfor` VALUES (796, 'admin', '10.17.80.89', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-11 16:55:51');
INSERT INTO `sys_logininfor` VALUES (797, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 16:57:05');
INSERT INTO `sys_logininfor` VALUES (798, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-11 16:57:50');
INSERT INTO `sys_logininfor` VALUES (799, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 16:57:59');
INSERT INTO `sys_logininfor` VALUES (800, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 19:40:40');
INSERT INTO `sys_logininfor` VALUES (801, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 19:46:36');
INSERT INTO `sys_logininfor` VALUES (802, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 19:47:28');
INSERT INTO `sys_logininfor` VALUES (803, 'admin', '10.17.80.89', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 19:56:02');
INSERT INTO `sys_logininfor` VALUES (804, 'admin', '192.168.0.12', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 21:50:16');
INSERT INTO `sys_logininfor` VALUES (805, 'admin', '192.168.0.12', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-11 22:12:21');
INSERT INTO `sys_logininfor` VALUES (806, 'admin', '192.168.0.12', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-11 22:46:49');
INSERT INTO `sys_logininfor` VALUES (807, 'admin', '192.168.0.12', '内网IP', 'Firefox', 'Windows 10', '1', '退出成功', '2019-01-11 22:46:53');
INSERT INTO `sys_logininfor` VALUES (808, 'admin', '192.168.0.12', '内网IP', 'Firefox', 'Windows 10', '1', '退出成功', '2019-01-11 22:48:42');
INSERT INTO `sys_logininfor` VALUES (809, 'admin', '192.168.0.12', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-11 22:48:53');
INSERT INTO `sys_logininfor` VALUES (810, 'admin', '192.168.0.12', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 22:49:03');
INSERT INTO `sys_logininfor` VALUES (811, 'admin', '192.168.0.12', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 22:49:53');
INSERT INTO `sys_logininfor` VALUES (812, 'admin', '192.168.0.12', '内网IP', 'Firefox', 'Windows 10', '1', '退出成功', '2019-01-11 22:50:18');
INSERT INTO `sys_logininfor` VALUES (813, 'admin', '192.168.0.12', '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-11 22:50:37');
INSERT INTO `sys_logininfor` VALUES (814, 'admin', '192.168.0.12', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-11 22:50:53');
INSERT INTO `sys_logininfor` VALUES (815, 'admin', '10.10.115.77', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-12 13:00:13');
INSERT INTO `sys_logininfor` VALUES (816, 'admin', '10.10.115.77', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-12 22:37:26');
INSERT INTO `sys_logininfor` VALUES (817, 'admin', '127.0.0.1', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-12 23:59:06');
INSERT INTO `sys_logininfor` VALUES (818, 'admin', '127.0.0.1', '内网IP', 'Firefox', 'Windows 10', '1', '退出成功', '2019-01-12 23:59:09');
INSERT INTO `sys_logininfor` VALUES (819, 'admin', '127.0.0.1', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-12 23:59:17');
INSERT INTO `sys_logininfor` VALUES (820, 'admin', '101.207.19.174', '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-13 11:28:52');
INSERT INTO `sys_logininfor` VALUES (821, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-13 11:39:48');
INSERT INTO `sys_logininfor` VALUES (822, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-13 11:47:30');
INSERT INTO `sys_logininfor` VALUES (823, 'admin', '101.207.19.174', '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-13 11:49:22');
INSERT INTO `sys_logininfor` VALUES (826, 'admin', '171.210.49.116', 'XX XX', 'Chrome Mobile', 'Android Mobile', '1', '登录成功', '2019-01-13 12:15:06');
INSERT INTO `sys_logininfor` VALUES (827, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-13 12:47:03');
INSERT INTO `sys_logininfor` VALUES (832, 'admin', '127.0.0.1', '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-14 10:56:33');
INSERT INTO `sys_logininfor` VALUES (833, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-14 14:10:19');
INSERT INTO `sys_logininfor` VALUES (834, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-14 14:10:41');
INSERT INTO `sys_logininfor` VALUES (835, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-14 17:17:53');
INSERT INTO `sys_logininfor` VALUES (836, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-14 18:04:46');
INSERT INTO `sys_logininfor` VALUES (837, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-14 19:25:44');
INSERT INTO `sys_logininfor` VALUES (838, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-14 19:25:50');
INSERT INTO `sys_logininfor` VALUES (839, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-14 19:26:29');
INSERT INTO `sys_logininfor` VALUES (840, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-14 19:27:07');
INSERT INTO `sys_logininfor` VALUES (841, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-14 19:29:00');
INSERT INTO `sys_logininfor` VALUES (842, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-14 19:29:17');
INSERT INTO `sys_logininfor` VALUES (843, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-14 19:29:52');
INSERT INTO `sys_logininfor` VALUES (844, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-14 19:29:59');
INSERT INTO `sys_logininfor` VALUES (845, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-14 19:30:03');
INSERT INTO `sys_logininfor` VALUES (854, 'admin', '125.69.76.87', '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-15 09:30:50');
INSERT INTO `sys_logininfor` VALUES (855, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-15 10:21:27');
INSERT INTO `sys_logininfor` VALUES (856, 'admin', '125.69.76.87', 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-15 12:20:14');
INSERT INTO `sys_logininfor` VALUES (857, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-15 15:49:03');
INSERT INTO `sys_logininfor` VALUES (858, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-15 16:30:23');
INSERT INTO `sys_logininfor` VALUES (859, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-15 16:34:59');
INSERT INTO `sys_logininfor` VALUES (860, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-15 17:08:33');
INSERT INTO `sys_logininfor` VALUES (861, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-15 17:21:22');
INSERT INTO `sys_logininfor` VALUES (862, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-15 17:21:58');
INSERT INTO `sys_logininfor` VALUES (863, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-15 17:22:06');
INSERT INTO `sys_logininfor` VALUES (864, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-15 18:12:46');
INSERT INTO `sys_logininfor` VALUES (865, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-15 18:17:29');
INSERT INTO `sys_logininfor` VALUES (866, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-16 09:44:00');
INSERT INTO `sys_logininfor` VALUES (867, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-16 10:25:12');
INSERT INTO `sys_logininfor` VALUES (868, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-16 10:27:47');
INSERT INTO `sys_logininfor` VALUES (869, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-16 10:33:35');
INSERT INTO `sys_logininfor` VALUES (870, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-16 12:19:20');
INSERT INTO `sys_logininfor` VALUES (871, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-16 14:00:03');
INSERT INTO `sys_logininfor` VALUES (872, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-16 14:18:41');
INSERT INTO `sys_logininfor` VALUES (874, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-16 16:07:05');
INSERT INTO `sys_logininfor` VALUES (876, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-16 16:37:37');
INSERT INTO `sys_logininfor` VALUES (877, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-16 19:27:58');
INSERT INTO `sys_logininfor` VALUES (878, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-16 19:45:48');
INSERT INTO `sys_logininfor` VALUES (879, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-16 19:50:10');
INSERT INTO `sys_logininfor` VALUES (880, 'admin', NULL, '中国 四川 成都', 'Chrome Mobile', 'Android Mobile', '1', '登录成功', '2019-01-16 19:52:12');
INSERT INTO `sys_logininfor` VALUES (881, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-16 20:44:49');
INSERT INTO `sys_logininfor` VALUES (882, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-16 20:45:00');
INSERT INTO `sys_logininfor` VALUES (883, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-16 20:47:59');
INSERT INTO `sys_logininfor` VALUES (884, 'admin', NULL, 'XX XX', 'Apple WebKit', 'Mac OS X (iPhone)', '1', '登录成功', '2019-01-17 08:21:30');
INSERT INTO `sys_logininfor` VALUES (885, 'admin', NULL, 'XX XX', 'Apple WebKit', 'Mac OS X (iPhone)', '1', '退出成功', '2019-01-17 08:22:08');
INSERT INTO `sys_logininfor` VALUES (886, 'admin', NULL, 'XX XX', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-17 09:28:01');
INSERT INTO `sys_logininfor` VALUES (887, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '0', '验证码异常', '2019-01-17 09:41:31');
INSERT INTO `sys_logininfor` VALUES (888, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-17 09:41:40');
INSERT INTO `sys_logininfor` VALUES (889, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-17 12:18:25');
INSERT INTO `sys_logininfor` VALUES (890, 'admin', NULL, 'XX XX', 'Firefox', 'Windows 10', '1', '退出成功', '2019-01-17 12:22:30');
INSERT INTO `sys_logininfor` VALUES (892, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-17 14:02:48');
INSERT INTO `sys_logininfor` VALUES (901, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-17 19:57:03');
INSERT INTO `sys_logininfor` VALUES (902, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-17 20:23:38');
INSERT INTO `sys_logininfor` VALUES (903, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-17 20:53:34');
INSERT INTO `sys_logininfor` VALUES (904, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-18 09:45:53');
INSERT INTO `sys_logininfor` VALUES (905, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-18 15:15:33');
INSERT INTO `sys_logininfor` VALUES (906, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-18 15:16:17');
INSERT INTO `sys_logininfor` VALUES (907, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-18 15:21:15');
INSERT INTO `sys_logininfor` VALUES (908, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-18 18:18:27');
INSERT INTO `sys_logininfor` VALUES (909, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-19 23:12:22');
INSERT INTO `sys_logininfor` VALUES (910, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-19 23:14:31');
INSERT INTO `sys_logininfor` VALUES (911, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-20 00:08:08');
INSERT INTO `sys_logininfor` VALUES (912, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-20 13:13:28');
INSERT INTO `sys_logininfor` VALUES (913, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-20 13:26:38');
INSERT INTO `sys_logininfor` VALUES (914, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-20 13:35:44');
INSERT INTO `sys_logininfor` VALUES (915, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-20 13:35:49');
INSERT INTO `sys_logininfor` VALUES (916, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-20 13:37:43');
INSERT INTO `sys_logininfor` VALUES (917, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-20 14:06:03');
INSERT INTO `sys_logininfor` VALUES (918, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-20 14:09:14');
INSERT INTO `sys_logininfor` VALUES (919, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-20 14:12:17');
INSERT INTO `sys_logininfor` VALUES (920, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-20 14:44:30');
INSERT INTO `sys_logininfor` VALUES (921, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-01-20 19:05:44');
INSERT INTO `sys_logininfor` VALUES (922, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-01-20 19:55:43');
INSERT INTO `sys_logininfor` VALUES (923, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-01-20 20:22:01');
INSERT INTO `sys_logininfor` VALUES (924, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-01-20 20:56:36');
INSERT INTO `sys_logininfor` VALUES (925, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '0', '验证码异常', '2019-01-20 21:19:03');
INSERT INTO `sys_logininfor` VALUES (926, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-01-20 21:19:07');
INSERT INTO `sys_logininfor` VALUES (927, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-20 22:36:04');
INSERT INTO `sys_logininfor` VALUES (928, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 09:32:15');
INSERT INTO `sys_logininfor` VALUES (929, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 10:30:01');
INSERT INTO `sys_logininfor` VALUES (930, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-21 10:30:12');
INSERT INTO `sys_logininfor` VALUES (931, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-21 10:35:43');
INSERT INTO `sys_logininfor` VALUES (932, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 10:35:47');
INSERT INTO `sys_logininfor` VALUES (933, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-21 10:35:50');
INSERT INTO `sys_logininfor` VALUES (934, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 10:36:30');
INSERT INTO `sys_logininfor` VALUES (935, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-21 10:36:33');
INSERT INTO `sys_logininfor` VALUES (936, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 10:37:22');
INSERT INTO `sys_logininfor` VALUES (937, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-21 10:37:28');
INSERT INTO `sys_logininfor` VALUES (938, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 10:38:27');
INSERT INTO `sys_logininfor` VALUES (939, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 10:45:07');
INSERT INTO `sys_logininfor` VALUES (940, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 10:45:16');
INSERT INTO `sys_logininfor` VALUES (941, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-21 10:52:08');
INSERT INTO `sys_logininfor` VALUES (942, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 10:52:31');
INSERT INTO `sys_logininfor` VALUES (943, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 10:54:29');
INSERT INTO `sys_logininfor` VALUES (944, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-21 11:08:23');
INSERT INTO `sys_logininfor` VALUES (945, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 11:11:10');
INSERT INTO `sys_logininfor` VALUES (946, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 12:07:37');
INSERT INTO `sys_logininfor` VALUES (947, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 12:31:35');
INSERT INTO `sys_logininfor` VALUES (948, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 12:37:28');
INSERT INTO `sys_logininfor` VALUES (949, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 15:21:43');
INSERT INTO `sys_logininfor` VALUES (950, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 15:22:23');
INSERT INTO `sys_logininfor` VALUES (951, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 15:35:57');
INSERT INTO `sys_logininfor` VALUES (952, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-21 15:56:04');
INSERT INTO `sys_logininfor` VALUES (953, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 15:56:16');
INSERT INTO `sys_logininfor` VALUES (954, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-21 16:05:04');
INSERT INTO `sys_logininfor` VALUES (955, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 16:05:55');
INSERT INTO `sys_logininfor` VALUES (956, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 16:35:31');
INSERT INTO `sys_logininfor` VALUES (957, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 17:42:38');
INSERT INTO `sys_logininfor` VALUES (958, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 18:13:56');
INSERT INTO `sys_logininfor` VALUES (959, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 18:16:45');
INSERT INTO `sys_logininfor` VALUES (960, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 19:05:53');
INSERT INTO `sys_logininfor` VALUES (961, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 19:17:02');
INSERT INTO `sys_logininfor` VALUES (962, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 19:46:55');
INSERT INTO `sys_logininfor` VALUES (963, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-21 20:25:12');
INSERT INTO `sys_logininfor` VALUES (964, 'admin', NULL, '中国 四川 成都', 'Apple WebKit', 'Mac OS X (iPhone)', '1', '登录成功', '2019-01-21 21:28:54');
INSERT INTO `sys_logininfor` VALUES (967, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-22 18:38:25');
INSERT INTO `sys_logininfor` VALUES (968, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-22 19:51:53');
INSERT INTO `sys_logininfor` VALUES (969, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-22 21:10:55');
INSERT INTO `sys_logininfor` VALUES (970, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-22 21:17:31');
INSERT INTO `sys_logininfor` VALUES (971, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-22 21:23:18');
INSERT INTO `sys_logininfor` VALUES (972, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-22 21:24:13');
INSERT INTO `sys_logininfor` VALUES (973, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-22 21:24:26');
INSERT INTO `sys_logininfor` VALUES (974, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-22 21:24:36');
INSERT INTO `sys_logininfor` VALUES (975, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-23 09:28:05');
INSERT INTO `sys_logininfor` VALUES (976, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-23 09:42:29');
INSERT INTO `sys_logininfor` VALUES (977, 'admin', NULL, '中国 四川 成都', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-23 14:13:58');
INSERT INTO `sys_logininfor` VALUES (978, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-23 16:47:01');
INSERT INTO `sys_logininfor` VALUES (979, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-23 19:22:35');
INSERT INTO `sys_logininfor` VALUES (980, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-23 19:50:29');
INSERT INTO `sys_logininfor` VALUES (981, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-23 20:07:30');
INSERT INTO `sys_logininfor` VALUES (982, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-23 20:39:15');
INSERT INTO `sys_logininfor` VALUES (983, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-24 10:16:03');
INSERT INTO `sys_logininfor` VALUES (984, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-24 12:19:28');
INSERT INTO `sys_logininfor` VALUES (985, 'admin', NULL, '中国 四川 成都', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-24 16:12:51');
INSERT INTO `sys_logininfor` VALUES (986, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 16:21:58');
INSERT INTO `sys_logininfor` VALUES (987, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-24 16:22:00');
INSERT INTO `sys_logininfor` VALUES (988, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-24 16:47:44');
INSERT INTO `sys_logininfor` VALUES (989, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 19:05:27');
INSERT INTO `sys_logininfor` VALUES (990, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 19:05:28');
INSERT INTO `sys_logininfor` VALUES (991, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 19:05:32');
INSERT INTO `sys_logininfor` VALUES (992, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 19:05:38');
INSERT INTO `sys_logininfor` VALUES (993, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 19:05:45');
INSERT INTO `sys_logininfor` VALUES (994, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 19:05:52');
INSERT INTO `sys_logininfor` VALUES (995, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 19:05:58');
INSERT INTO `sys_logininfor` VALUES (996, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 19:06:31');
INSERT INTO `sys_logininfor` VALUES (997, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 19:06:37');
INSERT INTO `sys_logininfor` VALUES (998, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 19:07:01');
INSERT INTO `sys_logininfor` VALUES (999, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-24 19:09:31');
INSERT INTO `sys_logininfor` VALUES (1000, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-24 19:09:41');
INSERT INTO `sys_logininfor` VALUES (1001, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 19:10:18');
INSERT INTO `sys_logininfor` VALUES (1002, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 19:10:26');
INSERT INTO `sys_logininfor` VALUES (1003, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-24 19:13:24');
INSERT INTO `sys_logininfor` VALUES (1004, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-24 19:13:36');
INSERT INTO `sys_logininfor` VALUES (1005, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-24 19:15:14');
INSERT INTO `sys_logininfor` VALUES (1006, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-24 19:53:29');
INSERT INTO `sys_logininfor` VALUES (1007, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-24 19:53:35');
INSERT INTO `sys_logininfor` VALUES (1008, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-24 20:43:35');
INSERT INTO `sys_logininfor` VALUES (1009, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-24 20:53:42');
INSERT INTO `sys_logininfor` VALUES (1010, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-24 20:54:16');
INSERT INTO `sys_logininfor` VALUES (1011, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-24 20:54:29');
INSERT INTO `sys_logininfor` VALUES (1012, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-24 20:54:34');
INSERT INTO `sys_logininfor` VALUES (1013, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-25 13:09:11');
INSERT INTO `sys_logininfor` VALUES (1014, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-25 13:09:31');
INSERT INTO `sys_logininfor` VALUES (1015, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-25 15:55:18');
INSERT INTO `sys_logininfor` VALUES (1016, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-25 18:48:20');
INSERT INTO `sys_logininfor` VALUES (1017, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-25 19:37:10');
INSERT INTO `sys_logininfor` VALUES (1018, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-25 19:37:35');
INSERT INTO `sys_logininfor` VALUES (1019, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-25 20:29:01');
INSERT INTO `sys_logininfor` VALUES (1020, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-25 20:59:34');
INSERT INTO `sys_logininfor` VALUES (1021, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-25 22:41:49');
INSERT INTO `sys_logininfor` VALUES (1022, 'admin', NULL, '内网IP', 'Internet Explorer 11', 'Windows 10', '0', '验证码异常', '2019-01-25 22:43:14');
INSERT INTO `sys_logininfor` VALUES (1023, 'admin', NULL, '内网IP', 'Internet Explorer 11', 'Windows 10', '1', '登录成功', '2019-01-25 22:43:23');
INSERT INTO `sys_logininfor` VALUES (1024, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-25 23:24:42');
INSERT INTO `sys_logininfor` VALUES (1025, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-26 00:33:50');
INSERT INTO `sys_logininfor` VALUES (1026, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-26 00:35:51');
INSERT INTO `sys_logininfor` VALUES (1027, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-26 00:47:08');
INSERT INTO `sys_logininfor` VALUES (1028, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-26 01:06:04');
INSERT INTO `sys_logininfor` VALUES (1029, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-26 13:51:13');
INSERT INTO `sys_logininfor` VALUES (1030, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-26 13:51:18');
INSERT INTO `sys_logininfor` VALUES (1031, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-26 14:02:51');
INSERT INTO `sys_logininfor` VALUES (1032, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-26 14:22:30');
INSERT INTO `sys_logininfor` VALUES (1033, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码异常', '2019-01-26 14:49:38');
INSERT INTO `sys_logininfor` VALUES (1034, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-26 14:49:42');
INSERT INTO `sys_logininfor` VALUES (1035, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-01-26 16:10:49');
INSERT INTO `sys_logininfor` VALUES (1036, 'admin', NULL, '中国 四川 成都', 'Mobile Safari', 'Mac OS X (iPhone)', '0', '验证码异常', '2019-01-26 16:40:41');
INSERT INTO `sys_logininfor` VALUES (1037, 'admin', NULL, 'XX XX', 'Mobile Safari', 'Mac OS X (iPhone)', '0', '验证码异常', '2019-01-26 16:40:44');
INSERT INTO `sys_logininfor` VALUES (1038, 'admin', NULL, '中国 四川 成都', 'Mobile Safari', 'Mac OS X (iPhone)', '1', '登录成功', '2019-01-26 16:40:48');
INSERT INTO `sys_logininfor` VALUES (1039, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-01-26 16:41:52');
INSERT INTO `sys_logininfor` VALUES (1040, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-01-26 19:07:59');
INSERT INTO `sys_logininfor` VALUES (1041, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-26 23:41:01');
INSERT INTO `sys_logininfor` VALUES (1042, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '退出成功', '2019-01-26 23:41:16');
INSERT INTO `sys_logininfor` VALUES (1043, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-26 23:41:25');
INSERT INTO `sys_logininfor` VALUES (1044, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '退出成功', '2019-01-26 23:46:56');
INSERT INTO `sys_logininfor` VALUES (1045, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-26 23:47:14');
INSERT INTO `sys_logininfor` VALUES (1046, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '退出成功', '2019-01-26 23:47:21');
INSERT INTO `sys_logininfor` VALUES (1047, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-26 23:47:28');
INSERT INTO `sys_logininfor` VALUES (1048, 'admin', NULL, '中国 四川 成都', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-26 23:49:25');
INSERT INTO `sys_logininfor` VALUES (1049, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '退出成功', '2019-01-26 23:57:46');
INSERT INTO `sys_logininfor` VALUES (1050, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '0', '验证码异常', '2019-01-26 23:57:56');
INSERT INTO `sys_logininfor` VALUES (1051, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '0', '验证码错误，请重新输入', '2019-01-26 23:59:44');
INSERT INTO `sys_logininfor` VALUES (1052, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-26 23:59:50');
INSERT INTO `sys_logininfor` VALUES (1053, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-27 00:29:02');
INSERT INTO `sys_logininfor` VALUES (1054, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-27 00:51:26');
INSERT INTO `sys_logininfor` VALUES (1055, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '0', '验证码错误，请重新输入', '2019-01-27 00:54:36');
INSERT INTO `sys_logininfor` VALUES (1056, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-27 00:54:42');
INSERT INTO `sys_logininfor` VALUES (1057, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-27 00:56:29');
INSERT INTO `sys_logininfor` VALUES (1058, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '0', '验证码错误，请重新输入', '2019-01-27 01:00:00');
INSERT INTO `sys_logininfor` VALUES (1059, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-27 01:00:07');
INSERT INTO `sys_logininfor` VALUES (1060, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-27 01:00:30');
INSERT INTO `sys_logininfor` VALUES (1061, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-27 14:37:12');
INSERT INTO `sys_logininfor` VALUES (1062, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-27 15:10:05');
INSERT INTO `sys_logininfor` VALUES (1063, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-27 16:52:31');
INSERT INTO `sys_logininfor` VALUES (1064, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-27 17:02:05');
INSERT INTO `sys_logininfor` VALUES (1065, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-27 17:34:35');
INSERT INTO `sys_logininfor` VALUES (1066, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-27 22:10:39');
INSERT INTO `sys_logininfor` VALUES (1067, 'admin', NULL, 'XX XX', 'Mobile Safari', 'Mac OS X (iPhone)', '1', '登录成功', '2019-01-27 22:12:03');
INSERT INTO `sys_logininfor` VALUES (1068, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 09:34:49');
INSERT INTO `sys_logininfor` VALUES (1069, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 10:45:13');
INSERT INTO `sys_logininfor` VALUES (1070, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-01-28 11:15:55');
INSERT INTO `sys_logininfor` VALUES (1071, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 11:16:02');
INSERT INTO `sys_logininfor` VALUES (1072, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 11:52:42');
INSERT INTO `sys_logininfor` VALUES (1073, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 12:05:53');
INSERT INTO `sys_logininfor` VALUES (1074, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-28 12:13:07');
INSERT INTO `sys_logininfor` VALUES (1075, 'admin', NULL, '内网IP', 'Microsoft Edge', 'Windows 10', '1', '登录成功', '2019-01-28 12:16:42');
INSERT INTO `sys_logininfor` VALUES (1076, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 12:37:52');
INSERT INTO `sys_logininfor` VALUES (1077, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 14:55:54');
INSERT INTO `sys_logininfor` VALUES (1078, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 15:38:34');
INSERT INTO `sys_logininfor` VALUES (1079, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 16:16:08');
INSERT INTO `sys_logininfor` VALUES (1080, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 16:38:10');
INSERT INTO `sys_logininfor` VALUES (1081, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 19:56:06');
INSERT INTO `sys_logininfor` VALUES (1082, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 20:27:35');
INSERT INTO `sys_logininfor` VALUES (1083, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-01-28 21:00:26');
INSERT INTO `sys_logininfor` VALUES (1084, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 21:00:32');
INSERT INTO `sys_logininfor` VALUES (1085, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-28 21:08:32');
INSERT INTO `sys_logininfor` VALUES (1086, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-28 21:10:16');
INSERT INTO `sys_logininfor` VALUES (1087, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 09:26:56');
INSERT INTO `sys_logininfor` VALUES (1088, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 09:41:39');
INSERT INTO `sys_logininfor` VALUES (1089, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 10:40:33');
INSERT INTO `sys_logininfor` VALUES (1090, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-01-29 10:40:46');
INSERT INTO `sys_logininfor` VALUES (1091, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 10:40:55');
INSERT INTO `sys_logininfor` VALUES (1092, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 12:03:09');
INSERT INTO `sys_logininfor` VALUES (1093, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 12:33:11');
INSERT INTO `sys_logininfor` VALUES (1094, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 13:43:07');
INSERT INTO `sys_logininfor` VALUES (1095, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 14:08:54');
INSERT INTO `sys_logininfor` VALUES (1096, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 14:13:42');
INSERT INTO `sys_logininfor` VALUES (1097, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 14:46:28');
INSERT INTO `sys_logininfor` VALUES (1098, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 15:10:43');
INSERT INTO `sys_logininfor` VALUES (1099, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 15:21:39');
INSERT INTO `sys_logininfor` VALUES (1100, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 19:10:49');
INSERT INTO `sys_logininfor` VALUES (1101, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 19:58:56');
INSERT INTO `sys_logininfor` VALUES (1102, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 20:24:45');
INSERT INTO `sys_logininfor` VALUES (1103, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-01-29 20:41:15');
INSERT INTO `sys_logininfor` VALUES (1104, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 20:41:20');
INSERT INTO `sys_logininfor` VALUES (1105, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-01-29 21:11:27');
INSERT INTO `sys_logininfor` VALUES (1106, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-29 21:11:33');
INSERT INTO `sys_logininfor` VALUES (1107, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 09:30:04');
INSERT INTO `sys_logininfor` VALUES (1108, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 09:56:05');
INSERT INTO `sys_logininfor` VALUES (1109, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 10:31:14');
INSERT INTO `sys_logininfor` VALUES (1110, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 10:36:37');
INSERT INTO `sys_logininfor` VALUES (1111, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 11:05:18');
INSERT INTO `sys_logininfor` VALUES (1112, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 11:09:21');
INSERT INTO `sys_logininfor` VALUES (1113, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 12:39:41');
INSERT INTO `sys_logininfor` VALUES (1114, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 14:19:02');
INSERT INTO `sys_logininfor` VALUES (1115, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 14:49:10');
INSERT INTO `sys_logininfor` VALUES (1116, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 19:01:54');
INSERT INTO `sys_logininfor` VALUES (1117, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-01-30 19:31:56');
INSERT INTO `sys_logininfor` VALUES (1118, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-01-30 19:32:02');
INSERT INTO `sys_logininfor` VALUES (1119, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 19:32:08');
INSERT INTO `sys_logininfor` VALUES (1120, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 19:39:02');
INSERT INTO `sys_logininfor` VALUES (1121, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-30 20:01:48');
INSERT INTO `sys_logininfor` VALUES (1122, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-01-30 20:01:58');
INSERT INTO `sys_logininfor` VALUES (1123, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-01-30 20:02:03');
INSERT INTO `sys_logininfor` VALUES (1124, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-01-30 20:02:08');
INSERT INTO `sys_logininfor` VALUES (1125, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 20:02:15');
INSERT INTO `sys_logininfor` VALUES (1126, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-30 20:17:40');
INSERT INTO `sys_logininfor` VALUES (1127, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 20:17:50');
INSERT INTO `sys_logininfor` VALUES (1128, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 20:59:30');
INSERT INTO `sys_logininfor` VALUES (1129, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 21:08:09');
INSERT INTO `sys_logininfor` VALUES (1130, 'admin', NULL, '内网IP', 'Firefox', 'Windows 10', '1', '登录成功', '2019-01-30 21:14:36');
INSERT INTO `sys_logininfor` VALUES (1131, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-30 21:18:43');
INSERT INTO `sys_logininfor` VALUES (1132, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 09:24:49');
INSERT INTO `sys_logininfor` VALUES (1133, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 12:23:08');
INSERT INTO `sys_logininfor` VALUES (1134, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 12:34:55');
INSERT INTO `sys_logininfor` VALUES (1135, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 16:35:31');
INSERT INTO `sys_logininfor` VALUES (1136, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 16:41:15');
INSERT INTO `sys_logininfor` VALUES (1137, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 16:41:26');
INSERT INTO `sys_logininfor` VALUES (1138, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 16:44:25');
INSERT INTO `sys_logininfor` VALUES (1139, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 16:46:30');
INSERT INTO `sys_logininfor` VALUES (1140, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 16:46:41');
INSERT INTO `sys_logininfor` VALUES (1141, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 17:49:14');
INSERT INTO `sys_logininfor` VALUES (1142, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 18:21:46');
INSERT INTO `sys_logininfor` VALUES (1143, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-01-31 19:12:21');
INSERT INTO `sys_logininfor` VALUES (1144, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 19:13:53');
INSERT INTO `sys_logininfor` VALUES (1145, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 19:42:36');
INSERT INTO `sys_logininfor` VALUES (1146, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 20:12:50');
INSERT INTO `sys_logininfor` VALUES (1147, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 20:14:53');
INSERT INTO `sys_logininfor` VALUES (1148, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 20:15:05');
INSERT INTO `sys_logininfor` VALUES (1149, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 20:15:25');
INSERT INTO `sys_logininfor` VALUES (1150, 'test', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 20:15:37');
INSERT INTO `sys_logininfor` VALUES (1151, 'test', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 20:16:23');
INSERT INTO `sys_logininfor` VALUES (1152, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 20:16:32');
INSERT INTO `sys_logininfor` VALUES (1153, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 20:33:40');
INSERT INTO `sys_logininfor` VALUES (1154, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 20:47:06');
INSERT INTO `sys_logininfor` VALUES (1155, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 21:10:23');
INSERT INTO `sys_logininfor` VALUES (1156, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 21:10:42');
INSERT INTO `sys_logininfor` VALUES (1157, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 21:12:26');
INSERT INTO `sys_logininfor` VALUES (1158, 'test', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 21:12:37');
INSERT INTO `sys_logininfor` VALUES (1159, 'test', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 21:13:07');
INSERT INTO `sys_logininfor` VALUES (1160, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 21:13:15');
INSERT INTO `sys_logininfor` VALUES (1161, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 21:15:05');
INSERT INTO `sys_logininfor` VALUES (1162, 'test', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 21:15:17');
INSERT INTO `sys_logininfor` VALUES (1163, 'test', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 21:15:53');
INSERT INTO `sys_logininfor` VALUES (1164, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 21:16:11');
INSERT INTO `sys_logininfor` VALUES (1165, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 21:16:47');
INSERT INTO `sys_logininfor` VALUES (1166, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 21:16:54');
INSERT INTO `sys_logininfor` VALUES (1167, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 21:16:59');
INSERT INTO `sys_logininfor` VALUES (1168, 'test', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 21:17:13');
INSERT INTO `sys_logininfor` VALUES (1169, 'test', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 21:17:48');
INSERT INTO `sys_logininfor` VALUES (1170, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 21:17:58');
INSERT INTO `sys_logininfor` VALUES (1171, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-01-31 21:20:06');
INSERT INTO `sys_logininfor` VALUES (1172, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 21:20:23');
INSERT INTO `sys_logininfor` VALUES (1173, 'admin', NULL, '中国 四川 成都', 'Mobile Safari', 'Mac OS X (iPhone)', '1', '登录成功', '2019-01-31 21:36:04');
INSERT INTO `sys_logininfor` VALUES (1174, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-01-31 23:14:51');
INSERT INTO `sys_logininfor` VALUES (1175, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 10:04:27');
INSERT INTO `sys_logininfor` VALUES (1176, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 13:54:12');
INSERT INTO `sys_logininfor` VALUES (1177, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 13:58:00');
INSERT INTO `sys_logininfor` VALUES (1178, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 15:39:56');
INSERT INTO `sys_logininfor` VALUES (1179, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 16:30:24');
INSERT INTO `sys_logininfor` VALUES (1180, 'admin', NULL, '中国 四川 成都', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-01 16:43:32');
INSERT INTO `sys_logininfor` VALUES (1181, 'admin', NULL, '中国 四川 成都', 'Apple WebKit', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-01 16:43:39');
INSERT INTO `sys_logininfor` VALUES (1182, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 16:53:14');
INSERT INTO `sys_logininfor` VALUES (1183, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:00:44');
INSERT INTO `sys_logininfor` VALUES (1184, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 17:08:37');
INSERT INTO `sys_logininfor` VALUES (1185, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:08:48');
INSERT INTO `sys_logininfor` VALUES (1186, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 17:12:04');
INSERT INTO `sys_logininfor` VALUES (1187, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 17:12:40');
INSERT INTO `sys_logininfor` VALUES (1188, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-01 17:12:59');
INSERT INTO `sys_logininfor` VALUES (1189, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:13:05');
INSERT INTO `sys_logininfor` VALUES (1190, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 17:15:21');
INSERT INTO `sys_logininfor` VALUES (1191, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:15:32');
INSERT INTO `sys_logininfor` VALUES (1192, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 17:16:03');
INSERT INTO `sys_logininfor` VALUES (1193, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:16:14');
INSERT INTO `sys_logininfor` VALUES (1194, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 17:16:20');
INSERT INTO `sys_logininfor` VALUES (1195, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-01 17:16:35');
INSERT INTO `sys_logininfor` VALUES (1196, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:16:48');
INSERT INTO `sys_logininfor` VALUES (1197, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 17:32:09');
INSERT INTO `sys_logininfor` VALUES (1198, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:32:19');
INSERT INTO `sys_logininfor` VALUES (1199, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 17:33:26');
INSERT INTO `sys_logininfor` VALUES (1200, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:33:49');
INSERT INTO `sys_logininfor` VALUES (1201, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:36:28');
INSERT INTO `sys_logininfor` VALUES (1202, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 17:47:13');
INSERT INTO `sys_logininfor` VALUES (1203, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:47:32');
INSERT INTO `sys_logininfor` VALUES (1204, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 17:49:56');
INSERT INTO `sys_logininfor` VALUES (1205, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:50:40');
INSERT INTO `sys_logininfor` VALUES (1206, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 17:53:27');
INSERT INTO `sys_logininfor` VALUES (1207, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:53:37');
INSERT INTO `sys_logininfor` VALUES (1208, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:55:01');
INSERT INTO `sys_logininfor` VALUES (1209, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 17:55:14');
INSERT INTO `sys_logininfor` VALUES (1210, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 17:55:31');
INSERT INTO `sys_logininfor` VALUES (1211, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 18:05:36');
INSERT INTO `sys_logininfor` VALUES (1212, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-01 18:05:47');
INSERT INTO `sys_logininfor` VALUES (1213, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 18:05:53');
INSERT INTO `sys_logininfor` VALUES (1214, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 18:07:51');
INSERT INTO `sys_logininfor` VALUES (1215, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 18:10:01');
INSERT INTO `sys_logininfor` VALUES (1216, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 18:13:23');
INSERT INTO `sys_logininfor` VALUES (1217, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 18:15:28');
INSERT INTO `sys_logininfor` VALUES (1218, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-01 18:15:44');
INSERT INTO `sys_logininfor` VALUES (1219, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-01 18:15:52');
INSERT INTO `sys_logininfor` VALUES (1220, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 18:15:59');
INSERT INTO `sys_logininfor` VALUES (1221, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 18:17:08');
INSERT INTO `sys_logininfor` VALUES (1222, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-01 18:18:28');
INSERT INTO `sys_logininfor` VALUES (1223, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-01 18:18:43');
INSERT INTO `sys_logininfor` VALUES (1224, 'bianxiaofeng', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-01 18:18:50');
INSERT INTO `sys_logininfor` VALUES (1225, 'admin', NULL, '中国 四川 成都', 'Mobile Safari', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-01 18:40:46');
INSERT INTO `sys_logininfor` VALUES (1226, 'admin', NULL, '中国 四川 成都', 'Mobile Safari', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-01 18:40:49');
INSERT INTO `sys_logininfor` VALUES (1227, 'admin', NULL, '中国 四川 成都', 'Microsoft Edge', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-02 00:04:22');
INSERT INTO `sys_logininfor` VALUES (1228, 'admin', NULL, '中国 四川 成都', 'Mobile Safari', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 06:55:03');
INSERT INTO `sys_logininfor` VALUES (1229, 'admin', NULL, '中国 四川 成都', 'Mobile Safari', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-02 06:55:07');
INSERT INTO `sys_logininfor` VALUES (1230, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-02 07:58:35');
INSERT INTO `sys_logininfor` VALUES (1231, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 07:58:41');
INSERT INTO `sys_logininfor` VALUES (1232, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 08:41:02');
INSERT INTO `sys_logininfor` VALUES (1233, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 08:55:22');
INSERT INTO `sys_logininfor` VALUES (1234, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-02 09:11:18');
INSERT INTO `sys_logininfor` VALUES (1235, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 09:11:31');
INSERT INTO `sys_logininfor` VALUES (1236, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-02 09:21:09');
INSERT INTO `sys_logininfor` VALUES (1237, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 09:21:16');
INSERT INTO `sys_logininfor` VALUES (1238, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-02 09:31:07');
INSERT INTO `sys_logininfor` VALUES (1239, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 09:31:12');
INSERT INTO `sys_logininfor` VALUES (1240, 'admin', NULL, '中国 陕西 西安', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-02 10:54:03');
INSERT INTO `sys_logininfor` VALUES (1241, 'admin', NULL, '中国 陕西 西安', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 10:54:08');
INSERT INTO `sys_logininfor` VALUES (1242, 'admin', NULL, '中国 陕西 西安', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-02 11:41:28');
INSERT INTO `sys_logininfor` VALUES (1243, 'admin', NULL, '中国 陕西 西安', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 11:41:32');
INSERT INTO `sys_logininfor` VALUES (1244, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 12:20:10');
INSERT INTO `sys_logininfor` VALUES (1245, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-02 12:26:40');
INSERT INTO `sys_logininfor` VALUES (1246, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 12:26:46');
INSERT INTO `sys_logininfor` VALUES (1247, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 12:59:07');
INSERT INTO `sys_logininfor` VALUES (1248, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-02 13:01:58');
INSERT INTO `sys_logininfor` VALUES (1249, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 13:02:10');
INSERT INTO `sys_logininfor` VALUES (1250, 'admin', NULL, '中国 四川 成都', 'Mobile Safari', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 14:29:00');
INSERT INTO `sys_logininfor` VALUES (1251, 'admin', NULL, '中国 四川 成都', 'Mobile Safari', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-02 14:29:03');
INSERT INTO `sys_logininfor` VALUES (1252, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-02 15:56:20');
INSERT INTO `sys_logininfor` VALUES (1253, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-02 16:10:49');
INSERT INTO `sys_logininfor` VALUES (1254, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 16:10:54');
INSERT INTO `sys_logininfor` VALUES (1255, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-02 16:16:33');
INSERT INTO `sys_logininfor` VALUES (1256, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 16:16:48');
INSERT INTO `sys_logininfor` VALUES (1257, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-02 16:19:36');
INSERT INTO `sys_logininfor` VALUES (1258, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 16:19:41');
INSERT INTO `sys_logininfor` VALUES (1259, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 16:29:30');
INSERT INTO `sys_logininfor` VALUES (1260, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-02 16:29:42');
INSERT INTO `sys_logininfor` VALUES (1261, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 16:29:48');
INSERT INTO `sys_logininfor` VALUES (1262, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 16:53:52');
INSERT INTO `sys_logininfor` VALUES (1263, 'admin', NULL, '中国 四川 成都', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 17:13:00');
INSERT INTO `sys_logininfor` VALUES (1264, 'admin', NULL, '中国 四川 成都', 'Apple WebKit', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-02 17:13:04');
INSERT INTO `sys_logininfor` VALUES (1265, 'admin', NULL, '中国 四川 成都', 'Chrome Mobile', 'Android Mobile', '0', '验证码错误，请重新输入', '2019-02-02 17:21:54');
INSERT INTO `sys_logininfor` VALUES (1266, 'admin', NULL, '中国 四川 成都', 'Chrome Mobile', 'Android Mobile', '1', '登录成功', '2019-02-02 17:22:05');
INSERT INTO `sys_logininfor` VALUES (1267, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-02 17:26:26');
INSERT INTO `sys_logininfor` VALUES (1268, 'admin', NULL, '中国 四川 遂宁', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 17:42:16');
INSERT INTO `sys_logininfor` VALUES (1269, 'admin', NULL, '中国 四川 遂宁', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 17:42:21');
INSERT INTO `sys_logininfor` VALUES (1270, 'admin', NULL, '中国 四川 遂宁', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 17:42:26');
INSERT INTO `sys_logininfor` VALUES (1271, 'test', NULL, '中国 四川 遂宁', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 17:42:50');
INSERT INTO `sys_logininfor` VALUES (1272, 'test', NULL, '中国 四川 遂宁', 'Apple WebKit', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-02 17:42:55');
INSERT INTO `sys_logininfor` VALUES (1273, 'admin', NULL, '中国 四川 成都', 'Mobile Safari', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-02 17:51:53');
INSERT INTO `sys_logininfor` VALUES (1274, 'admin', NULL, '中国 上海 上海', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-02 18:12:52');
INSERT INTO `sys_logininfor` VALUES (1275, 'admin', NULL, '中国 上海 上海', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-02 18:13:04');
INSERT INTO `sys_logininfor` VALUES (1276, 'admin', NULL, '中国 上海 上海', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-02 18:13:10');
INSERT INTO `sys_logininfor` VALUES (1277, 'admin', NULL, '中国 上海 上海', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-02-02 18:13:17');
INSERT INTO `sys_logininfor` VALUES (1278, 'admin', NULL, '中国 四川 成都', 'Apple WebKit', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-02 18:16:24');
INSERT INTO `sys_logininfor` VALUES (1279, 'admin', NULL, '中国 河北 廊坊', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-02-02 18:31:14');
INSERT INTO `sys_logininfor` VALUES (1280, 'admin', NULL, '中国 四川 成都', 'Chrome Mobile', 'Android Mobile', '0', '验证码错误，请重新输入', '2019-02-02 19:52:42');
INSERT INTO `sys_logininfor` VALUES (1281, 'admin', NULL, '中国 四川 成都', 'Chrome Mobile', 'Android Mobile', '1', '登录成功', '2019-02-02 19:52:49');
INSERT INTO `sys_logininfor` VALUES (1282, 'admin', NULL, '中国 四川 巴中', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-02 20:52:13');
INSERT INTO `sys_logininfor` VALUES (1283, 'admin', NULL, '中国 四川 巴中', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-02 20:52:31');
INSERT INTO `sys_logininfor` VALUES (1284, 'admin', NULL, '中国 四川 广元', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 23:20:07');
INSERT INTO `sys_logininfor` VALUES (1285, 'admin', NULL, '中国 四川 广元', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 23:20:12');
INSERT INTO `sys_logininfor` VALUES (1286, 'admin', NULL, '中国 四川 广元', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 23:20:17');
INSERT INTO `sys_logininfor` VALUES (1287, 'admin', NULL, '中国 四川 广元', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 23:20:24');
INSERT INTO `sys_logininfor` VALUES (1288, 'admin', NULL, '中国 四川 广元', 'Mobile Safari', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 23:20:42');
INSERT INTO `sys_logininfor` VALUES (1289, 'admin', NULL, '中国 四川 广元', 'Mobile Safari', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 23:20:45');
INSERT INTO `sys_logininfor` VALUES (1290, 'admin', NULL, 'XX XX', 'Mobile Safari', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 23:20:52');
INSERT INTO `sys_logininfor` VALUES (1291, 'admin', NULL, 'XX XX', 'Mobile Safari', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-02 23:20:59');
INSERT INTO `sys_logininfor` VALUES (1292, 'admin', NULL, 'XX XX', 'Mobile Safari', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-02 23:21:17');
INSERT INTO `sys_logininfor` VALUES (1293, 'admin', NULL, '中国 四川 成都', 'Mobile Safari', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-03 10:36:26');
INSERT INTO `sys_logininfor` VALUES (1294, 'admin', NULL, '香港 香港 XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-03 11:35:39');
INSERT INTO `sys_logininfor` VALUES (1295, 'admin', NULL, '香港 香港 XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-03 11:35:47');
INSERT INTO `sys_logininfor` VALUES (1296, 'admin', NULL, '中国 四川 广元', 'Apple WebKit', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-03 21:31:56');
INSERT INTO `sys_logininfor` VALUES (1297, 'admin', NULL, '中国 吉林 长春', 'Firefox', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-03 22:30:38');
INSERT INTO `sys_logininfor` VALUES (1298, 'admin', NULL, '中国 吉林 长春', 'Firefox', 'Windows 10', '1', '登录成功', '2019-02-03 22:30:42');
INSERT INTO `sys_logininfor` VALUES (1299, 'admin', NULL, '中国 上海 上海', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-06 09:35:37');
INSERT INTO `sys_logininfor` VALUES (1300, 'admin', NULL, '中国 上海 上海', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-06 09:35:41');
INSERT INTO `sys_logininfor` VALUES (1301, 'admin', NULL, '中国 四川 广元', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-06 14:05:38');
INSERT INTO `sys_logininfor` VALUES (1302, 'admin', NULL, '中国 四川 广元', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-06 14:05:44');
INSERT INTO `sys_logininfor` VALUES (1303, 'admin', NULL, '中国 四川 广元', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-06 15:09:58');
INSERT INTO `sys_logininfor` VALUES (1304, 'admin', NULL, '中国 四川 广元', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-06 20:21:54');
INSERT INTO `sys_logininfor` VALUES (1305, 'admin', NULL, '中国 四川 广元', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-06 20:22:01');
INSERT INTO `sys_logininfor` VALUES (1306, 'admin', NULL, 'XX XX', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-08 15:40:22');
INSERT INTO `sys_logininfor` VALUES (1307, 'admin', NULL, 'XX XX', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-02-08 15:40:31');
INSERT INTO `sys_logininfor` VALUES (1308, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-08 23:00:46');
INSERT INTO `sys_logininfor` VALUES (1309, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-08 23:00:51');
INSERT INTO `sys_logininfor` VALUES (1310, 'admin', NULL, '中国 安徽 XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-09 08:11:48');
INSERT INTO `sys_logininfor` VALUES (1311, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-09 08:11:56');
INSERT INTO `sys_logininfor` VALUES (1312, 'admin', NULL, '中国 湖北 武汉', 'Microsoft Edge', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-10 10:41:52');
INSERT INTO `sys_logininfor` VALUES (1313, 'admin', NULL, 'XX XX', 'Microsoft Edge', 'Windows 10', '1', '登录成功', '2019-02-10 10:42:00');
INSERT INTO `sys_logininfor` VALUES (1314, 'admin', NULL, '中国 四川 成都', 'Mobile Safari', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-10 16:04:37');
INSERT INTO `sys_logininfor` VALUES (1315, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-10 20:41:10');
INSERT INTO `sys_logininfor` VALUES (1316, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-10 20:41:13');
INSERT INTO `sys_logininfor` VALUES (1317, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-10 20:55:36');
INSERT INTO `sys_logininfor` VALUES (1318, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '0', '用户不存在/密码错误，请重新输入', '2019-02-10 20:55:46');
INSERT INTO `sys_logininfor` VALUES (1319, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-10 20:56:31');
INSERT INTO `sys_logininfor` VALUES (1320, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-10 20:56:36');
INSERT INTO `sys_logininfor` VALUES (1321, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-10 21:10:52');
INSERT INTO `sys_logininfor` VALUES (1322, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-11 11:24:46');
INSERT INTO `sys_logininfor` VALUES (1323, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-11 11:24:52');
INSERT INTO `sys_logininfor` VALUES (1324, 'admin', NULL, 'XX XX', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-11 14:52:52');
INSERT INTO `sys_logininfor` VALUES (1325, 'admin', NULL, 'XX XX', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-02-11 14:52:58');
INSERT INTO `sys_logininfor` VALUES (1326, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-11 15:39:07');
INSERT INTO `sys_logininfor` VALUES (1327, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-11 16:08:47');
INSERT INTO `sys_logininfor` VALUES (1328, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-11 16:08:53');
INSERT INTO `sys_logininfor` VALUES (1329, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-11 16:12:13');
INSERT INTO `sys_logininfor` VALUES (1330, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-11 16:26:28');
INSERT INTO `sys_logininfor` VALUES (1331, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-11 16:26:41');
INSERT INTO `sys_logininfor` VALUES (1332, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-11 17:05:14');
INSERT INTO `sys_logininfor` VALUES (1333, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-11 17:05:23');
INSERT INTO `sys_logininfor` VALUES (1334, 'admin', NULL, 'XX XX', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-11 17:15:08');
INSERT INTO `sys_logininfor` VALUES (1335, 'admin', NULL, 'XX XX', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-02-11 17:15:12');
INSERT INTO `sys_logininfor` VALUES (1336, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-11 18:18:26');
INSERT INTO `sys_logininfor` VALUES (1337, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-11 18:18:32');
INSERT INTO `sys_logininfor` VALUES (1338, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-11 18:39:55');
INSERT INTO `sys_logininfor` VALUES (1339, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-11 18:41:50');
INSERT INTO `sys_logininfor` VALUES (1340, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-11 18:41:55');
INSERT INTO `sys_logininfor` VALUES (1341, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-11 19:10:01');
INSERT INTO `sys_logininfor` VALUES (1342, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-11 19:44:04');
INSERT INTO `sys_logininfor` VALUES (1343, 'admin', NULL, 'XX XX', 'Mobile Safari', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-11 20:09:52');
INSERT INTO `sys_logininfor` VALUES (1344, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-11 22:38:12');
INSERT INTO `sys_logininfor` VALUES (1345, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-11 22:39:44');
INSERT INTO `sys_logininfor` VALUES (1346, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-11 22:40:12');
INSERT INTO `sys_logininfor` VALUES (1347, 'admin', NULL, 'XX XX', 'Chrome Mobile', 'Android Mobile', '0', '验证码错误，请重新输入', '2019-02-11 22:52:41');
INSERT INTO `sys_logininfor` VALUES (1348, 'admin', NULL, 'XX XX', 'Chrome Mobile', 'Android Mobile', '0', '验证码错误，请重新输入', '2019-02-11 22:52:50');
INSERT INTO `sys_logininfor` VALUES (1349, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-12 09:35:05');
INSERT INTO `sys_logininfor` VALUES (1350, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-12 09:35:11');
INSERT INTO `sys_logininfor` VALUES (1351, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-12 09:52:15');
INSERT INTO `sys_logininfor` VALUES (1352, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-12 09:52:21');
INSERT INTO `sys_logininfor` VALUES (1353, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-12 10:03:41');
INSERT INTO `sys_logininfor` VALUES (1354, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-12 10:09:44');
INSERT INTO `sys_logininfor` VALUES (1355, NULL, NULL, 'XX XX', 'Mobile Safari', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-02-12 11:26:14');
INSERT INTO `sys_logininfor` VALUES (1356, NULL, NULL, 'XX XX', 'Mobile Safari', 'Mac OS X (iPhone)', '0', '用户不存在/密码错误，请重新输入', '2019-02-12 11:26:17');
INSERT INTO `sys_logininfor` VALUES (1357, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-12 12:36:09');
INSERT INTO `sys_logininfor` VALUES (1358, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-12 12:36:15');
INSERT INTO `sys_logininfor` VALUES (1359, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-12 14:21:47');
INSERT INTO `sys_logininfor` VALUES (1360, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-12 14:21:52');
INSERT INTO `sys_logininfor` VALUES (1361, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-12 14:42:18');
INSERT INTO `sys_logininfor` VALUES (1362, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-12 14:42:25');
INSERT INTO `sys_logininfor` VALUES (1363, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-12 15:27:56');
INSERT INTO `sys_logininfor` VALUES (1364, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-12 17:22:22');
INSERT INTO `sys_logininfor` VALUES (1365, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-12 17:22:29');
INSERT INTO `sys_logininfor` VALUES (1366, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-12 17:22:38');
INSERT INTO `sys_logininfor` VALUES (1367, '1235', NULL, '中国 浙江 杭州', 'Chrome', 'Mac OS X', '0', '用户不存在/密码错误，请重新输入', '2019-02-12 17:33:22');
INSERT INTO `sys_logininfor` VALUES (1368, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-12 20:16:19');
INSERT INTO `sys_logininfor` VALUES (1369, '18582872818', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-12 20:55:12');
INSERT INTO `sys_logininfor` VALUES (1370, 'kongruojun', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-13 16:48:36');
INSERT INTO `sys_logininfor` VALUES (1371, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-13 16:55:45');
INSERT INTO `sys_logininfor` VALUES (1372, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-13 16:55:52');
INSERT INTO `sys_logininfor` VALUES (1373, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-13 19:11:27');
INSERT INTO `sys_logininfor` VALUES (1374, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '退出成功', '2019-02-13 19:12:18');
INSERT INTO `sys_logininfor` VALUES (1375, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-13 19:39:48');
INSERT INTO `sys_logininfor` VALUES (1376, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-13 19:40:23');
INSERT INTO `sys_logininfor` VALUES (1377, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-13 20:18:43');
INSERT INTO `sys_logininfor` VALUES (1378, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-13 20:19:39');
INSERT INTO `sys_logininfor` VALUES (1379, '18582872818', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-13 20:53:50');
INSERT INTO `sys_logininfor` VALUES (1380, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-13 20:53:51');
INSERT INTO `sys_logininfor` VALUES (1381, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-13 22:13:41');
INSERT INTO `sys_logininfor` VALUES (1382, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-13 22:28:27');
INSERT INTO `sys_logininfor` VALUES (1383, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-13 22:29:41');
INSERT INTO `sys_logininfor` VALUES (1384, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-13 22:44:22');
INSERT INTO `sys_logininfor` VALUES (1385, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-13 22:44:22');
INSERT INTO `sys_logininfor` VALUES (1386, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-13 22:44:25');
INSERT INTO `sys_logininfor` VALUES (1387, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-13 22:46:14');
INSERT INTO `sys_logininfor` VALUES (1388, NULL, NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-13 22:57:23');
INSERT INTO `sys_logininfor` VALUES (1389, '18582872818', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-14 09:58:16');
INSERT INTO `sys_logininfor` VALUES (1390, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-14 09:58:23');
INSERT INTO `sys_logininfor` VALUES (1391, '18582872818', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-14 10:38:17');
INSERT INTO `sys_logininfor` VALUES (1392, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-14 10:38:25');
INSERT INTO `sys_logininfor` VALUES (1393, 'test', NULL, 'XX XX', 'Chrome', 'Mac OS X', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-14 14:08:14');
INSERT INTO `sys_logininfor` VALUES (1394, 'test', NULL, '中国 北京 北京', 'Chrome', 'Mac OS X', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-14 14:08:20');
INSERT INTO `sys_logininfor` VALUES (1395, 'test', NULL, 'XX XX', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-14 14:08:38');
INSERT INTO `sys_logininfor` VALUES (1396, 'test', NULL, '中国 江西 南昌', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-14 15:27:42');
INSERT INTO `sys_logininfor` VALUES (1397, 'test', NULL, '中国 江西 南昌', 'Chrome', 'Windows 7', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-14 15:27:57');
INSERT INTO `sys_logininfor` VALUES (1398, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-14 17:18:38');
INSERT INTO `sys_logininfor` VALUES (1399, 'test', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-14 17:18:47');
INSERT INTO `sys_logininfor` VALUES (1400, 'as123', NULL, '中国 陕西 榆林', 'Firefox', 'Windows XP', '0', '验证码错误，请重新输入', '2019-02-15 08:32:12');
INSERT INTO `sys_logininfor` VALUES (1401, 'as123', NULL, '中国 陕西 榆林', 'Firefox', 'Windows XP', '0', '用户不存在/密码错误，请重新输入', '2019-02-15 08:32:25');
INSERT INTO `sys_logininfor` VALUES (1402, 'as123', NULL, '中国 陕西 榆林', 'Firefox', 'Windows XP', '0', '验证码错误，请重新输入', '2019-02-15 08:32:29');
INSERT INTO `sys_logininfor` VALUES (1403, 'test', NULL, '中国 安徽 XX', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-16 07:38:46');
INSERT INTO `sys_logininfor` VALUES (1404, 'admin', NULL, '中国 江苏 南京', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-16 11:36:32');
INSERT INTO `sys_logininfor` VALUES (1405, 'admin', NULL, '中国 江苏 南京', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-16 11:36:39');
INSERT INTO `sys_logininfor` VALUES (1406, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-17 17:25:15');
INSERT INTO `sys_logininfor` VALUES (1407, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-17 17:25:24');
INSERT INTO `sys_logininfor` VALUES (1408, 'test', NULL, '中国 福建 厦门', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-18 09:06:52');
INSERT INTO `sys_logininfor` VALUES (1409, 'test', NULL, '中国 福建 厦门', 'Chrome', 'Mac OS X', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-18 09:07:17');
INSERT INTO `sys_logininfor` VALUES (1410, 'test', NULL, '中国 福建 厦门', 'Chrome', 'Mac OS X', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-18 09:07:31');
INSERT INTO `sys_logininfor` VALUES (1411, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-18 19:08:19');
INSERT INTO `sys_logininfor` VALUES (1412, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-18 19:08:30');
INSERT INTO `sys_logininfor` VALUES (1413, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-18 19:42:28');
INSERT INTO `sys_logininfor` VALUES (1414, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-18 20:44:24');
INSERT INTO `sys_logininfor` VALUES (1415, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-18 20:59:52');
INSERT INTO `sys_logininfor` VALUES (1416, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-19 09:11:23');
INSERT INTO `sys_logininfor` VALUES (1417, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-19 09:11:36');
INSERT INTO `sys_logininfor` VALUES (1418, 'admin', NULL, '内网IP', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-19 10:00:21');
INSERT INTO `sys_logininfor` VALUES (1419, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-19 10:08:42');
INSERT INTO `sys_logininfor` VALUES (1420, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-19 10:08:42');
INSERT INTO `sys_logininfor` VALUES (1421, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-19 10:08:53');
INSERT INTO `sys_logininfor` VALUES (1422, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-19 10:09:01');
INSERT INTO `sys_logininfor` VALUES (1423, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-19 12:22:38');
INSERT INTO `sys_logininfor` VALUES (1424, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-19 12:40:02');
INSERT INTO `sys_logininfor` VALUES (1425, 'admin', NULL, '内网IP', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-19 12:52:22');
INSERT INTO `sys_logininfor` VALUES (1426, 'test', NULL, '中国 福建 福州', 'Chrome', 'Windows 7', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-19 14:19:41');
INSERT INTO `sys_logininfor` VALUES (1427, 'test', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-19 14:20:00');
INSERT INTO `sys_logininfor` VALUES (1428, 'test', NULL, '中国 福建 福州', 'Chrome', 'Windows 7', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-19 14:20:02');
INSERT INTO `sys_logininfor` VALUES (1429, 'admin', NULL, '中国 福建 福州', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-19 14:21:32');
INSERT INTO `sys_logininfor` VALUES (1430, 'test', NULL, '中国 湖南 长沙', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-19 16:53:52');
INSERT INTO `sys_logininfor` VALUES (1431, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-19 16:54:15');
INSERT INTO `sys_logininfor` VALUES (1432, 'admin', NULL, '中国 河南 郑州', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-19 19:49:23');
INSERT INTO `sys_logininfor` VALUES (1433, 'admin', NULL, '中国 河南 郑州', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-19 19:49:33');
INSERT INTO `sys_logininfor` VALUES (1434, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-19 20:29:22');
INSERT INTO `sys_logininfor` VALUES (1435, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-19 20:30:26');
INSERT INTO `sys_logininfor` VALUES (1436, 'test', NULL, '中国 辽宁 营口', 'Chrome', 'Windows 10', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-19 20:46:45');
INSERT INTO `sys_logininfor` VALUES (1437, NULL, NULL, '中国 广东 深圳', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-20 11:45:27');
INSERT INTO `sys_logininfor` VALUES (1438, NULL, NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-20 15:43:19');
INSERT INTO `sys_logininfor` VALUES (1439, NULL, NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-20 15:43:24');
INSERT INTO `sys_logininfor` VALUES (1440, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-20 15:43:33');
INSERT INTO `sys_logininfor` VALUES (1441, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-20 15:43:37');
INSERT INTO `sys_logininfor` VALUES (1442, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-20 15:46:17');
INSERT INTO `sys_logininfor` VALUES (1443, NULL, NULL, '中国 北京 北京', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-21 11:09:10');
INSERT INTO `sys_logininfor` VALUES (1444, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-21 17:01:29');
INSERT INTO `sys_logininfor` VALUES (1445, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-21 17:01:34');
INSERT INTO `sys_logininfor` VALUES (1446, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-21 17:24:44');
INSERT INTO `sys_logininfor` VALUES (1447, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-21 17:24:51');
INSERT INTO `sys_logininfor` VALUES (1448, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-21 17:24:56');
INSERT INTO `sys_logininfor` VALUES (1449, 'test', NULL, '中国 湖南 长沙', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-21 17:41:28');
INSERT INTO `sys_logininfor` VALUES (1450, 'test', NULL, '中国 湖南 长沙', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-21 17:41:33');
INSERT INTO `sys_logininfor` VALUES (1451, 'test', NULL, '中国 湖南 长沙', 'Chrome', 'Mac OS X', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-21 17:41:40');
INSERT INTO `sys_logininfor` VALUES (1452, 'test', NULL, '中国 湖南 长沙', 'Chrome', 'Mac OS X', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-21 17:41:47');
INSERT INTO `sys_logininfor` VALUES (1453, 'test', NULL, '中国 湖南 长沙', 'Chrome', 'Mac OS X', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-21 17:42:04');
INSERT INTO `sys_logininfor` VALUES (1454, 'test', NULL, '中国 湖南 长沙', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-21 17:42:10');
INSERT INTO `sys_logininfor` VALUES (1455, 'test', NULL, '中国 湖南 长沙', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-21 17:42:12');
INSERT INTO `sys_logininfor` VALUES (1456, 'test', NULL, '中国 北京 北京', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-22 16:00:00');
INSERT INTO `sys_logininfor` VALUES (1457, 'test', NULL, '中国 北京 北京', 'Chrome', 'Windows 10', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-22 16:00:15');
INSERT INTO `sys_logininfor` VALUES (1458, 'test', NULL, '中国 北京 北京', 'Chrome', 'Windows 10', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-22 16:00:22');
INSERT INTO `sys_logininfor` VALUES (1459, 'test', NULL, '中国 北京 北京', 'Chrome', 'Mac OS X', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-22 16:02:10');
INSERT INTO `sys_logininfor` VALUES (1460, 'test', NULL, '中国 北京 北京', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-22 16:02:27');
INSERT INTO `sys_logininfor` VALUES (1461, 'test', NULL, '中国 重庆 重庆', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-22 16:05:00');
INSERT INTO `sys_logininfor` VALUES (1462, 'test', NULL, '中国 重庆 重庆', 'Chrome', 'Windows 7', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-22 16:05:05');
INSERT INTO `sys_logininfor` VALUES (1463, 'test', NULL, '中国 重庆 重庆', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-22 16:05:14');
INSERT INTO `sys_logininfor` VALUES (1464, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-22 16:46:59');
INSERT INTO `sys_logininfor` VALUES (1465, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-22 20:51:36');
INSERT INTO `sys_logininfor` VALUES (1466, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-22 20:51:58');
INSERT INTO `sys_logininfor` VALUES (1467, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-22 21:25:40');
INSERT INTO `sys_logininfor` VALUES (1468, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-22 21:41:35');
INSERT INTO `sys_logininfor` VALUES (1469, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-23 09:57:51');
INSERT INTO `sys_logininfor` VALUES (1470, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-23 09:57:56');
INSERT INTO `sys_logininfor` VALUES (1471, NULL, NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-24 14:18:16');
INSERT INTO `sys_logininfor` VALUES (1472, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-24 15:02:24');
INSERT INTO `sys_logininfor` VALUES (1473, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-24 15:02:30');
INSERT INTO `sys_logininfor` VALUES (1474, 'test', NULL, '中国 山东 济南', 'Chrome Mobile', 'Android Mobile', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-24 21:53:41');
INSERT INTO `sys_logininfor` VALUES (1475, 'ww', NULL, 'XX XX', 'Internet Explorer 11', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-24 22:54:03');
INSERT INTO `sys_logininfor` VALUES (1476, 'test', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-25 08:53:03');
INSERT INTO `sys_logininfor` VALUES (1477, 'test', NULL, '中国 北京 北京', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-25 08:53:06');
INSERT INTO `sys_logininfor` VALUES (1478, 'test', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-25 08:53:12');
INSERT INTO `sys_logininfor` VALUES (1479, 'admin', NULL, '中国 湖北 武汉', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-25 09:24:59');
INSERT INTO `sys_logininfor` VALUES (1480, 'admin', NULL, '中国 湖北 武汉', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-02-25 09:25:05');
INSERT INTO `sys_logininfor` VALUES (1481, 'admin', NULL, '中国 湖北 武汉', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-25 09:25:13');
INSERT INTO `sys_logininfor` VALUES (1482, 'dimple', NULL, '中国 湖北 武汉', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-25 09:25:21');
INSERT INTO `sys_logininfor` VALUES (1483, 'dimple', NULL, '中国 湖北 武汉', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-25 09:25:31');
INSERT INTO `sys_logininfor` VALUES (1484, 'test', NULL, '中国 湖北 武汉', 'Chrome', 'Windows 10', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-25 09:25:40');
INSERT INTO `sys_logininfor` VALUES (1485, 'test', NULL, '中国 湖北 武汉', 'Chrome', 'Windows 10', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-25 09:25:51');
INSERT INTO `sys_logininfor` VALUES (1486, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-25 11:48:11');
INSERT INTO `sys_logininfor` VALUES (1487, 'admin', NULL, 'XX XX', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-02-25 11:48:16');
INSERT INTO `sys_logininfor` VALUES (1488, '15717981520', NULL, '中国 上海 上海', 'Chrome', 'Windows 7', '0', '用户不存在/密码错误，请重新输入', '2019-02-25 17:12:01');
INSERT INTO `sys_logininfor` VALUES (1489, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-25 17:13:43');
INSERT INTO `sys_logininfor` VALUES (1490, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '用户不存在/密码错误，请重新输入', '2019-02-25 17:13:47');
INSERT INTO `sys_logininfor` VALUES (1491, 'admin', NULL, '中国 上海 上海', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-25 17:13:51');
INSERT INTO `sys_logininfor` VALUES (1492, 'test', NULL, '中国 江苏 苏州', 'Safari', 'Mac OS X', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-25 17:25:21');
INSERT INTO `sys_logininfor` VALUES (1493, 'test', NULL, '中国 江苏 苏州', 'Safari', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-02-25 17:25:23');
INSERT INTO `sys_logininfor` VALUES (1494, 'test', NULL, '中国 江苏 苏州', 'Safari', 'Mac OS X', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-25 17:25:28');
INSERT INTO `sys_logininfor` VALUES (1495, 'test', NULL, 'XX XX', 'Safari', 'Mac OS X', '0', '身份认证异常，请刷新重试或联系管理员', '2019-02-25 17:25:43');
INSERT INTO `sys_logininfor` VALUES (1496, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-25 19:24:31');
INSERT INTO `sys_logininfor` VALUES (1497, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-25 22:51:39');
INSERT INTO `sys_logininfor` VALUES (1498, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-25 22:51:45');
INSERT INTO `sys_logininfor` VALUES (1499, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-25 22:51:50');
INSERT INTO `sys_logininfor` VALUES (1500, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-26 09:51:26');
INSERT INTO `sys_logininfor` VALUES (1501, 'test', NULL, '中国 广东 广州', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-26 10:12:56');
INSERT INTO `sys_logininfor` VALUES (1502, 'test', NULL, '中国 广东 广州', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-26 10:13:01');
INSERT INTO `sys_logininfor` VALUES (1503, 'test', NULL, 'XX XX', 'Firefox', 'Windows 7', '1', '登录成功', '2019-02-26 11:14:46');
INSERT INTO `sys_logininfor` VALUES (1504, 'test', NULL, 'XX XX', 'Firefox', 'Windows 7', '1', '退出成功', '2019-02-26 11:15:40');
INSERT INTO `sys_logininfor` VALUES (1505, 'test', NULL, 'XX XX', 'Firefox', 'Windows 7', '1', '登录成功', '2019-02-26 11:15:46');
INSERT INTO `sys_logininfor` VALUES (1506, 'test', NULL, '中国 北京 北京', 'Firefox', 'Windows 7', '1', '退出成功', '2019-02-26 11:16:48');
INSERT INTO `sys_logininfor` VALUES (1507, 'test', NULL, '中国 浙江 杭州', 'Mobile Safari', 'Mac OS X (iPhone)', '1', '登录成功', '2019-02-27 08:14:20');
INSERT INTO `sys_logininfor` VALUES (1508, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-27 13:47:17');
INSERT INTO `sys_logininfor` VALUES (1509, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-27 13:49:32');
INSERT INTO `sys_logininfor` VALUES (1510, 'admin', NULL, '中国 福建 福州', 'Chrome', 'Windows 7', '0', '用户不存在/密码错误，请重新输入', '2019-02-27 16:49:58');
INSERT INTO `sys_logininfor` VALUES (1511, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-02-28 10:39:59');
INSERT INTO `sys_logininfor` VALUES (1512, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '1', '登录成功', '2019-02-28 10:40:20');
INSERT INTO `sys_logininfor` VALUES (1513, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '1', '退出成功', '2019-02-28 10:40:45');
INSERT INTO `sys_logininfor` VALUES (1514, 'test', NULL, '中国 安徽 合肥', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-02-28 22:37:35');
INSERT INTO `sys_logininfor` VALUES (1515, 'test', NULL, '中国 安徽 合肥', 'Chrome', 'Windows 10', '1', '登录成功', '2019-02-28 22:37:41');
INSERT INTO `sys_logininfor` VALUES (1516, 'test', NULL, 'XX XX', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-03-01 09:33:23');
INSERT INTO `sys_logininfor` VALUES (1517, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-01 09:53:19');
INSERT INTO `sys_logininfor` VALUES (1518, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-01 10:56:00');
INSERT INTO `sys_logininfor` VALUES (1519, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-01 10:56:17');
INSERT INTO `sys_logininfor` VALUES (1520, 'test', NULL, '中国 江苏 苏州', 'Chrome Mobile', 'Android Mobile', '1', '登录成功', '2019-03-01 12:46:03');
INSERT INTO `sys_logininfor` VALUES (1521, 'test', NULL, 'XX XX', 'Chrome Mobile', 'Android Mobile', '1', '退出成功', '2019-03-01 12:46:47');
INSERT INTO `sys_logininfor` VALUES (1522, 'test', NULL, 'XX XX', 'Chrome Mobile', 'Android Mobile', '0', '验证码错误，请重新输入', '2019-03-01 12:47:51');
INSERT INTO `sys_logininfor` VALUES (1523, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-01 22:44:01');
INSERT INTO `sys_logininfor` VALUES (1524, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-03-02 15:35:51');
INSERT INTO `sys_logininfor` VALUES (1525, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-02 15:36:14');
INSERT INTO `sys_logininfor` VALUES (1526, 'admin', NULL, '中国 广东 惠州', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-03 17:15:18');
INSERT INTO `sys_logininfor` VALUES (1527, 'admin', NULL, '中国 广东 惠州', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-03 17:15:23');
INSERT INTO `sys_logininfor` VALUES (1528, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-03 17:28:21');
INSERT INTO `sys_logininfor` VALUES (1529, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-03 17:41:58');
INSERT INTO `sys_logininfor` VALUES (1530, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-03-03 17:42:08');
INSERT INTO `sys_logininfor` VALUES (1531, 'test', NULL, '中国 上海 上海', 'Chrome Mobile', 'Android 6.x', '0', '验证码错误，请重新输入', '2019-03-04 10:40:50');
INSERT INTO `sys_logininfor` VALUES (1532, 'test', NULL, '中国 上海 上海', 'Chrome Mobile', 'Android 6.x', '1', '登录成功', '2019-03-04 10:40:58');
INSERT INTO `sys_logininfor` VALUES (1533, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-04 14:31:54');
INSERT INTO `sys_logininfor` VALUES (1534, 'test', NULL, '中国 上海 上海', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-04 14:31:58');
INSERT INTO `sys_logininfor` VALUES (1535, 'test', NULL, '中国 上海 上海', 'Chrome', 'Windows 10', '1', '退出成功', '2019-03-04 14:40:03');
INSERT INTO `sys_logininfor` VALUES (1536, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-04 14:45:21');
INSERT INTO `sys_logininfor` VALUES (1537, 'jm.wong', NULL, 'XX XX', 'Chrome', 'Mac OS X', '0', '用户不存在/密码错误，请重新输入', '2019-03-05 10:47:14');
INSERT INTO `sys_logininfor` VALUES (1538, 'jm.wong', NULL, '中国 广东 广州', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-03-05 10:47:19');
INSERT INTO `sys_logininfor` VALUES (1539, 'jm.wong', NULL, '中国 广东 广州', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-03-05 10:47:20');
INSERT INTO `sys_logininfor` VALUES (1540, 'test', NULL, '中国 浙江 杭州', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-05 11:16:59');
INSERT INTO `sys_logininfor` VALUES (1541, 'test', NULL, '中国 浙江 杭州', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-05 11:17:03');
INSERT INTO `sys_logininfor` VALUES (1542, 'test', NULL, '中国 上海 上海', 'Safari', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-03-06 10:02:46');
INSERT INTO `sys_logininfor` VALUES (1543, 'test', NULL, '中国 上海 上海', 'Safari', 'Mac OS X', '1', '登录成功', '2019-03-06 10:02:50');
INSERT INTO `sys_logininfor` VALUES (1544, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-06 12:38:01');
INSERT INTO `sys_logininfor` VALUES (1545, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-06 18:01:36');
INSERT INTO `sys_logininfor` VALUES (1546, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-06 18:01:39');
INSERT INTO `sys_logininfor` VALUES (1547, 'test', NULL, '中国 北京 北京', 'Chrome Mobile', 'Android Mobile', '0', '验证码错误，请重新输入', '2019-03-06 22:08:18');
INSERT INTO `sys_logininfor` VALUES (1548, 'test', NULL, '中国 北京 北京', 'Chrome Mobile', 'Android Mobile', '1', '登录成功', '2019-03-06 22:08:24');
INSERT INTO `sys_logininfor` VALUES (1549, NULL, NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-06 23:31:36');
INSERT INTO `sys_logininfor` VALUES (1550, 'admin', NULL, '中国 福建 福州', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-06 23:46:25');
INSERT INTO `sys_logininfor` VALUES (1551, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-07 10:30:28');
INSERT INTO `sys_logininfor` VALUES (1552, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '退出成功', '2019-03-07 10:32:29');
INSERT INTO `sys_logininfor` VALUES (1553, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-07 10:32:52');
INSERT INTO `sys_logininfor` VALUES (1554, 'admin', NULL, 'XX XX', 'Internet Explorer 11', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-07 10:33:51');
INSERT INTO `sys_logininfor` VALUES (1555, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-07 10:33:55');
INSERT INTO `sys_logininfor` VALUES (1556, 'admin', NULL, '中国 广东 深圳', 'Internet Explorer 11', 'Windows 10', '1', '登录成功', '2019-03-07 10:34:01');
INSERT INTO `sys_logininfor` VALUES (1557, 'admin', NULL, '中国 福建 福州', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-07 13:03:20');
INSERT INTO `sys_logininfor` VALUES (1558, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-07 20:51:10');
INSERT INTO `sys_logininfor` VALUES (1559, 'admin', NULL, '中国 四川 绵阳', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-07 20:51:14');
INSERT INTO `sys_logininfor` VALUES (1560, 'admin', NULL, '中国 福建 福州', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-07 23:44:19');
INSERT INTO `sys_logininfor` VALUES (1561, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-08 09:48:03');
INSERT INTO `sys_logininfor` VALUES (1562, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-08 09:48:09');
INSERT INTO `sys_logininfor` VALUES (1563, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-08 09:48:14');
INSERT INTO `sys_logininfor` VALUES (1564, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-08 10:18:56');
INSERT INTO `sys_logininfor` VALUES (1565, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-08 10:52:59');
INSERT INTO `sys_logininfor` VALUES (1566, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-08 11:25:33');
INSERT INTO `sys_logininfor` VALUES (1567, 'admin', NULL, '中国 浙江 杭州', 'Firefox', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-08 11:58:22');
INSERT INTO `sys_logininfor` VALUES (1568, 'admin', NULL, '中国 浙江 杭州', 'Firefox', 'Windows 10', '1', '登录成功', '2019-03-08 11:58:29');
INSERT INTO `sys_logininfor` VALUES (1569, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-03-08 13:13:21');
INSERT INTO `sys_logininfor` VALUES (1570, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-08 13:15:06');
INSERT INTO `sys_logininfor` VALUES (1571, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-08 15:51:42');
INSERT INTO `sys_logininfor` VALUES (1572, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-08 18:40:00');
INSERT INTO `sys_logininfor` VALUES (1573, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-03-08 18:40:09');
INSERT INTO `sys_logininfor` VALUES (1574, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-08 18:40:15');
INSERT INTO `sys_logininfor` VALUES (1575, 'test', NULL, '中国 广东 深圳', 'Chrome Mobile', 'Android Mobile', '1', '登录成功', '2019-03-09 01:53:23');
INSERT INTO `sys_logininfor` VALUES (1576, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-09 14:56:05');
INSERT INTO `sys_logininfor` VALUES (1577, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-09 14:56:08');
INSERT INTO `sys_logininfor` VALUES (1578, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-09 16:09:56');
INSERT INTO `sys_logininfor` VALUES (1579, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-09 16:12:27');
INSERT INTO `sys_logininfor` VALUES (1580, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-09 16:45:57');
INSERT INTO `sys_logininfor` VALUES (1581, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-09 17:30:55');
INSERT INTO `sys_logininfor` VALUES (1582, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-09 23:41:09');
INSERT INTO `sys_logininfor` VALUES (1583, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-09 23:41:41');
INSERT INTO `sys_logininfor` VALUES (1584, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-09 23:41:45');
INSERT INTO `sys_logininfor` VALUES (1585, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-10 02:25:17');
INSERT INTO `sys_logininfor` VALUES (1586, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-10 12:34:24');
INSERT INTO `sys_logininfor` VALUES (1587, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-10 13:21:05');
INSERT INTO `sys_logininfor` VALUES (1588, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-10 13:22:39');
INSERT INTO `sys_logininfor` VALUES (1589, 'root', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-03-10 14:58:07');
INSERT INTO `sys_logininfor` VALUES (1590, 'test', NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-10 16:56:30');
INSERT INTO `sys_logininfor` VALUES (1591, 'test', NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-10 16:56:31');
INSERT INTO `sys_logininfor` VALUES (1592, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '退出成功', '2019-03-10 16:58:23');
INSERT INTO `sys_logininfor` VALUES (1593, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-10 20:25:47');
INSERT INTO `sys_logininfor` VALUES (1594, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-10 20:25:49');
INSERT INTO `sys_logininfor` VALUES (1595, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-10 20:25:54');
INSERT INTO `sys_logininfor` VALUES (1596, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-11 09:58:55');
INSERT INTO `sys_logininfor` VALUES (1597, NULL, NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-11 10:35:47');
INSERT INTO `sys_logininfor` VALUES (1598, 'test', NULL, '中国 安徽 合肥', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-11 13:59:05');
INSERT INTO `sys_logininfor` VALUES (1599, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-11 13:59:27');
INSERT INTO `sys_logininfor` VALUES (1600, 'test', NULL, '中国 湖北 武汉', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-03-11 15:08:17');
INSERT INTO `sys_logininfor` VALUES (1601, 'test', NULL, 'XX XX', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-03-11 15:08:26');
INSERT INTO `sys_logininfor` VALUES (1602, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-11 17:54:26');
INSERT INTO `sys_logininfor` VALUES (1603, 'test', NULL, '中国 安徽 合肥', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-11 20:43:12');
INSERT INTO `sys_logininfor` VALUES (1604, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-11 21:23:51');
INSERT INTO `sys_logininfor` VALUES (1605, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-11 21:26:06');
INSERT INTO `sys_logininfor` VALUES (1606, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-12 16:00:18');
INSERT INTO `sys_logininfor` VALUES (1607, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-12 17:59:57');
INSERT INTO `sys_logininfor` VALUES (1608, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-13 08:43:10');
INSERT INTO `sys_logininfor` VALUES (1609, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-13 08:43:16');
INSERT INTO `sys_logininfor` VALUES (1610, 'test', NULL, '中国 安徽 合肥', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-13 12:04:51');
INSERT INTO `sys_logininfor` VALUES (1611, 'admin', NULL, '中国 江苏 苏州', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-13 17:48:13');
INSERT INTO `sys_logininfor` VALUES (1612, 'admin', NULL, '中国 江苏 苏州', 'Chrome', 'Windows 10', '1', '退出成功', '2019-03-13 17:51:22');
INSERT INTO `sys_logininfor` VALUES (1613, 'test', NULL, '中国 安徽 合肥', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-13 21:06:02');
INSERT INTO `sys_logininfor` VALUES (1614, 'test', NULL, '中国 安徽 合肥', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-13 21:06:08');
INSERT INTO `sys_logininfor` VALUES (1615, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-14 10:12:34');
INSERT INTO `sys_logininfor` VALUES (1616, 'admin', NULL, 'XX XX', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-03-14 18:04:54');
INSERT INTO `sys_logininfor` VALUES (1617, 'admin', NULL, '中国 浙江 杭州', 'Chrome', 'Mac OS X', '0', '用户不存在/密码错误，请重新输入', '2019-03-14 18:05:02');
INSERT INTO `sys_logininfor` VALUES (1618, 'admin', NULL, '中国 湖北 武汉', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-14 21:52:05');
INSERT INTO `sys_logininfor` VALUES (1619, 'admin', NULL, '中国 湖北 武汉', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-14 21:52:10');
INSERT INTO `sys_logininfor` VALUES (1620, 'admin', NULL, 'XX XX', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-03-15 12:53:01');
INSERT INTO `sys_logininfor` VALUES (1621, 'test', NULL, 'XX XX', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-03-15 23:31:50');
INSERT INTO `sys_logininfor` VALUES (1622, 'test', NULL, '中国 陕西 西安', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-03-15 23:48:02');
INSERT INTO `sys_logininfor` VALUES (1623, 'test', NULL, '中国 广东 广州', 'Firefox', 'Windows 10', '1', '登录成功', '2019-03-16 00:51:27');
INSERT INTO `sys_logininfor` VALUES (1624, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-16 13:18:41');
INSERT INTO `sys_logininfor` VALUES (1625, 'test', NULL, '中国 安徽 XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-16 16:09:32');
INSERT INTO `sys_logininfor` VALUES (1626, 'test', NULL, '中国 安徽 XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-16 16:09:40');
INSERT INTO `sys_logininfor` VALUES (1627, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-16 16:26:59');
INSERT INTO `sys_logininfor` VALUES (1628, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-16 18:05:32');
INSERT INTO `sys_logininfor` VALUES (1629, 'test', NULL, '中国 安徽 合肥', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-16 19:59:31');
INSERT INTO `sys_logininfor` VALUES (1630, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-16 21:34:18');
INSERT INTO `sys_logininfor` VALUES (1631, 'test', NULL, 'XX XX', 'Firefox', 'Windows 10', '1', '登录成功', '2019-03-16 22:03:26');
INSERT INTO `sys_logininfor` VALUES (1632, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-16 22:25:14');
INSERT INTO `sys_logininfor` VALUES (1633, 'test', NULL, 'XX XX', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-03-16 22:25:58');
INSERT INTO `sys_logininfor` VALUES (1634, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-17 10:57:58');
INSERT INTO `sys_logininfor` VALUES (1635, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-03-17 11:37:05');
INSERT INTO `sys_logininfor` VALUES (1636, 'test', NULL, '中国 重庆 重庆', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-17 11:52:57');
INSERT INTO `sys_logininfor` VALUES (1637, 'test', NULL, '中国 重庆 重庆', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-17 11:53:14');
INSERT INTO `sys_logininfor` VALUES (1638, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-17 11:58:52');
INSERT INTO `sys_logininfor` VALUES (1639, 'admin', NULL, '中国 广西 河池', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-17 14:24:54');
INSERT INTO `sys_logininfor` VALUES (1640, 'admin', NULL, '中国 广西 河池', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-17 16:34:57');
INSERT INTO `sys_logininfor` VALUES (1641, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-03-17 16:58:59');
INSERT INTO `sys_logininfor` VALUES (1642, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-17 17:02:45');
INSERT INTO `sys_logininfor` VALUES (1643, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-17 20:34:54');
INSERT INTO `sys_logininfor` VALUES (1644, 'admin', NULL, '中国 广西 河池', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-17 21:23:26');
INSERT INTO `sys_logininfor` VALUES (1645, 'admin', NULL, '中国 广西 河池', 'Chrome', 'Windows 10', '1', '退出成功', '2019-03-17 21:23:35');
INSERT INTO `sys_logininfor` VALUES (1646, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-17 21:24:34');
INSERT INTO `sys_logininfor` VALUES (1647, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-17 22:29:49');
INSERT INTO `sys_logininfor` VALUES (1648, 'test', NULL, '中国 重庆 重庆', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-18 09:24:43');
INSERT INTO `sys_logininfor` VALUES (1649, 'admin', NULL, 'XX XX', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-03-18 12:24:09');
INSERT INTO `sys_logininfor` VALUES (1650, 'admin', NULL, '中国 北京 北京', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-03-18 12:24:12');
INSERT INTO `sys_logininfor` VALUES (1651, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-18 20:01:46');
INSERT INTO `sys_logininfor` VALUES (1652, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-18 20:01:50');
INSERT INTO `sys_logininfor` VALUES (1653, 'test', NULL, '中国 上海 上海', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-03-19 02:02:12');
INSERT INTO `sys_logininfor` VALUES (1654, 'test', NULL, '中国 上海 上海', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-19 02:02:24');
INSERT INTO `sys_logininfor` VALUES (1655, 'test', NULL, '中国 北京 北京', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-03-19 15:35:51');
INSERT INTO `sys_logininfor` VALUES (1656, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-19 15:51:57');
INSERT INTO `sys_logininfor` VALUES (1657, 'test', NULL, '中国 江苏 常州', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-19 16:01:13');
INSERT INTO `sys_logininfor` VALUES (1658, 'test', NULL, '中国 江苏 常州', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-19 16:01:21');
INSERT INTO `sys_logininfor` VALUES (1659, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-19 17:50:05');
INSERT INTO `sys_logininfor` VALUES (1660, 'test', NULL, '中国 北京 北京', 'Chrome', 'Windows 10', '1', '退出成功', '2019-03-19 17:51:11');
INSERT INTO `sys_logininfor` VALUES (1661, NULL, NULL, '中国 宁夏 银川', 'Chrome', 'Windows 8.1', '0', '验证码错误，请重新输入', '2019-03-20 09:04:23');
INSERT INTO `sys_logininfor` VALUES (1662, NULL, NULL, '中国 宁夏 银川', 'Chrome', 'Windows 8.1', '0', '用户不存在/密码错误，请重新输入', '2019-03-20 09:04:26');
INSERT INTO `sys_logininfor` VALUES (1663, '范甘迪', NULL, 'XX XX', 'Chrome', 'Windows 8.1', '0', '验证码错误，请重新输入', '2019-03-20 09:04:34');
INSERT INTO `sys_logininfor` VALUES (1664, '范甘迪', NULL, '中国 宁夏 银川', 'Chrome', 'Windows 8.1', '0', '验证码错误，请重新输入', '2019-03-20 09:04:37');
INSERT INTO `sys_logininfor` VALUES (1665, NULL, NULL, 'XX XX', 'Chrome', 'Windows 8.1', '0', '验证码错误，请重新输入', '2019-03-20 09:04:48');
INSERT INTO `sys_logininfor` VALUES (1666, '范甘迪', NULL, 'XX XX', 'Chrome', 'Windows 8.1', '0', '用户不存在/密码错误，请重新输入', '2019-03-20 09:05:13');
INSERT INTO `sys_logininfor` VALUES (1667, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-20 17:30:50');
INSERT INTO `sys_logininfor` VALUES (1668, 'test', NULL, '中国 江西 南昌', 'Chrome', 'Windows 10', '1', '退出成功', '2019-03-20 17:46:48');
INSERT INTO `sys_logininfor` VALUES (1669, 'test', NULL, '中国 江西 南昌', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-20 17:46:48');
INSERT INTO `sys_logininfor` VALUES (1670, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-20 18:02:42');
INSERT INTO `sys_logininfor` VALUES (1671, 'test', NULL, 'XX XX', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-03-20 19:06:29');
INSERT INTO `sys_logininfor` VALUES (1672, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-20 19:19:53');
INSERT INTO `sys_logininfor` VALUES (1673, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-20 19:21:07');
INSERT INTO `sys_logininfor` VALUES (1674, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-21 12:13:05');
INSERT INTO `sys_logininfor` VALUES (1675, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-03-22 15:52:21');
INSERT INTO `sys_logininfor` VALUES (1676, 'admin', NULL, '日本 XX XX', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-22 15:52:28');
INSERT INTO `sys_logininfor` VALUES (1677, 'test', NULL, 'XX XX', 'Chrome', 'Mac OS X', '1', '登录成功', '2019-03-22 16:31:19');
INSERT INTO `sys_logininfor` VALUES (1678, 'test', NULL, 'XX XX', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-03-22 16:31:21');
INSERT INTO `sys_logininfor` VALUES (1679, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-22 17:15:45');
INSERT INTO `sys_logininfor` VALUES (1680, NULL, NULL, 'XX XX', 'Safari', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-03-22 22:30:23');
INSERT INTO `sys_logininfor` VALUES (1681, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-23 13:01:01');
INSERT INTO `sys_logininfor` VALUES (1682, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-24 13:30:05');
INSERT INTO `sys_logininfor` VALUES (1683, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-24 13:30:09');
INSERT INTO `sys_logininfor` VALUES (1684, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-24 14:32:39');
INSERT INTO `sys_logininfor` VALUES (1685, 'test', NULL, 'XX XX', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-03-24 14:57:40');
INSERT INTO `sys_logininfor` VALUES (1686, 'test', NULL, 'XX XX', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-24 14:57:50');
INSERT INTO `sys_logininfor` VALUES (1687, 'test', NULL, 'XX XX', 'Chrome', 'Windows 7', '1', '退出成功', '2019-03-24 15:00:04');
INSERT INTO `sys_logininfor` VALUES (1688, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-24 15:17:44');
INSERT INTO `sys_logininfor` VALUES (1689, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-24 16:26:20');
INSERT INTO `sys_logininfor` VALUES (1690, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-24 16:49:43');
INSERT INTO `sys_logininfor` VALUES (1691, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-24 17:07:13');
INSERT INTO `sys_logininfor` VALUES (1692, 'test', NULL, 'XX XX', 'Chrome Mobile', 'Android Mobile', '0', '验证码错误，请重新输入', '2019-03-25 08:43:53');
INSERT INTO `sys_logininfor` VALUES (1693, 'admin', NULL, 'XX XX', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-25 08:50:01');
INSERT INTO `sys_logininfor` VALUES (1694, 'test', NULL, 'XX XX', 'Chrome Mobile', 'Android Mobile', '1', '登录成功', '2019-03-25 08:59:53');
INSERT INTO `sys_logininfor` VALUES (1695, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-25 22:08:58');
INSERT INTO `sys_logininfor` VALUES (1696, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-26 07:42:55');
INSERT INTO `sys_logininfor` VALUES (1697, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-26 11:08:55');
INSERT INTO `sys_logininfor` VALUES (1698, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-26 11:09:00');
INSERT INTO `sys_logininfor` VALUES (1699, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-26 12:12:01');
INSERT INTO `sys_logininfor` VALUES (1700, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-26 17:22:20');
INSERT INTO `sys_logininfor` VALUES (1701, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-26 17:56:36');
INSERT INTO `sys_logininfor` VALUES (1702, 'admin', NULL, '中国 吉林 长春', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-27 15:03:42');
INSERT INTO `sys_logininfor` VALUES (1703, 'test', NULL, 'XX XX', 'Apple WebKit', 'Mac OS X (iPad)', '1', '登录成功', '2019-03-27 22:15:03');
INSERT INTO `sys_logininfor` VALUES (1704, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-28 09:57:28');
INSERT INTO `sys_logininfor` VALUES (1705, 'test', NULL, '中国 湖南 长沙', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-28 10:36:23');
INSERT INTO `sys_logininfor` VALUES (1706, 'test', NULL, '中国 广东 广州', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-28 10:40:06');
INSERT INTO `sys_logininfor` VALUES (1707, 'test', NULL, '中国 广东 广州', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-28 10:40:09');
INSERT INTO `sys_logininfor` VALUES (1708, 'test', NULL, '中国 上海 上海', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-03-29 10:47:09');
INSERT INTO `sys_logininfor` VALUES (1709, 'test', NULL, '中国 上海 上海', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-29 10:47:13');
INSERT INTO `sys_logininfor` VALUES (1710, NULL, NULL, '中国 陕西 西安', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-03-29 22:32:34');
INSERT INTO `sys_logininfor` VALUES (1711, NULL, NULL, '中国 陕西 西安', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-03-29 22:32:34');
INSERT INTO `sys_logininfor` VALUES (1712, NULL, NULL, '中国 陕西 西安', 'Chrome', 'Windows 7', '0', '用户不存在/密码错误，请重新输入', '2019-03-29 22:32:39');
INSERT INTO `sys_logininfor` VALUES (1713, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-03-30 01:14:56');
INSERT INTO `sys_logininfor` VALUES (1714, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '0', '用户不存在/密码错误，请重新输入', '2019-03-30 01:15:01');
INSERT INTO `sys_logininfor` VALUES (1715, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-30 01:15:15');
INSERT INTO `sys_logininfor` VALUES (1716, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-30 08:34:07');
INSERT INTO `sys_logininfor` VALUES (1717, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-30 08:34:12');
INSERT INTO `sys_logininfor` VALUES (1718, 'admin', NULL, '中国 广东 深圳', 'Chrome', 'Mac OS X', '0', '验证码错误，请重新输入', '2019-03-30 11:48:47');
INSERT INTO `sys_logininfor` VALUES (1719, 'test', NULL, '中国 广东 深圳', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-03-30 14:02:22');
INSERT INTO `sys_logininfor` VALUES (1720, 'test', NULL, '中国 广东 深圳', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-30 14:02:38');
INSERT INTO `sys_logininfor` VALUES (1721, 'test', NULL, '中国 广东 惠州', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-30 14:17:27');
INSERT INTO `sys_logininfor` VALUES (1722, 'test', NULL, '中国 广东 惠州', 'Chrome', 'Windows 10', '1', '退出成功', '2019-03-30 14:19:09');
INSERT INTO `sys_logininfor` VALUES (1723, NULL, NULL, '中国 福建 福州', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-03-30 17:09:37');
INSERT INTO `sys_logininfor` VALUES (1724, 'admin', NULL, '中国 福建 福州', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-30 17:33:53');
INSERT INTO `sys_logininfor` VALUES (1725, 'TEST', NULL, '中国 山东 德州', 'Chrome', 'Windows 7', '0', '验证码错误，请重新输入', '2019-03-31 09:43:22');
INSERT INTO `sys_logininfor` VALUES (1726, 'TEST', NULL, '中国 山东 德州', 'Chrome', 'Windows 7', '1', '登录成功', '2019-03-31 09:43:26');
INSERT INTO `sys_logininfor` VALUES (1727, 'admin', NULL, '中国 福建 福州', 'Chrome', 'Windows 10', '1', '登录成功', '2019-03-31 12:53:57');
INSERT INTO `sys_logininfor` VALUES (1728, 'test', NULL, '中国 四川 绵阳', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-04-01 16:12:40');
INSERT INTO `sys_logininfor` VALUES (1729, 'test', NULL, '中国 四川 绵阳', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-04-01 16:12:44');
INSERT INTO `sys_logininfor` VALUES (1730, 'test', NULL, '中国 四川 绵阳', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-04-01 16:12:48');
INSERT INTO `sys_logininfor` VALUES (1731, 'test', NULL, 'XX XX', 'Chrome', 'Windows 10', '1', '登录成功', '2019-04-01 16:12:56');
INSERT INTO `sys_logininfor` VALUES (1732, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-04-01 17:35:22');
INSERT INTO `sys_logininfor` VALUES (1733, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '用户不存在/密码错误，请重新输入', '2019-04-01 17:35:26');
INSERT INTO `sys_logininfor` VALUES (1734, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-04-01 17:35:34');
INSERT INTO `sys_logininfor` VALUES (1735, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-04-02 10:37:42');
INSERT INTO `sys_logininfor` VALUES (1736, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-04-02 10:37:48');
INSERT INTO `sys_logininfor` VALUES (1737, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-04-02 15:13:50');
INSERT INTO `sys_logininfor` VALUES (1738, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-04-02 15:13:55');
INSERT INTO `sys_logininfor` VALUES (1739, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-04-02 21:04:58');
INSERT INTO `sys_logininfor` VALUES (1740, 'admin', NULL, '中国 福建 福州', 'Chrome', 'Windows 10', '1', '登录成功', '2019-04-02 23:00:41');
INSERT INTO `sys_logininfor` VALUES (1741, 'admin', NULL, '中国 山东 济南', 'Chrome', 'Windows 10', '1', '登录成功', '2019-04-03 10:25:50');
INSERT INTO `sys_logininfor` VALUES (1742, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-04-03 11:26:09');
INSERT INTO `sys_logininfor` VALUES (1743, 'test', NULL, '中国 辽宁 沈阳', 'Chrome', 'Windows 7', '1', '登录成功', '2019-04-03 11:52:27');
INSERT INTO `sys_logininfor` VALUES (1744, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-04-03 12:04:43');
INSERT INTO `sys_logininfor` VALUES (1745, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-04-03 12:04:49');
INSERT INTO `sys_logininfor` VALUES (1746, 'Test', NULL, '中国 浙江 杭州', 'Apple WebKit', 'Mac OS X (iPhone)', '1', '登录成功', '2019-04-03 12:38:21');
INSERT INTO `sys_logininfor` VALUES (1747, 'Test', NULL, '中国 浙江 杭州', 'Apple WebKit', 'Mac OS X (iPhone)', '0', '验证码错误，请重新输入', '2019-04-03 12:42:14');
INSERT INTO `sys_logininfor` VALUES (1748, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-04-03 13:58:52');
INSERT INTO `sys_logininfor` VALUES (1749, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-04-03 16:17:23');
INSERT INTO `sys_logininfor` VALUES (1750, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-04-03 17:26:08');
INSERT INTO `sys_logininfor` VALUES (1751, 'admin', NULL, '中国 四川 成都', 'Chrome', 'Windows 10', '1', '登录成功', '2019-04-03 18:23:17');
INSERT INTO `sys_logininfor` VALUES (1752, 'admin', NULL, '中国 陕西 咸阳', 'Chrome', 'Windows 10', '0', '验证码错误，请重新输入', '2019-04-03 21:55:10');
INSERT INTO `sys_logininfor` VALUES (1753, 'admin', NULL, '中国 黑龙江 哈尔滨', 'Chrome 49', 'Windows 7', '1', '登录成功', '2019-04-04 17:00:03');
INSERT INTO `sys_logininfor` VALUES (1754, 'test', NULL, '中国 上海 上海', 'Chrome Mobile', 'Android Mobile', '0', '验证码错误，请重新输入', '2019-04-05 02:38:51');
INSERT INTO `sys_logininfor` VALUES (1755, 'test', NULL, '中国 上海 上海', 'Chrome Mobile', 'Android Mobile', '1', '登录成功', '2019-04-05 02:38:56');
INSERT INTO `sys_logininfor` VALUES (1756, 'admin', '119.130.106.15', '广东 广州', 'Chrome', 'Windows 10', '1', '密码输入错误1次', '2019-04-09 11:25:08');
INSERT INTO `sys_logininfor` VALUES (1757, 'admin', '119.130.106.15', '广东 广州', 'Chrome', 'Windows 10', '1', '密码输入错误2次', '2019-04-09 11:25:15');
INSERT INTO `sys_logininfor` VALUES (1758, 'admin', '119.130.106.15', '广东 广州', 'Chrome', 'Windows 10', '1', '密码输入错误3次', '2019-04-09 11:25:21');
INSERT INTO `sys_logininfor` VALUES (1759, 'admin', '119.130.106.15', '广东 广州', 'Chrome', 'Windows 10', '1', '密码输入错误4次', '2019-04-09 11:25:57');
INSERT INTO `sys_logininfor` VALUES (1760, 'admin', '127.0.0.1', '内网IP', 'Firefox', 'Windows 7', '1', '密码输入错误1次', '2019-04-23 23:20:01');
INSERT INTO `sys_logininfor` VALUES (1761, 'Dimple', '127.0.0.1', '内网IP', 'Firefox', 'Windows 7', '1', '对不起，您的账号已被删除', '2019-04-23 23:22:35');
INSERT INTO `sys_logininfor` VALUES (1762, 'admin', '127.0.0.1', '内网IP', 'Firefox', 'Windows 7', '1', '密码输入错误2次', '2019-04-23 23:24:09');
INSERT INTO `sys_logininfor` VALUES (1763, 'admin', '127.0.0.1', '内网IP', 'Firefox', 'Windows 7', '1', '密码输入错误3次', '2019-04-23 23:24:16');
INSERT INTO `sys_logininfor` VALUES (1764, 'admin', '127.0.0.1', '内网IP', 'Firefox', 'Windows 7', '1', '验证码错误', '2019-04-23 23:24:45');
INSERT INTO `sys_logininfor` VALUES (1765, 'admin', '127.0.0.1', '内网IP', 'Firefox', 'Windows 7', '1', '密码输入错误4次', '2019-04-23 23:24:50');
INSERT INTO `sys_logininfor` VALUES (1766, 'admin', '127.0.0.1', '内网IP', 'Firefox', 'Windows 7', '1', '密码输入错误5次', '2019-04-23 23:25:58');
INSERT INTO `sys_logininfor` VALUES (1767, 'test', '127.0.0.1', '内网IP', 'Firefox', 'Windows 7', '1', '用户不存在/密码错误', '2019-04-23 23:26:14');
INSERT INTO `sys_logininfor` VALUES (1768, 'admin', '127.0.0.1', '内网IP', 'Firefox', 'Windows 7', '1', '密码输入错误5次，帐户锁定10分钟', '2019-04-23 23:26:59');
INSERT INTO `sys_logininfor` VALUES (1769, 'admin', '127.0.0.1', '内网IP', 'Firefox', 'Windows 7', '1', '密码输入错误5次，帐户锁定10分钟', '2019-04-23 23:27:25');
INSERT INTO `sys_logininfor` VALUES (1770, 'admin', '127.0.0.1', '内网IP', 'Firefox', 'Windows 7', '0', '登录成功', '2019-04-23 23:33:16');
INSERT INTO `sys_logininfor` VALUES (1771, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2019-06-19 16:46:08');
INSERT INTO `sys_logininfor` VALUES (1772, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-19 16:46:13');
INSERT INTO `sys_logininfor` VALUES (1773, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-19 16:51:02');
INSERT INTO `sys_logininfor` VALUES (1774, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-19 16:54:28');
INSERT INTO `sys_logininfor` VALUES (1775, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-19 16:56:53');
INSERT INTO `sys_logininfor` VALUES (1776, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-19 22:35:01');
INSERT INTO `sys_logininfor` VALUES (1777, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-19 23:10:05');
INSERT INTO `sys_logininfor` VALUES (1778, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-20 11:42:15');
INSERT INTO `sys_logininfor` VALUES (1779, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-20 11:54:36');
INSERT INTO `sys_logininfor` VALUES (1780, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-20 13:38:57');
INSERT INTO `sys_logininfor` VALUES (1781, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-20 15:59:48');
INSERT INTO `sys_logininfor` VALUES (1782, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-20 16:13:37');
INSERT INTO `sys_logininfor` VALUES (1783, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-21 13:56:10');
INSERT INTO `sys_logininfor` VALUES (1784, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2019-06-21 14:43:14');
INSERT INTO `sys_logininfor` VALUES (1785, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-21 14:43:17');
INSERT INTO `sys_logininfor` VALUES (1786, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-21 14:47:03');
INSERT INTO `sys_logininfor` VALUES (1787, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-21 14:58:39');
INSERT INTO `sys_logininfor` VALUES (1788, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-22 21:58:46');
INSERT INTO `sys_logininfor` VALUES (1789, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-22 22:56:16');
INSERT INTO `sys_logininfor` VALUES (1790, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2019-06-22 23:03:13');
INSERT INTO `sys_logininfor` VALUES (1791, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-22 23:03:16');
INSERT INTO `sys_logininfor` VALUES (1792, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-22 23:13:26');
INSERT INTO `sys_logininfor` VALUES (1793, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-24 17:42:16');
INSERT INTO `sys_logininfor` VALUES (1794, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2019-06-24 22:47:25');
INSERT INTO `sys_logininfor` VALUES (1795, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-24 22:47:28');
INSERT INTO `sys_logininfor` VALUES (1796, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-25 12:43:57');
INSERT INTO `sys_logininfor` VALUES (1797, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-25 22:58:26');
INSERT INTO `sys_logininfor` VALUES (1798, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-28 14:15:43');
INSERT INTO `sys_logininfor` VALUES (1799, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-28 16:20:46');
INSERT INTO `sys_logininfor` VALUES (1800, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-28 16:44:26');
INSERT INTO `sys_logininfor` VALUES (1801, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-28 16:52:59');
INSERT INTO `sys_logininfor` VALUES (1802, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-06-28 17:08:56');
INSERT INTO `sys_logininfor` VALUES (1803, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-01 17:56:24');
INSERT INTO `sys_logininfor` VALUES (1804, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-02 17:19:01');
INSERT INTO `sys_logininfor` VALUES (1805, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-02 22:18:37');
INSERT INTO `sys_logininfor` VALUES (1806, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-02 22:34:30');
INSERT INTO `sys_logininfor` VALUES (1807, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-02 22:46:00');
INSERT INTO `sys_logininfor` VALUES (1808, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-02 23:26:08');
INSERT INTO `sys_logininfor` VALUES (1809, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-02 23:36:46');
INSERT INTO `sys_logininfor` VALUES (1810, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-02 23:49:26');
INSERT INTO `sys_logininfor` VALUES (1811, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-02 23:54:34');
INSERT INTO `sys_logininfor` VALUES (1812, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-03 13:36:35');
INSERT INTO `sys_logininfor` VALUES (1813, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-03 13:50:08');
INSERT INTO `sys_logininfor` VALUES (1814, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-03 14:02:03');
INSERT INTO `sys_logininfor` VALUES (1815, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-03 21:55:45');
INSERT INTO `sys_logininfor` VALUES (1816, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-04 12:37:26');
INSERT INTO `sys_logininfor` VALUES (1817, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-04 15:37:11');
INSERT INTO `sys_logininfor` VALUES (1818, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-04 16:15:31');
INSERT INTO `sys_logininfor` VALUES (1819, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-04 17:11:19');
INSERT INTO `sys_logininfor` VALUES (1820, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-04 17:44:48');
INSERT INTO `sys_logininfor` VALUES (1821, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-04 17:57:42');
INSERT INTO `sys_logininfor` VALUES (1822, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-04 23:15:32');
INSERT INTO `sys_logininfor` VALUES (1823, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-05 11:59:19');
INSERT INTO `sys_logininfor` VALUES (1824, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-05 14:10:40');
INSERT INTO `sys_logininfor` VALUES (1825, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-05 14:55:49');
INSERT INTO `sys_logininfor` VALUES (1826, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-05 15:24:14');
INSERT INTO `sys_logininfor` VALUES (1827, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-05 15:53:56');
INSERT INTO `sys_logininfor` VALUES (1828, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-07 19:33:45');
INSERT INTO `sys_logininfor` VALUES (1829, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-07 19:38:54');
INSERT INTO `sys_logininfor` VALUES (1830, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-07 22:09:53');
INSERT INTO `sys_logininfor` VALUES (1831, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2019-07-08 14:42:41');
INSERT INTO `sys_logininfor` VALUES (1832, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-08 14:42:44');
INSERT INTO `sys_logininfor` VALUES (1833, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-08 14:52:48');
INSERT INTO `sys_logininfor` VALUES (1834, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-08 17:17:54');
INSERT INTO `sys_logininfor` VALUES (1835, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-08 17:43:33');
INSERT INTO `sys_logininfor` VALUES (1836, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2019-07-08 17:47:17');
INSERT INTO `sys_logininfor` VALUES (1837, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-08 17:47:21');
INSERT INTO `sys_logininfor` VALUES (1838, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-08 17:51:24');
INSERT INTO `sys_logininfor` VALUES (1839, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-08 21:17:57');
INSERT INTO `sys_logininfor` VALUES (1840, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2019-07-08 21:32:29');
INSERT INTO `sys_logininfor` VALUES (1841, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-08 21:32:32');
INSERT INTO `sys_logininfor` VALUES (1842, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-08 21:38:56');
INSERT INTO `sys_logininfor` VALUES (1843, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-08 22:24:58');
INSERT INTO `sys_logininfor` VALUES (1844, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-08 22:43:13');
INSERT INTO `sys_logininfor` VALUES (1845, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-08 23:09:49');
INSERT INTO `sys_logininfor` VALUES (1846, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-08 23:11:40');
INSERT INTO `sys_logininfor` VALUES (1847, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-09 11:41:38');
INSERT INTO `sys_logininfor` VALUES (1848, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-09 13:22:33');
INSERT INTO `sys_logininfor` VALUES (1849, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-09 15:36:54');
INSERT INTO `sys_logininfor` VALUES (1850, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-09 16:58:23');
INSERT INTO `sys_logininfor` VALUES (1851, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-09 22:55:28');
INSERT INTO `sys_logininfor` VALUES (1852, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-10 09:53:14');
INSERT INTO `sys_logininfor` VALUES (1853, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-10 13:51:34');
INSERT INTO `sys_logininfor` VALUES (1854, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-10 17:00:46');
INSERT INTO `sys_logininfor` VALUES (1855, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-10 22:09:46');
INSERT INTO `sys_logininfor` VALUES (1856, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-10 22:52:05');
INSERT INTO `sys_logininfor` VALUES (1857, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-11 22:20:52');
INSERT INTO `sys_logininfor` VALUES (1858, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-11 22:30:06');
INSERT INTO `sys_logininfor` VALUES (1859, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-11 23:16:28');
INSERT INTO `sys_logininfor` VALUES (1860, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-11 23:21:57');
INSERT INTO `sys_logininfor` VALUES (1861, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-11 23:31:40');
INSERT INTO `sys_logininfor` VALUES (1862, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-11 23:40:01');
INSERT INTO `sys_logininfor` VALUES (1863, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-11 23:41:15');
INSERT INTO `sys_logininfor` VALUES (1864, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-12 10:41:53');
INSERT INTO `sys_logininfor` VALUES (1865, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-12 10:53:11');
INSERT INTO `sys_logininfor` VALUES (1866, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-12 11:06:04');
INSERT INTO `sys_logininfor` VALUES (1867, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-12 11:09:15');
INSERT INTO `sys_logininfor` VALUES (1868, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-12 12:01:03');
INSERT INTO `sys_logininfor` VALUES (1869, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-12 13:15:29');
INSERT INTO `sys_logininfor` VALUES (1870, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-12 13:17:44');
INSERT INTO `sys_logininfor` VALUES (1871, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-12 13:26:14');
INSERT INTO `sys_logininfor` VALUES (1872, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-12 13:34:42');
INSERT INTO `sys_logininfor` VALUES (1873, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-12 13:36:21');
INSERT INTO `sys_logininfor` VALUES (1874, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-12 23:13:58');
INSERT INTO `sys_logininfor` VALUES (1875, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 00:08:04');
INSERT INTO `sys_logininfor` VALUES (1876, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 00:19:00');
INSERT INTO `sys_logininfor` VALUES (1877, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 00:23:53');
INSERT INTO `sys_logininfor` VALUES (1878, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 00:37:27');
INSERT INTO `sys_logininfor` VALUES (1879, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 00:44:55');
INSERT INTO `sys_logininfor` VALUES (1880, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 01:00:30');
INSERT INTO `sys_logininfor` VALUES (1881, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 01:11:14');
INSERT INTO `sys_logininfor` VALUES (1882, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 02:13:27');
INSERT INTO `sys_logininfor` VALUES (1883, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 02:35:45');
INSERT INTO `sys_logininfor` VALUES (1884, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 17:21:30');
INSERT INTO `sys_logininfor` VALUES (1885, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 20:59:08');
INSERT INTO `sys_logininfor` VALUES (1886, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 22:27:12');
INSERT INTO `sys_logininfor` VALUES (1887, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 23:14:42');
INSERT INTO `sys_logininfor` VALUES (1888, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 23:28:13');
INSERT INTO `sys_logininfor` VALUES (1889, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-13 23:29:32');
INSERT INTO `sys_logininfor` VALUES (1890, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 00:37:42');
INSERT INTO `sys_logininfor` VALUES (1891, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 00:44:35');
INSERT INTO `sys_logininfor` VALUES (1892, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 10:04:13');
INSERT INTO `sys_logininfor` VALUES (1893, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 11:04:26');
INSERT INTO `sys_logininfor` VALUES (1894, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 11:27:36');
INSERT INTO `sys_logininfor` VALUES (1895, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 12:03:05');
INSERT INTO `sys_logininfor` VALUES (1896, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 12:05:46');
INSERT INTO `sys_logininfor` VALUES (1897, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 12:10:36');
INSERT INTO `sys_logininfor` VALUES (1898, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 12:30:53');
INSERT INTO `sys_logininfor` VALUES (1899, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 15:00:32');
INSERT INTO `sys_logininfor` VALUES (1900, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 15:26:23');
INSERT INTO `sys_logininfor` VALUES (1901, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 16:10:04');
INSERT INTO `sys_logininfor` VALUES (1902, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 16:21:10');
INSERT INTO `sys_logininfor` VALUES (1903, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 22:15:24');
INSERT INTO `sys_logininfor` VALUES (1904, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 23:02:04');
INSERT INTO `sys_logininfor` VALUES (1905, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 23:07:54');
INSERT INTO `sys_logininfor` VALUES (1906, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 23:16:28');
INSERT INTO `sys_logininfor` VALUES (1907, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 23:18:10');
INSERT INTO `sys_logininfor` VALUES (1908, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 23:24:35');
INSERT INTO `sys_logininfor` VALUES (1909, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-14 23:26:39');
INSERT INTO `sys_logininfor` VALUES (1910, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-15 14:59:59');
INSERT INTO `sys_logininfor` VALUES (1911, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-15 16:52:23');
INSERT INTO `sys_logininfor` VALUES (1912, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-15 17:25:38');
INSERT INTO `sys_logininfor` VALUES (1913, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-15 22:17:17');
INSERT INTO `sys_logininfor` VALUES (1914, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-16 14:16:09');
INSERT INTO `sys_logininfor` VALUES (1915, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-16 15:10:35');
INSERT INTO `sys_logininfor` VALUES (1916, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-16 16:22:17');
INSERT INTO `sys_logininfor` VALUES (1917, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-16 16:29:24');
INSERT INTO `sys_logininfor` VALUES (1918, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-16 17:34:04');
INSERT INTO `sys_logininfor` VALUES (1919, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2019-07-16 21:58:58');
INSERT INTO `sys_logininfor` VALUES (1920, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-16 21:59:02');
INSERT INTO `sys_logininfor` VALUES (1921, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-16 22:04:11');
INSERT INTO `sys_logininfor` VALUES (1922, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-17 14:01:03');
INSERT INTO `sys_logininfor` VALUES (1923, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-17 14:26:30');
INSERT INTO `sys_logininfor` VALUES (1924, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2019-07-17 14:43:43');
INSERT INTO `sys_logininfor` VALUES (1925, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-17 14:43:49');
INSERT INTO `sys_logininfor` VALUES (1926, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-17 17:01:27');
INSERT INTO `sys_logininfor` VALUES (1927, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-17 20:29:03');
INSERT INTO `sys_logininfor` VALUES (1928, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-17 21:32:10');
INSERT INTO `sys_logininfor` VALUES (1929, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-17 21:42:56');
INSERT INTO `sys_logininfor` VALUES (1930, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-17 21:45:28');
INSERT INTO `sys_logininfor` VALUES (1931, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-17 21:58:36');
INSERT INTO `sys_logininfor` VALUES (1932, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-17 22:30:35');
INSERT INTO `sys_logininfor` VALUES (1933, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-17 23:13:39');
INSERT INTO `sys_logininfor` VALUES (1934, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-17 23:51:18');
INSERT INTO `sys_logininfor` VALUES (1935, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-18 00:06:23');
INSERT INTO `sys_logininfor` VALUES (1936, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-18 11:57:56');
INSERT INTO `sys_logininfor` VALUES (1937, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-18 13:34:30');
INSERT INTO `sys_logininfor` VALUES (1938, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2019-07-18 14:24:17');
INSERT INTO `sys_logininfor` VALUES (1939, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-18 14:24:19');
INSERT INTO `sys_logininfor` VALUES (1940, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-18 14:33:39');
INSERT INTO `sys_logininfor` VALUES (1941, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-18 14:56:10');
INSERT INTO `sys_logininfor` VALUES (1942, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-18 15:05:40');
INSERT INTO `sys_logininfor` VALUES (1943, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-18 15:18:52');
INSERT INTO `sys_logininfor` VALUES (1944, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-18 15:29:59');
INSERT INTO `sys_logininfor` VALUES (1945, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-18 16:56:15');
INSERT INTO `sys_logininfor` VALUES (1946, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-18 17:50:03');
INSERT INTO `sys_logininfor` VALUES (1947, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-18 23:07:30');
INSERT INTO `sys_logininfor` VALUES (1948, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-19 14:39:13');
INSERT INTO `sys_logininfor` VALUES (1949, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-19 15:00:02');
INSERT INTO `sys_logininfor` VALUES (1950, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-19 15:01:18');
INSERT INTO `sys_logininfor` VALUES (1951, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-19 15:28:48');
INSERT INTO `sys_logininfor` VALUES (1952, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-19 16:13:31');
INSERT INTO `sys_logininfor` VALUES (1953, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-19 16:38:17');
INSERT INTO `sys_logininfor` VALUES (1954, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-19 16:47:38');
INSERT INTO `sys_logininfor` VALUES (1955, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-19 17:45:30');
INSERT INTO `sys_logininfor` VALUES (1956, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-19 17:48:08');
INSERT INTO `sys_logininfor` VALUES (1957, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-19 17:51:56');
INSERT INTO `sys_logininfor` VALUES (1958, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-19 23:07:50');
INSERT INTO `sys_logininfor` VALUES (1959, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-20 00:07:18');
INSERT INTO `sys_logininfor` VALUES (1960, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-21 15:00:41');
INSERT INTO `sys_logininfor` VALUES (1961, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-21 16:47:29');
INSERT INTO `sys_logininfor` VALUES (1962, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-21 21:14:10');
INSERT INTO `sys_logininfor` VALUES (1963, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-22 15:43:14');
INSERT INTO `sys_logininfor` VALUES (1964, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-22 15:50:19');
INSERT INTO `sys_logininfor` VALUES (1965, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-22 16:42:16');
INSERT INTO `sys_logininfor` VALUES (1966, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-22 17:34:50');
INSERT INTO `sys_logininfor` VALUES (1967, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-22 17:49:59');
INSERT INTO `sys_logininfor` VALUES (1968, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-22 21:52:40');
INSERT INTO `sys_logininfor` VALUES (1969, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-22 22:24:51');
INSERT INTO `sys_logininfor` VALUES (1970, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-22 22:41:09');
INSERT INTO `sys_logininfor` VALUES (1971, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-22 23:09:41');
INSERT INTO `sys_logininfor` VALUES (1972, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 11:44:10');
INSERT INTO `sys_logininfor` VALUES (1973, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 11:47:11');
INSERT INTO `sys_logininfor` VALUES (1974, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 11:58:24');
INSERT INTO `sys_logininfor` VALUES (1975, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 13:33:00');
INSERT INTO `sys_logininfor` VALUES (1976, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 13:49:45');
INSERT INTO `sys_logininfor` VALUES (1977, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 14:32:01');
INSERT INTO `sys_logininfor` VALUES (1978, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 15:04:08');
INSERT INTO `sys_logininfor` VALUES (1979, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 15:15:34');
INSERT INTO `sys_logininfor` VALUES (1980, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 16:13:19');
INSERT INTO `sys_logininfor` VALUES (1981, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 16:29:12');
INSERT INTO `sys_logininfor` VALUES (1982, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 16:31:18');
INSERT INTO `sys_logininfor` VALUES (1983, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 16:48:42');
INSERT INTO `sys_logininfor` VALUES (1984, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 22:23:20');
INSERT INTO `sys_logininfor` VALUES (1985, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-23 23:24:56');
INSERT INTO `sys_logininfor` VALUES (1986, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-24 10:44:08');
INSERT INTO `sys_logininfor` VALUES (1987, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-24 14:08:46');
INSERT INTO `sys_logininfor` VALUES (1988, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-24 17:33:00');
INSERT INTO `sys_logininfor` VALUES (1989, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-24 22:21:00');
INSERT INTO `sys_logininfor` VALUES (1990, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-24 22:32:57');
INSERT INTO `sys_logininfor` VALUES (1991, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-25 13:54:19');
INSERT INTO `sys_logininfor` VALUES (1992, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-25 14:46:30');
INSERT INTO `sys_logininfor` VALUES (1993, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2019-07-25 15:02:37');
INSERT INTO `sys_logininfor` VALUES (1994, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-25 15:44:58');
INSERT INTO `sys_logininfor` VALUES (1995, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-25 16:36:33');
INSERT INTO `sys_logininfor` VALUES (1996, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-25 16:37:27');
INSERT INTO `sys_logininfor` VALUES (1997, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-26 14:00:13');
INSERT INTO `sys_logininfor` VALUES (1998, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-28 20:27:21');
INSERT INTO `sys_logininfor` VALUES (1999, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2019-07-28 22:32:26');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2025 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 10, '#', 'M', '0', '', 'fa fa-gear', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-16 17:00:22', '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 9, '#', 'M', '0', '', 'fa fa-video-camera', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-16 17:00:31', '系统监控目录');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, '/system/user', 'C', '0', 'system:user:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, '/system/role', 'C', '0', 'system:role:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, '/system/menu', 'C', '0', 'system:menu:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 6, '/system/dict', 'C', '0', 'system:dict:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 7, '/system/config', 'C', '0', 'system:config:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, '/system/notice', 'C', '0', 'system:notice:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 0, 9, '#', 'M', '0', '', 'fa fa-bug', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-16 17:41:31', '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, '/monitor/online', 'C', '0', 'monitor:online:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '在线用户菜单');
INSERT INTO `sys_menu` VALUES (110, '定时任务', 2, 2, '/monitor/job', 'C', '0', 'monitor:job:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '定时任务菜单');
INSERT INTO `sys_menu` VALUES (111, '数据监控', 2, 3, '/monitor/data', 'C', '0', 'monitor:data:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '数据监控菜单');
INSERT INTO `sys_menu` VALUES (112, '系统图表', 2013, 3, '/chart/server', 'C', '0', 'chart:server:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '服务监控菜单');
INSERT INTO `sys_menu` VALUES (115, '系统接口', 2, 3, '/monitor/swagger', 'C', '0', 'monitor:swagger:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-15 18:06:14', '系统接口菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, '/log/operlog', 'C', '0', 'log:operlog:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-16 19:12:30', '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, '/log/logininfor', 'C', '0', 'log:logininfor:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-16 19:12:43', '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1000, '用户查询', 100, 1, '#', 'F', '0', 'system:user:list', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1001, '用户新增', 100, 2, '#', 'F', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1002, '用户修改', 100, 3, '#', 'F', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1003, '用户删除', 100, 4, '#', 'F', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1004, '用户导出', 100, 5, '#', 'F', '0', 'system:user:export', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1005, '用户导入', 100, 6, '#', 'F', '0', 'system:user:import', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1006, '重置密码', 100, 7, '#', 'F', '0', 'system:user:resetPwd', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1007, '角色查询', 101, 1, '#', 'F', '0', 'system:role:list', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1008, '角色新增', 101, 2, '#', 'F', '0', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1009, '角色修改', 101, 3, '#', 'F', '0', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1010, '角色删除', 101, 4, '#', 'F', '0', 'system:role:remove', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1011, '角色导出', 101, 5, '#', 'F', '0', 'system:role:export', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1012, '菜单查询', 102, 1, '#', 'F', '0', 'system:menu:list', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1013, '菜单新增', 102, 2, '#', 'F', '0', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1014, '菜单修改', 102, 3, '#', 'F', '0', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1015, '菜单删除', 102, 4, '#', 'F', '0', 'system:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1025, '字典查询', 105, 1, '#', 'F', '0', 'system:dict:list', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1026, '字典新增', 105, 2, '#', 'F', '0', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1027, '字典修改', 105, 3, '#', 'F', '0', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1028, '字典删除', 105, 4, '#', 'F', '0', 'system:dict:remove', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1029, '字典导出', 105, 5, '#', 'F', '0', 'system:dict:export', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1030, '参数查询', 106, 1, '#', 'F', '0', 'system:config:list', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1031, '参数新增', 106, 2, '#', 'F', '0', 'system:config:add', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1032, '参数修改', 106, 3, '#', 'F', '0', 'system:config:edit', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1033, '参数删除', 106, 4, '#', 'F', '0', 'system:config:remove', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1034, '参数导出', 106, 5, '#', 'F', '0', 'system:config:export', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1035, '公告查询', 107, 1, '#', 'F', '0', 'system:notice:list', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1036, '公告新增', 107, 2, '#', 'F', '0', 'system:notice:add', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1037, '公告修改', 107, 3, '#', 'F', '0', 'system:notice:edit', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1038, '公告删除', 107, 4, '#', 'F', '0', 'system:notice:remove', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1039, '操作查询', 500, 1, '#', 'F', '0', 'log:operlog:list', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-16 19:12:54', '');
INSERT INTO `sys_menu` VALUES (1040, '操作删除', 500, 2, '#', 'F', '0', 'log:operlog:remove', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-16 19:13:03', '');
INSERT INTO `sys_menu` VALUES (1041, '详细信息', 500, 3, '#', 'F', '0', 'log:operlog:detail', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-16 19:13:12', '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', 'F', '0', 'log:operlog:export', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-16 19:13:22', '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', 'F', '0', 'log:logininfor:list', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-16 19:13:32', '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', 'F', '0', 'log:logininfor:remove', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-16 19:13:43', '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', 'F', '0', 'log:logininfor:export', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2019-03-16 19:13:55', '');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, 1, '#', 'F', '0', 'monitor:online:list', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, 2, '#', 'F', '0', 'monitor:online:batchForceLogout', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, 3, '#', 'F', '0', 'monitor:online:forceLogout', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1049, '任务查询', 110, 1, '#', 'F', '0', 'monitor:job:list', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1050, '任务新增', 110, 2, '#', 'F', '0', 'monitor:job:add', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1051, '任务修改', 110, 3, '#', 'F', '0', 'monitor:job:edit', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1052, '任务删除', 110, 4, '#', 'F', '0', 'monitor:job:remove', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1053, '状态修改', 110, 5, '#', 'F', '0', 'monitor:job:changeStatus', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1054, '任务详细', 110, 6, '#', 'F', '0', 'monitor:job:detail', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1055, '任务导出', 110, 7, '#', 'F', '0', 'monitor:job:export', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (2000, '博客模块', 0, 1, '#', 'M', '0', NULL, 'fa fa-th-large', 'admin', '2019-03-16 16:59:44', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2001, '博客管理', 2000, 1, '/blog/blog', 'C', '0', 'blog:blog:view', '#', 'admin', '2019-03-16 17:01:22', 'admin', '2019-03-16 17:02:37', '');
INSERT INTO `sys_menu` VALUES (2002, '分类管理', 2000, 2, '/blog/category', 'C', '0', 'blog:category:view', '#', 'admin', '2019-03-16 17:02:05', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2003, '标签管理', 2000, 3, '/blog/tag', 'C', '0', 'blog:tag:view', '#', 'admin', '2019-03-16 17:03:04', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2005, '畅言评论', 2000, 4, 'http://changyan.kuaizhan.com/', 'C', '0', NULL, '#', 'admin', '2019-03-16 19:21:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2006, '友链管理', 0, 5, '#', 'M', '0', NULL, 'fa fa-code', 'admin', '2019-03-16 19:22:45', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2007, '友链列表', 2006, 1, '/link/link', 'C', '0', '', '#', 'admin', '2019-03-16 19:23:16', 'admin', '2019-03-25 21:11:01', '');
INSERT INTO `sys_menu` VALUES (2008, '调度日志', 108, 4, '/log/jobLog', 'C', '0', 'log:job:view', '#', 'admin', '2019-03-16 22:18:07', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2009, '日志查询', 2008, 1, '#', 'F', '0', 'log:job:list', '#', 'admin', '2019-03-16 22:19:04', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2010, '日志删除', 2008, 2, '#', 'F', '0', 'log:job:remove', '#', 'admin', '2019-03-16 22:19:30', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2011, '日志导出', 2008, 3, '#', 'F', '0', 'log:job:export', '#', 'admin', '2019-03-16 22:19:53', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2012, '日志详细', 2008, 4, '#', 'F', '0', 'log:job:detail', '#', 'admin', '2019-03-16 22:20:17', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2013, '统计图表', 0, 6, '#', 'M', '0', NULL, 'fa fa-bar-chart-o', 'admin', '2019-03-17 11:05:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2014, '访问日志', 108, 1, '/log/visitLog', 'C', '0', '', '#', 'admin', '2019-03-26 17:40:13', 'admin', '2019-03-26 17:42:19', '');
INSERT INTO `sys_menu` VALUES (2015, '黑名单', 2, 4, '/monitor/blacklist', 'C', '0', 'monitor:blacklist:view', '#', 'admin', '2019-03-29 10:32:22', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2016, '内容管理', 0, 5, '#', 'M', '0', '', 'fa fa-archive', 'admin', '2019-04-03 15:53:17', 'admin', '2019-04-03 18:20:56', '');
INSERT INTO `sys_menu` VALUES (2018, '轮播设置', 1, 9, '/system/carouselMap', 'C', '0', 'system:carouselMap:view', '#', 'admin', '2019-04-08 16:43:39', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2019, '轮播删除', 2018, 1, '#', 'F', '0', 'system:carouselMap:remove', '#', 'admin', '2019-04-08 16:44:14', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2020, '轮播增加', 2018, 1, '#', 'F', '0', 'system:carouselMap:add', '#', 'admin', '2019-04-08 16:44:31', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2021, '轮播修改', 2018, 1, '#', 'F', '0', 'system:carouselMap:edit', '#', 'admin', '2019-04-08 16:44:48', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2022, '轮播查询', 2018, 1, '#', 'F', '0', 'system:carouselMap:list', '#', 'admin', '2019-04-08 16:45:03', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2023, '业务图表', 2013, 2, '/chart/business', 'C', '0', NULL, '#', 'admin', '2019-04-08 19:20:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2024, '文件管理', 2016, 1, '/filemanage', 'C', '0', '', '#', 'admin', '2019-07-08 17:19:43', 'admin', '2019-07-10 13:52:04', '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '通知公告表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, '温馨提醒：2019-07-01 DragonWen-1.0.0版本发布啦', '2', '1.0.0版本内容', '0', 'admin', '2019-07-01 11:33:00', 'admin', '2019-07-01 11:33:00', '管理员');
INSERT INTO `sys_notice` VALUES (2, '维护通知：2019-07-02 DragonWen系统凌晨维护', '1', '维护内容', '0', 'admin', '2019-07-02 11:33:00', 'admin', '2019-07-02 11:33:00', '管理员');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `oper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `operator_type` int(1) NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `status` int(1) NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES (1, '角色管理', 2, 'com.dragon.project.system.role.controller.RoleController.editSave()', 1, 'admin', '', '/system/role/edit', '127.0.0.1', '内网IP', '{\"roleId\":[\"1\"],\"roleName\":[\"管理员\"],\"roleKey\":[\"admin\"],\"roleSort\":[\"1\"],\"status\":[\"0\"],\"remark\":[\"管理员\"],\"menuIds\":[\"2001,2002,2003,2007,2016,112,2,109,1046,1047,1048,110,1049,1050,1051,1052,1053,1054,1055,111,115,2015,108,2014,500,1039,1040,1041,1042,501,1043,1044,1045,2008,2009,2010,2011,2012,1,100,1000,1001,1002,1003,1004,1005,1006,101,1007,1008,1009,1010,1011,102,1012,1013,1014,1015,105,1025,1026,1027,1028,1029,106,1030,1031,1032,1033,1034,107,1035,1036,1037,1038,2018,2019,2020,2021,2022\"]}', 0, NULL, '2019-06-28 14:38:31');
INSERT INTO `sys_oper_log` VALUES (2, '黑名单', 3, 'com.dragon.project.monitor.blacklist.controller.BlacklistController.remove()', 1, 'admin', '', '/monitor/blacklist/remove', '127.0.0.1', '内网IP', '{\"ids\":[\"1\"]}', 0, NULL, '2019-07-04 16:35:16');
INSERT INTO `sys_oper_log` VALUES (3, '友链管理', 2, 'com.dragon.project.link.controller.LinkController.display()', 1, 'admin', '', '/link/link/display/1', '127.0.0.1', '内网IP', '{\"id\":[\"1\"]}', 0, NULL, '2019-07-05 15:54:58');
INSERT INTO `sys_oper_log` VALUES (4, '菜单管理', 1, 'com.dragon.project.system.menu.controller.MenuController.addSave()', 1, 'admin', '', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"2016\"],\"menuType\":[\"C\"],\"menuName\":[\"文件管理\"],\"url\":[\"/filemanage\"],\"perms\":[\"\"],\"orderNum\":[\"2\"],\"icon\":[\"\"],\"visible\":[\"0\"]}', 0, NULL, '2019-07-08 17:19:43');
INSERT INTO `sys_oper_log` VALUES (5, '菜单管理', 3, 'com.dragon.project.system.menu.controller.MenuController.remove()', 1, 'admin', '', '/system/menu/remove/2017', '127.0.0.1', '内网IP', '{}', 0, NULL, '2019-07-10 13:51:53');
INSERT INTO `sys_oper_log` VALUES (6, '菜单管理', 2, 'com.dragon.project.system.menu.controller.MenuController.editSave()', 1, 'admin', '', '/system/menu/edit', '127.0.0.1', '内网IP', '{\"menuId\":[\"2024\"],\"parentId\":[\"2016\"],\"menuType\":[\"C\"],\"menuName\":[\"文件管理\"],\"url\":[\"/filemanage\"],\"perms\":[\"\"],\"orderNum\":[\"1\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', 0, NULL, '2019-07-10 13:52:04');
INSERT INTO `sys_oper_log` VALUES (7, '博客管理', 3, 'com.dragon.project.blog.blog.controller.BlogController.remove()', 1, 'admin', '', '/blog/blog/remove', '127.0.0.1', '内网IP', '{\"ids\":[\"51\"]}', 0, NULL, '2019-07-26 14:03:24');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 'admin', 1, '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-06-28 14:38:31', '管理员');
INSERT INTO `sys_role` VALUES (2, '普通角色', 'common', 2, '2', '0', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-06-21 15:01:03', '普通角色');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 2);
INSERT INTO `sys_role_menu` VALUES (1, 100);
INSERT INTO `sys_role_menu` VALUES (1, 101);
INSERT INTO `sys_role_menu` VALUES (1, 102);
INSERT INTO `sys_role_menu` VALUES (1, 105);
INSERT INTO `sys_role_menu` VALUES (1, 106);
INSERT INTO `sys_role_menu` VALUES (1, 107);
INSERT INTO `sys_role_menu` VALUES (1, 108);
INSERT INTO `sys_role_menu` VALUES (1, 109);
INSERT INTO `sys_role_menu` VALUES (1, 110);
INSERT INTO `sys_role_menu` VALUES (1, 111);
INSERT INTO `sys_role_menu` VALUES (1, 112);
INSERT INTO `sys_role_menu` VALUES (1, 115);
INSERT INTO `sys_role_menu` VALUES (1, 500);
INSERT INTO `sys_role_menu` VALUES (1, 501);
INSERT INTO `sys_role_menu` VALUES (1, 1000);
INSERT INTO `sys_role_menu` VALUES (1, 1001);
INSERT INTO `sys_role_menu` VALUES (1, 1002);
INSERT INTO `sys_role_menu` VALUES (1, 1003);
INSERT INTO `sys_role_menu` VALUES (1, 1004);
INSERT INTO `sys_role_menu` VALUES (1, 1005);
INSERT INTO `sys_role_menu` VALUES (1, 1006);
INSERT INTO `sys_role_menu` VALUES (1, 1007);
INSERT INTO `sys_role_menu` VALUES (1, 1008);
INSERT INTO `sys_role_menu` VALUES (1, 1009);
INSERT INTO `sys_role_menu` VALUES (1, 1010);
INSERT INTO `sys_role_menu` VALUES (1, 1011);
INSERT INTO `sys_role_menu` VALUES (1, 1012);
INSERT INTO `sys_role_menu` VALUES (1, 1013);
INSERT INTO `sys_role_menu` VALUES (1, 1014);
INSERT INTO `sys_role_menu` VALUES (1, 1015);
INSERT INTO `sys_role_menu` VALUES (1, 1025);
INSERT INTO `sys_role_menu` VALUES (1, 1026);
INSERT INTO `sys_role_menu` VALUES (1, 1027);
INSERT INTO `sys_role_menu` VALUES (1, 1028);
INSERT INTO `sys_role_menu` VALUES (1, 1029);
INSERT INTO `sys_role_menu` VALUES (1, 1030);
INSERT INTO `sys_role_menu` VALUES (1, 1031);
INSERT INTO `sys_role_menu` VALUES (1, 1032);
INSERT INTO `sys_role_menu` VALUES (1, 1033);
INSERT INTO `sys_role_menu` VALUES (1, 1034);
INSERT INTO `sys_role_menu` VALUES (1, 1035);
INSERT INTO `sys_role_menu` VALUES (1, 1036);
INSERT INTO `sys_role_menu` VALUES (1, 1037);
INSERT INTO `sys_role_menu` VALUES (1, 1038);
INSERT INTO `sys_role_menu` VALUES (1, 1039);
INSERT INTO `sys_role_menu` VALUES (1, 1040);
INSERT INTO `sys_role_menu` VALUES (1, 1041);
INSERT INTO `sys_role_menu` VALUES (1, 1042);
INSERT INTO `sys_role_menu` VALUES (1, 1043);
INSERT INTO `sys_role_menu` VALUES (1, 1044);
INSERT INTO `sys_role_menu` VALUES (1, 1045);
INSERT INTO `sys_role_menu` VALUES (1, 1046);
INSERT INTO `sys_role_menu` VALUES (1, 1047);
INSERT INTO `sys_role_menu` VALUES (1, 1048);
INSERT INTO `sys_role_menu` VALUES (1, 1049);
INSERT INTO `sys_role_menu` VALUES (1, 1050);
INSERT INTO `sys_role_menu` VALUES (1, 1051);
INSERT INTO `sys_role_menu` VALUES (1, 1052);
INSERT INTO `sys_role_menu` VALUES (1, 1053);
INSERT INTO `sys_role_menu` VALUES (1, 1054);
INSERT INTO `sys_role_menu` VALUES (1, 1055);
INSERT INTO `sys_role_menu` VALUES (1, 2001);
INSERT INTO `sys_role_menu` VALUES (1, 2002);
INSERT INTO `sys_role_menu` VALUES (1, 2003);
INSERT INTO `sys_role_menu` VALUES (1, 2007);
INSERT INTO `sys_role_menu` VALUES (1, 2008);
INSERT INTO `sys_role_menu` VALUES (1, 2009);
INSERT INTO `sys_role_menu` VALUES (1, 2010);
INSERT INTO `sys_role_menu` VALUES (1, 2011);
INSERT INTO `sys_role_menu` VALUES (1, 2012);
INSERT INTO `sys_role_menu` VALUES (1, 2014);
INSERT INTO `sys_role_menu` VALUES (1, 2015);
INSERT INTO `sys_role_menu` VALUES (1, 2016);
INSERT INTO `sys_role_menu` VALUES (1, 2018);
INSERT INTO `sys_role_menu` VALUES (1, 2019);
INSERT INTO `sys_role_menu` VALUES (1, 2020);
INSERT INTO `sys_role_menu` VALUES (1, 2021);
INSERT INTO `sys_role_menu` VALUES (1, 2022);
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 100);
INSERT INTO `sys_role_menu` VALUES (2, 101);
INSERT INTO `sys_role_menu` VALUES (2, 102);
INSERT INTO `sys_role_menu` VALUES (2, 105);
INSERT INTO `sys_role_menu` VALUES (2, 106);
INSERT INTO `sys_role_menu` VALUES (2, 107);
INSERT INTO `sys_role_menu` VALUES (2, 108);
INSERT INTO `sys_role_menu` VALUES (2, 109);
INSERT INTO `sys_role_menu` VALUES (2, 110);
INSERT INTO `sys_role_menu` VALUES (2, 500);
INSERT INTO `sys_role_menu` VALUES (2, 501);
INSERT INTO `sys_role_menu` VALUES (2, 1000);
INSERT INTO `sys_role_menu` VALUES (2, 1007);
INSERT INTO `sys_role_menu` VALUES (2, 1012);
INSERT INTO `sys_role_menu` VALUES (2, 1025);
INSERT INTO `sys_role_menu` VALUES (2, 1030);
INSERT INTO `sys_role_menu` VALUES (2, 1035);
INSERT INTO `sys_role_menu` VALUES (2, 1039);
INSERT INTO `sys_role_menu` VALUES (2, 1041);
INSERT INTO `sys_role_menu` VALUES (2, 1043);
INSERT INTO `sys_role_menu` VALUES (2, 1046);
INSERT INTO `sys_role_menu` VALUES (2, 1049);
INSERT INTO `sys_role_menu` VALUES (2, 1054);
INSERT INTO `sys_role_menu` VALUES (2, 2008);
INSERT INTO `sys_role_menu` VALUES (2, 2009);
INSERT INTO `sys_role_menu` VALUES (2, 2012);
INSERT INTO `sys_role_menu` VALUES (2, 2018);
INSERT INTO `sys_role_menu` VALUES (2, 2019);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `login_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '盐加密',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime NULL DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', 'admin', '00', '18475536452@163.com', '18129954693', '0', '/admin/img/profile.jpg', '1a366a671a35416ca01a8cf633afa1b4', '1b4b51', '0', '0', '127.0.0.1', '2019-07-28 22:32:26', 'admin', '2018-03-16 11:33:00', 'admin', '2019-07-28 22:32:26', '管理员');
INSERT INTO `sys_user` VALUES (3, 'test', 'test', '00', 'Dragon.Wen@hafele.com', '18475536452', '0', '', '3f8922736d703d6b738fd1e0b1460220', '442d03', '0', '0', '', NULL, 'admin', '2019-06-22 22:15:15', '', NULL, '测试用户');

-- ----------------------------
-- Table structure for sys_user_online
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_online`;
CREATE TABLE `sys_user_online`  (
  `sessionId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户会话id',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `start_timestamp` datetime NULL DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime NULL DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int(5) NULL DEFAULT 0 COMMENT '超时时间，单位为分钟',
  PRIMARY KEY (`sessionId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '在线用户记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (3, 2);

SET FOREIGN_KEY_CHECKS = 1;
