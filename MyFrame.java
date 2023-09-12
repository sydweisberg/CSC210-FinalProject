import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
    Panel myPanel; 
    JButton plusButton;
    JButton minusButton;
    JButton multiplyButton;
    JButton divideButton;
    JButton enterButton;
    JButton oneButton;
    JButton twoButton;
    JButton threeButton;
    JButton fourButton;
    JButton fiveButton;
    JButton sixButton;
    JButton sevenButton;
    JButton eightButton;
    JButton nineButton;
    JButton zeroButton;
    JButton openPButton;
    JButton closePButton;
    JButton clearButton;

    String equation = "";

    MyFrame() {
        // Buttons
        plusButton = new JButton("+");
        plusButton.setBounds(50,170,50,50);   
        this.add(plusButton);
        plusButton.addActionListener(this);

        minusButton = new JButton("-");
        minusButton.setBounds(138,170,50,50);   
        this.add(minusButton);
        minusButton.addActionListener(this);

        multiplyButton = new JButton("*");
        multiplyButton.setBounds(225,170,50,50);   
        this.add(multiplyButton);
        multiplyButton.addActionListener(this);

        divideButton = new JButton("/");
        divideButton.setBounds(313,170,50,50);   
        this.add(divideButton);
        divideButton.addActionListener(this);

        enterButton = new JButton("=");
        enterButton.setBounds(400,170,50,50);   
        this.add(enterButton);
        enterButton.addActionListener(this);
        
        oneButton = new JButton("1");
        oneButton.setBounds(50,240,50,50);   
        this.add(oneButton);
        oneButton.addActionListener(this);

        twoButton = new JButton("2");
        twoButton.setBounds(138,240,50,50);   
        this.add(twoButton);
        twoButton.addActionListener(this);
        
        threeButton = new JButton("3");
        threeButton.setBounds(225,240,50,50);  
        this.add(threeButton); 
        threeButton.addActionListener(this);

        fourButton = new JButton("4");
        fourButton.setBounds(313,240,50,50);   
        this.add(fourButton);
        fourButton.addActionListener(this);

        fiveButton = new JButton("5");
        fiveButton.setBounds(400,240,50,50); 
        this.add(fiveButton);
        fiveButton.addActionListener(this);  

        sixButton = new JButton("6");
        sixButton.setBounds(50,310,50,50);   
        this.add(sixButton);
        sixButton.addActionListener(this);

        sevenButton = new JButton("7");
        sevenButton.setBounds(138,310,50,50);   
        this.add(sevenButton);
        sevenButton.addActionListener(this);

        eightButton = new JButton("8");
        eightButton.setBounds(225,310,50,50); 
        this.add(eightButton);
        eightButton.addActionListener(this);  

        nineButton = new JButton("9");
        nineButton.setBounds(313,310,50,50);
        this.add(nineButton); 
        nineButton.addActionListener(this);  

        zeroButton = new JButton("0");
        zeroButton.setBounds(400,310,50,50);  
        this.add(zeroButton); 
        zeroButton.addActionListener(this);

        openPButton = new JButton("(");
        openPButton.setBounds(50,380,50,50);   
        this.add(openPButton);
        openPButton.addActionListener(this);
        
        closePButton = new JButton(")");
        closePButton.setBounds(138,380,50,50);   
        this.add(closePButton);
        closePButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setBounds(225,380,138,50);   
        this.add(clearButton);
        clearButton.addActionListener(this);

        myPanel = new Panel(equation); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(myPanel); 
        this.pack(); 

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == plusButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "+";
        }
        else if(e.getSource() == minusButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "-";
        }
        else if(e.getSource() == minusButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "-";
        }
        else if(e.getSource() == multiplyButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "*";
        }
        else if(e.getSource() == divideButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "/";
        }
        else if(e.getSource() == enterButton) { // test if input is a bunch of -s in A ROW
            if(equation.equals("ERROR")) {
                equation = "";
            }
            else {
                equation = "(" + equation + ")";
                ArithExpr expression = new ArithExpr(equation);
                equation = expression.validator();
            }
        }
        else if(e.getSource() == oneButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "1";
        }
        else if(e.getSource() == twoButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "2";
        }
        else if(e.getSource() == threeButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "3";
        }
        else if(e.getSource() == fourButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "4";
        }
        else if(e.getSource() == fiveButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "5";
        }
        else if(e.getSource() == sixButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "6";
        }
        else if(e.getSource() == sevenButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "7";
        }
        else if(e.getSource() == eightButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "8";
        }
        else if(e.getSource() == nineButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "9";
        }
        else if(e.getSource() == zeroButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "0";
        }
        else if(e.getSource() == openPButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += "(";
        }
        else if(e.getSource() == closePButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation += ")";
        }
        else if(e.getSource() == clearButton) {
            if(equation.equals("ERROR")) {
                equation = "";
            }
            equation = "";
        }
        myPanel.updateEquation(equation);
        myPanel.repaint();
    }

}