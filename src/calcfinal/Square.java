// File name: Square.java
// Written by: Kyle Marcoux
// Description:  This program allows users to calculate the perimeter and area of a square given a side
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

public class Square extends JFrame implements ActionListener{
    //Declares variables
    private final JFrame frame;
    private final JPanel drawPanel, resPanel;
    private final JLabel hgt, wth, ar, per;
    private final JTextField height, width, area, perim;
    private final JButton calc, clear;
    public double h, w;
    
    public Square(){
        frame = new JFrame("Square utility");    //Sets up JFrame
        frame.setSize(500,500);
        
        drawPanel = new JPanel(){   //Sets up drawPanel
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawRect(1, 1, (int)w, (int)h);
        }
        };
        
        resPanel = new JPanel(new GridLayout(5,2)); //Sets up resPanel with GridLayout
        resPanel.setBorder(BorderFactory.createTitledBorder("Input values here, measured in pixels"));
            hgt = new JLabel("The Height is: ");    //Declares JLabels
            wth = new JLabel("The Width is: ");
            per = new JLabel("Perimeter: ");
            ar = new JLabel("Area: ");
        
            height = new JTextField("", 10);    //Declares JTextFields
            width = new JTextField("", 10);
            area = new JTextField("", 10);
                area.setEditable(false);
            perim = new JTextField("", 10);
                perim.setEditable(false);

            resPanel.add(wth);  //Adds everything to resPanel
            resPanel.add(width);        
            resPanel.add(hgt);
            resPanel.add(height);
            resPanel.add(per);
            resPanel.add(perim);
            resPanel.add(ar);
            resPanel.add(area);
                
            calc = new JButton("Calculate");    //Declares Calc and Clear buttons and adds ActionListener
                calc.addActionListener(this);
            clear = new JButton("Clear");
                clear.addActionListener(this);
            resPanel.add(calc);         //Adds them to resPanel
            resPanel.add(clear);
            
        frame.add(resPanel, BorderLayout.SOUTH);
        frame.add(drawPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    //This makes it so the program will close just this window
        frame.setLocationRelativeTo(null);                              
        frame.setVisible(true); 
    }
    public void Calc(){ //Calc features a try block to ensure real integers are entered into the fields
        try{
            w=Double.parseDouble(width.getText());
            h=Double.parseDouble(height.getText());
        }
        catch(NumberFormatException num){
            JOptionPane.showMessageDialog(this, "Please enter a positive integer");
        }
        w=Math.abs(w);  //These Math.abs are to make sure negative values are not entered into the fields, to ensure proper drawing
        h=Math.abs(h);
        perim.setText("" + (2*h+2*w));  //This sets the perimeter
        area.setText("" + w*h);         //This sets the area
        drawPanel.repaint();        //This repaints the drawPanel
    }
    public void Clear(){    //This defaults all the fields and values
        w=0;
        h=0;
        width.setText("");
        height.setText("");
        area.setText("");
        perim.setText("");
        drawPanel.repaint();
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
