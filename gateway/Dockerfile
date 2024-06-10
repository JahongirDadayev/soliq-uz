FROM maven:3-openjdk-17 AS build
COPY . .
RUN mvn clean package

FROM openjdk:17.0.1-oracle
COPY --from=build target/*.jar gateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gateway.jar"]