
package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JLabel text;
    JTextField amount;
    JButton depo,back;
    String pinno;
    
    Withdrawl(String pinno)
    {
        this.pinno=pinno;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        //Label code 
        text=new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,17));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        //TextField code
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        //Button first Coding 
        depo =new JButton("Withdraw");
        depo.setBounds(370,490,150,25);
        depo.addActionListener(this);
        image.add(depo);
        
        //Button second Coding 
        back=new JButton("Back");
        back.setBounds(370,525,150,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setVisible(true);
        setLocation(300,40); 
        
    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==depo){
            String num=amount.getText();
            Date date =new Date();
            if(num.equals("")){
             JOptionPane.showMessageDialog(null,"Please Enter the amount you want to Withdrawl");
            }
            else
            {
                try{
                 Conn c=new Conn();
                 String q1="insert into bank values('"+pinno+"','"+date+"','Withdrawl','"+num+"')";
                 c.s.executeUpdate(q1);
                 JOptionPane.showMessageDialog(null,"₹"+" "+num+" "+"Withdraw Successfully");
                 setVisible(false);
                 new Transaction(pinno).setVisible(true);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
             }  
            
        }
        else if(a.getSource()==back){
          setVisible(false);
          new Transaction(pinno).setVisible(true);
        } 
    }
    

       public static void main(String[] args)
          {
              new Withdrawl(" ");
           }
  }
