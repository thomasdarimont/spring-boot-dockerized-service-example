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