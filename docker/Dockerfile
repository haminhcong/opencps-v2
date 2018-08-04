FROM gradle:4.9.0-jdk8
MAINTAINER conghm
ENV GRADLE_CACHE /home/gradle/gradle_cache
COPY bootstrap.sh /home/gradle/bootstrap.sh

USER root
VOLUME "/home/gradle/.gradle"
WORKDIR /home/gradle

RUN ["chmod", "+x", "/home/gradle/bootstrap.sh"]
ENTRYPOINT "/home/gradle/bootstrap.sh"
