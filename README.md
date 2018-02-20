# An example showing a strange logging

When starting the application, the configured endpoints are logged.

It is strange to see the a `GET` starting with `//` when it should be `/`

The current startup shows this:

```
    GET     //hello-world (se.organization.hag.greeting.GreetingResource)
```

## Build

Build with 

```
mvn clean install
```

## Run with

```
java -jar target/hitta-arbetsgivare-3.0.jar server
```