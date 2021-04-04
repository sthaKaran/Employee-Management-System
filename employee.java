package Employee;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
public class employee extends JFrame implements ActionListener {
        JLabel lblemployeeid,lblname,lblemail,lbladdress,lblgender,lblpost,lbldob,lblphone,lbleductaion;
        JTextField txtemployeeid,txtname,txtemail,txtaddress,txtpost,txtdob,txtphone,txteducation;
        JRadioButton rbmale,rbfemale;
        ButtonGroup bg;
        JButton btnsubmit,btncancel,btnback;
    public employee()
    {
        Font f1=new Font("ARIAL",Font.BOLD,12);
        lblemployeeid = new JLabel("EmployeeId:");
        add(lblemployeeid).setBounds(20,20,100,20);
        lblemployeeid.setFont(f1);
        txtemployeeid =new JTextField();
        add(txtemployeeid).setBounds(120,20,100,20);
        lblname = new JLabel("FullName:");
        add(lblname).setBounds(20,60,100,20);
        lblname.setFont(f1);
        txtname =new JTextField();
        add(txtname).setBounds(120,60,100,20);
        lblemail = new JLabel("Email:");
        add(lblemail).setBounds(20,100,100,20);
        lblemail.setFont(f1);
        txtemail =new JTextField();
        add(txtemail).setBounds(120,100,100,20);
        lbladdress = new JLabel("Address:");
        add(lbladdress).setBounds(20,140,100,20);
        lbladdress.setFont(f1);
        txtaddress =new JTextField();
        add(txtaddress).setBounds(120,140,100,20);
        lblgender =new JLabel("Gender:");
        add(lblgender).setBounds(20,180,100,20);
        lblgender.setFont(f1);
        rbmale = new JRadioButton("Male");
        add(rbmale).setBounds(120,180,100,20);
        rbfemale =new JRadioButton("Female");
        add(rbfemale).setBounds(220,180,100,20);
        bg =new ButtonGroup();
        bg.add(rbmale); bg.add(rbfemale);
        lblpost =new JLabel("Post");
        add(lblpost).setBounds(20,220,100,20);
        lblpost.setFont(f1);
        txtpost =new JTextField();
        add(txtpost).setBounds(120,220,100,20);
        lbldob=new JLabel("DateOfBirth");
        add(lbldob).setBounds(20,260,100,20);
        lbldob.setFont(f1);
        txtdob=new JTextField();
        add(txtdob).setBounds(120,260,100,20);
        lblphone =new JLabel("Phone");
        add(lblphone).setBounds(20,300,100,20);
        lblphone.setFont(f1);
        txtphone =new JTextField();
        add(txtphone).setBounds(120,300,100,20);
        lbleductaion =new JLabel("Education");
        add(lbleductaion).setBounds(20,340,100,20);
        lbleductaion.setFont(f1);
        txteducation=new JTextField();
        add(txteducation).setBounds(120,340,100,20);
        btnsubmit =new JButton("Submit");
        add(btnsubmit).setBounds(20,380,100,20);
        btnsubmit.addActionListener(this);
        btncancel=new JButton("Cancel");
        add(btncancel).setBounds(150,380,100,20);
        btncancel.addActionListener(this);
        btnback =new JButton("Back");
        add(btnback).setBounds(20,420,240,20);
        btnback.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setTitle("Add Employee");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnsubmit)
        {
            if(txtemployeeid.getText().equals("")||txtname.getText().equals("")||txtaddress.getText().equals("")||txtdob.getText().equals("")||txteducation.getText().equals("")||txtemail.getText().equals("")||txtphone.getText().equals("")||txtpost.getText().equals("")||bg.isSelected(null))
            {
                JOptionPane.showMessageDialog(null,"Any field must not be empty!");
            }
            else
            {
                try {
                    conn c1 =new conn();
                    String eid=txtemployeeid.getText();
                    String name=txtname.getText();
                    String email=txtemail.getText();
                    String address = txtaddress.getText();
                    String gender=null;
                    if(rbmale.isSelected()){
                        gender="Male";
                    }
                    else if(rbfemale.isSelected())
                    {
                        gender="Female";
                    }
                    String post=txtpost.getText();
                    String dob=txtdob.getText();
                    String phone=txtphone.getText();
                    String education=txteducation.getText();
                    String query="insert into addemployee values(null,'"+eid+"','"+name+"','"+email+"','"+address+"','"+gender+"','"+post+"','"+dob+"','"+phone+"','"+education+"')";
                    int x=c1.pstmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Employee Added Successfully");
                    dispose();
                    new details();
                    }
                catch (SQLException | HeadlessException ex) {
                }
            }
        }
        if(e.getSource()==btncancel)
        {
            txtemployeeid.setText("");
            txtname.setText("");
            txtemail.setText("");
            txtaddress.setText("");
            bg.clearSelection();
            txtpost.setText("");
            txtdob.setText("");
            txtphone.setText("");
            txteducation.setText("");
            txtemployeeid.requestFocus();
        }
        if(e.getSource()==btnback)
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
