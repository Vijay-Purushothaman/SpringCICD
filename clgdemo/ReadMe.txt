Create project using https://start.spring.io/



Version:
=========
Spring Boot : 3.1.0
JDK : 17

D:\2023\springbootsamples\3\clgdemo>

Maven Command
===============
mvn clean install -DskipTests
mvn spring-boot:run

docker command
===============
docker build -t clgdemo:v1 .
docker run -d -p 9998:9999 -t clgdemo:v1
docker run -d -p 9999:9999 -t clgdemo:v1


minikube start --memory=4096 --driver=docker
kubectl apply -f deployment.yaml
kubectl get deploy
kubectl get pods
kubectl get pods -o wide
kubectl apply -f service.yaml
kubectl delete svc clgdemo-java-app-service

http://localhost:9999/dept
http://localhost:9999/msgdept
http://localhost:9999/msg
http://localhost:9999/msg
http://localhost:9999/student/msg
http://localhost:9999/h2-console



POST:
http://localhost:9999/dept
{
	"deptName": "IT",
	"deptCode": "MEch-2022"
}

GET:
http://localhost:9999/dept/1
http://localhost:9999/dept



Issue at 1:34 for validation

Below is for student test


{
    "id" : "1",
    "name" : "Gana",
    "email" : "Gana@gmail.com"
}

Reference Docs:
=================
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation




input
======

{
    "deptName": "ECE",
	"deptCode": "ECE-2022"
}

{
    "deptName": "IT",
	"deptCode": "IT-2022"
}





