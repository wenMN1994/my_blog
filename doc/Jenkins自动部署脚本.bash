# 1.开始进行java项目的打包部署
# 检查maven版本
mvn -version
# 进入项目根路径
cd /var/lib/jenkins/workspace/my-blog/
# 清除上一次编译的文件
mvn clean
# 由于安全问题生产环境的配置文件我没有放到码云上所以下载下来的代码需要替换配置文件
rm -rf /var/lib/jenkins/workspace/my-blog/blog-admin/src/main/resources/application.yml
rm -rf /var/lib/jenkins/workspace/my-blog/blog-admin/src/main/resources/application-dev.yml
# 删除开发环境配置后将提前准备好的生产配置文件复制到项目中
cp -rf /home/my-blog/projects/blog-admin/config/* /var/lib/jenkins/workspace/my-blog/blog-admin/src/main/resources/
# maven编译打包jar文件
mvn clean package -Dmaven.test.skip=true
# 删除上一次编译打包的jar文件
rm -rf /home/my-blog/projects/blog-admin/run/blog-admin.jar
# 将新打包的jar文件复制到启动目录
cp /var/lib/jenkins/workspace/my-blog/blog-admin/target/blog-admin.jar /home/my-blog/projects/blog-admin/run/
# 进入项目启动目录
cd /home/my-blog/projects/blog-admin/run/
# 停止正在运行的服务
sh blog.sh stop
# 启动新服务
sh blog.sh start

# 2.开始开始进行admin vue项目的打包部署
# 检查node环境
node -v
# 进入admin vue项目根路径
cd /var/lib/jenkins/workspace/my-blog/admin-ui
# 安装admin vue项目所需的插件
npm install
# 删除上一次打包的dist内容
rm -rf /var/lib/jenkins/workspace/my-blog/admin-ui/dist/*
# 重新打包vue项目生成dist内容
npm run build:prod
# 删除正在运行的vue项目
rm -rf /home/my-blog/projects/blog-web/admin/*
# 将新打包的vue项目复制到nginx启动目录
cp -rf /var/lib/jenkins/workspace/my-blog/admin-ui/dist/* /home/my-blog/projects/blog-web/admin

# 3.开始开始进行web nuxt项目的打包部署
# 进入web nuxt项目根路径
cd /var/lib/jenkins/workspace/my-blog/web-ui
# 安装web nuxt项目所需的插件
npm install
# 打包web nuxt项目生成.nuxt内容
npm run build
# 先清空原来项目所有文件，避免有缓存数据
#.nuxt是隐藏文件，删除
rm /home/my-blog/projects/blog-web/web/.nuxt -rf
rm /home/my-blog/projects/blog-web/web/* -rf
# 复制 .nuxt目录，static目录，node_modules目录，nuxt.config.js文件和package.json文件
cp -r .nuxt /home/my-blog/projects/blog-web/web/
cp -r static /home/my-blog/projects/blog-web/web/
cp -r node_modules /home/my-blog/projects/blog-web/web/
cp nuxt.config.js package.json /home/my-blog/projects/blog-web/web/
# 复制好以上文件后，进入项目运行目录，我是放在 /home/my-blog/projects/blog-web/web/目录下
cd /home/my-blog/projects/blog-web/web/
# 需要先安装pm2，使用pm2的delete命令删除原来已经在运行的服务。
pm2 delete -s "blog-web"
#使用pm2 命令执行 npm run start,并为当前服务命名
pm2 start npm --name "blog-web" -- run start
# 进入nginx启动目录
cd /usr/local/nginx/sbin
# 重新加载nginx
./nginx -s reload