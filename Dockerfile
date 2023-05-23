FROM openjdk:17

COPY target/jenkins-hello-world-0.0.1-SNAPSHOT.jar service.jar

EXPOSE 8080

CMD ["java", "-jar", "service.jar"]

# build image
# docker build -t jenkins-hello .

# build container
# docker run -d --rm --name jenkins-hello -p 8080:8080 jenkins-hello
