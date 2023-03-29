# First stage: complete build environment
# FROM maven:3.5.0-jdk-8-alpine AS builder
FROM maven:3.6.3-jdk-11-slim AS builder

# service jar file - only plave to update is here
ENV appJar=docker-java-hello-0.0.1-SNAPSHOT.jar

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package jar
RUN mvn clean package

# Second stage: minimal runtime environment
FROM openjdk:11

# copy jar from the first stage
COPY --from=builder target/${appJar} service.jar

EXPOSE 8080

CMD ["java", "-jar", "service.jar"]
