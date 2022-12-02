FROM eclipse-temurin:17-jdk
COPY . /src
WORKDIR /src
RUN 'chmod +x build'
RUN ["./gradlew","build"]
CMD ["java","-jar","build/libs/demo-0.0.1-SNAPSHOT.jar"]
