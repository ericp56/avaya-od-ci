# avaya-od-ci 
Example of setting up an Avaya OD app with maven for build-time integration testing

## Features

- maven pom.xml which runs unit tests, integration tests and packages the war file

## Setup
Before running the mvn verify and package commands, you will have to install a few jars in your local maven repo.

- Install scert-07.23.08.01.jar (found in an OD app's WEB-INF/lib folder) and scertcommon-07.23.08.01.jar (found in the web server's lib folder):

``` bash
mvn install:install-file -Dfile=scert-07.23.08.01.jar  -DgroupId=com.avaya -DartifactId=scert -Dversion=07.23.08.01 -Dpackaging=jar
mvn install:install-file -Dfile=scertcommon-07.23.08.01.jar  -DgroupId=com.avaya -DartifactId=scertcommon -Dversion=07.23.08.01 -Dpackaging=jar
``` 
 - Also, clone and install the voicexml-util project

``` bash
git clone git@github.com:ericp56/voicexml-util.git
cd voicexml-util
mvn install
```

## Demo

### Maven Integration Test and Packaging

This will perform like a typical maven war package goal, but it will also deploy the app on an embedded Tomcat and use voicexml-util to run the integration tests.

- See SimpleIntegrationTest.java for the sample testing of the deployed app.

I added in #comment lines below, noting points of interest.

