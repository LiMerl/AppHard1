FROM eclipse-temurin:17-jdk
COPY . /src
WORKDIR /src
RUN ["chmod +x gradlew"]
RUN ["./gradlew","build"]
CMD ["java","-jar","build/libs/demo-0.0.1-SNAPSHOT.jar"]
