
package bank.management.system1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    
    String pinnumber;
    JButton back;
    JLabel lab;
    BalanceEnquiry(String pinno)
    {
       this.pinnumber=pinno;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image); 
   
       //Buttons
       back =new JButton("Back");
       back.setBounds(420,520,100,25);
       back.addActionListener(this);
       image.add(back);
       // To Calculate the balance 
                Conn c=new Conn();
                int balance =0;
                try
                 {
                  ResultSet rs=c.s.executeQuery("Select * from bank where pinno='"+pinnumber+"'");
              
                  while(rs.next())
                   {
                  if(rs.getString("type").equals("Deposit"))
                      {
                    balance= balance +Integer.parseInt(rs.getString("amount"));
                            }
                   else
                     {
                        balance= balance -Integer.parseInt(rs.getString("amount"));
                         }
                   }//loop
                  lab=new JLabel("Your Current Account Balance="+balance);
                  lab.setForeground(Color.WHITE);
                  lab.setBounds(200,300,300,30);
                  image.add(lab);
                  setSize(900,900);
                  setLocation(300,0);
                   setVisible(true);
                }//try   
              catch(Exception e)
                {
                  System.out.println(e);    
                } 
}    
       public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==back)
            {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
            }
        }   
    
     public static void main(String[] args)
       {
        new BalanceEnquiry(" ");
      }
 }
