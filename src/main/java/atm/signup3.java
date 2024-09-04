package atm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class signup3 extends JFrame implements ActionListener{
//    JTextField pan,aadhar; implements ActionListener
//    JButton next;
//    JComboBox religion,cat,inc,edu,occ;
    JRadioButton sa,fda,ca,rda;
    JCheckBox atm,mob,internet,email,cheq,estate,declare;
    String formno;
    JButton submit,cancel;
    
    signup3(String formno){
        this.formno=formno; 
        setLayout(null);
        
        JLabel personldetails = new JLabel("Page 3: Account Details");
        personldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personldetails.setBounds(220,50,600,30);
        add(personldetails);
        
        JLabel acc = new JLabel("Account Type:");
        acc.setFont(new Font("Raleway",Font.BOLD,20));
        acc.setBounds(100,120,600,30);
        add(acc);
        
        sa = new JRadioButton("Saving Account");
        sa.setFont(new Font("Raleway",Font.BOLD,15));
        sa.setBounds(120,160,200,25);
        sa.setBackground(Color.LIGHT_GRAY);
        add(sa);
        
        fda = new JRadioButton("Fixed Deposit Account");
        fda.setFont(new Font("Raleway",Font.BOLD,15));
        fda.setBounds(400,160,400,25);
        fda.setBackground(Color.LIGHT_GRAY);
        add(fda);
        
        ca = new JRadioButton("Current Account");
        ca.setFont(new Font("Raleway",Font.BOLD,15));
        ca.setBounds(120,200,200,25);
        ca.setBackground(Color.LIGHT_GRAY);
        add(ca);
        
        rda = new JRadioButton("Recurring Deposit Account");
        rda.setFont(new Font("Raleway",Font.BOLD,15));
        rda.setBounds(400,200,400,25);
        rda.setBackground(Color.LIGHT_GRAY);
        add(rda);
        
        ButtonGroup account = new ButtonGroup();
        account.add(sa);
        account.add(ca);
        account.add(fda);
        account.add(rda);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100,230,200,30);
        add(card);
        JLabel cardd = new JLabel("Your 16 Digit Card Number");
        cardd.setFont(new Font("Raleway",Font.BOLD,10));
        cardd.setBounds(100,260,600,10);
        add(cardd);
        
        JLabel cardno = new JLabel("XXXX-XXXX-XXXX-4184");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(250,230,600,30);
        add(cardno);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,300,600,30);
        add(pin);
        JLabel pinn = new JLabel("Your 4 Digit Password");
        pinn.setFont(new Font("Raleway",Font.BOLD,10));
        pinn.setBounds(100,330,600,10);
        add(pinn);
        
        JLabel pinno = new JLabel("XXXX");
        pinno.setFont(new Font("Raleway",Font.BOLD,20));
        pinno.setBounds(250,300,600,30);
        add(pinno);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,20));
        services.setBounds(100,370,400,30);
        add(services);
        
        atm = new JCheckBox("ATM CARD");
        atm.setFont(new Font("Raleway",Font.BOLD,13));
        atm.setBounds(110,400,200,25);
        atm.setBackground(Color.LIGHT_GRAY);
        add(atm);
        
        mob = new JCheckBox("Mobile Banking");
        mob.setFont(new Font("Raleway",Font.BOLD,15));
        mob.setBounds(110,440,200,25);
        mob.setBackground(Color.LIGHT_GRAY);
        add(mob);
        
        cheq = new JCheckBox("Cheque Book");
        cheq.setFont(new Font("Raleway",Font.BOLD,15));
        cheq.setBounds(110,480,200,25);
        cheq.setBackground(Color.LIGHT_GRAY);
        add(cheq);
        
        internet = new JCheckBox("Internet Banking");
        internet.setFont(new Font("Raleway",Font.BOLD,15));
        internet.setBounds(400,400,200,25);
        internet.setBackground(Color.LIGHT_GRAY);
        add(internet);
        
        email = new JCheckBox("EMAIL & SMS Alerts");
        email.setFont(new Font("Raleway",Font.BOLD,15));
        email.setBounds(400,440,200,25);
        email.setBackground(Color.LIGHT_GRAY);
        add(email);
        
        estate = new JCheckBox("E-Statement");
        estate.setFont(new Font("Raleway",Font.BOLD,15));
        estate.setBounds(400,480,200,25);
        estate.setBackground(Color.LIGHT_GRAY);
        add(estate);
        
        declare = new JCheckBox("I hereby declare that the above filled details are correct.");
        declare.setFont(new Font("Raleway",Font.BOLD,12));
        declare.setBounds(95,560,600,20);
        declare.setBackground(Color.LIGHT_GRAY);
        add(declare);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,15));
        submit.setBounds(250,590,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,15));
        cancel.setBounds(400,590,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(750,680);
        setLocation(200,10);
        getContentPane().setBackground(Color.lightGray);
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 3");
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
            String acctype=null;
            if (sa.isSelected()){ 
              acctype = "Saving Account";
            }
            else if(fda.isSelected()){
                acctype = "Fixed Deposit Account";
            } 
            else if(ca.isSelected()){
                acctype = "Current Account";
            }
            else if(rda.isSelected()){
                acctype = "Recurring Deposit Account";
            } 
            
            Random random = new Random();
            String cardnum =""+  Math.abs((random.nextLong() % 90000000L) +5040936000000000L);
            String pinno = ""+Math.abs((random.nextLong()%9000L)+ 1000L);
            String facility="";
            if (atm.isSelected()){ 
              facility=""+ "ATM CARD";
            }
            if(mob.isSelected()){
                facility=""+ "Mobile Banking";
            } 
            if(cheq.isSelected()){
                facility=""+ "Cheque Book";
            }
            if(internet.isSelected()){
                facility=""+ "Internet Banking";
            }
            if (email.isSelected()){ 
              facility=""+ "EMAIL & SMS Alerts";
            }
            if(estate.isSelected()){
                facility=""+ "E-Statement";
            }       
            try{
                if (acctype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is required");
                }
                else {
                    Conn c = new Conn();
                    String query = "insert into signup3 values('"+formno+"', '"+acctype+"', '"+cardnum+"', '"+pinno+"', '"+facility+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Card number: "+cardnum+"\n"+"Pin no: "+pinno
                    );
                    String query1="insert into login values('"+formno+"', '"+cardnum+"', '"+pinno+"')";
                    c.s.executeUpdate(query1);
                    setVisible(false);
                    new Deposit(pinno).setVisible(true);
                }  
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }
    public static void main(String[] args) {
          signup3 s = new  signup3("");
    }
}