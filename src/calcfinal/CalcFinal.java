// File name: CalcFinal.java
// Written by: Kyle Marcoux
// Description:  This program allows users to perform basic calculation functions as well as run shape calculators.
//           
// Revision History:
// Date:         		By:     Action:
// ---------------------------------------------------
/*      09/21/21                KM      Updated for 2021 Github
*/
package calcfinal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class CalcFinal extends JFrame implements ActionListener{
    //variable declarations
    private final JTextField res, dig1, dig2, digc, op;
    private final JLabel result, digit1, digit2, currentDig;
    private final JButton one, two, three, four, five, six, seven, eight, nine, zero, dot, backspace, plus, minus, divide, mult, pow, root, equal, switchButton, clear;
    private final JPanel resPanel, numPanel, opPanel, digPanel, backPanel, switchPanel;
    private final JMenuBar menuBar;
    private final JMenu shapeMenu;
    private final JFrame frame;
    private final JMenuItem circle, square, help;
    public String d1="0", d2="0", dChoice = "1";
    public int opChoice = 0;
   
    public CalcFinal(){
    frame = new JFrame("Math Utility");  //Frame setup
    frame.setSize(310,300);
    backPanel = new JPanel(new BorderLayout());
    menuBar = new JMenuBar();   //menuBar setup, this will hold the shapeMenu and Help button
    shapeMenu = new JMenu("Shapes");    //shapeMenu holds the JMenuItems that will call the shape objects
        circle = new JMenuItem("Circle");   //JMenuItem declarations and adding the ActionListener
            circle.addActionListener(this);
        square = new JMenuItem("Square");
            square.addActionListener(this);
        
        shapeMenu.add(circle);  //These add the JMenuItems to the menu
        shapeMenu.add(square);
        
    help = new JMenuItem("Help");   //This is the help item that is also added to the menu
        help.addActionListener(this);
    menuBar.add(shapeMenu);
    menuBar.add(help);
        
    numPanel = new JPanel(new GridLayout(4,3)); //This panel will hold all of the buttons
        numPanel.setBorder(BorderFactory.createTitledBorder("Digits"));
        one = new JButton(" 1 ");   //These are all of the button declarations and adding the ActionListener
            one.addActionListener(this);
        two = new JButton(" 2 "); 
            two.addActionListener(this);
        three = new JButton(" 3 ");
            three.addActionListener(this);
        four = new JButton(" 4 ");
            four.addActionListener(this);
        five = new JButton(" 5 ");
            five.addActionListener(this);
        six = new JButton(" 6 ");
            six.addActionListener(this);
        seven = new JButton(" 7 ");
            seven.addActionListener(this);
        eight = new JButton(" 8 "); 
            eight.addActionListener(this);
        nine = new JButton(" 9 "); 
            nine.addActionListener(this);
        zero = new JButton(" 0 "); 
            zero.addActionListener(this);
        dot = new JButton(" . ");
            dot.addActionListener(this);
        backspace = new JButton(" <- ");
            backspace.addActionListener(this);
        
        numPanel.add(one);      //This adds all of the buttons to the panel
        numPanel.add(two);
        numPanel.add(three);
        numPanel.add(four);
        numPanel.add(five);
        numPanel.add(six);
        numPanel.add(seven);
        numPanel.add(eight);
        numPanel.add(nine);
        numPanel.add(zero);
        numPanel.add(dot);
        numPanel.add(backspace);
        
    
    opPanel = new JPanel(new GridLayout(6,1));  //This declares the opPanel, which holds all of the operation buttons and the clear button
        opPanel.setBorder(BorderFactory.createTitledBorder("Operations"));
        plus = new JButton(" + ");      //These are all of the button declarations and adding the ActionListener
            plus.addActionListener(this);
        minus = new JButton(" - "); 
            minus.addActionListener(this);
        divide = new JButton(" / "); 
            divide.addActionListener(this);
        mult = new JButton(" * "); 
            mult.addActionListener(this);
        pow = new JButton(" ^ "); 
            pow.addActionListener(this);
        root = new JButton(" √ ");
            root.addActionListener(this);
        equal = new JButton(" = ");
            equal.addActionListener(this);
        clear = new JButton("Clear");
            clear.addActionListener(this);
    
        opPanel.add(plus);      //This adds all of the buttons to the panel
        opPanel.add(minus);
        opPanel.add(divide);
        opPanel.add(mult);
        opPanel.add(pow);
        opPanel.add(root);
        opPanel.add(equal);
        opPanel.add(clear);
        
    
    digPanel = new JPanel(new FlowLayout());    //This sets up the digPanel which holds the digit fields, and sets it to flow layout
        digit1 = new JLabel("D1: ");    //The following declares the labels and fields
        dig1 = new JTextField("0", 8);
            dig1.setEditable(true);
        
        op = new JTextField("", 3);
            op.setEditable(false);
        
        digit2 = new JLabel("D2: ");
        dig2 = new JTextField("0", 8);
            dig2.setEditable(true);
        
        digPanel.add(digit1);   //This adds the labels and fields to digPanel in the proper order
        digPanel.add(dig1);
        digPanel.add(op);
        digPanel.add(digit2);
        digPanel.add(dig2);  
    
    resPanel = new JPanel(new FlowLayout());    //This declares the resPanel, which holds the results
        resPanel.setBorder(BorderFactory.createTitledBorder(""));
        result = new JLabel("Result: ");
        
        res = new JTextField("", 20);
            res.setEditable(false);
            
        resPanel.add(result);
        resPanel.add(res);
    
    switchPanel = new JPanel(new GridLayout(1,3));  //This declares the switchPanel, which holds the the content for switching digit fields via button
        switchPanel.setBorder(BorderFactory.createTitledBorder(""));
        currentDig = new JLabel("Current digit: ", 10);
        
        digc = new JTextField("              " + dChoice, 5);
            digc.setEditable(false);
        
        switchButton = new JButton("Switch");
            switchButton.addActionListener(this);
        
        switchPanel.add(currentDig);
        switchPanel.add(digc);
        switchPanel.add(switchButton);
    
    frame.setJMenuBar(menuBar);         //This sets the JMenuBar
    backPanel.add(digPanel, BorderLayout.NORTH);    //The following sets up all the panels so the gui looks nice
    backPanel.add(numPanel, BorderLayout.WEST); 
    backPanel.add(opPanel, BorderLayout.EAST); 
    frame.add(resPanel, BorderLayout.NORTH);
    frame.add(backPanel, BorderLayout.CENTER);
    frame.add(switchPanel, BorderLayout.SOUTH);
    frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);    //This makes it so the program will exit on closing the window
    frame.setLocationRelativeTo(null);                              
    frame.setVisible(true); 
    }
    
    public static void main(String[] args) {
        CalcFinal app = new CalcFinal();    //runs the default app
    }

    public void Calc(){ //This method calculates the results
        double x = 0, y = 0;
        String z = "";
        DecimalFormat f = new DecimalFormat("#.##"); //This is a new DecimalFormat so that the JTextFields will only have 2 decimal places
        try{    //This attempts to parse both digit fields and will throw an exception if it is not valid data
            x = Double.parseDouble(dig1.getText());
            y = Double.parseDouble(dig2.getText());
        }
        catch(NumberFormatException num){
            JOptionPane.showMessageDialog(this, "Please do not enter invalid data, ensure there are not double decimals either");
        }
        
        switch(opChoice){   //This switch statement chooses what operation to perform based on the button pressed by the user
            case 0:
                JOptionPane.showMessageDialog(this, "Please pick an operator");
                break;
            case 1:
                z = Double.toString(x+y);
                res.setText(z);
                break;
            case 2:
                z = Double.toString(x-y);
                res.setText(z);
                break;
            case 3: //case 3 features try block which attempts division first to catch division by 0
                try{
                z = Double.toString(x/y);}
                catch(ArithmeticException num){
                    JOptionPane.showMessageDialog(this, "Please do not divide by 0");
                }
                res.setText(z);
                break;
            case 4:
                z = Double.toString(x*y);
                res.setText(z);
                break;
            case 5:
                z = Double.toString(Math.pow(x, y));
                res.setText(z);
                break;
            case 6: //I designed this one to use Math.pow to enable users to perform any root they want, this elimates the need of an nrt button.
                z = Double.toString(Math.pow(x, 1/y));
                res.setText(z);
                break;
        }
    }
    
    public String Backspace(String x){  //Backspace is what users can press if they are not inputting digits via keyboard.
        
        if(x.length()==0){              //It works by checking the current length of the JTextFields to
            return x;                   //make sure it is not just a 0 before performing the method and just returning if it is.
        }
        else{
            x = x.substring(0, x.length()-1);   //This backspaces one spot on the JTextField by removing length off of the string.
            return x;
        }
    }
    
    public void Switcher(){     //If the user is using buttons to do the calculations, this will be what switches the fields
        if(dChoice.equals("1")){    //This if statement simply checks which field is currently in use and switches them
            dChoice = "2";
            digc.setText("              " + dChoice);
        }
        else if(dChoice.equals("2"))
            dChoice = "1";
            digc.setText("              " + dChoice);
    }
    public void addNum(String x){   //addNum uses dChoice to tell which field is in use
        if("1".equals(dChoice)){
            if("0".equals(d1)){     //then it checks if the string is 0 before adding a number to it, and replacing the 0 if it is just 0.
                d1 = x;}
            else{
                d1+=x;  
                }  
            dig1.setText(d1);
        }
        else{
            if("0".equals(d2)){
                d2 = x;}
            else{
                d2+=x;  
                }  
            dig2.setText(d2);
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){  //This switch statement is for every button
            case(" 1 "):        //For each number button it calls the addNum method and sends it the integer
                addNum("1");
                break;
            case(" 2 "):
                addNum("2");
                break;
            case(" 3 "):
                addNum("3");
                break;
            case(" 4 "):
                addNum("4");
                break;
            case(" 5 "):
                addNum("5");
                break;
            case(" 6 "):
                addNum("6");
                break;
            case(" 7 "):
                addNum("7");
                break;
            case(" 8 "):
                addNum("8");
                break;
            case(" 9 "):
                addNum("9");
                break;
            case(" 0 "):
                addNum("0");
                break;
            case(" . "):    //This adds a decimal and calls setText
                d1+=".";
                dig1.setText(d1);
                break;
            case(" <- "):   //This calls method Backspace and setText, 
                if("1".equals(dChoice)){
                    d1 = Backspace(d1);
                    dig1.setText(d1);}
                else
                    d2=Backspace(d2);
                    dig2.setText(d2);
                break;
            case(" + "):    //Each op case sets the text to show the current operator and calls switcher to switch fields
                opChoice = 1;
                op.setText("    +");
                Switcher();
                break;
            case(" - "):
                opChoice = 2;
                op.setText("    -");
                Switcher();
                break;
            case(" / "):
                opChoice = 3;
                op.setText("    /");
                Switcher();
                break;
            case(" * "):
                opChoice = 4;
                op.setText("    *");                    
                Switcher();
                break;
            case(" ^ "):
                opChoice = 5; 
                op.setText("    ^");                   
                Switcher();
                break;
            case(" √ "):
                opChoice = 6;
                op.setText("    √");
                Switcher();
                break;
            case(" = "):
                Calc();
                break;
            case("Switch"):
                Switcher();
                break;
            case("Clear"):  //This button clears and defaults every field and value
                opChoice = 0;
                dChoice = "1";
                op.setText("");
                dig1.setText("");
                dig2.setText("");
                res.setText("");
                break;
            case("Circle"):     //The next 4 cases are just for calling the public classes for each shape
                Circle c = new Circle();
                break;
            case("Square"):
                Square s = new Square();
                break;
            case("Help"):
                JOptionPane.showMessageDialog(this, "This Program supports two ways of typing in digits: \n" + 
                        "You can use the number buttons and the Switch button to change between the digit fields \n" + 
                        "- When you hit an operator it will switch digit fields automatically \n" + 
                        "- The current digit field is displayed at the bottom of the window \n" +
                        "You can also just type in the fields reguarly if you have a working keyboard \n" +
                        "\n" +
                        "The window shows the current operator between the 2 digit fields \n" +
                        "**This program does not currently support negative roots**"
                );
                break;
        }
    }
}
   
