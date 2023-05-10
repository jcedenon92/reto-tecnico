FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY ./target/reto-tecnico-0.0.1-SNAPSHOT.jar .

#RUN ./mvnw clean package -DskipTests

EXPOSE 8005

ENTRYPOINT ["java", "-jar", "reto-tecnico-0.0.1-SNAPSHOT.jar"]