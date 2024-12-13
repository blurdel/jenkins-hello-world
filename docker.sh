#!/bin/bash

mvn clean package -DskipTests

docker build -t jenkins-hello:1.0.1 .

docker image tag  jenkins-hello:1.0.1  blurdel/jenkins-hello:1.0.1

docker push  blurdel/jenkins-hello:1.0.1