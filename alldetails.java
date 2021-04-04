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
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class alldetails extends JFrame implements ActionListener{

    DefaultTableModel model=new DefaultTableModel();
    JTable table;
    JScrollPane jsp;
    JLabel l1;
    JButton btn;
    
    public alldetails()
    {
        Font f1=new Font("ARIAL",Font.BOLD,14); 
        l1=new JLabel("Employee Details");
        add(l1).setBounds(20,20,180,25);
        l1.setFont(f1);
        l1.setForeground(Color.BLUE);
        
        table=new JTable(model){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        
        jsp=new JScrollPane(table,v,h);
        add(jsp).setBounds(20,60,900,350);

        table.getTableHeader().setReorderingAllowed(false);
        
        model.addColumn("S.No");
        model.addColumn("EmployeeId");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Address");
        model.addColumn("Gender");
        model.addColumn("Post");
        model.addColumn("DOB");
        model.addColumn("Phone");
        model.addColumn("Education");
        
        setLayout(null);
        setVisible(true);
        setSize(1000,750);
        setTitle("Employee Details");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        btn=new JButton("Back");
        add(btn).setBounds(20,420,100,25);
        btn.addActionListener(this);
        
        try {
            conn c1=new conn();
            ResultSet rs=c1.pstmt.executeQuery("Select * from addemployee");
            while(rs.next())
            {
                model.addRow(new Object[]{rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)});
            }
        } catch (Exception e) {
        }
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ex) {
        if(ex.getSource()==btn)
        {
            new details();
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
