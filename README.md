# JavaFX Calculator

This is a simple calculator application built with JavaFX, 
using instructions from ChatGPT.

## Features

- Addition, subtraction, multiplication, and division operations
- Binary operations (AND, OR, XOR, rotate right, and count ones)
- Logical operations (NOT)
- Decimal to hexadecimal conversion
- Clear and delete functions

## Screenshots of progress

First ChatGPT-generated calculator

![Screenshot of the calculator application](/screenshots/calculator.png "First ChatGPT-generated calculator")

First ChatGPT-generated hexadecimal calculator

![Screenshot of the hexadecimal calculator](/screenshots/hexcalculator1.png "First ChatGPT-generated hexadecimal calculator")

Keys in better order by hacking the fxml file

![Screenshot of the hexadecimal calculator](/screenshots/hexcalculator2.png "Better ChatGPT-generated hexadecimal calculator")

More colorful ChatGPT-generated hexadecimal calculator

![Screenshot of the next hexadecimal calculator](/screenshots/hexcalculator3.png "More colorful ChatGPT-generated hexadecimal calculator")

More functions on the ChatGPT-generated hexadecimal calculator

![Screenshot of the improved hexadecimal calculator](/screenshots/hexcalculator4.png "More functions on the ChatGPT-generated hexadecimal calculator")


## Installation

To run the calculator application, you must have the following software installed on your machine:

- Java SE Development Kit (JDK) 11 or later
- JavaFX 11 or later

To run the application, you can use the following command:

```
java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -jar CalculatorApp.jar
```

Make sure to replace `/path/to/javafx/lib` with the actual path to the JavaFX library on your machine.

## Usage

The calculator application has a simple interface that allows you to perform basic arithmetic and logical operations. You can click the buttons on the interface to enter numbers and operators, and the result will be displayed in the output area. The following buttons are available:

- Numbers 0-9
- Operators +, -, *, /
- Binary operators AND, OR, XOR, ROT, and COUNT
- Logical operator NOT
- Decimal to hexadecimal conversion button (DEC)
- Clear (C) and delete (DEL) buttons

## Contributing

If you'd like to contribute to the development of the JavaFX calculator application, please follow these steps:

1. Fork the repository and create a new branch for your feature or bug fix.
2. Write code to implement your feature or fix the bug.
3. Write tests to verify that your code works as expected.
4. Submit a pull request to merge your branch into the main repository.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

This project was inspired by the JavaFX tutorial series on [JavaFX Tutorials for Beginners](https://www.youtube.com/playlist?list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG) YouTube channel.