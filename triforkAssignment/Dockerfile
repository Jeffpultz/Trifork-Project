FROM gradle:7.2 AS BUILD
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradlew build

FROM openjdk:17-alpine
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/triforkassignment-0.0.1-SNAPSHOT.jar /app/
RUN `touch /app/triforkassignment-0.0.1-SNAPSHOT.jar`
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseContainerSupport", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app/triforkassignment-0.0.1-SNAPSHOT.jar"]
