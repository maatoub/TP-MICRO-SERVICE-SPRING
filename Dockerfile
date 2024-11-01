FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/TP1-*.jar /app/TP1-SERVICE.jar
ENTRYPOINT [ "java", "-jar", "/app/TP1-SERVICE.jar" ]