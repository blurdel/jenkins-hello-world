# jenkins-hello-world
Basic Spring Boot REST Controller example - just Hello World

#### DSO files
* Jenkinsfile
* Dockerfile
* webapp.yaml

#### Docker commands
    # build image
    docker build -t jenkins-hello:1.0.0 .

    # build container
    docker run -d --rm --name jenkins-hello -p 8080:8080 jenkins-hello:1.0.0

#### k8s commands
    kubectl apply -f webapp.yaml
