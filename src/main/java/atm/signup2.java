package atm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class signup2 extends JFrame  implements ActionListener{
    JTextField pan,aadhar;
    JButton next;
    JComboBox religion,cat,inc,edu,occ;
    JRadioButton syes,sno,eyes,eno;
    String formno;
    
    signup2(String formno){
        this.formno=formno; 
        setLayout(null);
        
        JLabel personldetails = new JLabel("Page 2: Additional Details");
        personldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personldetails.setBounds(220,50,400,30);
        add(personldetails);

        JLabel rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway",Font.BOLD,15));
        rel.setBounds(100,140,100,30);
        add(rel);

        String valReligion[] ={"Hindu","Muslim","Sikh","Christian","Other"};
        religion =new JComboBox(valReligion);
        religion.setBounds(250,140,300,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,15));
        category.setBounds(100,180,200,30);
        add(category);

        String valcategory[] ={"General","OBC","SC","ST","Other"};
        cat =new JComboBox(valcategory);
        cat.setBounds(250,140,300,30);
        cat.setBackground(Color.WHITE);
        add(cat);
        cat.setBounds(250,180,300,30);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,15));
        income.setBounds(100,220,200,30);
        add(income);

        String incomecategory[] ={"Null","< 2,50,000","< 5,00,000","upto 10,00,000"};
        inc =new JComboBox(incomecategory);
        inc.setBackground(Color.WHITE);
        inc.setBounds(250,220,300,30);
        add(inc);

        JLabel educ = new JLabel("Education");
        educ.setFont(new Font("Raleway",Font.BOLD,15));
        educ.setBounds(100,260,200,30);
        add(educ);
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,15));
        email.setBounds(100,280,200,30);
        add(email);

        String educategory[] ={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        edu  =new JComboBox(educategory);
        edu.setBackground(Color.WHITE);
        edu.setBounds(250,280,300,30);
        add(edu);
        
        JLabel O = new JLabel("Occupation:");
        O.setFont(new Font("Raleway",Font.BOLD,15));
        O.setBounds(100,340,200,30);
        add(O);
        
        String occcategory[] ={"Salaried","Self-Employed","Business","Student","Retired","Other"};
        occ  =new JComboBox(occcategory);
        occ.setBackground(Color.WHITE);
        occ.setBounds(250,340,300,30);
        add(occ);
        
        JLabel panno = new JLabel("PAN number:");
        panno.setFont(new Font("Raleway",Font.BOLD,15));
        panno.setBounds(100,380,200,30);
        add(panno);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,15));
        pan.setBounds(250,380,300,30);
        add(pan);

        JLabel adharno = new JLabel("Aadhar Number:");
        adharno.setFont(new Font("Raleway",Font.BOLD,15));
        adharno.setBounds(100,420,200,30);
        add(adharno);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,15));
        aadhar.setBounds(250,420,300,30);
        add(aadhar);

        JLabel cit = new JLabel("Senior Citizen:");
        cit.setFont(new Font("Raleway",Font.BOLD,15));
        cit.setBounds(100,460,200,30);
        add(cit);

        syes = new JRadioButton("Yes");
        syes.setFont(new Font("Raleway",Font.BOLD,15));
        syes.setBounds(250,460,100,30);
        syes.setBackground(Color.LIGHT_GRAY);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setFont(new Font("Raleway",Font.BOLD,15));
        sno.setBounds(350,460,100,30);
        sno.setBackground(Color.LIGHT_GRAY);
        add(sno);
        
        ButtonGroup sen = new ButtonGroup();
        sen.add(syes);
        sen.add(sno);

        JLabel pin= new JLabel("Existing Account:");
        pin.setFont(new Font("Raleway",Font.BOLD,15));
        pin.setBounds(100,500,200,30);
        add(pin);
        
        eyes = new JRadioButton("Yes");
        eyes.setFont(new Font("Raleway",Font.BOLD,15));
        eyes.setBounds(250,500,100,30);
        eyes.setBackground(Color.LIGHT_GRAY);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setFont(new Font("Raleway",Font.BOLD,15));
        eno.setBounds(350,500,100,30);
        eno.setBackground(Color.LIGHT_GRAY);
        add(eno);
        
        ButtonGroup exist = new ButtonGroup();
        exist.add(eyes);
        exist.add(eno);
       
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
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String sreligion =(String)religion.getSelectedItem() ;
        String scat  =(String)cat.getSelectedItem();
        String sincome  =(String)inc.getSelectedItem();
        String sedu  =(String)edu.getSelectedItem();
        String socc  =(String)occ.getSelectedItem();
        String span  =pan.getText();
        String saadhar  =aadhar.getText();
        String scitizen = null;
        if (syes.isSelected()){ 
            scitizen = "YES";
        }
        else if(sno.isSelected()){
            scitizen = "NO";
        }
        String sexist = null;
        if (eyes.isSelected()){ 
            sexist = "YES";
        }
        else if (eno.isSelected()){
           sexist = "NO";
        } 
        try{
                if(saadhar.equals("")){
                    JOptionPane.showMessageDialog(null,"Aadhar is required");  
                }
                Conn c = new Conn();
                String query = "insert into signup2 values('"+formno+"', '"+sreligion+"', '"+scat+"', '"+sincome+"', '"+sedu+"', '"+socc+"', '"+span+"', '"+saadhar+"', '"+scitizen+"', '"+sexist+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signup3(formno).setVisible(true);
                
         
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
          signup2 s = new  signup2("");
    }
}