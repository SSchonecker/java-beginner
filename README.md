# java-beginner
These are some of the beginner exercises.

## Quote of the day
Write a short program that, when started, prints a quote of the day on the screen.<br/>
The Quotes:
 - "galileo": "eppur si muove"
 - "archimedes": "eureka!"
 - "erasmus": "in regione caecorum rex est luscus"
 - "socrates": "I know nothing except the fact of my ignorance"
 - "rené descartes": "cogito, ergo sum"
 - "sir isaac newton": "if I have seen further it is by standing on the shoulders of giants"
 
Modify the quotes such that the program outputs the quote of the day in the following format:
```
Quote for Monday the 1th of February:
"Eureka!" -- Archimedes
```
A quote is printed between quotation marks, starts with a capital letter and ends with a full stop. If the quote ends with punctuation, do not add the full stop to the end of the sentence. For example eppur si muove becomes "Eppur si muove.", while eureka! becomes "Eureka!".<br/>
Names always start with a capital letter.<br/>
Select the quote by taking the day of the year and take the day as the index of the list. January 2nd is the second day of the year, so the quote should be "Eureka!" -- Archimedes, while January 3th gives the quote from Erasmus. If the list runs out of quotes, start again on the first quote. This means that January 1th, January 7th and January 13th all give the Galileo quote.
### Learning goals
 - Immutable data
 - String manipulation
 - Date API

## Roborally
Imagine a simple robot. This robot moves through a factory based on simple commands like “turn left”, “turn right”, “forward”, “backward”. It moves in a grid and each turn is 90 degrees. Assume the robot is the same size as the grid.<br/>
Create a class for this type of robot. The robot has a position and a facing. By default these are (0,0) and “North”. Not every robot will start at the same position and facing, so we want to be able to change its starting state. This can be done with another constructor that receives three parameters for initializing the robot with a position and facing.<br/>
Now we can create robots with different positions like:
1. Robot my_first_robot = new Robot(0, 1, "East")
2. Robot my_second_robot = new Robot(1, 0, "West")

Implement the turnLeft() and turnRight() method to change the direction the robot faces.<br/>
Implement the forward and backward method. We assume north means +1 to the y coordinate, south -1 to the y coordinate, etc…<br/>
Robots can move faster forward than the single square the forward function did. Allow the forward function to specify a speed. This speed should be between 1 and 3. The default when no speed is specified should still be one.<br/>
The robot does not perform the command directly, but the turn and movement functions are so that they do not alter the state, but are stored in a list. When you call goLeft(), goRight(), etc, the robot will store these as commands chronologically. An execute() function performs all commands in the list.
-    Robot my_first_robot = new Robot(1, 0, "West");
-    my_first_robot.turnLeft();
-    my_first_robot.forward();
-    my_first_robot.backward();
-    my_first_robot.execute();
### Learning goals
-    Working with objects
-    Creating a functional api on an object
-    Store methods as data

## Fractional calculation
Some numbers cannot be represented accurately in the decimal system, think of 1/3rd. Make a class Fraction that is constructed with a numerator and a denominator. The program should be able to get the values of the numerator and the denominator, but should not be able to modify them. Implement the following functions:

  -  double toDecimalNotation() -> 1/3 should return 0.33333
  -  string toString() -> 1/3 should return “1/3”
  -  Fraction add(int number) -> 1/3 + 1 should become 4/3
  -  Fraction add(Fraction fraction) -> 1/3 + 1/6 should become 1/2
   - Fraction subtract(int number) -> 4/3 - 1 should become 1/3
   - Fraction subtract(Fraction fraction) -> 1/2 - 1/6 should become 1/3
   - Fraction multiply(int number) -> 3/4 * 2 should become 3/2
   - Fraction multiply(Fraction fraction) -> 3/4 * 2/5 should become 3/10
   - Fraction divide(int number) -> 3/2 / 2 should become 3/4
   - Fraction divide(Fraction fraction) -> 3/10 / 2/5 should become 3/4
### Learning goals
- Creating an immutable object
- Creating a technical api on an object
