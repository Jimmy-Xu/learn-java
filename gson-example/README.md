Example for write/reader json with gson
=======================================

# prerequisite

- jdk 1.7+
- maven 3+
- intellij idea 2016+


# build

## use maven
```
//compile
$ mvn compile

//run
$ mvn exec:java -Dexec.mainClass=Example
[INFO] Scanning for projects...
...
[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ xjimmy ---
write json to file:/home/xjimmy/test.json
read json from file:/home/xjimmy/test.json
cat = it
id = 1,ide = Eclipse,name = java
id = 2,ide = XCode,name = Swift
id = 3,ide = Visual Studio,name = C#
pop = true
[INFO] ------------------------------------------------------------------------
...
```

## use java command line

### use maven java lib
```
$ cd src/main/java

//set env
$ export JAVA_HOME=/usr/java/jdk1.7.0_79
$ export PATH=$JAVA_HOME/bin:$PATH$
$ export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$HOME/.m2/repository/com/google/code/gson/gson/2.7/gson-2.7.jar

//compile
$ javac Example.java

//run
$ java Example
write json to file:/home/xjimmy/test.json
read json from file:/home/xjimmy/test.json
cat = it
id = 1,ide = Eclipse,name = java
id = 2,ide = XCode,name = Swift
id = 3,ide = Visual Studio,name = C#
pop = true
```

### use customized java lib

> add all dependency lib(gson-2.7.jar) to `libs` dir

```
$ cd src/main/java

//set env
$ export JAVA_HOME=/usr/java/jdk1.7.0_79
$ export PATH=$JAVA_HOME/bin:$PATH$
$ export CLASSPATH=.:../../../libs:$JAVA_HOME/lib/*

//compile
$ javac Example.java

//run
$ java Example
write json to file:/home/xjimmy/test.json
read json from file:/home/xjimmy/test.json
cat = it
id = 1,ide = Eclipse,name = java
id = 2,ide = XCode,name = Swift
id = 3,ide = Visual Studio,name = C#
pop = true
```

## use intellij idea

*import project*

![](images/1.import-project-pom.xml.PNG)

![](images/2.import-project-setting.PNG)

![](images/3.import-project-select-sdk.PNG)

*import prompt*

![](images/4.auto-import-prompt.PNG)

*run*

![](images/5.run-java.PNG)


# package

## use maven

> build fat jar

```
// package with dependency  
$ mvn assembly:single
[INFO] Scanning for projects...
...
[INFO] --- maven-assembly-plugin:2.2-beta-5:single (default-cli) @ gson-example ---
[INFO] Building jar: /home/xjimmy/java/learn-java/gson-example/target/gson-example-1.0-SNAPSHOT-jar-with-dependencies.jar
...


// run 
$ java -jar target/gson-example-1.0-SNAPSHOT-jar-with-dependencies.jar 
write json to file:/home/xjimmy/test.json
read json from file:/home/xjimmy/test.json
cat = it
id = 1,ide = Eclipse,name = java
id = 2,ide = XCode,name = Swift
id = 3,ide = Visual Studio,name = C#
pop = true

```