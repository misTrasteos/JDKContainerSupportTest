ARG JAVA_VERSION=8

FROM openjdk:$JAVA_VERSION as builder
COPY JDKContainerSupport.java /src/JDKContainerSupport.java
WORKDIR /src
RUN javac /src/JDKContainerSupport.java

FROM openjdk:$JAVA_VERSION
WORKDIR /tmp
COPY --from=builder /src/JDKContainerSupport.class /tmp/JDKContainerSupport.class
CMD ["java", "JDKContainerSupport"]
