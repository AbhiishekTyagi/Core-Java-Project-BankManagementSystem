
package bank.management.system1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton depst,fst,pin,Imt,cshw,mst,binq,ext;
    String pinno;
    FastCash(String pinno)
    {
       this.pinno=pinno;
       setLayout(null);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image); 
       
       JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
       text.setBounds(220,290,500,35);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,16));
       image.add(text);
       
       depst=new JButton("₹100");
       depst.setBackground(Color.WHITE);
       depst.setFont(new Font("Raleway",Font.BOLD,14));
       depst.setBounds(160,415,150,30);
       depst.addActionListener(this);
       image.add(depst);
       
       fst=new JButton("₹500");
       fst.setBackground(Color.WHITE);
       fst.setFont(new Font("Raleway",Font.BOLD,14));
       fst.setBounds(160,450,150,30);
       fst.addActionListener(this);
       image.add(fst);
       
       pin=new JButton("₹1000");
       pin.setBackground(Color.WHITE);
       pin.setFont(new Font("Raleway",Font.BOLD,14));
       pin.setBounds(160,485,150,30);
       pin.addActionListener(this);
       image.add(pin);
       
       Imt=new JButton("₹2000");
       Imt.setBackground(Color.WHITE);
       Imt.setFont(new Font("Raleway",Font.BOLD,14));
       Imt.setBounds(340,415,150,30);
       Imt.addActionListener(this);
       image.add(Imt);
       
       cshw=new JButton("₹10000");
       cshw.setBackground(Color.WHITE);
       cshw.setFont(new Font("Raleway",Font.BOLD,14));
       cshw.setBounds(340,485,150,30);
       cshw.addActionListener(this);
       image.add(cshw);
       
       mst=new JButton("₹5000");
       mst.setBackground(Color.WHITE);
       mst.setFont(new Font("Raleway",Font.BOLD,14));
       mst.setBounds(340,450,150,30);
       mst.addActionListener(this);
       image.add(mst);
       
       ext=new JButton("Back");
       ext.setBackground(Color.WHITE);
       ext.setFont(new Font("Raleway",Font.BOLD,14));
       ext.setBounds(280,525,100,30);
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
          setVisible(false);
          new Transaction(pinno).setVisible(true);
      }
      else
      {
         String amount1=((JButton)ae.getSource()).getText().substring(1);//₹100
         Conn c=new Conn();
         try
         {
              ResultSet rs=c.s.executeQuery("Select * from bank where pinno='"+pinno+"'");
              int balance =0;
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
              }
              if(ae.getSource()!= ext && balance<Integer.parseInt(amount1))
              {
                  JOptionPane.showMessageDialog(null,"Insufficient Balance");
                  return;
              }
              else
              {
              Date date=new Date();
              String query="insert into bank values('"+pinno+"','"+date+"','Withdrawl','"+amount1+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"₹" +amount1+ "Debited Sucessfully");
              setVisible(false);
              new Transaction(pinno).setVisible(true);
              }  
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
      }
    }
    public static void main(String[] args)
    {
        new FastCash(" ");
    }      
    
}
