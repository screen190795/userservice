FROM openjdk:17
ARG JAR_FILE=userservice-0.0.1.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]