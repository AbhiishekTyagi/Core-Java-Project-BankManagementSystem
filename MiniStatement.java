
package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.String;

public class MiniStatement extends JFrame {
    
    String pinnumber;
    JLabel bank,card,mini,balance;
    MiniStatement(String pinno)
    {
       this.pinnumber=pinno;
       setTitle("MiniStatement");
       setLayout(null);
       
       setBounds(0,0,900,900);
       setSize(400,600);
       setLocation(30,30);
       getContentPane().setBackground(Color.WHITE);
       setVisible(true);
        
        //Label
        mini=new JLabel();
        mini.setBounds(20,100,400,300);
        add(mini);   
        bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        balance=new JLabel();
        balance.setBounds(20,400,350,20);
        add(balance);
        
     try
     {
       Conn c=new Conn();
       ResultSet rs=c.s.executeQuery("Select * from login where pinno = '"+pinnumber+"'");
       while(rs.next())
              {
                card.setText("Card Number="+rs.getString("CardNo").substring(0,4)+ "********" + rs.getString("CardNo").substring(12));  
               }
      }
     catch(Exception e)
     {
         System.out.println(e);
     }
      try
      {
        Conn c=new Conn();
        int bal=0;
        ResultSet rs=c.s.executeQuery("Select * from bank where pinno= '"+pinnumber+"'");
        while(rs.next())
        {
          mini.setText(mini.getText() + "<html>" + rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+ "<br><br><html>");  
          if(rs.getString("type").equals("Deposit"))
             {
                bal= bal +Integer.parseInt(rs.getString("amount"));
             }
          else
                {
                    bal= bal -Integer.parseInt(rs.getString("amount"));
                }
        }
        balance.setText("Your Current Account Balanace in Rs="+bal);
      }
       catch(Exception e)
       {
           System.out.println(e);
       }
        
    }
    public static void main(String ...args)
    {
        new MiniStatement("");
    }
   
    
}
