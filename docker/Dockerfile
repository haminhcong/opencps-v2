FROM gradle:4.9.0-jdk8
MAINTAINER opencpsv2
ENV GRADLE_CACHE /home/gradle/gradle_cache
COPY bootstrap.sh /home/gradle/bootstrap.sh
USER root

RUN ["mkdir", "-p", "/home/gradle"]
RUN ["mkdir", "-p", "/home/gradle/.gradle"]

WORKDIR /home/gradle

RUN ["chmod", "+x", "/home/gradle/bootstrap.sh"]

ENTRYPOINT "/home/gradle/bootstrap.sh"