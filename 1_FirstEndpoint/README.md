## Spring Boot projects

This is the first mini-project folder followed by other files soon

### What this file do? 

This mini-project was made to test how end-points work with spring-boot.

There is just one end-point, which is /greetings/greeting/{content}, and it prints a message "Hello, {content}".
The "content" is a placeholder informed by path variable.

#### How to run it

With the terminal, get in the folder where the pom.xml is, and write "mvn clean package spring-boot:run" (or just click on the run button in your IDE). To use the endpoint, you can use a browser of your preference, just pass
http://localhost:8080/greetings/greeting/{content} in the search bar.




