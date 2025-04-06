# jenkins-hello-world
Basic Spring Boot REST controller example - just Hello World endpoint

### DSO files
* Jenkinsfile
* Dockerfile
* k8s deployment

### Docker commands
    # Build the image
    docker build -t jenkins-hello:1.0.0 .

    # Run the container
    docker run --rm -d --name jenkins-hello -p 8080:8080 jenkins-hello:1.0.0

### k8s deployment
    kubectl apply -f webapp.yaml
