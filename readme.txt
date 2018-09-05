This project uses Java8.
Please download java if you don't have java locally installed.You need to have java set in your classpath.

#################################################
Usage: From command line tool (Executable jar)
1. Save DateServiceModule.jar to your preferred location.
2. Go to that location.
3. Type this command:
    java -jar DateServiceModule.jar
4. Follow the instruction and enjoy!


################################################
Usage: From command line tool (Compile and run)
1. go to src folder of the project
2. javac ./com/company/main/Main.java
3. java com/company/main/Main


#################################################
I have used Julian day https://en.wikipedia.org/wiki/Julian_day calculationto get days.
Code Implementation can be found under src\com\company\main
Unit tests are located in \src\com\company\test


#################################################
C:\Users\s111591\Downloads\DateServiceModule\src>javac -d ../out ./com/company/main/Main.java
C:\Users\s111591\Downloads\DateServiceModule\out>java com.company.main.Main
java com.company.main.Main