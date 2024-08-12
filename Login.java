
package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton butt,butt1,butt2;
    JTextField ctext;
    JPasswordField ptext;
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE"); 
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(50,10,100,100);
        add(label);
        JLabel label1=new JLabel("Welcome to ATM");
        label1.setFont(new Font("osward",Font.BOLD,35));
        label1.setBounds(180,45,400,35);
        add(label1);
        JLabel label2=new JLabel("Card No:");
        label2.setFont(new Font("Railway",Font.BOLD,25));
        label2.setBounds(100,150,150,40);
        add(label2);
        ctext=new JTextField();
        ctext.setBounds(250,155,220,30);
        ctext.setFont(new Font("Arial",Font.BOLD,14));
        add(ctext);
        JLabel label3=new JLabel("PIN:");
        label3.setFont(new Font("Railway",Font.BOLD,25));
        label3.setBounds(100,220,200,40);
        add(label3);
        ptext=new JPasswordField();
        ptext.setBounds(250,220,220,30);
        ptext.setFont(new Font("Arial",Font.BOLD,14));
        add(ptext);
        butt=new JButton("SIGN IN");
        butt.setBounds(250,300,80,30);
        butt.setBackground(Color.WHITE);
        butt.setForeground(Color.RED);
        butt.addActionListener(this);
        butt.setOpaque(true);
        add(butt);
        butt1=new JButton("CLEAR");
        butt1.setBounds(360,300,80,30);
        butt1.setBackground(Color.WHITE);
        butt1.setForeground(Color.RED);
        butt1.addActionListener(this);
        butt1.setOpaque(true);
        add(butt1);
        butt2=new JButton("SIGN UP");
        butt2.setBounds(250,350,190,30);
        butt2.setBackground(Color.WHITE);
        butt2.setForeground(Color.RED);
        butt2.addActionListener(this);
        butt2.setOpaque(true);
        add(butt2);
        getContentPane().setBackground(Color.white);
        setSize(700,500);
        setVisible(true);
        setLocation(370,200);
      
    }
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==butt){
       Conn conn=new Conn();
       String crdno=ctext.getText();
       String pinno=ptext.getText();
       
       //Fetching the data from the Table Login.
       String query="Select * from Login where CardNo='"+crdno+"' and PinNo='"+pinno+"'";
       try{
           ResultSet rs=conn.s.executeQuery(query);
           if(rs.next()){
               setVisible(false);
               new Transaction(pinno).setVisible(true);
           }
           else{
               JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
           }
       }
       catch(Exception e){
           System.out.println(e);
       }
      } 
      else if(ae.getSource() ==butt1){
        ctext.setText("");
        ptext.setText("");
        }
      else if(ae.getSource()==butt2){
          setVisible(false);
          new SignupOne().setVisible(true);
      }
          
    } 
    
    public static void main(String[] args)
    {
        new Login();
      }   
    
}
