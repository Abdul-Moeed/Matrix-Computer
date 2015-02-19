# ap-lab1
Advanced Programming - Lab 1 (Matrix operations and unit testing)

* src contains java source files 
* AP_Lab1.java contains main()
* 3 unit tests included
* unit-test-1: Multiply 2 matrices
* unit-test-2: Add 3 matrices
* unit-test-3: Multiply 2 matrices and add 3rd to the result
* You can also test manually, just follow the sample_manual_test.txt format and edit path in test_manual() method

## Steps for project build
* clone java classes from src folder
* download unit_test_data files from master
* download sample_manual_test file from master
* edit paths in unit_test_x() in AP_Lab1.java to run automated tests
* e.g. to run test 1, edit path in unit_test_1() in AP_Lab1.java to add path of unit_test1_data.txt
* edit path in test_manual in AP_Lab1.java to run manual test
* e.g. to run manual test, edit path in test_manual() in AP_Lab1.java to add path of sample_manual_test.txt
* run main()

## File format
### Automated Test File Format
a11 a12 a13;b21 b22 b23 //represents a matrix of dimensions 2x3 

Every line of file represents a matrix. Rows are separated by ";" whereas columns are separated by " ". No spaces before or after semicolon.

e.g: 

line: 1 2 3;4 5 6; 7 8 9

matrix: 

        1 2 3
        
        4 5 6
        
        7 8 9
### Manual Test File Format
(Expression)

a11 a12 a13;b21 b22 b23 //represents a matrix of dimensions 2x3

First line of file must contain expression. All subsequent lines must contain matrices. Rows and columns' format is the same as automated tests.

e.g

A+B-C                   //first line of file

1 2 3;4 5 6;7 8 9       //matrix 1

1 1 1;2 2 2;3 3 3       //matrix 2

2 1 2;3 1 3;4 2 1       //matrix 3 - will add first two matrices and subtract third from sum

