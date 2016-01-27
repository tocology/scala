# Scala

This repository for writing and testing scala code.

## Development

### Preperation

Basically, SBT is used at this project. So, we need to set up SBT.
However, if you have any IDE for scala, we can skip the following steps.

First, install the SBT at your workspace.

**Ubuntu**
```console
> echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
> sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 642AC823
> sudo apt-get update   
  # maybe you need to install apt-transport-https first. At that time, 'sudo apt-get install apt-transport-https' before this command.
> sudo apt-get install sbt
```

**Mac**
```console
> brew install sbt
```

It can be install at other OS like Windows; Please check [Scala-Sbt-Setup](http://www.scala-sbt.org/0.13/docs/Setup.html "Sbt Setup") for detail.

Next, we should make directories for Sources, Test and Recources respectivily and lastly lib
; At this project, directories have been already built.

* Sources in the base directory
* Sources in src/main/scala or src/main/java
* Tests in src/test/scala or src/test/java
* Data files in src/main/resources or src/test/resources
* jars in lib


**Note**
In this Project, we use Java8.
If you don't, please enter and follow some steps from this link.
<http://www.tecmint.com/install-java-jdk-jre-in-linux/>


### Run

There is an Example for Akka actors(progscala2.introscala.shapes._), 
so you can run this sample by following commands.
```console
> sbt run
```