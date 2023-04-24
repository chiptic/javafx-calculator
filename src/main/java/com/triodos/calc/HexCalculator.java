package com.triodos.calc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;

public class HexCalculator extends Application {

  private boolean clearOnNextInput = true;

  @Override
  public void start(Stage primaryStage) throws Exception {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("hexcalculator.fxml"));

    Calculator controller = loader.getController();
    loader.setController(controller);

    Parent root = loader.load();


    // Create the scene
    Scene scene = new Scene(root);

    scene.getStylesheets().add(getClass().getResource("hexcalculator.css").toExternalForm());

    primaryStage.setTitle("JavaFX Calculator");

    // Set the scene and show the stage
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  @FXML
  private Label display;

  private long num1 = 0;
  private String operator = "";
  private boolean start = true;

  private long parseHex(String hexString) {
    return Long.parseLong(hexString, 16);
  }

  private String toHex(long number) {
    return Long.toHexString(number).toUpperCase();
  }

  @FXML
  private void processNumber(ActionEvent event) {
    if (start) {
      display.setText("");
      start = false;
    }
    String digit = ((Button)event.getSource()).getText();

    if (clearOnNextInput) {
      display.setText(digit);
      clearOnNextInput = false;
    } else {
      display.setText(display.getText() + digit);
    }
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

    clearOnNextInput = true;
  }

  @FXML
  private void processSqrt(ActionEvent event) {
    double value = Double.parseDouble(display.getText());
    double result = Math.sqrt(value);
    display.setText(Double.toString(result));
    clearOnNextInput = true;
  }

  @FXML
  private void processHexToDec(ActionEvent event) {
    String hexValue = display.getText();
    int decimalValue = Integer.parseInt(hexValue, 16);
    display.setText(Integer.toString(decimalValue));
    clearOnNextInput = true;
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
/*
      case "√":
        double value = Double.parseDouble(display.getText());
        display.setText(Double.toString(value));
        break;
      case "Hex to Dec":
        int decimalValue = Integer.parseInt(display.getText(), 16);
        display.setText(Integer.toString(decimalValue));
        break;
 */
      default:
        return 0;
    }
  }

  @FXML
  private void processClear(ActionEvent event) {
    // Code to handle clear button clicks
    clearOnNextInput = true;
    display.setText("");
  }

  public static void main(String[] args) {
    launch(args);
  }
}
