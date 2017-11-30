FROM        openjdk:8u151-jre-slim
MAINTAINER  Thomas Darimont <t.darimont@gmail.com>

ARG   BUILD_DATE
ARG   BUILD_HOST
ARG   APP_NAME
ARG   APP_VERSION
ARG   DESCRIPTION
ARG   VENDOR_NAME
ARG   VENDOR_URL
ARG   VCS_URL
ARG   VCS_REF

# Metadata
LABEL org.label-schema.build-date=$BUILD_DATE \
      org.label-schema.build-host=$BUILD_HOST \
      org.label-schema.name="$APP_NAME" \
      org.label-schema.description="$DESCRIPTION" \
      org.label-schema.url="$VENDOR_URL" \
      org.label-schema.vcs-url=$VCS_URL \
      org.label-schema.vcs-ref=$VCS_REF \
      org.label-schema.vendor="$VENDOR_NAME" \
      org.label-schema.version=$APP_VERSION \
      org.label-schema.schema-version="1.0"

ENV         PROFILES       dev

ENV         JAVA_OPTS      -Djava.net.preferIPv4Stack=true \
                           -Djava.awt.headless=true \
                           -Djava.security.egd=file:/dev/./urandom \
                           -Xms128M \
                           -Xmx1G \
                           -XX:MetaspaceSize=128M \
                           -XX:MaxMetaspaceSize=256m

ENV         APP_NAME       $APP_NAME

ENV         APP_VERSION    $APP_VERSION

# Set REMOTE_DEBUG to 1 to enable remote debugging
ENV         REMOTE_DEBUG   0

EXPOSE      8080 8787

RUN         mkdir -p /app

ADD         entry-point.sh maven/*.jar /app/

USER root

RUN         apk -U add tzdata \
            && cp /usr/share/zoneinfo/Europe/Berlin /etc/localtime \
            && chmod +x /app/entry-point.sh

RUN         addgroup -S appgrp -g 1000 \
            && adduser -S -g appgrp app \
            && chown -R app /app \
            && chmod -R "g+rwX" /app \
            && chown -R app:appgrp /app

USER app

CMD         ["sh","/app/entry-point.sh"]