FROM ubuntu:20.04 AS build

RUN apt update && apt install openjdk-17-jdk maven -y && rm -rf /var/lib/apt/lists/*
COPY . .

RUN mvn clean install

FROM openjdk:17-jdk-slim 
EXPOSE 8080

COPY --from=build /target/*.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
