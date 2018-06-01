为了保持内容为最新，建议每次阅读前先 pull 最新镜像
```
$ docker pull dockerpracticecn/docker_practice

$ docker run -it --rm -p 4000:80 dockerpracticecn/docker_practice
```

之后打开浏览器，在地址栏输入 ```127.0.0.1:4000``` 即可开始阅读。

停止
在终端按 ```Ctrl + c```

## docker 常用命令
```
# 获取mysql5.7版本的镜像
docker pull mysql:5.7.22
# 启动一个 容器内3306映射本机3309的名为mysql 5.7.22的容器,不加版本则是运行latest
docker run -it --rm -p 3306:3306 --name mysql -v ~/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7.22
# 罗列所有的容器，包含已经停止的
docker ps -a
# 停止一个容器 24ed9f74fa99为容器id，支持短id 如：24ed
docker stop 24ed9f74fa99
# 罗列镜像
docker images / 或者 docker image ls
# 罗列容器
docker container ls
# 删除镜像
docker image rm mysql
# 删除容器
docker rm containerId 
# 启动名为mysql的容器
docker start mysql  
# 进入名为mysql的容器
docker exec -it mysql bash 
```