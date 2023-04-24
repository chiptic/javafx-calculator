package com.triodos.calc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

  private TextField inputField;
  private double num1, num2, result;
  private String operator;

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Calculator");

    // Create the input field
    inputField = new TextField();
    inputField.setPrefWidth(250);
    inputField.setAlignment(Pos.CENTER_RIGHT);

    // Create the buttons
    Button btn0 = new Button("0");
    Button btn1 = new Button("1");
    Button btn2 = new Button("2");
    Button btn3 = new Button("3");
    Button btn4 = new Button("4");
    Button btn5 = new Button("5");
    Button btn6 = new Button("6");
    Button btn7 = new Button("7");
    Button btn8 = new Button("8");
    Button btn9 = new Button("9");
    Button btnAdd = new Button("+");
    Button btnSubtract = new Button("-");
    Button btnMultiply = new Button("*");
    Button btnDivide = new Button("/");
    Button btnClear = new Button("C");
    Button btnEquals = new Button("=");

    // Set the button sizes
    btn0.setPrefWidth(50);
    btn1.setPrefWidth(50);
    btn2.setPrefWidth(50);
    btn3.setPrefWidth(50);
    btn4.setPrefWidth(50);
    btn5.setPrefWidth(50);
    btn6.setPrefWidth(50);
    btn7.setPrefWidth(50);
    btn8.setPrefWidth(50);
    btn9.setPrefWidth(50);
    btnAdd.setPrefWidth(50);
    btnSubtract.setPrefWidth(50);
    btnMultiply.setPrefWidth(50);
    btnDivide.setPrefWidth(50);
    btnClear.setPrefWidth(50);
    btnEquals.setPrefWidth(50);

    // Set the button actions
    btn0.setOnAction(e -> inputField.setText(inputField.getText() + "0"));
    btn1.setOnAction(e -> inputField.setText(inputField.getText() + "1"));
    btn2.setOnAction(e -> inputField.setText(inputField.getText() + "2"));
    btn3.setOnAction(e -> inputField.setText(inputField.getText() + "3"));
    btn4.setOnAction(e -> inputField.setText(inputField.getText() + "4"));
    btn5.setOnAction(e -> inputField.setText(inputField.getText() + "5"));
    btn6.setOnAction(e -> inputField.setText(inputField.getText() + "6"));
    btn7.setOnAction(e -> inputField.setText(inputField.getText() + "7"));
    btn8.setOnAction(e -> inputField.setText(inputField.getText() + "8"));
    btn9.setOnAction(e -> inputField.setText(inputField.getText() + "9"));

    btnAdd.setOnAction(e -> {
      num1 = Double.parseDouble(inputField.getText());
      operator = "+";
      inputField.setText("");
    });

    btnSubtract.setOnAction(e -> {
      num1 = Double.parseDouble(inputField.getText());
      operator = "-";
      inputField.setText("");
    });

    btnMultiply.setOnAction(e -> {
      num1 = Double.parseDouble(inputField.getText());
      operator = "*";
      inputField.setText("");
    });

    btnDivide.setOnAction(e -> {
      num1 = Double.parseDouble(inputField.getText());
      operator = "/";
      inputField.setText("");
    });


    btnClear.setOnAction(e -> inputField.setText(""));

    btnEquals.setOnAction(e -> {
      num2 = Double.parseDouble(inputField.getText());
      switch (operator) {
        case "+":
          result = num1 + num2;
          break;
        case "-":
          result = num1 - num2;
          break;
        case "*":
          result = num1 * num2;
          break;
        case "/":
          result = num1 / num2;
          break;
      }
      inputField.setText(Double.toString(result));
    });

    // Create the grid pane layout
    GridPane gridPane = new GridPane();
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setPadding(new Insets(10, 10, 10, 10));
    gridPane.setHgap(5);
    gridPane.setVgap(5);

    // Add the controls to the grid pane layout
    gridPane.add(inputField, 0, 0, 4, 1);
    gridPane.add(btn7, 0, 1);
    gridPane.add(btn8, 1, 1);
    gridPane.add(btn9, 2, 1);
    gridPane.add(btnDivide, 3, 1);
    gridPane.add(btn4, 0, 2);
    gridPane.add(btn5, 1, 2);
    gridPane.add(btn6, 2, 2);
    gridPane.add(btnMultiply, 3, 2);
    gridPane.add(btn1, 0, 3);
    gridPane.add(btn2, 1, 3);
    gridPane.add(btn3, 2, 3);
    gridPane.add(btnSubtract, 3, 3);
    gridPane.add(btn0, 0, 4);
    gridPane.add(btnClear, 1, 4);
    gridPane.add(btnEquals, 2, 4);
    gridPane.add(btnAdd, 3, 4);

    // Create the scene
    Scene scene = new Scene(gridPane, 300, 250);

    // Set the scene and show the stage
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
