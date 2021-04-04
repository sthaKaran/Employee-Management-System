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
import java.awt.event.*;
import javax.swing.*;
public class view extends JFrame implements ActionListener{

    JLabel l1;
    JTextField t;
    JButton btn1,btn2;
    
    public view()
    {  
        
        l1=new JLabel("EmployeeId");
        add(l1).setBounds(20,20,100,20);
        
        t=new JTextField();
        add(t).setBounds(120,20,100,20);
        
        btn1=new JButton("Search");
        add(btn1).setBounds(60,70,100,20);
        btn1.addActionListener(this);
        
        btn2=new JButton("Cancel");
        add(btn2).setBounds(160,70,100,20);
        btn2.addActionListener(this);
        
        setLayout(null);
        setVisible(true);
        setSize(300,150);
        setTitle("View Employee");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1)
        {
            dispose();
            print_data p=new print_data(t.getText());
        }
        if(e.getSource()==btn2)
        {
            dispose();
            new details();
        }
    }
    
}
