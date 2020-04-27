FROM openjdk:8-jdk-alpine

COPY . /boot_mysql
WORKDIR /boot_mysql

CMD ["./gradlew", "bootRun"]

