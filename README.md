# Context
This is a test about older JVM versions not properly retrieving available CPUs and memory when running inside a container.

## Using OpenJDK 8
Last OpenJDK 8 correctly detects docker run limits

```
docker build -t mistrasteos/jdkcontainersupport:8 .
[+] Building 1.7s (11/11) FINISHED

docker run --rm -it mistrasteos/jdkcontainersupport:8
Runtime version, 1.8.0_312
Available processors, 8
Max memory, 1442840576
Total memory, 98566144
Free memory, 97024680

docker run --cpus=1 --memory=100m --rm -it mistrasteos/jdkcontainersupport:8
Runtime version, 1.8.0_312
Available processors, 1
Max memory, 50724864
Total memory, 8126464
Free memory, 7494656
```
## Using OpenJDK 8u181
This is the last version before [JDK-8146115](https://www.oracle.com/java/technologies/javase/8u191-relnotes.html#JDK-8146115) fix, so avaiable processors and memory are not correctly detected

```
docker build -t mistrasteos/jdkcontainersupport:8u131 --build-arg JAVA_VERSION=8u181 .
[+] Building 1.7s (11/11) 

docker run --rm -it mistrasteos/jdkcontainersupport:8u131
Runtime version, 1.8.0_181
Available processors, 8
Max memory, 1442840576
Total memory, 98566144
Free memory, 97024512

docker run --cpus=1 --memory=100m --rm -it mistrasteos/jdkcontainersupport:8u131
Runtime version, 1.8.0_181
Available processors, 8
Max memory, 1442840576
Total memory, 98566144
Free memory, 97024512
```

# Links
* [JDK 8u191 release note](https://www.oracle.com/java/technologies/javase/8u191-relnotes.html#JDK-8146115)
* [https://docs.docker.com/config/containers/resource_constraints/](https://docs.docker.com/config/containers/resource_constraints)
* [Running a JVM inside a container; What you need to know](https://medium.com/domain-tech/running-jvm-inside-a-container-what-you-need-to-know-aac6fa6c12c8a)
* [Be Aware of Your (Container) Surroundings](https://medium.com/97-things/be-aware-of-your-container-surroundings-40d0712fd98a)
