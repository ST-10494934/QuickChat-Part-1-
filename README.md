# Lorenza Richard - ST 10494934

# QuickChat - Part 1 (Registration & Login)

## Project Overview
This is **Part 1** of the QuickChat console application developed for **PROG5121**. 

The application allows users to:
- Register an account with username, password, South African cell number, first name, and last name
- Validate all inputs according to the specified rules
- Login using the registered credentials
- Display appropriate success and error messages

## Features Implemented
- Username validation (must contain `_` and be ≤ 5 characters)
- Password complexity validation (≥8 characters, uppercase, number, special character)
- South African cell phone number validation using regex (`+27xxxxxxxxx`)
- First name and last name collection (to match rubric welcome message)
- Secure login with correct success/failure messages
- Clean console interface with ASCII banner
- Comprehensive unit tests using JUnit 5

## Technologies Used
- Java (Maven Project)
- Apache NetBeans 
- JUnit 5 for unit testing

## How to Run
1. Open the project in NetBeans
2. Run the `QuickChatApp.java` file
3. Follow the on-screen prompts to register and login

## Project Structure
- `src/main/java/com/mycompany/quickchat/Login.java` - Core logic and validation
- `src/main/java/com/mycompany/quickchat/QuickChatApp.java` - Main application interface
- `src/test/java/com/mycompany/quickchat/LoginTest.java` - Unit tests

## Unit Tests
All unit tests are passing and cover:
- Username validation
- Password complexity
- Cell phone number validation
- Login success and failure cases

## References
Oracle (n.d.) Scanner (Java Platform SE 8). Available at: https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
 (Accessed: 02 April 2026).
JUnit (n.d.) JUnit 5 User Guide. Available at: https://junit.org/junit5/docs/current/user-guide/
 (Accessed: 02 April 2026).
Janko Sokolović (2017) Classes and Objects (The Java™ Tutorials). Available at: https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html
 (Accessed: 01 April 2026).
CloudBoost (n.d.) Simple Chat App with React and Java. Available at: https://blog.cloudboost.io/simple-chat-react-java-6923b54d65a0
 (Accessed: 8 April 2026).
Durga Software Solutions (2026) Java Chat Application Tutorial. Available at: https://www.youtube.com/watch?v=NPdyfLwBEbk
 (Accessed: 03 April 2026).
Code Crush (2025) Java Tutorial Video. Available at: https://www.youtube.com/watch?v=B-oJkLavrPE
 (Accessed: 03 April 2026).
Coding with John (2022) Java Tutorial Video. Available at: https://www.youtube.com/watch?v=vZm0lHciFsQ
 (Accessed: 05 April 2026).
Joyce Farrell (2019) Java Programming. 10th edn. Boston: Cengage Learning. (Accessed: 01 April 2026) 


