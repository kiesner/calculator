# see https://hub.docker.com/_/eclipse-temurin
FROM eclipse-temurin:21-jre

LABEL company="it-schulungen.com" \
      author="Bernhard Löwenstein"

WORKDIR /opt/app

COPY target/calculator.jar \
     .

EXPOSE 8080

CMD [ \
    "java", \
    "-jar", "calculator.jar" \
]