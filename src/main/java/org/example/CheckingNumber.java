package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class CheckingNumber {
    private JLabel titleLabel;
    private JTextField inputNumberField;
    private JCheckBox additionalConditionCheckBox;
    private JButton checkButton;
    private JLabel textOfResult;

    public CheckingNumber() {
        JFrame frame = new JFrame("Check your number");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLayout(null);

        titleLabel = new JLabel("Number:");
        titleLabel.setBounds(60, 10, 200, 25);
        frame.add(titleLabel);

        inputNumberField = new JTextField();
        inputNumberField.setBounds(50, 30, 200, 25);
        frame.add(inputNumberField);

        additionalConditionCheckBox = new JCheckBox("Additional condition");
        additionalConditionCheckBox.setBounds(50, 60, 300, 25);
        frame.add(additionalConditionCheckBox);

        checkButton = new JButton("Check");
        checkButton.setBounds(50, 100, 200, 25);
        frame.add(checkButton);


        textOfResult = new JLabel("");
        textOfResult.setBounds(50, 130, 400, 25);
        frame.add(textOfResult);

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputNumberField.getText();
                boolean isRealNumber = additionalConditionCheckBox.isSelected();
                boolean isSuccess = checkInputNumber(input, isRealNumber);
                String resultText = makeResultText(isSuccess);
                textOfResult.setText(resultText);

                textOfResult.setForeground
                        (isSuccess ? Color.green : Color.red);

            }
        });
        frame.setVisible(true);
    }
    private boolean checkInputNumber(String input, boolean isRealNumber) {
        input = input.replace(",", ".");
        try {
            if (isRealNumber) {
                BigDecimal inputNumber = new BigDecimal(input);
                int resultMin = inputNumber.compareTo(new BigDecimal(20));
                int resultMax = inputNumber.compareTo(new BigDecimal(50));
                return resultMin >= 0 && resultMax <=0;
            } else {
                int inputNumber = Integer.parseInt(input);
                return inputNumber >= 20 && inputNumber <=50;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String makeResultText(boolean isSuccess) {
        if (isSuccess) {
            return  "Success";
        }
        return  "Error. The number is not valid";
    }

    public static void main(String[] args) {
        new CheckingNumber();
    }
}



