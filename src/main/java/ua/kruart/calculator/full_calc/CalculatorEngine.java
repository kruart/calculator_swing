//package ua.kruart.calculator.full_calc;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
///**Created by kruart on 21.07.2016.*/
//public class CalculatorEngine implements ActionListener {
//    double currentResult = 0;
//    double displayValue = 0;
//    boolean isFirstNumber = true;
//    boolean isLastNumber = true;
//    char operation = ' ';
//    FullCalculator parent;
//
//    public CalculatorEngine(FullCalculator parent) {
//        this.parent = parent;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        JButton clicked = (JButton)e.getSource();
//        String text = clicked.getText();
//        String dispFieldText = parent.displayField.getText();
//
//        boolean isDigit = text.matches("[0-9]+");
//        if (isDigit) {
//            if (!isLastNumber){
//                parent.displayField.setText(text);
//                isLastNumber = true;
//            }else
//                parent.displayField.setText(dispFieldText + text);
//        }else if (isLastNumber) {
//            if ("±".equals(text)) {
//                operation = text.charAt(0);
//                displayValue = Double.parseDouble(dispFieldText);
//                currentResult = doOperation(operation, currentResult, displayValue);
//                parent.displayField.setText(String.valueOf(currentResult));
//            } else {
//                isLastNumber = false;
//
//                if (isFirstNumber) {
//                    isFirstNumber = false;
//                    operation = text.charAt(0);
//                    currentResult = Double.parseDouble(dispFieldText);
//                } else {
//                    displayValue = Double.parseDouble(dispFieldText);
//                    currentResult = doOperation(operation, currentResult, displayValue);
//                    operation = text.charAt(0);
//                    parent.displayField.setText(String.valueOf(currentResult));
//                }
//            }
//        }
//        else if (!isLastNumber) {
//            operation = text.charAt(0);
//
//        }
//
//    }
//
//    public double doOperation(char op, double resultValue, double displayValue){
//
//        switch(op) {
//            case '+': return resultValue += displayValue;
//            case '-': return resultValue -= displayValue;
//            case '/': return resultValue /= displayValue;
//            case '*': return resultValue *= displayValue;
//            case '=': return resultValue;
//            case '\u00B1': return -displayValue;
//        }
////        ScriptEngineManager mgr = new ScriptEngineManager();
////        ScriptEngine engine = mgr.getEngineByName("JavaScript");
////        try {
////            return (Double)(engine.eval(resultValue + String.valueOf(op) + currentValue));
////        } catch (ScriptException e) {
////            e.printStackTrace();
////        }
//        return 0;
//
//
//    }
//}
