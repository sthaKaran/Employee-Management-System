package Employee;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class print_data extends JFrame implements ActionListener{
    JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,lbl13,lbl14,lbl15,lbl16,lbl17,lbl18,lbl19;
    String emp_id,name,email,address,gender,post,dob,phone,education;
    JButton btn;
    public print_data(String e_id)
    {
        try {
            conn c1=new conn();
            String query="Select * from addemployee where employeeid='"+e_id+"'";
            ResultSet rs=c1.pstmt.executeQuery(query);
            while(rs.next())
            {
                emp_id=rs.getString("employeeid");
                name=rs.getString("fullname");
                email=rs.getString("email");
                address=rs.getString("address");
                gender=rs.getString("gender");
                post=rs.getString("post");
                dob=rs.getString("dob");
                phone=rs.getString("phone");
                education=rs.getString("education");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        lbl1=new JLabel("Employee Detail");
        add(lbl1).setBounds(200,20,100,20);
        lbl2=new JLabel("EmployeeId:");
        add(lbl2).setBounds(20,60,100,20);
        lbl3=new JLabel(emp_id);
        add(lbl3).setBounds(120,60,100,20);
        lbl4=new JLabel("FullName:");
        add(lbl4).setBounds(20,100,100,20);
        lbl5=new JLabel(name);
        add(lbl5).setBounds(120,100,100,20);
        lbl6=new JLabel("Email:");
        add(lbl6).setBounds(20,140,100,20);
        lbl7=new JLabel(email);
        add(lbl7).setBounds(120,140,100,20);
        lbl8=new JLabel("Address:");
        add(lbl8).setBounds(20,180,100,20);
        lbl9=new JLabel(address);
        add(lbl9).setBounds(120,180,100,20);
        lbl10=new JLabel("Gender:");
        add(lbl10).setBounds(20,220,100,20);
        lbl11=new JLabel(gender);
        add(lbl11).setBounds(120,220,100,20);
        lbl12=new JLabel("Post:");
        add(lbl12).setBounds(20,260,100,20);
        lbl13=new JLabel(post);
        add(lbl13).setBounds(120,260,100,20);
        lbl14=new JLabel("DOB");
        add(lbl14).setBounds(20,300,100,20);
        lbl15=new JLabel(dob);
        add(lbl15).setBounds(120,300,100,20);
        lbl16=new JLabel("Phone");
        add(lbl16).setBounds(20,340,100,20);
        lbl17=new JLabel(phone);
        add(lbl17).setBounds(120,340,100,20);
        lbl18=new JLabel("Education");
        add(lbl18).setBounds(20,380,100,20);
        lbl19=new JLabel(education);
        add(lbl19).setBounds(120,380,100,20);
        btn=new JButton("Cancel");
        add(btn).setBounds(100,420,100,20);
        btn.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn)
        {
            dispose();
            new view();
        }
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
    }
}
