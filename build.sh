#!/bin/sh
javac *.java
jar cfm MConvert.jar manifest.txt *.class