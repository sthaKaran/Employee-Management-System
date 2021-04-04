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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class MainScreen extends JFrame implements ActionListener {
   
    JLabel l1,l2,l3;
    String sysdate,systime;
    JButton btn1;
    
    public MainScreen(){
        
        Font f1=new Font("ARIAL",Font.BOLD,14);        
        l1=new JLabel("Employee Management System");
        add(l1).setBounds(10,10,300,25);
        l1.setForeground(Color.BLUE);
        l1.setFont(f1);
        
        Calendar cal=Calendar.getInstance();
        String day=" "+cal.get(Calendar.DATE);
        int x=cal.get(Calendar.MONTH);
        String month=" "+(x+1);
        String year=" "+cal.get(Calendar.YEAR);
        sysdate=day+"/"+month+"/"+year;
        l2=new JLabel("Date:-"+sysdate);
        add(l2).setBounds(250,50,100,20);
        
        String hr=""+cal.get(Calendar.HOUR_OF_DAY);
        String min=""+cal.get(Calendar.MINUTE);
        systime=hr+":"+min;
        l3=new JLabel("Time:-"+systime);
        add(l3).setBounds(250,80,100,20);
        
        
        btn1=new JButton("Click Here To Continue");
        add(btn1).setBounds(120,150,150,20);
        btn1.addActionListener(this);
        
     
        setLayout(null);
        setVisible(true);
        setTitle("HomePage");
        setSize(400,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            new login();
            dispose();
        }
        
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        new MainScreen();
    }
}