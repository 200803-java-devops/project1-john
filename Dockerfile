FROM openjdk:8-jre-alpine
#COPY . /usr/share/buildtool
ADD target/project-1.0.jar /usr/share/buildtool/buildtool.jar
EXPOSE 8443
#COPY entrypoint.sh /usr/share/scripts/entrypoint.sh
#ENTRYPOINT ["sh", "/usr/share/scripts/entrypoint.sh"]
ENTRYPOINT [ "/usr/bin/java", "-jar", "/usr/share/buildtool/buildtool.jar" ]