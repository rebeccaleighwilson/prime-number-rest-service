This code was written in response to this assignment:

Write a RESTful service which calculates and returns all the prime numbers up to and including a number provided.

Example
The REST call would look something like http://your.host.com/primes/10 and should return JSON content:

{
  "Initial":  10,
  "Primes": [2,3,5,7]
}

Requirements
The project must be written in Java 7 / 8.
The project must use Maven OR Gradle to build, test and run.
The project must have unit and integration tests.
The project must be runnable in that the service should be hosted in a container e.g. Tomcat, Jetty, Spring Boot etc.
You may use any frameworks or libraries for support e.g. Spring MVC, Apache CXF etc.
The project must be accessible from Github.


Optional Extensions
-Deploy the solution to a chosen platform that we can access.
-Consider supporting varying return content types such as XML based, that should be configurable using the requested media type.
-Consider ways to improve overall performance e.g. caching results, concurrent algorithm
-Consider supporting multiple algorithms that can be switched based on optional parameters

Please respond with the coding assignment link to github.

____________________________________________________________________

My implementation is written in Java 8 and runs with Spring Boot and Maven.
I've built it using Spring MVC, Junit and Mockito for testing and Jackson for XML.

Here's where I've uploaded it to github: https://github.com/rebeccaleighwilson/prime-number-rest-service

In order to limit the scope I haven't focused on error handling. This is something I would definitely have improved given more time.

Here's the optional extensions I did:
-Consider supporting varying return content types such as XML based, that should be configurable using the requested media type.
I've supported JSON and XML return types using the Accept header on the request. The default is JSON.

-Consider supporting multiple algorithms that can be switched based on optional parameters
I've added some query parameters to switch between a sieve algoritm and a brute force one.

?algorithm=sieve or ?algorithm=bruteforce

You can really see the difference in the response times when you start passing in values around 10000

To keep the scope managable I've left the sieve as the default and haven't added any error handling on bad parameters
If you send a request with a parameter that isn't "bruteforce" it just runs the sieve.
I honestly just ran out of time to make that part perfectly tidy.

-Consider ways to improve overall performance e.g. caching results, concurrent algorithm
I've implemented some in memory caching with Spring boot's built in tools.
I'm caching the response object. When testing this I can see the response time going down from ~150ms to ~10ms

