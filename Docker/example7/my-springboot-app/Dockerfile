FROM openjdk:17-alpine
EXPOSE 9090
WORKDIR /app
COPY target/my-springboot-app-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "my-springboot-app-0.0.1-SNAPSHOT.jar" ]
