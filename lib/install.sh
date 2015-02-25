#!/bin/sh
mvn install:install-file\
    -Dfile=cdc_1.1.jar\
    -DgroupId=system\
    -DartifactId=cdc\
    -Dversion=1.1\
    -Dpackaging=jar\
    -DgeneratePom=true
