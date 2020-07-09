# 基于哪个镜像
FROM openjdk:8-jre-alpine
# 将本地文件夹挂载到当前容器
VOLUME /export
ARG JAR_FILE
# 拷贝文件到容器，也可以直接写成ADD microservice-discovery-eureka-0.0.1-SNAPSHOT.jar /app.jar
ADD ${JAR_FILE} app.jar
# 开放8761端口
EXPOSE 8761/tcp
# 配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=GMT+8","-jar","/app.jar"]