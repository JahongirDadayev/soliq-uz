FROM maven:3-openjdk-17 AS build
COPY . .
RUN mvn clean package

FROM openjdk:17.0.1-oracle
COPY --from=build target/*.jar discovery.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "discovery.jar"]