package com.triodos.calc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HexCalculator4 extends Application {

  @FXML
  private Label display;

  private long num1 = 0;
  private String operator = "";
  private boolean start = true;

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("hexcalculator4.fxml"));

    Calculator controller = loader.getController();
    loader.setController(controller);
    Parent root = loader.load();

    // Create the scene
    Scene scene = new Scene(root, 270, 280);
    scene.getStylesheets().add(getClass().getResource("hexcalculator4.css").toExternalForm());

    primaryStage.setTitle("JavaFX HexCalc4");
    primaryStage.setMinWidth(270);
    primaryStage.setMinHeight(280);

    // Set the scene and show the stage
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  @FXML
  private void processNumber(ActionEvent event) {
    if (start) {
      display.setText("");
      start = false;
    }
    String value = ((Button)event.getSource()).getText();
    display.setText(display.getText() + value);
  }

  @FXML
  private void processOperator(ActionEvent event) {
    String value = ((Button)event.getSource()).getText();

    if (!"=".equals(value)) {
      if (!operator.isEmpty())
        return;
      operator = value;
      num1 = parseHex(display.getText());
      display.setText("");
    } else {
      if (operator.isEmpty())
        return;
      long num2 = parseHex(display.getText());
      long result = calculate(num1, num2, operator);
      display.setText(toHex(result));
      operator = "";
      start = true;
    }
  }

  @FXML
  private void processClear(ActionEvent event) {
    // Code to handle clear button clicks
    display.setText("");
  }


  private long parseHex(String hexString) {
    return Long.parseLong(hexString, 16);
  }

  private String toHex(long number) {
    return Long.toHexString(number).toUpperCase();
  }


  public void convertHexToDec() {
    try {
      String hex = display.getText();
      int dec = Integer.parseInt(hex, 16);
      display.setText(Integer.toString(dec));
    } catch (NumberFormatException e) {
      display.setText("Error");
    }
  }

  public void convertDecToHex() {
    try {
      int decimalValue = Integer.parseInt(display.getText());
      String hexValue = Integer.toHexString(decimalValue).toUpperCase();
      display.setText(hexValue);
    } catch (NumberFormatException e) {
      display.setText("Error");
    }
  }
  public void calculateSqrt() {
    try {
      double operand = Double.parseDouble(display.getText());
      double result = Math.sqrt(operand);
      display.setText(Double.toString(result));
    } catch (NumberFormatException e) {
      display.setText("Error");
    }
  }

  public void calculateNot() {
    try {
      long operand = Integer.parseInt(display.getText(), 16);
      long result = ~operand;
      display.setText(Long.toHexString(result).toUpperCase());
    } catch (NumberFormatException e) {
      display.setText("Error");
    }
  }

  public void calculateRor() {
    try {
      long operand1 = Integer.parseInt(display.getText(), 16);
      long result = Long.rotateRight(operand1, 1);
      display.setText(Long.toHexString(result).toUpperCase());
    } catch (NumberFormatException e) {
      display.setText("Error");
    }
  }

  public void calculateRol() {
    try {
      long operand1 = Integer.parseInt(display.getText(), 16);
      long result = Long.rotateLeft(operand1, 1);
      display.setText(Long.toHexString(result).toUpperCase());
    } catch (NumberFormatException e) {
      display.setText("Error");
    }
  }

  public void calculateShl() {
    try {
      long operand1 = Integer.parseInt(display.getText(), 16);
      long result =  operand1 << 1;
      display.setText(Long.toHexString(result).toUpperCase());
    } catch (NumberFormatException e) {
      display.setText("Error");
    }
  }

  public void calculateShr() {
    try {
      long operand1 = Integer.parseInt(display.getText(), 16);
      long result = operand1 >> 1;
      display.setText(Long.toHexString(result).toUpperCase());
    } catch (NumberFormatException e) {
      display.setText("Error");
    }
  }

  public void calculateCnt() {
    try {
      long operand = Integer.parseInt(display.getText(), 16);
      int result = Long.bitCount(operand);
      display.setText(Integer.toString(result));
    } catch (NumberFormatException e) {
      display.setText("Error");
    }
  }

  private long calculate(long num1, long num2, String operator) {
    switch (operator) {
      case "+":
        return num1 + num2;
      case "-":
        return num1 - num2;
      case "*":
        return num1 * num2;
      case "/":
        if (num2 == 0)
          return 0;
        return num1 / num2;
      case "^":
        return num1 ^ num2;
      case "|":
        return num1 | num2;
      case "&":
        return num1 & num2;
      default:
        return 0;
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
