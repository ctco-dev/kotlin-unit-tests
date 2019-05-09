# About

This project was designed for various JVM Unit Test frameworks comparison.
Target code is written in Kotlin. It could be found in "application" module.

# Contributing

Examples for each framework should be placed in a dedicated Gradle module 
named examples-${framework}.

Check examples-junit as a reference.

Before adding a new framework please check for relevant issues on github. 
Maybe someone already took over this task. 
* https://github.com/ctco-dev/kotlin-unit-tests/issues  

Also, please use pull requests for code validation.

# Known Issues
* If you working behind a proxy please consider adding gradle.properties file
```
systemProp.http.proxyHost=${proxy host}
systemProp.http.proxyProtocol=http
systemProp.http.proxyPort=${proxy port}
systemProp.http.nonProxyHosts=*.${corporate domain}|localhost
systemProp.https.proxyHost=${proxy host}
systemProp.https.proxyProtocol=http
systemProp.https.proxyPort=${proxy port}
systemProp.https.nonProxyHosts=*.${corporate domain}|localhost
```

* Currently the mocking workarounds (as in `org.mockito.plugins.MockMaker`) seem to work only on a HotSpot-derived JVM. On a SR IBM JDK 8.0-5.27 running `./gradlew build` results in
```
> Task :examples-junit:test

com.home.services.ServiceTest > shouldCombine() FAILED
    org.mockito.exceptions.base.MockitoException at ServiceTest.kt:12
        Caused by: org.mockito.exceptions.base.MockitoException at ServiceTest.kt:12
            Caused by: java.lang.instrument.UnmodifiableClassException at ServiceTest.kt:12

12 tests completed, 1 failed

> Task :examples-junit:test FAILED

FAILURE: Build failed with an exception.
```

Same thing happens on a OpenJ9-based OpenJDK 11
