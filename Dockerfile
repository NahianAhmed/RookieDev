FROM openjdk:11
ADD target/rookie-app.jar rookie-app.jar
ENTRYPOINT ["java","-jar","/rookie-app.jar"]