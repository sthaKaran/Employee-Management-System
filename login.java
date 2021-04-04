package Employee;
/**
 *
 * @author KARAN
 */
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class login extends JFrame implements ActionListener{    
    JLabel username, password;
    JTextField txtusername;
    JPasswordField txtpassword;
    JButton login,reset;
    public login(){    
        username = new JLabel("Username:-");
        add(username).setBounds(50,20,100,20);
        txtusername = new JTextField();
        add(txtusername).setBounds(150,20,100,20);
        password = new JLabel("Password:-");
        add(password).setBounds(50,60,100,20);
        txtpassword = new JPasswordField();
        add(txtpassword).setBounds(150,60,100,20);
        login = new JButton("Login");
        add(login).setBounds(50,100,100,20);
        login.addActionListener(this);
        reset = new JButton("Reset");
        add(reset).setBounds(150,100,100,20);
        reset.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setTitle("Login");
        setSize(400,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==login)
        {
            
            if(txtusername.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Username must be filled");
                txtusername.requestFocus();
            }
            else if(txtpassword.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Password must be filled");
                txtpassword.requestFocus();
            }
            else{
                try {
                conn c1=new conn();
                String username = txtusername.getText();
                String password = txtpassword.getText();
                
                String query ="Select * from admin where username='"+username+"' and password='"+password+"'";
                
                ResultSet rs = c1.pstmt.executeQuery(query);
                if (rs.next()) {
                    new details();
                     dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    txtusername.setText("");
                    txtpassword.setText("");
                    txtusername.requestFocus();
                }
                
            } catch (Exception ex) {
            
            }
            }
        }
        if(e.getSource()==reset)
        {
            txtusername.setText("");
            txtpassword.setText("");
            txtusername.requestFocus();
            
        }
        
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
    }
    
}
