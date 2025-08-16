# Europa Exploration Mission - Navigation Module

This project is a Java-based solution for the MaxHome take-home assignment, Part 1. It simulates the navigation of robotic rovers on a rectangular plateau on Jupiter's moon, Europa, using the Gradle build tool.

## Assumptions

1.  Valid Input Format: The program assumes that the input provided via standard input is well-formed and follows the format specified in the problem description. No validation is performed on the input structure itself.

2.  Boundary Behavior: A rover will ignore any 'M' (move) instruction that would cause it to fall off the plateau. It will remain in its last valid position and continue processing the next instruction in its command sequence.

3.  Case-sensitive Instructions: The instruction processing for 'L', 'R', and 'M' is case-sensitive.

##  How to Use

### Running the Application

The project is configured to be run easily from the command line using the Gradle Wrapper.

1. Clone the Repository
```
git clone https://github.com/sj902/maxhome-assignment.git
cd  maxhome-assignment  
```

2. Make the Wrapper Executable
```
chmod +x ./gradlew  
  ```

3. Run the Application

You can run the application and provide input in two ways:

-   File Input:  
    Add the commands input to `input.txt`, then run
    ```
    ./gradlew run<input.txt        
    ```  

##  How to Run Tests

To compile the project and run all the JUnit 5 unit tests, execute the test task:
```
./gradlew test  
  ```
