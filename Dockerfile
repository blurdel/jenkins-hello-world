# First stage: complete build environment
FROM maven:3.8.1-openjdk-11 AS builder

# service jar file - only place to update is here
ENV appJar=jenkins-hello-world-0.0.1-SNAPSHOT.jar

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package jar
RUN mvn clean verify

# Second stage: minimal runtime environment
FROM openjdk:11

# copy jar from the first stage
COPY --from=builder target/${appJar} service.jar
#COPY target/${appJar} service.jar

EXPOSE 8080

CMD ["java", "-jar", "service.jar"]
