FROM        anapsix/alpine-java:8u121b13_server-jre_unlimited
MAINTAINER  Thomas Darimont <t.darimont@gmail.com>

ARG   BUILD_DATE
ARG   VERSION
ARG   VCS_URL
ARG   VCS_REF

# Metadata
LABEL org.label-schema.build-date=$BUILD_DATE \
      org.label-schema.name="demo-service" \
      org.label-schema.description="Dockerized Spring Boot Demo Service" \
      org.label-schema.url="https://github.com/thomasdarimont/tdlabs" \
      org.label-schema.vcs-url=$VCS_URL \
      org.label-schema.vcs-ref=$VCS_REF \
      org.label-schema.vendor="tdlabs" \
      org.label-schema.version=$VERSION \
      org.label-schema.schema-version="1.0"

ENV         PROFILES    dev
ENV         JAVA_OPTS   -Dcustom.opts=true

ADD         entry-point.sh maven/*.jar /

RUN         apk -U add tzdata && cp /usr/share/zoneinfo/Europe/Berlin /etc/localtime && \
            chmod +x entry-point.sh

EXPOSE      8080

CMD         /entry-point.sh