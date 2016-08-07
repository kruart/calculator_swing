package ua.kruart.calculator.full_calc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Created by kruart on 21.07.2016.*/
public class CalculatorEnginev2 implements ActionListener {
    double currentResult = 0;
    double displayValue = 0;
    boolean isC = false;
    boolean isFirstNumber = true;
    boolean isNewDigit = true;
    boolean isLastSign = false;
    char operation = ' ';
    FullCalculator parent;

    public CalculatorEnginev2(FullCalculator parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        String text = clicked.getText();
        String dispFieldText = parent.displayField.getText();

        boolean isDigit = text.matches("[0-9]+");
        boolean isSign = text.matches("[+-=/*s]");

        if (isDigit || ".".equals(text)){
            displayDigit(text, dispFieldText);
        }
        else if(isSign) {
            displayResult(text, dispFieldText);
        }
        else if("C".equals(text) || "sqrt".equals(text) || "±".equals(text)){
            currentResult = displayOtherResult(text, dispFieldText);
            parent.displayField.setText(String.valueOf(currentResult));
        } else if("back".equals(text)){
            if (dispFieldText.length() > 1) parent.displayField.setText(dispFieldText.substring(0, dispFieldText.length() - 1));
            else parent.displayField.setText("");
        }
    }

    private double displayOtherResult(String text, String dispFieldText) {

        switch(text){
            case "C": {
                isFirstNumber = true;
                isNewDigit = true;
                isLastSign = true;
                isC = false;
                return 0;
            }
            case "sqrt": {
                isFirstNumber = true;
                isNewDigit = true;
                isLastSign = true;
                isC = false;
                return Math.sqrt(Double.parseDouble(dispFieldText));
            }
            case "±": {
                if(!isLastSign && !isFirstNumber){
                    return -currentResult;
                }else {
                    return -Double.parseDouble(dispFieldText);
                }
            }
        }

        return 0;
    }

    private void displayDigit(String text, String dispFieldText) {

        if(isLastSign) {
            parent.displayField.setText(text);
        } else {
            parent.displayField.setText(dispFieldText + text);
        }
        isLastSign = false;
    }

    private void displayResult(String text, String dispFieldText) {

        if (isFirstNumber  && !isLastSign){
            isFirstNumber = false;
            isLastSign = true;
            operation = text.charAt(0);
            currentResult = Double.parseDouble(dispFieldText);
        } else if(!isLastSign){
            isLastSign = true;
            displayValue = Double.parseDouble(dispFieldText);
            currentResult = doOperation(operation, currentResult, displayValue);
            operation = text.charAt(0);
            parent.displayField.setText(String.valueOf(currentResult));
        } else {
            operation = text.charAt(0);
        }

        isLastSign = true;

    }

    private double doOperation(char op, double resultValue, double displayValue){

        switch(op) {
            case '+': return resultValue += displayValue;
            case '-': return resultValue -= displayValue;
            case '/': return resultValue /= displayValue;
            case '*': return resultValue *= displayValue;
            case '=': return resultValue;
            case 's': return resultValue;
            case '\u00B1': return -displayValue;
        }
        return 0;
    }


}
