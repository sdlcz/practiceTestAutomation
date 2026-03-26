FROM maven:3.9.11-eclipse-temurin-17

WORKDIR /app

COPY pom.xml ./
COPY config.properties ./
COPY src ./src

RUN mvn -q -DskipTests dependency:go-offline

CMD ["mvn", "test"]
