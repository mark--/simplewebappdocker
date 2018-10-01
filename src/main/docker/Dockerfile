#FROM localhost:8083/centos:7
FROM centos:7
EXPOSE 8080
RUN yum install -y tomcat
#RUN systemctl enable tomcat
COPY postgresql-42.2.5.jar /usr/share/tomcat/lib
COPY tomcat-dbcp-7.0.30.jar /usr/share/java/tomcat-dbcp-7.0.30.jar
COPY context.xml /usr/share/tomcat/conf/context.xml
COPY app/simplewebapp.war /usr/share/tomcat/webapps/
ENTRYPOINT /usr/lib/jvm/jre/bin/java -classpath /usr/share/tomcat/bin/bootstrap.jar:/usr/share/tomcat/bin/tomcat-juli.jar:/usr/share/java/commons-daemon.jar -Dcatalina.base=/usr/share/tomcat -Dcatalina.home=/usr/share/tomcat -Djava.endorsed.dirs= -Djava.io.tmpdir=/var/cache/tomcat/temp -Djava.util.logging.config.file=/usr/share/tomcat/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager org.apache.catalina.startup.Bootstrap start
