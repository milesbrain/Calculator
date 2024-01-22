package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator implements ActionListener {
    JFrame frame;
    JTextField jTextField;
    JPanel panel, panel1, panel2, panel3;
    JButton button7, button8, button9, buttonmul;
    JButton button4, button5, button6, buttonsub;
    JButton button1, button2, button3, buttonadd;
    JButton buttonzero, buttonpoint, buttonequ, buttondi, buttonclr;
    Double num1, result, num2;
    String Operator;


    void calculator() {
        frame = new JFrame("Calculator");
        frame.setSize(new Dimension(350, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        jTextField = new JTextField(30);
        jTextField.setBounds(40, 60, 260, 40);
        jTextField.setEditable(false);
        jTextField.setBackground(Color.white);


        button7 = new JButton("7");
        button7.addActionListener(this);
        button7.setFocusable(false);

        button8 = new JButton("8");
        button8.addActionListener(this);
        button8.setFocusable(false);

        button9 = new JButton("9");
        button9.addActionListener(this);
        button9.setFocusable(false);

        buttonmul = new JButton("*");
        buttonmul.addActionListener(this);
        buttonmul.setFocusable(false);

        button4 = new JButton("4");
        button4.addActionListener(this);
        button4.setFocusable(false);

        button5 = new JButton("5");
        button5.addActionListener(this);
        button5.setFocusable(false);

        button6 = new JButton("6");
        button6.addActionListener(this);
        button6.setFocusable(false);

        buttonsub = new JButton("-");
        buttonsub.addActionListener(this);
        buttonsub.setFocusable(false);

        button1 = new JButton("1");
        button1.addActionListener(this);
        button1.setFocusable(false);

        button2 = new JButton("2");
        button2.addActionListener(this);
        button2.setFocusable(false);

        button3 = new JButton("3");
        button3.addActionListener(this);
        button3.setFocusable(false);

        buttonadd = new JButton("+");
        buttonadd.addActionListener(this);
        buttonadd.setFocusable(false);

        buttonzero = new JButton("0");
        buttonzero.addActionListener(this);
        buttonzero.setFocusable(false);

        buttonpoint = new JButton(".");
        buttonpoint.addActionListener(this);
        buttonpoint.setFocusable(false);

        buttonequ = new JButton("=");
        buttonequ.addActionListener(this);
        buttonequ.setFocusable(false);

        buttondi = new JButton("/");
        buttondi.addActionListener(this);
        buttondi.setFocusable(false);

        buttonclr = new JButton("C");
        buttonclr.addActionListener(this);
        buttonclr.setFocusable(false);
        buttonclr.setBounds(260, 105, 50, 30);


        panel = new JPanel(new BorderLayout());


        panel.setBounds(20, 140, 300, 60);
        panel.setLayout(new GridLayout());


        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonmul);

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout());
        panel1.setBounds(20, 210, 300, 60);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        panel1.add(buttonsub);

        panel3 = new JPanel();
        panel3.setLayout(new GridLayout());
        panel3.setBounds(20, 280, 300, 60);
        panel3.add(button1);
        panel3.add(button2);
        panel3.add(button3);
        panel3.add(buttonadd);

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout());
        panel2.setBounds(20, 350, 300, 60);
        panel2.add(buttonzero);
        panel2.add(buttonpoint);
        panel2.add(buttonequ);
        panel2.add(buttondi);


        frame.setVisible(true);
        frame.add(jTextField);
        frame.add(panel);
        frame.add(panel1);
        frame.add(panel3);
        frame.add(panel2);
        frame.add(buttonclr);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();
        if (buttonText.matches("[0-9.]")) {
            jTextField.setText(jTextField.getText() + buttonText);
        } else if (buttonText.matches("[+\\-*/]")) {
            handleOperator(buttonText.charAt(0));
        } else if (buttonText.equals("=")) {
            calculateResult();
        } else if (buttonText.equals("C")) {
            clearfield();


        }
    }


    private void handleOperator(char newOperator) {
        if (!jTextField.getText().isEmpty()) {
            num1 = Double.parseDouble(jTextField.getText());
            Operator = String.valueOf(newOperator);
            jTextField.setText("");
        }
    }

    private void calculateResult() {
        if (!jTextField.getText().isEmpty()) {
            num2 = Double.parseDouble(jTextField.getText());


            switch (Operator) {
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
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        jTextField.setText("Error");
                        return;
                    }
                    break;
            }

            jTextField.setText(String.valueOf(result));
        }
    }

    private void clearfield() {
        jTextField.setText("");
        num1 = num2 = result = Double.valueOf(0);
        Operator = String.valueOf('\0');

    }


    public static void main(String[] args) {
        calculator calculator = new calculator();
        calculator.calculator();
    }
}


