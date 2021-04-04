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
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class update extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    JButton btn1,btn2;
    String id_emp;
    
    public update(String emp_id)
    {
        id_emp=emp_id;
        
        Font f=new Font("Arial",Font.BOLD,14);
        l10=new JLabel("Update Employee Details");
        add(l10).setBounds(20,20,200,20);
        l10.setFont(f);
        
        l1=new JLabel("EmployeeID:");
        add(l1).setBounds(40,60,100,20);
        
        t1=new JTextField();
        add(t1).setBounds(140,60,100,20);
        
        l2=new JLabel("FullName:");
        add(l2).setBounds(40,100,100,20);
        
        t2=new JTextField();
        add(t2).setBounds(140,100,100,20);
        
        l3=new JLabel("Email:");
        add(l3).setBounds(40,140,100,20);
        
        t3=new JTextField();
        add(t3).setBounds(140,140,100,20);
        
        l4=new JLabel("Address:");
        add(l4).setBounds(40,180,100,20);
        
        t4=new JTextField();
        add(t4).setBounds(140,180,100,20);
        
        l5=new JLabel("Gender:");
        add(l5).setBounds(40,220,100,20);
        
        t5=new JTextField();
        add(t5).setBounds(140,220,100,20);
        
        l6=new JLabel("Post:");
        add(l6).setBounds(40,260,100,20);
        
        t6=new JTextField();
        add(t6).setBounds(140,260,100,20);
        
        l7=new JLabel("DOB:");
        add(l7).setBounds(40,300,100,20);
        
        t7=new JTextField();
        add(t7).setBounds(140,300,100,20);
        
        l8=new JLabel("Phone:");
        add(l8).setBounds(40,340,100,20);
        
        t8=new JTextField();
        add(t8).setBounds(140,340,100,20);
        
        l9=new JLabel("Education:");
        add(l9).setBounds(40,380,100,20);
        
        t9=new JTextField();
        add(t9).setBounds(140,380,100,20);
        
        btn1=new JButton("Update");
        add(btn1).setBounds(40,420,100,20);
        btn1.addActionListener(this);
        
        btn2=new JButton("Cancel");
        add(btn2).setBounds(160,420,100,20);
        btn2.addActionListener(this);
        
        
        
        
        setLayout(null);
        setVisible(true);
        setSize(500,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        showdate(emp_id);
        
    }
    
    int i=0;
    
    void showdate(String s)
    {
        try {
            conn c1=new conn();
            String query="Select * from addemployee where employeeid='"+s+"'";
            ResultSet rs=c1.pstmt.executeQuery(query);
            
            if(rs.next())
            {
                setVisible(true);
                i=1;
                t1.setText(rs.getString(2));
                t2.setText(rs.getString(3));
                t3.setText(rs.getString(4));
                t4.setText(rs.getString(5));
                t5.setText(rs.getString(6));
                t6.setText(rs.getString(7));
                t7.setText(rs.getString(8));
                t8.setText(rs.getString(9));
                t9.setText(rs.getString(10));
            }
            if(i==0)
            {
                JOptionPane.showMessageDialog(null, "Id not found");
                dispose();
               new searchupdate();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btn1)
            {
                try {
                    conn c1=new conn();
                    String eid =t1.getText();
                    String name=t2.getText();
                    String email=t3.getText();
                    String address=t4.getText();
                    String gender=t5.getText();
                    String post=t6.getText();
                    String dob=t7.getText();
                    String phone=t8.getText();
                    String education=t9.getText();
                    
                    String query="update addemployee set employeeid='"+eid+"',fullname='"+name+"',email='"+email+"',address='"+address+"',gender='"+gender+"',post='"+post+"',dob='"+dob+"',phone='"+phone+"',education='"+education+"' where employeeid='"+id_emp+"'";
                    c1.pstmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Successfully Updated!!!");
                    dispose();
                    new searchupdate();
                } catch (Exception ex) {
                }
            }
            if(e.getSource()==btn2)
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
