
package bank.management.system1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree  extends JFrame implements ActionListener{
    
    JRadioButton savradio,Fixradio,currradio,Recradio;
    JCheckBox c1,c2,c3,c4,c5,c6,c7; 
    JButton b1,b2;
    String formno;
    SignupThree(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 3");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(20,1,100,100);
        add(label);
       
       //Creating the Label on the frame 
       JLabel l1=new JLabel("Page 3: Account Details");
       l1.setFont(new Font("Raleway",Font.BOLD,26));
       l1.setBounds(270,50,330,60);
       add(l1);
       JLabel l2=new JLabel("Account Type");
       l2.setFont(new Font("Raleway",Font.BOLD,23));
       l2.setBounds(80,130,200,40);
       add(l2);
       //Creating the Radio Buttons
       savradio =new JRadioButton("Saving Account");
       savradio.setBounds(85,180,200,20);
       savradio.setFont(new Font("Raleway",Font.BOLD,14));
       savradio.setBackground(Color.WHITE);
       add(savradio);
       currradio =new JRadioButton("Current Account");
       currradio.setBounds(85,220,200,20);
       currradio.setFont(new Font("Raleway",Font.BOLD,14));
       currradio.setBackground(Color.WHITE);
       add(currradio);
       Fixradio =new JRadioButton("Fixed Deposit Account");
       Fixradio.setBounds(400,180,400,20);
       Fixradio.setFont(new Font("Raleway",Font.BOLD,14));
       Fixradio.setBackground(Color.WHITE);
       add(Fixradio);
       Recradio =new JRadioButton("Recurring Deposit Account");
       Recradio.setBounds(400,220,400,20);
       Recradio.setFont(new Font("Raleway",Font.BOLD,14));
       Recradio.setBackground(Color.BLUE);
       add(Recradio);
       JLabel l3=new JLabel("Card Number");
       l3.setFont(new Font("Raleway",Font.BOLD,23));
       l3.setBounds(80,280,200,40);
       add(l3);
       JLabel num=new JLabel("XXXX-XXXX-XXXX-4156");
       num.setFont(new Font("Raleway",Font.BOLD,24));
       num.setBounds(370,280,350,50);
       add(num);
       JLabel l4=new JLabel("Your 16 Digit Card Number");
       l4.setBounds(80,318,280,20);
       add(l4);
       JLabel l5=new JLabel("PIN:");
       l5.setFont(new Font("Raleway",Font.BOLD,23));
       l5.setBounds(80,380,200,40);
       add(l5);
       JLabel pinnum=new JLabel("XXXX");
       pinnum.setFont(new Font("Raleway",Font.BOLD,24));
       pinnum.setBounds(370,380,200,50);
       add(pinnum);
       JLabel l6=new JLabel("Your 4 Digit Password");
       l6.setBounds(80,420,280,20);
       add(l6);
       JLabel l7=new JLabel("Services Required:");
       l7.setFont(new Font("Raleway",Font.BOLD,23));
       l7.setBounds(80,480,300,40);
       add(l7);
       c1=new JCheckBox("ATM CARD");
       c1.setFont(new Font("Raleway",Font.BOLD,16));
       c1.setBackground(Color.WHITE);
       c1.setBounds(82,540,200,30);
       add(c1);
       c2=new JCheckBox("Internet Banking");
       c2.setFont(new Font("Raleway",Font.BOLD,16));
       c2.setBackground(Color.WHITE);
       c2.setBounds(400,540,200,30);
       add(c2);
       c3=new JCheckBox("Mobile Banking");
       c3.setFont(new Font("Raleway",Font.BOLD,16));
       c3.setBackground(Color.WHITE);
       c3.setBounds(82,600,200,30);
       add(c3);
       c4=new JCheckBox("EMAIL & SMS Alerts");
       c4.setFont(new Font("Raleway",Font.BOLD,16));
       c4.setBackground(Color.WHITE);
       c4.setBounds(400,600,200,30);
       add(c4);
       c5=new JCheckBox("Cheque Book");
       c5.setFont(new Font("Raleway",Font.BOLD,16));
       c5.setBackground(Color.WHITE);
       c5.setBounds(82,660,250,30);
       add(c5);
       c6=new JCheckBox("E-Statement");
       c6.setFont(new Font("Raleway",Font.BOLD,16));
       c6.setBackground(Color.WHITE);
       c6.setBounds(400,660,300,30);
       add(c6);
       c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
       c7.setFont(new Font("Raleway",Font.BOLD,12));
       c7.setBackground(Color.WHITE);
       c7.setBounds(82,720,900,20);
       add(c7);
       //Creating the Buttons
       b1=new JButton("Submit");
       b1.setFont(new Font("Raleway",Font.BOLD,15));
       b1.setBackground(Color.WHITE);
       b1.setForeground(Color.BLACK);
       b1.setOpaque(true);
       b1.setBounds(240,760,100,20);
       b1.addActionListener(this);
       add(b1);
       b2=new JButton("Cancel");
       b2.setFont(new Font("Raleway",Font.BOLD,15));
       b2.setBackground(Color.WHITE);
       b2.setForeground(Color.BLACK);
       b2.setOpaque(true);
       b2.setBounds(450,760,100,20);
       b2.addActionListener(this);
       add(b2);
       //Creating the Frame 
       getContentPane().setBackground(Color.WHITE); 
       setSize(800,950);
       setLocation(330,50);
       setVisible(true);
      
     } 
      
    public void actionPerformed(ActionEvent se)
    {
    if(se.getSource() == b1)
      {
         String accounttype = null;
         if(savradio.isSelected()){
           accounttype="Saving Account";
         } 
         else if(Fixradio.isSelected()){
            accounttype="Fixed Deposit Account" ;
         }
         else if(currradio.isSelected()){
            accounttype="Current Account" ;
         }
         else if(Recradio.isSelected()){
             accounttype="Recurring Deposit Account" ;
         }
         //Generatin the Randomely Card Number 
         
         Random rand=new Random();
         String crdNo=""+Math.abs((rand.nextLong()%90000000L)+5040936000000000L); 
         String pinNo=""+Math.abs((rand.nextLong() % 9000L)+1000L);
         
         String facility=""; 
         if(c1.isSelected()){
           facility=facility + " ATM CARD";
         }
         else if(c2.isSelected()){
            facility=facility + " Internet Banking"; 
         }
         else if(c3.isSelected()){
            facility=facility + " Mobile Banking"; 
         }
         else if(c4.isSelected()){
            facility=facility + "EMAIL & SMS Alerts"; 
         }
         else if(c5.isSelected()){
            facility=facility + "Cheque Book"; 
         }
         else if(c6.isSelected()){
            facility=facility + " E-Statement"; 
         }
         
         try
         {
             //Validation
             if(accounttype.equals("")){
                 JOptionPane.showMessageDialog(null,"Account Type is Required");
             }
             Conn con=new Conn();
             String query1="insert into SignupThree values('"+formno+"', '"+accounttype+"', '"+crdNo+"', '"+pinNo+"', '"+facility+"')";
             String query2="insert into Login values('"+formno+"', '"+crdNo+"', '"+pinNo+"')";

             con.s.executeUpdate(query1);
             con.s.executeUpdate(query2);
             JOptionPane.showMessageDialog(null,"CardNo:"+crdNo+"\n Pin:" +pinNo);
             setVisible(false);
             new CashDeposite(pinNo).setVisible(true);
            }
         catch(Exception e)
         {
             System.out.println(e);
         }
      }  
        
    else if (se.getSource() == b2)
      {
          setVisible(false);
          new Login().setVisible(true);
      }   
    }
    
    
    public static void main(String[] args)
    {
        new SignupThree(" ");
    }
    
}
