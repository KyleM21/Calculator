// File name: Circle.java
// Written by: Kyle Marcoux
// Description:  This program allows users to calculate the circumfrence and area of a circle given the radius
//           
// Revision History:
// Date:         		By:     Action:
// ---------------------------------------------------
/*      09/21/21                KM      Updated for 2021 Github
*/
package calcfinal;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class Circle extends JFrame implements ActionListener{
    //Declares variables
    private final JFrame frame;
    private final JPanel drawPanel, resPanel;
    private final JLabel rad, ar, circ;
    private final JTextField radius,area, circum;
    private final JButton calc, clear;
    public double r;
    
    public Circle(){
        frame = new JFrame("Circle Utility");    //Sets up JFrame
        frame.setSize(500,500); 
        
        drawPanel = new JPanel(){   //Sets up drawPanel
        @Override
        public void paint(Graphics g){
            super.paint(g);
            g.drawOval(1, 1, (int)r*2, (int)r*2);
        }
        };
        
        resPanel = new JPanel(new GridLayout(4,2));
        resPanel.setBorder(BorderFactory.createTitledBorder("Input values here, measured in pixels"));
            rad = new JLabel("Radius: ");    //Declares JLabels
            ar = new JLabel("Area: ");
            circ = new JLabel("Circumfrence: ");
        
            radius = new JTextField("", 10);    //Declares JTextFields
            area = new JTextField("", 10);
                area.setEditable(false);
            circum = new JTextField("", 10);
                circum.setEditable(false);
        
            resPanel.add(rad);  //Adds everything to resPanel
            resPanel.add(radius);
            resPanel.add(circ);
            resPanel.add(circum);
            resPanel.add(ar);
            resPanel.add(area);
            
            calc = new JButton("Calculate");    //Declares Calc and Clear buttons and adds ActionListener
                calc.addActionListener(this);
            clear = new JButton("Clear");
                clear.addActionListener(this);
            resPanel.add(calc);         //Adds them to resPanel
            resPanel.add(clear);
        
        frame.add(drawPanel, BorderLayout.CENTER);
        frame.add(resPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    //This makes it so the program will close just this window
        frame.setLocationRelativeTo(null);                              
        frame.setVisible(true); 
    }
    public void Calc(){
        DecimalFormat f = new DecimalFormat("#.##"); //This is a new DecimalFormat so that the JTextFields will only have 2 decimal places
        try{
            r=Double.parseDouble(radius.getText());
        }
        catch(NumberFormatException num){
            JOptionPane.showMessageDialog(this, "Please enter a positive integer");
        }
        r=Math.abs(r);   //The Math.abs are to make sure negative values are not entered into the fields, to ensure proper drawing
        circum.setText("" + f.format(2*Math.PI*r)); //This sets the circumfrence
        area.setText("" + f.format(Math.PI * Math.pow(r, 2)));  //This sets the area
        drawPanel.repaint();        //This repaints the drawPanel
    }
    public void Clear(){    //This defaults all the fields and values
        r=0;
        radius.setText("");
        area.setText("");
        circum.setText("");
        drawPanel.repaint();        //This repaints the drawPanel
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){  //Switch statement for the buttons
            case("Calculate"):
                Calc();
                break;
            case("Clear"):
                Clear();
                break;
        }
    }
}
