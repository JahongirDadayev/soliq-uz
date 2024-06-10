FROM maven:3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-oracle
COPY --from=build target/*.jar user.jar
EXPOSE 9897
ENTRYPOINT ["java", "-jar", "user.jar"]