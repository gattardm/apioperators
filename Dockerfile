FROM openjdk:8
EXPOSE 8383
ADD target/apioperators.jar apioperators.jar
ENTRYPOINT ["java","-jar","/apioperators.jar"]