# jenkins-hello-world
Basic Spring Boot REST controller example - just Hello World endpoint

### DSO files
* Jenkinsfile
* Dockerfile
* helm chart

### Docker commands
    # Build the image
    docker build -t jenkins-hello:1.0.0 .

    # Run the container
    docker run --rm -d --name jenkins-hello -p 8080:8080 jenkins-hello:1.0.0

### helm chart
    helm install <release> ./helm --namespace <name>