``` bash
# Here's the maven command
[ericp@local avaya-od-ci]$ mvn clean verify package
[INFO] 
[INFO] ---------------------< com.avaya.demo:MyMathQuiz >----------------------
[INFO] Building MyMathQuiz 1
[INFO] --------------------------------[ war ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ MyMathQuiz ---
[INFO] Deleting /home/ericp/Workspaces/avaya-od-ci/target
[INFO] 
[INFO] --- build-helper-maven-plugin:3.2.0:add-source (add-source) @ MyMathQuiz ---
[INFO] Source directory: /home/ericp/Workspaces/avaya-od-ci/WEB-INF/src added.
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ MyMathQuiz ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ericp/Workspaces/avaya-od-ci/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ MyMathQuiz ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 34 source files to /home/ericp/Workspaces/avaya-od-ci/target/classes
[INFO] /home/ericp/Workspaces/avaya-od-ci/WEB-INF/src/flow/RandomNumberGenerator.java: Some input files use unchecked or unsafe operations.
[INFO] /home/ericp/Workspaces/avaya-od-ci/WEB-INF/src/flow/RandomNumberGenerator.java: Recompile with -Xlint:unchecked for details.
[INFO] 
[INFO] --- build-helper-maven-plugin:3.2.0:add-test-source (add-integration-test-sources) @ MyMathQuiz ---
[INFO] Test Source directory: /home/ericp/Workspaces/avaya-od-ci/src/integration-test/java added.
[INFO] 
[INFO] --- build-helper-maven-plugin:3.2.0:add-test-resource (add-integration-test-resources) @ MyMathQuiz ---
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ MyMathQuiz ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ericp/Workspaces/avaya-od-ci/src/test/resources
[INFO] skip non existing resourceDirectory /home/ericp/Workspaces/avaya-od-ci/src/integration-test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ MyMathQuiz ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /home/ericp/Workspaces/avaya-od-ci/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ MyMathQuiz ---
[INFO] 
# Unit tests...
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running flow.SimpleUnitTest
*********UNIT TEST*********
*********UNIT TEST*********
*********UNIT TEST*********
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.009 s - in flow.SimpleUnitTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-war-plugin:3.2.2:war (default-war) @ MyMathQuiz ---
[INFO] Packaging webapp
[INFO] Assembling webapp [MyMathQuiz] in [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz]
[INFO] Processing war project
[INFO] Copying webapp webResources [/home/ericp/Workspaces/avaya-od-ci/WEB-INF/lib] to [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz]
[INFO] Copying webapp webResources [/home/ericp/Workspaces/avaya-od-ci/data] to [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz]
[INFO] Copying webapp webResources [/home/ericp/Workspaces/avaya-od-ci/icons] to [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz]
[INFO] Webapp assembled in [104 msecs]
[INFO] Building war: /home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz.war
[INFO] 
#Starting Tomcat
[INFO] >>> tomcat7-maven-plugin:2.2:run-war (start-tomcat) > package @ MyMathQuiz >>>
[INFO] 
[INFO] --- build-helper-maven-plugin:3.2.0:add-source (add-source) @ MyMathQuiz ---
[INFO] Source directory: /home/ericp/Workspaces/avaya-od-ci/WEB-INF/src added.
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ MyMathQuiz ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ericp/Workspaces/avaya-od-ci/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ MyMathQuiz ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- build-helper-maven-plugin:3.2.0:add-test-source (add-integration-test-sources) @ MyMathQuiz ---
[INFO] Test Source directory: /home/ericp/Workspaces/avaya-od-ci/src/integration-test/java added.
[INFO] 
[INFO] --- build-helper-maven-plugin:3.2.0:add-test-resource (add-integration-test-resources) @ MyMathQuiz ---
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ MyMathQuiz ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ericp/Workspaces/avaya-od-ci/src/test/resources
[INFO] skip non existing resourceDirectory /home/ericp/Workspaces/avaya-od-ci/src/integration-test/resources
[INFO] skip non existing resourceDirectory /home/ericp/Workspaces/avaya-od-ci/src/integration-test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ MyMathQuiz ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ MyMathQuiz ---
[INFO] Skipping execution of surefire because it has already been run for this configuration
[INFO] 
[INFO] --- maven-war-plugin:3.2.2:war (default-war) @ MyMathQuiz ---
[INFO] Packaging webapp
[INFO] Assembling webapp [MyMathQuiz] in [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz]
[INFO] Processing war project
[INFO] Copying webapp webResources [/home/ericp/Workspaces/avaya-od-ci/WEB-INF/lib] to [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz]
[INFO] Copying webapp webResources [/home/ericp/Workspaces/avaya-od-ci/data] to [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz]
[INFO] Copying webapp webResources [/home/ericp/Workspaces/avaya-od-ci/icons] to [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz]
[INFO] Webapp assembled in [77 msecs]
[INFO] Building war: /home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz.war
[INFO] 
[INFO] <<< tomcat7-maven-plugin:2.2:run-war (start-tomcat) < package @ MyMathQuiz <<<
[INFO] 
[INFO] 
[INFO] --- tomcat7-maven-plugin:2.2:run-war (start-tomcat) @ MyMathQuiz ---
[INFO] Running war on http://localhost:8080/MyMathQuiz
[INFO] Creating Tomcat server configuration at /home/ericp/Workspaces/avaya-od-ci/target/tomcat
[INFO] create webapp with contextPath: /MyMathQuiz
Jun 09, 2021 9:46:07 PM org.apache.coyote.AbstractProtocol init
INFO: Initializing ProtocolHandler ["http-bio-8080"]
Jun 09, 2021 9:46:07 PM org.apache.catalina.core.StandardService startInternal
INFO: Starting service Tomcat
Jun 09, 2021 9:46:07 PM org.apache.catalina.core.StandardEngine startInternal
INFO: Starting Servlet Engine: Apache Tomcat/7.0.47
Jun 09, 2021 9:46:08 PM org.apache.coyote.AbstractProtocol start
INFO: Starting ProtocolHandler ["http-bio-8080"]
#Tomcat is up, time for testing!
[INFO] 
[INFO] --- maven-failsafe-plugin:2.22.1:integration-test (default) @ MyMathQuiz ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running flow.SimpleIntegrationTest
*********INTEGRATION TEST*********
log4j:WARN No appenders could be found for logger (org.apache.http.client.protocol.RequestAddCookies).
log4j:WARN Please initialize the log4j system properly.
#ddconfig allowing temporary running of app without license server, but this will be regenerated with every "clean verify" instruction
INFO: Using path [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz/WEB-INF/lib/ddconfig.xml] to configuration file
INFO: No runtimeconfigextensions.xml file found, skipping.
File [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz/WEB-INF/lib/ddconfig.xml] could not be found, using empty configuration file
# Here's the OD app logging as the integration test is running.
09/06/2021 21:46:09  INFO - Start | channel:unknown | MyMathQuiz:Welcome | Play Prompt | Welcome to the math quiz. |  |  | 
09/06/2021 21:46:09  INFO - In Progress | channel:unknown | MyMathQuiz:MathQuizChoice | Play Prompt | Would you like to be quizzed on Addition, Subtraction, Multiplication or Division? |  |  | 
09/06/2021 21:46:09  INFO - In Progress | channel:unknown | MyMathQuiz:calculate | Choices | Caller chose to be quized on  | MathQuizChoice:interpretation | addition | 
09/06/2021 21:46:09  INFO - In Progress | channel:unknown | MyMathQuiz:calculate | Score | Total number of questions so far are  | TotalQuestions | 1 | 
09/06/2021 21:46:09  INFO - In Progress | channel:unknown | MyMathQuiz:calculate | Quiz Question | What is  | Temp | 7 plus 9? | 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.034 s - in flow.SimpleIntegrationTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
#Success!  Tear down the tomcat service.
[INFO] --- tomcat7-maven-plugin:2.2:shutdown (stop-tomcat) @ MyMathQuiz ---
Jun 09, 2021 9:46:10 PM org.apache.coyote.AbstractProtocol pause
INFO: Pausing ProtocolHandler ["http-bio-8080"]
Jun 09, 2021 9:46:10 PM org.apache.catalina.core.StandardService stopInternal
INFO: Stopping service Tomcat
Jun 09, 2021 9:46:10 PM org.apache.catalina.loader.WebappClassLoader clearReferencesThreads
SEVERE: The web application [/MyMathQuiz] appears to have started a thread named [DebugInfo] but has failed to stop it. This is very likely to create a memory leak.
Jun 09, 2021 9:46:10 PM org.apache.catalina.loader.WebappClassLoader clearReferencesThreads
SEVERE: The web application [/MyMathQuiz] appears to have started a thread named [LicenseTimer-certCheck] but has failed to stop it. This is very likely to create a memory leak.
Jun 09, 2021 9:46:10 PM org.apache.catalina.loader.WebappClassLoader clearReferencesThreads
SEVERE: The web application [/MyMathQuiz] appears to have started a thread named [LicenseTimer-Refresh] but has failed to stop it. This is very likely to create a memory leak.
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.apache.catalina.loader.WebappClassLoader (file:/home/ericp/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/7.0.47/tomcat-embed-core-7.0.47.jar) to field java.lang.Thread.threadLocals
WARNING: Please consider reporting this to the maintainers of org.apache.catalina.loader.WebappClassLoader
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
Jun 09, 2021 9:46:10 PM org.apache.coyote.AbstractProtocol stop
INFO: Stopping ProtocolHandler ["http-bio-8080"]
[INFO] 
[INFO] --- maven-failsafe-plugin:2.22.1:verify (default) @ MyMathQuiz ---
[INFO] 
[INFO] --- build-helper-maven-plugin:3.2.0:add-source (add-source) @ MyMathQuiz ---
[INFO] Source directory: /home/ericp/Workspaces/avaya-od-ci/WEB-INF/src added.
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ MyMathQuiz ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ericp/Workspaces/avaya-od-ci/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ MyMathQuiz ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- build-helper-maven-plugin:3.2.0:add-test-source (add-integration-test-sources) @ MyMathQuiz ---
[INFO] Test Source directory: /home/ericp/Workspaces/avaya-od-ci/src/integration-test/java added.
[INFO] 
[INFO] --- build-helper-maven-plugin:3.2.0:add-test-resource (add-integration-test-resources) @ MyMathQuiz ---
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ MyMathQuiz ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ericp/Workspaces/avaya-od-ci/src/test/resources
[INFO] skip non existing resourceDirectory /home/ericp/Workspaces/avaya-od-ci/src/integration-test/resources
[INFO] skip non existing resourceDirectory /home/ericp/Workspaces/avaya-od-ci/src/integration-test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ MyMathQuiz ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ MyMathQuiz ---
[INFO] Skipping execution of surefire because it has already been run for this configuration
[INFO] 
[INFO] --- maven-war-plugin:3.2.2:war (default-war) @ MyMathQuiz ---
[INFO] Packaging webapp
[INFO] Assembling webapp [MyMathQuiz] in [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz]
[INFO] Processing war project
[INFO] Copying webapp webResources [/home/ericp/Workspaces/avaya-od-ci/WEB-INF/lib] to [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz]
[INFO] Copying webapp webResources [/home/ericp/Workspaces/avaya-od-ci/data] to [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz]
[INFO] Copying webapp webResources [/home/ericp/Workspaces/avaya-od-ci/icons] to [/home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz]
[INFO] Webapp assembled in [63 msecs]
#All done, and here's the war file
[INFO] Building war: /home/ericp/Workspaces/avaya-od-ci/target/MyMathQuiz.war
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.022 s
[INFO] Finished at: 2021-06-09T21:46:10-04:00
[INFO] ------------------------------------------------------------------------

```

## Contact 

For support and feedback, email ericp@nextivr.com

## Authors

- [@ericp56](https://www.github.com/ericp56)



