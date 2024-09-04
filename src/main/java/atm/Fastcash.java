package atm;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.sql.*;
import java.awt.event.*;


public class Fastcash extends JFrame implements ActionListener{
    JButton h,f,th,two,fiveth,ten,back;
    String pinno;
    Fastcash(String pinno){
        this.pinno=pinno;
        setLayout(null);
        ImageIcon i1=new ImageIcon("icons/atm.jpg");
        Image i=i1.getImage().getScaledInstance(900,770,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i);
        JLabel img=new JLabel(i2);
        img.setBounds(0,0,900,700);
        add(img);
        
        JLabel text =new JLabel("SELECT YOUR WITHDRAWL AMOUNT");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(190, 220,700, 35);
        img.add(text);
        
        h =new JButton("Rs 100");
        h.setBounds(155,325,150,25);
        img.add(h);
        h.addActionListener(this);
        
        th =new JButton("Rs 1000");
        th.setBounds(155,355,150,25);
        img.add(th);
        th.addActionListener(this);
        
        f =new JButton("Rs 500");
        f.setBounds(365,325,150,25);
        img.add(f);
        f.addActionListener(this);
        
        two =new JButton("Rs 2000");
        two.setBounds(365,355,150,25);
        img.add(two);
        two.addActionListener(this);
        
        fiveth  =new JButton("Rs 5000");
        fiveth.setBounds(155,385,150,25);
        img.add(fiveth);
        fiveth.addActionListener(this);
        
        ten  =new JButton("Rs 10000");
        ten.setBounds(365,385,150,25);
        img.add(ten);
        ten.addActionListener(this);
        
        back  =new JButton("Back");
        back.setBounds(365,415,150,20);
        img.add(back);
        back.addActionListener(this);
        
        
        setSize(900,900);
        setLocation(200,0);
        setUndecorated(true);
         setVisible(true);
    }
       
    public void actionPerformed(ActionEvent ae){
            if (ae.getSource()==back){
                setVisible(false);
                new Transaction(pinno).setVisible(true);
            }
            else{
                String amount = ((JButton)ae.getSource()).getText().substring(3);
                Conn c = new Conn();
                try{
                    ResultSet rs =c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
                    int bal=0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            bal+=Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            bal-=Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (bal<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    }
                    else{
                        Date date= new Date();
                        String q="insert into bank values('" +pinno+ "', '" +date+ "', 'Withdrawl','" +amount+ "')";
                        c.s.executeUpdate(q);
                        JOptionPane.showMessageDialog(null,"Withdrawn succesfully");
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
            }
            
        }
    public static void main(String[] args) {
        new Fastcash("");
    }
    
    
}
