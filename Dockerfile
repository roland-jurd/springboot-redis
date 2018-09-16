FROM anapsix/alpine-java

ADD ./target/redis-service.jar /app/

CMD ["java", "-Xmx200m", "-jar", "/app/redis-service.jar"]

EXPOSE 8000