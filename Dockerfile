
FROM openjdk:17
COPY ./target/admin*.jar admin-dashboard.jar
EXPOSE 8080
CMD ["java", "-jar", "admin-dashboard.jar"]