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
If you working behind a proxy please consider adding gradle.properties file
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