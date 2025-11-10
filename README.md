Fall2025DeployingExample
========================

Prerequisites
- Docker installed and running
- JetBrains IDE (IntelliJ IDEA / Rider / Gateway)
- A Docker Hub account (username)

## The Common Docker Commands You'll Use
```bash
# build the image locally with a simple name
docker build -t imagename:latest . 

# or build with your Docker Hub username
docker build -t yourhubusername/imagename:latest .
```

- If you built the image without your Docker Hub username, tag it before pushing:

```bash
# retag the local image to the Docker Hub repository path if you have not already
docker tag imagename:latest yourhubusername/imagename:latest
```

- Run Docker Compose (use either docker-compose or the newer docker compose command depending on your Docker version):

```bash
# bring up services (rebuild images if necessary)
docker compose up

```

- Push the image to Docker Hub:

## do a docker login\
```bash
# log in to Docker Hub
docker login
#then enter your Docker Hub username and password/ follow prompts it shows you
```

```bash
# push the tag that includes your Docker Hub username
docker push yourhubusername/imagename:latest
```


Notes
- If your `Dockerfile` expects the compiled JAR to exist (COPY target/*.jar /app/app.jar), be sure you ran the Maven `package` goal (via IDE or `mvn package`) before building the image. Alternatively, change the Dockerfile to build the project during image build.
- Use `docker images` to list local images and confirm tags.
- Use `docker ps` and `docker logs <container>` to inspect running containers.

Troubleshooting (GUI-focused)
- "JAR not found" in Docker build: make sure you ran the Maven `package` goal in the IDE and that the artifact exists in `target/`.
- Dockerfile build dialog can't find Dockerfile: ensure the Dockerfile path you selected is the one in the project root.
- "No such image" in Docker push: ensure you pushed the image with the tag that includes your Docker Hub username.
- "No such image" in Docker compose up: ensure you built the image with the tag that includes your Docker Hub username.
- "Anything that says ERROR with MYSQL check DB credentials"


