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
import java.sql.*;
public class delete extends JFrame implements ActionListener{

    JLabel lbl1,lbl2,lbl3,lbl4,l5,l6,l7;
    JTextField t;
    JButton btn1,btn2,b1,b2;
    public delete()
    {
        lbl1=new JLabel("EmployeeId:");
        add(lbl1).setBounds(80,40,100,20);
        
        t=new JTextField();
        add(t).setBounds(180,40,100,20);
        
        btn1=new JButton("Delete");
        add(btn1).setBounds(100,80,100,20);
        btn1.addActionListener(this);
        
        btn2=new JButton("Cancel");
        add(btn2).setBounds(220,80,100,20);
        btn2.addActionListener(this);
        
        lbl2=new JLabel("Name");
        add(lbl2).setBounds(50,150,100,20);
        lbl2.setVisible(false);
        
        lbl3=new JLabel("Phone");
        add(lbl3).setBounds(50,190,100,20);
        lbl3.setVisible(false);
        
        lbl4=new JLabel("Email");
        add(lbl4).setBounds(50,230,100,20);
        lbl4.setVisible(false);
        
        l5=new JLabel();
        add(l5).setBounds(150,150,100,20);
        
        
        l6=new JLabel();
        add(l6).setBounds(150,190,100,20);
        
        
        l7=new JLabel();
        add(l7).setBounds(150,230,100,20);
        
        b1=new JButton("Delete");
        add(b1).setBounds(100,270,100,20);
        b1.addActionListener(this);
        b1.setVisible(false);
        
        b2=new JButton("Cancel");
        add(b2).setBounds(220,270,100,20);
        b2.addActionListener(this);
        b2.setVisible(false);
        
        setLayout(null);
        setVisible(true);
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1)
        {
            try {
                conn c1=new conn();
                String query="Select fullname,phone,email from addemployee where employeeid='"+t.getText()+"'";
                ResultSet rs=c1.pstmt.executeQuery(query);
                
                int i=0;
                if(rs.next())
                {
                    String name=rs.getString(1);
                    String phone=rs.getString(2);
                    String email=rs.getString(3);
                    
                    lbl2.setVisible(true);
                    lbl3.setVisible(true);
                    lbl4.setVisible(true);
                    b1.setVisible(true);
                    b2.setVisible(true);
                    i=1;
                    l5.setText(name);
                    l6.setText(phone);
                    l7.setText(email);
                    btn1.setVisible(false);
                    btn2.setVisible(false);
                    
                }
                if(i==0){
                    JOptionPane.showMessageDialog(null,"ID not found");
                    t.setText("");
                    t.requestFocus();
                }
            } catch (Exception ex) {
            }
        }
        if(e.getSource()==b1)
        {
            try {
                conn c1=new conn();
                String query="Delete from addemployee where employeeid='"+t.getText()+"'";
                c1.pstmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Record deleted successfully");
                dispose();
                new details();
            } catch (Exception ex) {
            }
        }
        if(e.getSource()==btn2){
            dispose();
            new details();
        }
        if(e.getSource()==b2)
        {
            dispose();
            new delete();
        }
        
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
    }
    
}
