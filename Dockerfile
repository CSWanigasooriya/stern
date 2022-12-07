FROM openjdk:19-jdk-alpine
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} stern.war
ENTRYPOINT ["java","-jar","/stern.war"]