FROM openjdk:17-oracle
EXPOSE 9999
VOLUME /tmp
ARG JAR_FILE=target/clgdemo-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} clgdemo
ENTRYPOINT ["java","-jar","clgdemo"]