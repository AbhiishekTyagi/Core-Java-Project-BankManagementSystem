
package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField namtext,ftext,etext,atext,ctext,pintext,stext;
    JDateChooser datechooser;
    JRadioButton male,fmale,unmarr,marr,oth;
    JButton next;
    SignupOne()
    {
        setLayout(null);
        Random ran=new Random();
        random=Math.abs(ran.nextLong()%9000L+100L);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(20,1,100,100);
        add(label);
        
        JLabel formno=new JLabel("APPLICATION FORM NO."+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personDetails=new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(80,140,100,30);
        add(name);
        
        namtext=new JTextField();
        namtext.setFont(new Font("Raleway",Font.BOLD,14));
        namtext.setBounds(310,140,370,30);
        add(namtext);
        
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(80,190,200,30);
        add(fname);
        
        ftext=new JTextField();
        ftext.setFont(new Font("Raleway",Font.BOLD,14));
        ftext.setBounds(310,190,370,30);
        add(ftext);
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(80,240,400,30);
        add(dob);
        
        datechooser=new JDateChooser();
        datechooser.setBounds(310,240,370,30);
        datechooser.setForeground(Color.BLUE);
        add(datechooser);
        
        JLabel gen=new JLabel("Gender:");
        gen.setFont(new Font("Raleway",Font.BOLD,22));
        gen.setBounds(80,290,100,30);
        add(gen);
        
        male=new JRadioButton("Male");
        male.setBounds(310,290,100,30);
        add(male);
        
        fmale=new JRadioButton("Female");
        fmale.setBounds(450,290,100,30);
        add(fmale);
        
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(80,340,300,30);
        add(email);
        
        etext=new JTextField();
        etext.setFont(new Font("Raleway",Font.BOLD,14));
        etext.setBounds(310,340,370,30);
        add(etext);
        
        JLabel martial=new JLabel("Marital Status:");
        martial.setFont(new Font("Raleway",Font.BOLD,22));
        martial.setBounds(80,390,250,30);
        add(martial);
        
        marr=new JRadioButton("Married");
        marr.setBounds(310,390,100,30);
        add(marr);
        unmarr=new JRadioButton("Unmarried");
        unmarr.setBounds(420,390,100,30);
        add(unmarr);
        
        oth=new JRadioButton("Other");
        oth.setBounds(550,390,100,30);
        add(oth);
        
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(80,440,200,30);
        add(address);
        
        atext=new JTextField();
        atext.setFont(new Font("Raleway",Font.BOLD,14));
        atext.setBounds(310,440,370,30);
        add(atext);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(80,490,100,30);
        add(city);
        
        ctext=new JTextField();
        ctext.setFont(new Font("Raleway",Font.BOLD,14));
        ctext.setBounds(310,490,370,30);
        add(ctext);
        
        JLabel pin=new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(80,540,150,30);
        add(pin);
        
        pintext=new JTextField();
        pintext.setFont(new Font("Raleway",Font.BOLD,14));
        pintext.setBounds(310,540,370,30);
        add(pintext);
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(80,590,100,30);
        add(state);
        
        stext=new JTextField();
        stext.setFont(new Font("Raleway",Font.BOLD,14));
        stext.setBounds(310,590,370,30);
        add(stext);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(580,680,100,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true); 
  }     
       
    public void actionPerformed(ActionEvent ae)
    {
      String formno=""+random;//long
      String name=namtext.getText();
      String fname=ftext.getText();
      String dob=((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
      String gender=null;
      if(male.isSelected())
      {
          gender="Male";
      } 
      else if(fmale.isSelected())
      {
          gender="Female";
      } 
      String marital=null;
      if(marr.isSelected())
      {
          marital="Married";
      }
      else if(unmarr.isSelected())
      {
          marital="Unmarried";
      }
      else if(oth.isSelected())
      {
          marital="Other";
      }
      String email=etext.getText();
      String address=atext.getText();
      String City=ctext.getText();
      String state=stext.getText();
      String Pin=pintext.getText();
      try
      { //Validation
         if(name.equals(""))
         {
             JOptionPane.showMessageDialog(null,"Name is required");
         }
         else if(fname.equals(""))
         {
            JOptionPane.showMessageDialog(null,"Father Name is required"); 
         }
         else if(dob.equals(""))
         {
           JOptionPane.showMessageDialog(null,"Date of Birth is required"); 
         }
         else
         {
           Conn c=new Conn();
           String query="insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+marital+"', '"+email+"', '"+address+"', '"+City+"', '"+state+"', '"+Pin+"')";
           //Execute the query
           c.s.executeUpdate(query);
           setVisible(false);
           new SignupTwo(formno).setVisible(true);
         }   
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
    }
  public static void main(String [] args)
    {
         new SignupOne(); 
    }
    
}
