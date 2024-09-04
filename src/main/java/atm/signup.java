package atm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class signup extends JFrame implements ActionListener{
    long random;
    JDateChooser dobtext;
    JTextField nametext,ftext,etext,atext,ctext,stext,ptext;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    
    signup(){
        setLayout(null);
        Random ran = new Random();
        random =Math.abs((ran.nextLong() % 9000L)+1000L);
        JLabel formno = new JLabel("APPLICATION NO :"+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(150,20,600,40);
        add(formno);

        JLabel personldetails = new JLabel("Page 1: Personal Details");
        personldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personldetails.setBounds(220,80,400,30);
        add(personldetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,15));
        name.setBounds(100,140,100,30);
        add(name);

        nametext = new JTextField();
        nametext.setFont(new Font("Raleway",Font.BOLD,15));
        nametext.setBounds(250,140,300,30);
        add(nametext);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,15));
        fname.setBounds(100,180,200,30);
        add(fname);

        ftext = new JTextField();
        ftext.setFont(new Font("Raleway",Font.BOLD,15));
        ftext.setBounds(250,180,300,30);
        add(ftext);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setBounds(100,220,200,30);
        add(dob);

        dobtext = new JDateChooser();
        dobtext.setFont(new Font("Raleway",Font.BOLD,15));
        dobtext.setBounds(250,220,300,30);
        add(dobtext);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setBounds(100,260,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBackground(Color.lightGray);
        male.setBounds(250,260,100,30);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBackground(Color.lightGray);
        female.setBounds(350,260,150,30);
        add(female);
        
        ButtonGroup gen = new ButtonGroup();
        gen.add(male);
        gen.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,15));
        email.setBounds(100,300,200,30);
        add(email);

        etext = new JTextField();
        etext.setFont(new Font("Raleway",Font.BOLD,15));
        etext.setBounds(250,300,300,30);
        add(etext);
        
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,15));
        marital.setBounds(100,340,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBackground(Color.lightGray);
        married.setBounds(250,340,100,30);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(Color.lightGray);
        unmarried.setBounds(350,340,100,30);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBackground(Color.lightGray);
        other.setBounds(460,340,150,30);
        add(other);
        
        ButtonGroup mar = new ButtonGroup();
        mar.add(married);
        mar.add(unmarried);
        mar.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,15));
        address.setBounds(100,380,200,30);
        add(address);

        atext = new JTextField();
        atext.setFont(new Font("Raleway",Font.BOLD,15));
        atext.setBounds(250,380,300,30);
        add(atext);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,15));
        city.setBounds(100,420,200,30);
        add(city);

        ctext = new JTextField();
        ctext.setFont(new Font("Raleway",Font.BOLD,15));
        ctext.setBounds(250,420,300,30);
        add(ctext);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,15));
        state.setBounds(100,460,200,30);
        add(state);

        stext = new JTextField();
        stext.setFont(new Font("Raleway",Font.BOLD,15));
        stext.setBounds(250,460,300,30);
        add(stext);

        JLabel pin= new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway",Font.BOLD,15));
        pin.setBounds(100,500,200,30);
        add(pin);

        ptext = new JTextField();
        ptext.setFont(new Font("Raleway",Font.BOLD,15));
        ptext.setBounds(250,500,300,30);
        add(ptext);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(470,560,80,30);
        add(next);
        next.addActionListener(this);
        
        setSize(750,650);
        setLocation(200,10);
        getContentPane().setBackground(Color.lightGray);
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 1");
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name =nametext.getText() ;
        String fname  =ftext.getText();
        String dob  =((JTextField)dobtext.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){ 
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        String email =etext.getText();
        String marital = null;
        if (married.isSelected()){ 
            marital = "married";
        }
        else if(unmarried.isSelected()){
           marital = "unmarried";
        } 
        else if(other.isSelected()){
           marital = "Other";
        } 
        String address  =atext.getText();
        String city  =ctext.getText();
        String state  =stext.getText();
        String pin  =ptext.getText();
        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else if (fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's Name is Required");
            }
            else if (dob.equals("")){
                JOptionPane.showMessageDialog(null,"DOB is Required");
            }
            else if (email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required");
            }
            else if (address .equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required");
            }
            else if (city .equals("")){
                JOptionPane.showMessageDialog(null,"City is Required");
            }
            else if (state .equals("")){
                JOptionPane.showMessageDialog(null,"State is Required");
            }
            else if (pin .equals("")){
                JOptionPane.showMessageDialog(null,"Pin is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signup2(formno).setVisible(true);
            }
         
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
          signup s = new  signup();
    }
}
