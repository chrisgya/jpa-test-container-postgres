mvnw spring-boot:build-image
docker run --tty --publish 8080:8080 devtool-docker-image:0.0.1-SNAPSHOT


--spring.profiles.active=dev