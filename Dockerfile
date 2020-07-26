FROM mcr.microsoft.com/java/jre-headless:11u2-zulu-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar app.jar
EXPOSE 8102