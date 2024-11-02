FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY C:/ProgramData/Jenkins/.jenkins/workspace/Pipeline-test/target/tp1-*.jar /app/TP1-SERVICE.jar
ENTRYPOINT [ "java", "-jar", "/app/TP1-SERVICE.jar" ]
EXPOSE 8080