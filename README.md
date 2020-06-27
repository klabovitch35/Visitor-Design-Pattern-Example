# Project Template

This is a Java Maven Project Template

#Provide a description of the application use case scenario that you have selected for your final project.

The video recording is uploaded and published on blackboard.

The use case that I have found for applying the Visitor pattern is for creating a report on a tennis match. In a tennis match,
data is aggregated under its parent, Matches are collections of Sets, Sets are collections of games, games are collections of points, 
etc. A report needs to be able to go through all of these components and subcomponents, and aggregate information about the whole
as well as its individual parts. My goal through my design was to build a hierarchy of Match components in a way that was
simple and understandable as possible, and utilize the Visitor pattern to make the reporting understandable. I also used the Factory pattern to
make data setup easier, and encapsulate any logic to create instances of MatchComponents in the class. 

In my architecture, I aggregate all components under the one directly related to it in an ArrayList. These components are all included
in the package MatchComponents. This fulfills the design goal of low coupling, as each component only knows about the one below it, and is
not dependent on the one above it, and high cohesion, as all of these classes relate to each other being parts of the same match. The flexibility
of my design means that if a new type of match component is added (e.g. the individual shots that make up a point), or if Sets need to be decomposed into
subsets, then the new type can extend the Match Component abstract class template requiring no other classes to change. If a new type of report is needed, 
then that report type can implement the MatchVisitor type, with the template laid out to ensure standardization.





# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run

```bash
mvn -q clean compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" -Dlog4j.configuration="file:log4j.properties"
```

We recommand the above command for running the project. 

Alternativly, you can run the following command. It will generate a single jar file with all of the dependencies. 

```bash
mvn clean compile assembly:single

java -Dlog4j.configuration=file:log4j.properties -classpath ./target/JavaProjectTemplate-1.0-SNAPSHOT-jar-with-dependencies.jar  edu.bu.met.cs665.Main
```


# Run all the unit test classes.


```bash
mvn clean compile test

```

# Using Findbugs 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn findbugs:gui 
```

or 


```bash
mvn findbugs:findbugs
```


For more info about FindBugs see 

http://findbugs.sourceforge.net/

And about Maven Findbug plugin see 
https://gleclaire.github.io/findbugs-maven-plugin/index.html


You can install Findbugs Eclipse Plugin 

http://findbugs.sourceforge.net/manual/eclipse.html



SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```


# Generate  coveralls:report 

You can find more info about coveralls 

https://coveralls.io/

```bash
mvn -DrepoToken=YOUR-REPO-TOCKEN-ON-COVERALLS  cobertura:cobertura coveralls:report
```


