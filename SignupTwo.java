
package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{
  
    JTextField pantext,adhartext;
    JRadioButton yesradio,noradio,yesradio1,noradio1;
    JComboBox creligion,oc,Incom,Jcate,ed;
    JButton next;
    String formno;
    SignupTwo( String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(20,1,100,100);
        add(label);
        
        JLabel personDetails=new JLabel("Page 2: Addditional Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        religion.setBounds(80,140,100,30);
        add(religion);
        
        
        //Array of String
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        creligion=new JComboBox(valReligion);
        creligion.setBounds(310,140,370,30);
        add(creligion);
        
        JLabel cate =new JLabel("Category:");
        cate.setFont(new Font("Raleway",Font.BOLD,22));
        cate.setBounds(80,190,200,30);
        add(cate);
        
        //Array of String
        String Jcat[]={"General","OBC","SC","ST","Other"};
        Jcate=new JComboBox(Jcat);
        Jcate.setBounds(310,190,370,30);
        add(Jcate);
        
        
        JLabel Inco=new JLabel("Income:");
        Inco.setFont(new Font("Raleway",Font.BOLD,22));
        Inco.setBounds(80,240,400,30);
        add(Inco);
        
        //Array of String
        String inc[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        Incom=new JComboBox(inc);
        Incom.setBounds(310,240,370,30);
        add(Incom);
        
        
        JLabel edu=new JLabel("Educational");
        edu.setFont(new Font("Raleway",Font.BOLD,22));
        edu.setBounds(80,290,300,30);
        add(edu);
        
       
        JLabel qua=new JLabel("Qualification:");
        qua.setFont(new Font("Raleway",Font.BOLD,22));
        qua.setBounds(80,320,150,30);
        add(qua);
        
        //Array of String
        String qual[]={"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
        ed=new JComboBox(qual);
        ed.setBounds(310,310,370,30);
        add(ed);
        
       
        JLabel occu=new JLabel("Occupation:");
        occu.setFont(new Font("Raleway",Font.BOLD,22));
        occu.setBounds(80,390,300,30);
        add(occu);
        
        //Array of String
        String occ[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        oc=new JComboBox(occ);
        oc.setBounds(310,390,370,30);
        add(oc);
        

        JLabel Pan=new JLabel("PAN Number:");
        Pan.setFont(new Font("Raleway",Font.BOLD,22));
        Pan.setBounds(80,440,250,30);
        add(Pan);
        
        pantext=new JTextField();
        pantext.setFont(new Font("Raleway",Font.BOLD,14));
        pantext.setBounds(310,440,370,30);
        add(pantext);
        
        
        JLabel adno=new JLabel("Aadhar Number:");
        adno.setFont(new Font("Raleway",Font.BOLD,22));
        adno.setBounds(80,490,200,30);
        add(adno);
        
        adhartext=new JTextField();
        adhartext.setFont(new Font("Raleway",Font.BOLD,14));
        adhartext.setBounds(310,490,370,30);
        add(adhartext);
        
      
        JLabel senciti=new JLabel("Senior Citizen:");
        senciti.setFont(new Font("Raleway",Font.BOLD,22));
        senciti.setBounds(80,540,200,30);
        add(senciti);
        
        yesradio =new JRadioButton("Yes");
        yesradio.setBounds(310,540,100,30);
        add(yesradio);
       
        noradio =new JRadioButton("NO");
        noradio.setBounds(500,540,100,30);
        add(noradio);
        
        
        JLabel exacc=new JLabel("Exisiting Account:");
        exacc.setFont(new Font("Raleway",Font.BOLD,22));
        exacc.setBounds(80,590,200,30);
        add(exacc);
        
        
        yesradio1 =new JRadioButton("Yes");
        yesradio1.setBounds(310,590,100,30);
        add(yesradio1);
       
        noradio1 =new JRadioButton("NO");
        noradio1.setBounds(500,590,100,30);
        add(noradio1);
        
       
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
      
      String srel=(String) creligion.getSelectedItem();
      String scat =(String) Jcate.getSelectedItem();
      String sincom =(String) Incom.getSelectedItem();
      String sed=(String) ed.getSelectedItem();
      String socc=(String) oc.getSelectedItem();
      String seniorcitizens=null;
      if(yesradio.isSelected())
      {
          seniorcitizens="Yes";
      } 
      else if(noradio.isSelected())
      {
          seniorcitizens="NO";
      } 
      String Exisiting=null;
      if(yesradio1.isSelected())
      {
         Exisiting="Yes";
      }
      else if(noradio1.isSelected())
      {
          Exisiting="No";
      }
      String sadhartext=adhartext.getText();
      String spantext=pantext.getText();
        try{
           Conn c=new Conn();
           String query="insert into signupTwo values('"+formno+"', '"+srel+"', '"+scat+"', '"+sincom+"', '"+sed+"', '"+socc+"', '"+seniorcitizens+"','"+Exisiting+"', '"+sadhartext+"','"+spantext+"')";
           //Execute the query
           c.s.executeUpdate(query);
           //Signup3 object
           setVisible(false);
           new SignupThree(formno).setVisible(true);
         }   
      catch(Exception e)
      {
          System.out.println(e);
      }
    }
  public static void main(String [] args)
    {
         new SignupTwo(" "); 
    }
    
}

