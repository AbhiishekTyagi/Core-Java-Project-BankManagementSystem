
package bank.management.system1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class PinChange extends JFrame implements ActionListener{
    
    
    JLabel text,pintext,repintext;
    JPasswordField pin,repin;
    JButton chg,bck;
    String pinnumber;
    PinChange(String pinnumber)
    {
        this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image); 
       setSize(900,900);
       setSize(900,900);
      // setUndecorated(true);
       setLocation(300,0);
       setVisible(true);
       text=new JLabel("Change YOUR PIN");
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,17));
       text.setBounds(250,280,400,20);
       image.add(text);
       
       pintext=new JLabel("New Pin:");
       pintext.setForeground(Color.WHITE);
       pintext.setFont(new Font("System",Font.BOLD,17));
       pintext.setBounds(170,340,200,20);
       image.add(pintext);
       
       pin=new JPasswordField();
       pin.setFont(new Font("Raleway",Font.BOLD,22));
       pin.setBounds(290,340,200,20);
       image.add(pin);
       
       repintext=new JLabel("ReEnter Pin:");
       repintext.setForeground(Color.WHITE);
       repintext.setFont(new Font("System",Font.BOLD,17));
       repintext.setBounds(170,390,200,20);
       image.add(repintext);
       
       repin=new JPasswordField();
       repin.setFont(new Font("Raleway",Font.BOLD,22));
       repin.setBounds(290,390,200,20);
       image.add(repin);
       
       bck =new JButton("Back");
       bck.setBounds(420,520,100,25);
       bck.addActionListener(this);
       image.add(bck);
        
       chg =new JButton("Change");
       chg.setBounds(420,485,100,25);
       chg.addActionListener(this);
       image.add(chg);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
       
        if(ae.getSource()==chg)
        {
            try
            {
                String npin=pin.getText();
                String rpin=repin.getText();
                
                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null,"Entered Pin does not match");
                    return;
                }
                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please Enter New Pin");
                    return;
                }
                if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please Re-Enter Pin");
                    return;
                }
                Conn c=new Conn();
                String q1="update bank set pinNo='"+npin+"' where pinNo='"+pinnumber+"'";
                
                String q2="update Login set pinNo='"+npin+"' where pinNo='"+pinnumber+"'";

                String q3="update Signupthree set pinNo='"+npin+"' where pinNo='"+pinnumber+"'";
                //Execute this all three query
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);
                JOptionPane.showMessageDialog(null,"PIN Change Successfully");
                setVisible(false);
                new Transaction(npin).setVisible(true);
              }
              
           catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if (ae.getSource()==bck)
                 {
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                    }
    }
    
    public static void main(String[] args)
    {
        new PinChange(" ").setVisible(true);
    }
    
}
