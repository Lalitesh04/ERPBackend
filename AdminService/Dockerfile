# Stage 1: Build the application
FROM eclipse-temurin:21-jdk-jammy AS build

# Set working directory
WORKDIR /app

# Copy only the files needed for dependency resolution
COPY pom.xml .

# Download dependencies for offline use
RUN apt-get update && apt-get install -y maven \
    && mvn dependency:go-offline -B \
    && apt-get clean && rm -rf /var/lib/apt/lists/*

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Create the final runtime image
FROM eclipse-temurin:21-jre-jammy

# Set working directory
WORKDIR /app

# Copy the built application JAR from the build stage
COPY --from=build /app/target/AdminService-0.0.1-SNAPSHOT.jar /app/AdminService.jar

# Expose the application port
EXPOSE 2001

# Set the default entry point
ENTRYPOINT ["java", "-jar", "/app/AdminService.jar"]
