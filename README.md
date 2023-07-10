# Basic project showcasing QueryDSL usage

This project is for the blog post **QueryDSL for JPA** demonstrating a basic setup and usage of QueryDSL.

There are four branches in this project:

1. **main:** Maven with Java 11
2. **maven-17:** Maven with Java 17 (jakarta API)
3. **gradle:** Gradle with Java 11
4. **gradle-17:** Gradle with Java 17 (jakarta API)

When switching between Maven and Gradle branches, you might need to delete your IDE's project directory (`.idea` in Intellij IDEA) and restart the IDE to make
it recognize the changes.

### Running the Project

In Maven projects, run:

```shell
./mvnw clean install
```

In Gradle projects run:

```shell
./gradlew clean build
```

You should see the project compile successfully and the tests should run with no errors.
