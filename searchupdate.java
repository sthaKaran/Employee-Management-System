/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

/**
 *
 * @author KARAN
 */
import javax.swing.*;
import java.awt.event.*;
public class searchupdate extends JFrame implements ActionListener {
    
    JLabel lbl1;
    JTextField t;
    JButton b1,b2;
    
    public searchupdate(){
        
        lbl1=new JLabel("EmployeeId");
        add(lbl1).setBounds(80,20,100,20);
        
        t=new JTextField();
        add(t).setBounds(180,20,100,20);
        
        b1=new JButton("Submit");
        add(b1).setBounds(60,80,100,20);
        b1.addActionListener(this);
        
        b2=new JButton("Cancel");
        add(b2).setBounds(180,80,100,20);
        b2.addActionListener(this);
        
        
        
        
        setLayout(null);
        setVisible(true);
        setSize(300,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==b1)
        {
            dispose();
            update up=new update(t.getText());
        }
        if(e.getSource()==b2)
        {
            dispose();
            new details();
        }
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
}
    
}
