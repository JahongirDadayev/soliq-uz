FROM maven:3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-oracle
COPY --from=build target/*.jar billing.jar
EXPOSE 9898
ENTRYPOINT ["java", "-jar", "billing.jar"]