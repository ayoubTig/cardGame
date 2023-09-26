#!/bin/bash
env=$1
version=$2

java -jar -Dspring.profiles.active=$env target/card-game-$version.jar

## java -jar -Dspring.profiles.active=deve target/card-game-0.0.1.jar
