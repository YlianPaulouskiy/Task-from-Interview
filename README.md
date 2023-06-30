
# Задача: “Calculator”
## Description:
Create a console application “Calculator". The application must read arithmetic operations entered by the user from the console and output the result of their execution to the console.  

## Requirements:  
1. The calculator can perform addition, subtraction, multiplication and division operations with two numbers: a + b, a - b, a * b, a / b. Data is transmitted in one line (see example)! Solutions in which every number and arithmetic operation is passed from a new line are considered incorrect.
2. The calculator can work with both Arabic (1,2,3,4,5...) and Roman (I,II,III,IV, V...) numbers.
3. The calculator must accept numbers from 1 to 10 inclusive, no more. At the output, the numbers are not limited in magnitude and can be any.
4. The calculator can only work with integers.
5. The calculator can only work with Arabic or Roman numerals at the same time, when the user enters a string like 3 + II, the calculator should throw an exception and stop working.
6. When entering Roman numbers, the answer should be output in Roman numerals, respectively, when entering Arabic - the answer is expected in Arabic.
7. When the user enters unsuitable numbers, the application throws an exception and shuts down.
8. When the user enters a string that does not correspond to one of the arithmetic operations described above, the application throws an exception and terminates its work.
9. The result of the division operation is an integer, the remainder is discarded.
10.The result of the calculator with Arabic numbers can be negative numbers and zero. The result of the calculator with Roman numbers can only be positive numbers, if the result is less than one, an exception is thrown
## Examples:
Input:  
1 + 2  
Output:  
3  

Input:    
VI / III  
Output:  
II  

Input:  
I - II  
Output:  
throws Exception //because there are no negative numbers in the Roman system 

Input:  
I + 1  
Output:  
throws Exception //because different number systems are used simultaneously  

Input:  
1  
Output:  
throws Exception //because a string is not a mathematical operation

Input:  
1 + 2 + 3  
Output:  
throws Exception //because the format of the mathematical operation does not satisfy the task - two operands and one operator (+, -, /, *)
