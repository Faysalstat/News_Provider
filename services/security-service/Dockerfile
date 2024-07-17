FROM openjdk:20
EXPOSE 8761
ADD target/security-service.jar security-service.jar
ENTRYPOINT ["java","-jar","/security-service.jar"]