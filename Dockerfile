# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application files to the container
COPY pom.xml .
COPY src ./src

# Install Maven dependencies
RUN apt-get update && apt-get install -y maven \
    && mvn dependency:go-offline

# Build the application
RUN mvn package -DskipTests

# Expose the application port
EXPOSE 8080

# Environment variables for database connection
ENV spring.datasource.url=jdbc:mysql://food-ordering-db.cxg8usiu82yc.us-east-1.rds.amazonaws.com:3306/food-ordering-db
ENV spring.datasource.username=admin
ENV spring.datasource.password=admin123
ENV spring.jpa.hibernate.ddl-auto=update
ENV spring.jpa.show-sql=true
ENV spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
ENV server.servlet.context-path=/New-FoodOrdering

# Set the entry point for the application
CMD ["java", "-jar", "target/New-FoodOrdering-0.0.1-SNAPSHOT.jar"]
