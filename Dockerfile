FROM openjdk:11
EXPOSE 8080:8080
ADD target/rookie-app.jar rookie-app.jar
ENTRYPOINT ["java","-jar","/rookie-app.jar"]