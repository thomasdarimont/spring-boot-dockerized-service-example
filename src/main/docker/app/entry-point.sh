#!/bin/sh

# environment variables, e.g. PATH, are not available when executing "docker exec bash -l", so persist it for login shells
env | grep -vwe '_\|HOSTNAME\|PWD\|SHLVL' | awk '{print "export " $0}' > /etc/profile.d/environment.sh

echo
echo "Using Java Version"
java -version

echo
echo "Starting App " $(ls *.jar)
java $JAVA_OPTS -jar /*.jar $@