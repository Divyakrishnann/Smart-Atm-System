package atm;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinno;
    BalanceEnquiry(String pinno){
        setLayout(null);
        this.pinno = pinno;
        ImageIcon i = new ImageIcon("icons/atm.jpg");
        Image i1 = i.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel image = new JLabel (i2);
        image.setBounds(0,0,900,700);
        add(image);
        
        back =  new JButton("Back");
        back.setBounds(355,390,145,30);
        back.addActionListener(this);
        image.add(back);
        Conn c = new Conn();
        int bal = 0;
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
            while(rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal-= Integer.parseInt(rs.getString("Amount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        JLabel l1 = new JLabel ("Your Current Account balance is Rs "+bal);
        l1.setBounds(210,200,500,200);
        l1.setForeground(Color.WHITE);
        image.add(l1);
        
        setSize(900,900);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== back){
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
    
}
