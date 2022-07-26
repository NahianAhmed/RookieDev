FROM openjdk:11
EXPOSE 8080:8080
ADD target/rookie-app.war rookie-app.war
ENTRYPOINT ["java","-war","/rookie-app.war"]