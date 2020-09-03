FROM debian:latest
RUN apt-get -y update
RUN apt-get -y install openjdk-11-jdk-headless
RUN apt-get -y install git
RUN apt-get -y install maven
COPY . /usr/share/buildtool
#ADD target/project-1.0.jar /usr/share/buildtool/buildtool.jar
EXPOSE 8443
COPY entrypoint.sh /usr/share/scripts/entrypoint.sh
ENTRYPOINT ["sh", "/usr/share/scripts/entrypoint.sh"]
#ENTRYPOINT [ "/usr/bin/java", "-jar", "/usr/share/buildtool/buildtool.jar" ]