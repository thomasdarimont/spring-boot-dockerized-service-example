# Build docker image
```
mvn clean package -DskipTests docker:build
```

# Run docker image
```
docker run -it --rm --name demo-service -e REMOTE_DEBUG=1 -p 8080:8080 de.tdlabs/demo-service
```

# Show Docker Image Metadata
```
docker inspect de.tdlabs/demo-service:latest | jq '.[0].Config.Labels'
```

Result:
```json
{
  "org.label-schema.build-date": "2017-03-24T00:09:12+0100",
  "org.label-schema.build-host": "euler",
  "org.label-schema.description": "Demo project for Spring Boot",
  "org.label-schema.name": "demo-service",
  "org.label-schema.schema-version": "1.0",
  "org.label-schema.url": "https://github.com/thomasdarimont",
  "org.label-schema.vcs-ref": "53aa3b9",
  "org.label-schema.vcs-url": "https://github.com/thomasdarimont/demo-service",
  "org.label-schema.vendor": "tdlabs",
  "org.label-schema.version": "0.0.1.BUILD-SNAPSHOT"
}
```