# DateService
This project uses Java8. This is a small utility service which calculates days between dates using core java. No date library has been used to build this functionality.

# Requirements:
1. Only good old java! 
2. You need to have jdk 8 installed and java set in your class path to use comman line compile and run step.

# Usage: From command line tool (Executable jar)
1. Save DateServiceModule.jar to your preferred location.
2. Go to that location.
3. Type this command:
    java -jar DateServiceModule.jar
4. Follow the instruction!


# Usage: From command line tool (Compile and run)
1. go to src folder of the project
2. javac -d ../out ./com/company/main/Main.java
3. java com.company.main.Main


# Overview
1. I have used Julian day https://en.wikipedia.org/wiki/Julian_day calculationto get days.
2. Code Implementation can be found under src\com\company\main
3. Unit tests are located in \src\com\company\test
