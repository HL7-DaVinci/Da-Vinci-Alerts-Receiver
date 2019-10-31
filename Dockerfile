FROM openjdk:8-jdk-slim AS builder

COPY *.gradle gradle.* gradlew /src/
COPY gradle /src/gradle
WORKDIR /src
RUN ./gradlew resolveDependencies
COPY . .
RUN ./gradlew build


FROM openjdk:8-jre-alpine
COPY ./docker-entrypoint.sh /
COPY --from=builder /src/build/libs/receiver-*.jar /service.jar
EXPOSE 8081
ENTRYPOINT ["sh", "/docker-entrypoint.sh"]