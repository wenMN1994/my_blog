# 以下是我的Jenkins 通过shell脚本自动部署jar包和vue的
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

# 2.开始开始进行vue项目的打包部署
# 检查node环境
node -v
# 进入vue项目根路径
cd /var/lib/jenkins/workspace/my-blog/admin-ui
# 安装vue项目所需的插件
npm install --registry=https://registry.npmmirror.com
# 删除上一次打包的dist内容
rm -rf /var/lib/jenkins/workspace/my-blog/admin-ui/dist/*
# 重新打包vue项目生成dist内容
npm run build:prod
# 删除正在运行的vue项目
rm -rf /home/my-blog/projects/admin-ui/*
# 将新打包的vue项目复制到nginx启动目录
cp -rf /var/lib/jenkins/workspace/my-blog/admin-ui/dist/* /home/my-blog/projects/admin-ui
# 进入nginx启动目录
cd /usr/local/nginx/sbin
# 重新加载nginx
./nginx -s reload

# 以下是启动jar服务的blog.sh脚本
#!/bin/sh
# ./ry.sh start 启动 stop 停止 restart 重启 status 状态
BUILD_ID=DONTKILLME

AppName=blog-admin.jar

# JVM参数
JVM_OPTS="-Dname=$AppName  -Duser.timezone=Asia/Shanghai -Xms512m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDateStamps  -XX:+PrintGCDetails -XX:NewRatio=1 -XX:SurvivorRatio=30 -XX:+UseParallelGC -XX:+UseParallelOldGC"
APP_HOME=`pwd`
LOG_PATH=$APP_HOME/logs/$AppName.log

if [ "$1" = "" ];
then
    echo -e "\033[0;31m 未输入操作名 \033[0m  \033[0;34m {start|stop|restart|status} \033[0m"
    exit 1
fi

if [ "$AppName" = "" ];
then
    echo -e "\033[0;31m 未输入应用名 \033[0m"
    exit 1
fi

function start()
{
    PID=`ps -ef |grep java|grep $AppName|grep -v grep|awk '{print $2}'`

	if [ x"$PID" != x"" ]; then
	    echo "$AppName is running..."
	else
		nohup java $JVM_OPTS -jar $AppName > /dev/null 2>&1 &
		echo "Start $AppName success..."
	fi
}

function stop()
{
    echo "Stop $AppName"

	PID=""
	query(){
		PID=`ps -ef |grep java|grep $AppName|grep -v grep|awk '{print $2}'`
	}

	query
	if [ x"$PID" != x"" ]; then
		kill -TERM $PID
		echo "$AppName (pid:$PID) exiting..."
		while [ x"$PID" != x"" ]
		do
			sleep 1
			query
		done
		echo "$AppName exited."
	else
		echo "$AppName already stopped."
	fi
}

function restart()
{
    stop
    sleep 2
    start
}

function status()
{
    PID=`ps -ef |grep java|grep $AppName|grep -v grep|wc -l`
    if [ $PID != 0 ];then
        echo "$AppName is running..."
    else
        echo "$AppName is not running..."
    fi
}

case $1 in
    start)
    start;;
    stop)
    stop;;
    restart)
    restart;;
    status)
    status;;
    *)

esac

# 在windows环境下编写的blog.sh脚本放到linux服务器上后必须执行以下命令编译sh文件，不然blog.sh会启动报错
# linux编译.sh脚本
dos2unix blog.sh