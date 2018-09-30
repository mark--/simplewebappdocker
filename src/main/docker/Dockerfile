##FROM localhost:8083/centos:7
#FROM centos:7
#EXPOSE 8080
#RUN yum install -y tomcat
##RUN systemctl enable tomcat
##COPY res/context.xml /usr/share/tomcat/conf/
#COPY res/postgres-demo.war /usr/share/tomcat/webapps/
#ENTRYPOINT /usr/lib/jvm/jre/bin/java -classpath /usr/share/tomcat/bin/bootstrap.jar:/usr/share/tomcat/bin/tomcat-juli.jar:/usr/share/java/commons-daemon.jar -Dcatalina.base=/usr/share/tomcat -Dcatalina.home=/usr/share/tomcat -Djava.endorsed.dirs= -Djava.io.tmpdir=/var/cache/tomcat/temp -Djava.util.logging.config.file=/usr/share/tomcat/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager org.apache.catalina.startup.Bootstrap start

FROM tomcat
MAINTAINER mete
#RUN apt-get update && apt-get -y upgrade
WORKDIR /usr/local/tomcat
#COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
#COPY context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml

COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY manager-context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml

EXPOSE 8080
COPY res/simplewebapp.war /usr/local/tomcat/webapps/
ENTRYPOINT [ "/usr/local/tomcat/bin/catalina.sh" ]
CMD [ "run" ]
