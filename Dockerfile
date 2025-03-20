FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE = itx-test-202-boot/target/*.jar

# cd /opt/app
WORKDIR /opt/app

# cp $JAR_FILE /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# Run the entry point: java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

