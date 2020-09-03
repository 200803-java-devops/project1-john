# Project Proposal

John stibbards

For project 1, I will be building an automated build and deployment tool in java. This tool will be used to simplify the process of running the varying commands necessary to build, initialize and test a java program. The primary processes I will focus on for the tool to manage are maven, junit, git, and postgres via docker containers. As there are pre existing tools that already fulfill this goal in java development, the end result for this project will ideally mirror the baseline functionality of one of these tools, such as Jenkins.

## User Stories

As a developer, I want to be able to confirm my project builds successfully so that changes pushed to github can be proven functional.
As a developer, I want to be able to remotely run any unit tests for my program so that object functionalities can be confirmed after new code is added.
As a user, I would like to be able to run a program built with maven/docker without the need to fuss with command line arguments so that I can use the program easily.

## Features

- [x] Takes input of github repository
- [x] Clones github repo in image (PUBLIC ONLY)
- [x] Reports errors or success message for maven commands Supports:
  - [x] mvn compile
  - [x] mvn test
  - [x] mvn package

- [x] Containerized using Docker
  - [x] Pushed to Dockerhub (stibbsj/buildtool)

- [x] Hosted on AWS EC2
  - [x] Accessible via <http://18.224.56.174:8443>

## How to Use

Access running instance :
Go to <http://18.224.56.174:8443/jstib>
enter link to PUBLIC ONLY github repo of java project built with maven
Press button for maven command to run on github project

Containerize :
Docker build -t stibbsj/buildtool .
Docker run --rm --name tool -it -p 8443:8443 stibbsj/buildtool:latest

Run on local machine :
mvn compile exec:java

Compile and run unit tests :
mvn compile test
