# pumkins-server
  The backend of my private blog project.
  Blog Adress: [pumkins.us:4200](http://www.pumkins.us:4200/)

  
# Version
| Name             | Version | Comment |
| :--------------- | ------- | ------- |
| Java             | 1.8     |         |
| Spring Framework | 2.21    |         |
| Minio            | 8.1.0   |         |
| Querydsl         | 5.0.0   |         |
| Log4j            | 2.11.0  |         |
| Maven            | 3.2     |         |
| Hibernate        | 5.4.7   |         |


# Deploy info

## Java

### Version

```
java-1.8.0-openjdk-1.8.0.382.b05-2.el8.x86\_64
```

### Environment

```
export JAVA\_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.382.b05-2.el8.x86\_64
export JRE\_HOME=\$JAVA\_HOME/jre
export CLASSPATH=.:\$JAVA\_HOME/lib:\$JRE\_HOME/lib:\$CLASSPATH
export PATH=\$PATH:\$JRE\_HOME/bin:\$JAVA\_HOME/bin
```

### Start command

```
nohup java -jar /home/tomcat/webapps/pumkins-server-base-1.0-SNAPSHOT.jar >/home/java/log/pumkins\_log &
```

## Nginx

### deploy path

usr/local/nginx

/usr/local/nginx/html

### Add nginx to system

```
vim /etc/profile
export PATH=/usr/local/nginx/sbin/nginx:\$PATH
```

### basic command

nginx -s reload
nginx -s stop

## Tomcat

### deploy path

/home/tomcat/webapps

## Docker

### Basic command

docker ps -a

docker images

docker container ls

docker rm container name

docker rmi image name

docker excc -it container name

## Mysql

```
docker run --name mysql -p 3306:3306 
-v /mysql/mysql/data:/var/lib/mysql 
-v /mysql/mysql/config:/etc/mysql/conf.d 
-v /mysql/mysql/log:/var/log/mysql 
-e MYSQL_ROOT_PASSWORD=***-d mysql:5.7.25
```
