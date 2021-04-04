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
import java.awt.*;
public class details extends JFrame implements ActionListener{
    
        JButton add,view,remove,update,alldetails;
        JLabel lbl1, background;
    public details()
    {
//        ImageIcon img = new ImageIcon("C:\\Users\\lenovo\\OneDrive\\Documents\\NetBeansProjects\\EmployeeManagementSystem\\src\\Employee\\background.jpg");
//        background = new JLabel("",img,JLabel.CENTER);
//        background.setBounds(0,0,970,450);
//        add(background);
        
        add = new JButton("ADD");
        add(add).setBounds(250,60,100,20);
        add.addActionListener(this);
        
        view = new JButton("VIEW");
        add(view).setBounds(400,60,100,20);
        view.addActionListener(this);
        
        
        remove = new JButton("REMOVE");
        add(remove).setBounds(250,100,100,20);
        remove.addActionListener(this);
        
        
        update = new JButton("UPDTAE");
        add(update).setBounds(400,100,100,20);
        update.addActionListener(this);
        
        alldetails=new JButton("AllDetails");
        add(alldetails).setBounds(250,140,250,20);
        alldetails.addActionListener(this);
        
        
        
        
        setLayout(null);
        setVisible(true);
        setTitle("Employee Details");
        setSize(720,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==add)
        {
         new employee();
            dispose();
        }
        
        if(e.getSource()==view)
        {
            new view();
            dispose();
        }
        
        if(e.getSource()==remove)
        {
            new delete();
            dispose();
        }
        
        if(e.getSource()==update)
        {
            new searchupdate();
            dispose();
        }
        if(e.getSource()==alldetails)
        {
            new alldetails();
            dispose();
        }
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
   }
    
}
