package ua.kruart.calculator.full_calc;

import javax.swing.*;
import java.awt.*;


public class FullCalculator {
    JPanel windowContent, pl;
    JTextField displayField;
    JButton button0, button1, button2, button3, button4, button5, button6, button7, button8,button9, buttonPoint, buttonEqual,
            buttonPlus, buttonMinus, buttonMulti, buttonDiv, buttonBS, buttonC, buttonPlusMinus, buttonSqrt;

    public FullCalculator() {
        windowContent = new JPanel(new BorderLayout());

        displayField = new JTextField(30);
        displayField.setSize(new Dimension(30, 40));
        displayField.setFont(new Font("Courier New", Font.BOLD, 24));

        windowContent.add(displayField, BorderLayout.NORTH);

        buttonSqrt = new JButton("sqrt");
        buttonBS = new JButton("back");
        buttonC = new JButton("C");
        buttonPlusMinus = new JButton(String.valueOf('\u00B1'));
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMulti = new JButton("/");
        buttonDiv = new JButton("*");

        pl = new JPanel(new GridLayout(5, 4));


        pl.add(buttonBS);
        pl.add(buttonC);
        pl.add(buttonPlusMinus);
        pl.add(buttonSqrt);
        pl.add(button9);
        pl.add(button8);
        pl.add(button7);
        pl.add(buttonDiv);
        pl.add(button6);
        pl.add(button5);
        pl.add(button4);
        pl.add(buttonMulti);
        pl.add(button3);
        pl.add(button2);
        pl.add(button1);
        pl.add(buttonMinus);
        pl.add(button0);
        pl.add(buttonPoint);
        pl.add(buttonEqual);
        pl.add(buttonPlus);


        windowContent.add(pl, BorderLayout.CENTER);


        JFrame frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 320));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(windowContent);
        frame.setVisible(true);
        frame.pack();

        CalculatorEnginev2 calculatorEngine = new CalculatorEnginev2(this);
        button0.addActionListener(calculatorEngine);
        button1.addActionListener(calculatorEngine);
        button2.addActionListener(calculatorEngine);
        button3.addActionListener(calculatorEngine);
        button4.addActionListener(calculatorEngine);
        button5.addActionListener(calculatorEngine);
        button6.addActionListener(calculatorEngine);
        button7.addActionListener(calculatorEngine);
        button8.addActionListener(calculatorEngine);
        button9.addActionListener(calculatorEngine);
        buttonEqual.addActionListener(calculatorEngine);
        buttonPoint.addActionListener(calculatorEngine);
        buttonMinus.addActionListener(calculatorEngine);
        buttonMulti.addActionListener(calculatorEngine);
        buttonDiv.addActionListener(calculatorEngine);
        buttonPlus.addActionListener(calculatorEngine);
        buttonPlusMinus.addActionListener(calculatorEngine);
        buttonC.addActionListener(calculatorEngine);
        buttonBS.addActionListener(calculatorEngine);
        buttonSqrt.addActionListener(calculatorEngine);
    }

    public static void main(String[] args) {
        FullCalculator calculator = new FullCalculator();
    }
}
