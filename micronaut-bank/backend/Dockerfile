FROM alpine:latest
RUN apk update
RUN apk add --no-cache openjdk11
COPY build/libs/bank-*-all.jar app.jar
EXPOSE 8080
CMD java -jar app.jar
