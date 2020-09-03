FROM openjdk:8-jre-alpine
COPY . /usr/share/buildtool
EXPOSE 8443
COPY entrypoint.sh /usr/share/scripts/entrypoint.sh
ENTRYPOINT ["sh", "/usr/share/scripts/entrypoint.sh"]