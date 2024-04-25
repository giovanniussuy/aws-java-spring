FROM openjdk:17
WORKDIR /usr/src/myapp
COPY target/aws-java-spring-0.0.1-SNAPSHOT.jar /usr/src/myapp
CMD ["java", "-jar", "/usr/src/myapp/aws-java-spring-0.0.1-SNAPSHOT.jar"]