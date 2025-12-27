# =============================================================================
# MULTI-STAGE DOCKERFILE FOR SPRING BOOT APPLICATION
# =============================================================================
# This Dockerfile uses a multi-stage build to:
# 1. Build the application in a Maven container (with JDK)
# 2. Run the application in a lightweight JRE container
# This approach reduces the final image size significantly (~370MB vs ~500MB+)
# =============================================================================

# -----------------------------------------------------------------------------
# STAGE 1: BUILD STAGE
# -----------------------------------------------------------------------------
# Purpose: Compile the Java source code and package it into a JAR file
# We use Maven image with JDK 17 to build the project
# The 'AS build' names this stage so we can reference it later

FROM maven:3.9-eclipse-temurin-17 AS build

# Set the working directory inside the container
# All subsequent commands will run from this directory
WORKDIR /app

# Copy the Maven configuration file first (for better Docker layer caching)
# If pom.xml hasn't changed, Docker will use cached dependencies
COPY pom.xml .

# Copy the source code into the container
COPY src ./src

# Run Maven to build the project:
# - 'clean': Removes any previous build artifacts
# - 'package': Compiles code and creates JAR file in /app/target/
# - '-DskipTests': Skips running tests to speed up the build
RUN mvn clean package -DskipTests

# -----------------------------------------------------------------------------
# STAGE 2: RUN STAGE
# -----------------------------------------------------------------------------
# Purpose: Create a lightweight container to run the application
# We use Alpine-based JRE image (smaller than full JDK)
# Only the compiled JAR is copied from the build stage

FROM eclipse-temurin:21-jre

# Set the working directory for the runtime container
WORKDIR /app

# Copy ONLY the JAR file from the build stage
# '--from=build' references the first stage named 'build'
# This is the key to multi-stage builds - we discard the Maven/source code
COPY --from=build /app/target/*.jar app.jar

# Document which port the application listens on
# This is informational - you still need to map ports with -p or in docker-compose
EXPOSE 4000

# Define the command to run when the container starts
# ENTRYPOINT is preferred over CMD for applications that should always run
# -Duser.timezone=Asia/Kolkata fixes PostgreSQL 18 timezone compatibility
# (PostgreSQL 18 doesn't recognize deprecated "Asia/Calcutta" timezone)
ENTRYPOINT ["java", "-Duser.timezone=Asia/Kolkata", "-jar", "app.jar"]