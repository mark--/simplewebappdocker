FROM localhost:8083/centos:7
EXPOSE 8080
RUN yum install -y tomcat
RUN systemctl enable tomcat
COPY res/simplewebapp.war /usr/share/tomcat/webapps/
ENTRYPOINT /usr/sbin/init
