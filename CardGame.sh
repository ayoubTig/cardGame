#!/bin/bash

env=$1
version=$2

java -jar -Dspring.profiles.active=$env target/kit4trying-apidoc-$version.jar
