#!/bin/bash

export PORT=8443
echo starting server on port $PORT
cd /usr/share/buildtool
java -jar /usr/share/buildtool/target/project-1.0.jar