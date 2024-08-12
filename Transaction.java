
package bank.management.system1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton depst,fst,pin,Imt,cshw,mst,binq,ext;
    String pinno;
    Transaction(String pinno)
    {
       this.pinno=pinno;
       setLayout(null);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image); 
       
       JLabel text=new JLabel("Please Select your Transaction");
       text.setBounds(220,290,500,35);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,16));
       image.add(text);
       
       depst=new JButton("Cash Deposite");
       depst.setBackground(Color.WHITE);
       depst.setFont(new Font("Raleway",Font.BOLD,14));
       depst.setBounds(160,415,150,30);
       depst.addActionListener(this);
       image.add(depst);
       
       fst=new JButton("Fast Cash");
       fst.setBackground(Color.WHITE);
       fst.setFont(new Font("Raleway",Font.BOLD,14));
       fst.setBounds(160,450,150,30);
       fst.addActionListener(this);
       image.add(fst);
       
       pin=new JButton("Pin Change");
       pin.setBackground(Color.WHITE);
       pin.setFont(new Font("Raleway",Font.BOLD,14));
       pin.setBounds(160,485,150,30);
       pin.addActionListener(this);
       image.add(pin);
       
      
       cshw=new JButton("Cash Withdrawl");
       cshw.setBackground(Color.WHITE);
       cshw.setFont(new Font("Raleway",Font.BOLD,14));
       cshw.setBounds(340,415,150,30);
       cshw.addActionListener(this);
       image.add(cshw);
       
       mst=new JButton("Mini Statement");
       mst.setBackground(Color.WHITE);
       mst.setFont(new Font("Raleway",Font.BOLD,14));
       mst.setBounds(340,450,150,30);
       mst.addActionListener(this);
       image.add(mst);
       
       binq=new JButton("Balance Enquiry");
       binq.setBackground(Color.WHITE);
       binq.setFont(new Font("Raleway",Font.BOLD,14));
       binq.setBounds(340,485,150,30);
       binq.addActionListener(this);
       image.add(binq);
       
       ext=new JButton("Exit");
       ext.setBackground(Color.WHITE);
       ext.setFont(new Font("Raleway",Font.BOLD,14));
       ext.setBounds(285,525,90,30);
       ext.addActionListener(this);
       image.add(ext);
       
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);        
    }
    public  void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==ext){
          System.exit(0);
      }
      else if(ae.getSource()==depst){
        setVisible(false);
        new CashDeposite(pinno).setVisible(true);
      }
      else if(ae.getSource()==cshw){
          setVisible(false);
          new Withdrawl(pinno).setVisible(true);
      }
      else if(ae.getSource()==fst)
      {
          setVisible(false);
          new FastCash(pinno).setVisible(true);
       }
      else if(ae.getSource()==pin)
      {
          setVisible(false);
          new PinChange(pinno).setVisible(true);
       }
       else if(ae.getSource()==binq)
      {
          setVisible(false);
          new BalanceEnquiry(pinno).setVisible(true);
       }
       else if(ae.getSource()==mst)
       {
          new MiniStatement(pinno).setVisible(true);
       }
      
    } 
    public static void main(String[] args)
    {
        new Transaction(" ");
    }      
 }
